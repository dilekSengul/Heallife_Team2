package pages;

import StepDefinitions.Hooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverManager;
import utilities.JSUtilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertTrue;

public class AdminDashboardPage {

    public AdminDashboardPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(AdminDashboardPage.class);
    WebDriver driver = Hooks.getDriver();

    @FindBy(xpath = "//a [@class='sidebar-toggle']")
    public WebElement sidebarIcon;
    @FindBy(xpath = "//span [text()=' Dashboard']")
    public WebElement dashboardText;

    @FindBy(xpath = "//li[@class='treeview ']")
    public List<WebElement> sideBarTitleElementList;
    @FindBy(xpath = "//i [@class='fas fa-cogs']")
    public WebElement setupIcon;

    // Dashboardaki TPA Management Link
    @FindBy(xpath = "(//*[@class='treeview '])[13]")
    public WebElement tpaManagementLink;

    // TPA Management Page Baslık
    @FindBy(xpath = " //*[@class='box-title titlefix']")
    public WebElement tpaManagementPageTitle;

    public void clickSidebarIconIfDashboardNotVisible() {
        driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {

            if (!dashboardText.isDisplayed()) {

                sidebarIcon.click();

            } else {
                System.out.println("Dashboad paneli gorunuyor");
            }
        } catch (NoSuchElementException e) {
        }
    }

    public void validateMenuItems(WebDriver driver, List<String> expectedMenuItems) {
        // Gerçek menü başlıklarını bulun
        JSUtilities.scrollToElement(driver, setupIcon);
        List<WebElement> menuItems = driver.findElements(By.cssSelector(".sidebar-menu li a span"));
        List<String> actualMenuItems = new ArrayList<>();

        // Menü öğelerini toplama
        for (WebElement item : menuItems) {
            String menuText = item.getText().trim();
            if (!menuText.isEmpty()) {
                actualMenuItems.add(menuText);
                // Başlıkları konsola yazdır
                System.out.println("- " + menuText);
            }
        }

        // Beklenen başlıkların gerçek başlıklarda mevcut olduğunu doğrula
        for (String expected : expectedMenuItems) {
            assertTrue("Başlık bulunamadı: " + expected, actualMenuItems.contains(expected));
        }

        System.out.println("Tüm menü başlıkları başarıyla doğrulandı.");
    }

    // Dashboard menü başlıkları

    @FindBy (xpath = "//span[normalize-space()='Dashboard']")
    public WebElement DashboardMenu;

    @FindBy (xpath = "//span[normalize-space()='Billing']")
    public WebElement BillingMenu;

    @FindBy (xpath = "//span[normalize-space()='Appointment']")
    public WebElement AppointmentMenu;

    @FindBy (xpath = "//span[normalize-space()='OPD']")
    public WebElement OPDMenu;

    @FindBy (xpath = "//span[normalize-space()='IPD']")
    public WebElement IPDMenu;

    @FindBy (xpath = "//span[normalize-space()='Pharmacy']")
    public WebElement PharmacyMenu;

    @FindBy (xpath = "//span[normalize-space()='Pathology']")
    public WebElement PathologyMenu;

    @FindBy (xpath = "//span[normalize-space()='Radiology']")
    public WebElement RadiologyMenu;

    @FindBy (xpath = "//span[normalize-space()='Blood Bank']")
    public WebElement BloodBankMenu;

    @FindBy (xpath = "//span[normalize-space()='Ambulance']")
    public WebElement AmbulanceMenu;

    @FindBy (xpath = "//span[normalize-space()='Birth & Death Record']")
    public WebElement BirthDeathRecordMenu;

    @FindBy (xpath = "//a[normalize-space()='Birth Record']")
    public WebElement BirthRecordMenu;

    @FindBy (xpath = "//a[normalize-space()='Death Record']")
    public WebElement DeathRecordMenu;

    @FindBy (xpath = "//span[normalize-space()='Human Resource']")
    public WebElement HumanResourceMenu;

    @FindBy (xpath = "//span[normalize-space()='TPA Management']")
    public WebElement TPAManagementMenu;

    @FindBy (xpath = "//span[normalize-space()='Messaging']")
    public WebElement MessagingMenu;

    @FindBy (xpath = "//span[normalize-space()='Live Consultation']")
    public WebElement LiveConsultationMenu;

    @FindBy (xpath = "//a[@href='https://qa.heallifehospital.com/admin/zoom_conference/consult']")
    public WebElement LiveConsultationMenu2;

    @FindBy (xpath = "//a[normalize-space()='Live Meeting']")
    public WebElement LiveMeetingMenu;

    @FindBy (xpath = "//span[normalize-space()='Setup']")
    public WebElement SetupMenu;

    @FindBy (xpath = "//a[@href='https://qa.heallifehospital.com/admin/onlineappointment/']")
    public WebElement SetupAppointmentMenu;

    @FindBy (xpath = "//a[normalize-space()='Symptoms']")
    public WebElement SetupSymptomsMenu;

    @FindBy (xpath = "//a[@href='https://qa.heallifehospital.com/admin/bloodbank/products']")
    public WebElement SetupBloodBankMenu;

    @FindBy (xpath = "//a[@href='https://qa.heallifehospital.com/admin/lab/addlab']")
    public WebElement SetupRadiologyMenu;

    @FindBy (xpath = "//a[@href='https://qa.heallifehospital.com/admin/pathologycategory/addcategory']")
    public WebElement SetupPathologyMenu;

    @FindBy (xpath = "//a[@href='https://qa.heallifehospital.com/admin/medicinecategory/index']")
    public WebElement SetupPharmacyMenu;

    @FindBy (xpath = "//a[normalize-space()='Print Header Footer']")
    public WebElement SetupPrintHeaderFooterMenu;

    @FindBy (xpath = "//a[normalize-space()='Bed']")
    public WebElement SetupBedMenu;

    @FindBy (xpath = "//a[normalize-space()='Hospital Charges']")
    public WebElement SetupHospitalChargesMenu;

    @FindBy (xpath = "//a[normalize-space()='Patient']")
    public WebElement SetupPatientMenu;

    // Dashboard menü iconları

    @FindBy (xpath = "//i[@class='fas fa-television']")
    public WebElement DashboardIcon;

    @FindBy (xpath = "//i[@class='fas fa-file-invoice']")
    public WebElement BillingIcon;

    @FindBy (xpath = "(//i[@class='fa fa-calendar-check-o'])[2]")
    public WebElement AppointmentIcon;

    @FindBy (xpath = "(//i[@class='fas fa-stethoscope'])[1]")
    public WebElement OPDIcon;

    @FindBy (xpath = "//i[@class='fas fa-procedures']")
    public WebElement IPDIcon;

    @FindBy (xpath = "//i[@class='fas fa-mortar-pestle']")
    public WebElement PharmacyIcon;

    @FindBy (xpath = "(//i[@class='fas fa-flask'])[1]")
    public WebElement PathologyIcon;

    @FindBy (xpath = "(//i[@class='fas fa-microscope'])[1]")
    public WebElement RadiologyIcon;

    @FindBy (xpath = "(//i[@class='fas fa-tint'])[1]")
    public WebElement BloodBankIcon;

    @FindBy (xpath = "//i[@class='fas fa-ambulance']")
    public WebElement AmbulanceIcon;

    @FindBy (xpath = "//i[@class='fa fa-birthday-cake']")
    public WebElement BirthDeathRecordIcon;

    @FindBy (xpath = "//i[@class='fas fa-sitemap']")
    public WebElement HumanResourceIcon;

    @FindBy (xpath = "//i[@class='fas fa-umbrella']")
    public WebElement TPAManagementIcon;

    @FindBy (xpath = "//i[@class='fas fa-bullhorn']")
    public WebElement MessagingIcon;

    @FindBy (xpath = "//i[@class='fa fa-video-camera ftlayer']")
    public WebElement LiveConsultationIcon;

    @FindBy (xpath = "//i[@class='fas fa-cogs']")
    public WebElement SetupIcon;

    // Hamburger menü

    @FindBy (xpath = "//a[@role='button']")
    public WebElement HamburgerMenu;

    @FindBy (xpath = "//*[@class='fas fa-microscope']")
    public WebElement radiologyButton;

}