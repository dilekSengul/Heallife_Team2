package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

import java.util.List;

import java.util.ArrayList;


public class HomePage {
    public HomePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }


    // [Header] - Lastest News - Kayan Yazı
    @FindBy(xpath = "//marquee/ul/li[1]/a/div")
    public WebElement lastestNewsKayanYaziIcerik;

    // [Header] - Header-Navbar elementleri
    //Locator
    @FindBy(xpath = "//*[@id='navbar-collapse-3']/ul/li")
    public List<WebElement> navbarElements; // Tüm <li> elementlerini listeler.

    //String Çağırma Metodu
    public List<String> getNavbarElements() {
        List<String> navbarLi = new ArrayList<>();
        for (WebElement header : navbarElements) {
            navbarLi.add(header.getText().trim());
        }
        return navbarLi;
    }


    // [Header] - [Home] bölümünün elementleri

    @FindBy(xpath = "(//*[text()='Home'])[1]")
    public WebElement Home;

    @FindBy(xpath = "//a[@class='navbar-brand logo']//img")
    public WebElement HLlogo;

    @FindBy(xpath = "//*[text()='Bu siteye ulaşılamıyor']")
    public WebElement errorMessage;

    // [Header] - [Appointment] bölümünün elementleri

    @FindBy(xpath = "(//*[text()='Appointment'])[1]")
    public WebElement Appointment;

    // [Header] - [Login] bölümünün elementleri

    @FindBy(xpath = "//*[text()='Login']")
    public WebElement Login;

    // [Header] - [Contant Us] bölümünün elementleri

    @FindBy(xpath = "(//*[text()='Contact Us'])[1]")
    public WebElement ContactUs;

    // [Header] - [About Us] bölümünün elementleri

    @FindBy(xpath = "(//*[text()='About Us '])[1]")
    public WebElement AboutUs;

    @FindBy(xpath = "//h2[normalize-space()='Our Doctors']")
    public WebElement OurDoctors;
    @FindBy(xpath = "//div[@class='container spacet50 spaceb50']//div[4]//div[2]")
    public WebElement doktorKartlari;
    @FindBy(xpath = "//h4[normalize-space()='Heidi Prather']")
    public List<WebElement> doktorBilgileri;

    @FindBy(xpath = "//*[@class='col-md-4 col-sm-4'])[2])")
    public List<WebElement> footerElementLists;


    // [Footer] - [Social Media] bölümünün elementleri


    @FindBy(xpath = "//*[@class='fa fa-facebook']")
    public WebElement FacebookIkonu;

    @FindBy(xpath = "//*[@href='https://twitter.com/login?lang=en']")
    public WebElement TwitterIkonu;

    @FindBy(xpath = "//*[@class='fa fa-youtube']")
    public WebElement YouTubeIkonu;

    @FindBy(xpath = "//*[@class='fa fa-google-plus']")
    public WebElement GoogleIkonu;

    @FindBy(xpath = "//*[@class='fa fa-linkedin']")
    public WebElement LinkedinIkonu;

    @FindBy(xpath = "//*[@class='fa fa-instagram']")
    public WebElement InstagramIkonu;

    @FindBy(xpath = "//*[@class='fa fa-pinterest']")
    public WebElement PinterestIkonu;


    // [Footer] - [Communication] bölümünün elementleri

    @FindBy(xpath = "(//a[@class='content-title'])[1]")
    public WebElement Contact;
    @FindBy(xpath = "(//a[@class='content-title'])[2]")
    public WebElement Email;
    @FindBy(xpath = "(//a[@class='content-title'])[3]")
    public WebElement Adress;

    // [Footer] - [Copyright] bölümünün elementleri

    // [Home] - [Methods] buraya eklenecek

    @FindBy(xpath = "//div[@class='team-member']/h4")
    public List<WebElement> teamMembers;

    @FindBy(xpath = "//div[@class='team-member']/p")
    public List<WebElement> unvanlar;

    @FindBy (xpath = "//h2[normalize-space()='Our Doctors']")
    public WebElement ourDoctorsText;

    @FindBy (xpath = "//ul[@class='f1-list']/li/a")
    public List<WebElement> homapagealtBar;

    public List<String> getHomePageAltBar(){
        List<String>homePageBar=new ArrayList<>();
        for(WebElement altbar : homapagealtBar){
            homePageBar.add(altbar.getText());
        }
        return homePageBar;
    }

    public String doctorstextsgets() {
        String doctortexts = ourDoctorsText.getText();
    return doctortexts;
}

    public List<String> getDoctorUnvans() {
        List<String> doctorUnvans = new ArrayList<>();
        for (WebElement member : unvanlar) {
            doctorUnvans.add(member.getText());
        }

        return doctorUnvans;

    }



    public List<String> getDoctorNames() {
        List<String> doctorNames = new ArrayList<>();
        for (WebElement member : teamMembers) {
            doctorNames.add(member.getText());
        }

        return doctorNames;

    }

    public void kullanıcı_ana_sayfaya_yönlendirilir() {
        // Beklenen ana sayfa URL'si
        String expectedUrl = "https://qa.heallifehospital.com/";

        // Tarayıcıdaki mevcut URL'yi al
        WebDriver driver = null;
        String actualUrl = driver.getCurrentUrl();

        // URL'nin doğru olup olmadığını doğrula
        Assert.assertEquals("Kullanıcı ana sayfada değil!", expectedUrl, actualUrl);

    }
    public void setOurDoctors() {
        Assert.assertTrue(OurDoctors.isDisplayed());
    }

    public void her_bir_doktor_için_aşağıdaki_bilgiler_görünür_olmalı() {
        for (int i = 0; i < doktorBilgileri.size(); i++) {
            // Beklenen isim ve unvan
            //   String actualName = doktorBilgileri.get(i).getText("İsim Soyisim");
            //    String actualTitle = doktorBilgileri.get(i).get("Unvan");

            // Sayfadaki doktor kartını al
            //  WebElement doktorKart = doktorKartlari.get(i);
            //Doktor fotoğrafının görünür olduğunu doğrula
            // WebElement doktorFoto = doktorKart.findElement(By.cssSelector(".doctor-photo"));
            // Assert.assertTrue("Doktor fotoğrafı görünüyor!", doktorFoto.isDisplayed());

        }
    }



    // [Header] - [Gallery] bölümünün elementleri

    @FindBy(xpath = "(//a[normalize-space()='Gallery'])[1]")
    public WebElement Gallery;

    @FindBy(xpath = "//h2[normalize-space()='Gallery']")
    public WebElement GalleryTitle;

    @FindBy(xpath = "//h1[normalize-space()='Health & Wellness']")
    public WebElement GallerySubTitle1;

    @FindBy(xpath = "//h1[normalize-space()='Hospitals and Directions']")
    public WebElement GallerySubTitle2;

    @FindBy(xpath = "//h1[normalize-space()='Specialities']")
    public WebElement GallerySubTitle3;

    @FindBy(xpath = "//h1[normalize-space()='Recreation Centre']")
    public WebElement GallerySubTitle4;

    @FindBy(xpath = "//h1[normalize-space()='Your Health']")
    public WebElement GallerySubTitle5;

    @FindBy(xpath = "//h1[normalize-space()='Surgery']")
    public WebElement GallerySubTitle6;

    // [Header] - [Login] bölümünün elementleri

    // [Footer] - [Social Media] bölümünün elementleri

    // [Footer] - [Communication] bölümünün elementleri

    // [Footer] - [Copyright] bölümünün elementleri

    @FindBy(xpath = "(//*[text()='Contact Us'])[2]")
    public WebElement FooterContactUs;

    @FindBy(xpath = "(//*[text()='About'])[1]")
    public WebElement FooterAboutUs;

    @FindBy(xpath = "(//a[normalize-space()='Gallery'])[2]")
    public WebElement FooterGallery;

    @FindBy(xpath = "(//*[text()='Home'])[2]")
    public WebElement FooterHome;

    @FindBy(xpath = "(//*[text()='Academics'])[1]")
    public WebElement FooterAcademics;

    @FindBy(xpath = "//*[@class='eventbox']")
    public List<WebElement> GalleryResimler;

    @FindBy(xpath = "//*[@class='evcontentfix']")
    public List<WebElement> GalleryBasliklar;



    // [Body] - [Bilgi Boardları] bölümünün elementleri

    @FindBy (xpath = "//*[@class='featurebox1']")
    public WebElement InsurancePlans;

    @FindBy (xpath = "(//*[@class='morebtn'])[1]")
    public WebElement ReadMoreInsurancePlans;

    @FindBy (xpath = "(//*[text()='Insurance Plans'])[2]")
    public WebElement BaslikInsurancePlans;

    @FindBy (xpath = "//*[@class='featurebox2']")
    public WebElement PediatricServices;

    @FindBy (xpath = "(//*[@class='morebtn'])[2]")
    public WebElement ReadMorePediatricServices;

    @FindBy (xpath = "//*[text()='Our Pediatric Services:']")
    public WebElement BaslikPediatricServices;

    @FindBy (xpath = "//*[@class='featurebox3']")
    public WebElement LabTesting;

    @FindBy (xpath = "(//*[@class='morebtn'])[3]")
    public WebElement ReadMoreLabTesting;

    @FindBy (xpath = "//*[text()='Lab Testing Services:']")
    public WebElement BaslikLabTesting;


    // [Body] - [Featured Services] bölümünün elementleri

    @FindBy (xpath = "//*[text()='Featured Services']")
    public WebElement FeaturedServicesYazisi;

    @FindBy (xpath = "//*[text()='Nurse-to-Resident Ratio']")
    public WebElement FSbirinciBaslik;

    @FindBy (xpath = "//*[text()='Emergency Help']")
    public WebElement FSikinciBaslik;

    @FindBy (xpath = "//*[text()='Onsite Medical Staff']")
    public WebElement FSucuncuBaslik;

    @FindBy (xpath = "//*[text()='Communication All Parties']")
    public WebElement FSdorduncuBaslik;


}

