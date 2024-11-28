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

    @FindBy (xpath = "//span[@id='slot_6']")
    public WebElement slot5_12;

    @FindBy (xpath = "//a[@class='dropdown-toggle']")
    public WebElement profileButton;

    @FindBy (xpath = "//a[normalize-space()='Logout']")
    public WebElement logoutButton;

}
