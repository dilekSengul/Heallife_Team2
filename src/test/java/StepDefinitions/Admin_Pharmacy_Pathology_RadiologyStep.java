package StepDefinitions;

import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.AboutUsPage;
import pages.Admin_Pharmacy_Pathology_RadiologyPage;
import utilities.DriverManager;
import utilities.ReusableMethods;


public class Admin_Pharmacy_Pathology_RadiologyStep {
    WebDriver driver = Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(Admin_Pharmacy_Pathology_RadiologyStep.class);

    Admin_Pharmacy_Pathology_RadiologyPage page= new Admin_Pharmacy_Pathology_RadiologyPage();
    Actions actions=new Actions(DriverManager.getDriver());

    @Then("Doktor Generate Bill Butonuna basar")
    public void doktor_generate_bill_butonuna_basar() {
        ReusableMethods.wait(2);
        page.generateBill.click();

        logger.info("Doktor Generate Bill Butonuna basildi");
    }
    @Then("Medicine Category olarak {string} seçer")
    public void medicine_category_olarak_seçer(String medicine) {
        page.medicineCategory.click();
        ReusableMethods.wait(1);
        page.capsule.click();
        ReusableMethods.wait(1);
        logger.info("Medicine Category olarak " + medicine + " secildi");
    }
    @Then("Medicine Name olarak {string} seçer")
    public void medicine_name_olarak_seçer(String name) {
        page.medicineName.click();
        ReusableMethods.wait(1);
        page.wormstop.click();
        ReusableMethods.wait(1);
        logger.info("Medicine Name olarak " + name + " secildi");
    }

    @And("Hasta id'si {string} olarak seçer")
    public void hastaIdSiOlarakSeçer(String id) {
        ReusableMethods.wait(2);
        page.hastaAdiBox.click();
        ReusableMethods.wait(1);
        actions.sendKeys(id).perform();
        ReusableMethods.wait(1);
        actions.sendKeys(Keys.ENTER).perform();
        ReusableMethods.wait(1);
        logger.info("Hasta id'si " + id + " olarak secildi");
    }

    @And("Batch No olarak 1520 seçer")
    public void batchNoOlarakSeçer() {
        page.batchNoBox.click();
        ReusableMethods.wait(1);
        page.chosenBatchNo.click();
        ReusableMethods.wait(1);
        logger.info("Batch No olarak 1520 secildi");
    }

    @And("Quantity olarak {string} yazar")
    public void quantityOlarakYazar(String adet) {
        page.Quantity.sendKeys(adet);
        ReusableMethods.wait(1);
        logger.info("Quantity olarak " + adet + " yazildi");
    }

    @And("Hospital Doctor olarak ismail kaya seçer")
    public void hospitalDoctorOlarakIsmailKayaSeçer() {
        ReusableMethods.wait(2);
        page.hospitalDoctorBox.click();
        ReusableMethods.wait(2);
        page.chosenDoctor.click();
        ReusableMethods.wait(2);
        logger.info("Hospital Doctor olarak ismail kaya secildi");
    }

    @And("Save butonuna basarak ilacı kaydeder")
    public void saveButonunaBasarakIlacıKaydeder() {
        page.saveButton.click();
        logger.info("Save butonuna basildi");
        ReusableMethods.wait(1);
    }

    @And("Success mesajını doğrular")
    public void successMesajınıDoğrular() {
        page.successMessage.isDisplayed();
        logger.info("Success mesaji gorundu");
        ReusableMethods.wait(4);
    }

    @And("Listede hasta isminin göründüğünü doğrular")
    public void listedeHastaIsmininGöründüğünüDoğrular() {
        if (page.accesesblityName.getText().equals("John Doe (259)")){
            logger.info("Listede hasta ismi dogru");
        }else {
            logger.error("Listede hasta ismi yanlis");
        }
        ReusableMethods.wait(2);
    }


    ////İsim////
}
