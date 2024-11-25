package StepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import pages.PatientDashboardPage;
import pages.PatientPharmacyPage;
import utilities.ReusableMethods;

import java.util.List;


public class PatientPharmacySteps {

    WebDriver driver = Hooks.getDriver();
    private List<WebElement> tableHeaders;
    private List<WebElement> tableItems;
    PatientPharmacyPage patientPharmacyPage = new PatientPharmacyPage(tableHeaders,tableItems);
    PatientDashboardPage patientDashboardPage = new PatientDashboardPage();


    @When("kullanici sol menuden Pharmacy secenegine tiklar")
    public void kullanici_sol_menuden_secenegine_tiklar() {
        patientDashboardPage.PharmacySideBarButton.click();
    }

    @Then("Pharmacy sayfasinin duzgun bir sekilde goruntulendigini dogrular")
    public void pharmacy_sayfasinin_duzgun_bir_sekilde_goruntulendigini_dogrular() {
        Assert.assertTrue(driver.getCurrentUrl().contains("pharmacy"));
    }

    @Then("kullanici aşagidaki tablo basliklarinin goruntulendigini dogrular:")
    public void kullanici_asagidaki_tablo_basliklarinin_goruntulendigini_dogrular(List<String> expectedHeaders) {
        List<String> actualHeaders = patientPharmacyPage.getTableHeaders();
        Assertions.assertEquals(expectedHeaders, actualHeaders, "Column headers do not match!");
    }

    @When("kullanici arama cubuguna bir ogenin iceriginin ilk 3 harfini yazar")
    public void kullanici_arama_cubuguna_bir_ogenin_ilk_harfini_yazar() {
        patientPharmacyPage.searchBar.sendKeys("PAT");
        ReusableMethods.bekle(2);
    }

    @Then("arama sonuçlarinin dogru bir sekilde goruntulendigini dogrular")
    public void arama_sonuclarinin_dogru_bir_sekilde_goruntulendigini_dogrular() {
        Assert.assertTrue(patientPharmacyPage.getTableBodies().contains("PAT"));
    }

    @When("kullanici Actions sutunundaki View Payments butonuna tiklar")
    public void kullanici_Actions_sutunundaki_View_Payments_butonuna_tiklar() {
            patientPharmacyPage.viewPaymentsButton.click();
            ReusableMethods.waitForClickablility(patientPharmacyPage.viewPaymentsWindowTitle, 10);
    }

    @When("View Payments butonunun duzgun calistigini dogrular")
    public void View_Payments_butonun_duzgun_calistigini_dogrular() {
        Assertions.assertTrue(patientPharmacyPage.viewPaymentsWindowTitle.isDisplayed());
        patientPharmacyPage.viewPaymentsXbutton.click();
    }
    @When("kullanici Actions sutunundaki Show butonlarina butonuna tiklar")
    public void kullanici_Actions_sutunundaki_Show_butonuna_tiklar() {
        patientPharmacyPage.showButton.click();
        ReusableMethods.waitForClickablility(patientPharmacyPage.showWindowTitle, 10);
    }

    @When("Show butonunun duzgun calistigini dogrular")
    public void show_butonun_duzgun_calistigini_dogrular() {
        Assertions.assertTrue(patientPharmacyPage.showWindowTitle.isDisplayed());
    }

    @When("kullanici bir ogenin Pay dugmesine tiklar")
    public void kullanici_bir_ogenin_dugmesine_tiklar() {
            patientPharmacyPage.firstPayButton.click();
    }

    @And("odeme penceresine negatif bir miktar girer ve Add dugmesine tiklar")
    public void odeme_penceresine_negatif_bir_miktar_girer_ve_dugmesine_tiklar() {
        patientPharmacyPage.paymentInput.clear();
        patientPharmacyPage.paymentInput.sendKeys("-10");
        patientPharmacyPage.addButton.click();
    }

    @Then("sayfanin bu girisimi reddettigini ve sag ust kosede error mesaji ciktigini dogrular")
    public void sayfanin_bu_girisimi_reddettigini_ve_sag_ust_kosede_mesaji_ciktigini_dogrular() {
        Assert.assertTrue(patientPharmacyPage.errorMessage.isDisplayed());
    }
    @When("odeme penceresine rakam olmayan bir karakter girer ve Add dugmesine tiklar")
    public void odeme_penceresine_rakam_olmayan_bir_karakter_girer_ve_Add_dugmesine_tiklar() {
        patientPharmacyPage.paymentInput.clear();
        patientPharmacyPage.paymentInput.sendKeys("*");
        patientPharmacyPage.addButton.click();
    }

    @When("odeme penceresine miktar olarak 0 girer ve Add dugmesine tiklar")
    public void odemePenceresineMiktarOlarakGirerVeAddDugmesineTiklar() {
        patientPharmacyPage.paymentInput.clear();
        patientPharmacyPage.paymentInput.sendKeys("0");
        patientPharmacyPage.addButton.click();
    }

    @When("odeme penceresine bakiye miktarindan daha buyuk bir miktar olarak {int} girer ve Add dugmesine tiklar")
    public void odemePenceresineBakiyeMiktarindanDahaBuyukBirMiktarOlarakGirerVeAddDugmesineTiklar(int arg0) {
        patientPharmacyPage.paymentInput.clear();
        patientPharmacyPage.paymentInput.sendKeys(String.valueOf(arg0));
        patientPharmacyPage.addButton.click();
    }

    @When("odeme penceresini bos birakir ve Add dugmesine tiklar")
    public void odemePenceresiniBosBirakirVeAddDugmesineTiklar() {
        patientPharmacyPage.addButton.click();
    }

    @And("odeme penceresine miktar girer \\(full or partial amount) ve Add e tiklar")
    public void odeme_penceresine_miktar_girer_ve_e_tiklar() {
       // patientPharmacyPage.paymentInput.sendKeys("50"); //boş kalsın
        patientPharmacyPage.addButton.click();
        ReusableMethods.wait(2);
    }

    @Then("odeme detaylari sayfasinin acildigini dogrular")
    public void odemeDetaylariSayfasininAcildiginiDogrular() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/patient/payment/stripe"));
    }
}
