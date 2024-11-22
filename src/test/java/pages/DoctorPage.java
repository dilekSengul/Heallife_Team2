package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class DoctorPage {

    public DoctorPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }


}
