package StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AboutUsPage;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class AboutUsStep {
    WebDriver driver = Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(AboutUsStep.class);
    AboutUsPage page = new AboutUsPage();

    //Levent//
    @When("Kullanici header bolumunde yer alan AboutUs tiklar")
    public void kullanici_header_bolumunde_yer_alan_about_us_tiklar() {
        page.aboutUsButton.click();
        ReusableMethods.wait(4);
    }
    @Then("Kullanici asagidaki seceklerin alt About menusunde oldugunu dogrular")
    public void kullanici_asagidaki_seceklerin_alt_about_menusunde_oldugunu_dogrular(io.cucumber.datatable.DataTable dataTable) {
        // Verilen tabloyu listeye dönüştür
        List<String> expectedOptions = dataTable.asList();



        // About Us dropdown menüsündeki seçenekleri topla
        WebElement aboutMenu = page.aboutUsButton; // 'aboutMenu' id'yi kendi uygulamanıza göre değiştirin
        aboutMenu.click(); // Menü açılır

        List<WebElement> actualOptionsElements = page.aboutUsMenuDMM2; // XPath'i uygulamaya göre düzenle
        List<String> actualOptions = new ArrayList<>();
        for (WebElement option : actualOptionsElements) {
            actualOptions.add(option.getText());
        }
        System.out.println(expectedOptions);
        System.out.println(actualOptions);
        // Beklenen seçeneklerle mevcut seçenekleri karşılaştır
        Assert.assertEquals(expectedOptions, actualOptions);
    }
    }

    //Levent//


    @When("Ana sayfanın üst kısmında {string} menüsünün üzerine gelir")
    public void ana_sayfanın_üst_kısmında_menüsünün_üzerine_gelir(String menuName) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement aboutUsMenu = page.aboutUsDropdownMenu;
        actions.moveToElement(aboutUsMenu).perform();
        //aboutUsMenu.click();
        logger.info(menuName + " menüsünün üzerine gelindi.");
    }

    @When("Kullanıcı About Hospitals başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular")
    public void kullanıcı_about_hospitals_başlığına_tıkladığında_ilgili_sayfaya_yönlendirildiğini_doğrular() {
        page.aboutHospitalsLink.click();
        // Sayfa URL'sinin doğruluğunu kontrol et
        String expectedUrl = "https://qa.heallifehospital.com/page/about-hospitals";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("Kullanıcı About Hospitals sayfasına yönlendirilemedi", expectedUrl, actualUrl);
    }

    @When("Kullanıcı Meet Our Doctors başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular")
    public void kullanıcı_meet_our_doctors_başlığına_tıkladığında_ilgili_sayfaya_yönlendirildiğini_doğrular() {
        page.Home.click();
        page.aboutUsDropdownMenu.click();
        page.meetOurDoctorsLink.click();
        // Sayfa URL'sinin doğruluğunu kontrol et
        String expectedUrl = "https://qa.heallifehospital.com/page/meet-our-doctors";
        String actualUrl = driver.getCurrentUrl();

        // URL kontrolü
        Assert.assertEquals("Kullanıcı Meet Our Doctors sayfasına yönlendirilemedi", expectedUrl, actualUrl);
    }

    @When("Kullanıcı FAQ's başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular")
    public void kullanıcı_faq_s_başlığına_tıkladığında_ilgili_sayfaya_yönlendirildiğini_doğrular() {
        // İlk olarak Home sayfasına tıklanır
        page.Home.click();

        // About Us dropdown menüsüne tıklanır
        page.aboutUsDropdownMenu.click();

        // FAQ's linkine tıklanır
        page.faqsLink.click();

        // Sayfa URL'sinin doğruluğunu kontrol et
        String expectedUrl = "https://qa.heallifehospital.com/page/faq";  // FAQ's sayfasının URL'si
        String actualUrl = driver.getCurrentUrl();

        // URL kontrolü
        Assert.assertEquals("Kullanıcı FAQ's sayfasına yönlendirilemedi", expectedUrl, actualUrl);
    }

    @When("Kullanıcı Departments başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular")
    public void kullanıcı_departments_başlığına_tıkladığında_ilgili_sayfaya_yönlendirildiğini_doğrular() {
        // İlk olarak Home sayfasına tıklanır
        page.Home.click();

        // About Us dropdown menüsüne tıklanır
        page.aboutUsDropdownMenu.click();

        // Departments linkine tıklanır
        page.departmentsLink.click();

        // Sayfa URL'sinin doğruluğunu kontrol et
        String expectedUrl = "https://qa.heallifehospital.com/page/departments";  // Departments sayfasının URL'si
        String actualUrl = driver.getCurrentUrl();

        // URL kontrolü
        Assert.assertEquals("Kullanıcı Departments sayfasına yönlendirilemedi", expectedUrl, actualUrl);
    }

    @When("Kullanıcı Testimonials başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular")
    public void kullanıcı_testimonials_başlığına_tıkladığında_ilgili_sayfaya_yönlendirildiğini_doğrular() {
        // İlk olarak Home sayfasına tıklanır
        page.Home.click();

        // About Us dropdown menüsüne tıklanır
        page.aboutUsDropdownMenu.click();

        // Testimonials linkine tıklanır
        page.testimonialsLink.click();

        // Sayfa URL'sinin doğruluğunu kontrol et
        String expectedUrl = "https://qa.heallifehospital.com/page/testimonials";  // Testimonials sayfasının URL'si
        String actualUrl = driver.getCurrentUrl();

        // URL kontrolü
        Assert.assertEquals("Kullanıcı Testimonials sayfasına yönlendirilemedi", expectedUrl, actualUrl);
    }

    @Then("Some Words About Us başlığının sayfada göründüğünü doğrulayın")
    public void some_words_about_us_başlığının_sayfada_göründüğünü_doğrulayın() {
        // "Some Words About Us" başlığının sayfada görünüp görünmediğini kontrol et
        Assert.assertTrue("Some Words About Us başlığı sayfada görünmüyor", page.someWordsAboutUsTitle.isDisplayed());
    }

    @Then("Our Mission başlığının sayfada göründüğünü doğrulayın")
    public void our_mission_başlığının_sayfada_göründüğünü_doğrulayın() {
        // "Our Mission" başlığının sayfada görünüp görünmediğini kontrol et
        Assert.assertTrue("Our Mission başlığı sayfada görünmüyor", page.ourMissionTitle.isDisplayed());
    }

    @Then("Opening Hours bilgisinin sayfada göründüğünü doğrulayın")
    public void opening_hours_bilgisinin_sayfada_göründüğünü_doğrulayın() {
        // "Opening Hours" bilgisinin sayfada görünüp görünmediğini kontrol et
        Assert.assertTrue("OPENING HOURS bilgisi sayfada görünmüyor", page.openingHoursInfo.isDisplayed());
    }


    @Then("Our Specialist başlığının sayfada göründüğünü doğrulayın")
    public void our_specialist_başlığının_sayfada_göründüğünü_doğrulayın() {
        Assert.assertTrue("Our Specialist başlığı sayfada görünmüyor", page.ourSpecialistHeading.isDisplayed());

    }

    @Then("Heidi Prather'in resmi, İsim ve Unvan'ının Our Specialist başlığı altında olduğunu doğrulayın")
    public void heidi_prather_in_resmi_i̇sim_ve_unvan_ının_our_specialist_başlığı_altında_olduğunu_doğrulayın() {
        WebElement doctor = page.doctorsList.get(0);  // Heidi Prather ilk sırada
        Assert.assertTrue("Heidi Prather'in resmi görünmüyor", doctor.findElement(By.xpath(".//img")).isDisplayed());
        Assert.assertTrue("Heidi Prather'in ismi görünmüyor", doctor.findElement(By.xpath(".//h4[contains(text(), 'Heidi Prather')]")).isDisplayed());
        // Güncellenmiş unvan kontrolü
        Assert.assertTrue("Heidi Prather'in unvanı görünmüyor", doctor.findElement(By.xpath(".//p[contains(text(), 'Professor')]")).isDisplayed());
    }

    @Then("Alexander M. Simotas'ın resmi, İsim ve Unvan'ının Our Specialist başlığı altında olduğunu doğrulayın")
    public void alexander_m_simotas_ın_resmi_i̇sim_ve_unvan_ının_our_specialist_başlığı_altında_olduğunu_doğrulayın() {
        WebElement doctor = page.doctorsList.get(1);  // Alexander M. Simotas ikinci sırada
        Assert.assertTrue("Alexander M. Simotas'ın resmi görünmüyor", doctor.findElement(By.xpath(".//img")).isDisplayed());
        Assert.assertTrue("Alexander M. Simotas'ın ismi görünmüyor", doctor.findElement(By.xpath(".//h4[contains(text(), 'Alexander C. Simotas')]")).isDisplayed());
        // Güncellenmiş unvan kontrolü
        Assert.assertTrue("Alexander M. Simotas'ın unvanı görünmüyor", doctor.findElement(By.xpath(".//p[contains(text(), 'Professor')]")).isDisplayed());
    }

    @Then("Jesse N. Charnoff'ın resmi, İsim ve Unvan'ının Our Specialist başlığı altında olduğunu doğrulayın")
    public void jesse_n_charnoff_ın_resmi_i̇sim_ve_unvan_ının_our_specialist_başlığı_altında_olduğunu_doğrulayın() {
        WebElement doctor = page.doctorsList.get(2);  // Jesse N. Charnoff üçüncü sırada
        Assert.assertTrue("Jesse N. Charnoff'ın resmi görünmüyor", doctor.findElement(By.xpath(".//img")).isDisplayed());
        Assert.assertTrue("Jesse N. Charnoff'ın ismi görünmüyor", doctor.findElement(By.xpath(".//h4[contains(text(), 'Jesse N. Charnoff')]")).isDisplayed());
        // Güncellenmiş unvan kontrolü
        Assert.assertTrue("Jesse N. Charnoff'ın unvanı görünmüyor", doctor.findElement(By.xpath(".//p[contains(text(), 'Professor')]")).isDisplayed());
    }

    @Then("George Cyril'in resmi, İsim ve Unvan'ının Our Specialist başlığı altında olduğunu doğrulayın")
    public void george_cyril_in_resmi_i̇sim_ve_unvan_ının_our_specialist_başlığı_altında_olduğunu_doğrulayın() {
        WebElement doctor = page.doctorsList.get(3);  // George Cyril dördüncü sırada
        Assert.assertTrue("George Cyril'in resmi görünmüyor", doctor.findElement(By.xpath(".//img")).isDisplayed());
        Assert.assertTrue("George Cyril'in ismi görünmüyor", doctor.findElement(By.xpath(".//h4[contains(text(), 'George Cyril')]")).isDisplayed());
        // Güncellenmiş unvan kontrolü
        Assert.assertTrue("George Cyril'in unvanı görünmüyor", doctor.findElement(By.xpath(".//p[contains(text(), 'Professor')]")).isDisplayed());
    }
