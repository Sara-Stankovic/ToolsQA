package test;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class WidgetsTests extends BasePage {

    @BeforeMethod
    public void setupWidgetsPage(){
        driver.manage().window().maximize();
        driver.navigate().to(homeUrl);
        homePage.clickOnWidgets();
    }

    @Test
    public void userCanSelectItemFromDropdownMenu(){
        sidebarPage.clickOnSelectMenu();
        waitVisibility(selectMenuPage.oldSelectMenu());
        selectMenuPage.selectFromMenu(1);

        String expectedItem = "Blue";
        String actualItem = selectMenuPage.getSelectedItem(1);

        Assert.assertEquals(expectedItem, actualItem);
    }
}


