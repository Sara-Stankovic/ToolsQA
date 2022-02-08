package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonPage {

    public WebDriver driver;

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement yes(){
        return driver.findElement(By.id("yesRadio"));
    }

    public WebElement getSelectedMessage(){
        return driver.findElement(By.className("text-success"));
    }
}
