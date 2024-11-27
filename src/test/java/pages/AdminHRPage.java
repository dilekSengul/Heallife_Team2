package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class AdminHRPage {
    public  AdminHRPage(){ PageFactory.initElements(DriverManager.getDriver(), this);}

    // Admin Dashboard Login Ekrani Elementleri(Kullanici Adi ve Sifre Alanlari)

    @FindBy(id="email")
    public WebElement emailAlani;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement sifreAlani;

    //Admin Dashboard'ta menu bar'da yer alan Human Resource Bolumu
    @FindBy(xpath = "//span[text()='Human Resource']")
    public WebElement humanResourceLinki;

    @FindBy(xpath = "//h3[@class='box-title titlefix']" )
    public WebElement staffDirectoryBasligi;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButonu;

    // Staff Directory Sayfasi Elementleri (https://qa.heallifehospital.com/admin/staff)
    @FindBy (xpath = "//a[@href='#tab_2']")
    public WebElement listViewButonu;
    @FindBy(xpath = "//a[@href='#tab_1']")
    public WebElement cardViewButonu;
    @FindBy(xpath = "//th[@rowspan='1']")
    public WebElement staffIDBasligi;
    @FindBy(xpath = "(//th[@colspan='1'])[2]")
    public WebElement nameBasligli;
    @FindBy(xpath = "(//th[@colspan='1'])[3]")
    public WebElement roleBasligi;
    @FindBy(xpath = "//th[text()='Department']")
    public WebElement departmentBasligi;
    @FindBy(xpath = "//th[text()='Designation']")
    public WebElement designationBasligi;
    @FindBy(xpath = "//th[text()='Mobile Number']")
    public WebElement mobileNumberBasligi;
    @FindBy(xpath = "//th[text()='Action']")
    public WebElement actionBasligi;
    @FindBy(xpath = "//td[text()='9001']")
    public WebElement superAdminListView;
    @FindBy(xpath = "//div[@id='tab_1']/div[1]/div[1]/div[1]/div[1]/div[1]/img[1]")
    public WebElement superAdminCardView;
    @FindBy(css = "table#DataTables_Table_0>tbody>tr:nth-of-type(2)>td:nth-of-type(7)>a:nth-of-type(2)>i")
    public WebElement showButonuActionAltinda;
    @FindBy(xpath = "//li[@class='active']//a[1]")
    public WebElement profileButonu;
    @FindBy(xpath = "//li[@class='list-group-item listnoback']//b")
    public WebElement staffIDButonuProfilEkrani;
    @FindBy(xpath = "//i[@class='fa fa-pencil']")
    public WebElement editButonuActionAltinda;
    @FindBy(xpath = "//h4[text()='Basic Information ']")
    public WebElement basicInformationSayfasiBasligi;

    @FindBy(xpath = "//a[contains(@class,'btn btn-primary')]")
    public WebElement addStaffButonu;

    @FindBy(xpath = "//button[@data-toggle='dropdown']")
    public WebElement addStaffDropdownButonu;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//a[1]")
    public WebElement disabledStaffButonu;

    @FindBy(xpath = "//h3[text()='Disabled Staff']")
    public WebElement disabledStaffEkraniBasligi;

    @FindBy(xpath = "(//a[contains(@class,'btn btn-primary')])[2]")
    public WebElement staffAttendanceButonu;

    @FindBy(xpath = "//h3[text()='Staff Attendance']")
    public WebElement staffAttendanceBasligi;

    @FindBy(xpath = "(//a[contains(@class,'btn btn-primary')])[3]")
    public WebElement payrollButonu;

    @FindBy(xpath = "//h3[text()='Payroll']")
    public WebElement payrollSayfasiBasligi;

    @FindBy(xpath = "//a[contains(@class,'btn btn-sm')]")
    public WebElement importStaffButonu;

    @FindBy(xpath = "//h3[text()='Import Staff']")
    public WebElement importStaffSayfaBasligi;

    @FindBy(xpath = "(//a[contains(@class,'btn btn-primary')]/following-sibling::a)[2]")
    public WebElement leavesButonu;

    @FindBy(xpath = "//h3[text()='My Leaves']")
    public WebElement leavesSayfasiBasligi;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement leavesSayfasiSearchButonu;

    @FindBy(xpath = "//span[text()=' Add new record or search with different criteria.']")
    public WebElement addNewLeaveYazisi;

    @FindBy(xpath = "(//a[contains(@class,'btn btn-primary')])[2]")
    public WebElement approveLeaveRequestButonu;

    @FindBy(xpath = "//div[@class='dataTables_length']//label[1]")
    public WebElement approveLeaveRequest100Butonu;

    @FindBy(xpath = "DataTables_Table_0_length")
    public WebElement aprroveLeaveRequestAllButonu;

    @FindBy(xpath = "//i[@class='fa fa-reorder']")
    public WebElement aprroveLeaveRequestViewButonu;

    @FindBy(xpath = "//h4[@class='modal-title']")
    public WebElement detailsPenceresiALRSayfasi;

    @FindBy(xpath = "//a[contains(@class,'btn btn-primary')]")
    public WebElement addLeaveRequestButonu;

    @FindBy(xpath = "(//h4[text()='Add Details']")
    public WebElement addDetailsEkrani;

    @FindBy(xpath = "//th[text()='Name']")
    public WebElement detailsEkraniNameBasligi;

    @FindBy(xpath = "//select[@class='form-control']")
    public WebElement addDetailsRole;

    @FindBy(xpath = "//select[@id='leave_type']")
    public WebElement addDetailsLeaveType;

    @FindBy(xpath = "(//button[contains(@class,'btn btn-primary')])[2]")
    public WebElement saveButonuAddDetailsPenceresi;

























}
