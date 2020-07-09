package Controllers;

import DataReader.CSVDataReaderAKOAssessment;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import PageObjectModels.AKOAssessmentInfoPage;
import javafx.beans.property.adapter.JavaBeanBooleanProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AssessmentInfoController {
    AKOAssessmentInfoPage akoAssessmentInfoPage = new AKOAssessmentInfoPage();
    CSVDataReaderAKOAssessment csvDataReaderAKOAssessment = new CSVDataReaderAKOAssessment();

    public void enterAssessmentDetails(String assessmentName, String subject, String collection, String plc,
                                       String isMultiGrade, String grade, String studentSelection, String courseGroup, String course,
                                       String studentGroup) {
        csvDataReaderAKOAssessment.getCsv();

        /*Wait until Assessment Name textbox is clickable*/
        BrowserInitHelper.getMaxWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(akoAssessmentInfoPage.getAssessmentNameTextbox())));

        /*Enter the Assessment name*/
        DriverHelper.sendKeysXpath(akoAssessmentInfoPage.getAssessmentNameTextbox(), assessmentName);

        /*Click Subject drop down*/
        DriverHelper.clickXpath(akoAssessmentInfoPage.getSubjectDropDown());

        /*Select the Subject*/
        JavascriptHelper.click_Xpath("//button[@data-id='subjects']/following::div//a[.='" + subject + "']/span");
        /*Click Collection drop down*/
        //DriverHelper.clickXpath(akoAssessmentInfoPage.getCollectionDropDown());

        /*Select the Collection*/
        //BrowserInitHelper.getInstance().findElement(By.xpath("//ul[@id='selAddToAssessCollection']//span[contains(text(),'"+collection+"')]")).click();

        /*Click PLC drop down*/
        //DriverHelper.clickXpath(akoAssessmentInfoPage.getPlcDropDown());

        /*Select the PLC option*/
        //BrowserInitHelper.getInstance().findElement(By.xpath("//ul[@id='subjects']//span[contains(text(),'"+plc+"')]")).click();

        if (isMultiGrade.equalsIgnoreCase("Yes")) {
            /*Set Setup for Multiple Grades togglebutton to Yes mode*/
            JavascriptHelper.clickID_JS(akoAssessmentInfoPage.getSetupMultipleGrades());

            /*Click OK in the alert message*/
            DriverHelper.clickXpath(akoAssessmentInfoPage.getAlertOKButton());

            /*Click OK to proceed in the alert message*/
            DriverHelper.clickXpath(akoAssessmentInfoPage.getAlertOKButton());

            /*Select the Grade*/
            BrowserInitHelper.getInstance().findElement(By.xpath("//div[@id='divGradeLst']//span[contains(text(),'" + grade + "')]")).click();

            System.out.println("getScheduleStudentsMultiGrade: " + csvDataReaderAKOAssessment.getScheduleStudentsMultiGrade());
            if (csvDataReaderAKOAssessment.getScheduleStudentsMultiGrade().equalsIgnoreCase("All students may take this test")) {
                /*Click All students may take this test radio button*/
                BrowserInitHelper.getInstance().findElement(By.xpath("//b[contains(text(), 'Grade " + grade + "')]/parent::label/following-sibling::div//span[contains(text(),'All students may take this test')]")).click();
            } else if (csvDataReaderAKOAssessment.getScheduleStudentsMultiGrade().equalsIgnoreCase("Assign students by grade level")) {
                JavascriptHelper.scrollIntoView("//b[contains(text(), 'Grade " + grade + "')]/parent::label/following-sibling::div//span[contains(text(),'Assign students by Student Group')]");

                /*Click Assign students by grade level radio button*/
                BrowserInitHelper.getInstance().findElement(By.xpath("//b[contains(text(), 'Grade " + grade + "')]/parent::label/following-sibling::div//span[contains(text(),'Assign students by grade level')]")).click();

                /*Select the Grade checkbox*/
                BrowserInitHelper.getInstance().findElement(By.xpath("//div[contains(@id, 'divScheduleGradeID')]//span[contains(text(),'" + csvDataReaderAKOAssessment.getScheduleGradeMultiGrade() + "')]")).click();
            } else if (csvDataReaderAKOAssessment.getScheduleStudentsMultiGrade().equalsIgnoreCase("Assign students by Course Group or Course")) {
                /*Click Assign students by Course Group or Course radio button*/
                BrowserInitHelper.getInstance().findElement(By.xpath("//b[contains(text(), 'Grade " + grade + "')]/parent::label/following-sibling::div//span[contains(text(),'Assign students by Course Group or Course')]")).click();
            } else if (csvDataReaderAKOAssessment.getScheduleStudentsMultiGrade().equalsIgnoreCase("Assign students by Student Group")) {
                /*Click Assign students by Student Group radio button*/
                BrowserInitHelper.getInstance().findElement(By.xpath("//b[contains(text(), 'Grade " + grade + "')]/parent::label/following-sibling::div//span[contains(text(),'Assign students by Student Group')]")).click();
            }
        }

        if(csvDataReaderAKOAssessment.getScheduleStudents().equalsIgnoreCase("students by grade level")){
            scheduleByGradeLevel(grade);
        }
        else if(csvDataReaderAKOAssessment.getScheduleStudents().equalsIgnoreCase("students by Course Group or Course")){
            scheduleByCourseGroup(courseGroup, course);
        }
        else if(csvDataReaderAKOAssessment.getScheduleStudents().equalsIgnoreCase("students by Student Group")){
            scheduleByStudentGroup(studentGroup);
        }

        /*Save the Assessment Info page*/
        DriverHelper.clickXpath(akoAssessmentInfoPage.getSaveButton());
    }

    public void scheduleByGradeLevel(String grade){
        /*Click Schedule students by grade level radio button*/
        DriverHelper.clickXpath(akoAssessmentInfoPage.getScheduleGradeLevel());

        /*Select the Grade*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//div[@id='divScheduleGradeLst']//span[contains(text(),'" + grade + "')]")).click();
    }

    public void scheduleByCourseGroup(String courseGroup, String course){
        /*Click Schedule students by Course Group/Course radio button*/
        DriverHelper.clickXpath(akoAssessmentInfoPage.getScheduleCourseGroupLevel());

        JavascriptHelper.scrollIntoView(akoAssessmentInfoPage.getSelectCourseDropDown());
        /*Click Course Group drop down*/
        //DriverHelper.clickXpath(akoAssessmentInfoPage.getSelectCourseGroupDropDown());

        /*Enter the Course Group name in textbox*/


        /*Select the Course Group*/


        /*Click Course drop down*/
        DriverHelper.clickXpath(akoAssessmentInfoPage.getSelectCourseDropDown());

        /*Enter the Course name in textbox*/
        DriverHelper.sendKeysXpath(akoAssessmentInfoPage.getTextboxCourseDropDown(), course);

        /*Select the course*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//span[contains(text(),'"+course+"')]")).click();

        /*Click District header to close Course drop down*/
        DriverHelper.clickXpath(akoAssessmentInfoPage.getDistrictHeader());
    }

    public void scheduleByStudentGroup(String studentGroup){
        /*Click Schedule students by Student Group radio button*/
        DriverHelper.clickXpath(akoAssessmentInfoPage.getScheduleStudentGroupLevel());

        JavascriptHelper.scrollIntoView(akoAssessmentInfoPage.getSelectStudentGroupDropDown());

        /*Click Student Group drop down*/
        DriverHelper.clickXpath(akoAssessmentInfoPage.getSelectStudentGroupDropDown());

        /*Enter the Student Group name in textbox*/
        DriverHelper.sendKeysXpath(akoAssessmentInfoPage.getTextboxStudentGroupDropDown(), studentGroup);

        /*Select the Student Group*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//span[contains(text(),'"+studentGroup+"')]")).click();

        /*Click District header to close Student Group drop down*/
        DriverHelper.clickXpath(akoAssessmentInfoPage.getDistrictHeader());
    }
}
