package org.graphwalker;

import Controllers.AssessmentInfoController;
import Controllers.AssessmentStandardsController;
import DataReader.CSVDataReaderAKOAssessment;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import PageObjectModels.AKOAssessmentInfoPage;
import PageObjectModels.AKOAssessmentStandardsPage;
import PageObjectModels.ManageAssessmentsPage;
import Utils.Config;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;

@GraphWalker(value = "quick_random(edge_coverage(100))")
public class AKOAssessmentStandardsTest extends ExecutionContext implements org.graphwalker.AKOAssessmentStandards{
    Config config = new Config();
    DriverHelper helper = new DriverHelper();
    ManageAssessmentsPage manageAssessmentsPage = new ManageAssessmentsPage();
    AKOAssessmentStandardsPage akoAssessmentstandardsPage = new AKOAssessmentStandardsPage();
    CSVDataReaderAKOAssessment csvDataReaderAKOAssessment = new CSVDataReaderAKOAssessment();
    AssessmentStandardsController assessmentStandardsController = new AssessmentStandardsController();

    public void v_ValidateAssessmentStandard(){
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

    public void e_SearchAndSelectStandards(){
        assessmentStandardsController.selectStandards(csvDataReaderAKOAssessment.getStandard());
    }

    public void v_VerifyAssessmentStandardsPage(){
        String alertMessage = BrowserInitHelper.getInstance().findElement(By.xpath(akoAssessmentstandardsPage.getAlertMessage())).getText();
        System.out.println("alertMessage: "+alertMessage);
        if(alertMessage.equalsIgnoreCase("Standard selection aligned successfully.")){
            DriverHelper.clickXpath(akoAssessmentstandardsPage.getAlertOKButton());
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
    }

    public void e_ClickNextButton(){
        DriverHelper.clickXpath(akoAssessmentstandardsPage.getNextButton());
    }

    public void v_ValidateAssessmentAnswerKeys(){

    }
}
