package pages;

import StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.DriverManager;
import utilities.ReusableMethods;


public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    WebDriver driver = Hooks.getDriver();

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(className = "btn")
    public WebElement signInButton;

    @FindBy(xpath = "//*[text()='Login']")
    public WebElement Login;

    //Admin Login Penceresi
    @FindBy(xpath = "//div[@class='form-bottom']")
    public WebElement adminLoginPenceresi;

    @FindBy(xpath = "//div[@class='col-lg-6 col-sm-6 col-sm-6']")
    public WebElement latestNewsPenceresi;

    @FindBy(xpath = "//a[@class='forgot']")
    public WebElement adminForgotPassword;

    @FindBy(xpath = "//input[@class='form-username form-control']")
    public WebElement adminForgotPasswordEmail;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement adminForgotPasswordSubmitButton;

    @FindBy(xpath = "//a[@class='forgot']")
    public WebElement adminLoginLink;

    @FindBy(xpath = "//span[@class='logo-lg']")
    public WebElement adminLogo;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement forgotPasswordAlert;

    public void verifySectionVisibilityAndPosition(String xpath, String sectionName, String expectedPosition) {
        WebElement section = driver.findElement(By.xpath(xpath));

        // Bölmenin görünürlüğünü kontrol et
        if (!section.isDisplayed()) {
            throw new AssertionError(sectionName + " görünmüyor!");
        }

        // Pencere genişliğini ve bölmenin X koordinatını al
        int windowWidth = driver.manage().window().getSize().getWidth();
        int elementX = section.getLocation().getX();

        // Beklenen konuma göre bölmenin doğru yerde olup olmadığını doğrula
        if ("sağ".equalsIgnoreCase(expectedPosition) && elementX <= windowWidth / 2) {
            throw new AssertionError(sectionName + " sağ tarafta değil!");
        } else if ("sol".equalsIgnoreCase(expectedPosition) && elementX >= windowWidth / 2) {
            throw new AssertionError(sectionName + " sol tarafta değil!");
        }
    }

    public static  void accesAdmin(String adminuserName,String adminPassword) {
        LoginPage loginPage = new LoginPage();
        DriverManager.getDriver().get(ConfigReader.getProperty("HLadminUrl"));
        ReusableMethods.wait(2);
        loginPage.email.sendKeys(ConfigReader.getProperty(adminuserName) + Keys.TAB + ConfigReader.getProperty(adminPassword));
      loginPage.signInButton.click();
    }

    public void hastaLogin() {
        Login.click();  // Giriş butonuna tıklanıyor
        email.sendKeys(ConfigReader.getProperty("HLusername")); // Kullanıcı adı giriliyor (test için örnek)
        password.sendKeys(ConfigReader.getProperty("HLpassword")); // Şifre giriliyor (test için örnek)
        signInButton.click();
    }


    public void AdminLogin(String email, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.email.sendKeys(email);
        loginPage.password.sendKeys(password);
        loginPage.signInButton.click();

    }

}
