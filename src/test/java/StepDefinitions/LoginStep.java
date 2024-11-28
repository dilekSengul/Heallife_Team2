package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DriverManager;
import utilities.ReusableMethods;

public class LoginStep {
    WebDriver driver = Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(LoginStep.class);
    LoginPage loginPage=new LoginPage();

    @Given("Kullanıcı Heal Life sitesine giriş yapar")
    public void kullanici_heal_life_sitesine_giris_yapar() {
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

    @Then("username bolumune yanlis data girilir")
    public void username_bolumune_yanlis_data_girilir() {
        loginPage.email.sendKeys("damla@gmail.com");
    }
    @Then("password bolumune yanlis data girilir")
    public void password_bolumune_yanlis_data_girilir() {
        loginPage.password.sendKeys("123456");

    }
    @Then("sisteme giris yapilamadigi ve admin penceresinin gorunur oldugu dogrulanir.")
    public void sisteme_giris_yapilamadigi_ve_admin_penceresinin_gorunur_oldugu_dogrulanir() {
       Assert.assertTrue("Admin login penceresi görüntülenir, sisteme giriş yapilamadi",loginPage.adminLoginPenceresi.isDisplayed());
    }

    @Then("forgot password linkine tiklanir")
    public void forgot_password_linkine_tiklanir() {
    loginPage.adminForgotPassword.click();
    }
    @Then("email alanina dogru data girilir")
    public void email_alanina_dogru_data_girilir() {
    loginPage.adminForgotPasswordEmail.sendKeys("damla@gmail.com");
    }
    @Then("submit butonuna tiklanir")
    public void submit_butonuna_tiklanir() {
        loginPage.adminForgotPasswordSubmitButton.click();

    }
    @Then("textbox a girilen mail adresine sifre geldigi ustteki bilgi kutucugu ile dogrulanir")
    public void textbox_a_girilen_mail_adresine_sifre_geldigi_ustteki_bilgi_kutucugu_ile_dogrulanir() {
    Assert.assertTrue("Bilgi kutusu görüntülenir.",loginPage.forgotPasswordAlert.isDisplayed());
    }

    @Then("admin login linkine tiklanir")
    public void admin_login_linkine_tiklanir() {
        loginPage.adminLoginLink.click();
    }
    @Then("admin anasayfasinda oldugu dogrulanir")
    public void admin_anasayfasinda_oldugu_dogrulanir() {
      Assert.assertTrue("Anasayfaya geri dönüş sağlandi",loginPage.adminLoginPenceresi.isDisplayed());
    }

    @Given("Kullanici Heal Life {string}  girer")
    public void kullanici_heal_life_girer(String adminUrlKey) {
        String adminUrl=ConfigReader.getProperty(adminUrlKey);
       driver.get(adminUrl);
    }
    @Then("Login sayfasinin sag tarafinda Admin Login penceresi görüntülendigini dogrular")
    public void login_sayfasinin_sag_tarafinda_admin_login_penceresi_görüntülendigini_dogrular() {

        loginPage.verifySectionVisibilityAndPosition("//div[@class='form-bottom']", "Admin Giriş bölümü", "sağ"
        );

    }
    @Then("Login sayfasinin sol tarafinda Latest New penceresi görüntülendigini dogrular")
    public void login_sayfasinin_sol_tarafinda_latest_new_penceresi_görüntülendigini_dogrular() {


        loginPage.verifySectionVisibilityAndPosition("//div[@class='col-lg-6 col-sm-6 col-sm-6']", "Latest Nes", "sol");
    }

    @When("User Name Box tiklar")
    public void user_name_box_tiklar() {

        loginPage.email.click();
    }
    @Then("Gecerli User Name {string} Girer")
    public void gecerli_user_name_girer(String  gecerliMail) {
        loginPage.email.sendKeys(gecerliMail);
    }
    @Then("Password Box tiklar")
    public void password_box_tiklar() {
       loginPage.password.click();
    }
    @Then("Gecerli password {string} girer")
    public void gecerli_password_girer(String gecerliPassword) {
       loginPage.password.sendKeys(gecerliPassword);
    }
    @Then("Admin paneline yonlendirildigini dogrular")
    public void admin_paneline_yonlendirildigini_dogrular() {
       String expectedUrl=ConfigReader.getProperty("AdminDasboardUrl");
       String actualUrl=driver.getCurrentUrl();
       Assert.assertEquals(expectedUrl,actualUrl);
    }
    @Then("Admin paneline giris yapilamadigini dogrular")
    public void admin_paneline_giris_yapilamadigini_dogrular() {

        loginPage.forgotPasswordAlert.isDisplayed();
    }
    @Then("Forgot Password yazisinin gorunurlugunu dogrular")
    public void forgot_password_yazisinin_gorunurlugunu_dogrular() {
       Assert.assertTrue(loginPage.adminForgotPassword.isDisplayed());
    }
    @Then("Forgot Password'a tiklar")
    public void forgot_password_a_tiklar() {

        loginPage.adminForgotPassword.click();
    }
    @Then("Forgot Password sayfasina yonlendirildigini dogrular")
    public void forgot_password_sayfasina_yonlendirildigini_dogrular() {

        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("forgotpassword"));
    }

    @Then("E mail box'ina {string} girer")
    public void e_mail_box_ina_girer(String email) {
        loginPage.adminForgotPasswordEmail.sendKeys(email);
    }
    @Then("Submit butonuna tıklar")
    public void submit_butonuna_tıklar() {
        loginPage.adminForgotPasswordSubmitButton.click();
    }

    @Then("Admin Login linkinin gorunurlugunu dogrular")
    public void admin_login_linkinin_gorunurlugunu_dogrular() {
       Assert.assertTrue(loginPage.adminLoginLink.isDisplayed());
    }


    //BAŞARILI PATIENT (USER) / ADMIN LOGIN STEPLERI

        @Given("kullanici {string} adresine gider")
        public void kullanici_adresine_gider(String url) {
            driver.get(ConfigReader.getProperty(url));
        }

        @And("geçerli bir email adresi {string} ve sifre {string} girer")
        public void gecerli_bir_email_adresi_ve_sifre_girer(String email, String sifre) {
            loginPage.email.sendKeys(ConfigReader.getProperty(email));
            loginPage.password.sendKeys(ConfigReader.getProperty(sifre));
        }

        @When("Sign In butonuna tıklar")
        public void giris_butonuna_tiklar() {
            loginPage.signInButton.click();
        }
        @Then("dashboard duzgun bir şekilde goruntulenir")
        public void ana_sayfa_duzgun_bir_sekilde_goruntulenir() {
            Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        }

    //Bu stepleri farklı feature'larda userDash girişi için standard background olarak kullanabiliriz.

    @Then("Kullanıcı Heal Life sitesine giris yapar")
    public void kullanıcıHealLifeSitesineGirisYapar() {
        driver.manage().deleteAllCookies();
        driver.get("https://qa.heallifehospital.com/site/login");
    }

    @And("Kulllanci Username bax icine admin adini giris yapar")
    public void kulllanciUsernameBaxIcineAdminAdiniGirisYapar() {
        loginPage.email.sendKeys(ConfigReader.getProperty("AdminMailLevent"));
    }

    @And("Kullanici password bolumune admin password girsi yapar")
    public void kullaniciPasswordBolumuneAdminPasswordGirsiYapar() {
        loginPage.password.sendKeys(ConfigReader.getProperty("Passwords"));
    }

    @And("Kullanici Signin Buttonu tiklar")
    public void kullaniciSigninButtonuTiklar() {
        loginPage.signInButton.click();
    }



    @And("loginButton'una tıklayarak ve kullanııc adı ve şifre ile giriş yapar")
    public void loginbuttonUnaTıklayarakVeKullanııcAdıVeŞifreIleGirişYapar() {
        loginPage.email.click();
        loginPage.email.sendKeys(ConfigReader.getProperty("pat116"));
        loginPage.password.click();
        loginPage.password.sendKeys(ConfigReader.getProperty("4bwui5"));
    }

    @And("geçerli bir email adresi \\{string} ve sifre \\{string} girer")
    public void geçerliBirEmailAdresiStringVeSifreStringGirer() {
        loginPage.email.click();
        loginPage.email.sendKeys(ConfigReader.getProperty("pat116"));
        ReusableMethods.bekle(100);
        loginPage.password.click();
        loginPage.password.sendKeys(ConfigReader.getProperty("4bwui5"));
    }
}



