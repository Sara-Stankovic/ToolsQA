package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadAndDownloadPage {

    public WebDriver driver;

    public UploadAndDownloadPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement uploadButton(){
        return driver.findElement(By.id("uploadFile"));
    }

    public void uploadFile(String path){
        uploadButton().sendKeys(path);
    }


    public WebElement uploadedFilePath(){
        return driver.findElement(By.id("uploadedFilePath"));
    }
}
