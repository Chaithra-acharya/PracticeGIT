package PageObjectModels;

import Helpers.DriverHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AKOAssessmentInfoPage {
    String assessmentNameTextbox, subjectDropDown, collectionDropDown, plcDropDown, setupMultipleGrades, alertOKButton;
    String scheduleAllStudents, scheduleGradeLevel, scheduleCourseGroupLevel, scheduleStudentGroupLevel;
    String selectCourseGroupDropDown, selectCourseDropDown, textboxCourseDropDown, selectStudentGroupDropDown, textboxStudentGroupDropDown;
    String saveButton, saveMessage, nextButton;
    String districtHeader;

    private static String os = null;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;

    public AKOAssessmentInfoPage(){
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("SC_SUITE_AKOAssessment", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + DriverHelper.getPath("\\Properties\\AKOAssessmentInfoPage.properties"));
            } else {
                input = new FileInputStream(dir + "/Properties/AKOAssessmentInfoPage.properties");
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

    public String getAssessmentNameTextbox(){
        assessmentNameTextbox = properties.getProperty("ASSESSMENT_NAME_TEXTBOX");
        return assessmentNameTextbox;
    }

    public String getSubjectDropDown(){
        subjectDropDown = properties.getProperty("ASSESSMENT_SUBJECT_DROPDOWN");
        return subjectDropDown;
    }

    public String getCollectionDropDown(){
        collectionDropDown = properties.getProperty("ASSESSMENT_COLLECTION_DROPDOWN");
        return collectionDropDown;
    }

    public String getPlcDropDown(){
        plcDropDown = properties.getProperty("ASSESSMENT_PLC_DROPDOWN");
        return plcDropDown;
    }

    public String getSetupMultipleGrades(){
        setupMultipleGrades = properties.getProperty("ASSESSMENT_SETUP_MULTIPLE_GRADES");
        return setupMultipleGrades;
    }

    public String getAlertOKButton(){
        alertOKButton = properties.getProperty("ALERT_OK_BUTTON");
        return alertOKButton;
    }

    public String getScheduleAllStudents(){
        scheduleAllStudents = properties.getProperty("ASSESSMENT_SCHEDULE_ALL_STUDENTS");
        return scheduleAllStudents;
    }

    public String getScheduleGradeLevel(){
        scheduleGradeLevel = properties.getProperty("ASSESSMENT_SCHEDULE_BY_GRADE_LEVEL");
        return scheduleGradeLevel;
    }

    public String getScheduleCourseGroupLevel(){
        scheduleCourseGroupLevel = properties.getProperty("ASSESSMENT_SCHEDULE_BY_COURSE_GROUP_LEVEL");
        return scheduleCourseGroupLevel;
    }

    public String getScheduleStudentGroupLevel(){
        scheduleStudentGroupLevel = properties.getProperty("ASSESSMENT_SCHEDULE_BY_STUDENT_GROUP_LEVEL");
        return scheduleStudentGroupLevel;
    }

    public String getSelectCourseGroupDropDown(){
        selectCourseGroupDropDown = properties.getProperty("ASSESSMENT_SELECT_COURSEGROUP_DROPDOWN");
        return selectCourseGroupDropDown;
    }

    public String getSelectCourseDropDown(){
        selectCourseDropDown = properties.getProperty("ASSESSMENT_SELECT_COURSE_DROPDOWN");
        return selectCourseDropDown;
    }

    public String getTextboxCourseDropDown(){
        textboxCourseDropDown = properties.getProperty("ASSESSMENT_SELECT_COURSE_DROPDOWN_TEXTBOX");
        return textboxCourseDropDown;
    }

    public String getSelectStudentGroupDropDown(){
        selectStudentGroupDropDown = properties.getProperty("ASSESSMENT_SELECT_STUDENTGROUP_DROPDOWN");
        return selectStudentGroupDropDown;
    }

    public String getTextboxStudentGroupDropDown(){
        textboxStudentGroupDropDown = properties.getProperty("ASSESSMENT_SELECT_STUDENTGROUP_DROPDOWN_TEXTBOX");
        return textboxStudentGroupDropDown;
    }

    public String getSaveButton(){
        saveButton = properties.getProperty("ASSESSMENT_INFO_SAVE_BUTTON");
        return saveButton;
    }

    public String getSaveMessage(){
        saveMessage = properties.getProperty("ASSESSMENT_INFO_SAVE_MESSAGE");
        return saveMessage;
    }

    public String getNextButton(){
        nextButton = properties.getProperty("ASSESSMENT_INFO_NEXT_BUTTON");
        return nextButton;
    }

    public String getDistrictHeader(){
        districtHeader = properties.getProperty("ASSESSMENT_DISTRICT_HEADER");
        return districtHeader;
    }
}


