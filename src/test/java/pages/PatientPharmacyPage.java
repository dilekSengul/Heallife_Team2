package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class PatientPharmacyPage {

    WebDriver driver;

    public PatientPharmacyPage(List<WebElement> tableHeaders) {
        this.tableHeaders = tableHeaders;

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "locate") // Pharmacy menu option
    public WebElement pharmacyMenuOption;

    @FindBy(xpath = "//input[@type='search']") // Search input box
    public WebElement searchBox;


    ////////Pharmacy Sayfası Table grubu///////////////////

        //TableHead Locator'ı
      @FindBy(xpath = "//tr[@class='white-space-nowrap']/th")
      private List<WebElement> tableHeaders; // Tüm <th> elementlerini listeler.

        //Çağırma Metodu
      public List<String> getColumnHeaders() {
          List<String> headers = new ArrayList<>();
          for (WebElement header : tableHeaders) {
              headers.add(header.getText().trim());
          }
          return headers;
      }

      //////////////////////////////////////////////////////

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



    @FindBy(id = "locate") // View Payments button
    public WebElement viewPaymentsButton;

    @FindBy(id = "locate") // Show button
    public WebElement showButton;

    @FindBy(id = "locate") // Pay button
    public WebElement payButton;

    @FindBy(id = "locate") // Payment input field
    public WebElement paymentInput;

    @FindBy(id = "locate") // Add button
    public WebElement addButton;

    @FindBy(id = "locate") // Error message
    public WebElement errorMessage;

    @FindBy(id = "locate") // Payment details confirmation
    public WebElement paymentDetailsConfirmation;
}
