package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class Gallery_ContactUsPage {

    public Gallery_ContactUsPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

}
