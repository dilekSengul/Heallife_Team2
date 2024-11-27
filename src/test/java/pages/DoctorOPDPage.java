package pages;

import StepDefinitions.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class DoctorOPDPage {

    public DoctorOPDPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
    WebDriver driver = Hooks.getDriver();

    //Doctor Sidebar OPD linki
    @FindBy(xpath = "/html/body/div[1]/aside/div/section/ul[2]/li[4]")
    public WebElement doctorSidebarOpd;

    @FindBy(xpath = "//div[@class='box-header with-border']")
    public WebElement OPDpatientBoxDogrulama;


}
