package StepDefinitions;

import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utilities.ReusableMethods;

public class HLhomeStep {

    WebDriver driver = Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(  HLhomeStep.class);



    @Given("Kullanıcı HealLife sitesine erişir")
    public void kullanıcı_heal_life_sitesine_erişir() {
        driver.get("https://www.youtube.com");

    }
}

