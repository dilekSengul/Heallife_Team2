package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Gallery_ContactUsPage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.DriverManager;
import utilities.JSUtilities;
import utilities.ReusableMethods;

import java.sql.Driver;

public class HomePageStep {

    WebDriver driver = Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(  HomePageStep.class);
    HomePage homePage=new HomePage();
    Gallery_ContactUsPage galleryContactUsPage=new Gallery_ContactUsPage();


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






    @Given("Kullanıcı HealLife sitesine erişir")
    public void kullanıcı_heal_life_sitesine_erişir() {
        driver.get("https://www.youtube.com");

    }
    @Given("Url {string} girer")
    public void urlGirer(String url) {
        driver.get(ConfigReader.getProperty(url));
    }

    @Then("Anasayfa alt barinda Contact, Email ve Adress gorunurlugunu dogrular.")
    public void anasayfa_alt_barinda_contact_email_ve_adress_gorunurlugunu_dogrular () {

        JSUtilities.scrollToElement(driver,homePage.Contact);
        ReusableMethods.wait(3);
        Assert.assertTrue(homePage.Contact.isDisplayed());
        Assert.assertTrue(homePage.Email.isDisplayed());
        Assert.assertTrue(homePage.Adress.isDisplayed());
    }
    @Then("Sayfayi Kapatir")
    public void sayfayı_kapatir () {
        driver.quit();
    }
    @When("Anasayfa alt Barinda Contact'a tiklar")
    public void ansayfa_alt_barinda_contact_a_tiklar() {
        JSUtilities.scrollToElement(driver,homePage.Contact);
        ReusableMethods.wait(3);
        homePage.Contact.click();
    }
    @Then("Contact Us sayfasina yonlendirildigini dogrular")
    public void contact_us_sayfasina_yonlendirildigini_dogrular() {
        String expectedUrl=ConfigReader.getProperty("ContactUsUrl");
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @When("Anasayfa alt Barinda Mail'e tiklar")
    public void anasayfa_alt_barinda_mail_e_tiklar() {
        JSUtilities.scrollToElement(driver,homePage.Email);
        ReusableMethods.wait(3);
        homePage.Email.click();
    }
    @Then("Mail'e tiklanabildigini dogrular")
    public void mail_e_tiklanabildigini_dogrular() {
        Assert.assertTrue(homePage.Adress.isEnabled());
    }
    @When("Anasayfa alt Barinda Adress'e tiklar")
    public void anasayfa_alt_barinda_adress_e_tiklar() {
        JSUtilities.scrollToElement(driver,homePage.Adress);
        ReusableMethods.wait(3);
        homePage.Adress.click();
    }
    @Then("Yonlendirilen sayfada hatitanın goruntulendigini dogrular")
    public void yonlendirilen_sayfada_hatitanın_goruntulendigini_dogrular() {
        ReusableMethods.switchWindowByUrl(driver, ConfigReader.getProperty("ContactUsUrl"));
        // driver.switchTo().frame(galleryContactUsPage.MapIframe);

        Assert.assertTrue(galleryContactUsPage.MapText.isDisplayed());

    }








}
