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

    // Dropdown menüsü
    // Alt başlıklar
    @FindBy(xpath = "//*[@class='dropdown-toggle']")
    public WebElement aboutUsDropdownMenu;

    @FindBy(linkText = "About Hospitals")

    public WebElement aboutHospitalsLink;

    @FindBy(linkText = "Meet Our Doctors")
    public WebElement meetOurDoctorsLink;

    @FindBy(linkText = "FAQ’s")
    public WebElement faqsLink;

    @FindBy(linkText = "Departments")
    public WebElement departmentsLink;

    @FindBy(linkText = "Testimonials")
    public WebElement testimonialsLink;

    // About Hospitals
    // "Some Words About Us" başlığını bulmak için WebElement
    @FindBy(xpath = "(//*[@class='mt0'])[1]")
    public WebElement someWordsAboutUsTitle;

    // "Our Mission" başlığını bulmak için WebElement
    @FindBy(xpath = "(//*[@class='mt0'])[2]")
    public WebElement ourMissionTitle;

    // "Opening Hours" bilgisini bulmak için WebElement
    @FindBy(xpath = "//*[@class='opening-hours']")
    public WebElement openingHoursInfo;

    @FindBy(xpath = "(//*[text()='Home'])[1]")
    public WebElement Home;





}
