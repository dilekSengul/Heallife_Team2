package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class AdminBirthand_DeathRecord_FinancePage {

    public AdminBirthand_DeathRecord_FinancePage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

}
