package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class PatientPage {

    public PatientPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

}
