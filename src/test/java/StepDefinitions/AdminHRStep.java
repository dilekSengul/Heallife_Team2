package StepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.cucumber.java.en_scouse.An;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.AdminDashboardPage;
import pages.AdminHRPage;
import utilities.ConfigReader;
import utilities.DriverManager;
import utilities.ReusableMethods;

import java.sql.Driver;

public class AdminHRStep {

    WebDriver driver = Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(AdminHRStep.class);
    AdminHRPage adminHRPage = new AdminHRPage();


    @When("Admin kullanici ana sayfaya gider")
    public void admin_kullanici_ana_sayfaya_gider() {

        driver.get(ConfigReader.getProperty("AdminDasboardUrl"));

    }
    @And("Gecerli giris bilgileriyle sisteme giris yapar")
    public void gecerli_giris_bilgileriyle_sisteme_giris_yapar() {
        adminHRPage.emailAlani.sendKeys(ConfigReader.getProperty("AdminMailUgur"));
        adminHRPage.sifreAlani.sendKeys(ConfigReader.getProperty("Passwords"));
        adminHRPage.signInButonu.click();

    }
    @Then("Admin kullanici {string} Linkine tiklar")
    public void admin_kullanici_linkine_tiklar(String string) {
        adminHRPage.humanResourceLinki.click();

    }
    @And("Admin Kullanici {string} sayfasini goruntuler")
    public void admin_kullanici_sayfasini_goruntuler(String string) {
        Assert.assertTrue(adminHRPage.staffDirectoryBasligi.isDisplayed());
        ReusableMethods.wait(2);

    }

    @Given("Admin kullanici giris bilgileri ile sisteme login olur")
    public void admin_kullanici_giris_bilgileri_ile_sisteme_login_olur() {
        driver.get(ConfigReader.getProperty("AdminDasboardUrl"));

        adminHRPage.emailAlani.sendKeys(ConfigReader.getProperty("AdminMailUgur"));
        adminHRPage.sifreAlani.sendKeys(ConfigReader.getProperty("Passwords"));
        adminHRPage.signInButonu.click();

    }
    @Given("Staff Directory Sayfasina gider")
    public void staff_directory_sayfasina_gider() {

        adminHRPage.humanResourceLinki.click();

    }
    @When("Kullanici List View butonuna tiklar")
    public void kullanici_list_view_butonuna_tiklar() {

        adminHRPage.listViewButonu.click();
        ReusableMethods.wait(1);

    }
    @Then("Kullanici Staff ID, Name, Role, Department, Designation, Mobile Number ve Action basliklarini goruntuler")
    public void kullanici_staff_id_name_role_department_designation_mobile_number_ve_action_basliklarini_goruntuler() {

        Assert.assertTrue(adminHRPage.staffDirectoryBasligi.isDisplayed());
        Assert.assertTrue(adminHRPage.nameBasligli.isDisplayed());
        Assert.assertTrue(adminHRPage.roleBasligi.isDisplayed());
        Assert.assertTrue(adminHRPage.departmentBasligi.isDisplayed());
        Assert.assertTrue(adminHRPage.designationBasligi.isDisplayed());
        Assert.assertTrue(adminHRPage.mobileNumberBasligi.isDisplayed());
        Assert.assertTrue(adminHRPage.actionBasligi.isDisplayed());
        ReusableMethods.wait(3);

    }
    @Then("Kullanici Personelleri Liste halinde goruntuler")
    public void kullanici_personelleri_liste_halinde_goruntuler() {

        Assert.assertTrue(adminHRPage.superAdminListView.isDisplayed());
        ReusableMethods.wait(1);

    }
    @When("Kullanici Card View butonuna tiklar")
    public void kullanici_card_view_butonuna_tiklar() {

        adminHRPage.cardViewButonu.click();
        ReusableMethods.wait(1);

    }
    @Then("Kullanici Personelleri Card View halinde goruntuler")
    public void kullanici_personelleri_card_view_halinde_goruntuler() {

        Assert.assertTrue(adminHRPage.superAdminCardView.isDisplayed());
        ReusableMethods.wait(1);

    }

    @When("Kullanici {string} butonuna tiklar ve link siralamasi degisir")
    public void kullanici_butonuna_tiklar_ve_link_siralamasi_degisir(String string) {

    }
    @When("Kullanici {string} altinda {string} butonuna tiklar")
    public void kullanici_altinda_butonuna_tiklar(String string, String string2) {

        adminHRPage.showButonuActionAltinda.click();

    }
    @Then("Ilgili personelin bilgilerinin yer aldigi sayfaya yonlendirilir")
    public void ilgili_personelin_bilgilerinin_yer_aldigi_sayfaya_yonlendirilir() {

        Assert.assertTrue(adminHRPage.staffIDButonuProfilEkrani.isDisplayed());

    }

    @When("Kullanici {string} butonuna ardindan da {string} butonuna tiklar")
    public void kullanici_butonuna_ardindan_da_butonuna_tiklar(String string, String string2) {

        adminHRPage.addStaffDropdownButonu.click();
        adminHRPage.disabledStaffButonu.click();

    }
    @Then("Kullanici Disabled Staff ekranina erisir")
    public void kullanici_disabled_staff_ekranina_erisir() {

        Assert.assertTrue(adminHRPage.disabledStaffEkraniBasligi.isDisplayed());

    }
    @When("Kullanici {string} linkine tiklar")
    public void kullanici_linkine_tiklar(String string) {

        adminHRPage.payrollButonu.click();

    }
    @When("Kullanici {string} butonuna tiklar")
    public void kullanici_butonuna_tiklar(String string) {
        adminHRPage.addStaffButonu.click();

    }


    @Then("Kullanici {string} sayfasina erisir")
    public void kullaniciSayfasinaErisir(String arg0) {
        adminHRPage.staffAttendanceBasligi.isDisplayed();

    }


    @Then("Kullanici {string} Sayfasina goruntuler")
    public void kullaniciSayfasinaGoruntuler(String arg0) {
        Assert.assertTrue(adminHRPage.payrollSayfasiBasligi.isDisplayed());
    }

    @And("Kullanici Action butonuna tiklar")
    public void kullaniciActionButonunaTiklar() {

        adminHRPage.actionBasligi.click();

    }

    @When("Kullanici Action altinda Edit butonuna tiklar")
    public void kullaniciActionAltindaEditButonunaTiklar() {

        adminHRPage.editButonuActionAltinda.click();
    }

    @Then("Ilgili personel bilgilerinin editlendigi sayfaya yonlendirilir")
    public void ilgiliPersonelBilgilerininEditlendigiSayfayaYonlendirilir() {

        Assert.assertTrue(adminHRPage.basicInformationSayfasiBasligi.isDisplayed());
    }

    @Then("Kullanici {string} basligi altinda Add Staff Ekranina erisir")
    public void kullaniciBasligiAltindaAddStaffEkraninaErisir(String arg0) {

        Assert.assertTrue(adminHRPage.basicInformationSayfasiBasligi.isDisplayed());
    }

    @And("Kullanici kayit formunu doldurur islemi kaydeder")
    public void kullaniciKayitFormunuDoldururIslemiKaydeder() {

        Faker faker = new Faker();
        String fakeStaffID = faker.idNumber().invalid();
        String fakeFirstName = faker.name().firstName();

    }

    @Then("Kullanici kaydedilen personelin listede goruntuler")
    public void kullaniciKaydedilenPersonelinListedeGoruntuler() {
    }

    @And("Kullanici Import Staff butonuna tiklar")
    public void kullaniciImportStaffButonunaTiklar() {
        adminHRPage.importStaffButonu.click();


    }

    @Then("Kullanici Import Staff ekranini goruntuler")
    public void kullaniciImportStaffEkraniniGoruntuler() {
        Assert.assertTrue(adminHRPage.importStaffSayfaBasligi.isDisplayed());
    }

    @When("Kullanici Add Staff butonuna tiklar")
    public void kullaniciAddStaffButonunaTiklar() {
        adminHRPage.addStaffButonu.click();
    }

    @Then("Kullanici Basic Information basligi altinda Add Staff Ekranina erisir")
    public void kullaniciBasicInformationBasligiAltindaAddStaffEkraninaErisir() {
        Assert.assertTrue(adminHRPage.basicInformationSayfasiBasligi.isDisplayed());
    }

    @When("Kullanici Leaves butonuna tiklar")
    public void kullaniciLeavesButonunaTiklar() {
        adminHRPage.leavesButonu.click();


    }

    @Then("Kullanici My Leaves sayfasina erisir")
    public void kullaniciMyLeavesSayfasinaErisir() {
        Assert.assertTrue(adminHRPage.leavesSayfasiBasligi.isDisplayed());
        
    }

    @When("Kullanici arama butonunda ilgili izin icin arama yapar")
    public void kullaniciAramaButonundaIlgiliIzinIcinAramaYapar() {
        adminHRPage.leavesSayfasiSearchButonu.click();
        adminHRPage.leavesSayfasiSearchButonu.sendKeys("Ahmet");
        
    }

    @Then("Kullanici izin bilgisine erisir")
    public void kullaniciIzinBilgisineErisir() {
        Assert.assertTrue(adminHRPage.addNewLeaveYazisi.isDisplayed());
        
    }


    @And("Kullanici Approve Leave Request butonuna tiklar")
    public void kullaniciApproveLeaveRequestButonunaTiklar() {
        adminHRPage.approveLeaveRequestButonu.click();
        ReusableMethods.wait(1);
    }

    @When("Kullanici {string} siralama secenegine tiklar")
    public void kullanici_siralama_secenegine_tiklar(String string) {
        adminHRPage.approveLeaveRequest100Butonu.click();

    }
    @When("Kullanici Action basligi altinda Viewe tiklar")
    public void kullanici_action_basligi_altinda_viewe_tiklar() {
        adminHRPage.aprroveLeaveRequestViewButonu.click();
        ReusableMethods.wait(1);

    }
    @Then("Kullanici Details ekraninin goruntulendigini dogrular")
    public void kullanici_details_ekraninin_goruntulendigini_dogrular() {
        Assert.assertTrue(adminHRPage.detailsEkraniNameBasligi.isDisplayed());
        ReusableMethods.wait(1);

    }

    @When("Kullanici Add Leave Request butonuna tiklar")
    public void kullanici_add_leave_request_butonuna_tiklar() {
        adminHRPage.addLeaveRequestButonu.click();
        ReusableMethods.wait(1);

    }
    @Then("Kullanici Add Details ekranina erisir")
    public void kullanici_add_details_ekranina_erisir() {
        Assert.assertTrue(adminHRPage.saveButonuAddDetailsPenceresi.isDisplayed());
        ReusableMethods.wait(1);

    }
    @When("Kullanici Add Details ekraninda formu doldurur")
    public void kullanici_add_details_ekraninda_formu_doldurur() {

        Actions actions = new Actions(DriverManager.getDriver());

        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .perform();

        adminHRPage.saveButonuAddDetailsPenceresi.click();

    }
    @Then("Kullanici kaydedilen izni Approve Leave Request ekraninda goruntuleyebildigini dogrular")
    public void kullanici_kaydedilen_izni_approve_leave_request_ekraninda_goruntuleyebildigini_dogrular() {

        Assert.assertTrue(adminHRPage.addLeaveRequestButonu.isDisplayed());

    }


    @Then("Kullanici Staff Attendance sayfasina erisir")
    public void kullaniciStaffAttendanceSayfasinaErisir() {

        Assert.assertTrue(adminHRPage.staffAttendanceBasligi.isDisplayed());


    }
}
