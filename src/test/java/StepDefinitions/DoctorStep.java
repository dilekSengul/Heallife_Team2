package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AdminDashboardPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DriverManager;
import utilities.JSUtilities;
import utilities.ReusableMethods;

import java.util.Arrays;
import java.util.List;

public class DoctorStep {
    WebDriver driver = Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(DoctorStep.class);
    LoginPage loginPage = new LoginPage();
    AdminDashboardPage dashboardPage = new AdminDashboardPage();

    @Given("Doktor {string} sitesine gider")
    public void doktor_sitesine_gider(String url) {
        DriverManager.getDriver().get(ConfigReader.getProperty(url));
    }

    @When("Doktor email olarak {string} ve password olarakda {string} ile giriş yapar")
    public void doktor_email_olarak_ve_password_olarakda_ile_giriş_yapar(String email, String password) {
        loginPage.email.sendKeys(ConfigReader.getProperty(email));
        loginPage.password.sendKeys(ConfigReader.getProperty(password));
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
        ReusableMethods.wait(3);
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
        ReusableMethods.wait(3);

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
        ReusableMethods.wait(3);

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

    }

}
