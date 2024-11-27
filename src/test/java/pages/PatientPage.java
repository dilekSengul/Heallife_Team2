package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientPage {

    public PatientPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }


    @FindBy(xpath = "//*[text()='Appointment']")
    public WebElement appointmentButton;

    @FindBy(xpath = "(//select[@class='form-control select2 select2-hidden-accessible'])[1]")
    public WebElement specialistDDM;

    @FindBy(xpath = "(//select[@class='form-control select2 select2-hidden-accessible'])[2]")
    public WebElement doctorDDM;
    @FindBy(xpath = "//span[@id='select2-global_shift-container']")
    public WebElement shiftbutton;
    @FindBy(xpath = "//input[@role='textbox']")
    public WebElement shiftsearchbox;

    @FindBy(xpath = "//*[@id=\"datetimepicker1\"]")
    public WebElement datebox;

    @FindBy(xpath = "//*[@id='message']")
    public WebElement messageBoxElementi;

    @FindBy(id = "select2-global_shift-container")
    public WebElement shiftBox;

    @FindBy(xpath = "//*[@class='slot-details each-slot-duration']")
    public WebElement slotButton;

    @FindBy(xpath = "//*[@id=\"slot_18\"]")
    public WebElement slot9_00;

    @FindBy(xpath = "//*[@id='patient_name']")
    public WebElement patientNameBox;

    @FindBy(xpath = "//*[@id='email']")
    public WebElement Emaileboxelementi;

    @FindBy(xpath = "//*[@id='phone']")
    public WebElement phoneboxElementi;

    @FindBy(xpath = "//*[@id='submitbtn']")
    public WebElement SubmitButtonElementi;

    @FindBy(xpath = "//*[@class='select2-search__field']")
    public WebElement specialistBoxElementi;

    @FindBy(xpath = "//*[@class='select2-search__field']")
    public WebElement doctorSearchBox;

    @FindBy(xpath = "/html/body/span/span/span[1]/input]")
    public WebElement shiftselectionSearchBox;

    @FindBy(xpath = "//*[@class= 'modal-backdrop fade in']")
    public WebElement falseErrorMsg;

    @FindBy(xpath = "//*[@class='col-md-4 col-sm-4'])[2])")
    public List<String> footerElementLists;


   //// Patient Radiology Sayfası  ////

    // Patient Dashboard'da Radiology Butonu
    @FindBy(xpath = "//*[@class='fas fa-microscope']")
    public WebElement PatientDashboardRadiologyButton;

    // Patient Dashboard'da Ambulance Butonu
    @FindBy(xpath = "https://qa.heallifehospital.com/patient/dashboard/ambulance'])[1]")
    public WebElement PatientAmbulanceButton;

    // Patient Radiology Test Report Yazısı
    @FindBy(xpath = "*[@class='box-title titlefix']")
    public WebElement RadiologyTestReportText;

    // Bill No Başlığı
    @FindBy(xpath = "*[@class='sorting'])[1]")
    public WebElement BillNo;

    // Case ID Başlığı
    @FindBy(xpath = "*[@class='sorting'])[2]")
    public WebElement CaseID;

    // Reporting Date Baslığı
    @FindBy(xpath = "*[@class='sorting'])[3]")
    public WebElement ReportingDate;

    // Referance Doctor Başlığı
    @FindBy(xpath = "*[@class='sorting'])[4]")
    public WebElement ReferanceDoctor;

    // Not Başlığı
    @FindBy(xpath = "*[@class='sorting'])[5]")
    public WebElement NotHeader;

    // Amount Başlığı
    @FindBy(xpath = "*[@class='text-right sorting'])[1]")
    public WebElement AmountHeader;

    // Paid Amounts Başlığı
    @FindBy(xpath = "*[@class='text-right sorting'])[2] ")
    public WebElement PaidAmountHeader;

    // Balance Amounts Başlığı
    @FindBy(xpath = "*[@class='text-right sorting'])[3] ")
    public WebElement BalanceAmountHeader;

    // Action Başlığı
    @FindBy(xpath = "*[@class='text-right noExport sorting' ")
    public WebElement ActionHeader;

    // Action Başlığı Altında View Payments Butonu
    @FindBy(xpath = "*[@class='fa fa-money'")
    public WebElement ViewPaymentsButton;

    // Action Başlığı Altında View Reports Butonu
    @FindBy(xpath = "*[@class='btn btn-default btn-xs view_detail'])[1]")
    public WebElement ViewReportsButton;

    // Action Başlığı Altında Pay Butonu
    @FindBy(xpath = "*[@class='btn btn-primary btn-xs'])[1]")
    public WebElement PayButton;

    // Action Başlığı Altında  Search Butonu
    @FindBy(xpath = "*[@type='search']")
    public WebElement SearchButton;

    // Radyolojy Test Raport listelenen kayıt sayısı texti
    @FindBy(xpath = "*[@class='dataTables_info']")
    public WebElement ListelenenKAyitSayisiText;


    // Dashboard texti
    @FindBy(xpath = "*[text()=' Dashboard']")
    public WebElement DashboardText;





}
