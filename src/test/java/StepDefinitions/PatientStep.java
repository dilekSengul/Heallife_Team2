package StepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.PatientDashboardPage;
import pages.PatientPage;
import utilities.ConfigReader;
import utilities.DriverManager;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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


    @Given("kullanici URL'i acar")
    public void kullanici_url_i_acar() {
    DriverManager.getDriver().get(ConfigReader.getProperty("HLuserUrl"));
    ReusableMethods.waitFor(2);

    }

    @Given("kullanıcı {string} ve {string} ile giriş yapar")
    public void kullanıcı_ve_ile_giriş_yapar(String username, String password) {
        loginPage.email.sendKeys(ConfigReader.getProperty("HLusername"));
       ReusableMethods.wait(1);
        loginPage.password.sendKeys(ConfigReader.getProperty("HLpassword"));
        ReusableMethods.wait(1);

    }
    @Then("{string} sayfasinin goruntulendigini dogrular")
    public void sayfasinin_goruntulendigini_dogrular(String Dashboard) {
        page.DashboardText.isDisplayed();
    }
    @When("kullanici sol menuden Radiology secenegine tiklar")
    public void kullanici_sol_menuden_Radiology_secenegine_tiklar() {
        page.PatientDashboardRadiologyButton.click();
    }

    @When("Sign In butonuna tıklanır")
    public void giris_butonuna_tiklanir() {
       loginPage.signInButton.click();

        ReusableMethods.wait(3);
   }
    @Then("dashboard duzgun bir şekilde goruntuler")
    public void ana_sayfa_duzgun_bir_sekilde_goruntuler() {
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));

    }
    @Given("hasta Radyology Test Reports List sayfasına gider")
    public void hasta_radyology_test_reports_list_sayfasına_gider() {
        ReusableMethods.wait(2);
        Assert.assertTrue("Radiology Test Reports List sayfası açılmadı!",
                page.RadiologyTestReportText.isDisplayed());
    }

    @Then("asagidaki baslıklarin gorunur oldugunu dogrular")
    public void asagidaki_baslıklarin_gorunur_oldugunu_dogrular(io.cucumber.datatable.DataTable dataTable) {
        List<String> headers = dataTable.asList();

        Map<String, WebElement> headerMap = new HashMap<>();
        headerMap.put("Bill No", page.BillNo);
        headerMap.put("Case ID", page.CaseID);
        headerMap.put("Reporting Date", page.ReportingDate);
        headerMap.put("Reference Doctor", page.ReferanceDoctor);
        headerMap.put("Note", page.NotHeader);
        headerMap.put("Amount", page.AmountHeader);
        headerMap.put("Paid Amount", page.PaidAmountHeader);
        headerMap.put("Balance Amount", page.BalanceAmountHeader);
        headerMap.put("Action", page.ActionHeader);

        for (String header : headers) {
            Assert.assertTrue(header + " başlığı görünmüyor!",
                    headerMap.get(header).isDisplayed());
        }
    }


  //  @Given("hasta Radyology Test Reports Listesi sayfasina gider")
  //    loginPage.hastaLogin();
  //  }

    @When("hasta bir arama terimi girer")
    public void hasta_bir_arama_terimi_girer() {
        page.SearchButton.sendKeys("Test Search Term");
        page.SearchButton.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
    }

    @Then("sonuclarin girilen arama terimiyle eslesen sekilde goruntulendigini dogrular")
    public void sonuclarin_girilen_arama_terimiyle_eslesen_sekilde_goruntulendigini_dogrular() {
        String searchResultText = page.ListelenenKAyitSayisiText.getText();
        Assert.assertTrue("Arama sonucu eşleşmiyor!",
                searchResultText.contains("Test Search Term"));
    }

    @Given("hasta Radyology Test Reports sayfasina gider")
    public void hasta_radyology_test_reports_sayfasina_gider() {

    }

    @When("hasta bir baslık uzerine tiklar")
    public void hasta_bir_baslık_uzerine_tiklar() {
        page.BillNo.click();
        ReusableMethods.wait(1);
    }

    @Then("liste artan sirada siralanmalidir")
    public void liste_artan_sirada_siralanmalidir() {
//        // Sıralama doğrulama mantığı eklenebilir, örneğin tabloda değer kontrolü.
//        Assert.assertTrue("Liste artan sırada sıralanmadı!",
//                ReusableMethods.isSortedAscending(page.BillNo));

        List<WebElement> billNoElements = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));

        // Sıralama kontrolü
        Assert.assertTrue("Liste artan sırada sıralanmadı!",
                ReusableMethods.isSortedAscending(billNoElements));
    }

    @When("hasta aynı başlık uzerine tekrar tiklar")
    public void hasta_aynı_başlık_uzerine_tekrar_tiklar() {
        page.BillNo.click();
        ReusableMethods.wait(1);
    }

    @Then("listenin azalan sirada siralandigini dogrular")
    public void listenin_azalan_sirada_siralandigini_dogrular() {
//        // Sıralama doğrulama mantığı eklenebilir, örneğin tabloda değer kontrolü.
//        Assert.assertTrue("Liste azalan sırada sıralanmadı!",
//                ReusableMethods.isSortedDescending(page.BillNo));
        List<WebElement> billNoElements = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));

        // Sıralama kontrolü
        Assert.assertTrue("Liste artan sırada sıralanmadı!",
                ReusableMethods.isSortedDescending(billNoElements));
    }

    @Given("Radyology Test Reports sayfasına gider")
    public void radyology_test_reports_sayfasına_gider() {

    }

    @Then("{string} baglantisinin her rapor icin mevcut oldugunu dogrular")
    public void baglantisinin_her_rapor_icin_mevcut_oldugunu_dogrular(String string) {

    }
    @When("hasta {string} baglantısına tıklar")
    public void hasta_baglantısına_tıklar(String string) {

    }

    @Then("bir modal pencere ödeme detaylarıyla acilir")
    public void bir_modal_pencere_ödeme_detaylarıyla_acilir() {

    }

    @Then("modal penceresinin {string} butonunu icerdigini dogrular")
    public void modal_penceresinin_butonunu_icerdigini_dogrular(String string) {

    }

    @When("hasta {string} butonuna tiklar")
    public void hasta_butonuna_tiklar(String menuName) {
        WebElement menu = driver.findElement(By.xpath("//a[contains(text(),'" + menuName + "')]"));
        menu.click();
    }

    @Then("sistem ödeme islemini yapmali ve rapor durumu guncellenmeli veya onay mesaji göstermelidir")
    public void sistem_ödeme_islemini_yapmali_ve_rapor_durumu_guncellenmeli_veya_onay_mesaji_göstermelidir() {


    }

    @Then("{string} baglantisi her rapor için mevcut olmalidir")
    public void baglantisi_her_rapor_için_mevcut_olmalidir(String string) {

    }

    @When("hasta {string} bağlantısına tiklar")
    public void hasta_bağlantısına_tiklar(String string) {

    }

    @Then("bir modal pencere rapor detaylarıyla açılmalidir")
    public void bir_modal_pencere_rapor_detaylarıyla_açılmalidir() {

    }

    @Then("modal pencere {string} butonunu icermelidir")
    public void modal_pencere_butonunu_icermelidir(String string) {

    }

    @Then("yazdırma penceresinin acıldigi dogrulanir")
    public void yazdırma_penceresinin_acıldigi_dogrulanir() {

    }

    @Then("{string} baglantısı her rapor için mevcut olmalidir")
    public void baglantısı_her_rapor_için_mevcut_olmalidir(String string) {

    }

    @When("hasta {string} baglantısına tiklar")
    public void hasta_baglantısına_tiklar(String string) {

    }

    @Then("bir modal pencere acilir")
    public void bir_modal_pencere_acilir() {

    }

    @Then("modal pencerenin {string} butonunu icerdigi dogrulanir")
    public void modal_pencerenin_butonunu_icerdigi_dogrulanir(String string) {

    }

    @When("hasta modal pencereyi kapatmak için {string} butonuna tiklar")
    public void hasta_modal_pencereyi_kapatmak_için_butonuna_tiklar(String string) {

    }

    @Then("modal pencere kapanir ve kullanici Radiology Test List sayfasina geri dondugu dogrulanir.")
    public void modal_pencere_kapanir_ve_kullanici_radiology_test_list_sayfasina_geri_dondugu_dogrulanir() {

    }


    @Given("hasta Radyology Test Reports Listesi sayfasina gider")
    public void hasta_radyology_test_reports_listesi_sayfasina_gider() {
        try {
            // Hasta login işlemi yap
            loginPage.hastaLogin();

            // Radyoloji sayfasına yönlendir
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement radiologyButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[@href='/patient/dashboard/radiology']"))); // Düzgün XPath kullanıldı
            radiologyButton.click();

            // Sayfa başlığını kontrol et
            WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h1[contains(text(),'Radiology Test Reports')]"))); // Başlık kontrolü
            Assert.assertTrue("Radiology Test Reports Listesi sayfası açılmadı!", pageTitle.isDisplayed());
            logger.info("Hasta Radyology Test Reports Listesi sayfasına başarıyla yönlendirildi.");
        } catch (Exception e) {
            logger.error("Radyology Test Reports Listesi sayfasına yönlendirme başarısız. Hata: " + e.getMessage());
            Assert.fail("Radyology Test Reports Listesi sayfası açılamadı.");
        }
    }
}

