package test;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ElementsTests extends BasePage {

    @BeforeMethod
    public void setupElementsPage(){
        driver.manage().window().maximize();
        driver.navigate().to(homeUrl);
        homePage.clickOnElements();
    }

    @Test
    public void userCanOpenElementsPage(){
        String expectedUrl = excelReader.getStringData("URL", 1,1);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualURL);
        Assert.assertTrue(sidebarPage.mainHeader().contains("Elements"));
    }

    @Test
   public void userCanSubmitTextBoxData(){
        sidebarPage.clickOnTextBox();
        waitVisibility(textBoxPage.fullName());

        String fullName = excelReader.getStringData("TextBox", 1, 0);
        String email = excelReader.getStringData("TextBox", 1, 1);
        String currentAddress = excelReader.getStringData("TextBox", 1, 2);
        String permanentAddress = excelReader.getStringData("TextBox", 1, 3);

        inputText(textBoxPage.fullName(), fullName);
        inputText(textBoxPage.email(), email);
        inputText(textBoxPage.currentAddress(), currentAddress);
        inputText(textBoxPage.permanentAddress(), permanentAddress);

        scroll(textBoxPage.submitButton());
        textBoxPage.clickSubmit();

        Assert.assertTrue(textBoxPage.outputText().isDisplayed());
        String actualOutput = textBoxPage.getOutputText();
        String expectedOutput = excelReader.getStringData("TextBox", 1, 4);
        Assert.assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void userCanExpandCheckBoxTree(){
        sidebarPage.clickOnCheckBox();
        waitVisibility(checkBoxPage.expandAll());
        int stage1 = checkBoxPage.checkboxes().size();
        checkBoxPage.expandCheckboxTree();
        int stage2 = checkBoxPage.checkboxes().size();

        Assert.assertNotEquals(stage1, stage2);
    }

    @Test
    public void userGetsCorrectMessageAfterClickingRadioButton(){
        sidebarPage.clickOnRadioButton();
        click(radioButtonPage.yes());
        waitVisibility(radioButtonPage.getSelectedMessage());

        Assert.assertTrue(radioButtonPage.yes().isSelected());
        String expectedMessage = excelReader.getStringData("RadioButton", 1,0);
        String actualMessage = radioButtonPage.getSelectedMessage().getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void userCanDeleteRowInTheTable(){
        sidebarPage.clickOnWebTables();
        waitVisibility(webTablesPage.deleteButton());
        int stage1 = webTablesPage.editAndDeleteButtons().size();
        String expectedName = webTablesPage.firstName();
        webTablesPage.deleteRow();
        int stage2 = webTablesPage.editAndDeleteButtons().size();

        Assert.assertNotEquals(stage1, stage2);

        String actualName = webTablesPage.firstName();
        Assert.assertNotEquals(actualName, expectedName);
    }

    @Test
    public void userCanChangeNumberOfRows(){
        sidebarPage.clickOnWebTables();
        waitVisibility(webTablesPage.deleteButton());
        int stage1 = webTablesPage.rows().size();
        scroll(webTablesPage.numberOfRows());
        webTablesPage.selectNumberOfRows(0);
        int stage2 = webTablesPage.rows().size();

        Assert.assertNotEquals(stage1, stage2);

        String expectedNumber = "5";
        String actualNumber = webTablesPage.actualNumberOfRows();
        Assert.assertEquals(actualNumber, expectedNumber);
  }

   @Test
    public void userGetsCorrectMessageAfterClickingTheButton(){
        sidebarPage.clickOnButtons();
        buttonsPage.doubleClick();
        Assert.assertTrue(buttonsPage.doubleClickText().isDisplayed());
        String expectedMessage1 = excelReader.getStringData("Buttons", 1, 0);
        String actualMessage1 = buttonsPage.doubleClickText().getText();
        Assert.assertEquals(actualMessage1, expectedMessage1);

       buttonsPage.rightClick();
       Assert.assertTrue(buttonsPage.rightClickText().isDisplayed());
       String expectedMessage2 = excelReader.getStringData("Buttons", 1, 1);
       String actualMessage2 = buttonsPage.rightClickText().getText();
       Assert.assertEquals(actualMessage2, expectedMessage2);

       buttonsPage.dynamicClick();
       Assert.assertTrue(buttonsPage.dynamicClickText().isDisplayed());
       String expectedMessage3 = excelReader.getStringData("Buttons", 1, 2);
       String actualMessage3 = buttonsPage.dynamicClickText().getText();
       Assert.assertEquals(actualMessage3, expectedMessage3);
   }

   @Test
    public void userCanOpenCorrectPageInNewTab(){
        sidebarPage.clickOnLinks();
        linksPage.openNewTab();
        linksPage.switchToTab();

        String expectedUrl = excelReader.getStringData("URL",1,0);
        String actualUrl = linksPage.getNewTabURL();
        Assert.assertEquals(expectedUrl, actualUrl);
   }


   @Test
    public void userCanUploadFile(){
        sidebarPage.clickOnUploadAndDownload();
        waitVisibility(uploadAndDownloadPage.uploadButton());
        String filePath = "C:\\Users\\Sara\\IdeaProjects\\DemoQA\\photo.jpg";
        uploadAndDownloadPage.uploadFile(filePath);

        Assert.assertTrue(uploadAndDownloadPage.uploadedFilePath().isDisplayed());
        String fileName = "photo.jpg";
        Assert.assertTrue(uploadAndDownloadPage.uploadedFilePath().getText().contains(fileName));
   }


}
