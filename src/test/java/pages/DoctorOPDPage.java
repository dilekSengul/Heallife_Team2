package pages;

import StepDefinitions.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class DoctorOPDPage {

    public DoctorOPDPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
    WebDriver driver = Hooks.getDriver();

    //Doctor Sidebar OPD linki
    @FindBy(xpath = "/html/body/div[1]/aside/div/section/ul[2]/li[4]")
    public WebElement doctorSidebarOpd;

    @FindBy(xpath = "//div[@class='box-header with-border']")
    public WebElement OPDpatientBoxDogrulama;

    //Doktor OPD başlıkları

    @FindBy(xpath = "(//th[@class='sorting'])[1]")
    public WebElement OpdName;

    @FindBy(xpath = "(//th[@class='sorting'])[2]")
    public WebElement OpdPatientId;

    @FindBy(xpath = "(//th[@class='sorting'])[3]")
    public WebElement OpdGuardianName;

    @FindBy(xpath = "(//th[@class='sorting'])[4]")
    public WebElement OpdGender;

    @FindBy(xpath = "(//th[@class='sorting'])[5]")
    public WebElement OpdPhone;

    @FindBy(xpath = "(//th[@class='sorting'])[6]")
    public WebElement OpdConsultant;

    @FindBy(xpath = "(//th[@class='sorting'])[7]")
    public WebElement OpdLastVisit;

    @FindBy(xpath = "//th[@class='ftext-right dt-body-right sorting_disabled']")
    public WebElement OpdTotalRecheckup;


}
