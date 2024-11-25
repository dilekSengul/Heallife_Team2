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
import pages.PatientDashboardPage;
import pages.PatientPage;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.util.List;
import java.util.NoSuchElementException;

public class PatientStep {
    WebDriver driver = Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(PatientStep.class);
    PatientPage page = new PatientPage(); // Page Object sınıfınız
    LoginPage loginPage = new LoginPage();
    Faker faker = new Faker();
    PatientDashboardPage patientDashboardPage=new PatientDashboardPage();

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
    // Hasta giriş adımı-Özet bilgi panellerinin görünürlüğünü ve işlevselliğini doğrulama
    @Given("loginButton'una tıklayarak kullanıcı adı ve şifresi ile hasta olarak giriş yapar")
    public void login_button_una_tıklayarak_kullanıcı_adı_ve_şifresi_ile_hasta_olarak_giriş_yapar() {
        loginPage.hastaLogin();
    }


    // Özet bilgi panellerinin doğrulama ve her birine tıklama adımı
    @Then("Kullanıcı aşağıdaki özet bilgi panellerinin hasta dashboard'da mevcut olduğunu doğrular ve her birine tıklayıp ilgili sayfaya gider")
    public void kullanıcı_aşağıdaki_özet_bilgi_panellerinin_hasta_dashboard_da_mevcut_olduğunu_doğrular_ve_her_birine_tıklayıp_ilgili_sayfaya_gider(io.cucumber.datatable.DataTable dataTable) {


        // Her bir özet panelinin görünür olduğunu doğrulama
        for (String boardName : dataTable.asList()) {
            WebElement board = patientDashboardPage.getBoardElementByName(boardName);  // Panelleri almak için yardımcı metod çağrılıyor
            Assert.assertTrue(boardName + " paneli görüntülenmiyor.", board.isDisplayed());  // Panelin görünür olduğunu doğruluyor

            // Panelleri tıklama ve yönlendirilen sayfayı doğrulama
            board.click();
            ReusableMethods.wait(1);
            String currentUrl = driver.getCurrentUrl();  // Mevcut URL alınıyor
            // Mevcut URL'nin beklenen URL ile eşleştiğini doğrulama
            Assert.assertTrue(
                boardName + " için yanlış sayfaya yönlendirilmiş. Beklenen: " + patientDashboardPage.getBoardUrls().get(boardName) + ", Mevcut: " + currentUrl, // Hata mesajı
                currentUrl.equals(patientDashboardPage.getBoardUrls().get(boardName)));


            // Dashboard sayfasına geri dön
            driver.navigate().back();


        }
    }

    // HATA VAR US_026-TC_02-Medical History grafiğinin görünürlüğünü ve değerlerini doğrula HATA VAR
    @Then("Dashboard sayfasının gövdesinde {string} başlıklı bir grafik bulunduğunu doğrular")
    public void dashboard_sayfasının_gövdesinde_başlıklı_bir_grafik_bulunduğunu_doğrular(String string) {
        patientDashboardPage.medicalHistoryGraph.isDisplayed();
    }

    @Then("Aşağıdaki değerlerin grafikte yer aldığını kontrol eder:")
    public void aşağıdaki_değerlerin_grafikte_yer_aldığını_kontrol_eder(io.cucumber.datatable.DataTable dataTable) {
        // Değerleri liste olarak al
        List<String> expectedValues = dataTable.asList();

        for (String value : expectedValues) {
            WebElement valueElement = getValueElementByName(value);  // Helper method to return the correct element based on value
            Assert.assertTrue(value + " değeri grafikte yer almıyor.", valueElement.isDisplayed());


        }
    }

    // Yardımcı metod, doğru elementi seçer
    public WebElement getValueElementByName(String value) {
        switch (value) {
            case "OPD":
                return patientDashboardPage.opdValue;
            case "IPD":
                return patientDashboardPage.ipdValue;
            case "Pharmacy":
                return patientDashboardPage.pharmacyValue;
            case "Pathology":
                return patientDashboardPage.pathologyValue;
            case "Radiology":
                return patientDashboardPage.radiologyValue;
            case "Blood Bank":
                return patientDashboardPage.bloodBankValue;
            case "Ambulance":
                return patientDashboardPage.ambulanceValue;
            default:
                throw new NoSuchElementException("Değer için element bulunamadı: " + value);
        }
    }

    // US_026-TC_03

    @When("Belirtiler  için özet grafiklerin sayfada mevcut olduğunu doğrular")
    public void belirtiler_için_özet_grafiklerin_sayfada_mevcut_olduğunu_doğrular() {
        Assert.assertTrue("Belirtiler için özet grafik sayfada mevcut değil!", patientDashboardPage.belirtilerGrafik.isDisplayed());
    }

    @Then("Semptomlar için özet grafiklerin sayfada mevcut olduğunu doğrular")
    public void semptomlar_için_özet_grafiklerin_sayfada_mevcut_olduğunu_doğrular() {
        Assert.assertTrue("Semptomlar için özet grafik sayfada mevcut değil!", patientDashboardPage.semptomlarGrafik.isDisplayed());

    }


}

