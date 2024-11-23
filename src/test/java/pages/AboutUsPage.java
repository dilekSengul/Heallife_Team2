package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

import java.util.List;

public class AboutUsPage {

    public AboutUsPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    //Levent//
    @FindBy (xpath = "//*[@class='dropdown-toggle']")
    public WebElement aboutUsButton;

    @FindBy (xpath = "//a[@class='dropdown-toggle' and contains(text(), 'About Us')]")
    public List<WebElement> aboutUsMenuDMM;
    @FindBy (xpath = "//ul[@class='dropdown-menu']/li/a")
    public List<WebElement> aboutUsMenuDMM2;



}
