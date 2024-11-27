package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TPAManagementPage {



        WebDriver driver;

        public TPAManagementPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//button[@id='tpaManagementButton']")
        public WebElement tpaManagementButton;

        @FindBy(xpath = "//table[@id='tpaTable']//th")
        public WebElement tableHeaders;

        @FindBy(xpath = "//input[@id='searchBar']")
        public WebElement searchBar;

        @FindBy(xpath = "//select[@id='rowsPerPage']")
        public WebElement rowsPerPageDropdown;

        @FindBy(xpath = "//table[@id='tpaTable']//button[contains(text(), 'Organization')]")
        public WebElement organizationButton;

        @FindBy(xpath = "//h1[text()='Details']")
        public WebElement detailsPageHeader;


}
