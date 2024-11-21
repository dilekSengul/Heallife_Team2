package StepDefinitions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginStep {
    @FindBy(id = "email")
    public WebElement email;

    @FindBy (id = "password")
    public WebElement password;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy (className = "btn")
    public WebElement signInButton;
}
