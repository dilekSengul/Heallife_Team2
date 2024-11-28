package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

import java.util.HashMap;
import java.util.Map;

public class PatientDashboardPage {

    public PatientDashboardPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);


    }

    @FindBy (xpath = "//*[@id='sibe-box']/ul/li[5]/a")
    public WebElement PharmacySideBarButton;

    // Patient dashboard-hurrem
    @FindBy(xpath = "(//*[@class='treeview '])[2]")
    public WebElement myAppointmentsdBoard;


    @FindBy(xpath = "//*[@class='fas fa-stethoscope']")
    public WebElement opdBoard;

    @FindBy(xpath = "(//*[@class='treeview '])[3]")
    public WebElement ipdBoard;

    @FindBy(xpath = "(//*[@class='treeview '])[4]")
    public WebElement pharmacyBoard;

    @FindBy(xpath = "(//*[@class='treeview '])[5]")
    public WebElement pathologyBoard;

    @FindBy(xpath = "(//*[@class='treeview '])[6]")
    public WebElement radiologyBoard;

    @FindBy(xpath = "(//*[@class='treeview '])[7]")
    public WebElement ambulanceBoard;

    @FindBy(xpath = "(//*[@class='treeview '])[8]")
    public WebElement bloodBankBoard;

    @FindBy(xpath = "(//*[@class='treeview '])[9]")
    public WebElement  liveConsultation;

    // Yardımcı metod: Board ismine göre ilgili WebElement'i döndürüyor
    public  WebElement getBoardElementByName(String boardName) {
        switch (boardName) {
            case "OPD":
                return opdBoard;
            case "IPD":
                return ipdBoard;
            case "Pharmacy":
                return pharmacyBoard;
            case "Pathology":
                return pathologyBoard;
            case "Radiology":
                return radiologyBoard;
            case "Blood Bank":
                return bloodBankBoard;
            case "Ambulance":
                return ambulanceBoard;
            case "Live Consultation":
                return liveConsultation;
            default:
                throw new IllegalArgumentException("Bilinmeyen panel ismi: " + boardName);  // Geçersiz panel ismi durumunda hata verilir
        }
    }

    public Map<String, String> getBoardUrls() {
        Map<String, String> boardUrls = new HashMap<>();
        boardUrls.put("OPD", "https://qa.heallifehospital.com/patient/dashboard/profile");
        boardUrls.put("IPD", "https://qa.heallifehospital.com/patient/dashboard/patientipddetails");
        boardUrls.put("Pharmacy", "https://qa.heallifehospital.com/patient/dashboard/pharmacybill");
        boardUrls.put("Pathology", "https://qa.heallifehospital.com/patient/dashboard/pathology");
        boardUrls.put("Radiology", "https://qa.heallifehospital.com/patient/dashboard/radiology");
        boardUrls.put("Ambulance", "https://qa.heallifehospital.com/patient/dashboard/ambulance");
        boardUrls.put("Blood Bank", "https://qa.heallifehospital.com/patient/dashboard/bloodbank");
        boardUrls.put("Live Consultation", "https://qa.heallifehospital.com/patient/dashboard/liveconsult");
        return boardUrls;
    }

    // Medical History grafiği element tanımı
    @FindBy(id = "medical-history-chart")
    public WebElement medicalHistoryGraph;
    // OPD değeri
    @FindBy(xpath = "//div[contains(@class, 'chart-info')]//div[contains(text(),'OPD')]")
    public WebElement opdValue;

    // IPD değeri
    @FindBy(xpath = "//div[contains(@class, 'chart-info')]//div[contains(text(),'IPD')]")
    public WebElement ipdValue;

    // Pharmacy değeri
    @FindBy(xpath = "//div[contains(@class, 'chart-info')]//div[contains(text(),'Pharmacy')]")
    public WebElement pharmacyValue;

    // Pathology değeri
    @FindBy(xpath = "//div[contains(@class, 'chart-info')]//div[contains(text(),'Pathology')]")
    public WebElement pathologyValue;

    // Radiology değeri
    @FindBy(xpath = "//div[contains(@class, 'chart-info')]//div[contains(text(),'Radiology')]")
    public WebElement radiologyValue;

    // Blood Bank değeri
    @FindBy(xpath = "//div[contains(@class, 'chart-info')]//div[contains(text(),'Blood Bank')]")
    public WebElement bloodBankValue;

    // Ambulance değeri
    @FindBy(xpath = "//div[contains(@class, 'chart-info')]//div[contains(text(),'Ambulance')]")
    public WebElement ambulanceValue;

    // Belirtiler için özet grafik
    @FindBy(xpath = "(//div[@class='box-body'])[2]")
    public WebElement belirtilerGrafik;

    // Semptomlar için özet grafik
    @FindBy(xpath = "(//div[@class='box-body'])[3]")
    public WebElement semptomlarGrafik;


    //dil değişimi.
    @FindBy(xpath = "//*[@id=\"alert\"]/nav/div[2]/div/div/div/div/button")
    public WebElement dilSecimi;

    @FindBy(xpath = "//*[@id=\"alert\"]/nav/div[2]/div/div/div/div/div/ul/li[2]/a/span")
    public WebElement turkdili;
    @FindBy(xpath = "//*[@id=\"alert\"]/nav/div[2]/div/div/div/div/button/span[1]/span")
    public WebElement turcegoruntuleme;


    @FindBy(xpath = "//*[@id=\"alert\"]/nav/div[2]/div/div/ul/li[1]/a")
    public WebElement bildirim;

    @FindBy(xpath = "/html/body/div[1]/div[1]/section/div/div/div/div[1]/div/button/i")
    public WebElement bildirimsilmek;

    @FindBy(className = "topuser-image")
    public WebElement profilresmivebilgı;

    @FindBy (xpath = "//*[@id=\"alert\"]/nav/div[2]/div/div/ul/li[2]/ul/li/div/div[4]/a[2]")
    public WebElement profillogout;


}
