package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DroppablePage {

    public WebDriver driver;

    public DroppablePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement draggable(){
        return driver.findElement(By.id("draggable"));
    }

    public WebElement droppable(){
        return driver.findElement(By.id("droppable"));
    }

    public void dragAndDrop(){
        Actions act = new Actions(driver);
        act.dragAndDrop(draggable(), droppable()).perform();
    }

    public String getDroppableBoxText(){
      return droppable().getText();
    }


}
