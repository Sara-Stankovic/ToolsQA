package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class LinksPage {

    public WebDriver driver;

    public LinksPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement newTab(){
        return driver.findElement(By.id("simpleLink"));
    }

    public void openNewTab(){
        newTab().click();
    }


    public void switchToTab(){
        List<String> browserTabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
    }

    public String getNewTabURL(){
        return driver.getCurrentUrl();
    }

}
