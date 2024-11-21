package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class AdminOPDPage {

    public AdminOPDPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

}
