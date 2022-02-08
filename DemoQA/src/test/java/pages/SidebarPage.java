package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class SidebarPage {

    public WebDriver driver;
    public WebDriverWait wdwait;

    public SidebarPage(WebDriver driver) {
        this.driver = driver;
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String mainHeader(){
        return driver.findElement(By.className("main-header")).getText();
    }

   public List<WebElement> listOfSubpages(){
        return driver.findElements(By.cssSelector(".btn.btn-light"));
    }

    public void waitVisibility(WebElement w){
        wdwait.until(ExpectedConditions.visibilityOf(w));
    }

    public void scroll(WebElement w) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", w);
    }


    public void clickOnTextBox(){
        waitVisibility(listOfSubpages().get(0));
        listOfSubpages().get(0).click();
    }

    public void clickOnCheckBox(){
        waitVisibility(listOfSubpages().get(1));
        listOfSubpages().get(1).click();
    }

    public void clickOnRadioButton(){
        waitVisibility(listOfSubpages().get(2));
        listOfSubpages().get(2).click();
    }

    public void clickOnWebTables(){
        waitVisibility(listOfSubpages().get(3));
        listOfSubpages().get(3).click();
    }

    public void clickOnButtons(){
        scroll(listOfSubpages().get(3));
        listOfSubpages().get(4).click();
    }

    public void clickOnLinks(){
        scroll(listOfSubpages().get(5));
        listOfSubpages().get(5).click();
    }

    public void clickOnUploadAndDownload(){
        scroll(listOfSubpages().get(7));
        listOfSubpages().get(7).click();
    }

    public void clickOnAlerts() {
        scroll(listOfSubpages().get(11));
        listOfSubpages().get(11).click();
    }


    public void clickOnSelectMenu(){
        scroll(listOfSubpages().get(23));
        listOfSubpages().get(23).click();
    }

    public void clickOnDroppable(){
        scroll(listOfSubpages().get(27));
        listOfSubpages().get(27).click();
    }

}
