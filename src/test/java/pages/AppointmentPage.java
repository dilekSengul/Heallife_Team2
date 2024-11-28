package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

import java.util.List;

public class AppointmentPage {

    public AppointmentPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy (xpath = "(//tbody)[1]//tr")
    public List<WebElement> tableRows;

    @FindBy (xpath = "//input[@placeholder='Search...']")
    public WebElement searchBar;

    @FindBy (xpath = "(//tbody)[1]/tr/td[1]")
    public WebElement firstPatientName;

    @FindBy (id = "doctor")
    public WebElement doctorSelect;

    @FindBy (xpath = "//input[@name='date']")
    public WebElement dateBox;

    @FindBy (xpath = "//button[normalize-space()='Search']")
    public WebElement searchBtn;

    @FindBy (xpath = "(//tbody)[1]/tr/td[5]")
    public WebElement firstPatientDate;

    @FindBy (xpath = "//*[@class='btn btn-primary btn-sm']")
    public List<WebElement> WiseQueue;

    @FindBy (id = "slot")
    public WebElement slotSelect;

    @FindBy (id = "global_shift")
    public WebElement shiftSelect;

    @FindBy (xpath = "//*[@id=\"slot\"]/option[2]")
    public WebElement slotOption;

    @FindBy (xpath = "//thead/tr/th")
    public List<WebElement> tableHeaders;

}
