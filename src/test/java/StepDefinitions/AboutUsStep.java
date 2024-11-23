package StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AboutUsPage;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class AboutUsStep {
    WebDriver driver = Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(AboutUsStep.class);
    AboutUsPage page = new AboutUsPage();

    //Levent//
    @When("Kullanici header bolumunde yer alan AboutUs tiklar")
    public void kullanici_header_bolumunde_yer_alan_about_us_tiklar() {
        page.aboutUsButton.click();
        ReusableMethods.wait(4);
    }
    @Then("Kullanici asagidaki seceklerin alt About menusunde oldugunu dogrular")
    public void kullanici_asagidaki_seceklerin_alt_about_menusunde_oldugunu_dogrular(io.cucumber.datatable.DataTable dataTable) {
        // Verilen tabloyu listeye dönüştür
        List<String> expectedOptions = dataTable.asList();



        // About Us dropdown menüsündeki seçenekleri topla
        WebElement aboutMenu = page.aboutUsButton; // 'aboutMenu' id'yi kendi uygulamanıza göre değiştirin
        aboutMenu.click(); // Menü açılır

        List<WebElement> actualOptionsElements = page.aboutUsMenuDMM2; // XPath'i uygulamaya göre düzenle
        List<String> actualOptions = new ArrayList<>();
        for (WebElement option : actualOptionsElements) {
            actualOptions.add(option.getText());
        }
        System.out.println(expectedOptions);
        System.out.println(actualOptions);
        // Beklenen seçeneklerle mevcut seçenekleri karşılaştır
        Assert.assertEquals(expectedOptions, actualOptions);
    }
    }

    //Levent//




