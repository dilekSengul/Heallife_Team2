package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

import java.util.List;

public class AboutUsPage {

    public AboutUsPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    //Levent//
    @FindBy(xpath = "//*[@class='dropdown-toggle']")
    public WebElement aboutUsButton;

    @FindBy(xpath = "//a[@class='dropdown-toggle' and contains(text(), 'About Us')]")
    public List<WebElement> aboutUsMenuDMM;
    @FindBy(xpath = "//ul[@class='dropdown-menu']/li/a")
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

    // "Our Specialist" başlığı
    @FindBy(xpath = "//*[@class='mt0 text-center']")
    public WebElement ourSpecialistHeading;

    // Doktorların tümünü içeren WebElement listesi
    @FindBy(xpath = "//*[@class='team-member']")
    public List<WebElement> doctorsList;

    // "Meet Our Doctors" sayfasi
    @FindBy(xpath = "//*[@class='nav nav-pills doctortap']")
    public WebElement uzmanlikAlanlariMenu;

    @FindBy(xpath = "//a[@href='#practitioner']")
    public WebElement generalPractitioner;

    @FindBy(xpath = "//a[@href='#ophthalmologist']")
    public WebElement ophthalmologist;

    @FindBy(xpath = "//a[@href='#paediatrician']")
    public WebElement paediatrician;

    @FindBy(xpath = "//a[@href='#cardiologist']")
    public WebElement cardiologist;

    @FindBy(xpath = "//a[@href='#gynaecologist']")
    public WebElement gynaecologist;

    @FindBy(xpath = "//a[@href='#neurologist']")
    public WebElement neurologist;

    // "Meet Our Doctors" sayfasindaki uzmanlik alanina tikladindiginda yanda cikan doktorlar(toplam28 doktor)
    @FindBy(xpath = "//*[@class='team-member']")
    public List<WebElement> teamMembers;

    // Doktor bilgilerini doğrulamak için yardımcı metod
    public void validateDoctorDetails(WebElement doctor) {
        WebElement image = doctor.findElement(By.tagName("img"));
        WebElement name = doctor.findElement(By.tagName("h4"));
        WebElement title = doctor.findElement(By.tagName("p"));

        // Doktor ismi, ünvanı ve resminin görünür olduğunu doğruluyoruz
        if (!name.isDisplayed()) {
            throw new AssertionError("Doktor ismi görünmüyor");
        }
        if (!title.isDisplayed()) {
            throw new AssertionError("Doktor ünvanı görünmüyor");
        }
        if (!image.isDisplayed()) {
            throw new AssertionError("Doktor resmi görünmüyor");
        }
    }

    // "FAQ" sayfasi
    // "What Our Clients Say" ve "What Our Doctors Say" bölümleri için locater'lar
    @FindBy(xpath = "//*[@class='col-md-6'][1]")
    public WebElement whatOurClientsSay;

    @FindBy(xpath = "//*[@class='col-md-6'][2]")
    public WebElement whatOurDoctorsSay;

    // Tüm soruları almak için locater
    @FindBy(xpath = "(//*[@class='panel panel-default'])")
    public List<WebElement> allQuestions;

    // Cevaplar için locater
    @FindBy(xpath = "//*[@class='panel-body pxlr-faq-body']")
    public List<WebElement> allAnswers;

    // Departman başlıkları için locater (h4 etiketine göre)
    @FindBy(xpath = "//div[@class='chooseus']//h4")
    public List<WebElement> departmentTitles;

    // Departman açıklama metinleri için locater (p etiketine göre)
    @FindBy(xpath = "//div[@class='chooseus']//p")
    public List<WebElement> departmentDescriptions;


    // Tüm testimonial öğelerini almak için locater
    @FindBy(xpath = "//*[@class='user-testimonial']")
    public List<WebElement> testimonialList;

    // Testimonial içerisindeki isimleri almak için locater
    @FindBy(xpath = "//*[@class='user-testimonial']//h3")
    public List<WebElement> testimonialNames;

    // Testimonial içerisindeki yorumları almak için locater
    @FindBy(xpath = "//*[@class='user-testimonial']//p")
    public List<WebElement> testimonialComments;

    // Testimonial içerisindeki resimleri almak için locater
    @FindBy(xpath = "//*[@class='user-testimonial']//img")
    public List<WebElement> testimonialImages;

}

