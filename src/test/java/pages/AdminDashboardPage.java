package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class AdminDashboardPage {

    public AdminDashboardPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

}
