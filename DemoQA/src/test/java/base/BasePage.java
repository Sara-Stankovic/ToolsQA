package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import pages.*;

import java.io.IOException;
import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public ExcelReader excelReader;
    public WebDriverWait wdwait;
    public HomePage homePage;
    public String homeUrl;
    public SidebarPage sidebarPage;
    public TextBoxPage textBoxPage;
    public CheckBoxPage checkBoxPage;
    public RadioButtonPage radioButtonPage;
    public WebTablesPage webTablesPage;
    public ButtonsPage buttonsPage;
    public LinksPage linksPage;
    public SelectMenuPage selectMenuPage;
    public AlertsPage alertsPage;
    public DroppablePage droppablePage;
    public UploadAndDownloadPage uploadAndDownloadPage;


    @BeforeClass
    public  void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        excelReader = new ExcelReader("DemoQA.xlsx");
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage(driver);
        homeUrl = excelReader.getStringData("URL", 1, 0);
        sidebarPage = new SidebarPage(driver);
        textBoxPage = new TextBoxPage(driver);
        checkBoxPage = new CheckBoxPage(driver);
        radioButtonPage = new RadioButtonPage(driver);
        webTablesPage = new WebTablesPage(driver);
        buttonsPage = new ButtonsPage(driver);
        linksPage = new LinksPage(driver);
        selectMenuPage = new SelectMenuPage(driver);
        alertsPage = new AlertsPage(driver);
        droppablePage = new DroppablePage(driver);
        uploadAndDownloadPage = new UploadAndDownloadPage(driver);
    }

    public void waitVisibility(WebElement w){
        wdwait.until(ExpectedConditions.visibilityOf(w));
    }

    public void scroll(WebElement w) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", w);
    }

    public void click (WebElement w) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", w);
    }

    public void inputText(WebElement w, String s){
        w.sendKeys(s);
    }

  /*  @AfterClass
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }*/


}

