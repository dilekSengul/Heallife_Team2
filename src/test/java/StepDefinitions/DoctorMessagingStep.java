package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.DoctorPage;
import pages.LoginPage;
import utilities.ReusableMethods;

public class DoctorMessagingStep {

    WebDriver driver = Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(DoctorStep.class);
    DoctorPage doctorPage=new DoctorPage();
    LoginPage loginPage=new LoginPage();

    @Given("dashboard sidebarda bulunan Messaging e tiklanir")
    public void dashboard_sidebarda_bulunan_messaging_e_tiklanir() {
        doctorPage.monthButton.click();
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        doctorPage.doctorSidebarMessaging.click();
        ReusableMethods.bekle(2);
        logger.info("Messaging linkine tıklandı.");

    }
    @Given("messaging sayfasina gidildigi dogrulanir")
    public void messaging_sayfasina_gidildigi_dogrulanir() {
        String currentURL=driver.getCurrentUrl();

        if (currentURL.contains("notification")) {
            logger.info("Yönlendirme başarılı. Mevcut URL: " + currentURL);
        } else {
            logger.error("Yönlendirme başarısız! Mevcut URL: " + currentURL);
        }

    }
    @Then("notice board goruntulenir")
    public void notice_board_goruntulenir() {
        Assert.assertTrue(doctorPage.messagingNoticeBoard.isDisplayed());
        logger.info("Notice board görüntüleniyor..");

    }

    @Given("post new message linkine tiklanir")
    public void post_new_message_linkine_tiklanir() {
        doctorPage.messagingPostNewMessage.click();

    }
    @When("title, message, notice date, publish on, message to doldurulur")
    public void title_message_notice_date_publish_on_message_to_doldurulur() {
        doctorPage.postNewMessageTitle.sendKeys("deneme");
        ReusableMethods.bekle(1);
        logger.info("Iframe'e geçiş yapılıyor.");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='wysihtml5-sandbox']")));
        doctorPage.postNewMessageMesajBolumu.sendKeys("deneme1234");
        logger.info("Iframe'den çıkılıyor.");
        driver.switchTo().defaultContent();
        doctorPage.postNewMessageNoticeDate.click();
        doctorPage.noticeDateGunSecimi.click();
        doctorPage.postNewMessagePublishOn.click();
        doctorPage.postNewMessagePublisOnGunSecimi.click();
        doctorPage.postNewMessageMessageTo.click();

    }
    @Then("send tiklanir")
    public void send_tiklanir() {
        doctorPage.postNewMessageSend.click();

    }

    @Then("mesajin geldigi dogrulanir")
    public void mesajin_geldigi_dogrulanir() {
        logger.info("mesaj geldiği doğrulanıyor");
        Assert.assertTrue(doctorPage.newPostMessageRecordSavedSuccessfully.isDisplayed());
        logger.info("mesaj geldiği doğrulandı");

    }

    @Given("send SMS e tiklanir")
    public void send_sms_e_tiklanir() {
        doctorPage.messagingSendSMS.click();

    }
    @When("title, sms, message, message to doldurulur")
    public void title_sms_message_message_to_doldurulur() {
        doctorPage.postNewMessageTitle.sendKeys("denemetest");
        doctorPage.sendSMSmessage.sendKeys("test ediliyor");
        doctorPage.sendSmsSendThrough.click();
        doctorPage.postNewMessageMessageTo.click();

    }
    @Then("send sms send tiklanir")
    public void send_sms_send_tiklanir() {
        doctorPage.sendSmsSendButton.click();
    }

    @Given("send email tiklanir")
    public void send_email_tiklanir() {
        doctorPage.messagingSendEmail.click();
    }
    @When("title, message, message to doldurulur")
    public void title_message_message_to_doldurulur() {
        doctorPage.postNewMessageTitle.sendKeys("deneme");
        ReusableMethods.bekle(1);
        logger.info("Iframe'e geçiş yapılıyor.");
        driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@class='cke_wysiwyg_frame cke_reset'])[1]")));
        doctorPage.sendEmailMessageBolumu.sendKeys("test");
        logger.info("Iframe'den çıkılıyor.");
        driver.switchTo().defaultContent();

        doctorPage.sendEmailMessageTo.click();
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }
    @When("send email send tiklanir")
    public void send_email_send_tiklanir() {

        doctorPage.sendEmailSendButton.click();
    }



}
