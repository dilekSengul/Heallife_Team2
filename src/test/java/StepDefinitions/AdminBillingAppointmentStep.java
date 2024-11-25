package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AdminBillingAppointmentPage;
import utilities.ConfigReader;

import java.util.List;


public class AdminBillingAppointmentStep {
    WebDriver driver = Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(AdminBillingAppointmentStep.class);
    AdminBillingAppointmentPage adminBillingAppointmentPage=new AdminBillingAppointmentPage();


    @Given("Sidbarda {string} a tiklar")
    public void sidbarda_a_tiklar(String menu) {
        adminBillingAppointmentPage.AppointmentMenu.click();

    }

    @When("Appoinment sayfasina yonlendirildigini dogrular")
    public void appoinment_sayfasina_yonlendirildigini_dogrular() {
        String expectedUrl= ConfigReader.getProperty("AdminAppoinmentUrl");
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

    }


    @When("Tablo baslıklarının oldugunu dogrular")
    public void tablo_baslıklarının_oldugunu_dogrular(io.cucumber.datatable.DataTable expectedHeadersTable) {
        List<String> expectedHeaders = expectedHeadersTable.asList();

        // Get actual headers from the web page
        List<String> actualHeaders = adminBillingAppointmentPage.getTableHeaders();
        System.out.println("Expected Headers: " + expectedHeaders);
        System.out.println("Actual Headers: " + actualHeaders);
        Assert.assertEquals(expectedHeaders,actualHeaders);

    }

}
