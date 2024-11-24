package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_scouse.An;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.DriverManager;
import utilities.ReusableMethods;

import java.sql.Driver;


public class HomePageStep {

    private static final Logger logger = LogManager.getLogger(  HomePageStep.class);

    HomePage homePage= new HomePage();



    @Given("Kullanıcı HLurl adresini ziyaret eder")
    public void kullanıcı_h_lurl_adresini_ziyaret_eder() {
    DriverManager.getDriver().get(ConfigReader.getProperty("HLurl"));
    ReusableMethods.waitFor(2);
    }


    @And ("Kullanıcı siteye başarıyla erişebildiğini doğrular")
    public void kullanici_siteye_basariyla_erisebilmelidir() {
    homePage.HLlogo.isDisplayed();
    ReusableMethods.waitFor(2);


    }
    @Given("Kullanıcı ana sayfanın footer bölümüne kaydırır")
    public void kullanıcı_ana_sayfanın_footer_bölümüne_kaydırır() {
    ReusableMethods.scrollToFooter(DriverManager.getDriver(),homePage.FacebookIkonu);
    ReusableMethods.waitFor(2);

    }

    @Given("Kullanıcı sosyal medya ikonu Facebook'un görünür olduğunu doğrular")
    public void kullanıcı_sosyal_medya_ikonu_facebook_un_görünür_olduğunu_doğrular() {
    homePage.FacebookIkonu.isDisplayed();
    ReusableMethods.waitFor(2);
    }


    @Then("Facebook ikonuna tıklar")
    public void facebook_ikonuna_tıklar() {
    homePage.FacebookIkonu.click();
    ReusableMethods.waitFor(2);
    }


    @And("Twitter ikonuna tıklar")
    public void twitter_ikonuna_tıklar() {
    homePage.TwitterIkonu.click();
    ReusableMethods.waitFor(2);

    }

    @And("YouTube ikonuna tıklar")
    public void you_tube_ikonuna_tıklar() {
    homePage.YouTubeIkonu.click();
    ReusableMethods.waitFor(2);

    }
    @And("Google ikonuna tıklar")
    public void google_ikonuna_tıklar() {
    homePage.GoogleIkonu.click();
    ReusableMethods.waitFor(2);

    }
    @Then("LinkedIn ikonuna tıklar")
    public void linked_ın_ikonuna_tıklar() {
    homePage.LinkedinIkonu.click();
    ReusableMethods.waitFor(2);

    }

    @And("Kullanıcı Instagram ikonuna tıklar")
    public void kullanıcı_ınstagram_ikonuna_tıklar() {
    homePage.InstagramIkonu.click();
    ReusableMethods.waitFor(2);
    }

    @And("Kullanıcı Pinterest ikonuna tıklar")
    public void kullanıcı_pinterest_ikonuna_tıklar() {
    homePage.PinterestIkonu.click();
    ReusableMethods.waitFor(2);
    }


    }














