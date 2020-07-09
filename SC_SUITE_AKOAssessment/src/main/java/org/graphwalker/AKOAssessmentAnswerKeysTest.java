package org.graphwalker;

import Controllers.AssessmentStandardsController;
import DataReader.CSVDataReaderAKOAssessment;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import PageObjectModels.AKOAssessmentAnswerKeysPage;
import PageObjectModels.AKOAssessmentInfoPage;
import PageObjectModels.AKOAssessmentStandardsPage;
import PageObjectModels.ManageAssessmentsPage;
import Utils.Config;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

@GraphWalker(value = "quick_random(edge_coverage(100))")
public class AKOAssessmentAnswerKeysTest extends ExecutionContext implements org.graphwalker.AKOAssessmentAnswerKeys {
    Config config = new Config();
    DriverHelper helper = new DriverHelper();
    AKOAssessmentInfoPage akoAssessmentInfoPage = new AKOAssessmentInfoPage();
    AKOAssessmentStandardsPage akoAssessmentStandardsPage = new AKOAssessmentStandardsPage();
    AKOAssessmentAnswerKeysPage akoAssessmentAnswerKeysPage = new AKOAssessmentAnswerKeysPage();
    CSVDataReaderAKOAssessment csvDataReaderAKOAssessment = new CSVDataReaderAKOAssessment();

    public void v_ValidateAssessmentAnswerKeys(){
        csvDataReaderAKOAssessment.getCsv();
        try {
            DriverHelper.waitUntilLoaderInvisible();
            //DriverHelper.waitTill(5);
            JavascriptHelper.scrollUp();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void e_EnterItemNumbers(){
        /*Enter the number of Items*/
        DriverHelper.sendKeysXpath(akoAssessmentAnswerKeysPage.getNumberOfItemsTextbox(), csvDataReaderAKOAssessment.getItemsCount());

        /*Click Update button*/
        //DriverHelper.clickXpath(akoAssessmentAnswerKeysPage.getUpdateButton());
        JavascriptHelper.click_Xpath(akoAssessmentAnswerKeysPage.getUpdateButton());

        /*Wait until loading icon disappear*/
        DriverHelper.waitUntilLoaderInvisible();
    }

    public void v_VerifyItemTable(){
        if(BrowserInitHelper.getInstance().findElement(By.xpath(akoAssessmentAnswerKeysPage.getTableItems())).isDisplayed()){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
    }

    public void e_SelectItemDetailsAndSave(){
        /*Select 1st Item*/
        if(csvDataReaderAKOAssessment.getQuestion1ItemType().equalsIgnoreCase("MC")){
            selectItemType("1", csvDataReaderAKOAssessment.getQuestion1ItemType());
            selectNumberOfChoices("1", csvDataReaderAKOAssessment.getAnswerChoice());
            selectTypeOfChoices("1", csvDataReaderAKOAssessment.getTypeOfChoice());
            selectAnswerChoice("1", csvDataReaderAKOAssessment.getMcItemTypeAnswerChoice());
            enterPoints("1", csvDataReaderAKOAssessment.getPoints());
            selectStandard("1", csvDataReaderAKOAssessment.getStandard());
        }

        /*Select 2nd Item*/
        if(csvDataReaderAKOAssessment.getQuestion2ItemType().equalsIgnoreCase("MR")){
            selectItemType("2", csvDataReaderAKOAssessment.getQuestion2ItemType());
            selectNumberOfChoices("2", csvDataReaderAKOAssessment.getAnswerChoice());
            selectTypeOfChoices("2", csvDataReaderAKOAssessment.getTypeOfChoice());
            selectAnswerChoice("2", csvDataReaderAKOAssessment.getMrItemTypeAnswerChoice());
            enterPoints("2", csvDataReaderAKOAssessment.getPoints());
            selectStandard("2", csvDataReaderAKOAssessment.getStandard());
        }

        /*Select 3rd Item*/
        if(csvDataReaderAKOAssessment.getQuestion3ItemType().equalsIgnoreCase("CR")){
            /*Scroll till Item Type drop down*/
            //JavascriptHelper.scrollIntoView("//span[@data-id='questiontype_"+2+"']");
            JavascriptHelper.scrollIntoViewById("ipPoints_2");

            selectItemType("3", csvDataReaderAKOAssessment.getQuestion3ItemType());
            enterCRItemRubricDetails("3", csvDataReaderAKOAssessment.getCrItemRubricPoints(), csvDataReaderAKOAssessment.getCrItemRubricMultiplier());
            JavascriptHelper.scrollIntoViewById("ipPoints_2");
            selectStandard("3", csvDataReaderAKOAssessment.getStandard());
        }

        /*Select 4th Item*/
        if(csvDataReaderAKOAssessment.getQuestion4ItemType().equalsIgnoreCase("SA")){
            selectItemType("4", csvDataReaderAKOAssessment.getQuestion4ItemType());
            enterPoints("4", csvDataReaderAKOAssessment.getPoints());
            selectStandard("4", csvDataReaderAKOAssessment.getStandard());
        }

        /*Select 5th Item*/
        if(csvDataReaderAKOAssessment.getQuestion5ItemType().equalsIgnoreCase("MB")){
            selectItemType("5", csvDataReaderAKOAssessment.getQuestion5ItemType());
            selectMBAnswerChoice("5", csvDataReaderAKOAssessment.getMbItemAnswerChoice());
            enterPoints("5", csvDataReaderAKOAssessment.getPoints());
            selectStandard("5", csvDataReaderAKOAssessment.getStandard());
        }

        /*Select 6th Item*/
        if(csvDataReaderAKOAssessment.getQuestion6ItemType().equalsIgnoreCase("NR")){
            selectItemType("6", csvDataReaderAKOAssessment.getQuestion6ItemType());
            selectNTGriddableTemplate("6", csvDataReaderAKOAssessment.getNrItemGriddableTemplate());
            enterNRItemAnswer("6", csvDataReaderAKOAssessment.getNrItemAnswer());
            enterPoints("6", csvDataReaderAKOAssessment.getPoints());
            selectStandard("6", csvDataReaderAKOAssessment.getStandard());
        }

        /*Select 7th Item*/
        if(csvDataReaderAKOAssessment.getQuestion7ItemType().equalsIgnoreCase("EBSR")){
           JavascriptHelper.scrollIntoView("//span[@data-id='questiontype_7']");
            selectItemType("7", csvDataReaderAKOAssessment.getQuestion7ItemType());
            selectEBSRTypeAItemType("7", csvDataReaderAKOAssessment.getEbsrSubItemType1());
            selectEBSRTypeBItemType("7", csvDataReaderAKOAssessment.getEbsrSubItemType2());
            selectEBSRPartANumberOfChoices("7", csvDataReaderAKOAssessment.getAnswerChoice());
            selectEBSRPartBNumberOfChoices("7", csvDataReaderAKOAssessment.getAnswerChoice());
            selectEBSRPartAAnswerChoice("7", csvDataReaderAKOAssessment.getEbsrSubItemType1AnswerChoice());
            selectEBSRPartBAnswerChoice("7", csvDataReaderAKOAssessment.getEbsrSubItemType2AnswerChoice());
            enterPoints("7", csvDataReaderAKOAssessment.getPoints());
            selectStandard("7", csvDataReaderAKOAssessment.getStandard());
        }

        /*Click Save button*/
        DriverHelper.clickXpath(akoAssessmentAnswerKeysPage.getSaveButton());

        /*Wait until the display of alert message*/
        BrowserInitHelper.getMaxWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(akoAssessmentStandardsPage.getAlertOKButton())));
    }

    public void selectItemType(String itemNumber, String itemType){
        /*Click Question Type drop down*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//span[@data-id='questiontype_"+itemNumber+"']")).click();

        /*Select the Item Type*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//ul[@id='questiontype_"+itemNumber+"']//span[contains(text(), '"+itemType+"')]")).click();
    }

    public void selectNumberOfChoices(String itemNumber, String choiceCount){
        /*Click # of choices drop down*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//span[@data-id='itemnoofchoice_"+itemNumber+"']")).click();

        /*Select the Choice count*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//ul[@id='itemnoofchoice_"+itemNumber+"']//span[contains(text(), '"+choiceCount+"')]")).click();
    }

    public void selectTypeOfChoices(String itemNumber, String answerChoiceType){
        /*Click type of choices drop down*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//span[@data-id='itemstypeofchoice_"+itemNumber+"']")).click();

        /*Select the Choice type*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//ul[@id='itemstypeofchoice_"+itemNumber+"']//span[contains(text(), '"+answerChoiceType+"')]")).click();
    }

    public void selectAnswerChoice(String itemNumber, String answerChoice){
        /*Select the Correct Answer Choice*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//td[@id='tdOption_"+itemNumber+"']/button[contains(text(), '"+answerChoice+"')]")).click();
    }

    public void selectMBAnswerChoice(String itemNumber, String answerChoice){
        try {
            List<WebElement> mbAnswerChoices = BrowserInitHelper.getInstance().findElements(By.xpath("//td[@id='tdOption_" + itemNumber + "']/button"));
            int j = 0;
            List<String> items = Arrays.asList(answerChoice.split("\\s*,\\s*"));
            String correctAnswerChoice;

            //System.out.println("mbAnswerChoices.size(): "+mbAnswerChoices.size());
            for (int i = 0; i < items.size(); i++) {
                j = i + 1;
                correctAnswerChoice = items.get(i);
                //System.out.println("correctAnswerChoice: " + correctAnswerChoice);
                BrowserInitHelper.getInstance().findElement(By.xpath("(//td[@id='tdOption_" + itemNumber + "']/button[contains(text(), '" + correctAnswerChoice + "')])[" + j + "]")).click();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void selectNTGriddableTemplate(String itemNumber, String templateName){
        /*Click Select Griddable Template button*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//a[@id = 'btn-select-gt_"+itemNumber+"']")).click();

        /*Select the Template*/
        JavascriptHelper.clickXpath_JS("//b[contains(text(), '"+templateName+"')]/following-sibling::a[text() = 'Select This Template']");
    }

    public void enterNRItemAnswer(String itemNumber, String nrItemAnswer){
        List<WebElement> nrAnswerTextboxes = BrowserInitHelper.getInstance().findElements(By.xpath("//ul[@id='ulGridDropDown_"+itemNumber+"']//input"));

        for(int i=0; i<nrAnswerTextboxes.size(); i++){
            JavascriptHelper.sendTextByID(nrAnswerTextboxes.get(i).getAttribute("id"), String.valueOf(nrItemAnswer.charAt(i)));
        }
    }

    public void selectEBSRTypeAItemType(String itemNumber, String itemType){
        /*Click Part A item type drop down*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//button[@data-id='EBSR_ItemType_A_"+itemNumber+"']")).click();

        /*Select the item type*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//ul[@id='EBSR_ItemType_A_"+itemNumber+"']//span[contains(text(), '"+itemType+"')]")).click();
    }

    public void selectEBSRTypeBItemType(String itemNumber, String itemType){
        /*Click Part B item type drop down*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//button[@data-id='EBSR_ItemType_B_"+itemNumber+"']")).click();

        /*Select the item type*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//ul[@id='EBSR_ItemType_B_"+itemNumber+"']//span[contains(text(), '"+itemType+"')]")).click();
    }

    public void selectEBSRPartANumberOfChoices(String itemNumber, String choiceCount){
        /*Click # of choices drop down*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//span[@data-id='itemnoofchoice_A_"+itemNumber+"']")).click();

        /*Select the Choice count*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//ul[@id='itemnoofchoice_A_"+itemNumber+"']//span[contains(text(), '"+choiceCount+"')]")).click();
    }

    public void selectEBSRPartBNumberOfChoices(String itemNumber, String choiceCount){
        /*Click # of choices drop down*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//span[@data-id='itemnoofchoice_B_"+itemNumber+"']")).click();

        /*Select the Choice count*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//ul[@id='itemnoofchoice_B_"+itemNumber+"']//span[contains(text(), '"+choiceCount+"')]")).click();
    }

    public void selectEBSRPartAAnswerChoice(String itemNumber, String correctAnswerChoice){
        /*Select the Correct Answer Choice*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//td[@id='tdOption_"+itemNumber+"']/button[contains(text(), '"+correctAnswerChoice+"')]")).click();
    }

    public void selectEBSRPartBAnswerChoice(String itemNumber, String correctAnswerChoice){
        /*Select the Correct Answer Choice*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//td[@id='tdOption_B_"+itemNumber+"']/button[contains(text(), '"+correctAnswerChoice+"')]")).click();
    }

    public void enterPoints(String itemNumber, String points){
        /*Clear the Points textbox*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//input[@id='ipPoints_"+itemNumber+"']")).clear();

        /*Enter the Points*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//input[@id='ipPoints_"+itemNumber+"']")).sendKeys(points);
    }

    public void selectStandard(String itemNumber, String standard){
        /*Click Standards drop down*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//span[@data-id='itemStandards_"+itemNumber+"']")).click();

        /*Select the Standard*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//ul[@id='itemStandards_"+itemNumber+"']//span[contains(text(), '"+standard+"')]")).click();

        /*Click District header*/
        DriverHelper.clickXpath(akoAssessmentInfoPage.getDistrictHeader());
    }

    public void enterCRItemRubricDetails(String itemNumber, String rubricPoints, String rubricMultiplier){
        /*Clear Rubric Points textbox*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//input[@id='txtrubricpoints_"+itemNumber+"']")).clear();

        /*Enter Rubrci Points*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//input[@id='txtrubricpoints_"+itemNumber+"']")).sendKeys(rubricPoints);

        /*Enter Rubrci Multiplier*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//input[@id='txtrubricmulti_"+itemNumber+"']")).sendKeys(rubricMultiplier);
    }

    public void v_VerifyAnswerKeysPage(){
        /*Validate the alert message*/
        if(BrowserInitHelper.getInstance().findElement(By.xpath(akoAssessmentStandardsPage.getAlertMessage())).getText().equalsIgnoreCase("Answer Key details saved successfully.")){
            DriverHelper.clickXpath(akoAssessmentStandardsPage.getAlertOKButton());
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
    }

    public void v_ValidateAssessmentPerformanceLevel(){
        /*Click Next Button*/
        DriverHelper.clickXpath(akoAssessmentAnswerKeysPage.getNextButton());
    }
}
