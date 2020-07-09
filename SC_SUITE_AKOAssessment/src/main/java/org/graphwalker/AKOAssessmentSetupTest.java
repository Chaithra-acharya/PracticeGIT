package org.graphwalker;

import Controllers.AssessmentSetupController;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import DataReader.CSVDataReaderAKOAssessment;
import Helpers.JavascriptHelper;
import PageObjectModels.AKOAssessmentSetupPage;
import PageObjectModels.AKOAssessmentStandardsPage;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

@GraphWalker(value = "quick_random(edge_coverage(100))")
public class AKOAssessmentSetupTest extends ExecutionContext implements org.graphwalker.AKOAssessmentSetup{
    AKOAssessmentStandardsPage akoAssessmentStandardsPage = new AKOAssessmentStandardsPage();
    AKOAssessmentSetupPage akoAssessmentSetupPage = new AKOAssessmentSetupPage();
    CSVDataReaderAKOAssessment csvDataReaderAKOAssessment = new CSVDataReaderAKOAssessment();
    AssessmentSetupController assessmentSetupController = new AssessmentSetupController();

    public void v_ValidateAssessmentSetup(){
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

    public void e_SelectSetupProperties(){
        String path = System.getProperty("user.dir");

        String teacherRubricPDFPath = path + "\\..\\dist\\Resources\\Uploads\\TeacherPDF.pdf";
        String studentRubricPDFPath = path + "\\..\\dist\\Resources\\Uploads\\StudentPDF.pdf";

        assessmentSetupController.selectSetupProperties(csvDataReaderAKOAssessment.getAdministrationWindow(), csvDataReaderAKOAssessment.getScanning(),
                csvDataReaderAKOAssessment.getOnlineAnswerSheet(), csvDataReaderAKOAssessment.getIntendedUser());

        assessmentSetupController.addRubrics(csvDataReaderAKOAssessment.getAddRubrics(), csvDataReaderAKOAssessment.getTeacherRubricType(), csvDataReaderAKOAssessment.getStudentRubricType(),
                csvDataReaderAKOAssessment.getTeacherRubricName(), csvDataReaderAKOAssessment.getTeacherRubric(), csvDataReaderAKOAssessment.getStudentRubricName(), csvDataReaderAKOAssessment.getStudentRubric(),
                csvDataReaderAKOAssessment.getAvailableTeacherRubricName(), csvDataReaderAKOAssessment.getAvailableStudentRubricName(), teacherRubricPDFPath, studentRubricPDFPath);

        assessmentSetupController.addOnlineSettings(csvDataReaderAKOAssessment.getOnlineSettings(), csvDataReaderAKOAssessment.getDurationToggle(),
                csvDataReaderAKOAssessment.getDurationHours(), csvDataReaderAKOAssessment.getDurationMins(), csvDataReaderAKOAssessment.getDefaultTimeIncrement(),
                csvDataReaderAKOAssessment.getStartTime(),csvDataReaderAKOAssessment.getEndTime(), csvDataReaderAKOAssessment.getDaysToSelect());

        /*Select All checkbox with Lock & Unlock*/
        assessmentSetupController.propertiesSettings(akoAssessmentSetupPage.getSelectAllCheckBoxId(), csvDataReaderAKOAssessment.getPropSelectAllCheckBox(),
                akoAssessmentSetupPage.getSelectAllLockId(), csvDataReaderAKOAssessment.getPropSelectAllLock(),
                akoAssessmentSetupPage.getSelectAllUnlockId(), csvDataReaderAKOAssessment.getPropSelectAllUnLock());

        /*Select 4 Digit PIN Verification with Lock & Unlock*/
        assessmentSetupController.propertiesSettings(akoAssessmentSetupPage.getDigitVerfyCheckBoxId(), csvDataReaderAKOAssessment.getPinVerificationCheckBox(),
                akoAssessmentSetupPage.getDigitVerfyLockId(), csvDataReaderAKOAssessment.getPinVerificationLock(),
                akoAssessmentSetupPage.getDigitVerfyUnlockId(), csvDataReaderAKOAssessment.getPinVerificationUnLock());

        /*Select Auto Activation with Lock & Unlock*/
        assessmentSetupController.propertiesSettings(akoAssessmentSetupPage.getAutoActivationCheckBoxId(), csvDataReaderAKOAssessment.getAutoActivationCheckBox(),
                akoAssessmentSetupPage.getAutoActivationLockId(), csvDataReaderAKOAssessment.getAutoActivationLock(),
                akoAssessmentSetupPage.getAutoActivationUnlockId(), csvDataReaderAKOAssessment.getAutoActivationUnLock());

        /*Select Auto Reactivation with Lock & Unlock*/
        assessmentSetupController.propertiesSettings(akoAssessmentSetupPage.getReActivationCheckBoxId(), csvDataReaderAKOAssessment.getReActivationCheckBox(),
                akoAssessmentSetupPage.getReActivationLockId(), csvDataReaderAKOAssessment.getReActivationLock(),
                akoAssessmentSetupPage.getReActivationUnlockId(), csvDataReaderAKOAssessment.getReActivationUnLock());

        /*Select Display Item Details in Student Portal with Lock & Unlock*/
        assessmentSetupController.propertiesSettings(akoAssessmentSetupPage.getDisplayItemsStudentCheckBoxId(), csvDataReaderAKOAssessment.getDisplayItemSPCheckBox(),
                akoAssessmentSetupPage.getDisplayItemsStudentLockId(), csvDataReaderAKOAssessment.getDisplayItemSPLock(),
                akoAssessmentSetupPage.getDisplayItemsStudentUnlockId(), csvDataReaderAKOAssessment.getDisplayItemSPUnLock());

        /*Select Display Correct Answers in Student Portal*/
        AssessmentSetupController.compareAndCheckElementById(akoAssessmentSetupPage.getDispalyCorrectAnsCheckBoxId(), csvDataReaderAKOAssessment.getDisplayCorrAnsSPCheckBox());

        /*Select Show Rationale for Incorrect Items*/
        AssessmentSetupController.compareAndCheckElementById(akoAssessmentSetupPage.getDisplayRationaleCheckBoxId(), csvDataReaderAKOAssessment.getShowRationaleIncorrectCheckBox());

        /*Select Show Standards*/
        AssessmentSetupController.compareAndCheckElementById(akoAssessmentSetupPage.getDisplayStandards(), csvDataReaderAKOAssessment.getShowStandards());

        /*Select Group Items by Standard*/
        AssessmentSetupController.compareAndCheckElementById(akoAssessmentSetupPage.getDisplayGroupItemStandard(), csvDataReaderAKOAssessment.getGroupItemsByStandards());

        /*Select Display Timer with Lock & Unlock*/
        assessmentSetupController.propertiesSettings(akoAssessmentSetupPage.getDisplayTimerCheckBoxId(), csvDataReaderAKOAssessment.getDisplayTimerCheckBox(),
                akoAssessmentSetupPage.getDisplayTimerLockId(), csvDataReaderAKOAssessment.getDisplayTimerLock(),
                akoAssessmentSetupPage.getDisplayTimerUnlockId(), csvDataReaderAKOAssessment.getDisplaytimerUnLock());

        /*Select Thermometer with Lock & Unlock*/
        assessmentSetupController.propertiesSettings(akoAssessmentSetupPage.getThermometerCheckBoxId(), csvDataReaderAKOAssessment.getThermometerCheckBox(),
                akoAssessmentSetupPage.getThermometerLockId(), csvDataReaderAKOAssessment.getThermometerLock(),
                akoAssessmentSetupPage.getThermometerUnlockId(), csvDataReaderAKOAssessment.getThermometerUnLock());

        /*Select Advanced Calculator with Lock & Unlock*/
        JavascriptHelper.scrollIntoViewById(akoAssessmentSetupPage.getAdvanceCalCheckBoxId());
        assessmentSetupController.propertiesSettings(akoAssessmentSetupPage.getAdvanceCalCheckBoxId(), csvDataReaderAKOAssessment.getAdvCalcCheckBox(),
                akoAssessmentSetupPage.getAdvanceCalLockId(), csvDataReaderAKOAssessment.getAdvCalcLock(),
                akoAssessmentSetupPage.getAdvanceCalUnlockId(), csvDataReaderAKOAssessment.getAdvCalcUnLock());

        /*Select Basic Calculator with Lock & Unlock*/
        assessmentSetupController.propertiesSettings(akoAssessmentSetupPage.getBasicCalCheckBoxId(), csvDataReaderAKOAssessment.getBasicCalcCheckBox(),
                akoAssessmentSetupPage.getBasicCalLockId(), csvDataReaderAKOAssessment.getBasicCalcLock(),
                akoAssessmentSetupPage.getBasicCalUnlockId(), csvDataReaderAKOAssessment.getBasicCalcUnLock());

        /*Select Scientific Calculator with Lock & Unlock*/
        assessmentSetupController.propertiesSettings(akoAssessmentSetupPage.getScientificCalCheckBoxId(), csvDataReaderAKOAssessment.getScientificCalcCheckBox(),
                akoAssessmentSetupPage.getScientificCalLockId(), csvDataReaderAKOAssessment.getScientificCalcLock(),
                akoAssessmentSetupPage.getScientificCalUnlockId(), csvDataReaderAKOAssessment.getScientificCalcUnLock());

        /*Select Advanced Equation Editor*/
        AssessmentSetupController.compareAndCheckElementById(akoAssessmentSetupPage.getAdvEquEditorCheckBoxId(), csvDataReaderAKOAssessment.getAdvEquEditorCheckBox());

        /*Select Algebra Editor*/
        AssessmentSetupController.compareAndCheckElementById(akoAssessmentSetupPage.getAlgebraEditorCheckBoxId(), csvDataReaderAKOAssessment.getAlgebraEditorLock());

        /*Select Algebra with Trigonometry*/
        AssessmentSetupController.compareAndCheckElementById(akoAssessmentSetupPage.getTrignometryEditorCheckBoxId(), csvDataReaderAKOAssessment.getTrignometryEditorCheckBox());

        /*Select Elementary Editor*/
        AssessmentSetupController.compareAndCheckElementById(akoAssessmentSetupPage.getElementryEditorCheckBoxId(), csvDataReaderAKOAssessment.getElementaryEditorCheckBox());

        /*Select Audio with Lock & Unlock*/
        JavascriptHelper.scrollIntoViewById(akoAssessmentSetupPage.getAudioCheckBoxId());
        assessmentSetupController.propertiesSettings(akoAssessmentSetupPage.getAudioCheckBoxId(), csvDataReaderAKOAssessment.getAudioCheckBox(),
                akoAssessmentSetupPage.getAudioLockId(), csvDataReaderAKOAssessment.getAudioLock(),
                akoAssessmentSetupPage.getAudioUnlockId(), csvDataReaderAKOAssessment.getAudioUnLock());

        /*Select Image with Lock & Unlock*/
        assessmentSetupController.propertiesSettings(akoAssessmentSetupPage.getImageCheckBoxId(), csvDataReaderAKOAssessment.getImageCheckBox(),
                akoAssessmentSetupPage.getImageLockId(), csvDataReaderAKOAssessment.getImageLock(),
                akoAssessmentSetupPage.getImageUnlockId(), csvDataReaderAKOAssessment.getImageUnLock());

        /*Select Video with Lock & Unlock*/
        assessmentSetupController.propertiesSettings(akoAssessmentSetupPage.getVideoCheckBoxId(), csvDataReaderAKOAssessment.getVideoCheckBox(),
                akoAssessmentSetupPage.getVideoLockId(), csvDataReaderAKOAssessment.getVideoLock(),
                akoAssessmentSetupPage.getVideoUnlockId(), csvDataReaderAKOAssessment.getVideoUnLock());

        /*Select Answer Eliminator with Lock & Unlock*/
        assessmentSetupController.propertiesSettings(akoAssessmentSetupPage.getAnsEliminatorCheckBoxId(), csvDataReaderAKOAssessment.getAnsEliminatorCheckBox(),
                akoAssessmentSetupPage.getAnsEliminatorLockId(), csvDataReaderAKOAssessment.getAnsEliminatorLock(),
                akoAssessmentSetupPage.getAnsEliminatorUnlockId(), csvDataReaderAKOAssessment.getAnsEliminatorUnLock());

        /*Select Graph with Lock & Unlock*/
        assessmentSetupController.propertiesSettings(akoAssessmentSetupPage.getGraphCheckBoxId(), csvDataReaderAKOAssessment.getGraphCheckBox(),
                akoAssessmentSetupPage.getGraphLockId(), csvDataReaderAKOAssessment.getGraphLock(),
                akoAssessmentSetupPage.getGraphUnlockId(), csvDataReaderAKOAssessment.getGraphUnLock());

        /*Select Line Reader with Lock & Unlock*/
        assessmentSetupController.propertiesSettings(akoAssessmentSetupPage.getLineReaderCheckBoxId(), csvDataReaderAKOAssessment.getLineReaderCheckBox(),
                akoAssessmentSetupPage.getLineReaderLockId(), csvDataReaderAKOAssessment.getLineReaderLock(),
                akoAssessmentSetupPage.getLineReaderUnlockId(), csvDataReaderAKOAssessment.getLineReaderUnLock());

        /*Select Notes with Lock & Unlock*/
        assessmentSetupController.propertiesSettings(akoAssessmentSetupPage.getNotesCheckBoxId(), csvDataReaderAKOAssessment.getNotesCheckBox(),
                akoAssessmentSetupPage.getNotesLockId(), csvDataReaderAKOAssessment.getNotesLock(),
                akoAssessmentSetupPage.getNotesUnlockId(), csvDataReaderAKOAssessment.getNotesUnLock());

        /*Select Periodic Table with Lock & Unlock*/
        assessmentSetupController.propertiesSettings(akoAssessmentSetupPage.getPeriodicTableCheckBoxId(), csvDataReaderAKOAssessment.getPeriodicTableCheckBox(),
                akoAssessmentSetupPage.getPeriodicTableLockId(), csvDataReaderAKOAssessment.getPeriodicTableLock(),
                akoAssessmentSetupPage.getPeriodicTableUnlockId(), csvDataReaderAKOAssessment.getPeriodicTableUnLock());

        /*Select Protractor with Lock & Unlock*/
        assessmentSetupController.propertiesSettings(akoAssessmentSetupPage.getProtractorCheckBoxId(), csvDataReaderAKOAssessment.getProtractorCheckBox(),
                akoAssessmentSetupPage.getProtractorLockId(), csvDataReaderAKOAssessment.getProtractorLock(),
                akoAssessmentSetupPage.getProtractorUnlockId(), csvDataReaderAKOAssessment.getProtractorUnLock());

        /*Select Ruler with Lock & Unlock*/
        assessmentSetupController.propertiesSettings(akoAssessmentSetupPage.getRulerCheckBoxId(), csvDataReaderAKOAssessment.getRulerCheckBox(),
                akoAssessmentSetupPage.getRulerLockId(), csvDataReaderAKOAssessment.getRulerLock(),
                akoAssessmentSetupPage.getRulerUnlockId(), csvDataReaderAKOAssessment.getRulerUnLock());

        /*Select Spell Check with Lock & Unlock*/
        assessmentSetupController.propertiesSettings(akoAssessmentSetupPage.getSpellCheckCheckBoxId(), csvDataReaderAKOAssessment.getRulerCheckBox(),
                akoAssessmentSetupPage.getSpellCheckLockId(), csvDataReaderAKOAssessment.getSpellCheckLock(),
                akoAssessmentSetupPage.getSpellCheckUnlockId(), csvDataReaderAKOAssessment.getSpellCheckUnLock());

        /*Select Text Magnifier with Lock & Unlock*/
        assessmentSetupController.propertiesSettings(akoAssessmentSetupPage.getTextMagnifierCheckBoxId(), csvDataReaderAKOAssessment.getTextMagnifierCheckBox(),
                akoAssessmentSetupPage.getTextMagnifierLockId(), csvDataReaderAKOAssessment.getTextMagnifierLock(),
                akoAssessmentSetupPage.getTextMagnifierUnlockId(), csvDataReaderAKOAssessment.getTextMagnifierUnLock());

        if(csvDataReaderAKOAssessment.getScanning().equalsIgnoreCase("Yes")) {
            /*Select Answer Sheet Template*/
            assessmentSetupController.selectAnswerSheetTemplate(csvDataReaderAKOAssessment.getAnswerSheetTemplate());

            /*Select Bubble Size*/
            assessmentSetupController.selectBubbleSize(csvDataReaderAKOAssessment.getBubbleSize());

            JavascriptHelper.scrollIntoViewById(akoAssessmentSetupPage.getBubbleSizeDiv());
        }

        if(csvDataReaderAKOAssessment.getScanning().equalsIgnoreCase("No")) {
            System.out.println("Scrolling till Scoring End Date");
            String ID = BrowserInitHelper.getInstance().findElement(By.xpath(akoAssessmentSetupPage.getScoringEndDate())).getAttribute("id");
            JavascriptHelper.scrollIntoViewById(ID);
        }

        /*Enter Answer Sheet Start Date & Scoring End Date*/
        assessmentSetupController.selectAnswerSheetPrintAndScoringEndDate(csvDataReaderAKOAssessment.getScanning(), akoAssessmentSetupPage.getAnswerSheetPrintingStartDate(), csvDataReaderAKOAssessment.getAnswerSheetPrintingStartDate(),
                akoAssessmentSetupPage.getScoringEndDate(), csvDataReaderAKOAssessment.getScoringEndDate());

        /*Click Save button*/
        DriverHelper.clickXpath(akoAssessmentSetupPage.getSetupSave());

        /*Wait till the display of Alert message*/
        BrowserInitHelper.getMaxWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(akoAssessmentStandardsPage.getAlertOKButton())));
    }

    public void v_VerifySetupPage(){
        if(BrowserInitHelper.getInstance().findElement(By.xpath(akoAssessmentStandardsPage.getAlertMessage())).getText().equalsIgnoreCase("Assessment saved successfully.")){
            DriverHelper.clickXpath(akoAssessmentStandardsPage.getAlertOKButton());
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
    }

    public void e_PublishAssessment(){
        assessmentSetupController.publishAssessment();
    }

    public void v_VerifyPublishedAssessment(){

    }
}
