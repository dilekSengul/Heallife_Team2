package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class AdminIPDPage {

    public AdminIPDPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

}
