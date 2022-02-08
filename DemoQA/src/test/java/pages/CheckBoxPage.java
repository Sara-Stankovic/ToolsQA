package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxPage {

    public WebDriver driver;

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement expandAll(){
        return driver.findElement(By.cssSelector(".rct-icon.rct-icon-expand-all"));
    }

    public void expandCheckboxTree(){
        expandAll().click();
    }

    public List<WebElement> checkboxes(){
        return driver.findElements(By.className("rct-checkbox"));
    }

}
