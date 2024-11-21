package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class AdminFrontOffice_Human_ResourcesPage {

    public AdminFrontOffice_Human_ResourcesPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

}
