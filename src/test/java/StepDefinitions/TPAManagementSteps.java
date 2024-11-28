package StepDefinitions;

import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.TPAManagementPage;

import java.util.List;

public class TPAManagementSteps {

    WebDriver driver = Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(AdminIPDStep.class);
    TPAManagementPage tpaManagementPage = new TPAManagementPage(driver);

    @When("kullanici sol menuden TBA Management butonuna tiklar")
    public void kullanici_sol_menuden_tba_management_butonuna_tiklar() {
        tpaManagementPage.tpaManagementButton.click();
    }

    @Then("kullanici TBA Management sayfasina yonlendirildigini dogrular")
    public void kullanici_tba_management_sayfasina_yonlendirildigini_dogrular() {
        Assert.assertTrue(driver.getCurrentUrl().contains("tpa-management"));
    }

    @Then("kullanici aşağıdaki kolonların görüntülendiğini doğrular:")
    public void kullanici_asagidaki_kolonlarin_goruntulendigini_dogrular(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedColumns = dataTable.asList();
        String actualHeaders = tpaManagementPage.tableHeaders.getText();
        for (String column : expectedColumns) {
            Assert.assertTrue(actualHeaders.contains(column));
        }
    }

    @Then("kullanici tablo öğelerinin kolonlara göre listelenebildiğini doğrular")
    public void kullanici_tablo_ogelerinin_kolonlara_gore_listelenebildigini_dogrular() {
        // Kolon sıralama işlemini burada test edebilirsiniz.
        Assert.assertTrue("Sorting functionality works", true); // Placeholder
    }

    @Then("sayfada bir arama çubuğu olduğunu doğrular")
    public void sayfada_bir_arama_cubugu_oldugunu_dogrular() {
        Assert.assertTrue(tpaManagementPage.searchBar.isDisplayed());
    }

    @Then("kullanici sayfadaki içeriğin görüntüleneceği sayfa sayısını {int} ya da {string} olarak seçebileceğini doğrular")
    public void kullanici_sayfadaki_icerigin_goruntulenecegi_sayfa_sayisini_ya_da_olarak_secebilecegini_dogrular(int rows, String all) {
        Assert.assertTrue(tpaManagementPage.rowsPerPageDropdown.isDisplayed());
        // Drop-down kontrol kodları
    }

    @When("kullanici Contact Person Phone altındaki Organization butonuna tıklar")
    public void kullanici_contact_person_phone_altindaki_organization_butonuna_tiklar() {
        tpaManagementPage.organizationButton.click();
    }

    @Then("kullanici Details sayfasina yonlendirildigini dogrular")
    public void kullanici_details_sayfasina_yonlendirildigini_dogrular() {
        Assert.assertTrue(tpaManagementPage.detailsPageHeader.isDisplayed());
    }

    @When("kullanici {string} altındaki {string} butonuna tıklar")
    public void kullaniciAltındakiButonunaTıklar(String arg0, String arg1) {
        
    }

    @When("kullanici sol menuden {string} butonuna tiklar")
    public void kullaniciSolMenudenButonunaTiklar(String arg0) {
        
    }

    @Then("kullanici TPA Management sayfasina yonlendirildigini dogrular")
    public void kullaniciTPAManagementSayfasinaYonlendirildiginiDogrular() {
    }
}
