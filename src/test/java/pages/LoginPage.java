package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(id = "email")
    public WebElement email;

    @FindBy (id = "password")
    public WebElement password;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy (className = "btn")
    public WebElement signInButton;

    @FindBy (xpath = "//*[text()='Login']")
    public WebElement Login;

    //Admin Login
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

}
