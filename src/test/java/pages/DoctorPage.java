package pages;

import StepDefinitions.Hooks;
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



}
