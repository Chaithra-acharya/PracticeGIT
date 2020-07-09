package Controllers;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import PageObjectModels.AKOAssessmentSetupPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.util.ArrayList;
import java.util.List;

public class AssessmentSetupController {
    AKOAssessmentSetupPage akoAssessmentSetupPage = new AKOAssessmentSetupPage();

    public void selectSetupProperties(String administrationWindowDateRange, String scanning, String onlineAnswerSheet, String intendedUser){
        try {
            /*Send Administration Window date range*/
            DriverHelper.sendKeysXpath(akoAssessmentSetupPage.getAdministrationWindowTextbox(), administrationWindowDateRange);

            /*Click Apply button*/
            DriverHelper.clickXpath(akoAssessmentSetupPage.getAdminWindowApplyButton());

            /*Select the Method of Delivery - Scanning*/
            if (scanning.equalsIgnoreCase("Yes")) {
                if (JavascriptHelper.getCheckboxStatus("scanning").equalsIgnoreCase("false")) {
                    DriverHelper.clickXpath(akoAssessmentSetupPage.getMethodOfDeliveryScanning());
                }
            }
            if (scanning.equalsIgnoreCase("No")) {
                if (JavascriptHelper.getCheckboxStatus("scanning").equalsIgnoreCase("true")) {
                    DriverHelper.clickXpath(akoAssessmentSetupPage.getMethodOfDeliveryScanning());
                }
            }

            /*Select the Method of Delivery - Online Answer Sheet*/
            if (onlineAnswerSheet.equalsIgnoreCase("Yes")) {
                if (JavascriptHelper.getCheckboxStatus("bubble-sheet-on").equalsIgnoreCase("false")) {
                    DriverHelper.clickXpath(akoAssessmentSetupPage.getMethodOfDeliveryOnlineAnswerSheet());
                }
            }
            if (onlineAnswerSheet.equalsIgnoreCase("No")) {
                if (JavascriptHelper.getCheckboxStatus("bubble-sheet-on").equalsIgnoreCase("true")) {
                    DriverHelper.clickXpath(akoAssessmentSetupPage.getMethodOfDeliveryOnlineAnswerSheet());
                }
            }

            /*Select the Intended User - Teacher*/
            if (intendedUser.equalsIgnoreCase("Teacher")) {
                DriverHelper.clickXpath(akoAssessmentSetupPage.getIntendedUserTeacher());
            }
            /*Select the Intended User - Student*/
            else if (intendedUser.equalsIgnoreCase("Student")) {
                DriverHelper.clickXpath(akoAssessmentSetupPage.getIntendedUserStudent());

                /*Wait until loading icon disappear*/
                DriverHelper.waitUntilLoaderInvisible();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void selectAnswerSheetTemplate(String templateName){
        try {
            if (templateName.equalsIgnoreCase("Individual Student")) {
                if (JavascriptHelper.getCheckboxStatus("ipIStudent").equalsIgnoreCase("false")) {
                    DriverHelper.clickXpath(akoAssessmentSetupPage.getAnswerSheetTemplateIndividualStudent());
                }
            } else if (templateName.equalsIgnoreCase("Class Roster")) {
                if (JavascriptHelper.getCheckboxStatus("ipRoster").equalsIgnoreCase("false")) {
                    DriverHelper.clickXpath(akoAssessmentSetupPage.getAnswerSheetTemplateClassRoster());
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void selectBubbleSize(String bubbleSize){
        try {
            if (bubbleSize.equalsIgnoreCase("Normal")) {
                if (JavascriptHelper.getCheckboxStatus("NBubbleSize").equalsIgnoreCase("false")) {
                    DriverHelper.clickXpath(akoAssessmentSetupPage.getAnswerSheetTemplateIndividualStudent());
                }
            } else if (bubbleSize.equalsIgnoreCase("Large")) {
                if (JavascriptHelper.getCheckboxStatus("BBubbleSize").equalsIgnoreCase("false")) {
                    DriverHelper.clickXpath(akoAssessmentSetupPage.getAnswerSheetTemplateClassRoster());
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void selectAnswerSheetPrintAndScoringEndDate(String isScanningSelected, String answerSheetPrintDateTextbox, String answerSheetPrintDate,
                                                        String scoringEndDateTextbox, String scoringEndDate){
        if(isScanningSelected.equalsIgnoreCase("Yes")) {
            /*Enter Answer Sheet Print Start Date*/
            DriverHelper.sendKeysXpath(answerSheetPrintDateTextbox, answerSheetPrintDate);
        }

        /*Enter Scoring End Date*/
        DriverHelper.sendKeysXpath(scoringEndDateTextbox, scoringEndDate);
    }

    public void addRubrics(String addRubrics, String teacherRubricType, String studentRubricType, String teacherRubricName, String teacherRubric,
                           String studentRubricName, String studentRubric, String availableTeacherRubricName, String availableStudentRubricName,
                           String teacherRubricPDFPath, String studentRubricPDFPath){
        if(addRubrics.equalsIgnoreCase("Yes")){
            /*Set Add Rubric toggle button to Yes mode*/
            JavascriptHelper.clickID_JS(akoAssessmentSetupPage.getAddRubricsToggleButton());

            /*Wait until the display of Rubric expand icon*/
            //BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(akoAssessmentSetupPage.getExpandRubricIcon())));

            /*Click rubric expand icon*/
            //DriverHelper.clickXpath(akoAssessmentSetupPage.getExpandRubricIcon());
            JavascriptHelper.click_Xpath(akoAssessmentSetupPage.getExpandRubricIcon());

            if(teacherRubricType.equalsIgnoreCase("Create")){
                DriverHelper.createTeacherRubric(akoAssessmentSetupPage.getCreateTeacherRubricButton(), akoAssessmentSetupPage.getTeacherRubricNameTextbox(),
                        teacherRubricName, akoAssessmentSetupPage.getTeacherRubricCKEditor(), teacherRubric, akoAssessmentSetupPage.getTeacherRubricSaveButton(),
                        akoAssessmentSetupPage.getRubricSavedAlert(), akoAssessmentSetupPage.getTeacherRubricCancelButton());
            }
            else if(teacherRubricType.equalsIgnoreCase("Upload")){
                /*Click Upload Button*/
                DriverHelper.uploadRubric(akoAssessmentSetupPage.getUploadTeacherRubricButton(), akoAssessmentSetupPage.getUploadTeacherRubricNameTextbox(),
                        akoAssessmentSetupPage.getUploadTeacherRubricDropzone(), teacherRubricName, teacherRubricPDFPath, akoAssessmentSetupPage.getUploadTeacherRubricSuccessIcon(),
                        akoAssessmentSetupPage.getUploadTeacherRubricSaveButton(), akoAssessmentSetupPage.getRubricSavedAlert());
            }
            else if(teacherRubricType.equalsIgnoreCase("Select from Available Rubrics")){
                /*Click Select from Available Rubrics Button*/
                DriverHelper.selectAvailableRubric(akoAssessmentSetupPage.getAvailableTeacherRubricButton(), akoAssessmentSetupPage.getAvailableRubricsTextbox(),
                        availableTeacherRubricName, akoAssessmentSetupPage.getAvailableRubricsSearchIcon(), akoAssessmentSetupPage.getSelectRubricsButton(),
                        akoAssessmentSetupPage.getAvailableRubricsExitFullScreen(), akoAssessmentSetupPage.getTeacherRubricSaveButton(), akoAssessmentSetupPage.getRubricSavedAlert());
            }

            if(studentRubricType.equalsIgnoreCase("Create")){
                DriverHelper.createStudentRubric(akoAssessmentSetupPage.getExpandRubricIcon(), akoAssessmentSetupPage.getCreateStudentRubricButton(), akoAssessmentSetupPage.getStudentRubricNameTextbox(),
                        studentRubricName, akoAssessmentSetupPage.getStudentRubricCKEditor(), studentRubric, akoAssessmentSetupPage.getStudentRubricSaveButton(),
                        akoAssessmentSetupPage.getRubricSavedAlert(), akoAssessmentSetupPage.getStudentRubricCancelButton());
            }
            else if(studentRubricType.equalsIgnoreCase("Upload")){
                JavascriptHelper.scrollIntoView(akoAssessmentSetupPage.getExpandRubricIcon());

                /*Click Upload Button*/
                DriverHelper.uploadRubric(akoAssessmentSetupPage.getUploadStudentRubricButton(), akoAssessmentSetupPage.getUploadStudentRubricNameTextbox(),
                        akoAssessmentSetupPage.getUploadStudentRubricDropzone(), studentRubricName, studentRubricPDFPath, akoAssessmentSetupPage.getUploadStudentRubricSuccessIcon(),
                        akoAssessmentSetupPage.getUploadStudentRubricSaveButton(), akoAssessmentSetupPage.getRubricSavedAlert());
            }
            else if(studentRubricType.equalsIgnoreCase("Select from Available Rubrics")){
                /*Click Select from Available Rubrics Button*/
                DriverHelper.selectAvailableRubric(akoAssessmentSetupPage.getAvailableStudentRubricButton(), akoAssessmentSetupPage.getAvailableRubricsTextbox(),
                        availableStudentRubricName, akoAssessmentSetupPage.getAvailableRubricsSearchIcon(), akoAssessmentSetupPage.getSelectRubricsButton(),
                        akoAssessmentSetupPage.getAvailableRubricsExitFullScreen(), akoAssessmentSetupPage.getTeacherRubricSaveButton(), akoAssessmentSetupPage.getRubricSavedAlert());
            }
        }
    }

    public void addOnlineSettings(String onlineSettings, String durationToggle, String durationHours, String durationMins, String defaultTimeIncrement, String startTime,
                                  String endTime, String daysToSelect){
        JavascriptHelper.scrollIntoViewById("divOSettToggle");
        if(onlineSettings.equalsIgnoreCase("Yes")){
            /*Set Online Settings toggle button to Yes mode*/
            JavascriptHelper.clickID_JS(akoAssessmentSetupPage.getOnlineSettings());

            /*Wait till loading icon disappear*/
            DriverHelper.waitUntilLoaderInvisible();

            /*Enter the Duration hours*/
            DriverHelper.sendKeysXpath(akoAssessmentSetupPage.getDurationHoursTextbox(), durationHours);

            /*Enter the Duration mins*/
            DriverHelper.sendKeysXpath(akoAssessmentSetupPage.getDurationMinsTextbox(), durationMins);

            /*Enter Default time increment*/
            DriverHelper.sendKeysXpath(akoAssessmentSetupPage.getTimeIncrementTextbox(), defaultTimeIncrement);

            /*Enter Start time*/
            DriverHelper.sendKeysXpath(akoAssessmentSetupPage.getTimeWindowStartTimeTextbox(), startTime);

            /*Enter End time*/
            DriverHelper.sendKeysXpath(akoAssessmentSetupPage.getTimeWindowEndTimeTextbox(), endTime);

            List<String> days = new ArrayList<String>();
            days.add("Monday");
            days.add("Tuesday");
            days.add("Wednesday");
            days.add("Thursday");
            days.add("Friday");
            days.add("Saturday");
            days.add("Sunday");

            /*Select Days window*/
            String[] daysWindow = daysToSelect.split(",");

            List<String> daysCheckboxID = new ArrayList<String>();
            daysCheckboxID.add(akoAssessmentSetupPage.getDaysMonday());
            daysCheckboxID.add(akoAssessmentSetupPage.getDaysTuesday());
            daysCheckboxID.add(akoAssessmentSetupPage.getDaysWednesday());
            daysCheckboxID.add(akoAssessmentSetupPage.getDaysThursday());
            daysCheckboxID.add(akoAssessmentSetupPage.getDaysFriday());
            daysCheckboxID.add(akoAssessmentSetupPage.getDaysSaturday());
            daysCheckboxID.add(akoAssessmentSetupPage.getDaysSunday());

            for(int i=0; i<daysWindow.length; i++){
                //System.out.println("Days in CSV: "+daysWindow[i]);
                //System.out.println("Days in UI: "+days.get(i));
                if(daysWindow[i].equalsIgnoreCase(days.get(i))){
                    if(JavascriptHelper.getCheckboxStatus(daysCheckboxID.get(i)).equalsIgnoreCase("false")){
                        //System.out.println("Selecting "+daysCheckboxID.get(i));
                        JavascriptHelper.clickID_JS(daysCheckboxID.get(i));
                    }
                }
            }
        }
    }

    public boolean propertiesSettings(String chkBox, String chkBoxStatus, String lock, String lockStatus, String unLock, String unLockStatus) {
        boolean res = false;
        String eleId = null;
        String eleStatus = null;
        try {
            for (int i = 1; i <= 3; i++) {
                if (i == 1) {
                    eleId = chkBox;
                    eleStatus = chkBoxStatus;
                } else if (i == 2) {
                    eleId = lock;
                    eleStatus = lockStatus;
                }else if (i == 3) {
                    eleId = unLock;
                    eleStatus = unLockStatus;
                }
                //System.out.println("eleId: "+eleId +"::"+ "eleStatus:: "+eleStatus);
                compareAndCheckElementById(eleId,eleStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception handled for propertiesSettings. ");
        }
        return res;
    }

    public static boolean compareAndCheckElementById(String eleId, String reqStatus) {
        boolean res = false;
        try {
            String elementStatus = JavascriptHelper.getToggleButtonState(eleId);
            if (elementStatus.equalsIgnoreCase(reqStatus)) {
                //System.out.println("For the element -- " + eleId + " -- default status -- " + reqStatus + " -- & Required status  -- " + reqStatus + " -- both are matching");
                res = true;
            } else {
                JavascriptHelper.ClickByID_Javascript(eleId);
                //System.out.println("Required to change the -- " + eleId + " -- element from default status -- " + reqStatus + " -- to Required status  -- " + reqStatus + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception handled for verifyAndCheckElementById for the id :- " + eleId);
        }
        return res;
    }

    public static boolean verifyAndCheckElementById(String eleId, boolean reqStatus) {
        boolean res = false;
        try {
            String elementStatus = JavascriptHelper.getToggleButtonState(eleId);

            String defaultStatus = String.valueOf(reqStatus);
            if (elementStatus.equalsIgnoreCase(defaultStatus)) {
                //System.out.println("For the element -- " + eleId + " -- default status -- " + defaultStatus + " -- & Required status  -- " + reqStatus + " -- both are matching");
                res = true;
            } else {
                JavascriptHelper.ClickByID_Javascript(eleId);
                //System.out.println("Required to change the -- " + eleId + " -- element from default status -- " + defaultStatus + " -- to Required status  -- " + reqStatus + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception handled for verifyAndCheckElementById for the id :- " + eleId);
        }
        return res;
    }

    public void publishAssessment(){
        /*Click Publish button*/
        DriverHelper.clickXpath(akoAssessmentSetupPage.getSetupPublish());

        /*Wait till the display of No Thank you button*/
        BrowserInitHelper.getMaxWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(akoAssessmentSetupPage.getSetupNoThankyou())));

        /*Click No Thank you button*/
        DriverHelper.clickXpath(akoAssessmentSetupPage.getSetupNoThankyou());
    }
}
