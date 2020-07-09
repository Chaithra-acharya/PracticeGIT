package org.graphwalker;

import Controllers.AssessmentPerformanceLevelsController;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import DataReader.CSVDataReaderAKOAssessment;
import Helpers.JavascriptHelper;
import PageObjectModels.AKOAssessmentAnswerKeysPage;
import PageObjectModels.AKOAssessmentInfoPage;
import PageObjectModels.AKOAssessmentPerformanceLevelsPage;
import PageObjectModels.AKOAssessmentStandardsPage;
import Utils.Config;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

@GraphWalker(value = "quick_random(edge_coverage(100))")
public class AKOAssessmentPerformanceLevelsTest extends ExecutionContext implements org.graphwalker.AKOAssessmentPerformanceLevels{
    Config config = new Config();
    DriverHelper helper = new DriverHelper();
    AKOAssessmentInfoPage akoAssessmentInfoPage = new AKOAssessmentInfoPage();
    AKOAssessmentStandardsPage akoAssessmentStandardsPage = new AKOAssessmentStandardsPage();
    AKOAssessmentAnswerKeysPage akoAssessmentAnswerKeysPage = new AKOAssessmentAnswerKeysPage();
    AssessmentPerformanceLevelsController assessmentPerformanceLevelsController = new AssessmentPerformanceLevelsController();
    AKOAssessmentPerformanceLevelsPage akoAssessmentPerformanceLevelsPage = new AKOAssessmentPerformanceLevelsPage();
    CSVDataReaderAKOAssessment csvDataReaderAKOAssessment = new CSVDataReaderAKOAssessment();

    public void v_ValidateAssessmentPerformanceLevel(){
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

    public void e_LoadPLTemplate(){
        assessmentPerformanceLevelsController.loadAvailableTemplate(csvDataReaderAKOAssessment.getSkipPerformanceLevel(),
                csvDataReaderAKOAssessment.getSetupPerformanceLevelBy(), csvDataReaderAKOAssessment.getPlTemplateName());
    }

    public void v_VerifyPerformanceLevelTable(){
        /*Validate the presence of PL Level data table*/
        System.out.println("Data table: "+akoAssessmentPerformanceLevelsPage.getPlDataTable());
        BrowserInitHelper.getMinWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(akoAssessmentPerformanceLevelsPage.getPlDataTable())));

        if(BrowserInitHelper.getInstance().findElement(By.xpath(akoAssessmentPerformanceLevelsPage.getPlDataTable())).isDisplayed()){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
    }

    public void e_SavePLPage(){
        /*Click on Save*/
        DriverHelper.clickXpath(akoAssessmentPerformanceLevelsPage.getSaveButton());

        /*Wait till the display of Alert message*/
        BrowserInitHelper.getMaxWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(akoAssessmentStandardsPage.getAlertOKButton())));
    }

    public void v_VerifyPerformanceLevelsPage(){
        if(BrowserInitHelper.getInstance().findElement(By.xpath(akoAssessmentStandardsPage.getAlertMessage())).getText().equalsIgnoreCase("Performance Level(s) saved successfully.")){
            DriverHelper.clickXpath(akoAssessmentStandardsPage.getAlertOKButton());
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
    }

    public void v_ValidateAssessmentSetup(){
        /*Click Next button*/
        DriverHelper.clickXpath(akoAssessmentPerformanceLevelsPage.getNextButton());
    }
}
