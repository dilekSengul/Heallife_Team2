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

}
