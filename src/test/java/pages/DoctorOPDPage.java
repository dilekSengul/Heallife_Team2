package pages;

import StepDefinitions.Hooks;
import org.apache.poi.xddf.usermodel.text.XDDFParagraphBulletProperties;
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

    @FindBy(xpath = "/html/body/div[1]/div[1]/section/div/div/div/div[2]/div[2]/div[4]/table/thead/tr/th[8]")
    public WebElement OpdTotalRecheckup;


    //Doctor Opd Ptient
    @FindBy (xpath = "//input[@type='search']")
    public WebElement OpdPatientSearchBox;

    @FindBy(xpath = "/html/body/div[1]/div[1]/section/div/div/div/div[2]/div[2]/div[4]/table/tbody/tr")
    public WebElement OpdBulunanHasta;

    @FindBy(xpath = "/html/body/div[1]/div[1]/section/div/div/div/div[2]/div[2]/div[4]/table/tbody/tr[1]")
    public WebElement patientIdBulunanHasta;

    @FindBy(xpath = "//div[@class='dataTables_length']")
    public WebElement OpdGoruntulenecekHastaSayisi;

    @FindBy(xpath = "//select[@name='DataTables_Table_0_length']//option[text()='All']")
    public WebElement allHastaSayisi;

    @FindBy(xpath = "/html/body/div[1]/div[1]/section/div/div/div/div[2]/div[2]/div[4]/table/tbody/tr[1]/td[1]/div/a/i")
    public WebElement OpdPatientShowButton;

    //Doctor OPD Overview
    @FindBy(xpath = "//div[@class='scrtabs-tabs-movable-container']")
    public WebElement doctorOpdOverviewNav;

    @FindBy(xpath = "/html/body/div[1]/div[1]/section/div/div/div/div[1]/div[2]/div/ul/li[2]/a")
    public WebElement doctorOpdVisitButton;

    //Doctor OPD Visits Sayfasi
    @FindBy(xpath = "(//div[@class='box-tab-header'])[1]")
    public WebElement visitTextBox;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm revisitpatient']")
    public WebElement newVisitsButton;

    //Doctor Opd Lab Investigation






}
