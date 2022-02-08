package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> listOfPages() {
        return driver.findElements(By.className("card-body"));
    }

    public void scroll(WebElement w) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", w);
    }

    public void clickOnElements() {
        scroll(listOfPages().get(0));
        listOfPages().get(0).click();
    }

    public void clickOnAlertsFramesWindows() {
        scroll(listOfPages().get(2));
        listOfPages().get(2).click();
    }

    public void clickOnWidgets() {
        scroll(listOfPages().get(3));
        listOfPages().get(3).click();
    }

    public void clickOnInteractions(){
        scroll(listOfPages().get(4));
        listOfPages().get(4).click();
    }
}