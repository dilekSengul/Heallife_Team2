package StepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import pages.PatientDashboardPage;
import pages.PatientPharmacyPage;

import java.util.ArrayList;
import java.util.List;


public class PatientPharmacySteps {

    WebDriver driver = Hooks.getDriver();
    PatientPharmacyPage patientPharmacyPage = new PatientPharmacyPage();
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
        List<String> actualHeaders = patientPharmacyPage.getColumnHeaders();
        Assertions.assertEquals(expectedHeaders, actualHeaders, "Column headers do not match!");
    }
    /*
    public void verifyColumnHeaders(List<String> expectedHeaders) {

    }
     */

    @When("kullanici arama cubuguna bir ögenin ilk 3 harfini yazar")
    public void kullanici_arama_cubuguna_bir_ogenin_ilk_harfini_yazar(int harfSayisi) {
        patientPharmacyPage.searchBox.sendKeys("kır".substring(0, harfSayisi)); // Example input
    }

    @Then("arama sonuçlarinin dogru bir sekilde goruntulendigini dogrular")
    public void arama_sonuclarinin_dogru_bir_sekilde_goruntulendigini_dogrular() {
        Assert.assertTrue(patientPharmacyPage.searchBox.getText().contains("kır"));
    }

    @When("kullanici {string} sutunundaki {string} butonlarina tiklar")
    public void kullanici_sutunundaki_butonlarina_tiklar(String sutun, String buton) {
        if (buton.equals("View Payments")) {
            patientPharmacyPage.viewPaymentsButton.click();
        } else if (buton.equals("Show")) {
            patientPharmacyPage.showButton.click();
        }
    }

    @Then("bu dugmelerin duzgun calistigini dogrular")
    public void bu_dugmelerin_duzgun_calistigini_dogrular() {
        // Implement logic to verify button functionality
    }

    @When("kullanici bir ogenin {string} dugmesine tiklar")
    public void kullanici_bir_ogenin_dugmesine_tiklar(String button) {
        if (button.equals("Pay")) {
            patientPharmacyPage.payButton.click();
        }
    }

    @And("odeme penceresine negatif bir miktar girer ve {string} dugmesine tiklar")
    public void odeme_penceresine_negatif_bir_miktar_girer_ve_dugmesine_tiklar(String addButton) {
        patientPharmacyPage.paymentInput.sendKeys("-10");
        patientPharmacyPage.addButton.click();
    }

    @Then("sayfanin bu girisimi reddettigini ve sag ust kosede {string} mesaji ciktigini dogrular")
    public void sayfanin_bu_girisimi_reddettigini_ve_sag_ust_kosede_mesaji_ciktigini_dogrular(String mesaj) {
        Assert.assertTrue(patientPharmacyPage.errorMessage.getText().contains(mesaj));
    }

    @And("odeme penceresine miktar girer \\(full or partial amount) ve {string} e tiklar")
    public void odeme_penceresine_miktar_girer_ve_e_tiklar(String addButton) {
        patientPharmacyPage.paymentInput.sendKeys("50");
        patientPharmacyPage.addButton.click();
    }

    @Then("odeme detaylari sayfasinin ve odeme miktarinin olması gerektigi gibi goruntulendigini dogrular")
    public void odeme_detaylari_sayfasinin_ve_odeme_miktarinin_olmasi_gerektigi_gibi_goruntulendigini_dogrular() {
        Assert.assertTrue(patientPharmacyPage.paymentDetailsConfirmation.isDisplayed());
    }
}
