package PageObjectModels;

import Helpers.DriverHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AKOAssessmentSetupPage {
    String administrationWindowTextbox, adminWindowApplyButton, methodOfDeliveryScanning, methodOfDeliveryOnlineAnswerSheet, intendedUserStudent, intendedUserTeacher;
    String uploadStudentAssessment, addRubricsToggleButton, answerSheetTemplateIndividualStudent, answerSheetTemplateClassRoster;
    String expandRubricIcon, createTeacherRubricButton, teacherRubricNameTextbox, teacherRubricCKEditor, createStudentRubricButton, studentRubricNameTextbox, studentRubricCKEditor;
    String teacherRubricSaveButton, teacherRubricCancelButton, studentRubricSaveButton, studentRubricCancelButton, rubricSavedAlert;
    String uploadTeacherRubricButton, uploadTeacherRubricNameTextbox, uploadTeacherRubricDropzone, uploadTeacherRubricSuccessIcon, uploadTeacherRubricSaveButton;
    String uploadStudentRubricButton, uploadStudentRubricNameTextbox, uploadStudentRubricDropzone, uploadStudentRubricSuccessIcon, uploadStudentRubricSaveButton;
    String availableTeacherRubricButton, availableStudentRubricButton, availableRubricsTextbox, availableRubricsSearchIcon, selectRubricsButton, availableRubricsExitFullScreen;
    String enableBrowserLockDown, onlineSettings, durationSwitch, durationUnlock, durationHoursTextbox, durationMinsTextbox, timeIncrementTextbox, timeIncrementUnlock;
    String timeWindowStartTimeTextbox, timeWindowEndTimeTextbox, timeWindowLock, timeWindowUnLock, daysMonday, daysTuesday, daysWednesday, daysThursday, daysFriday, daysSaturday, daysSunday;
    String daysWindowUnLock, timeWindowLabel;
    String selectAllCheckBoxId,selectAllUnlockId,digitVerfCheckBoxId,digitVerfyUnlockId;
    String autoActivationCheckBoxId,autoActivationUnlockId,reActivationCheckBoxId,reActivationUnlockId;
    String displayItemsStudentCheckBoxId,displayItemsStudentUnlockId,dispalyCorrectAnsCheckBoxId,displayRationaleCheckBoxId, displayStandards, displayGroupItemStandard;
    String displayTimerCheckBoxId,displayTimerUnlockId,thermometerCheckBoxId,thermometerUnlockId,browserLockDownId;
    String onlineToolsLabel,advanceCalCheckBoxId,advanceCalUnlockId,basicCalCheckBoxId,basicCalUnlockId,scientificCalCheckBoxId,scientificCalUnlockId;
    String equationEditorLabel,advEquEditorCheckBoxId,advEquEditorUnlockId,algebraEditorCheckBoxId,algebraEditorUnlockId,trignometryEditorCheckBoxId;
    String trignometryEditorUnlockId,elementryEditorCheckBoxId,elementryEditorUnlockId,durationSwitchId;
    String mediaUploadLabel,audioCheckBoxId,audioUnlockId,imageCheckBoxId,imageUnlockId,videoCheckBoxId,videoUnlockId;
    String otherToolsLabel,ansEliminatorCheckBoxId,ansEliminatorUnlockId,graphCheckBoxId,graphUnlockId,lineReaderCheckBoxId,lineReaderUnlockId;
    String notesCheckBoxId,notesUnlockId,periodicTableCheckBoxId,periodicTableUnlockId,protractorCheckBoxId,protractorUnlockId;
    String rulerCheckBoxId,rulerUnlockId,spellCheckCheckBoxId,spellCheckUnlockId,textMagnifierCheckBoxId,textMagnifierUnlockId;
    String timeWindowLockId,daysWindowLockId,selectAllLockId,digitVerfyLockId,autoActivationLockId,reActivationLockId,displayItemsStudentLockId;
    String displayTimerLockId,thermometerLockId,advanceCalLockId,basicCalLockId,scientificCalLockId,advEquEditorLockId,algebraEditorLockId;
    String trignometryEditorLockId,elementryEditorLockId,audioLockId,imageLockId,videoLockId,ansEliminatorLockId,graphLockId,lineReaderLockId;
    String notesLockId,periodicTableLockId,protractorLockId,rulerLockId,spellCheckLockId,textMagnifierDivID, textMagnifierLockId;
    String bubbleSizeDiv, bubbleSizeNormal, bubbleSizeLarge, answerSheetPrintingStartDate, scoringEndDate, setupSave, setupPublish, setupNoThankyou;

    private static String os = null;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;

    public AKOAssessmentSetupPage(){
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("SC_SUITE_AKOAssessment", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + DriverHelper.getPath("\\Properties\\AKOAssessmentSetupPage.properties"));
            } else {
                input = new FileInputStream(dir + "/Properties/AKOAssessmentSetupPage.properties");
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getAdministrationWindowTextbox(){
        administrationWindowTextbox = properties.getProperty("ASSESSMENTS_ADMINISTRATION_WINDOW");
        return administrationWindowTextbox;
    }

    public String getAdminWindowApplyButton(){
        adminWindowApplyButton = properties.getProperty("ASSESSMENTS_ADMINISTRATION_WINDOW_APPLY_BUTTON");
        return adminWindowApplyButton;
    }

    public String getMethodOfDeliveryScanning(){
        methodOfDeliveryScanning = properties.getProperty("ASSESSMENTS_METHOD_OF_DELIVERY_SCANNING");
        return methodOfDeliveryScanning;
    }

    public String getMethodOfDeliveryOnlineAnswerSheet(){
        methodOfDeliveryOnlineAnswerSheet = properties.getProperty("ASSESSMENTS_METHOD_OF_DELIVERY_ONLINE_ANSWER_SHEET");
        return methodOfDeliveryOnlineAnswerSheet;
    }

    public String getIntendedUserStudent(){
        intendedUserStudent = properties.getProperty("ASSESSMENTS_INTENDED_USER_STUDENT");
        return intendedUserStudent;
    }

    public String getIntendedUserTeacher(){
        intendedUserTeacher = properties.getProperty("ASSESSMENTS_INTENDED_USER_TEACHER");
        return intendedUserTeacher;
    }

    public String getUploadStudentAssessment(){
        uploadStudentAssessment = properties.getProperty("ASSESSMENTS_UPLOAD_STUDENT_ASSESSMENT");
        return uploadStudentAssessment;
    }

    public String getAddRubricsToggleButton(){
        addRubricsToggleButton = properties.getProperty("ASSESSMENTS_ADD_RUBRICS_TOGGLE_BUTTON");
        return addRubricsToggleButton;
    }

    public String getExpandRubricIcon(){
        expandRubricIcon = properties.getProperty("ASSESSMENTS_CR_ITEM_EXPAND_RUBRIC_ICON");
        return expandRubricIcon;
    }

    public String getCreateTeacherRubricButton(){
        createTeacherRubricButton = properties.getProperty("ASSESSMENTS_CREATE_TEACHER_RUBRIC_BUTTON");
        return createTeacherRubricButton;
    }

    public String getTeacherRubricNameTextbox(){
        teacherRubricNameTextbox = properties.getProperty("ASSESSMENTS_TEACHER_RUBRIC_NAME_TEXTBOX");
        return teacherRubricNameTextbox;
    }

    public String getTeacherRubricCKEditor(){
        teacherRubricCKEditor = properties.getProperty("ASSESSMENTS_TEACHER_RUBRIC_CKEDITOR");
        return teacherRubricCKEditor;
    }

    public String getTeacherRubricSaveButton(){
        teacherRubricSaveButton = properties.getProperty("ASSESSMENTS_TEACHER_RUBRIC_SAVE_BUTTON");
        return teacherRubricSaveButton;
    }

    public String getTeacherRubricCancelButton(){
        teacherRubricCancelButton = properties.getProperty("ASSESSMENTS_TEACHER_RUBRIC_CANCEL_BUTTON");
        return teacherRubricCancelButton;
    }

    public String getCreateStudentRubricButton(){
        createStudentRubricButton = properties.getProperty("ASSESSMENTS_CREATE_STUDENT_RUBRIC_BUTTON");
        return createStudentRubricButton;
    }

    public String getStudentRubricNameTextbox(){
        studentRubricNameTextbox = properties.getProperty("ASSESSMENTS_STUDENT_RUBRIC_NAME_TEXTBOX");
        return studentRubricNameTextbox;
    }

    public String getStudentRubricCKEditor(){
        studentRubricCKEditor = properties.getProperty("ASSESSMENTS_STUDENT_RUBRIC_CKEDITOR");
        return studentRubricCKEditor;
    }

    public String getStudentRubricSaveButton(){
        studentRubricSaveButton = properties.getProperty("ASSESSMENTS_STUDENT_RUBRIC_SAVE_BUTTON");
        return studentRubricSaveButton;
    }

    public String getStudentRubricCancelButton(){
        studentRubricCancelButton = properties.getProperty("ASSESSMENTS_STUDENT_RUBRIC_CANCEL_BUTTON");
        return studentRubricCancelButton;
    }

    public String getRubricSavedAlert(){
        rubricSavedAlert = properties.getProperty("ASSESSMENTS_CREATE_RUBRIC_SAVED_ALERT");
        return rubricSavedAlert;
    }

    public String getUploadTeacherRubricButton(){
        uploadTeacherRubricButton = properties.getProperty("ASSESSMENTS_UPLOAD_TEACHER_RUBRIC_BUTTON");
        return uploadTeacherRubricButton;
    }

    public String getUploadTeacherRubricNameTextbox(){
        uploadTeacherRubricNameTextbox = properties.getProperty("ASSESSMENTS_UPLOAD_TEACHER_RUBRIC_NAME_TEXTBOX");
        return uploadTeacherRubricNameTextbox;
    }

    public String getUploadTeacherRubricDropzone(){
        uploadTeacherRubricDropzone = properties.getProperty("ASSESSMENTS_UPLOAD_TEACHER_RUBRIC_DROPZONE");
        return uploadTeacherRubricDropzone;
    }

    public String getUploadTeacherRubricSuccessIcon(){
        uploadTeacherRubricSuccessIcon = properties.getProperty("ASSESSMENTS_UPLOAD_TEACHER_RUBRIC_DROPZONE");
        return uploadTeacherRubricSuccessIcon;
    }

    public String getUploadTeacherRubricSaveButton(){
        uploadTeacherRubricSaveButton = properties.getProperty("ASSESSMENTS_UPLOAD_TEACHER_RUBRIC_SAVE_BUTTON");
        return uploadTeacherRubricSaveButton;
    }

    public String getUploadStudentRubricButton(){
        uploadStudentRubricButton = properties.getProperty("ASSESSMENTS_UPLOAD_STUDENT_RUBRIC_BUTTON");
        return uploadStudentRubricButton;
    }

    public String getUploadStudentRubricNameTextbox(){
        uploadStudentRubricNameTextbox = properties.getProperty("ASSESSMENTS_UPLOAD_STUDENT_RUBRIC_NAME_TEXTBOX");
        return uploadStudentRubricNameTextbox;
    }

    public String getUploadStudentRubricDropzone(){
        uploadStudentRubricDropzone = properties.getProperty("ASSESSMENTS_UPLOAD_STUDENT_RUBRIC_DROPZONE");
        return uploadStudentRubricDropzone;
    }

    public String getUploadStudentRubricSuccessIcon(){
        uploadStudentRubricSuccessIcon = properties.getProperty("ASSESSMENTS_UPLOAD_STUDENT_RUBRIC_SUCCESS_ICON");
        return uploadStudentRubricSuccessIcon;
    }

    public String getUploadStudentRubricSaveButton(){
        uploadStudentRubricSaveButton = properties.getProperty("ASSESSMENTS_UPLOAD_STUDENT_RUBRIC_SAVE_BUTTON");
        return uploadStudentRubricSaveButton;
    }

    public String getAvailableTeacherRubricButton(){
        availableTeacherRubricButton = properties.getProperty("ASSESSMENTS_SELECT_AVAILABLE_TEACHER_RUBRIC_BUTTON");
        return availableTeacherRubricButton;
    }

    public String getAvailableStudentRubricButton(){
        availableStudentRubricButton = properties.getProperty("ASSESSMENTS_SELECT_AVAILABLE_STUDENT_RUBRIC_BUTTON");
        return availableStudentRubricButton;
    }

    public String getAvailableRubricsTextbox(){
        availableRubricsTextbox = properties.getProperty("ASSESSMENTS_SEARCH_AVAILABLE_RUBRICS_TEXTBOX");
        return availableRubricsTextbox;
    }

    public String getAvailableRubricsSearchIcon(){
        availableRubricsSearchIcon = properties.getProperty("ASSESSMENTS_SEARCH_AVAILABLE_RUBRICS_SEARCH_ICON");
        return availableRubricsSearchIcon;
    }

    public String getSelectRubricsButton(){
        selectRubricsButton = properties.getProperty("ASSESSMENTS_SEARCH_AVAILABLE_RUBRICS_SELECT_RUBRIC_BUTTON");
        return selectRubricsButton;
    }

    public String getAvailableRubricsExitFullScreen(){
        availableRubricsExitFullScreen = properties.getProperty("ASSESSMENTS_SEARCH_AVAILABLE_RUBRICS_EXIT_FULL_SCREEN");
        return availableRubricsExitFullScreen;
    }

    public String getEnableBrowserLockDown(){
        enableBrowserLockDown = properties.getProperty("ASSESSMENTS_ENABLE_BROWSER_LOCK_DOWN");
        return enableBrowserLockDown;
    }

    public String getOnlineSettings(){
        onlineSettings = properties.getProperty("ASSESSMENTS_ONLINE_SETTINGS");
        return onlineSettings;
    }

    public String getDurationSwitch(){
        durationSwitch = properties.getProperty("DURATION_SWITCH_ID");
        return durationSwitch;
    }

    public String getDurationUnlock(){
        durationUnlock = properties.getProperty("DURATION_UNLOCK_ID");
        return durationUnlock;
    }

    public String getDurationHoursTextbox(){
        durationHoursTextbox = properties.getProperty("DURATION_HOURS_TEXT_BOX");
        return durationHoursTextbox;
    }

    public String getDurationMinsTextbox(){
        durationMinsTextbox = properties.getProperty("DURATION_MINUTES_TEXT_BOX");
        return durationMinsTextbox;
    }

    public String getTimeIncrementTextbox(){
        timeIncrementTextbox = properties.getProperty("TIME_INCREMENT_TEXT_BOX");
        return timeIncrementTextbox;
    }

    public String getTimeIncrementUnlock(){
        timeIncrementUnlock = properties.getProperty("TIME_INCREMENT_UNLOCK_ID");
        return timeIncrementUnlock;
    }

    public String getTimeWindowStartTimeTextbox(){
        timeWindowStartTimeTextbox = properties.getProperty("TIME_WINDOW_START_TIME_TEXT_BOX");
        return timeWindowStartTimeTextbox;
    }

    public String getTimeWindowEndTimeTextbox(){
        timeWindowEndTimeTextbox = properties.getProperty("TIME_WINDOW_END_TIME_TEXT_BOX");
        return timeWindowEndTimeTextbox;
    }

    public String getTimeWindowLock(){
        timeWindowLock = properties.getProperty("TIME_WINDOW_LOCK_ID");
        return timeWindowLock;
    }

    public String getTimeWindowUnLock(){
        timeWindowUnLock = properties.getProperty("TIME_WINDOW_UNLOCK_ID");
        return timeWindowUnLock;
    }

    public String getDaysMonday(){
        daysMonday = properties.getProperty("DAYS_WINDOW_MONDAY_ID");
        return daysMonday;
    }

    public String getDaysTuesday(){
        daysTuesday = properties.getProperty("DAYS_WINDOW_TUESDAY_ID");
        return daysTuesday;
    }

    public String getDaysWednesday(){
        daysWednesday = properties.getProperty("DAYS_WINDOW_WEDNESDAY_ID");
        return daysWednesday;
    }

    public String getDaysThursday(){
        daysThursday = properties.getProperty("DAYS_WINDOW_THURSDAY_ID");
        return daysThursday;
    }

    public String getDaysFriday(){
        daysFriday = properties.getProperty("DAYS_WINDOW_FRIDAY_ID");
        return daysFriday;
    }

    public String getDaysSaturday(){
        daysSaturday = properties.getProperty("DAYS_WINDOW_SATURDAY_ID");
        return daysSaturday;
    }

    public String getDaysSunday(){
        daysSunday = properties.getProperty("DAYS_WINDOW_SUNDAY_ID");
        return daysSunday;
    }

    public String getDaysWindowUnLock(){
        daysWindowUnLock = properties.getProperty("DAYS_WINDOW_UNLOCK_ID");
        return daysWindowUnLock;
    }

    public String getTimeWindowLabel(){
        timeWindowLabel = properties.getProperty("TIME_WINDOW_LABEL");
        return timeWindowLabel;
    }

    public String getAnswerSheetTemplateIndividualStudent(){
        answerSheetTemplateIndividualStudent = properties.getProperty("ASSESSMENTS_ANSWER_SHEET_TEMPLATE_INDIVIDUAL_STUDENT");
        return answerSheetTemplateIndividualStudent;
    }

    public String getAnswerSheetTemplateClassRoster(){
        answerSheetTemplateClassRoster = properties.getProperty("ASSESSMENTS_ANSWER_SHEET_TEMPLATE_CLASS_ROSTER");
        return answerSheetTemplateClassRoster;
    }

    public String getBubbleSizeNormal(){
        bubbleSizeNormal = properties.getProperty("ASSESSMENTS_BUBBLE_SIZE_NORMAL");
        return bubbleSizeNormal;
    }

    public String getBubbleSizeLarge(){
        bubbleSizeLarge = properties.getProperty("ASSESSMENTS_BUBBLE_SIZE_LARGE");
        return bubbleSizeLarge;
    }

    public String getAnswerSheetPrintingStartDate(){
        answerSheetPrintingStartDate = properties.getProperty("ASSESSMENTS_ANSWER_SHEET_PRINTING_START_DATE");
        return answerSheetPrintingStartDate;
    }

    public String getScoringEndDate(){
        scoringEndDate = properties.getProperty("ASSESSMENTS_SCORING_END_DATE");
        return scoringEndDate;
    }

    public String getSetupSave(){
        setupSave = properties.getProperty("ASSESSMENTS_SETUP_SAVE");
        return setupSave;
    }

    public String getSetupPublish(){
        setupPublish = properties.getProperty("ASSESSMENTS_SETUP_PUBLISH");
        return setupPublish;
    }

    public String getSetupNoThankyou(){
        setupNoThankyou = properties.getProperty("ASSESSMENTS_SETUP_NO_THANKYOU_BUTTON");
        return setupNoThankyou;
    }

    public String getSelectAllCheckBoxId() {
        selectAllCheckBoxId = properties.getProperty("SELECT_ALL_CHECKBOX_ID");
        return selectAllCheckBoxId;
    }

    public String getSelectAllLockId() {
        selectAllLockId = properties.getProperty("SELECT_ALL_LOCK_ID");
        return selectAllLockId;
    }

    public String getSelectAllUnlockId() {
        selectAllUnlockId = properties.getProperty("SELECT_ALL_UNLOCK_ID");
        return selectAllUnlockId;
    }

    public String getDigitVerfyCheckBoxId() {
        digitVerfCheckBoxId = properties.getProperty("DIGIT_VERIFICATION_CHECKBOX_ID");
        return digitVerfCheckBoxId;
    }

    public String getDigitVerfyLockId() {
        digitVerfyLockId = properties.getProperty("DIGIT_VERIFICATION_LOCK_ID");
        return digitVerfyLockId;
    }

    public String getDigitVerfyUnlockId() {
        digitVerfyUnlockId = properties.getProperty("DIGIT_VERIFICATION_UNLOCK_ID");
        return digitVerfyUnlockId;
    }

    public String getAutoActivationCheckBoxId() {
        autoActivationCheckBoxId = properties.getProperty("AUTO_ACTIVATION_CHECKBOX_ID");
        return autoActivationCheckBoxId;
    }

    public String getAutoActivationUnlockId() {
        autoActivationUnlockId = properties.getProperty("AUTO_ACTIVATION_UNLOCK_ID");
        return autoActivationUnlockId;
    }

    public String getAutoActivationLockId() {
        autoActivationLockId = properties.getProperty("AUTO_ACTIVATION_LOCK_ID");
        return autoActivationLockId;
    }

    public String getReActivationCheckBoxId() {
        reActivationCheckBoxId = properties.getProperty("RE_ACTIVATION_CHECKBOX_ID");
        return reActivationCheckBoxId;
    }

    public String getReActivationUnlockId() {
        reActivationUnlockId = properties.getProperty("RE_ACTIVATION_UNLOCK_ID");
        return reActivationUnlockId;
    }

    public String getReActivationLockId() {
        reActivationLockId = properties.getProperty("RE_ACTIVATION_LOCK_ID");
        return reActivationLockId;
    }

    public String getDisplayItemsStudentCheckBoxId() {
        displayItemsStudentCheckBoxId = properties.getProperty("DISPLAY_ITEMS_STUDENT_PORTAL_CHECKBOX_ID");
        return displayItemsStudentCheckBoxId;
    }

    public String getDisplayItemsStudentLockId() {
        displayItemsStudentLockId = properties.getProperty("DISPLAY_ITEMS_STUDENT_PORTAL_LOCK_ID");
        return displayItemsStudentLockId;
    }

    public String getDisplayItemsStudentUnlockId() {
        displayItemsStudentUnlockId = properties.getProperty("DISPLAY_ITEMS_STUDENT_PORTAL_UNLOCK_ID");
        return displayItemsStudentUnlockId;
    }

    public String getDispalyCorrectAnsCheckBoxId() {
        dispalyCorrectAnsCheckBoxId = properties.getProperty("DISPLAY_CORRECT_ANS_CHECKBOX_ID");
        return dispalyCorrectAnsCheckBoxId;
    }

    public String getDisplayRationaleCheckBoxId() {
        displayRationaleCheckBoxId = properties.getProperty("DISPLAY_RATIONALE_CHECKBOX_ID");
        return displayRationaleCheckBoxId;
    }

    public String getDisplayStandards(){
        displayStandards = properties.getProperty("DISPLAY_STANDARDS");
        return displayStandards;
    }

    public String getDisplayGroupItemStandard(){
        displayGroupItemStandard = properties.getProperty("DISPLAY_GROUP_ITEMS_STANDARDS");
        return displayGroupItemStandard;
    }

    public String getDisplayTimerCheckBoxId() {
        displayTimerCheckBoxId = properties.getProperty("DISPLAY_TIMER_CHECKBOX_ID");
        return displayTimerCheckBoxId;
    }

    public String getDisplayTimerLockId() {
        displayTimerLockId = properties.getProperty("DISPLAY_TIMER_LOCK_ID");
        return displayTimerLockId;
    }

    public String getDisplayTimerUnlockId() {
        displayTimerUnlockId = properties.getProperty("DISPLAY_TIMER_UNLOCK_ID");
        return displayTimerUnlockId;
    }

    public String getThermometerCheckBoxId() {
        thermometerCheckBoxId = properties.getProperty("THERMOMETER_CHECKBOX_ID");
        return thermometerCheckBoxId;
    }

    public String getThermometerLockId() {
        thermometerLockId = properties.getProperty("THERMOMETER_LOCK_ID");
        return thermometerLockId;
    }

    public String getThermometerUnlockId() {
        thermometerUnlockId = properties.getProperty("THERMOMETER_UNLOCK_ID");
        return thermometerUnlockId;
    }

    public String getOnlineToolsLabel() {
        onlineToolsLabel = properties.getProperty("ONLINE_TOOLS_LABEL");
        return onlineToolsLabel;
    }

    public String getAdvanceCalCheckBoxId() {
        advanceCalCheckBoxId = properties.getProperty("ADVANCE_CALCULATOR_CHECKBOX_ID");
        return advanceCalCheckBoxId;
    }

    public String getAdvanceCalLockId() {
        advanceCalLockId = properties.getProperty("ADVANCE_CALCULATOR_LOCK_ID");
        return advanceCalLockId;
    }

    public String getAdvanceCalUnlockId() {
        advanceCalUnlockId = properties.getProperty("ADVANCE_CALCULATOR_UNLOCK_ID");
        return advanceCalUnlockId;
    }

    public String getBasicCalCheckBoxId() {
        basicCalCheckBoxId = properties.getProperty("BASIC_CALCULATOR_CHECKBOX_ID");
        return basicCalCheckBoxId;
    }

    public String getBasicCalLockId() {
        basicCalLockId = properties.getProperty("BASIC_CALCULATOR_LOCK_ID");
        return basicCalLockId;
    }

    public String getBasicCalUnlockId() {
        basicCalUnlockId = properties.getProperty("BASIC_CALCULATOR_UNLOCK_ID");
        return basicCalUnlockId;
    }

    public String getScientificCalCheckBoxId() {
        scientificCalCheckBoxId = properties.getProperty("SCIENTIFIC_CALCULATOR_CHECKBOX_ID");
        return scientificCalCheckBoxId;
    }

    public String getScientificCalLockId() {
        scientificCalLockId = properties.getProperty("SCIENTIFIC_CALCULATOR_LOCK_ID");
        return scientificCalLockId;
    }

    public String getScientificCalUnlockId() {
        scientificCalUnlockId = properties.getProperty("SCIENTIFIC_CALCULATOR_UNLOCK_ID");
        return scientificCalUnlockId;
    }

    public String getEquationEditorLabel() {
        equationEditorLabel = properties.getProperty("EQUATION_EDITOR_LABEL");
        return equationEditorLabel;
    }

    public String getAdvEquEditorCheckBoxId() {
        advEquEditorCheckBoxId = properties.getProperty("ADVANCE_EQUA_EDITOR_CHECKBOX_ID");
        return advEquEditorCheckBoxId;
    }

    public String getAdvEquEditorLockId() {
        advEquEditorLockId = properties.getProperty("ADVANCE_EQUA_EDITOR_LOCK_ID");
        return advEquEditorLockId;
    }

    public String getAdvEquEditorUnlockId() {
        advEquEditorUnlockId = properties.getProperty("ADVANCE_EQUA_EDITOR_UNLOCK_ID");
        return advEquEditorUnlockId;
    }

    public String getAlgebraEditorCheckBoxId() {
        algebraEditorCheckBoxId = properties.getProperty("ALGEBRA_EDITOR_CHECKBOX_ID");
        return algebraEditorCheckBoxId;
    }

    public String getAlgebraEditorLockId() {
        algebraEditorLockId = properties.getProperty("ALGEBRA_EDITOR_LOCK_ID");
        return algebraEditorLockId;
    }

    public String getAlgebraEditorUnlockId() {
        algebraEditorUnlockId = properties.getProperty("ALGEBRA_EDITOR_UNLOCK_ID");
        return algebraEditorUnlockId;
    }

    public String getTrignometryEditorCheckBoxId() {
        trignometryEditorCheckBoxId = properties.getProperty("ALGEBRA_TRIGNOMETRY_EDITOR_CHECKBOX_ID");
        return trignometryEditorCheckBoxId;
    }

    public String getTrignometryEditorLockId() {
        trignometryEditorLockId = properties.getProperty("ALGEBRA_TRIGNOMETRY_EDITOR_LOCK_ID");
        return trignometryEditorLockId;
    }

    public String getTrignometryEditorUnlockId() {
        trignometryEditorUnlockId = properties.getProperty("ALGEBRA_TRIGNOMETRY_EDITOR_UNLOCK_ID");
        return trignometryEditorUnlockId;
    }

    public String getElementryEditorCheckBoxId() {
        elementryEditorCheckBoxId = properties.getProperty("ELIMENTRY_EDITOR_CHECKBOX_ID");
        return elementryEditorCheckBoxId;
    }

    public String getElementryEditorLockId() {
        elementryEditorLockId = properties.getProperty("ELIMENTRY_EDITOR_LOCK_ID");
        return elementryEditorLockId;
    }

    public String getElementryEditorUnlockId() {
        elementryEditorUnlockId = properties.getProperty("ELIMENTRY_EDITOR_UNLOCK_ID");
        return elementryEditorUnlockId;
    }

    public String getMediaUploadLabel() {
        mediaUploadLabel = properties.getProperty("MEDIA_UPLOAD_LABEL");
        return mediaUploadLabel;
    }

    public String getAudioCheckBoxId() {
        audioCheckBoxId = properties.getProperty("AUDIO_CHECKBOX_ID");
        return audioCheckBoxId;
    }

    public String getAudioLockId() {
        audioLockId = properties.getProperty("AUDIO_LOCK_ID");
        return audioLockId;
    }

    public String getAudioUnlockId() {
        audioUnlockId = properties.getProperty("AUDIO_UNLOCK_ID");
        return audioUnlockId;
    }

    public String getImageCheckBoxId() {
        imageCheckBoxId = properties.getProperty("IMAGE_CHECKBOX_ID");
        return imageCheckBoxId;
    }

    public String getImageLockId() {
        imageLockId = properties.getProperty("IMAGE_LOCK_ID");
        return imageLockId;
    }

    public String getImageUnlockId() {
        imageUnlockId = properties.getProperty("IMAGE_UNLOCK_ID");
        return imageUnlockId;
    }

    public String getVideoCheckBoxId() {
        videoCheckBoxId = properties.getProperty("VIDEO_CHECKBOX_ID");
        return videoCheckBoxId;
    }

    public String getVideoLockId() {
        videoLockId = properties.getProperty("VIDEO_LOCK_ID");
        return videoLockId;
    }

    public String getVideoUnlockId() {
        videoUnlockId = properties.getProperty("VIDEO_UNLOCK_ID");
        return videoUnlockId;
    }

    public String getOtherToolsLabel() {
        otherToolsLabel = properties.getProperty("OTHER_TOOLS_LABEL");
        return otherToolsLabel;
    }

    public String getAnsEliminatorCheckBoxId() {
        ansEliminatorCheckBoxId = properties.getProperty("ANSWER_ELIMINATOR_CHECKBOX_ID");
        return ansEliminatorCheckBoxId;
    }

    public String getAnsEliminatorLockId() {
        ansEliminatorLockId = properties.getProperty("ANSWER_ELIMINATOR_LOCK_ID");
        return ansEliminatorLockId;
    }

    public String getAnsEliminatorUnlockId() {
        ansEliminatorUnlockId = properties.getProperty("ANSWER_ELIMINATOR_UNLOCK_ID");
        return ansEliminatorUnlockId;
    }

    public String getGraphCheckBoxId() {
        graphCheckBoxId = properties.getProperty("GRAPH_CHECKBOX_ID");
        return graphCheckBoxId;
    }

    public String getGraphLockId() {
        graphLockId = properties.getProperty("GRAPH_LOCK_ID");
        return graphLockId;
    }

    public String getGraphUnlockId() {
        graphUnlockId = properties.getProperty("GRAPH_UNLOCK_ID");
        return graphUnlockId;
    }

    public String getLineReaderCheckBoxId() {
        lineReaderCheckBoxId = properties.getProperty("LINE_READER_CHECKBOX_ID");
        return lineReaderCheckBoxId;
    }

    public String getLineReaderLockId() {
        lineReaderLockId = properties.getProperty("LINE_READER_LOCK_ID");
        return lineReaderLockId;
    }

    public String getLineReaderUnlockId() {
        lineReaderUnlockId = properties.getProperty("LINE_READER_UNLOCK_ID");
        return lineReaderUnlockId;
    }

    public String getNotesCheckBoxId() {
        notesCheckBoxId = properties.getProperty("NOTES_CHECKBOX_ID");
        return notesCheckBoxId;
    }

    public String getNotesLockId() {
        notesLockId = properties.getProperty("NOTES_LOCK_ID");
        return notesLockId;
    }

    public String getNotesUnlockId() {
        notesUnlockId = properties.getProperty("NOTES_UNLOCK_ID");
        return notesUnlockId;
    }

    public String getPeriodicTableCheckBoxId() {
        periodicTableCheckBoxId = properties.getProperty("PERIODIC_TABLE_CHECKBOX_ID");
        return periodicTableCheckBoxId;
    }

    public String getPeriodicTableLockId() {
        periodicTableLockId = properties.getProperty("PERIODIC_TABLE_LOCK_ID");
        return periodicTableLockId;
    }

    public String getPeriodicTableUnlockId() {
        periodicTableUnlockId = properties.getProperty("PERIODIC_TABLE_UNLOCK_ID");
        return periodicTableUnlockId;
    }
    public String getProtractorCheckBoxId() {
        protractorCheckBoxId = properties.getProperty("PROTRACTOR_CHECKBOX_ID");
        return protractorCheckBoxId;
    }

    public String getProtractorLockId() {
        protractorLockId = properties.getProperty("PROTRACTOR_LOCK_ID");
        return protractorLockId;
    }

    public String getProtractorUnlockId() {
        protractorUnlockId = properties.getProperty("PROTRACTOR_UNLOCK_ID");
        return protractorUnlockId;
    }

    public String getRulerCheckBoxId() {
        rulerCheckBoxId = properties.getProperty("RULER_CHECKBOX_ID");
        return rulerCheckBoxId;
    }

    public String getRulerLockId() {
        rulerLockId = properties.getProperty("RULER_LOCK_ID");
        return rulerLockId;
    }

    public String getRulerUnlockId() {
        rulerUnlockId = properties.getProperty("RULER_UNLOCK_ID");
        return rulerUnlockId;
    }

    public String getSpellCheckCheckBoxId() {
        spellCheckCheckBoxId = properties.getProperty("SPELL_CHECKER_CHECKBOX_ID");
        return spellCheckCheckBoxId;
    }

    public String getSpellCheckLockId() {
        spellCheckLockId = properties.getProperty("SPELL_CHECKER_LOCK_ID");
        return spellCheckLockId;
    }

    public String getSpellCheckUnlockId() {
        spellCheckUnlockId = properties.getProperty("SPELL_CHECKER_UNLOCK_ID");
        return spellCheckUnlockId;
    }

    public String getTextMagnifierDivID(){
        textMagnifierDivID = properties.getProperty("TEXT_MAGNIFIER_CHECKBOX_ID");
        return textMagnifierDivID;
    }

    public String getTextMagnifierCheckBoxId() {
        textMagnifierCheckBoxId = properties.getProperty("TEXT_MAGNIFIER_CHECKBOX_ID");
        return textMagnifierCheckBoxId;
    }

    public String getTextMagnifierLockId() {
        textMagnifierLockId = properties.getProperty("TEXT_MAGNIFIER_LOCK_ID");
        return textMagnifierLockId;
    }

    public String getTextMagnifierUnlockId() {
        textMagnifierUnlockId = properties.getProperty("TEXT_MAGNIFIER_UNLOCK_ID");
        return textMagnifierUnlockId;
    }

    public String getBubbleSizeDiv(){
        bubbleSizeDiv = properties.getProperty("ASSESSMENTS_BUBBLE_SIZE_DIV");
        return bubbleSizeDiv;
    }
}
