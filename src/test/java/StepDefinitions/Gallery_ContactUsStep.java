package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.Gallery_ContactUsPage;
import utilities.ConfigReader;
import utilities.ReusableMethods;

public class Gallery_ContactUsStep {
    WebDriver driver = Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(Gallery_ContactUsStep.class);
    Gallery_ContactUsPage galleryPage = new Gallery_ContactUsPage();

    @Then("Kullanici contact_us sayfasina acildigini dogrular")
    public void kullaniciContact_usSayfasinaAcildiginiDogrular() {
        String expectedUrl = "https://qa.heallifehospital.com/page/contact-us";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @When("Kullanici contact_us linkine tiklar")
    public void kullaniciContact_usLinkineTiklar() {
        galleryPage.contactUsTabElementi.click();
        ReusableMethods.wait(2);

    }


    //US_13_GalleryPageTest-Hurrem

    @When("Ana sayfada Gallery menüsüne tıklayın")
    public void ana_sayfada_gallery_menüsüne_tıklayın() {
        galleryPage.galleryLink.click();
    }

    @Then("Kullanıcının Gallery sayfasına yönlendirildiğini doğrulayın")
    public void kullanıcının_gallery_sayfasına_yönlendirildiğini_doğrulayın() {
        galleryPage.galleryPageHeader.isDisplayed();
    }

    @When("{string} bölümüne tıklayın ve ilgili resimlerin sayfada bulunduğunu doğrulayın")
    public void bölümüne_tıklayın(String sectionName) {

        for (WebElement section : galleryPage.gallerySectionsList) {
            if (section.getText().startsWith(sectionName)) {
                section.click();
                ReusableMethods.bekle(1);
                Assert.assertFalse("Resimler bulunamadı!", galleryPage.galleryImagesList.isEmpty());
                break;
            }
        }

        driver.navigate().back();
    }


    @And("Kullanıcı ismini girer")
    public void kullanıcıIsminiGirer() {
        galleryPage.Namecontact.sendKeys(ConfigReader.getProperty("Namegulnar"));
        {

        }
    }

    @And("Kullanıcı email adresini girer")
    public void kullanıcıEmailAdresiniGirer() {
        galleryPage.emailContact.sendKeys(ConfigReader.getProperty("gulnarPatName"));
    }

    @And("Kullanıcı subject alanını doldurur")
    public void kullanıcıSubjectAlanınıDoldurur() {
        galleryPage.Subject.sendKeys(ConfigReader.getProperty("subject"));
    }

    @And("Kullanıcı description alanına mesaj yazar")
    public void kullanıcıDescriptionAlanınaMesajYazar() {
        galleryPage.Description.sendKeys(ConfigReader.getProperty("Description"));
        ReusableMethods.wait(2);
    }

    @Then("Kullanıcı formu gönderir")
    public void kullanıcıFormuGönderir() {
        galleryPage.submit.click();
    }

    @Then("Kulanici dogrulama mesajını görür")
    public void kulaniciDogrulamaMesajınıGörür() {
        galleryPage.dogrulama.isDisplayed();

    }

    @And("haritanin görundugunu onaylar")
    public void haritaninGörundugunuOnaylar() {
        galleryPage.Map.click();

    }

    @When("drop down sayfa asagı iner")
    public void dropDownSayfaAsagıIner() throws InterruptedException {


        JavascriptExecutor js = (JavascriptExecutor) driver;
        long previousHeight = 0;
        while (true) {
            js.executeScript("window.scrollBy(0, 500);");
            Thread.sleep(100);
            long currentHeight = (Long) js.executeScript("return document.body.scrollHeight;");
            if (currentHeight == previousHeight) break;
            previousHeight = currentHeight;
        }
    }


    @And("haritanin görundugununu onaylar")
    public void haritaninGörundugununuOnaylar() {
        galleryPage.Map.click();
    }
}



