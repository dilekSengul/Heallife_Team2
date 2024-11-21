package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class AboutUsPage {

    public AboutUsPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

}
