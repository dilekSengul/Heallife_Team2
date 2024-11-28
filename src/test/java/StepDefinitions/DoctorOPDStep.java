package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.DoctorOPDPage;
import pages.DoctorPage;
import pages.LoginPage;
import utilities.ReusableMethods;

import java.util.Arrays;
import java.util.List;

public class DoctorOPDStep {
    WebDriver driver = Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(DoctorOPDStep.class);
    DoctorPage doctorPage = new DoctorPage();
    LoginPage loginPage = new LoginPage();
    DoctorOPDPage doctorOPDPage = new DoctorOPDPage();

    @Given("doktor sidebar da OPD linkine tiklanir")
    public void doktor_sidebar_da_opd_linkine_tiklanir() {
        ReusableMethods.bekle(2);
        doctorOPDPage.doctorSidebarOpd.click();
        ReusableMethods.bekle(2);
        doctorOPDPage.OPDpatientBoxDogrulama.isDisplayed();
    }

    @When("OPD Patient list başlıklari goruntulenmelidir")
    public void opd_patient_list_başlıklari_goruntulenmelidir() {
        logger.info("başlıyor...");
        List<WebElement>opdElements= Arrays.asList(
                doctorOPDPage.OpdName,
                doctorOPDPage.OpdPatientId,
                doctorOPDPage.OpdGuardianName,
                doctorOPDPage.OpdGender,
                doctorOPDPage.OpdPhone,
                doctorOPDPage.OpdConsultant,
                doctorOPDPage.OpdLastVisit,
                doctorOPDPage.OpdTotalRecheckup
        );


        for (WebElement element:opdElements){
            if (element.isDisplayed()) {
                System.out.println(element + " is displayed");
            } else {
                System.out.println(element + " is not displayed");
            }
        }


    }









}
