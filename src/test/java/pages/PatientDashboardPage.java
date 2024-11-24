package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class PatientDashboardPage {

    public PatientDashboardPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);


    }

    @FindBy (xpath = "//*[@id='sibe-box']/ul/li[5]/a")
    public WebElement PharmacySideBarButton;

}
