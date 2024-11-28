package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
import org.openqa.selenium.WebElement;
import pages.AdminDashboardPage;
import utilities.JSUtilities;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;


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
        assertTrue("Doktor paneli mesaj bölümü görüntülenir",doctorPage.mesajBolumu.isDisplayed());
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





    AdminDashboardPage dashboardPage = new AdminDashboardPage();

    @Given("Doktor {string} sitesine gider")
    public void doktor_sitesine_gider(String url) {
        DriverManager.getDriver().get(ConfigReader.getProperty(url));
        ReusableMethods.wait(2);
    }

    @When("Doktor email olarak {string} ve password olarakda {string} ile giriş yapar")
    public void doktor_email_olarak_ve_password_olarakda_ile_giriş_yapar(String email, String password) {
        loginPage.email.sendKeys(ConfigReader.getProperty(email));
        loginPage.password.sendKeys(ConfigReader.getProperty(password));
        ReusableMethods.wait(2);
        loginPage.signInButton.click();
        logger.info("Doktor email olarak " + email + " ve password olarakda " + password + " ile giriş yapar.");

    }

    @Then("Doktor sayfasında Dashboard SideBar'da menüleri görünür ve aktif olmalı")
    public void doktor_sayfasında_dashboard_side_bar_da_menüleri_görünür_ve_aktif_olmalı() {
        List<WebElement> menus = Arrays.asList(
                dashboardPage.DashboardMenu,
                dashboardPage.BillingMenu,
                dashboardPage.AppointmentMenu,
                dashboardPage.OPDMenu,
                dashboardPage.IPDMenu,
                dashboardPage.PharmacyMenu,
                dashboardPage.PathologyMenu,
                dashboardPage.RadiologyMenu,
                dashboardPage.BloodBankMenu,
                dashboardPage.AmbulanceMenu,
                dashboardPage.BirthDeathRecordMenu,
                dashboardPage.HumanResourceMenu,
                dashboardPage.TPAManagementMenu,
                dashboardPage.MessagingMenu,
                dashboardPage.LiveConsultationMenu
        );

        List<String> menuNames = Arrays.asList(
                "Dashboard",
                "Billing",
                "Appointment",
                "OPD",
                "IPD",
                "Pharmacy",
                "Pathology",
                "Radiology",
                "BloodBank",
                "Ambulance",
                "BirthDeathRecord",
                "HumanResource",
                "TPAManagement",
                "Messaging",
                "LiveConsultation"
        );

        for (int i = 0; i < menus.size(); i++) {
            WebElement menu = menus.get(i);
            String menuName = menuNames.get(i);
            if (menu.isDisplayed() && menu.isEnabled()) {
                logger.info("Doktor sayfasında " + menuName + " SideBar'da menüleri görünür ve aktif oldu.");
            } else {
                logger.error("Doktor sayfasında " + menuName + " SideBar'da menüleri görünür ve aktif değil!!");
            }
        }


        JSUtilities.scrollToElement(DriverManager.getDriver(), dashboardPage.SetupMenu);

        if (dashboardPage.SetupMenu.isDisplayed() && dashboardPage.SetupMenu.isEnabled()) {
            logger.info("Doktor sayfasında Setup SideBar'da menüleri görünür ve aktif oldu.");
        } else {
            logger.error("Doktor sayfasında Setup SideBar'da menüleri görünür ve aktif değil!!");
        }

        dashboardPage.SetupMenu.click();
        ReusableMethods.wait(2);
        JSUtilities.scrollToElement(DriverManager.getDriver(), dashboardPage.SetupAppointmentMenu);

        List<WebElement> SetupMenus = Arrays.asList(
                dashboardPage.SetupAppointmentMenu,
                dashboardPage.SetupSymptomsMenu,
                dashboardPage.SetupBloodBankMenu,
                dashboardPage.SetupRadiologyMenu,
                dashboardPage.SetupPathologyMenu,
                dashboardPage.SetupPharmacyMenu,
                dashboardPage.SetupPrintHeaderFooterMenu,
                dashboardPage.SetupBedMenu,
                dashboardPage.SetupHospitalChargesMenu,
                dashboardPage.SetupPatientMenu
        );

        List<String> SetupMenuNames = Arrays.asList(
                "SetupAppointment",
                "SetupSymptoms",
                "SetupBloodBank",
                "SetupRadiology",
                "SetupPathology",
                "SetupPharmacy",
                "SetupPrintHeaderFooter",
                "SetupBed",
                "SetupHospitalCharges",
                "SetupPatient"
        );

        for (int i = 0; i < SetupMenus.size(); i++) {
            WebElement SetupMenu = SetupMenus.get(i);
            String SetupMenuName = SetupMenuNames.get(i);
            if (SetupMenu.isDisplayed() && SetupMenu.isEnabled()) {
                logger.info("Doktor sayfasında " + SetupMenuName + " SideBar'da menüleri görünür ve aktif oldu.");
            } else {
                logger.error("Doktor sayfasında " + SetupMenuName + " SideBar'da menüleri görünür ve aktif değil!!");
            }

        }

        dashboardPage.LiveConsultationMenu.click();
        ReusableMethods.wait(2);

        if (dashboardPage.LiveConsultationMenu2.isDisplayed() && dashboardPage.LiveConsultationMenu2.isEnabled()) {
            logger.info("Doktor sayfasında Live Consultation SideBar'da menüleri görünür ve aktif oldu.");
        } else {
            logger.error("Doktor sayfasında Live Consultation SideBar'da menüleri görünür ve aktif değil!!");
        }

        if (dashboardPage.LiveMeetingMenu.isDisplayed() && dashboardPage.LiveMeetingMenu.isEnabled()) {
            logger.info("Doktor sayfasında Live Meeting SideBar'da menüleri görünür ve aktif oldu.");
        } else {
            logger.error("Doktor sayfasında Live Meeting SideBar'da menüleri görünür ve aktif değil!!");
        }

        dashboardPage.BirthDeathRecordMenu.click();
        ReusableMethods.wait(2);

        if (dashboardPage.BirthRecordMenu.isDisplayed() && dashboardPage.BirthRecordMenu.isEnabled()) {
            logger.info("Doktor sayfasında Birth Record SideBar'da menüleri görünür ve aktif oldu.");
        } else {
            logger.error("Doktor sayfasında Birth Record SideBar'da menüleri görünür ve aktif değil!!");
        }

        if (dashboardPage.DeathRecordMenu.isDisplayed() && dashboardPage.DeathRecordMenu.isEnabled()) {
            logger.info("Doktor sayfasında Death Record SideBar'da menüleri görünür ve aktif oldu.");
        } else {
            logger.error("Doktor sayfasında Death Record SideBar'da menüleri görünür ve aktif değil!!");
        }
    }


    @Then("Doktor browser kapatır")
    public void doktor_browser_kapatır() {
        DriverManager.quitDriver();
        logger.info("Browser kapatıldı.");
    }

    @Then("Doktor sayfasında Dashboard SideBar'daki menüler dogru sayfaya ulmaşmalı")
    public void doktor_sayfasında_dashboard_side_bar_daki_menüler_dogru_sayfaya_ulmaşmalı() {
        ReusableMethods.navigateAndAssert("Dashboard", dashboardPage.DashboardMenu, "https://qa.heallifehospital.com/admin/admin/dashboard", logger);
        ReusableMethods.navigateAndAssert("Billing", dashboardPage.BillingMenu, "https://qa.heallifehospital.com/admin/bill/dashboard", logger);
        ReusableMethods.navigateAndAssert("Appointment", dashboardPage.AppointmentMenu, "https://qa.heallifehospital.com/admin/appointment/index", logger);
        ReusableMethods.navigateAndAssert("OPD", dashboardPage.OPDMenu, "https://qa.heallifehospital.com/admin/patient/search", logger);
        ReusableMethods.navigateAndAssert("IPD", dashboardPage.IPDMenu, "https://qa.heallifehospital.com/admin/patient/ipdsearch", logger);
        ReusableMethods.navigateAndAssert("Pharmacy", dashboardPage.PharmacyMenu, "https://qa.heallifehospital.com/admin/pharmacy/bill", logger);
        ReusableMethods.navigateAndAssert("Pathology", dashboardPage.PathologyMenu, "https://qa.heallifehospital.com/admin/pathology/gettestreportbatch", logger);
        ReusableMethods.navigateAndAssert("Radiology", dashboardPage.RadiologyMenu, "https://qa.heallifehospital.com/admin/radio/gettestreportbatch", logger);
        ReusableMethods.navigateAndAssert("Blood Bank", dashboardPage.BloodBankMenu, "https://qa.heallifehospital.com/admin/bloodbankstatus/", logger);
        ReusableMethods.navigateAndAssert("Ambulance", dashboardPage.AmbulanceMenu, "https://qa.heallifehospital.com/admin/vehicle/getcallambulance", logger);
        ReusableMethods.navigateAndAssert("Human Resource", dashboardPage.HumanResourceMenu, "https://qa.heallifehospital.com/admin/staff", logger);
        ReusableMethods.navigateAndAssert("TPA Management", dashboardPage.TPAManagementMenu, "https://qa.heallifehospital.com/admin/tpamanagement", logger);
        ReusableMethods.navigateAndAssert("Messaging", dashboardPage.MessagingMenu, "https://qa.heallifehospital.com/admin/notification", logger);
        JSUtilities.scrollToElement(DriverManager.getDriver(), dashboardPage.BirthDeathRecordMenu);
        dashboardPage.BirthDeathRecordMenu.click();
        JSUtilities.scrollToElement(DriverManager.getDriver(), dashboardPage.BirthRecordMenu);
        ReusableMethods.navigateAndAssert("Birth Record", dashboardPage.BirthRecordMenu, "https://qa.heallifehospital.com/admin/birthordeath", logger);
        ReusableMethods.navigateAndAssert("Death Record", dashboardPage.DeathRecordMenu, "https://qa.heallifehospital.com/admin/birthordeath/death", logger);
        JSUtilities.scrollToElement(DriverManager.getDriver(), dashboardPage.LiveConsultationMenu);
        dashboardPage.LiveConsultationMenu.click();
        JSUtilities.scrollToElement(DriverManager.getDriver(), dashboardPage.LiveConsultationMenu2);
        ReusableMethods.navigateAndAssert("Live Consultation", dashboardPage.LiveConsultationMenu2, "https://qa.heallifehospital.com/admin/zoom_conference/consult", logger);
        ReusableMethods.navigateAndAssert("Live Meeting", dashboardPage.LiveMeetingMenu, "https://qa.heallifehospital.com/admin/zoom_conference/meeting", logger);
        JSUtilities.scrollToElement(DriverManager.getDriver(), dashboardPage.SetupMenu);
        dashboardPage.SetupMenu.click();
        JSUtilities.scrollToElement(DriverManager.getDriver(), dashboardPage.SetupAppointmentMenu);
        ReusableMethods.navigateAndAssert("Setup Patient", dashboardPage.SetupPatientMenu, "https://qa.heallifehospital.com/admin/admin/search", logger);
        ReusableMethods.navigateAndAssert("Setup Hospital Charges", dashboardPage.SetupHospitalChargesMenu, "https://qa.heallifehospital.com/admin/charges", logger);
        ReusableMethods.navigateAndAssert("Setup Bed", dashboardPage.SetupBedMenu, "https://qa.heallifehospital.com/admin/setup/bed/status", logger);
        ReusableMethods.navigateAndAssert("Setup Print Header/Footer", dashboardPage.SetupPrintHeaderFooterMenu, "https://qa.heallifehospital.com/admin/printing", logger);
        ReusableMethods.navigateAndAssert("Setup Pharmacy", dashboardPage.SetupPharmacyMenu, "https://qa.heallifehospital.com/admin/medicinecategory/medicine", logger);
        ReusableMethods.navigateAndAssert("Setup Pathology", dashboardPage.SetupPathologyMenu, "https://qa.heallifehospital.com/admin/pathologycategory/addcategory", logger);
        ReusableMethods.navigateAndAssert("Setup Radiology", dashboardPage.SetupRadiologyMenu, "https://qa.heallifehospital.com/admin/lab/addlab", logger);
        ReusableMethods.navigateAndAssert("Setup Blood Bank", dashboardPage.SetupBloodBankMenu, "https://qa.heallifehospital.com/admin/bloodbank/products", logger);
        ReusableMethods.navigateAndAssert("Setup Symptoms", dashboardPage.SetupSymptomsMenu, "https://qa.heallifehospital.com/admin/symptoms", logger);
        ReusableMethods.navigateAndAssert("Setup Appointment", dashboardPage.SetupAppointmentMenu, "https://qa.heallifehospital.com/admin/onlineappointment/", logger);
    }

    @Then("Doktor sayfasında Hamburger menüye tıklayıp SideBar'ı kapatır")
    public void doktor_sayfasında_hamburger_menüye_tıklayıp_side_bar_ı_kapatır() {
        dashboardPage.HamburgerMenu.click();
    }
    @Then("Doktor sayfasında Dashboard SideBar'ı kapalı oldugunda iconlar gorunur olmalı")
    public void doktor_sayfasında_dashboard_side_bar_ı_kapalı_oldugunda_iconlar_gorunur_olmalı() {
        List<WebElement> menus = Arrays.asList(
                dashboardPage.DashboardIcon,
                dashboardPage.BillingIcon,
                dashboardPage.AppointmentIcon,
                dashboardPage.OPDIcon,
                dashboardPage.IPDIcon,
                dashboardPage.PharmacyIcon,
                dashboardPage.PathologyIcon,
                dashboardPage.RadiologyIcon,
                dashboardPage.BloodBankIcon,
                dashboardPage.AmbulanceIcon,
                dashboardPage.BirthDeathRecordIcon,
                dashboardPage.HumanResourceIcon,
                dashboardPage.TPAManagementIcon,
                dashboardPage.MessagingIcon,
                dashboardPage.LiveConsultationIcon,
                dashboardPage.SetupMenu

        );

        List<String> menuNames = Arrays.asList(
                "Dashboard",
                "Billing",
                "Appointment",
                "OPD",
                "IPD",
                "Pharmacy",
                "Pathology",
                "Radiology",
                "BloodBank",
                "Ambulance",
                "BirthDeathRecord",
                "HumanResource",
                "TPAManagement",
                "Messaging",
                "LiveConsultation",
                "Setup"
        );

        for (int i = 0; i < menus.size(); i++) {
            WebElement menu = menus.get(i);
            String menuName = menuNames.get(i);

            if (menu.isDisplayed() && menu.isEnabled()) {
                logger.info("Doktor sayfasında " + menuName + " SideBar'da iconu görünür ve aktif oldu.");
            }

            if (!menu.isDisplayed() && !menu.isEnabled()) {
                JSUtilities.scrollToElement(DriverManager.getDriver(), menu);
                ReusableMethods.wait(2); // 2 saniye bekleme (elementin yüklenmesi için)
                if (menu.isDisplayed() && menu.isEnabled()){
                    logger.info("Doktor sayfasında " + menuName + " SideBar'da iconu görünür ve aktif oldu.");
                }else{
                    logger.error("Doktor sayfasında " + menuName + " SideBar'da iconu görünür ve aktif değil!!");
                }
            }


        }


    }


    @Then("calisan sayisi bolumune gelinir")
    public void calisan_sayisi_bolumune_gelinir() {
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

    }
    @Then("accountant in {int} oldugu dogrulanir")
    public void accountant_in_oldugu_dogrulanir(Integer int1) {
        String actualNumberText=doctorPage.accountantNumber.getText();
        Integer actualNumber=Integer.parseInt(actualNumberText);
        Assert.assertEquals("Accountant sayisi dogru",int1,actualNumber);


    }
    @Then("doctor un {int} oldugu dogrulanir")
    public void doctor_un_oldugu_dogrulanir(Integer int1) {

        String actualNumberText=doctorPage.doctorNumber.getText();
        Integer actualNumber=Integer.parseInt(actualNumberText);
        Assert.assertEquals("Doctor sayisi dogru",int1,actualNumber);
    }
    @Then("pharmacist in {int} oldugu dogrulanir")
    public void pharmacist_in_oldugu_dogrulanir(Integer int1) {

        String actualNumberText=doctorPage.pharmacistNumber.getText();
        Integer actualNumber=Integer.parseInt(actualNumberText);
        Assert.assertEquals("Phamacist sayisi dogru",int1,actualNumber);
    }
    @Then("pathologist in {int} oldugu dogrulanir")
    public void pathologist_in_oldugu_dogrulanir(Integer int1) {
        String actualNumberText=doctorPage.pathologistNumber.getText();
        Integer actualNumber=Integer.parseInt(actualNumberText);
        Assert.assertEquals("Pathologist sayisi dogru",int1,actualNumber);
    }
    @Then("radiologist in {int} oldugu dogrulanir")
    public void radiologist_in_oldugu_dogrulanir(Integer int1) {
        String actualNumberText=doctorPage.radiologistNumber.getText();
        Integer actualNumber=Integer.parseInt(actualNumberText);
        Assert.assertEquals("Radiologist sayisi dogru",int1,actualNumber);
    }
    @Then("super admin in {int} oldugu dogrulanir")
    public void super_admin_in_oldugu_dogrulanir(Integer int1) {
        String actualNumberText=doctorPage.superAdminNumber.getText();
        Integer actualNumber=Integer.parseInt(actualNumberText);
        Assert.assertEquals("Super Admin sayisi dogru",int1,actualNumber);
    }
    @Then("receptionist in {int} oldugu dogrulanir")
    public void receptionist_in_oldugu_dogrulanir(Integer int1) {
        String actualNumberText=doctorPage.receptionistNumber.getText();
        Integer actualNumber=Integer.parseInt(actualNumberText);
        Assert.assertEquals("Receptionist sayisi dogru",int1,actualNumber);
    }
    @Then("Nurse in {int} oldugu dogrulanir")
    public void nurse_in_oldugu_dogrulanir(Integer int1) {
        String actualNumberText=doctorPage.nurseNumber.getText();
        Integer actualNumber=Integer.parseInt(actualNumberText);
        Assert.assertEquals("Nurse sayisi dogru",int1,actualNumber);
        logger.info("çalışan sayilari dogrulandi");
    }
    @Then("kullanici doctor a tiklar")
    public void kullanici_doctor_a_tiklar() {
        doctorPage.doctorText.click();
    }
    @Then("human resources sayfasina yönlendirdigi test edilir")
    public void human_resources_sayfasina_yönlendirdigi_test_edilir() {
        String currentURL=driver.getCurrentUrl();

        if (currentURL.contains("staff")) {
            logger.info("Yönlendirme başarılı. Mevcut URL: " + currentURL);
        } else {
            logger.error("Yönlendirme başarısız! Mevcut URL: " + currentURL);
        }

        // Human Resources sayfasına yönlendirme başarılı mı?
        assertTrue("Human Resources sayfasına yönlendirilmedi!", currentURL.contains("staff"));
    }



}
