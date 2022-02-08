package test;

import base.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AlertsTests extends BasePage {

    @BeforeMethod
    public void setupAlertsPage(){
        driver.manage().window().maximize();
        driver.navigate().to(homeUrl);
        homePage.clickOnAlertsFramesWindows();
    }

    public void waiter(){
        String firstMessage = excelReader.getStringData("Alerts", 1, 0);
        wdwait.until(ExpectedConditions.textToBePresentInElement(alertsPage.confirmMessage(), firstMessage));
    }

    @Test
    public void userGetsCorrectMessageAfterClickingOnAlert() {
        sidebarPage.clickOnAlerts();
        click(alertsPage.confirmBoxButton());
        alertsPage.clickOk();

        Assert.assertTrue(alertsPage.confirmMessage().isDisplayed());
        String expectedMessage = excelReader.getStringData("Alerts", 1, 0);
        String actualMessage = alertsPage.getConfirmMessage();
        Assert.assertEquals(actualMessage, expectedMessage);

        waiter();
        alertsPage.clickConfirmBox();
        alertsPage.clickCancel();
        Assert.assertTrue(alertsPage.confirmMessage().isDisplayed());
        String expectedMessage2 = excelReader.getStringData("Alerts", 1, 1);
        String actualMessage2 = alertsPage.getConfirmMessage();
        Assert.assertEquals(actualMessage2, expectedMessage2);
    }

    @Test
    public void userCanEnterNameInPromptBox(){
        sidebarPage.clickOnAlerts();
        waitVisibility(alertsPage.promptBoxButton());
        alertsPage.clickPromptBox();
        String name = excelReader.getStringData("Alerts", 1, 2);
        alertsPage.insertText(name);

        Assert.assertTrue(alertsPage.promptBoxMessage().isDisplayed());
        String expectedMessage = excelReader.getStringData("Alerts", 1, 3);
        String actualMessage = alertsPage.getPromptMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
    }



}
