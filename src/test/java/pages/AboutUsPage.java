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

    @FindBy(xpath = "(//*[text()='Home'])[1]")
    public WebElement Home;

    // Alt başlıklar
//    @FindBy(xpath = "//*[@id='navbar-collapse-3']/ul/li[3]/ul/li[1]/a")
//    public WebElement aboutHospitals;
//
//    @FindBy(xpath = "//*[@class='dropdown-menu']//a[text()='Meet Our Doctors']")
//    public WebElement meetOurDoctors;
//
//    @FindBy(xpath = "//*[@class='dropdown-menu']//a[text()=\"FAQ's\"]")
//    public WebElement faqs;
//
//    @FindBy(xpath = "//*[@class='dropdown-menu']//a[text()='Departments']")
//    public WebElement departments;
//
//    @FindBy(xpath = "//*[@class='dropdown-menu']//a[text()='Testimonials']")
//    public WebElement testimonials;


}
