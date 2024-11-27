package pages;

import StepDefinitions.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverManager;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminBillingAppointmentPage {

    public AdminBillingAppointmentPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
    WebDriver driver = Hooks.getDriver();

    @FindBy(xpath = "//span[normalize-space()='Dashboard']")
    public WebElement DashboardMenu;

    @FindBy (xpath = "//span[normalize-space()='Appointment']")
    public WebElement AppointmentMenu;

    @FindBy(xpath = "//table[@id='DataTables_Table_0']//thead/tr/th")
    public List <WebElement> appointmentHeaderTitles;
    @FindBy(xpath = "(//tbody)[1]/tr /td[1]")
    public List <WebElement>  patientNameColumn;
    @FindBy(xpath = "//thead/tr/th[1]")
    public WebElement patientNameHeader;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement appoinenmentDetailSearchBox;
    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[1]")
    public WebElement doctorWiseButton;
    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[2]")
    public WebElement QueueButton;

    @FindBy(xpath = "//span[@class='select2-selection__rendered']")
    public WebElement doctorBoxDoctorWise;
    @FindBy(xpath = "//input[@class='form-control date']")
    public WebElement dateBox;
    @FindBy(xpath = "(//button[@type='submit'])[3]")
    public WebElement searchBox;
    @FindBy(xpath = "(//li[@class='select2-results__option'])[1]")
    public WebElement chosenPeople;
    @FindBy(xpath = "(//tbody)[1]//tr[4]//td[3]")
    public WebElement chosenDate;
    @FindBy(xpath = "//table")
    public WebElement doctorFilterResult;
    @FindBy(xpath = "//select[@onchange='getDoctorShift()']")
    public WebElement queueDoctorBox;
    @FindBy(xpath = "//option[@value='11']")
    public WebElement QueueChosenDoctor;
    @FindBy(xpath = "//select[@id='global_shift']")
    public WebElement shiftBox;
    @FindBy(xpath = "//option[@value='1']")
    public WebElement selectedShift;
    @FindBy(xpath = "//select[@name='slot']")
    public WebElement slotBox;

    @FindBy(xpath = "//option[@value='6']")
    public WebElement selectedSlot;
    public List<String> getTableHeaders() {
        List<String> headers = new ArrayList<>();
        for (WebElement headerElement :appointmentHeaderTitles) {
            headers.add(headerElement.getText().trim());
        }
        return headers;
    }

    public void siralamayiDogrulama(String columnName) {

        ReusableMethods.wait(3);
        List<WebElement> patientNameElements = driver.findElements(By.xpath("(//tbody)[1]/tr /td[1]"));
        List<String> actualOrder = new ArrayList<>();


        for (WebElement element : patientNameElements) {
            actualOrder.add(element.getText().trim().toLowerCase());
        }

        List<String> expectedOrder = new ArrayList<>(actualOrder);
        Collections.sort(expectedOrder);


        Assert.assertEquals("Tablo alfabetik siralanmadi" + columnName, actualOrder, expectedOrder);
    }
    public boolean sutundaIsimMevcutMu(String expectedName) {

        ReusableMethods.wait(3);
        List<WebElement> rows = driver.findElements(By.xpath("(//tbody)[1]/tr /td[1]"));

        for (WebElement row : rows) {

            if (row.getText().contains(expectedName)) {
                return true;
            }
        }

        return false;
    }
    public boolean baslikGorunuyorMu(String headerName) {
        List<WebElement> headers = driver.findElements(By.xpath("//table//thead/tr/th"));////table[@id='DataTables_Table_0']//thead/tr/th
        for (WebElement header : headers) {
            if (header.getText().equalsIgnoreCase(headerName)) {
                return true;
            }
        }
        return false;
    }
    public void verifyTableContent(WebElement table, List<List<String>> expectedData) {
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

        for (int i = 0; i < rows.size(); i++) { // Tablo satırlarını dolaş
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));

            for (int j = 0; j < columns.size(); j++) { // Her satırın sütunlarını kontrol et
                String actualValue = columns.get(j).getText().trim();
                String expectedValue = expectedData.get(i).get(j).trim();
                if (!actualValue.equals(expectedValue)) {
                    throw new AssertionError("Beklenen değer: " + expectedValue + ", Ancak bulunan değer: " + actualValue);
                }
            }
        }
    }



}