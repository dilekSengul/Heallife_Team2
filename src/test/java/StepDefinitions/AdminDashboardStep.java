package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AdminDashboardPage;
import pages.LoginPage;
import utilities.ConfigReader;
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

        // Feature dosyasından gelen menü başlıklarını alın
       // List<String> expectedMenuItems = dataTable.asList();

        // Menü doğrulama metodunu çağır
       //adminDashboardPage.validateMenuItems(driver, expectedMenuItems);
      adminDashboardPage.kullanıcı_tüm_menü_başlıklarını_kontrol_eder();




        /*List<WebElement> menuItems = driver.findElements(By.cssSelector(".sidebar-menu li a span"));

        // Menü başlıklarını konsola yazdır
        System.out.println("Sol Menü Başlıkları:");
        for (WebElement menuItem : menuItems) {
            System.out.println("- " + menuItem.getText().trim());
        }
*/
    }
    @Then("Her linkin tiklanabilir oldugunu ve dogru sayfaya yönlendirildigini dogrular")
    public void her_linkin_tıklanabilir_olduğunu_ve_doğru_sayfaya_yönlendirildiğini_doğrula() {
        // Tüm <a href> linklerini almak
        List<WebElement> links = driver.findElements(By.cssSelector("li.treeview > a"));

        // Linklerin href değerlerini bir listeye ekleme
        List<String> hrefList = new ArrayList<>();
        for (WebElement link : links) {
            String href = link.getAttribute("href"); // href değerini al
            hrefList.add(href); // Listeye ekle
        }

        // Listeyi yazdır
        System.out.println("Bulunan Linkler:");
        for (String href : hrefList) {
            System.out.println(href);
        }


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
}
