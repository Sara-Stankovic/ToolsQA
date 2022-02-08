package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsPage {

    public WebDriver driver;
    public WebDriverWait wdwait;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement confirmBoxButton(){
        return driver.findElement(By.id("confirmButton"));
    }

    public void clickConfirmBox(){
        confirmBoxButton().click();
    }

    public void clickOk(){
        driver.switchTo().alert().accept();
    }

    public void clickCancel(){
        driver.switchTo().alert().dismiss();
    }

    public WebElement confirmMessage(){
        return driver.findElement(By.id("confirmResult"));
    }

    public String getConfirmMessage(){
      return confirmMessage().getText();
    }

    public WebElement promptBoxButton(){
        return driver.findElement(By.id("promtButton"));
    }

    public void clickPromptBox(){
        promptBoxButton().click();
    }

    public void insertText(String s){
        Alert promptAlert  = driver.switchTo().alert();
        promptAlert.sendKeys(s);
        promptAlert.accept();
    }

    public WebElement promptBoxMessage(){
        return driver.findElement(By.id("promptResult"));
    }

    public String getPromptMessage(){
        return promptBoxMessage().getText();
    }


}
