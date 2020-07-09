package org.graphwalker;

//import Controllers.AssessmentInfoController;
//import Helpers.BrowserInitHelper;
//import Helpers.DriverHelper;
//import DataReader.CSVDataReaderAKOAssessment;
//import Helpers.JavascriptHelper;
//import PageObjectModels.AKOAssessmentInfoPage;
//import PageObjectModels.ManageAssessmentsPage;
//import Utils.Config;
//import org.graphwalker.core.machine.ExecutionContext;
//import org.graphwalker.java.annotation.GraphWalker;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedConditions;


import Controllers.AssessmentInfoController;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import PageObjectModels.AKOAssessmentInfoPage;
import PageObjectModels.ManageAssessmentsPage;
import Utils.Config;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import DataReader.CSVDataReaderAKOAssessment;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.google.common.base.Function;

@GraphWalker(value = "quick_random(edge_coverage(100))")
public class AKOAssessmentInfoTest extends ExecutionContext implements org.graphwalker.AKOAssessmentInfo{
    Config config = new Config();
    DriverHelper helper = new DriverHelper();
    ManageAssessmentsPage manageAssessmentsPage = new ManageAssessmentsPage();
    AKOAssessmentInfoPage akoAssessmentInfoPage = new AKOAssessmentInfoPage();
    CSVDataReaderAKOAssessment csvDataReaderAKOAssessment = new CSVDataReaderAKOAssessment();
    AssessmentInfoController assessmentInfoController = new AssessmentInfoController();

    public void v_ValidateAssessmentInfo(){
        csvDataReaderAKOAssessment.getCsv();
    }

    public void e_EnterAssessmentDetails() {
        if (config.getUserLevel().equalsIgnoreCase("district")) {
            assessmentInfoController.enterAssessmentDetails(csvDataReaderAKOAssessment.getDistrictLevelAKOAssessmentName(), csvDataReaderAKOAssessment.getSubject(),
                    csvDataReaderAKOAssessment.getCollection(), csvDataReaderAKOAssessment.getPlc(), csvDataReaderAKOAssessment.getSetupMultipleGrades(),
                    csvDataReaderAKOAssessment.getGrade(), csvDataReaderAKOAssessment.getScheduleStudents(), csvDataReaderAKOAssessment.getCourseGroup(),
                    csvDataReaderAKOAssessment.getCourse(), csvDataReaderAKOAssessment.getStudentGroup());
        } else if (config.getUserLevel().equalsIgnoreCase("campus")) {
            assessmentInfoController.enterAssessmentDetails(csvDataReaderAKOAssessment.getCampusLevelAKOAssessmentName(), csvDataReaderAKOAssessment.getSubject(),
                    csvDataReaderAKOAssessment.getCollection(), csvDataReaderAKOAssessment.getPlc(), csvDataReaderAKOAssessment.getSetupMultipleGrades(),
                    csvDataReaderAKOAssessment.getGrade(), csvDataReaderAKOAssessment.getScheduleStudents(), csvDataReaderAKOAssessment.getCourseGroup(),
                    csvDataReaderAKOAssessment.getCourse(), csvDataReaderAKOAssessment.getStudentGroup());
        }
        else{
            assessmentInfoController.enterAssessmentDetails(csvDataReaderAKOAssessment.getTeacherLevelAKOAssessmentName(), csvDataReaderAKOAssessment.getSubject(),
                    csvDataReaderAKOAssessment.getCollection(), csvDataReaderAKOAssessment.getPlc(), csvDataReaderAKOAssessment.getSetupMultipleGrades(),
                    csvDataReaderAKOAssessment.getGrade(), csvDataReaderAKOAssessment.getScheduleStudents(), csvDataReaderAKOAssessment.getCourseGroup(),
                    csvDataReaderAKOAssessment.getCourse(), csvDataReaderAKOAssessment.getStudentGroup());
        }
    }

    public void v_VerifyAssessmentInfoPage(){
        /*Validate the display of Save alert message on clicking Save button*/
        BrowserInitHelper.getMaxWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(akoAssessmentInfoPage.getSaveMessage())));

        JavascriptHelper.scrollIntoView(akoAssessmentInfoPage.getSaveMessage());

        if(DriverHelper.verifyDisplayByXpath(akoAssessmentInfoPage.getSaveMessage())){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
    }

    public void v_ValidateAssessmentStandard(){
        JavascriptHelper.scrollUp();

        /*Click Next button*/
        DriverHelper.clickXpath(akoAssessmentInfoPage.getNextButton());
    }
}
