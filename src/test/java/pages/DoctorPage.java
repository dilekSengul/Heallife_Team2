package pages;

import StepDefinitions.Hooks;
import org.apache.poi.xddf.usermodel.text.XDDFBodyProperties;
import org.apache.poi.xddf.usermodel.text.XDDFParagraphBulletProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class DoctorPage {

    public DoctorPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
    WebDriver driver = Hooks.getDriver();


    //Doktor paneli mesaj bölümü
    @FindBy(xpath = "//div[@class='col-md-12']")
    public WebElement mesajBolumu;

    //Doktor paneli calendar bölümü
    @FindBy(xpath = "/html/body/div[1]/div[1]/section/div[4]/div[1]/div/div[2]/div/div/div[1]/div[2]/div/button[1]")
    public WebElement monthButton;

    @FindBy(xpath = "(//td[@data-date='2024-11-26'])[1]")
    public WebElement takvimUzerindeSecilenGun;


    @FindBy(xpath = "(//input[@class='form-control'])[1]")
    public WebElement eventTitle;

    @FindBy(xpath = "//input[@name='event_dates']")
    public WebElement eventDate;

    @FindBy(xpath = "(//td[@class='weekend available'])[8]")
    public WebElement secilenGun;

    @FindBy(xpath = "//button[@class='applyBtn btn btn-sm btn-success']")
    public WebElement applyButton;

    @FindBy(xpath = "(//div[@class='calendar-cpicker cpicker cpicker-small'])[7]")
    public WebElement eventColorRed;

    @FindBy(xpath = "(//input[@name='event_type'])[1]")
    public WebElement eventTypePublic;

    @FindBy(xpath = "//input[@class='btn btn-primary submit_addevent pull-right']")
    public WebElement newEventSaveButton;

    //Doktor paneli Accountant
    @FindBy(xpath = "(//span[@class='info-box-text'])[10]")
    public WebElement accountantText;

    @FindBy(xpath = "(//span[@class='info-box-number'])[10]")
    public WebElement accountantNumber;

    //Doktor paneli Doctor
    @FindBy(xpath = "(//span[@class='info-box-text'])[11]")
    public WebElement doctorText;

    @FindBy(xpath = "(//span[@class='info-box-number'])[11]")
    public WebElement doctorNumber;

    //Doktor paneli Pharmacist
    @FindBy(xpath = "(//span[@class='info-box-text'])[12]")
    public WebElement pharmacistText;

    @FindBy(xpath = "(//span[@class='info-box-number'])[12]")
    public WebElement pharmacistNumber;

    //Doktor paneli Pathologist
    @FindBy(xpath = "(//span[@class='info-box-text'])[13]")
    public WebElement pathologistText;

    @FindBy(xpath = "(//span[@class='info-box-number'])[13]")
    public WebElement pathologistNumber;

    //Doktor paneli Radiologist
    @FindBy(xpath = "(//span[@class='info-box-text'])[14]")
    public WebElement radiologistText;

    @FindBy(xpath = "(//span[@class='info-box-number'])[14]")
    public WebElement radiologistNumber;

    //Doktor paneli SuperAdmin
    @FindBy(xpath = "(//span[@class='info-box-text'])[15]")
    public WebElement superAdminText;

    @FindBy(xpath = "(//span[@class='info-box-number'])[15]")
    public WebElement superAdminNumber;

    //Doktor paneli Receptionist
    @FindBy(xpath = "(//span[@class='info-box-text'])[16]")
    public WebElement receptionistText;

    @FindBy(xpath = "(//span[@class='info-box-number'])[16]")
    public WebElement receptionistNumber;

    //Doktor paneli Nurse
    @FindBy(xpath = "(//span[@class='info-box-text'])[17]")
    public WebElement nurseText;

    @FindBy(xpath = "(//span[@class='info-box-number'])[17]")
    public WebElement nurseNumber;

    //Doctor Dashboard Sidebar Messaging

    @FindBy(xpath = "/html/body/div[1]/aside/div/section/ul[2]/li[14]/a")
    public WebElement doctorSidebarMessaging;

    @FindBy(xpath = "(//div[@class='box-header with-border'])[1]")
    public WebElement messagingNoticeBoard;

    @FindBy(xpath = "/html/body/div[1]/div/section/div/div/div/div[1]/div/a[1]")
    public WebElement messagingPostNewMessage;

    @FindBy(xpath = "/html/body/div[1]/div/section/div/div/div/div[1]/div/a[2]")
    public WebElement messagingSendSMS;

    @FindBy(xpath = "/html/body/div[1]/div/section/div/div/div/div[1]/div/a[3]")
    public WebElement messagingSendEmail;

    //Doctor Messaging Sayfasi New Post Message Sayfasi

    @FindBy(xpath = "(//input[@class='form-control'])[1]")
    public WebElement postNewMessageTitle;

    @FindBy(xpath = "//body[@class='form-control wysihtml5-editor']")
    public WebElement postNewMessageMesajBolumu;

    @FindBy(xpath = "(//input[@class='form-control date'])[1]")
    public WebElement postNewMessageNoticeDate;

    @FindBy(xpath = "(//td[@class='day'])[20]")
    public WebElement noticeDateGunSecimi;

    @FindBy(xpath = "(//input[@class='form-control date'])[2]")
    public WebElement postNewMessagePublishOn;

    @FindBy(xpath = "(//td[@class='day'])[22]")
    public WebElement postNewMessagePublisOnGunSecimi;

    @FindBy(xpath = "(//input[@type='checkbox'])[4]")
    public WebElement postNewMessageMessageTo;

    @FindBy(xpath = "(//button[@class='btn btn-primary'])[1]")
    public WebElement postNewMessageSend;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement newPostMessageRecordSavedSuccessfully;


    //Doctor Messaging Sayfasi Send SMS Sayfasi

    @FindBy(xpath = "(//textarea[@class='form-control compose-textarea'])[1]")
    public WebElement sendSMSmessage;

    @FindBy(xpath = "(//input[@value='sms'])[1]")
    public WebElement sendSmsSendThrough;

    @FindBy(xpath = "//button[@class='btn btn-primary submit_group']")
    public WebElement sendSmsSendButton;

    //Doctor Messaging Sayfası Send Email Sayfasi
    @FindBy(xpath = "(//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders'])[1]")
    public WebElement sendEmailMessageBolumu;

    @FindBy(xpath = "//button[@class='btn btn-primary submit_group']")
    public WebElement sendEmailSendButton;

    @FindBy(xpath = "(//div[@class='checkbox'])[5]")
    public WebElement sendEmailMessageTo;



}
