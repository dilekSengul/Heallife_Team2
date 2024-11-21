package StepDefinitions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class HomePageStep {
    public HomePageStep(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    // [Header] - [Home] bölümünün elementleri

    @FindBy(xpath = "(//*[text()='Home'])[1]")
    public WebElement Home;

    @FindBy(xpath = "//a[@class='navbar-brand logo']//img")
    public WebElement HLlogo;

    @FindBy(xpath = "//*[text()='Bu siteye ulaşılamıyor']")
    public WebElement errorMessage;

    // [Header] - [Appointment] bölümünün elementleri

    @FindBy (xpath = "(//*[text()='Appointment'])[1]")
    public WebElement Appointment;

    // [Header] - [Login] bölümünün elementleri

    @FindBy (xpath = "//*[text()='Login']")
    public WebElement Login;

    // [Header] - [Contant Us] bölümünün elementleri

    @FindBy (xpath = "(//*[text()='Contact Us'])[1]")
    public WebElement ContactUs;

    // [Header] - [About Us] bölümünün elementleri

    @FindBy (xpath = "(//*[text()='About Us '])[1]")
    public WebElement AboutUs;

    // [Footer] - [Social Media] bölümünün elementleri

    // [Footer] - [Communication] bölümünün elementleri

    // [Footer] - [Copyright] bölümünün elementleri

    // [Home] - [Methods] buraya eklenecek



}
