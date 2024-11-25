package pages;

import StepDefinitions.AdminDashboardStep;
import StepDefinitions.Hooks;
import com.google.j2objc.annotations.Weak;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverManager;
import utilities.JSUtilities;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
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


    public void kullanıcı_tüm_menü_başlıklarını_kontrol_eder() {
        // Menü başlıklarını toplamak için liste
        List<String> visibleMenuItems = new ArrayList<>();

        // Sol sidebar'daki menüyü bul
        WebElement sidebar = driver.findElement(By.cssSelector("ul.sidebar-menu.verttop")); // Sidebar'ın CSS selector'ü

        // Görünür tüm başlıkları topla
        List<WebElement> menuItems = driver.findElements(By.cssSelector(".sidebar-menu li a span")); // Menü başlıklarının selector'ü


        for (WebElement item : menuItems) {
            visibleMenuItems.add(item.getText().trim());
        }

        // Beklenen başlıklar
        List<String> expectedMenuItems = List.of(
                "Dashboard", "Billing", "OPD", "IPD", "Pharmacy",
                "Pathology", "Radiology", "Blood Bank", "Ambulance",
                "Birth & Death Record", "Human Resource", "TPA Management",
                "Messaging", "Live Consultation", "Setup"
        );

        // Başlıkları kontrol et
        Assert.assertEquals("Menü başlıkları eşleşmiyor!", expectedMenuItems, visibleMenuItems);
    }
}