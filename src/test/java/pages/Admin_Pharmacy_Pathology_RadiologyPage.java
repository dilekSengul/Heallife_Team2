package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class Admin_Pharmacy_Pathology_RadiologyPage {

    public Admin_Pharmacy_Pathology_RadiologyPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"load1\"]")
    public WebElement generateBill;

    @FindBy(xpath = "//*[@id=\"row1\"]/td[1]/span[1]")
    public WebElement medicineCategory;

    @FindBy(xpath = "//*[@id=\"row1\"]/td[2]/span[1]")
    public WebElement medicineName;

    @FindBy(xpath = "(//li[@class='select2-results__option'])[2]")
    public WebElement capsule;

    @FindBy(xpath = "(//li[@class='select2-results__option'])[1]")
    public WebElement wormstop;

    @FindBy(xpath = "(//li[@role='treeitem'])[2]")
    public WebElement chosenBatchNo;

    @FindBy(xpath = "//input[@name='quantity_1']")
    public WebElement Quantity;

    @FindBy(xpath = "(//span[@class='select2-selection__rendered'])[5]")
    public WebElement hospitalDoctorBox;

    @FindBy(xpath = "//li[text()='i̇smail kaya (1011)']")
    public WebElement chosenDoctor;

    @FindBy(xpath = "//button[@class='btn btn-info']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"bill\"]/div[1]/div/div[1]/div/span")
    public WebElement hastaAdiBox;

    @FindBy (xpath = "//*[@id=\"row1\"]/td[3]/span[1]")
    public WebElement batchNoBox;

    @FindBy (xpath = "//*[@id=\"toast-container\"]/div/div")
    public WebElement successMessage;

    @FindBy (xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[4]")
    public WebElement accesesblityName;


}