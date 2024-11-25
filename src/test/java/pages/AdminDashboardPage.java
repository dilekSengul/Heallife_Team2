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
}
