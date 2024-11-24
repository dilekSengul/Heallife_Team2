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

    @When("Kullanici contact_us linkine tiklar")
    public void kullanici_contact_us_linkine_tiklar() {

    }

    @Then("Kullanici contact_us sayfasina yonlendirilir")
    public void kullanici_contact_us_sayfasina_yonlendirilir() {

    }

    @Then("Kullanici Ad-Soyad textBox goruntelendigini dogrular")
    public void kullanici_ad_soyad_text_box_goruntelendigini_dogrular() {

    }

    @Then("Kullanici E-posta textBox goruntelendigini dogrular")
    public void kullanici_e_posta_text_box_goruntelendigini_dogrular() {

    }

    @Then("Kullanici Konu textBox goruntelendigini dogrular")
    public void kullanici_konu_text_box_goruntelendigini_dogrular() {

    }

    @Then("Kullanici Mesaj textBox goruntelendigini dogrular")
    public void kullanici_mesaj_text_box_goruntelendigini_dogrular() {

    }

    @Then("Kullanici Gonder butonu goruntelendigini dogrular")
    public void kullanici_gonder_butonu_goruntelendigini_dogrular() {

    }

    @Then("Kullanici Contact Us sayfasinin alt kisminda hastanenin lokasyonunu gosteren bir haritayi goruntuler")
    public void kullanici_contact_us_sayfasinin_alt_kisminda_hastanenin_lokasyonunu_gosteren_bir_haritayi_goruntuler() {

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
