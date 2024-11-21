package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class DoctorIPDPage {

    public DoctorIPDPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

}
