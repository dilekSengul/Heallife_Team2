package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class AdminBillingAppointmentPage {

    public AdminBillingAppointmentPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
}