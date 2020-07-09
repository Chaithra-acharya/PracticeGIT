package org.graphwalker;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import DataReader.CSVDataReaderAKOAssessment;
import Helpers.JavascriptHelper;
import PageObjectModels.ManageAssessmentsPage;
import Utils.Config;
import Utils.ConsoleLogger;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

@GraphWalker(value = "quick_random(edge_coverage(100))")
public class AKOAssessmentCreationTest extends ExecutionContext implements org.graphwalker.AKOAssessmentCreation {
    Config config = new Config();
    DriverHelper helper = new DriverHelper();
    ManageAssessmentsPage manageAssessmentsPage = new ManageAssessmentsPage();
    CSVDataReaderAKOAssessment csvDataReaderAKOAssesmentData = new CSVDataReaderAKOAssessment();

    public void v_VerifyAssessmentCreation() {
        csvDataReaderAKOAssesmentData.getCsv();
    }

    public void e_DeleteExistingAssessment() {
        try {
            boolean existingAssessmentName = false;
            if (config.getUserLevel().equalsIgnoreCase("district")) {
                existingAssessmentName = Controllers.ManageAssessmentController.deleteExistingAssessmentName(csvDataReaderAKOAssesmentData.getDistrictLevelAKOAssessmentName());
            } else if (config.getUserLevel().equalsIgnoreCase("campus")) {
                existingAssessmentName = Controllers.ManageAssessmentController.deleteExistingAssessmentName(csvDataReaderAKOAssesmentData.getCampusLevelAKOAssessmentName());
            } else if (config.getUserLevel().equalsIgnoreCase("teacher")) {
                existingAssessmentName = Controllers.ManageAssessmentController.deleteExistingAssessmentName(csvDataReaderAKOAssesmentData.getTeacherLevelAKOAssessmentName());
            }
            if (existingAssessmentName) {
                ConsoleLogger.SuccessLog("Existing Express assessment is deleted OR There were no existing AKO Assessment.");
            } else {
                ConsoleLogger.FailedTestCase("Failed to Delete existing AKO Assessment.");
            }
            Assert.assertTrue(existingAssessmentName);
        } catch (Exception e) {
            System.out.println("Exception handled for e_DeleteExistingAssessment");
        }
    }

    public void v_VerifyAssessment(){

    }

    public void e_ClickCreateAssessmentSelectAssessmentType() {
        try {
            /*Wait till Manage Assessment page completly loads*/
            BrowserInitHelper.getMaxWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(manageAssessmentsPage.getCreateAssessmentDropDown())));

            /*Click Create Assessment drop down*/
            DriverHelper.clickXpath(manageAssessmentsPage.getCreateAssessmentDropDown());

            //Thread.sleep(2000);

            /*Click AKO Assessment type option*/
            BrowserInitHelper.getInstance().findElement(By.xpath("//li[@id= 'licreateako']/a[contains(text(),'Answer Key Only')]")).click();

            /*Wait till the loading icon disapper*/
            DriverHelper.waitUntilLoaderInvisible();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void v_ValidateAssessmentInfo() {

    }
}
