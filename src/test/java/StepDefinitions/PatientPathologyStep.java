package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PatientDashboardPage;
import pages.PatientPharmacyPage;
import utilities.ReusableMethods;

import java.util.List;

public class PatientPathologyStep {

    WebDriver driver = Hooks.getDriver();
    private List<WebElement> tableHeaders;
    private List<WebElement> tableItems;
    PatientPharmacyPage patientPharmacyPage = new PatientPharmacyPage(tableHeaders,tableItems);
    PatientDashboardPage patientDashboardPage = new PatientDashboardPage();

    @When("kullanici sol menuden Pathology secenegine tiklar")
    public void kullanici_sol_menuden_secenegine_tiklar() {
        patientDashboardPage.pathologyBoard.click();
    }

    @When("kullanici listeden bir ogenin Pay dugmesine tiklar")
    public void kullanici_bir_ogenin_dugmesine_tiklar() {

        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-xs']")).click();

    }

    @Then("Pathology sayfasinin duzgun bir sekilde goruntulendigini dogrular")
    public void pharmacy_sayfasinin_duzgun_bir_sekilde_goruntulendigini_dogrular() {
        Assert.assertTrue(driver.getCurrentUrl().contains("pathology"));
    }


}
