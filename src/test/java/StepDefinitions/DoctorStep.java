package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.DoctorPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DriverManager;
import utilities.ReusableMethods;

public class DoctorStep {
    WebDriver driver = Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(DoctorStep.class);
    DoctorPage doctorPage=new DoctorPage();
    LoginPage loginPage=new LoginPage();

    @Given("Doktor geçerli url ile giriş yapar")
    public void doktor_geçerli_url_ile_giriş_yapar() {
        DriverManager.getDriver().get(ConfigReader.getProperty("HLadminUrl"));

    }
    @Then("Gecerli User Name girer")
    public void gecerli_user_name_girer() {
        loginPage.email.sendKeys(ConfigReader.getProperty("DoctorMailDamla"));
    }
    @Then("Gecerli password girer")
    public void gecerli_password_girer() {
        loginPage.password.sendKeys(ConfigReader.getProperty("Passwords"));
    }
    @Then("navbar altinda post mesajlari bölümü oldugu dogrulanir")
    public void navbar_altinda_post_mesajlari_bölümü_oldugu_dogrulanir() {
        Assert.assertTrue("Doktor paneli mesaj bölümü görüntülenir",doctorPage.mesajBolumu.isDisplayed());
    }

    @Then("takvim bolumune gelinir")
    public void takvim_bolumune_gelinir() {
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);
    }
    @Then("Month tiklanir ve gun secilir")
    public void month_tiklanir_ve_gun_secilir() {
        doctorPage.monthButton.click();
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(3);

        actions.moveToElement(doctorPage.takvimUzerindeSecilenGun).click().perform();

    }
    @Then("Event title, event date, event color ve event type bolumleri doldurulur")
    public void event_title_event_date_event_color_ve_event_type_bolumleri_doldurulur() {
        doctorPage.eventTitle.sendKeys("deneme");
        doctorPage.eventDate.click();
        doctorPage.secilenGun.click();
        doctorPage.applyButton.click();
        doctorPage.eventColorRed.click();


    }
    @Then("save butonuna tiklanir")
    public void save_butonuna_tiklanir() {
        ReusableMethods.bekle(2);
        doctorPage.newEventSaveButton.click();

    }




}
