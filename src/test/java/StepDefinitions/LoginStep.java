package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DriverManager;
import utilities.LoggerHelper;

import java.sql.Driver;

public class LoginStep {
    WebDriver driver = Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(LoginStep.class);
    LoginPage loginPage=new LoginPage();

    @Given("Kullanıcı Heal Life sitesine giriş yapar")
    public void kullanıcı_heal_life_sitesine_giriş_yapar() {
        DriverManager.getDriver().get(ConfigReader.getProperty("HLadminUrl"));
    }
    @Then("Login sayfasinin sag tarafinda Admin Login penceresi görüntülenmeli")
    public void login_sayfasinin_sag_tarafinda_admin_login_penceresi_görüntülenmeli() {
        int adminLoginPanelX=loginPage.adminLoginPenceresi.getLocation().getX();
        Assert.assertTrue("Admin login penceresi sagda gorunuyor",adminLoginPanelX>500);
    }
    @Then("Login sayfasinin sol tarafinda Latest New penceresi görüntülenmeli")
    public void login_sayfasinin_sol_tarafinda_latest_new_penceresi_görüntülenmeli() {
        int adminLatestNewX=loginPage.latestNewsPenceresi.getLocation().getY();
        Assert.assertTrue("Latest News Penceresi solda gorunuyor",adminLatestNewX<500);
    }

    @Then("username bolumune dogru email girilir")
    public void username_bolumune_dogru_email_girilir() {
     loginPage.email.sendKeys(ConfigReader.getProperty("DoctorMailDamla"));
    }
    @Then("password bolumune dogru password girilir")
    public void password_bolumune_dogru_password_girilir() {
      loginPage.password.sendKeys(ConfigReader.getProperty("Passwords"));
    }
    @Then("sign in butonuna tiklanir")
    public void sign_in_butonuna_tiklanir() {
       loginPage.signInButton.click();
    }
    @Then("heal life logosu görüntülenir")
    public void heal_life_logosu_görüntülenir() {
        Assert.assertTrue("Heal Life logosu görüntülendi", loginPage.adminLogo.isDisplayed());


        if (loginPage.adminLogo.isDisplayed()) {
            logger.info("Heal Life logosu başarılı bir şekilde görüntüleniyor.");
        } else {
            logger.error("Heal Life logosu görüntülenemedi.");
        }
    }





}



