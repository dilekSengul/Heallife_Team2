package StepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import utilities.DriverManager;

public class HLhomeStep {

    WebDriver driver = StepDefinitions.Hooks.getDriver();

    @Given("Kullanıcı HealLife sitesine erişir")
    public void kullanıcı_heal_life_sitesine_erişir() {
        driver.get("https://www.youtube.com");
    }
}

