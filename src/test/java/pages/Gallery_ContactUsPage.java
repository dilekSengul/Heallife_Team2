package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

import java.util.List;

public class Gallery_ContactUsPage {

    public Gallery_ContactUsPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }


    // [Header] - [Login] bölümünün elementleri

    // [Header] - [Contant Us] bölümünün elementleri

    // [Header] - [About Us] bölümünün elementleri
    // ? Bu elementler AboutUsPage classında tekrar yazmamıza gerek var mı?

    // [Header] - [Gallery] bölümünün elementleri
    @FindBy (xpath = "//*[text()='Contact Us']")
    public WebElement contactUsTabElementi;
    // Galeri menüsü locater'ı
    @FindBy(xpath = "(//a[text()='Gallery'])[1]")
    public WebElement galleryLink;

    // Galeri sayfası başlığı locater'ı
    @FindBy(xpath = "//h2[text()='Gallery']")
    public WebElement galleryPageHeader;
    // Galeri altindaki bolumler
    @FindBy(xpath = "//*[@class='eventbox']")
    public List<WebElement> gallerySectionsList;

    //Bolumlere tiklandiginda cikan resimler
    @FindBy(xpath = "//*[@class='galleryfancy']")
    public List<WebElement> galleryImagesList;

    // [Footer] - [Social Media] bölümünün elementleri


    // [Footer] - [Communication] bölümünün elementleri

    @FindBy(xpath = "//div[@class='gm-style']")
    public WebElement MapPhoto;
   @FindBy(xpath = "//iframe[contains(@src, 'https://www.google.com/maps/embed')]")
   public WebElement iframeElement;


    // [Footer] - [Social Media] bölümünün elementleri

    // [Footer] - [Copyright] bölümünün elementleri

    // [Contac_Us] - [Methods] buraya eklenecek

    @FindBy(xpath = "//*[@id=\"name\"]")
    public WebElement Namecontact;
    @FindBy(xpath = "//*[@id=\"email\"]")
    public WebElement emailContact;
    @FindBy(xpath = "//*[@id=\"subject\"]")
    public WebElement Subject;
    @FindBy(xpath = "//*[@id=\"description\"]")
    public WebElement Description;
    @FindBy(xpath = "//*[@id=\"open\"]/div[5]/div/input")
    public WebElement submit;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]")
    public WebElement dogrulama;
    @FindBy(xpath = "//*[@id=\"map\"]")
    public WebElement Map;



}
