package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WebTablesPage {

    public WebDriver driver;

    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
    }


    public List<WebElement> editAndDeleteButtons(){
        return driver.findElements(By.className("action-buttons"));
    }

    public List<WebElement> rows(){
        return driver.findElements(By.className("rt-tr-group"));
    }

    public WebElement deleteButton(){
        return driver.findElement(By.id("delete-record-1"));
    }

    public void deleteRow(){
        deleteButton().click();
    }

    public WebElement numberOfRows(){
        return driver.findElement(By.cssSelector("[aria-label='rows per page']"));
    }

    public String actualNumberOfRows(){
        return numberOfRows().getAttribute("value");
    }

    public void selectNumberOfRows(int index){
        Select dropdownMenu = new Select(numberOfRows());
        dropdownMenu.selectByIndex(index);
    }

    public String firstName(){
        return driver.findElement(By.className("rt-td")).getText();
    }

}
