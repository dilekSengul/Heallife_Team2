package StepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.PatientDashboardPage;
import pages.PatientPage;
import utilities.ReusableMethods;

import java.util.List;

public class PatientBloodBankStep {

    WebDriver driver = Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(PatientStep.class);
    PatientPage page = new PatientPage(); // Page Object sınıfınız
    private List<WebElement> tableHeaders;
    private List<WebElement> tableItems;
    PatientPage patientPage = new PatientPage(tableHeaders,tableItems);
    LoginPage loginPage = new LoginPage();
    Faker faker = new Faker();
    PatientDashboardPage patientDashboardPage=new PatientDashboardPage();

    @When("kullanici sol menuden Blood Bank secenegine tiklar")
    public void kullanici_sol_menuden_Blood_Bank_secenegine_tiklar() {
        patientDashboardPage.bloodBankBoard.click();

    }

    @Given("hasta Blood Bank sayfasına gider")
    public void hasta_blood_bank_sayfasına_gider() {
        ReusableMethods.wait(2);
        Assert.assertTrue("Blood Bank sayfası açılmadı!",
                page.patienNameTextBloodBank.isDisplayed());
    }

    @Given("hasta Blood Issue sayfasına gider")
    public void hasta_blood_Issue_sayfasına_gider() {
        ReusableMethods.wait(2);
        Assert.assertTrue("Blood Issue sayfası açılmadı!",
                page.patienNameTextBloodBank.isDisplayed());
    }
    @When("Blood Issue listesinde hasta bir baslık uzerine tiklar")
    public void blood_ıssue_listesinde_hasta_bir_baslık_uzerine_tiklar() {
        page.billNoBloodIssue.click();
        ReusableMethods.wait(2);
        page.billNoBloodIssue.click();
        ReusableMethods.wait(2);
    }

    @When("Compenent Issue listesinde hasta bir baslık uzerine tiklar")
    public void component_ıssue_listesinde_hasta_bir_baslık_uzerine_tiklar() {
        page.billNoComponentIssue.click();
        ReusableMethods.wait(2);
        page.billNoComponentIssue.click();
        ReusableMethods.wait(2);
    }

    @Then("blood liste artan sirada siralanmalidir")
    public void blood_liste_artan_sirada_siralanmalid() {
        List<WebElement> billNoElements = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        System.out.println("Bulunan eleman sayısı: " + billNoElements.size());

        for (WebElement element : billNoElements) {
            System.out.println("Bulunan değer: " + element.getText());
        }

    }
    @When("hasta blood Id uzerine tekrar tiklar")
    public void hasta_blood_ıd_uzerine_tekrar_tiklar() {
        ReusableMethods.wait(2);
        page.billNoBloodIssue.click();

    }




    @Then("Component Issue sayfasinin goruntulendigini dogrular")
    public void component_ıssue_sayfasinin_goruntulendigini_dogrular() {
        Assert.assertTrue("Component Issue sayfası açılmadı!",
                page.componentIssueHeader.isDisplayed());
    }

    @Then("hasta, blood icin bir arama terimi girer")
    public void hasta_blood_icin_bir_arama_terimi_girer() {
        page.searchAlaniBloodIssue.sendKeys("B");
        ReusableMethods.bekle(2);
    }




    @Then("blood elementinin girilen arama terimiyle eslesen sekilde goruntulendigini dogrular")
    public void blood_elementinin_girilen_arama_terimiyle_eslesen_sekilde_goruntulendigini_dogrular() {
        List<String> tbody = page.getTableBodies();
        System.out.println("Tablodaki veriler: " + tbody);
        boolean containsRAD = tbody.stream().anyMatch(row -> row.contains("B"));
        Assert.assertTrue("Arama sonuçları beklenen değeri içermiyor", containsRAD);
    }



    @When("blood listesinde hasta bir baslık uzerine tiklar")
    public void blood_listesinde_hasta_bir_baslık_uzerine_tiklar() {
        page.billNoBloodIssue.click();
        ReusableMethods.wait(2);

    }


        @Then("blood liste artan bir sirada siralanmalidir")
        public void blood_liste_artan_sirada_siralanmalidir() {
            List<WebElement> bloodIssueElements = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
            System.out.println("Bulunan eleman sayısı: " +bloodIssueElements.size());

            for (WebElement element : bloodIssueElements) {
                System.out.println("Bulunan değer: " + element.getText());

            }


        }

    @When("hasta blood bolumunde aynı header uzerine tekrar tiklar")
    public void hasta_blood_bolumunde_aynı_header_uzerine_tekrar_tiklar() {
        page.billNoBloodIssue.click();
        ReusableMethods.wait(2);
    }







    @Given("hasta Component Issue butonuna tıklar")
    public void hasta_component_issue_butonuna_tiklar() {
        ReusableMethods.wait(2);
        page.componentIssueButton.click();
        Assert.assertTrue("Blood Bank sayfası açılmadı!",
                page.componentIssueHeader.isDisplayed());


    }


    @Then("hasta,component icin bir arama terimi girer")
    public void hasta_component_icin_bir_arama_terimi_girer() {
        page.searchAlaniComponentIssue.sendKeys("B");
        ReusableMethods.bekle(2);
    }


    @Then("component elementinin girilen arama terimiyle eslesen sekilde goruntulendigini dogrular")
    public void component_elementinin_girilen_arama_terimiyle_eslesen_sekilde_goruntulendigini_dogrular() {
        List<String> tbody = page.getTableBodies();
        System.out.println("Tablodaki veriler: " + tbody);
        boolean containsRAD = tbody.stream().anyMatch(row -> row.contains("B"));
        Assert.assertTrue("Arama sonuçları beklenen değeri içermiyor", containsRAD);
    }

    @Then("hasta, Blood Issue icin bir arama terimi girer")
    public void hasta_blood_ıssue_icin_bir_arama_terimi_girer() {
        page.searchAlaniBloodIssue.sendKeys("B");
        ReusableMethods.bekle(2);
    }
    @Then("hasta, Compenent Issue icin bir arama terimi girer")
    public void hasta_component_ıssue_icin_bir_arama_terimi_girer() {
        page.searchAlaniComponentIssue.sendKeys("B");
        ReusableMethods.bekle(2);
    }
    @Then("Blood Issue elementinin girilen arama terimiyle eslesen sekilde goruntulendigini dogrular")
    public void blood_ıssue_elementinin_girilen_arama_terimiyle_eslesen_sekilde_goruntulendigini_dogrular() {
        List<String> tbody = page.getTableBodies();
        System.out.println("Tablodaki veriler: " + tbody);
        boolean containsRAD = tbody.stream().anyMatch(row -> row.contains("B"));
        Assert.assertTrue("Arama sonuçları beklenen değeri içermiyor", containsRAD);
    }
    @Then("Component Issue elementinin girilen arama terimiyle eslesen sekilde goruntulendigini dogrular")
    public void component_ıssue_elementinin_girilen_arama_terimiyle_eslesen_sekilde_goruntulendigini_dogrular() {
        List<String> tbody = page.getTableBodies();
        System.out.println("Tablodaki veriler: " + tbody);
        boolean containsRAD = tbody.stream().anyMatch(row -> row.contains("B"));
        Assert.assertTrue("Arama sonuçları beklenen değeri içermiyor", containsRAD);
    }

    @When("component listesinde hasta bir baslık uzerine tiklar")
    public void component_listesinde_hasta_bir_baslık_uzerine_tiklar() {
        page.billNoComponentIssue.click();
        ReusableMethods.wait(2);

    }

    @Then("component liste artan bir sirada siralanmalidir")
    public void component_liste_artan_sirada_siralanmalidir() {
        List<WebElement> componentIssueElements = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        System.out.println("Bulunan eleman sayısı: " +componentIssueElements.size());

        for (WebElement element : componentIssueElements) {
            System.out.println("Bulunan değer: " + element.getText());

        }
    }

    @When("hasta component bolumunde aynı header uzerine tekrar tiklar")
    public void hasta_component_bolumunde_aynı_header_uzerine_tekrar_tiklar() {
        page.billNoBloodIssue.click();
        ReusableMethods.wait(2);
    }





}
