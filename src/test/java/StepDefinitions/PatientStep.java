package StepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.LoginPage;
import pages.PatientPage;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.util.HashMap;
import java.util.Map;

public class PatientStep {
    WebDriver driver = Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(HLhomeStep.class);
    PatientPage page = new PatientPage(); // Page Object sınıfınız
    LoginPage loginPage = new LoginPage();
    Faker faker = new Faker();


    @Given("Kullanici anasayfaya gider")
    public void kullanici_anasayfaya_gider() {

        driver.get(ConfigReader.getProperty("HLurl"));
        logger.info("Kullanici Anasayafa gider");

    }


    @When("Kullanici Appointment sekmesine tiklar")
    public void kullaniciAppointmentSekmesineTiklar() {
        page.appointmentButton.click();
    }

    @Then("Kullanici Appointment sayfasinin acildigini dogrular")
    public void kullaniciAppointmentSayfasininAcildiginiDogrular() {

        String expectedUrl = "https://qa.heallifehospital.com/form/appointment";
        String actualUrl = driver.getCurrentUrl();
    }

    @And("Kullanici gerekli bilgileri \\(bolum, doktor, tarih, notlar) girer")
    public void kullaniciGerekliBilgileriBolumDoktorTarihNotlarGirer() {
        Select specialist = new Select(page.specialistDDM);
        ReusableMethods.wait(2);

        specialist.selectByValue("1");
        ReusableMethods.wait(2);

        Select doctorDDM = new Select(page.doctorDDM);
        ReusableMethods.wait(2);

        doctorDDM.selectByValue("786");
        ReusableMethods.wait(2);

        Actions actions = new Actions(driver);
        actions.moveToElement(page.shiftBox).click().perform();
        page.shiftsearchbox.sendKeys("Morning");
        page.shiftsearchbox.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        page.datebox.click();
        ReusableMethods.wait(2);
        page.datebox.sendKeys(Keys.DELETE);
        ReusableMethods.wait(2);
        page.datebox.sendKeys("29.11.2024");
        ReusableMethods.wait(2);
        page.messageBoxElementi.sendKeys(faker.backToTheFuture().quote());
        ReusableMethods.wait(2);


    }

    @And("Kullanici zaman araligini ve saati secer")
    public void kullaniciZamanAraliginiVeSaatiSecer() {


        page.slotButton.click();
        ReusableMethods.wait(2);
        page.slot9_00.click();


    }

    @And("Kullanici hasta bilgilerini \\(isim, email, cinsiyet, telefon) girer")
    public void kullaniciHastaBilgileriniIsimEmailCinsiyetTelefonGirer() {
        page.patientNameBox.sendKeys("John Doe");
        ReusableMethods.wait(1);
        page.Emaileboxelementi.sendKeys("niko@niko.com");
        ReusableMethods.wait(1);
        page.phoneboxElementi.sendKeys("5321002020");
        ReusableMethods.getFullScreenshot(driver);

    }

    @When("Kullanici Submit tusuna basar")
    public void kullaniciSubmitTusunaBasar() {
        page.SubmitButtonElementi.click();
        ReusableMethods.wait(5);
        ReusableMethods.getFullScreenshot(driver);

    }

    @Then("Kullanici Patient Portal yonlendirildigini dogrular")
    public void kullaniciPatientPortalYonlendirildiginiDogrular() {
        ReusableMethods.wait(1);
        String expectedUrl = "https://qa.heallifehospital.com/patient/dashboard/appointment";
        String actualUrl = driver.getCurrentUrl();
    }

    @And("Kullanici sayfayi kapatir")
    public void kullaniciSayfayiKapatir() {
        driver.quit();
    }


    @And("Kullaniciya eksik veya hatali bilgi icin Lutfen tum alanlari doldurun seklinde bir hata mesaji gosterilir.")
    public void kullaniciyaEksikVeyaHataliBilgiIcinLutfenTumAlanlariDoldurunSeklindeBirHataMesajiGosterilir() {
        ReusableMethods.wait(1);
        Assert.assertTrue(page.falseErrorMsg.isDisplayed());
    }


    @And("Kullanici hasta bilgilerini \\(isim, email, cinsiyet, gecersiztelefon) girer")
    public void kullaniciHastaBilgileriniIsimEmailCinsiyetGecersiztelefonGirer() {
        page.patientNameBox.sendKeys(faker.funnyName().name());
        ReusableMethods.wait(1);
        page.Emaileboxelementi.sendKeys(faker.internet().emailAddress());
        ReusableMethods.wait(1);
        page.phoneboxElementi.sendKeys(faker.phoneNumber().cellPhone());
        ReusableMethods.getFullScreenshot(driver);
    }

    @And("Kullanici randevu olusturmadigini dogrular")
    public void kullaniciRandevuOlusturmadiginiDogrular() {
        ReusableMethods.wait(1);
        Assert.assertTrue(page.falseErrorMsg.isDisplayed());

    }

    // US_026-TC_01
    // Hasta giriş adımı
    @Given("loginButton'una tıklayarak kullanıcı adı ve şifresi ile hasta olarak giriş yapar")
    public void login_button_una_tıklayarak_kullanıcı_adı_ve_şifresi_ile_hasta_olarak_giriş_yapar() {
        loginPage.hastaLogin();
    }


    // Özet bilgi panellerinin doğrulama ve her birine tıklama adımı
    @Then("Kullanıcı aşağıdaki özet bilgi panellerinin hasta dashboard'da mevcut olduğunu doğrular ve her birine tıklayıp ilgili sayfaya gider")
    public void kullanıcı_aşağıdaki_özet_bilgi_panellerinin_hasta_dashboard_da_mevcut_olduğunu_doğrular_ve_her_birine_tıklayıp_ilgili_sayfaya_gider(io.cucumber.datatable.DataTable dataTable) {

        // Paneller ve ilgili URL'lerin eşleştirilmesi
        Map<String, String> boardUrls = new HashMap<>();
        boardUrls.put("OPD", "https://qa.heallifehospital.com/patient/dashboard/profile");
        boardUrls.put("IPD", "https://qa.heallifehospital.com/patient/dashboard/patientipddetails");
        boardUrls.put("Pharmacy", "https://qa.heallifehospital.com/patient/dashboard/pharmacybill");
        boardUrls.put("Pathology", "https://qa.heallifehospital.com/patient/dashboard/pathology");
        boardUrls.put("Radiology", "https://qa.heallifehospital.com/patient/dashboard/radiology");
        boardUrls.put("Ambulance", "https://qa.heallifehospital.com/patient/dashboard/ambulance");
        boardUrls.put("Blood Bank", "https://qa.heallifehospital.com/patient/dashboard/bloodbank");
        boardUrls.put("Live Consultation", "https://qa.heallifehospital.com/patient/dashboard/liveconsult");
        // Her bir özet panelinin görünür olduğunu doğrulama
        for (String boardName : dataTable.asList()) {
            WebElement board = page.getBoardElementByName(boardName);  // Panelleri almak için yardımcı metod çağrılıyor
            Assert.assertTrue(boardName + " paneli görüntülenmiyor.", board.isDisplayed());  // Panelin görünür olduğunu doğruluyor

            // Panelleri tıklama ve yönlendirilen sayfayı doğrulama
            board.click();
            String currentUrl = driver.getCurrentUrl();  // Mevcut URL alınıyor


            //Assert.assertTrue( boardName + " için yanlış sayfaya yönlendirilmiş.",currentUrl,boardUrls.get(boardName));
            //Assert.assertEquals(currentUrl, boardUrls.get(boardName), boardName + " için yanlış sayfaya yönlendirilmiş."); // Doğru URL ile karşılaştırma yapılıyor
           // Assert.assertTrue(boardName + " için yanlış sayfaya yönlendirilmiş. Beklenen: " + boardUrls.get(boardName) + ", Mevcut: " + currentUrl, currentUrl.equals(boardUrls.get(boardName)));
        }


    }

}

