package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

import java.util.List;

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

    // Patient dashboard-hurrem

    @FindBy(xpath = "(//*[@class='treeview '])[2]")
    public WebElement myAppointmentsdBoard;

    @FindBy(xpath = "//*[@class='treeview active']")
    public WebElement opdBoard;

    @FindBy(xpath = "(//*[@class='treeview '])[3]")
    public WebElement ipdBoard;

    @FindBy(xpath = "(//*[@class='treeview '])[4]")
    public WebElement pharmacyBoard;

    @FindBy(xpath = "(//*[@class='treeview '])[5]")
    public WebElement pathologyBoard;

    @FindBy(xpath = "(//*[@class='treeview '])[6]")
    public WebElement radiologyBoard;

    @FindBy(xpath = "(//*[@class='treeview '])[7]")
    public WebElement ambulanceBoard;

    @FindBy(xpath = "(//*[@class='treeview '])[8]")
    public WebElement bloodBankBoard;

    @FindBy(xpath = "(//*[@class='treeview '])[9]")
    public WebElement  liveConsultation;

    // Yardımcı metod: Board ismine göre ilgili WebElement'i döndürüyor
    public  WebElement getBoardElementByName(String boardName) {
        switch (boardName) {
            case "OPD":
                return opdBoard;
            case "IPD":
                return ipdBoard;
            case "Pharmacy":
                return pharmacyBoard;
            case "Pathology":
                return pathologyBoard;
            case "Radiology":
                return radiologyBoard;
            case "Blood Bank":
                return bloodBankBoard;
            case "Ambulance":
                return ambulanceBoard;
            case "Live Consultation":
                return liveConsultation;
            default:
                throw new IllegalArgumentException("Bilinmeyen panel ismi: " + boardName);  // Geçersiz panel ismi durumunda hata verilir
        }
    }
}
