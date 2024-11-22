package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;
import utilities.ReusableMethods;

import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    public HomePage(){
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


    @FindBy (xpath = "//*[@class='col-md-4 col-sm-4'])[2])")
    public List<WebElement> footerElementLists;


    // [Footer] - [Social Media] bölümünün elementleri


    @FindBy (xpath = "//*[@class='fa fa-facebook']")
    public WebElement FacebookIkonu;

    @FindBy (xpath = "//*[@href='https://twitter.com/login?lang=en']")
    public WebElement TwitterIkonu;

    @FindBy (xpath = "//*[@class='fa fa-youtube']")
    public WebElement YouTubeIkonu;

    @FindBy (xpath = "//*[@class='fa fa-google-plus']")
    public WebElement GoogleIkonu;

    @FindBy (xpath = "//*[@class='fa fa-linkedin']")
    public WebElement LinkedinIkonu;

    @FindBy (xpath = "//*[@class='fa fa-instagram']")
    public WebElement InstagramIkonu;

    @FindBy (xpath = "//*[@class='fa fa-pinterest']")
    public WebElement PinterestIkonu;



    // [Footer] - [Communication] bölümünün elementleri

    // [Footer] - [Copyright] bölümünün elementleri

    // [Home] - [Methods] buraya eklenecek

    @FindBy (xpath = "//div[@class='team-member']/h4")
    public List<WebElement> teamMembers;


    public List<String> getDoctorNames() {
        List<String> doctorNames = new ArrayList<>();
        for (WebElement member : teamMembers) {
            doctorNames.add(member.getText());
        }

        return doctorNames;

    }
}
