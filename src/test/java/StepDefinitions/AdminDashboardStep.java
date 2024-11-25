package StepDefinitions;

import io.cucumber.java.en.And;
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
     LoginPage loginPage =new LoginPage();
     AdminDashboardPage adminDashboardPage=new AdminDashboardPage();

    @When("Admin mail {string}  ve password {string} ile sign in olur")
    public void admin_mail_ve_password_ile_sign_in_olur(String userName, String password) {
       loginPage.accesAdmin(userName,password);

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

       String actualUrl=ConfigReader.getProperty("AdminDasboardUrl");
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
         List<String> menuString= ReusableMethods.getStringList(menuItems);

        Assert.assertEquals(expectedMenuItems,menuString);

    }



    @And("Kullanici admin sayfasinda oldugunu dogrular")
    public void kullaniciAdminSayfasindaOldugunuDogrular() {
        ReusableMethods.wait(2);
        String expectedUrl= "https://qa.heallifehospital.com/admin/admin/dashboard";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
    }

    @And("Kullanici side navigation yer alan Radiology tab'ine tiklar")
    public void kullaniciSideNavigationYerAlanRadiologyTabIneTiklar() {
        adminDashboardPage.radiologyButton.click();

    }

    @And("Kullanici Radiology sayfasinin acildigini dogrular")
    public void kullaniciRadiologySayfasininAcildiginiDogrular() {
        ReusableMethods.wait(2);
        String expectedUrl="https://qa.heallifehospital.com/admin/radio/gettestreportbatch";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

    }

    @Then("sayfayi Setup a kadar kaydirir ve yan menude asagidaki basliklarin mevcut oldugunu dogrular:")
    public void sayfayiSetupAKadarKaydirirVeYanMenudeAsagidakiBasliklarinMevcutOldugunuDogrular(io.cucumber.datatable.DataTable dataTable) {
        JSUtilities.scrollToElement(driver,adminDashboardPage.SetupMenu);
        // Feature dosyasından gelen menü başlıkları
        List<String> expectedMenuItems = dataTable.asList();
        List<WebElement> menuItems = new ArrayList<>();
        menuItems.add(adminDashboardPage.TPAManagementMenu);
        menuItems.add(adminDashboardPage.MessagingMenu);
        menuItems.add(adminDashboardPage.LiveConsultationMenu);
        menuItems.add(adminDashboardPage.SetupMenu);
        List<String> menuString= ReusableMethods.getStringList(menuItems);

        Assert.assertEquals(expectedMenuItems,menuString);
    }@Then("{string} basligina tikladigimda")
    public void basligina_tikladigimda(String menuItem) {
        WebElement menuElement =  driver.findElement(By.xpath("//span[normalize-space()='" + menuItem + "']"));
       // menuElement.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", menuElement);

    }
    @Then("{string} basligina yonlendirilmeliyim")
    public void basligina_yonlendirilmeliyim(String ExpectedPageUrl) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(ExpectedPageUrl));
    }


}
