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

    @Given("kullanici URL'i acar")
    public void kullanici_url_i_acar() {

    }

    @Given("kullanıcı {string} ve {string} ile giriş yapar")
    public void kullanıcı_ve_ile_giriş_yapar(String string, String string2) {

    }

    @When("Kullanici \\(hasta) {string} menu secenegine tiklar")
    public void kullanici_hasta_menu_secenegine_tiklar(String string) {

    }

    @Then("{string} sayfasinşn goruntulendigini dogrular")
    public void sayfasinin_goruntulendigini_dogrular(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("hasta Radyology Test Reports List sayfasına gider")
    public void hasta_radyology_test_reports_list_sayfasına_gider() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("asagidaki baslıklarin gorunur oldugunu dogrular")
    public void asagidaki_baslıklarin_gorunur_oldugunu_dogrular(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }


    // Patient Radiology Sayfası
    @Given("hasta Radyology Test Reports Listesi sayfasina gider")
    public void hasta_radyology_test_reports_listesi_sayfasina_gider() {
        loginPage.hastaLogin();
    }

    @When("hasta bir arama terimi girer")
    public void hasta_bir_arama_terimi_girer() {

    }

    @Then("sonuclarin girilen arama terimiyle eslesen sekilde goruntulendigini dogrular")
    public void sonuclarin_girilen_arama_terimiyle_eslesen_sekilde_goruntulendigini_dogrular() {

    }

    @Given("hasta Radyology Test Reports sayfasina gider")
    public void hasta_radyology_test_reports_sayfasina_gider() {

    }

    @When("hasta bir baslık uzerine tiklar")
    public void hasta_bir_baslık_uzerine_tiklar() {

    }

    @Then("liste artan sirada siralanmalidir")
    public void liste_artan_sirada_siralanmalidir() {

    }

    @When("hasta aynı başlık uzerine tekrar tiklar")
    public void hasta_aynı_başlık_uzerine_tekrar_tiklar() {

    }

    @Then("listenin azalan sirada siralandigini dogrular")
    public void listenin_azalan_sirada_siralandigini_dogrular() {

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
    public void hasta_butonuna_tiklar(String string) {

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

}

