package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
        Assert.assertTrue("name başlığı görüntülendi",doctorOPDPage.OpdName.isDisplayed());
        Assert.assertTrue("patient id başlığı görüntülendi",doctorOPDPage.OpdPatientId.isDisplayed());
        Assert.assertTrue("guardian başlığı görüntülendi",doctorOPDPage.OpdGuardianName.isDisplayed());
        Assert.assertTrue("gender başlığı görüntülendi",doctorOPDPage.OpdGender.isDisplayed());
        Assert.assertTrue("phone başlığı görüntülendi",doctorOPDPage.OpdPhone.isDisplayed());
        Assert.assertTrue("consultant başlığı görüntülendi",doctorOPDPage.OpdConsultant.isDisplayed());
        Assert.assertTrue("last visit başlığı görüntülendi",doctorOPDPage.OpdLastVisit.isDisplayed());
        Assert.assertTrue("total recheckup başlığı görüntülendi",doctorOPDPage.OpdTotalRecheckup.isDisplayed());



        }

    @Then("Opd patient list sayfasida search box olmali")
    public void opd_patient_list_sayfasida_search_box_olmali() {
       Assert.assertTrue("checkbox görünüyor",doctorOPDPage.OpdPatientSearchBox.isDisplayed());
    }
    @Then("searchbox a isim girilip arama yapilabilmeli")
    public void searchbox_a_isim_girilip_arama_yapilabilmeli() {
     doctorOPDPage.OpdPatientSearchBox.sendKeys("damla");
     Assert.assertTrue("Hasta bulundu",doctorOPDPage.OpdBulunanHasta.isDisplayed());
    }
    @When("patient id e tiklanir ve bir numaralı hasta geldigi dogrulanir")
    public void patient_id_e_tiklanir_ve_bir_numaralı_hasta_geldigi_dogrulanir() {
        doctorOPDPage.OpdPatientId.click();
        Assert.assertTrue("Olivier Thomas bulundu",doctorOPDPage.patientIdBulunanHasta.isDisplayed());

    }
    @Then("goruntulenecek hasta sayisi secilir")
    public void goruntulenecek_hasta_sayisi_secilir() {
        doctorOPDPage.OpdGoruntulenecekHastaSayisi.click();
        doctorOPDPage.allHastaSayisi.click();

    }
    @When("show butonuna tiklanir")
    public void show_butonuna_tiklanir() {
        ReusableMethods.bekle(2);
        Actions actions=new Actions(driver);
        actions.moveToElement(doctorOPDPage.OpdPatientShowButton).click().perform();
        logger.info("show butonuna tiklandi");


    }
    @Then("overview sayfasi goruntulenir")
    public void overview_sayfasi_goruntulenir() {
       Assert.assertTrue("Overview sayfasi goruntulendi",doctorOPDPage.doctorOpdOverviewNav.isDisplayed());

    }
    @Then("visits butonuna tiklanir")
    public void visits_butonuna_tiklanir() {
        doctorOPDPage.doctorOpdVisitButton.click();
    }
    @Then("visits sayfasi acilir")
    public void visits_sayfasi_acilir() {
       Assert.assertTrue("Visits sayfasi acildi",doctorOPDPage.visitTextBox.isDisplayed());

    }
    @Then("new visit butonuna tiklanir")
    public void new_visit_butonuna_tiklanir() {
        doctorOPDPage.newVisitsButton.click();
        logger.info("new visits acildi");

    }









}
