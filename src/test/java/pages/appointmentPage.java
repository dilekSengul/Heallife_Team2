package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class AppointmentPage {

    public AppointmentPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

}
