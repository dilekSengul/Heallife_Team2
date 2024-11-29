package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientPage {

    public PatientPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
    public PatientPage(List<WebElement> tableHeaders, List<WebElement> tableItems) {
        this.tableHeaders = tableHeaders;
        this.tableBodies = tableItems;
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
    //TableHead Locator'ı
    @FindBy(xpath = "//thead/tr/th")
    private List<WebElement> tableHeaders; // Tüm <th> elementlerini listeler.

    //Çağırma Metodu
    public List<String> getTableHeadersOld() {
        List<String> headers = new ArrayList<>();
        for (WebElement header : tableHeaders) {
            headers.add(header.getText().trim());
        }
        return headers;
    }
    public List<String> getTableHeaders() {
        List<String> headers = new ArrayList<>();
        for (WebElement header : tableHeaders) {
            String headerText = header.getText().trim();
            if (!headerText.isEmpty()) { // Boş başlıkları filtrele
                headers.add(headerText);
            }
        }
        return headers;
    }

    public List<String> getHeadersFromListGroup() {
        List<String> headers = new ArrayList<>();

        // HTML içindeki <b> etiketlerini bul
        List<WebElement> headerElements = DriverManager.getDriver().findElements(By.cssSelector(".list-group-item b"));

        for (WebElement header : headerElements) {
            String headerText = header.getText().trim();
            System.out.println("Header found: " + headerText); // Log ekleyin
            if (!headerText.isEmpty()) {
                headers.add(headerText); // Boş olmayan başlıkları listeye ekle
            }
        }

        return headers;
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

    @FindBy(xpath = "//a[@class='btn btn-info btn-xs']")
    public WebElement payButton;

    @FindBy(xpath = "//span[text()='Pay with Card']")
    public WebElement payWithCard;

    @FindBy(xpath = "/html/body/div[3]/form/div[2]/div/div[4]/div/div[1]/div/input")
    public WebElement emailBox;

    @FindBy(xpath = "//span[@class='iconTick']")
    public WebElement payButtton;

    @FindBy(xpath = "//p[text()='Your Online Appointment Fees Is Successfully Submitted.']")
    public WebElement successMessage;

    @FindBy(xpath = "//a[@class='btn btn-primary mt20']")
    public WebElement goToHomeButton;

    @FindBy(xpath = "//small[@class='label label-success']")
    public WebElement approved;

    @FindBy (xpath = "//span[@id='slot_11']")
    public WebElement slot7_00;

    @FindBy (xpath = "//a[@class='dropdown-toggle']")
    public WebElement profileButton;

    @FindBy (xpath = "//a[normalize-space()='Logout']")
    public WebElement logoutButton;

   //// Patient Radiology Sayfası  ////

    // Patient Dashboard'da Radiology Butonu
    @FindBy(xpath = "//*[@class='fas fa-microscope']")
    public WebElement PatientDashboardRadiologyButton;

    // Patient Dashboard'da Ambulance Butonu
//    @FindBy(xpath = "https://qa.heallifehospital.com/patient/dashboard/ambulance'])[1]")
    @FindBy(xpath = "//*[@class='fas fa-ambulance']")
    public WebElement PatientDashboardAmbulanceButton;

    // Patient Radiology Test Report Yazısı
    @FindBy(xpath = "//*[@class='box-header with-border']")
    public WebElement RadiologyTestReportText;


    @FindBy(xpath = "//*[@id='allpayments']/div/div/div[1]/h4") //View Payments Window Title (Payments)
    public WebElement viewPaymentsWindowTitle;
    @FindBy(xpath = "//i[@class='fa fa-reorder'][1]") // Show button
    public WebElement showButton;

    @FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[9]/a[2]") //show Window Title (Payments)
    public WebElement showWindowTitle;
    @FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[4]/td[9]/button") // Pay button
    public WebElement firstPayButton;

    @FindBy(xpath = "//*[@id='amount_total_paid']") // Payment input field
    public WebElement paymentInput;

    @FindBy(xpath = "(//*[@class='sorting'])[1]")
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
    @FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[9]/a[1]") // View Payments button
    public WebElement viewPaymentsButton;


    // Action Başlığı Altında View Reports Butonu
    @FindBy(xpath = "(//*[@class='btn btn-default btn-xs view_detail'])[1]")
    public WebElement ViewReportsButton;

    // Action Başlığı Altında Pay Butonu
    @FindBy(xpath = "*[@class='btn btn-primary btn-xs'])[1]")
    public WebElement PayButton;

    // Action Başlığı Altında  Search Butonu

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchBar;

    // Radyolojy Test Raport listelenen kayıt sayısı texti
    @FindBy(xpath = "*[@class='dataTables_info']")
    public WebElement ListelenenKAyitSayisiText;


    // Dashboard texti
    @FindBy(xpath = "//*[@class='treeview active']")
    public WebElement DashboardText;
    @FindBy(xpath = "//tbody/tr[@role='row']")
    private List<WebElement> tableBodies; // Tüm <th> elementlerini listeler.
    public List<String> getTableBodies() {
        List<String> tbody = new ArrayList<>();
        for (WebElement body : tableBodies) {
            tbody.add(body.getText().trim());
        }

        System.out.println(tbody);

        return tbody;

    }



//// Patient Ambulance Sayfası  ////

 //   Ambulance Button
    @FindBy(xpath = "//*[@class='treeview active']")
    public WebElement patientAmbulanceButton;

    // Ambulance Bill Baslığı
    @FindBy(xpath = "//*[@class='box-header with-border']")
    public WebElement ambulanceBillHeader;

   // Bill No Baslıgı
   @FindBy(xpath = "(//*[@class='sorting'])[1]")
   public WebElement billNoHeaderAmbulance;

   // Vehicle Number Baslıgı
   @FindBy(xpath = "(//*[@class='sorting'])[2]")
   public WebElement vehicleNumberHeader;

   // Vehicle Model Baslıgı
   @FindBy(xpath = "(//*[@class='sorting'])[3]")
   public WebElement vehicleModelHeader;

   //Driver Name Baslıgı
   @FindBy(xpath = "(//*[@class='sorting'])[4]")
   public WebElement driverNameHeader;

   //Driver Contact Baslıgı
   @FindBy(xpath = "(//*[@class='sorting'])[5]")
   public WebElement driverContactHeader;

   //Amount($) Baslıgı
   @FindBy(xpath = "(//*[@class='text-right sorting'])[1]")
   public WebElement amountHeaderAmbulance;

   //Text(%) Baslıgı
    @FindBy(xpath = "(//*[@class='text-right sorting'])[2]")
    public WebElement textHeaderAmbulance;

    //Net Amount($) Baslıgı
    @FindBy(xpath = "(//*[@class='text-right sorting'])[3]")
    public WebElement netAmountHeaderAmbulance;

    //Paid Amount(%) Baslıgı
    @FindBy(xpath = "(//*[@class='text-right sorting'])[4]")
    public WebElement paidAmountHeaderAmbulance;

    //Balance Amount(%) Baslıgı
    @FindBy(xpath = "(//*[@class='text-right sorting'])[5]")
    public WebElement balanceAmountHeaderAmbulance;

    //Action Header
    @FindBy(xpath = "//*[@class='text-right noExport sorting']")
    public WebElement actionHeaderAmbulance;

    //Search Alanı
    @FindBy(xpath = "//*[@class='dataTables_filter']")
    public WebElement searchHeaderAmbulance;

    //Action'ın Altında View Payments butonu
    @FindBy(xpath = "(//*[@title='View Payments'])[1]")
    public WebElement viewPaymentButtonAmbulance;

    //Action'ın Altında Show butonu
    @FindBy(xpath = "(//*[@title='Show'])[1]")
    public WebElement showButtonAmbulance;

    //Action'ın Altında Pay butonu
    @FindBy(xpath = "(//*[@class='btn btn-primary btn-xs'])[1]")
    public WebElement payButtonAmbulance;

    //View Payment penceresi print button
    @FindBy(xpath = "(//*[@class='fa fa-print'])[2]")
    public WebElement viewPaymentWindowPrint;

    @FindBy(xpath = "//*[@id='allpayments']/div/div/div[1]/button") //View Payments Window "X" button
    public WebElement viewPaymentsXbutton;

    //Show penceresi logo
    @FindBy(xpath = "//*[@class='img-responsive']")
    public WebElement showWindowLogo;

    //Show penceresi X butonu
    @FindBy(xpath = "(//*[@class='close'])[1]")
    public WebElement ShowWindowClose;

    //Pay penceresi Add butonu
    @FindBy(xpath = "//*[@id='pay_button']")
    public WebElement payWindowAddButton;

    //Pay penceresi X butonu
    @FindBy(xpath = "((//*[@class='close'])[2]")
    public WebElement PayWindowClose;



//// Patient Blood BAnk Sayfası  ////

    //Hasta Bilgileri//

//Hasta Adı Texti

@FindBy(xpath = "//*[@class='profile-username text-center']")
public WebElement patienNameTextBloodBank;


// Patient ID
@FindBy(xpath = "//b[text()='Patient Id']")
public WebElement patientIdBloodBank;

// Gender
@FindBy(xpath = "//b[text()='Gender']")
public WebElement gender;

// Phone
@FindBy(xpath = "//b[text()='MAfrital Status']")
public WebElement maritalStatus;

//Phone
@FindBy(xpath = "//b[text()='Phone']")
public WebElement phone;

// EMAil
@FindBy(xpath = "//b[text()='Email']")
public WebElement email;

//Address
@FindBy(xpath = "//b[text()='Address']")
public WebElement address;

// Age
@FindBy(xpath = "//b[text()='Age]")
public WebElement age;

//Guardian Name
@FindBy(xpath = "//b[text()='Guardian Name']")
public WebElement guardianName;


// Blood Issue Sayfası //

    //Blood Issue Header
    @FindBy(xpath ="//a[@href='#bloodissue']")
    public WebElement bloodIssueHeader;


    // Search Alanı
    @FindBy(xpath ="(//*[@type='search'])[1]")
    public WebElement searchAlaniBloodIssue;



    // Bill No
    @FindBy(xpath ="(//th[contains(@aria-label, 'Bill No')])[1]")
    public WebElement billNoBloodIssue;



    // Issue Date
    @FindBy(xpath ="(//th[contains(@aria-label, 'Issue Date')])[1]")
    public WebElement issueDateBloodIssue;


    // Recieved To
    @FindBy(xpath ="(//th[contains(@aria-label, 'Received To')])[1]")
    public WebElement recievedToBloodIssue;


    // Blood Group
    @FindBy(xpath ="(//th[contains(@aria-label, 'Blood Group')])[1]")
    public WebElement bloodGroupBloodIssue;

    // Gender
    @FindBy(xpath ="(//th[contains(@aria-label, 'Gender')])[1]")
    public WebElement genderBloodIssue;


    // Donor Name
    @FindBy(xpath ="(//th[contains(@aria-label, 'Donor Name')])[1]")
    public WebElement donorNameBloodIssue;

    // Donor Name
    @FindBy(xpath ="(//th[contains(@aria-label, 'Bags')])[1]")
    public WebElement bagsBloodIssue;


    // Amount ($)
    @FindBy(xpath =" (//th[contains(@aria-label, 'Amount ($)')])[1]")
    public WebElement amountBloodIssue;

    // Paid Amount ($)
    @FindBy(xpath =" (//th[contains(@aria-label, 'Paid Amount ($)')])[1]")
    public WebElement paidAmountBloodIssue;


    // Balance Amount ($)
    @FindBy(xpath =" (//th[contains(@aria-label, 'Balance Amount ($)')])[1]")
    public WebElement balanceAmountBloodIssue;

    // Action
    @FindBy(xpath =" (//th[contains(@aria-label, 'Action')])[1]")
    public WebElement actionBloodIssue;

    // Action Altında View Payments
    @FindBy(xpath =" (//*[@title='View Payments'])[1]")
    public WebElement viewPaymentsBloodIssue;



// Component Issue Sayfası //

    //Component Issue Button
    @FindBy(xpath ="//a[contains(text(), 'Component Issue')]")
    public WebElement componentIssueButton;


    //Component Issue Header
    @FindBy(xpath ="//*[text()='Component Issue']")
    public WebElement componentIssueHeader;


    // Search Alanı
    @FindBy(xpath ="(//*[@type='search'])[2]")
    public WebElement searchAlaniComponentIssue;



    // Bill No
    @FindBy(xpath ="(//th[contains(@aria-label, 'Bill No')])[2]")
    public WebElement billNoComponentIssue;



    // Issue Date
    @FindBy(xpath ="(//th[contains(@aria-label, 'Issue Date')])[2]")
    public WebElement issueDateComponentIssue;


    // Recieved To
    @FindBy(xpath ="(//th[contains(@aria-label, 'Received To')])[2]")
    public WebElement recievedToComponentIssue;


    // Blood Group
    @FindBy(xpath ="(//th[contains(@aria-label, 'Blood Group')])[2]")
    public WebElement bloodGroupComponentIssue;


    // Component
    @FindBy(xpath ="//th[contains(@aria-label, 'Component')]")
    public WebElement ComponentComponentIssue;



    // Gender
    @FindBy(xpath ="(//th[contains(@aria-label, 'Gender')])[2]")
    public WebElement genderComponentIssue;


    // Donor Name
    @FindBy(xpath ="(//th[contains(@aria-label, 'Donor Name')])[2]")
    public WebElement donorNameComponentIssue;

    // Donor Name
    @FindBy(xpath ="(//th[contains(@aria-label, 'Bags')])[2]")
    public WebElement bagsComponentIssue;


    // Amount ($)
    @FindBy(xpath =" (//th[contains(@aria-label, 'Amount ($)')])[4]")
    public WebElement amountComponentIssue;

    // Paid Amount ($)
    @FindBy(xpath =" (//th[contains(@aria-label, 'Amount ($)')])[5]")
    public WebElement paidAmountComponentIssue;


    // Balance Amount ($)
    @FindBy(xpath =" (//th[contains(@aria-label, 'Amount ($)')])[6]")
    public WebElement balanceAmountComponentIssue;

    // Action
    @FindBy(xpath =" (//th[contains(@aria-label, 'Action')])[2]")
    public WebElement actionComponentIssue;




}






