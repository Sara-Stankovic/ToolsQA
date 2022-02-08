package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class SelectMenuPage {

    public WebDriver driver;

    public SelectMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement oldSelectMenu(){
        return driver.findElement(By.id("oldSelectMenu"));
    }


    public void selectFromMenu(int index) {
        Select select = new Select(oldSelectMenu());
        select.selectByIndex(index);
    }

    public String getSelectedItem(int index){
        Select select = new Select(oldSelectMenu());
        select.selectByIndex(index);
        return select.getFirstSelectedOption().getText();
    }


}