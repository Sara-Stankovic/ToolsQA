package test;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InteractionsTests extends BasePage {

    @BeforeMethod
    public void setupInteractionsPage(){
        driver.manage().window().maximize();
        driver.navigate().to(homeUrl);
        homePage.clickOnInteractions();
    }

    @Test
    public void userCanDragAndDropTextBox() throws InterruptedException {
        Thread.sleep(2000);
        sidebarPage.clickOnDroppable();
        waitVisibility(droppablePage.droppable());
        droppablePage.dragAndDrop();

        String expectedText = "Dropped!";
        String actualText = droppablePage.getDroppableBoxText();
        Assert.assertEquals(actualText, expectedText);
    }
}
