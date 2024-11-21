package StepDefinitions;

import io.cucumber.core.logging.Logger;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import utilities.ReusableMethods;

public class HLhomeStep {

    WebDriver driver = Hooks.getDriver();



    @Given("Kullanıcı HealLife sitesine erişir")
    public void kullanıcı_heal_life_sitesine_erişir() {
        driver.get("https://www.youtube.com");

    }
}

