package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class Gallery_ContactUsPage {

    public Gallery_ContactUsPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }


    // [Header] - [Login] bölümünün elementleri

    // [Header] - [Contant Us] bölümünün elementleri

    // [Header] - [About Us] bölümünün elementleri

    // [Footer] - [Social Media] bölümünün elementleri


    // [Footer] - [Communication] bölümünün elementleri

    @FindBy(xpath = "//div[@class='place-card place-card-large']")
    public WebElement MapPhoto;
    @FindBy(xpath = "(//iframe)[2]")//html/body/div[2]//iframe
    public WebElement MapIframe;
    @FindBy(xpath = "//h2[@id='map']")
    public WebElement MapText;

    // [Footer] - [Social Media] bölümünün elementleri

    // [Footer] - [Copyright] bölümünün elementleri

    // [Contac_Us] - [Methods] buraya eklenecek


}
