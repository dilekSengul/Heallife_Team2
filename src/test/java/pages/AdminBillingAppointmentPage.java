package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

import java.util.ArrayList;
import java.util.List;

public class AdminBillingAppointmentPage {

    public AdminBillingAppointmentPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(xpath = "//span[normalize-space()='Dashboard']")
    public WebElement DashboardMenu;

    @FindBy (xpath = "//span[normalize-space()='Appointment']")
    public WebElement AppointmentMenu;

    @FindBy(xpath = "//table[@id='DataTables_Table_0']//thead/tr/th")
    public List <WebElement> appointmentColumnTitles;

    public List<String> getTableHeaders() {
        List<String> headers = new ArrayList<>();
        for (WebElement headerElement :appointmentColumnTitles) {
            headers.add(headerElement.getText().trim());
        }
        return headers;
    }

}