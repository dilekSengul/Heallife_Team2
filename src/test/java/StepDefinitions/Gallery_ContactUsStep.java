package StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Gallery_ContactUsPage;
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



}
