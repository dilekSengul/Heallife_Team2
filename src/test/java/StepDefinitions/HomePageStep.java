package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.DriverManager;

import java.sql.Driver;

public class HomePageStep {
    public HomePageStep(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
    private static final Logger logger = LogManager.getLogger(  HomePageStep.class);

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


    @Given("Kullanıcı projectUrl adresini ziyaret eder")
    public void kullanıcı_HLurl_adresini_ziyaret_eder() throws InterruptedException {

        DriverManager.getDriver().get(ConfigReader.getProperty("HLurl"));
        Thread.sleep(2000);


    }
    @Given("Kullanıcı ana sayfanın footer bölümüne kaydırır")
    public void kullanıcı_ana_sayfanın_footer_bölümüne_kaydırır() {
       ;
    }
    @Given("Facebook ikonuna tıklar")
    public void facebook_ikonuna_tıklar() {

    }
    @Then("Facebook ikonunun tıklandığını doğrular")
    public void facebook_ikonunun_tıklandığını_doğrular() {

    }

    @Then("Twitter ikonuna tıklar")
    public void twitter_ikonuna_tıklar() {

    }
    @Then("Açılan sayfa doğru Twitter hesabına yönlendirilmelidir")
    public void açılan_sayfa_doğru_twitter_hesabına_yönlendirilmelidir() {

    }
    @Then("YouTube ikonuna tıklar")
    public void you_tube_ikonuna_tıklar() {

    }
    @Then("Açılan sayfa doğru YouTube hesabına yönlendirilmelidir")
    public void açılan_sayfa_doğru_you_tube_hesabına_yönlendirilmelidir() {
      ;
    }
    @Then("Google ikonuna tıklar")
    public void google_ikonuna_tıklar() {

    }
    @Then("Açılan sayfa doğru Google hesabına yönlendirilmelidir")
    public void açılan_sayfa_doğru_google_hesabına_yönlendirilmelidir() {

    }
    @Then("LinkedIn ikonuna tıklar")
    public void linked_ın_ikonuna_tıklar() {
       ;
    }
    @Then("Açılan sayfa doğru LinkedIn hesabına yönlendirilmelidir")
    public void açılan_sayfa_doğru_linked_ın_hesabına_yönlendirilmelidir() {

    }
    @Then("Kullanıcı Instagram ikonuna tıklar")
    public void kullanıcı_ınstagram_ikonuna_tıklar() {

    }
    @Then("Açılan sayfa doğru Instagram hesabına yönlendirilmelidir")
    public void açılan_sayfa_doğru_ınstagram_hesabına_yönlendirilmelidir() {

    }
    @Then("Kullanıcı Pinterest ikonuna tıklar")
    public void kullanıcı_pinterest_ikonuna_tıklar() {

    }
    @Then("Açılan sayfa doğru Pinterest hesabına yönlendirilmelidir")
    public void açılan_sayfa_doğru_pinterest_hesabına_yönlendirilmelidir() {

    }
    @Then("sayfayı kapatır")
    public void sayfayı_kapatır() {
 ;
    }





    // [Footer] - [Communication] bölümünün elementleri

    // [Footer] - [Copyright] bölümünün elementleri

    // [Home] - [Methods] buraya eklenecek



}
