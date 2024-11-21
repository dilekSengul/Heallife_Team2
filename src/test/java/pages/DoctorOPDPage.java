package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class DoctorOPDPage {

    public DoctorOPDPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

}
