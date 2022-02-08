package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ButtonsPage {

    public WebDriver driver;

    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement doubleClickButton(){
        return driver.findElement(By.id("doubleClickBtn"));
    }

    public void doubleClick(){
        Actions act = new Actions(driver);
        act.doubleClick(doubleClickButton()).perform();
    }

    public WebElement doubleClickText(){
        return driver.findElement(By.id("doubleClickMessage"));
    }

   //******************************************

    public WebElement rightClickButton(){
        return driver.findElement(By.id("rightClickBtn"));
    }

    public void rightClick(){
        Actions act = new Actions(driver);
        act.contextClick(rightClickButton()).perform();
    }

    public WebElement rightClickText(){
        return driver.findElement(By.id("rightClickMessage"));
    }

    //*****************************************

    public List<WebElement> buttons(){
        return driver.findElements(By.cssSelector(".btn.btn-primary"));
    }

    public void dynamicClick(){
        buttons().get(2).click();
    }

    public WebElement dynamicClickText(){
        return driver.findElement(By.id("dynamicClickMessage"));
    }


}
