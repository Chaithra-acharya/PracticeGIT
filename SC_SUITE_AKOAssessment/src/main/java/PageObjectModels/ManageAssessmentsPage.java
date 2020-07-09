package PageObjectModels;

import Helpers.DriverHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ManageAssessmentsPage {
    String pageHeader, yearDropDown, collectionDropDown, subjectDropDown, standardGradeDropDown, assessmentTypeDropDown, statusDropDown;
    String allTabsSearchTextBox, allTabSearchButton, assessmentNamesResults, assessmentNamesCheckBoxResults, noAssessmentFound, assessmentDeleteButton;
    String assessmentDeletePopUpHeader, assessmentDeletePopUpDeleteButton, assessmentDeleteSuccessfully, assessmentDeleteOk;
    String tagsDropDown, assessmentCreatedByDropDown, refreshButton, createAssessmentDropDown, manageCollectionButton, assessmentTabs;

    private static String os = null;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;

    public ManageAssessmentsPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("SC_SUITE_AKOAssessment", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + DriverHelper.getPath("\\Properties\\ManageAssessmentsPage.properties"));
            } else {
                input = new FileInputStream(dir + "/Properties/ManageAssessmentsPage.properties");
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

    public String getPageHeader(){
        pageHeader = properties.getProperty("ASSESSMENTS_HEADER_TEXT");
        return pageHeader;
    }

    public String getYearDropDown(){
        yearDropDown = properties.getProperty("ASSESSMENTS_YEAR_FILTER_DROPDOWN");
        return yearDropDown;
    }

    public String getCollectionDropDown(){
        collectionDropDown = properties.getProperty("ASSESSMENTS_COLLECTION_FILTER_DROPDOWN");
        return collectionDropDown;
    }

    public String getSubjectDropDown(){
        subjectDropDown = properties.getProperty("ASSESSMENTS_SUBJECT_FILTER_DROPDOWN");
        return subjectDropDown;
    }

    public String getStandardGradeDropDown(){
        standardGradeDropDown = properties.getProperty("ASSESSMENTS_STANDARD_GRADE_FILTER_DROPDOWN");
        return standardGradeDropDown;
    }

    public String getAssessmentTypeDropDown(){
        assessmentTypeDropDown = properties.getProperty("ASSESSMENTS_TYPE_FILTER_DROPDOWN");
        return assessmentTypeDropDown;
    }

    public String getStatusDropDown(){
        statusDropDown = properties.getProperty("ASSESSMENTS_STATUS_FILTER_DROPDOWN");
        return statusDropDown;
    }

    public String getTagsDropDown() {
        tagsDropDown = properties.getProperty("ASSESSMENTS_TAGS_FILTER_DROPDOWN");
        return tagsDropDown;
    }

    public String getAssessmentCreatedByDropDown(){
        assessmentCreatedByDropDown = properties.getProperty("ASSESSMENTS_CREATEDBY_FILTER_DROPDOWN");
        return assessmentCreatedByDropDown;
    }

    public String getRefreshButton(){
        refreshButton = properties.getProperty("ASSESSMENTS_FILTER_REFRESH_BUTTON");
        return refreshButton;
    }

    public String getCreateAssessmentDropDown(){
        createAssessmentDropDown = properties.getProperty("ASSESSMENTS_CREATE_ASSESSMENT_DROPDOWN");
        return createAssessmentDropDown;
    }

    public String getManageCollectionButton(){
        manageCollectionButton = properties.getProperty("ASSESSMENTS_MANAGE_COLLECTION_BUTTON");
        return manageCollectionButton;
    }

    public String getAssessmentTabs(){
        assessmentTabs = properties.getProperty("ASSESSMENTS_TABS");
        return assessmentTabs;
    }

    public String getAllTabsSearchTextBox() {
        allTabsSearchTextBox = properties.getProperty("ASSESSMENTS_ALL_TABS_SEARCH_TEXTBOX");
        return allTabsSearchTextBox;
    }

    public String getAllTabSearchButton() {
        allTabSearchButton = properties.getProperty("ASSESSMENTS_ALL_TABS_SEARCH_BUTTON");
        return allTabSearchButton;
    }

    public String getAssessmentNamesResults() {
        assessmentNamesResults = properties.getProperty("ASSESSMENTS_NAME_SEARCHED_RESULTS_NAME");
        return assessmentNamesResults;
    }

    public String getAssessmentNamesCheckBoxResults() {
        assessmentNamesCheckBoxResults = properties.getProperty("ASSESSMENTS_NAME_SEARCHED_RESULTS_CHECKBOX");
        return assessmentNamesCheckBoxResults;
    }
    public String getNoAssessmentFound() {
        noAssessmentFound = properties.getProperty("NO_ASSESSMENT_FOUND");
        return noAssessmentFound;
    }
    public String getAssessmentDeleteButton() {
        assessmentDeleteButton = properties.getProperty("ASSESSMENTS_NAME_DELETE_BUTTON");
        return assessmentDeleteButton;
    }

    public String getAssessmentDeletePopUpHeader() {
        assessmentDeletePopUpHeader = properties.getProperty("ASSESSMENTS_NAME_DELETE_POPUP_HEADER");
        return assessmentDeletePopUpHeader;
    }

    public String getAssessmentDeletePopUpDeleteButton() {
        assessmentDeletePopUpDeleteButton = properties.getProperty("ASSESSMENTS_NAME_DELETE_POPUP_DELETE_BUTTON");
        return assessmentDeletePopUpDeleteButton;
    }
    public String getAssessmentDeleteSuccessfully() {
        assessmentDeleteSuccessfully = properties.getProperty("ASSESSMENTS_NAME_DELETE_POPUP_SUCCESSFULLY_DELETED_TITLE");
        return assessmentDeleteSuccessfully;
    }
    public String getAssessmentDeleteOk() {
        assessmentDeleteOk = properties.getProperty("ASSESSMENTS_NAME_DELETE_POPUP_OK_BUTTON");
        return assessmentDeleteOk;
    }
}
