package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AdminDashboardPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.JSUtilities;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AdminDashboardStep {
    WebDriver driver = Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(AdminDashboardStep.class);
    LoginPage loginPage = new LoginPage();
    AdminDashboardPage adminDashboardPage = new AdminDashboardPage();

    @When("Admin mail {string}  ve password {string} ile sign in olur")
    public void admin_mail_ve_password_ile_sign_in_olur(String userName, String password) {
        loginPage.accesAdmin(userName, password);

    }

    @Then("Heal Life Hospital & Research yazisinin solundaki sidebar iconuna tiklar")
    public void heal_life_hospital_research_yazisinin_solundaki_sidebar_iconuna_tiklar() {
        adminDashboardPage.clickSidebarIconIfDashboardNotVisible();
    }

    @Then("Sidbarda {string} yazisini gorunurlugunu dogrular")
    public void sidbarda_yazisini_gorunurlugunu_dogrular(String string) {
        Assert.assertTrue(adminDashboardPage.dashboardText.isDisplayed());
    }

    @Then("Dashboard yazisina tiklar")
    public void dashboard_yazisina_tiklar() {
        adminDashboardPage.dashboardText.click();
    }

    @Then("Sayfanin yenilendigini dogrular")
    public void sayfanin_yenilendigini_dogrular() {

        String actualUrl = ConfigReader.getProperty("AdminDasboardUrl");
        //  driver.navigate().refresh();
        String newUrl = driver.getCurrentUrl();
        assertEquals("Sayfa yenilendikten sonra Url ayni kalmali", actualUrl, newUrl);
    }

    @Then("Yan menude asagidaki basliklarin mevcut oldugunu dogrular:")
    public void yan_menüde_aşağıdaki_linklerin_mevcut_olduğunu_doğrula(io.cucumber.datatable.DataTable dataTable) {

        // Feature dosyasından gelen menü başlıkları
        List<String> expectedMenuItems = dataTable.asList();

        // List<WebElement> menuItems = driver.findElements(By.cssSelector(".sidebar-menu li a span"));

        List<WebElement> menuItems = new ArrayList<>();
        menuItems.add(adminDashboardPage.DashboardMenu);
        menuItems.add(adminDashboardPage.BillingMenu);
        menuItems.add(adminDashboardPage.AppointmentMenu);
        menuItems.add(adminDashboardPage.OPDMenu);
        menuItems.add(adminDashboardPage.IPDMenu);
        menuItems.add(adminDashboardPage.PharmacyMenu);
        menuItems.add(adminDashboardPage.PathologyMenu);
        menuItems.add(adminDashboardPage.RadiologyMenu);
        menuItems.add(adminDashboardPage.BloodBankMenu);
        menuItems.add(adminDashboardPage.AmbulanceMenu);
        menuItems.add(adminDashboardPage.BirthDeathRecordMenu);
        menuItems.add(adminDashboardPage.HumanResourceMenu);
        List<String> menuString = ReusableMethods.getStringList(menuItems);

        Assert.assertEquals(expectedMenuItems, menuString);

    }


    @And("Kullanici admin sayfasinda oldugunu dogrular")
    public void kullaniciAdminSayfasindaOldugunuDogrular() {
        ReusableMethods.wait(2);
        String expectedUrl = "https://qa.heallifehospital.com/admin/admin/dashboard";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @And("Kullanici side navigation yer alan Radiology tab'ine tiklar")
    public void kullaniciSideNavigationYerAlanRadiologyTabIneTiklar() {
        adminDashboardPage.radiologyButton.click();

    }

    @And("Kullanici Radiology sayfasinin acildigini dogrular")
    public void kullaniciRadiologySayfasininAcildiginiDogrular() {
        ReusableMethods.wait(2);
        String expectedUrl = "https://qa.heallifehospital.com/admin/radio/gettestreportbatch";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);

    }

    @Then("sayfayi Setup a kadar kaydirir ve yan menude asagidaki basliklarin mevcut oldugunu dogrular:")
    public void sayfayiSetupAKadarKaydirirVeYanMenudeAsagidakiBasliklarinMevcutOldugunuDogrular(io.cucumber.datatable.DataTable dataTable) {
        JSUtilities.scrollToElement(driver, adminDashboardPage.SetupMenu);
        // Feature dosyasından gelen menü başlıkları
        List<String> expectedMenuItems = dataTable.asList();
        List<WebElement> menuItems = new ArrayList<>();
        menuItems.add(adminDashboardPage.TPAManagementMenu);
        menuItems.add(adminDashboardPage.MessagingMenu);
        menuItems.add(adminDashboardPage.LiveConsultationMenu);
        menuItems.add(adminDashboardPage.SetupMenu);
        List<String> menuString = ReusableMethods.getStringList(menuItems);

        Assert.assertEquals(expectedMenuItems, menuString);
    }

    @Then("{string} basligina tikladigimda")
    public void basligina_tikladigimda(String menuItem) {
        WebElement menuElement = driver.findElement(By.xpath("//span[normalize-space()='" + menuItem + "']"));
        // menuElement.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", menuElement);

    }

    @Then("{string} basligina yonlendirilmeliyim")
    public void basligina_yonlendirilmeliyim(String ExpectedPageUrl) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(ExpectedPageUrl));
    }

    //US_041-TC1
    @When("Dashboard yan menüsünden {string} bağlantısını tıkla")
    public void dashboard_yan_menüsünden_bağlantısını_tıkla(String string) {
        adminDashboardPage.tpaManagementLink.click(); // TPA Management bağlantısına tıkla
    }

    @Then("TPA Management sayfasına yönlendirildiğini doğrular")
    public void tpa_management_sayfasına_yönlendirildiğini_doğrular() {
        Assert.assertTrue(adminDashboardPage.tpaManagementPageTitle.isDisplayed()); // Başlık görünürlüğünü kontrol et
    }

    //US_041-TC2
    @Then("TPA Yönetim Listesinde {string}, {string}, {string}, {string}, {string} ve {string} sütunlarının görüntülendiğini doğrular")
    public void tpa_yönetim_listesinde_ve_sütunlarının_görüntülendiğini_doğrular(String name, String code, String phone, String address, String contactPersonName, String contactPersonPhone) {
        Assert.assertTrue(name + " sütunu görüntülenmiyor.", adminDashboardPage.nameButton.isDisplayed());
        Assert.assertTrue(code + " sütunu görüntülenmiyor.", adminDashboardPage.codeButton.isDisplayed());
        Assert.assertTrue(phone + " sütunu görüntülenmiyor.", adminDashboardPage.phoneButton.isDisplayed());
        Assert.assertTrue(address + " sütunu görüntülenmiyor.", adminDashboardPage.addressButton.isDisplayed());
        Assert.assertTrue(contactPersonName + " sütunu görüntülenmiyor.", adminDashboardPage.contactPersonNameButton.isDisplayed());
        Assert.assertTrue(contactPersonPhone + " sütunu görüntülenmiyor.", adminDashboardPage.contactPersonPhoneButton.isDisplayed());

    }

    @Then("Kayıtları filtrelemek için bir arama kutusunun bulunduğunu doğrular")
    public void kayıtları_filtrelemek_için_bir_arama_kutusunun_bulunduğunu_doğrular() {
        Assert.assertTrue("Arama kutusu bulunamadı.", adminDashboardPage.searchBox.isDisplayed());

    }

    @Then("Görüntülenen kayıt sayısını değiştirmek için yuz ve all seçeneklerinin mevcut olduğunu doğrular")
    public void görüntülenenKayıtSayısınıDeğiştirmekIçinYuzVeAllSeçeneklerininMevcutOlduğunuDoğrular() {

        // 'All ve 100' seçeneklerinin bulunduğu dropdown menüsüne tıklıyoruz
        adminDashboardPage.allYuzButton.click();

        // '100' seçeneğini seçiyoruz
        ReusableMethods.selectByVisibleText(adminDashboardPage.allYuzButton, "100");

        // '100' seçeneği gerçekten seçildi mi kontrol ediyoruz
        String selectedOption = adminDashboardPage.allYuzButton.getAttribute("value");
        Assert.assertEquals("100 seçeneği seçilemedi.", selectedOption, "100");

        // 'All' seçeneğini seçiyoruz
        ReusableMethods.selectByVisibleText(adminDashboardPage.allYuzButton, "All");

        // 'All' seçeneği gerçekten seçildi mi kontrol ediyoruz
        selectedOption = adminDashboardPage.allYuzButton.getAttribute("value");
        Assert.assertEquals("All seçeneği seçilemedi.", selectedOption, "-1");
    }

    @Then("Her bir sütun başlığına tıklayarak listenin sıralanabildiğini doğrular")
    public void her_bir_sütun_başlığına_tıklayarak_listenin_sıralanabildiğini_doğrular() {
        adminDashboardPage.areWebElementTextsSorted(adminDashboardPage.nameColumnCells);
        adminDashboardPage.areWebElementTextsSorted(adminDashboardPage.codeColumnCells);
        adminDashboardPage.areWebElementTextsSorted(adminDashboardPage.phoneColumnCells);
        adminDashboardPage.areWebElementTextsSorted(adminDashboardPage.addressColumnCells);
        adminDashboardPage.areWebElementTextsSorted(adminDashboardPage.contactPersonNameColumnCells);
        adminDashboardPage.areWebElementTextsSorted(adminDashboardPage.contactPersonPhoneColumnCells);
    }

    //US_041-TC3
    @Then("TPA Add penceresinde Name,Code,Contact No,Address,Contact Person Name ve Contact Person Phone  giriş alanlarının mevcut olduğunu doğrular")
    public void tpaAddPenceresindeNameCodeContactNoAddressContactPersonNameVeContactPersonPhoneGirişAlanlarınınMevcutOlduğunuDoğrular() {

        adminDashboardPage.addButton.click();
        ReusableMethods.wait(3);
        Assert.assertTrue("Name giriş alanı bulunamadı!", adminDashboardPage.nameField.isDisplayed());
        Assert.assertTrue("Code giriş alanı bulunamadı!", adminDashboardPage.codeField.isDisplayed());
        Assert.assertTrue("Contact No giriş alanı bulunamadı!", adminDashboardPage.contactNoField.isDisplayed());
        Assert.assertTrue("Address giriş alanı bulunamadı!", adminDashboardPage.addressField.isDisplayed());
        Assert.assertTrue("Contact Person Name giriş alanı bulunamadı!", adminDashboardPage.contactPersonNameField.isDisplayed());
        Assert.assertTrue("Contact Person Phone giriş alanı bulunamadı!", adminDashboardPage.contactPersonPhoneField.isDisplayed());
    }

    @When("TPA Ekleme penceresindeki tüm alanlara geçerli veriler girer ve Save düğmesine tıklar")
    public void tpa_ekleme_penceresindeki_tüm_alanlara_geçerli_veriler_girer() {
        adminDashboardPage.nameField.sendKeys("Hurrem");
        adminDashboardPage.codeField.sendKeys("16");
        adminDashboardPage.contactNoField.sendKeys("54387542");
        adminDashboardPage.addressField.sendKeys("Bursa");
        adminDashboardPage.contactPersonNameField.sendKeys("Ali");
        adminDashboardPage.contactPersonPhoneField.sendKeys("875785");
        ReusableMethods.wait(2);
        adminDashboardPage.addSaveSubmit.click();

    }

      @Then("Yeni kaydın TPA Yönetim Listesinde görüntülendiğini doğrular")
    public void yeni_kaydın_tpa_yönetim_listesinde_görüntülendiğini_doğrular() {
        Assert.assertTrue(adminDashboardPage.nameColumnCells.get(0).getText().equalsIgnoreCase("Hurrem"));
    }

    //US_041-TC4

    @Given("TPA Yönetim Listesinde {string} sütununun altındaki bir kaydı bulurum")
    public void tpa_yönetim_listesinde_sütununun_altındaki_bir_kaydı_bulurum(String string) {

    }

    @When("Düzenle işlemiyle kaydın detaylarını güncellerim")
    public void düzenle_işlemiyle_kaydın_detaylarını_güncellerim() {

    }

    @Then("Değişikliklerin doğru şekilde güncellenmiş olduğunu doğrularım")
    public void değişikliklerin_doğru_şekilde_güncellenmiş_olduğunu_doğrularım() {

    }

    @When("Silme işlemini gerçekleştiririm")
    public void silme_işlemini_gerçekleştiririm() {

    }

    @Then("Kaydın listede artık görünmediğini doğrularım")
    public void kaydın_listede_artık_görünmediğini_doğrularım() {

    }

    @When("Sıralama işlemi gerçekleştiririm")
    public void sıralama_işlemi_gerçekleştiririm() {
    }

    @Then("Kayıtların yeni sırada doğru şekilde görüntülendiğini doğrularım")
    public void kayıtların_yeni_sırada_doğru_şekilde_görüntülendiğini_doğrularım() {
    }


}
