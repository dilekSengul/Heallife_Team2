package pages;

import StepDefinitions.Hooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverManager;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class AdminDashboardPage {

    public AdminDashboardPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
        this.driver = Hooks.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private static final Logger logger = LogManager.getLogger(AdminDashboardPage.class);
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait;

    @FindBy(xpath = "//a [@class='sidebar-toggle']")
    public WebElement sidebarIcon;
    @FindBy(xpath = "//span [text()=' Dashboard']")
    public WebElement dashboardText;

    @FindBy(xpath = "//li[@class='treeview ']")
    public List<WebElement> sideBarTitleElementList;
    @FindBy(xpath = "//i [@class='fas fa-cogs']")
    public WebElement setupIcon;

    // ------------ Dashboardaki TPA Management Test--------------
    @FindBy(xpath = "(//*[@class='treeview '])[13]")
    public WebElement tpaManagementLink;
    // TPA Management Page Baslık
    @FindBy(xpath = " //*[@class='box-title titlefix']")
    public WebElement tpaManagementPageTitle;
    // Name sütunu
    @FindBy(xpath = "(//*[@class='sorting'])[1]")
    public WebElement nameButton;
    // Code sütunu
    @FindBy(xpath = "(//*[@class='sorting'])[2]")
    public WebElement codeButton;
    // Phone sütunu
    @FindBy(xpath = "(//*[@class='sorting'])[3]")
    public WebElement phoneButton;
    // Address sütunu
    @FindBy(xpath = "(//*[@class='sorting'])[4]")
    public WebElement addressButton;
    // Contact Person Name sütunu
    @FindBy(xpath = "(//*[@class='sorting'])[5]")
    public WebElement contactPersonNameButton;
    // Contact Person Phone sütunu
    @FindBy(xpath = "//*[@class='text-right dt-body-right sorting_disabled']")
    public WebElement contactPersonPhoneButton;
    // Search Box
    @FindBy(xpath = "//*[@type='search']")
    public WebElement searchBox;
    // Kayıt sayısını değiştirme seçenekleri
    @FindBy(xpath = "//*[@name='DataTables_Table_0_length']")
    public WebElement allYuzButton;
    @FindBy(xpath = "//*[@name='DataTables_Table_0_length']")
    public WebElement yuzButton;
    // TPA Yönetim Listesi sıralama başlıkları-Columns
    @FindBy(xpath = "//tr/td[1]")
    public List<WebElement> nameColumnCells;  // 'Sirket' sütunu

    @FindBy(xpath = "//tr/td[2]")
    public List<WebElement> codeColumnCells;  // 'ID' sütunu

    @FindBy(xpath = "//tr/td[3]")
    public List<WebElement> phoneColumnCells;  // 'Phone' sütunu

    @FindBy(xpath = "//tr/td[4]")
    public List<WebElement> addressColumnCells;  // 'Address' sütunu

    @FindBy(xpath = "//tr/td[5]")
    public List<WebElement> contactPersonNameColumnCells;  // 'Contact Person' sütunu

    @FindBy(xpath = "//tr/td[6]")
    public List<WebElement> contactPersonPhoneColumnCells;  // 'Contact Phone' sütunu

    public void areWebElementTextsSorted(List<WebElement> nameColumnCells) {
        List<String> elements = ReusableMethods.getElementsText(nameColumnCells);
        List<String> sortedElements = new ArrayList<>(elements);
        Collections.sort(sortedElements);

        Assert.assertEquals("Sıralama başarılı olmadı!", elements, sortedElements);
    }

    // TPA Add Button Check
    @FindBy(xpath = "//*[@class='box-tools pull-right box-tools-md']")
    public WebElement addButton;

    // 'Name' giriş alanı
    @FindBy(xpath = "//small[@class='req']/following-sibling::input[@name='name']")
    public WebElement nameField;

    // 'Code' giriş alanı
    @FindBy(xpath = "//*[@name='code']")
    public WebElement codeField;

    // 'Contact No' giriş alanı
    @FindBy(name = "contact_number")
    public WebElement contactNoField;

    // 'Address' giriş alanı
    @FindBy(name = "address")
    public WebElement addressField;

    // 'Contact Person Name' giriş alanı
    @FindBy(xpath = "//*[@name='contact_person_name']")
    public WebElement contactPersonNameField;

    // 'Contact Person Phone' giriş alanı
    @FindBy(xpath = "//*[@name='contact_person_phone']")
    public WebElement contactPersonPhoneField;

    @FindBy(xpath = "(//*[@type='submit'])[3]")
    public WebElement addSaveSubmit;

    //Edit bolumu
    @FindBy(xpath = "//*[@class='fa fa-pencil']")
    public WebElement editbutton;

    // 'Name' giriş alanı - Edit formu
    @FindBy(xpath = "//*[@id='ename']")
    public WebElement nameFieldEdit;

    // 'Code' giriş alanı - Edit formu
    @FindBy(xpath = "//*[@id='ecode']")
    public WebElement codeFieldEdit;

    // 'Contact No' giriş alanı - Edit formu
    @FindBy(xpath = "//*[@id='econtact_number']")
    public WebElement contactNoFieldEdit;

    // 'Address' giriş alanı - Edit formu
    @FindBy(xpath = "//*[@id='eaddress']")
    public WebElement addressFieldEdit;

    // 'Contact Person Name' giriş alanı - Edit formu
    @FindBy(xpath = "//*[@id='econtact_persion_name']")
    public WebElement contactPersonNameFieldEdit;

    // 'Contact Person Phone' giriş alanı - Edit formu
    @FindBy(xpath = "//*[@id='econtact_persion_phone']")
    public WebElement contactPersonPhoneFieldEdit;

    // Kaydet butonu - Edit formu
    @FindBy(xpath = "(//*[@class='fa fa-check-circle'])[2]")
    public WebElement saveButtonEdit;

    @FindBy(xpath = "(//*[@class='list-group-item listnoback'])[1]")
    public WebElement TPAName;

    public void editfield(WebElement codeFieldEdit, String editString) {
        codeFieldEdit.click();
        codeFieldEdit.clear();
        codeFieldEdit.sendKeys(editString);
        ReusableMethods.wait(1);
    }
    //Delete Button
    @FindBy(xpath = "(//*[@data-toggle='tooltip'])[6]")
    public WebElement deleteButton;

    //Organization Button
    @FindBy(xpath = "(//*[@aria-hidden='true'])[4]")
    public WebElement organizationButton;

    // -------------------------------------

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


    // Dashboard menü başlıkları

    @FindBy(xpath = "//span[normalize-space()='Dashboard']")
    public WebElement DashboardMenu;

    @FindBy(xpath = "//span[normalize-space()='Billing']")
    public WebElement BillingMenu;

    @FindBy(xpath = "//span[normalize-space()='Appointment']")
    public WebElement AppointmentMenu;

    @FindBy(xpath = "//span[normalize-space()='OPD']")
    public WebElement OPDMenu;

    @FindBy(xpath = "//span[normalize-space()='IPD']")
    public WebElement IPDMenu;

    @FindBy(xpath = "//span[normalize-space()='Pharmacy']")
    public WebElement PharmacyMenu;

    @FindBy(xpath = "//span[normalize-space()='Pathology']")
    public WebElement PathologyMenu;

    @FindBy(xpath = "//span[normalize-space()='Radiology']")
    public WebElement RadiologyMenu;

    @FindBy(xpath = "//span[normalize-space()='Blood Bank']")
    public WebElement BloodBankMenu;

    @FindBy(xpath = "//span[normalize-space()='Ambulance']")
    public WebElement AmbulanceMenu;

    @FindBy(xpath = "//span[normalize-space()='Birth & Death Record']")
    public WebElement BirthDeathRecordMenu;

    @FindBy(xpath = "//a[normalize-space()='Birth Record']")
    public WebElement BirthRecordMenu;

    @FindBy(xpath = "//a[normalize-space()='Death Record']")
    public WebElement DeathRecordMenu;

    @FindBy(xpath = "//span[normalize-space()='Human Resource']")
    public WebElement HumanResourceMenu;

    @FindBy(xpath = "//span[normalize-space()='TPA Management']")
    public WebElement TPAManagementMenu;

    @FindBy(xpath = "//span[normalize-space()='Messaging']")
    public WebElement MessagingMenu;

    @FindBy(xpath = "//span[normalize-space()='Live Consultation']")
    public WebElement LiveConsultationMenu;

    @FindBy(xpath = "//a[@href='https://qa.heallifehospital.com/admin/zoom_conference/consult']")
    public WebElement LiveConsultationMenu2;

    @FindBy(xpath = "//a[normalize-space()='Live Meeting']")
    public WebElement LiveMeetingMenu;

    @FindBy(xpath = "//span[normalize-space()='Setup']")
    public WebElement SetupMenu;

    @FindBy(xpath = "//a[@href='https://qa.heallifehospital.com/admin/onlineappointment/']")
    public WebElement SetupAppointmentMenu;

    @FindBy(xpath = "//a[normalize-space()='Symptoms']")
    public WebElement SetupSymptomsMenu;

    @FindBy(xpath = "//a[@href='https://qa.heallifehospital.com/admin/bloodbank/products']")
    public WebElement SetupBloodBankMenu;

    @FindBy(xpath = "//a[@href='https://qa.heallifehospital.com/admin/lab/addlab']")
    public WebElement SetupRadiologyMenu;

    @FindBy(xpath = "//a[@href='https://qa.heallifehospital.com/admin/pathologycategory/addcategory']")
    public WebElement SetupPathologyMenu;

    @FindBy(xpath = "//a[@href='https://qa.heallifehospital.com/admin/medicinecategory/index']")
    public WebElement SetupPharmacyMenu;

    @FindBy(xpath = "//a[normalize-space()='Print Header Footer']")
    public WebElement SetupPrintHeaderFooterMenu;

    @FindBy(xpath = "//a[normalize-space()='Bed']")
    public WebElement SetupBedMenu;

    @FindBy(xpath = "//a[normalize-space()='Hospital Charges']")
    public WebElement SetupHospitalChargesMenu;

    @FindBy(xpath = "//a[normalize-space()='Patient']")
    public WebElement SetupPatientMenu;

    // Dashboard menü iconları

    @FindBy(xpath = "//i[@class='fas fa-television']")
    public WebElement DashboardIcon;

    @FindBy(xpath = "//i[@class='fas fa-file-invoice']")
    public WebElement BillingIcon;

    @FindBy(xpath = "(//i[@class='fa fa-calendar-check-o'])[2]")
    public WebElement AppointmentIcon;

    @FindBy(xpath = "(//i[@class='fas fa-stethoscope'])[1]")
    public WebElement OPDIcon;

    @FindBy(xpath = "//i[@class='fas fa-procedures']")
    public WebElement IPDIcon;

    @FindBy(xpath = "//i[@class='fas fa-mortar-pestle']")
    public WebElement PharmacyIcon;

    @FindBy(xpath = "(//i[@class='fas fa-flask'])[1]")
    public WebElement PathologyIcon;

    @FindBy(xpath = "(//i[@class='fas fa-microscope'])[1]")
    public WebElement RadiologyIcon;

    @FindBy(xpath = "(//i[@class='fas fa-tint'])[1]")
    public WebElement BloodBankIcon;

    @FindBy(xpath = "//i[@class='fas fa-ambulance']")
    public WebElement AmbulanceIcon;

    @FindBy(xpath = "//i[@class='fa fa-birthday-cake']")
    public WebElement BirthDeathRecordIcon;

    @FindBy(xpath = "//i[@class='fas fa-sitemap']")
    public WebElement HumanResourceIcon;

    @FindBy(xpath = "//i[@class='fas fa-umbrella']")
    public WebElement TPAManagementIcon;

    @FindBy(xpath = "//i[@class='fas fa-bullhorn']")
    public WebElement MessagingIcon;

    @FindBy(xpath = "//i[@class='fa fa-video-camera ftlayer']")
    public WebElement LiveConsultationIcon;

    @FindBy(xpath = "//i[@class='fas fa-cogs']")
    public WebElement SetupIcon;

    // Hamburger menü

    @FindBy(xpath = "//a[@role='button']")
    public WebElement HamburgerMenu;

    @FindBy(xpath = "//*[@class='fas fa-microscope']")
    public WebElement radiologyButton;


}