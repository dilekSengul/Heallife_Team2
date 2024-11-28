package StepDefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.Gallery_ContactUsPage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.DriverManager;
import utilities.JSUtilities;

import utilities.ReusableMethods;

import java.sql.Driver;
import java.util.Arrays;
import java.util.List;
import java.util.List;


public class HomePageStep {

    WebDriver driver = Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(HomePageStep.class);

    HomePage homePage = new HomePage();
    Gallery_ContactUsPage galleryContactUsPage = new Gallery_ContactUsPage();




    @Given("Kullanıcı HLurl adresini ziyaret eder")
    public void kullanıcı_h_lurl_adresini_ziyaret_eder() {
        DriverManager.getDriver().get(ConfigReader.getProperty("HLurl"));
        ReusableMethods.waitFor(2);
    }


    @And("Kullanıcı siteye başarıyla erişebildiğini doğrular")
    public void kullanici_siteye_basariyla_erisebilmelidir() {
        homePage.HLlogo.isDisplayed();
        ReusableMethods.waitFor(2);


    }

    @Given("Kullanıcı ana sayfanın footer bölümüne kaydırır")
    public void kullanıcı_ana_sayfanın_footer_bölümüne_kaydırır() {
        ReusableMethods.scrollToFooter(DriverManager.getDriver(), homePage.FacebookIkonu);
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


    @Given("Kullanıcı HealLife sitesine erişir")
    public void kullanıcı_heal_life_sitesine_erişir() {
        driver.get("https://www.youtube.com");

    }

    @Given("Url {string} girer")
    public void urlGirer(String url) {
        driver.get(ConfigReader.getProperty(url));
    }

    @Then("Anasayfa alt barinda Contact, Email ve Adress gorunurlugunu dogrular.")
    public void anasayfa_alt_barinda_contact_email_ve_adress_gorunurlugunu_dogrular() {

        JSUtilities.scrollToElement(driver, homePage.Contact);
        ReusableMethods.wait(3);
        Assert.assertTrue(homePage.Contact.isDisplayed());
        Assert.assertTrue(homePage.Email.isDisplayed());
        Assert.assertTrue(homePage.Adress.isDisplayed());
    }

    @Then("Sayfayi Kapatir")
    public void sayfayı_kapatir() {
        driver.quit();
    }

    @When("Anasayfa alt Barinda Contact'a tiklar")
    public void ansayfa_alt_barinda_contact_a_tiklar() {
        JSUtilities.scrollToElement(driver, homePage.Contact);
        ReusableMethods.wait(3);
        homePage.Contact.click();
    }

    @Then("Contact Us sayfasina yonlendirildigini dogrular")
    public void contact_us_sayfasina_yonlendirildigini_dogrular() {
        String expectedUrl = ConfigReader.getProperty("ContactUsUrl");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @When("Anasayfa alt Barinda Mail'e tiklar")
    public void anasayfa_alt_barinda_mail_e_tiklar() {
        JSUtilities.scrollToElement(driver, homePage.Email);
        ReusableMethods.wait(3);
        homePage.Email.click();
    }

    @Then("Mail'e tiklanabildigini dogrular")
    public void mail_e_tiklanabildigini_dogrular() {
        Assert.assertTrue(homePage.Adress.isEnabled());
    }

    @When("Anasayfa alt Barinda Adress'e tiklar")
    public void anasayfa_alt_barinda_adress_e_tiklar() {
        JSUtilities.scrollToElement(driver, homePage.Adress);
        ReusableMethods.wait(3);
        homePage.Adress.click();
    }

    @Then("Yonlendirilen sayfada hatitanın goruntulendigini dogrular")
    public void yonlendirilen_sayfada_hatitanın_goruntulendigini_dogrular() {
        ReusableMethods.switchWindowByUrl(driver, ConfigReader.getProperty("ContactUsUrl"));
        driver.switchTo().frame(galleryContactUsPage.iframeElement);

        Assert.assertTrue(galleryContactUsPage.MapPhoto.isDisplayed());

    }

    @And("Kullanıcı ana sayfaya yönlendirilir")
    public void kullanıcıAnaSayfayaYönlendirilir() {
    }

    @When("Kullanıcı sayfada {string} başlığını görür")
    public void kullanıcıSayfadaBaşlığınıGörür(String arg0) {
        String actualTexts= homePage.doctorstextsgets();
        Assert.assertEquals(arg0,actualTexts);
    }

    @And("Doktor isimlerini kontrol eder")
    public void doktorIsimleriniKontrolEder() {
            // Beklenen isimler
            List<String> expectedNames = Arrays.asList(
                    "Heidi Prather",
                    "Alexander C. Simotas",
                    "Kristina Marie Quirolgico",
                    "Christopher Lutz",
                    "Joel M. Press",
                    "Dena Barsoum"

            );
            Assert.assertEquals(expectedNames,homePage.getDoctorNames());
    }

    @And("Kullanıcı ünvalnarı kontrol eder")
    public void kullanıcıÜnvanlarıKontrolEder() {
        List<String> expectedUnvans = Arrays.asList(
                "Professor",
                "Professor",
                "Professor",
                "Professor",
                "Professor",
                "Professor"

        );
        Assert.assertEquals(expectedUnvans,homePage.getDoctorUnvans());
    }

    @And("Kullanıcı sayfada alt barı kontrol eder")
    public void kullanıcıSayfadaAltBarıKontrolEder() {
            List<String> expectedbars = Arrays.asList(
                    "Home",
                    "Academics",
                    "Gallery",
                    "About",
                    "Contact US",
                    "Event");
            Assert.assertEquals(expectedbars,homePage.getHomePageAltBar());
    }


    @Given("Kullanici websitesi URL'ini kullanarak ana sayfaya gider")
    public void kullanici_websitesi_url_ini_kullanarak_ana_sayfaya_gider() {

        driver.get(ConfigReader.getProperty("HLurl"));

    }
    @When("Kullanıcı ana sayfadaki slider'i göruntuler")
    public void kullanıcı_ana_sayfadaki_slider_i_göruntuler() {


    }

    @And("Kullanici ana sayfada slider'da otomatik olarak degisen resimleri goruntuler")
    public void kullaniciAnaSayfadaSliderDaOtomatikOlarakDegisenResimleriGoruntuler() {
        
    }

    @When("Kullanici ana sayfada slider gecis ikonuna tiklar")
    public void kullaniciAnaSayfadaSliderGecisIkonunaTiklar() {
        
    }

    @And("Kullanici bu ikona tiklayarak tum gorselleri manuel olarak degistigini gozlemler")
    public void kullaniciBuIkonaTiklayarakTumGorselleriManuelOlarakDegistiginiGozlemler() {

    }

    @Given("Kullanıcı {string} sitesine gider")
    public void kullanıcı_sitesine_gider(String url) {
        DriverManager.getDriver().get(ConfigReader.getProperty(url));
        logger.info("Kullanıcı sitesine gidiyor: " + url);
    }

    @When("Kullanıcı bulunduğu URL ile belirlenmiş URL'yi doğrular")
    public void kullanıcı_bulunduğu_url_ile_belirlenmiş_url_yi_doğrular() {
        String expectedUrl = ConfigReader.getProperty("HLurl");
        String currentUrl = DriverManager.getDriver().getCurrentUrl();

        if (expectedUrl.equals(currentUrl)) {
            logger.info("Kullanıcı bulunduğu URL ile belirlenmiş URL doğru.");
        } else {
            logger.error("Kullanıcı bulunduğu URL ile belirlenmiş URL değil.");
        }
    }

    @Then("Kullanıcı site başlığının {string} olduğunu doğrular")
    public void kullanıcı_site_başlığının_olduğunu_doğrular(String title) {
        String actualTitle = DriverManager.getDriver().getTitle();

        if (title.equals(actualTitle)) {
            logger.info("Site başlığı beklenen ile aynı");
        } else {
            logger.error("Site başlığı yanlış!");
        }
    }

    @Then("Kullanıcı Heal Life sitesinin logosunu görebilmelidir")
    public void kullanıcı_heal_life_sitesinin_logosunu_görebilmelidir() {
        Assert.assertTrue(homePage.HLlogo.isDisplayed());
        Assert.assertTrue(homePage.HLlogo.isDisplayed());
    }

    @When("Kullanıcı browser kapatır")
    public void kullanıcı_browser_kapatır() {
        DriverManager.quitDriver();
        logger.info("Browser kapatıldı.");
    }

    @And("Kullanıcı bir hata mesajı görmelidir")
    public void kullanıcıBirHataMesajıGörmelidir() {
        Assert.assertTrue(homePage.errorMessage.isDisplayed());
        logger.info("Kullanıcı bir hata mesajı gördu ):");
    }

    @When("Kullanıcı Header Bölümünden {string} sayfasına gider")
    public void kullanıcı_header_bölümünden_sayfasına_gider(String sayfa) {
        ReusableMethods.HeaderAccessibility(sayfa, logger);
    }

    @Then("Kullanıcı URL'in {string} sayfasında olduğunu doğrular")
    public void kullanıcı_url_in_sayfasında_olduğunu_doğrular(String url) {
        String URL = "https://qa.heallifehospital.com/page/" + url;
        Assert.assertEquals(URL, DriverManager.getDriver().getCurrentUrl());
        logger.info("Kullanıcı +" + url + " sayfasına ulaştı.");
    }

    @Then("Kullanıcı site içerisinde {string} yazısını görebilmelidir")
    public void kullanıcı_site_içerisinde_yazısını_görebilmelidir(String string) {
        if (homePage.GalleryTitle.getText().contains(string)) {
            logger.info("Kullanıcı site içerisinde " + string + " yazısını gordu.");
        } else {
            logger.error("Kullanıcı site içerisinde " + string + " bulunamadı!");
        }
    }

    @When("Kullanıcı Footer Bölümünden {string} sayfasına gider")
    public void kullanıcı_footer_bölümünden_sayfasına_gider(String sayfa) {
        ReusableMethods.FooterAccessibility(sayfa, logger);
    }

    @Then("Kullanıcı site içerisinde Resimlerin ve Başlıklarının olmasını istiyorum")
    public void kullanıcı_site_içerisinde_resimlerin_ve_başlıklarının_olmasını_istiyorum() {
        for (int i = 0; i < homePage.GalleryResimler.size(); i++) {
            Assert.assertTrue(homePage.GalleryResimler.get(i).isDisplayed());
        }
        logger.info("Gallery Resimler göründü.");

        for (int i = 0; i < homePage.GalleryBasliklar.size(); i++) {
            Assert.assertTrue(homePage.GalleryBasliklar.get(i).isDisplayed());
        }
        logger.info("Gallery Basliklar görünüyor.");
    }

    @Then("Kullanıcı Gallery sayfasında {string} adet içerik bulunmalıdır")
    public void kullanıcı_gallery_sayfasında_adet_içerik_bulunmalıdır(String sayi) {
        ReusableMethods.wait(3);

        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollBy(0, 300);");

        ReusableMethods.wait(3);

        if (homePage.GalleryResimler.size() == Integer.parseInt(sayi)) {
            logger.info("Kullanıcı Gallery sayfasında " + sayi + " adet içerik bulundu.");
        } else {
            logger.error("Kullanıcı Gallery sayfasında " + sayi + " adet içerik bulunamadı!");
        }
    }

    @Then("Kullanıcı Gallery sayfasının URL, Title ve içeriğinin doğru olduğunu doğrular")
    public void kullanıcıGallerySayfasınınURLTitleVeIçeriğininDoğruOlduğunuDoğrular() {
        for (int i = 0; i < 6; i++) {

            if (i == 0) {
                homePage.GalleryResimler.get(i).click();
                logger.info("Kullanıcı Health Wellness sayfasına gider.");
                Assert.assertEquals("https://qa.heallifehospital.com/read/health-wellness", DriverManager.getDriver().getCurrentUrl());
                logger.info("Kullanıcı Health Wellness sayfasına ulaştı.");
                Assert.assertEquals(DriverManager.getDriver().getTitle(), homePage.GallerySubTitle1.getText());
                logger.info("Kullanıcı Gallery sayfasının Title'i " + homePage.GallerySubTitle1.getText() + " oldu.");
                DriverManager.getDriver().navigate().back();
            }

            if (i == 1) {
                homePage.GalleryResimler.get(i).click();
                logger.info("Kullanıcı Hospitals and Directions sayfasına gider.");
                Assert.assertEquals("https://qa.heallifehospital.com/read/hospitals-and-directions", DriverManager.getDriver().getCurrentUrl());
                logger.info("Kullanıcı Hospitals and Directions sayfasına ulaştı.");
                Assert.assertEquals(DriverManager.getDriver().getTitle(), homePage.GallerySubTitle2.getText());
                logger.info("Kullanıcı Gallery sayfasının Title'i " + homePage.GallerySubTitle2.getText() + " oldu.");
                DriverManager.getDriver().navigate().back();
            }

            if (i == 2) {
                homePage.GalleryResimler.get(i).click();
                logger.info("Kullanıcı Health Specialities sayfasına gider.");
                Assert.assertEquals("https://qa.heallifehospital.com/read/specialities", DriverManager.getDriver().getCurrentUrl());
                logger.info("Kullanıcı Health Specialities sayfasına ulaştı.");
                Assert.assertEquals(DriverManager.getDriver().getTitle(), homePage.GallerySubTitle3.getText());
                logger.info("Kullanıcı Gallery sayfasının Title'i " + homePage.GallerySubTitle3.getText() + " oldu.");
                ReusableMethods.wait(2);
                DriverManager.getDriver().navigate().back();
            }

            if (i == 3) {
                JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
                js.executeScript("window.scrollBy(0, 200);");
                homePage.GalleryResimler.get(i).click();
                logger.info("Kullanıcı Recreation Centre sayfasına gider.");
                Assert.assertEquals("https://qa.heallifehospital.com/read/recreation-centre", DriverManager.getDriver().getCurrentUrl());
                logger.info("Kullanıcı Recreation Centre sayfasına ulaştı.");
                Assert.assertEquals(DriverManager.getDriver().getTitle(), homePage.GallerySubTitle4.getText());
                logger.info("Kullanıcı Gallery sayfasının Title'i " + homePage.GallerySubTitle4.getText() + " oldu.");
                DriverManager.getDriver().navigate().back();
            }

            if (i == 4) {
                homePage.GalleryResimler.get(i).click();
                logger.info("Kullanıcı Your Health sayfasına gider.");
                Assert.assertEquals("https://qa.heallifehospital.com/read/your-health", DriverManager.getDriver().getCurrentUrl());
                logger.info("Kullanıcı Your Health sayfasına ulaştı.");
                Assert.assertEquals(DriverManager.getDriver().getTitle(), homePage.GallerySubTitle5.getText());
                logger.info("Kullanıcı Gallery sayfasının Title'i " + homePage.GallerySubTitle5.getText() + " oldu.");
                DriverManager.getDriver().navigate().back();
            }

            if (i == 5) {
                homePage.GalleryResimler.get(i).click();
                logger.info("Kullanıcı Surgery sayfasına gider.");
                Assert.assertEquals("https://qa.heallifehospital.com/read/surgery", DriverManager.getDriver().getCurrentUrl());
                logger.info("Kullanıcı Surgery sayfasına ulaştı.");
                Assert.assertEquals(DriverManager.getDriver().getTitle(), homePage.GallerySubTitle6.getText());
                logger.info("Kullanıcı Gallery sayfasının Title'i " + homePage.GallerySubTitle6.getText() + " oldu.");
                DriverManager.getDriver().navigate().back();
            }
        }
    }



    @Given("Browser aç ve HLurl adersine git")
    public void browser_aç_ve_h_lurl_adersine_git() {
        DriverManager.getDriver().get(ConfigReader.getProperty("HLurl"));

    }
    @When("Sayfayı kaydır")
    public void sayfayı_kaydır() {
        JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",homePage.InsurancePlans);

    }
    @When("Insurance Plans görünür olduğunu doğrula")
    public void ınsurance_plans_görünür_olduğunu_doğrula() {
        Assert.assertTrue(homePage.InsurancePlans.isDisplayed());

    }
    @When("Pediatric Services görünür olduğunu doğrula")
    public void pediatric_services_görünür_olduğunu_doğrula() {
        Assert.assertTrue(homePage.PediatricServices.isDisplayed());

    }
    @Then("Lab Testing görünür olduğunu doğrula")
    public void lab_testing_görünür_olduğunu_doğrula() {
        Assert.assertTrue(homePage.LabTesting.isDisplayed());

    }
    @Then("Sayfayı kapat")
    public void sayfayı_kapat() {
        DriverManager.quitDriver();
    }

    @When("Insurance Plans altında read more butonuna tıkla")
    public void ınsurance_plans_altında_read_more_butonuna_tıkla() {
        homePage.ReadMoreInsurancePlans.click();
        ReusableMethods.bekle(2);

    }
    @When("Açılan sayfada Insurance Plans text'i görünür olduğunu doğrula")
    public void açılan_sayfada_ınsurance_plans_text_i_görünür_olduğunu_doğrula() {
        Assert.assertTrue(homePage.BaslikInsurancePlans.isDisplayed());

    }
    @Then("Geri git")
    public void geri_git() {
        DriverManager.getDriver().navigate().back();
        ReusableMethods.bekle(2);

    }
    @Then("Pediatric Services altında read more butonuna tıkla")
    public void pediatric_services_altında_read_more_butonuna_tıkla() {
        homePage.ReadMorePediatricServices.click();
        ReusableMethods.bekle(1);

    }
    @Then("Our Pediatric Services: text'i görünür olduğunu doğrula")
    public void our_pediatric_services_text_i_görünür_olduğunu_doğrula() {
        Assert.assertTrue(homePage.BaslikPediatricServices.isDisplayed());

    }
    @Then("Lab Texting altında read more butonuna tıkla")
    public void lab_texting_altında_read_more_butonuna_tıkla() {
        homePage.ReadMoreLabTesting.click();
        ReusableMethods.bekle(1);

    }
    @Then("Lab Texting Services text'i görünür olduğunu doğrula")
    public void lab_texting_services_text_i_görünür_olduğunu_doğrula() {
        Assert.assertTrue(homePage.BaslikLabTesting.isDisplayed());

    }

    @Then("Featured Services görünür olduğunu doğrula")
    public void featured_services_görünür_olduğunu_doğrula() {
      Assert.assertTrue(homePage.FeaturedServicesYazisi.isDisplayed());
    }
    @Then("Medical Treatment görünür olduğunu doğrula")
    public void medical_treatment_görünür_olduğunu_doğrula() {
        String expectedBaslik = "Medical Treatment";
        String actualBaslik = homePage.FSbirinciBaslik.getText();
        Assert.assertEquals(expectedBaslik,actualBaslik);

    }
    @Then("Emergency Help görünür olduğunu doğrula")
    public void emergency_help_görünür_olduğunu_doğrula() {
        String expectedBaslik = "Emergency Help";
        String actualBaslik = homePage.FSikinciBaslik.getText();
        Assert.assertEquals(expectedBaslik,actualBaslik);

    }
    @Then("Qualified Doctors görünür olduğunu doğrula")
    public void qualified_doctors_görünür_olduğunu_doğrula() {
        String expectedBaslik = "Qualified Doctors";
        String actualBaslik = homePage.FSucuncuBaslik.getText();
        Assert.assertEquals(expectedBaslik,actualBaslik);

    }
    @Then("Medical professionals görünür olduğunu doğrula")
    public void medical_professionals_görünür_olduğunu_doğrula() {
        String expectedBaslik = "Medical professionals";
        String actualBaslik = homePage.FSdorduncuBaslik.getText();
        Assert.assertEquals(expectedBaslik, actualBaslik);
    }

    @Then("Latest News bilgisinin ust barda kayan bir yazi olarak gorunur oldugunu dogrular")
    public void latest_news_kayan_yazi_oldugunu_dogrular() {
        WebElement latestNewsElement = homePage.lastestNewsKayanYaziIcerik;

        // Elementin görünür olduğunu kontrol et
        Assert.assertTrue(latestNewsElement.isDisplayed());

        // Elementin pozisyonunun zaman içinde değişip değişmediğini kontrol et
        Point initialLocation = latestNewsElement.getLocation(); //başlangıç pozunu kaydeder.
        try {
            Thread.sleep(3000); // Yazının kaymasını bekle
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Point newLocation = latestNewsElement.getLocation(); //guncel poz.
        
        Assert.assertNotEquals(initialLocation, newLocation); //pointler eşleşmezse bar hareket ediyor demek.
    }

    @And("sitenin logosunun ust barda gorundugunu dogrular")
    public void siteninLogosununUstBardaGorundugunuDogrular() {
        homePage.HLlogo.isDisplayed();
    }

    @And("ust barda asagidaki menu ogelerinin gorundugunu dogrular:")
    public void ustBardaAsagidakiMenuOgelerininGorundugunuDogrular(List<String> expectedNavbarElements) {
        List<String> actualNavbarElements = homePage.getNavbarElements();
        Assertions.assertEquals(expectedNavbarElements, actualNavbarElements, "Items do not match!");
    }

    @When("kullanici site logosuna tiklar")
    public void kullaniciSiteLogosunaTiklar() {
        homePage.HLlogo.click();
    }

    @Then("ana sayfanin yenilendigini ve URL’nin degismedigini dogrular")
    public void anaSayfaninYenilendiginiVeURLNinDegismediginiDogrular() {
        Assert.assertEquals("https://qa.heallifehospital.com/", driver.getCurrentUrl());
    }

    @Then("Home secenegine tikladiginda ana sayfaya yonlendigini dogrular")
    public void homeSecenegineTikladigindaAnaSayfayaYonlendiginiDogrular() {
        homePage.Home.click();
        String expectedUrl = ConfigReader.getProperty("HomeButtonUrl");
        Assert.assertEquals("Ana sayfa URL eşleşmiyor!", expectedUrl, driver.getCurrentUrl());
    }

    @And("Appointment secenegine tikladiginda Appointment sayfasina yonlendigini dogrular")
    public void appointmentSecenegineTikladigindaAppointmentSayfasinaYonlendiginiDogrular() {
        homePage.Appointment.click();
        String expectedUrl = ConfigReader.getProperty("AppointmentButtonUrl");
        Assert.assertEquals("Appointment sayfa URL eşleşmiyor!", expectedUrl, driver.getCurrentUrl());

    }




    /*Element yok (Events) - bug sebebi - US02 Scenario: Menu navigasyon islev testi
    @And("Events secenegine tikladiginda Events sayfasina yonlendigini dogrular")

    public void eventsSecenegineTikladigindaEventsSayfasinaYonlendiginiDogrular() {
        homePage.Events.click();
        String expectedUrl = ConfigReader.getProperty("EventsButtonUrl");
        Assert.assertEquals("Appointment sayfa URL eşleşmiyor!", expectedUrl, driver.getCurrentUrl());
    }*/

    @And("About Us secenegine tikladiginda About Us sayfasina yonlendigini dogrular")
    public void aboutUsSecenegineTikladigindaAboutUsSayfasinaYonlendiginiDogrular() {
        homePage.AboutUs.click();
        String expectedUrl = ConfigReader.getProperty("AboutUsButtonUrl");
        Assert.assertEquals("About Us sayfa URL eşleşmiyor!", expectedUrl, driver.getCurrentUrl());
    }

    @And("Gallery secenegine tikladiginda Gallery sayfasina yonlendigini dogrular")
    public void gallerySecenegineTikladigindaGallerySayfasinaYonlendiginiDogrular() {
        homePage.Gallery.click();
        String expectedUrl = ConfigReader.getProperty("GalleryButtonUrl");
        Assert.assertEquals("Gallery sayfa URL eşleşmiyor!", expectedUrl, driver.getCurrentUrl());
    }

    @And("Contact Us secenegine tikladiginda Contact Us sayfasina yonlendigini dogrular")
    public void contactUsSecenegineTikladigindaContactUsSayfasinaYonlendiginiDogrular() {
        homePage.ContactUs.click();
        String expectedUrl = ConfigReader.getProperty("ContactUsButtonUrl");
        Assert.assertEquals("Contact Us sayfa URL eşleşmiyor!", expectedUrl, driver.getCurrentUrl());

    }


}


