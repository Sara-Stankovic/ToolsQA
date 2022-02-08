package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage {

    public WebDriver driver;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement fullName(){
        return driver.findElement(By.id("userName"));
    }

    public WebElement email(){
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement currentAddress(){
        return driver.findElement(By.id("currentAddress"));
    }

    public WebElement permanentAddress(){
        return driver.findElement(By.id("permanentAddress"));
    }

    public WebElement submitButton(){
        return driver.findElement(By.id("submit"));
    }

    public void clickSubmit(){
        submitButton().click();
    }

    public WebElement outputText(){
        return driver.findElement(By.id("output"));
    }

    public String getOutputText(){
        return outputText().getText();
    }
}
