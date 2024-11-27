package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

import java.util.ArrayList;
import java.util.List;


public class PatientPharmacyPage {


    public PatientPharmacyPage(List<WebElement> tableHeaders, List<WebElement> tableItems) {
        this.tableHeaders = tableHeaders;
        this.tableBodies = tableItems;


        PageFactory.initElements(DriverManager.getDriver(), this);
    }


    @FindBy(xpath = "//input[@type='search']") // Search input box
    public WebElement searchBar;


    ////////Pharmacy Sayfası Table grubu///////////////////

        //TableHead Locator'ı
      @FindBy(xpath = "//thead/tr/th")
      private List<WebElement> tableHeaders; // Tüm <th> elementlerini listeler.

        //Çağırma Metodu
      public List<String> getTableHeaders() {
          List<String> headers = new ArrayList<>();
          for (WebElement header : tableHeaders) {
              headers.add(header.getText().trim());
          }
          return headers;
      }

    //TableBody Locator'ı
    @FindBy(xpath = "//tbody/tr[@role='row']")
    private List<WebElement> tableBodies; // Tüm <th> elementlerini listeler.

    //Çağırma Metodu
    public List<String> getTableBodies() {
        List<String> tbody = new ArrayList<>();
        for (WebElement body : tableBodies) {
            tbody.add(body.getText().trim());
        }

        System.out.println(tbody);

        return tbody;

    }



    @FindBy(xpath = "//*[@id='DataTables_Table_0']/thead/tr/th[1]") // Bill No
    public WebElement thBillNo;
    @FindBy(xpath = "//*[@id='DataTables_Table_0']/thead/tr/th[2]") // Case ID / Patient ID
    public WebElement thCaseId;
    @FindBy(xpath = "//*[@id='DataTables_Table_0']/thead/tr/th[3]") // Date
    public WebElement thDate;
    @FindBy(xpath = "//*[@id='DataTables_Table_0']/thead/tr/th[4]") // Doctor Name
    public WebElement thDoctorName;
    @FindBy(xpath = "//*[@id='DataTables_Table_0']/thead/tr/th[5]") // Note
    public WebElement thNote;
    @FindBy(xpath = "//*[@id='DataTables_Table_0']/thead/tr/th[6]") // Amount ($)
    public WebElement thAmount;
    @FindBy(xpath = "//*[@id='DataTables_Table_0']/thead/tr/th[7]") // Paid Amount ($)
    public WebElement thPaidAmout;
    @FindBy(xpath = "//*[@id='DataTables_Table_0']/thead/tr/th[8]") // Balance Amount ($)
    public WebElement thBalanceAmount;
    @FindBy(xpath = "//*[@id='DataTables_Table_0']/thead/tr/th[9]") // Action
    public WebElement thAction;














    @FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[9]/a[1]") // View Payments button
    public WebElement viewPaymentsButton;

    @FindBy(xpath = "//*[@id='allpayments']/div/div/div[1]/h4") //View Payments Window Title (Payments)
    public WebElement viewPaymentsWindowTitle;

    @FindBy(xpath = "//*[@id='allpayments']/div/div/div[1]/button") //View Payments Window "X" button
    public WebElement viewPaymentsXbutton;

    @FindBy(xpath = "//i[@class='fa fa-reorder'][1]") // Show button
    public WebElement showButton;

    @FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[9]/a[2]") //show Window Title (Payments)
    public WebElement showWindowTitle;

    @FindBy(xpath = "//*[@id='viewModal']/div/div/div[1]/button") // Show Window "X" button
    public WebElement showXbutton;

    @FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[4]/td[9]/button") // Pay button
    public WebElement firstPayButton;

    @FindBy(xpath = "//*[@id='amount_total_paid']") // Payment input field
    public WebElement paymentInput;

    @FindBy(xpath = "//*[@id='pay_button']") // Add button
    public WebElement addButton;

    @FindBy(xpath = "//*[@id='toast-container']/div/div") // Error message
    public WebElement errorMessage;

}
