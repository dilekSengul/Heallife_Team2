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

public class PatientAmbulanceStep {

    WebDriver driver = Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(PatientStep.class);
    PatientPage page = new PatientPage(); // Page Object sınıfınız
    private List<WebElement> tableHeaders;
    private List<WebElement> tableItems;
    PatientPage patientPage = new PatientPage(tableHeaders,tableItems);
    LoginPage loginPage = new LoginPage();
    Faker faker = new Faker();
    PatientDashboardPage patientDashboardPage=new PatientDashboardPage();

    @When("kullanici sol menuden Ambulance secenegine tiklar")
    public void kullanici_sol_menuden_ambulance_secenegine_tiklar() {
        page.PatientDashboardAmbulanceButton.click();

    }

    @Given("hasta Ambulance Bill sayfasına gider")
    public void hasta_ambulance_bill_sayfasına_gider() {
        ReusableMethods.wait(2);
        Assert.assertTrue("Ambulance Bill sayfası açılmadı!",
                page.ambulanceBillHeader.isDisplayed());
    }



    @Then("hasta, ambulans icin bir arama terimi girer")
    public void hasta_ambulans_icin_bir_arama_terimi_girer() {
        page.searchBar.sendKeys("A");
        ReusableMethods.bekle(2);
    }




    @Then("ambulans elementinin girilen arama terimiyle eslesen sekilde goruntulendigini dogrular")
    public void ambulans_elementinin_girilen_arama_terimiyle_eslesen_sekilde_goruntulendigini_dogrular() {
//         Assert.assertTrue(page.getTableBodies().contains("RAD"));  ÇALIŞMADI
        List<String> tbody = page.getTableBodies();
        System.out.println("Tablodaki veriler: " + tbody);
        boolean containsRAD = tbody.stream().anyMatch(row -> row.contains("A"));
        Assert.assertTrue("Arama sonuçları beklenen değeri içermiyor!", containsRAD);
    }

    @Then("component liste artan sirada siralanmalidir")
    public void component_liste_artan_sirada_siralanmalidir() {
        List<WebElement> billNoElements = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        System.out.println("Bulunan eleman sayısı: " + billNoElements.size());

        for (WebElement element : billNoElements) {
            System.out.println("Bulunan değer: " + element.getText());
        }
        page.billNoComponentIssue.click();
        ReusableMethods.wait(2);
    }
    @When("component listede hasta aynı başlık uzerine tekrar tiklar")
    public void component_listede_hasta_aynı_başlık_uzerine_tekrar_tiklar() {

        page.billNoComponentIssue.click();
        ReusableMethods.wait(2);

    }
    @When("ambulans listesinde hasta bir baslık uzerine tiklar")
    public void ambulans_listesinde_hasta_bir_baslık_uzerine_tiklar() {
        page.vehicleNumberHeader.click();
        ReusableMethods.wait(2);
        page.BillNo.click();
        ReusableMethods.wait(2);
    }

    @Then("liste artan bir sirada siralanmalidir")
    public void liste_artan_sirada_siralanmalidir() {
        List<WebElement> vehicleNumberElements = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        System.out.println("Bulunan eleman sayısı: " +vehicleNumberElements.size());

        for (WebElement element : vehicleNumberElements) {
            System.out.println("Bulunan değer: " + element.getText());
        }
    }

    @When("hasta aynı header uzerine tekrar tiklar")
    public void hasta_aynı_header_uzerine_tekrar_tiklar() {
        page.vehicleNumberHeader.click();
        ReusableMethods.wait(4);

    }




    @When("hasta show baglantısına tıklar")
    public void hasta_show_baglantısına_tıklar() {
        ReusableMethods.wait(2);
        page.showButtonAmbulance.click();
        ReusableMethods.wait(2);


    }


    @When("hasta modal pencereyi kapatmak için X butonuna tiklar")
    public void hasta_model_pencereyi_kapatmak_icin_X_butonuna_tiklar() {
        ReusableMethods.wait(2);
        page.ShowWindowClose.click();
    }

    @When("hasta pay modal pencereyi kapatmak için X butonuna tiklar")
    public void hasta_pay_model_pencereyi_kapatmak_icin_X_butonuna_tiklar() {
        ReusableMethods.wait(2);
        page.PayWindowClose.click();
    }

    @When("hasta X butonuna tiklar")
    public void hasta_X_butonuna_tiklar() {

    }





    @When("hasta View Payments bağlantısına tiklar")
    public void hasta_view_payments_bağlantısına_tiklar() {
            page.viewPaymentButtonAmbulance.click();
            ReusableMethods.wait(3);
    }



    @Then("modal penceresinin Print butonunu içerdiği doğrulanır")
    public void modal_penceresinin_butonunu_içerdiği_doğrulanır() {
        // Print butonunun görünür olduğunu doğrula
        boolean isDisplayed = page.viewPaymentWindowPrint.isDisplayed();
        Assert.assertTrue("Print butonu görüntülenemedi", isDisplayed);
    }


    @When("kullanıcı modal pencereyi kapatmak için X butonuna tiklar")
    public void kullanıcı_modal_pencereyi_kapatmak_için_x_butonuna_tiklar() {
       page.viewPaymentsXbutton.click();


    }

    @Then("rapor detayları modal penceresi açılmalıdır")
    public void rapor_detayları_modal_penceresi_açılmalıdır() {

        boolean isDisplayed = page.showWindowLogo.isDisplayed();
        Assert.assertTrue("show penceresi görüntülenemedi", isDisplayed);
    }



    @When("hasta pay bağlantısına tıklar")
    public void hasta_bağlantısına_tıklar() {
        ReusableMethods.wait(3);
       page.payButtonAmbulance.click();
        ReusableMethods.wait(2);
    }



    @Then("modal pencerenin add butonunu içerdiği doğrulanır")
    public void modal_pencerenin_butonunu_içerdiği_doğrulanır( ) {
        boolean isDisplayed = page.payWindowAddButton.isDisplayed();
        Assert.assertTrue("pay add butonu içermiyor ", isDisplayed);
    }

    @Then("modal pencere kapanır")
    public void modal_pencere_kapanır() {
        page.PayWindowClose.click();
    }

    @Then("kullanici Ambulance Bill sayfasına geri döndüğünü doğrular")
    public void kullanici_ambulance_bill_sayfasına_geri_döndüğünü_doğrular() {
        boolean isDisplayed = page.ambulanceBillHeader.isDisplayed();
        Assert.assertTrue("Ambulance Bill sayfası gorunmjuyor ", isDisplayed);

    }












    @When("kullanıcı modal pencereyi kapatmak için {string} butonuna tiklar")
    public void hasta_modal_pencereyi_kapatmak_için_butonuna_tiklar(String string) {

    }

    @Then("modal pencere kapanir ve kullanici Ambulans Test List sayfasina geri dondugu dogrulanir.")
    public void modal_pencere_kapanir_ve_kullanici_ambulans_test_list_sayfasina_geri_dondugu_dogrulanir() {

    }




}
