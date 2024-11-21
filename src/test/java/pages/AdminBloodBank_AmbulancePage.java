package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class AdminBloodBank_AmbulancePage {

    public AdminBloodBank_AmbulancePage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

}
