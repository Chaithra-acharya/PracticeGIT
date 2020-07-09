package PageObjectModels;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ItemInfoPage extends PageObjectModelBase {
    private String itemInfoTab, itemNameTextbox, itemTypeDropDown, textboxInItemTypeDropDown;
    private String subjectDropDown, textboxInSubjectDropDown, subject;
    private String grade;
    private String courseGroupDropDown, textboxInCourseGroupDropDown, courseGroup;
    private String courseDropDown, textboxInCourseDropDown, course;
    private String districtName, gradesSection;
    private String linkPassageButton, linkpassageModalHeader, passageSearchTextbox, bankDropDown, textboxInBankDropDown, bankName, refreshButton;
    private String passageSelectionCheckbox, selectButton, cancelButton, closeModalIcon, linkedPassage;
    private String teacherInstructionToggleButton, teacherInstructionCKEditor;
    private String questionCKEditor, linkInsideDropDown;
    private String totalPossiblePoints, pilotOption, answerhint, answerhinttextbox, answerchoiceSection;
    private String courseGroupID, subjectID, pilot, itemTypeID, courseID, bankNameID, noOfChoicesDropDown, noOfChoices;
    private String typeofChoicesDropDown, typeofChoices, answerChoiceFormatDropDown, answerChoice, lockChoicesOrder, includeRationale, noChoicesSection;
    private String saveButton, nextButton;
    private String hisdVersionID, hisdVersionDropDown, hisdVersionDropDownTextbox, hisdQualifierTextbox, hisdGenerateItemName;
    private static String os = null;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;

    public void readProperties() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("CreateMCItemType", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + DriverHelper.getPath("\\Properties\\ItemBanksItemInfoPage.properties"));
            } else {
                input = new FileInputStream(dir + "/Properties/ItemBanksItemInfoPage.properties");
            }
            properties.load(input);

            itemInfoTab = properties.getProperty("ITEN_INFO_TAB");
            itemNameTextbox = properties.getProperty("ITEM_NAME_TEXT_BOX");
            itemTypeDropDown =  properties.getProperty("ITEM_TYPE_DROP_DOWN");
            textboxInItemTypeDropDown = properties.getProperty("ITEM_TYPE_DROP_DOWN_TEXTBOX");
            subjectDropDown = properties.getProperty("SUBJECT_DROP_DOWN");
            textboxInSubjectDropDown = properties.getProperty("SUBJECT_DROP_DOWN_TEXTBOX");
            subject = properties.getProperty("SUBJECT_DROPDOWN_SUBJECT_OPTION");
            courseGroupDropDown = properties.getProperty("COURSE_GROUP_DROP_DOWN");
            textboxInCourseGroupDropDown = properties.getProperty("COURSE_GROUP_DROP_DOWN_TEXTBOX");
            courseDropDown = properties.getProperty("COURSE_DROP_DOWN");
            textboxInCourseDropDown = properties.getProperty("COURSE_DROP_DOWN_TEXTBOX");
            pilotOption = properties.getProperty("PILOT_ITEM_OPTION");

            districtName = properties.getProperty("DISTRICT_NAME");
            gradesSection = properties.getProperty("GRADES_SECTION");
            linkPassageButton = properties.getProperty("LINK_PASSAGE_BUTTON");

            districtName = properties.getProperty("DISTRICT_NAME");
            gradesSection = properties.getProperty("GRADES_SECTION");

            linkPassageButton = properties.getProperty("LINK_PASSAGE_BUTTON");
            linkpassageModalHeader = properties.getProperty("LINK_PASSAGE_MODAL_HEADER");
            passageSearchTextbox = properties.getProperty("LINK_PASSAGE_MODAL_PASSAGE_SEARCH_TEXTBOX");
            bankDropDown = properties.getProperty("LINK_PASSAGE_MODAL_BANK_DROPDOWN");
            textboxInBankDropDown = properties.getProperty("LINK_PASSAGE_MODAL_BANK_DROPDOWN_TEXT");

            refreshButton = properties.getProperty("LINK_PASSAGE_MODAL_REFRESH_BUTTON");
            selectButton = properties.getProperty("LINK_PASSAGE_MODAL_SELECT_BUTTON");
            cancelButton = properties.getProperty("LINK_PASSAGE_MODAL_CANCEL_BUTTON");
            closeModalIcon = properties.getProperty("LINK_PASSAGE_CLOSE_MODAL_ICON");

            teacherInstructionToggleButton = properties.getProperty("TEACHER_INSTRUCTION_TOGGLE_BUTTON");
            teacherInstructionCKEditor = properties.getProperty("TEACHER_INSTRUCTION_CKEDITOR");
            questionCKEditor = properties.getProperty("QUESTION_CKEDITOR");
            totalPossiblePoints = properties.getProperty("TOTAL_POSSIBLE_POINTS_TEXTBOX");
            answerhint = properties.getProperty("ANSWER_HINT");

            answerhinttextbox = properties.getProperty("ANSWER_HINT_TEXTBOX");
            answerchoiceSection = properties.getProperty("ANSWER_CHOICE_SECTION");
            totalPossiblePoints = properties.getProperty("TOTAL_POSSIBLE_POINTS_TEXTBOX");
            answerhint = properties.getProperty("ANSWER_HINT");

            itemTypeID = properties.getProperty("ITEM_TTYPE_ID");
            subjectID = properties.getProperty("SUBJECT_ID");
            courseGroupID = properties.getProperty("COURSE_GROUP_ID");
            courseID = properties.getProperty("COURSE_ID");
            bankNameID = properties.getProperty("ITEM_BANK_NAME_ID");

            noOfChoicesDropDown = properties.getProperty("NUMBER_OF_CHOICE_DROPDOWN");
            typeofChoicesDropDown = properties.getProperty("TYPE_OF_CHOICE_DROPDOWN");
            answerChoiceFormatDropDown = properties.getProperty("ANSWER_CHOICE_FORMAT_DROPDOWN");

            lockChoicesOrder = properties.getProperty("LOCK_CHOICE_ORDER");
            includeRationale = properties.getProperty("INCLUDE_RATIONAL_TOGGLE_BUTTON");
            noChoicesSection= properties.getProperty("CHOICE_SECTION");

            saveButton = properties.getProperty("ITEM_INFO_SAVE_BUTTON");
            nextButton= properties.getProperty("ITEM_INFO_NEXT_BUTTON");

            hisdVersionID = properties.getProperty("HISD_VERSION_ID");
            hisdVersionDropDown = properties.getProperty("HISD_VERSION_DROPDOWN");
            hisdVersionDropDownTextbox = properties.getProperty("HISD_VERSION_DROPDOWN_TEXTBOX");
            hisdQualifierTextbox = properties.getProperty("HISD_QUALIFIER_TEXTBOX");
            hisdGenerateItemName = properties.getProperty("HISD_GENERATE_ITEM_NAME");
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

    //ID
    public String getItemInfoTab() {
        return itemInfoTab;
    }

    //ID
    public String getPilot() {
        return pilot;
    }

    //ID
    public String getItemTypeID() {
        return itemTypeID;
    }

    //Xpath
    public String getItemNameTextbox() {
        return itemNameTextbox;
    }

    //ID
    public String getCourseID() {
        return courseID;
    }

    //Css
    public String getItemTypeDropDown() {
        return itemTypeDropDown;
    }

    //ID
    public String getBankNameID() {
        return bankNameID;
    }

    //Xpath
    public String getpilotOption() {
        return pilotOption;
    }

    //Xpath
    public String getTextboxInItemTypeDropDown() {
        return textboxInItemTypeDropDown;
    }

    //CSS
    public String getSubjectDropDown() {
        return subjectDropDown;
    }

    //Xpath
    public String getTextboxInSubjectDropDown() {
        return textboxInSubjectDropDown;
    }

    //Xpath
    public String getlinkInsideDropDown(String ElementID, String LinkText) {
        linkInsideDropDown = "//ul[@id='" + ElementID + "']//a[normalize-space(.)='" + LinkText + "']";
        return linkInsideDropDown;
    }

    //ID
    public String getSubjectID() {
        return subjectID;
    }

    //Css
    public String getCourseGroupDropDown() {
        return courseGroupDropDown;
    }

    //Xpath
    public String getTextboxInCourseGroupDropDown() {
        return textboxInCourseGroupDropDown;
    }

    //Xpath
    public String getCourseGroup(String Option) {
        courseGroup = "//ul[@id='selcoursegroups']//a[normalize-space(.)='" + Option + "']";
        return courseGroup;
    }

    //Css
    public String getCourseDropDown() {
        return courseDropDown;
    }

    //Xpath
    public String getTextboxInCourseDropDown() {
        return textboxInCourseDropDown;
    }

    //ID
    public String getCourseGroupID() {
        return courseGroupID;
    }

    //Xpath
    public String getCourse(String Option) {
        course = "//ul[@id='selcourses']//a[normalize-space(.)='" + Option + "']";
        return course;
    }

    //Css
    public String getDistrictName() {
        return districtName;
    }

    //Css
    public String getLinkPassageButton() {
        return linkPassageButton;
    }

    //Xpath
    public String getgradesSection() {
        return gradesSection;
    }

    //Xpath
    public String getlinkpassageModalHeader() {
        return linkpassageModalHeader;
    }

    //Xpath
    public String getPassageSearchTextbox() {
        return passageSearchTextbox;
    }

    //Css
    public String getBankDropDown() {
        return bankDropDown;
    }

    //Xpath
    public String getTextboxInBankDropDown() {
        return textboxInBankDropDown;
    }

    //Xpath
    public String getBankName(String Option) {
        bankName = "//ul[@id='selitembank']//a[normalize-space(.)='" + Option + "']";
        return bankName;
    }

    //Id
    public String getRefreshButton() {
        return refreshButton;
    }

    //Xpath
    public String getPassageSelectionCheckbox(String Passage) {
        passageSelectionCheckbox = "//a[normalize-space(.)='" + Passage + "']/parent::td/preceding-sibling::td/input";
        return passageSelectionCheckbox;
    }

    //Id
    public String getSelectButton() {
        return selectButton;
    }

    //Css
    public String getCancelButton() {
        return cancelButton;
    }

    //Css
    public String getCloseModalIcon() {
        return closeModalIcon;
    }

    //Xpath
    public String getLinkedPassage(String Passage) {
        linkedPassage = "//ul[@id='ulpassagenames']//span[normalize-space(.)='" + Passage + "']";
        return linkedPassage;
    }

    //ID
    public String getTeacherInstructionToggleButton() {
        return teacherInstructionToggleButton;
    }

    //Xpath
    public String getTeacherInstructionCKEditor() {
        return teacherInstructionCKEditor;
    }

    //Xpath
    public String getQuestionCKEditor() {
        return questionCKEditor;
    }

    //Xpath
    public String getSaveButton() {
        return saveButton;
    }

    //Css
    public String getNextButton() {
        return nextButton;
    }

    //ID
    public String getTotalPossiblePoints() {
        return totalPossiblePoints;
    }

    //Returns Class name of All option in drop down
    public WebElement getAllOptionClassName(String ID) {
        WebElement allOptionClassName;
        allOptionClassName = BrowserInitHelper.getInstance().findElement(By.xpath("//ul[@id='" + ID + "']//span[normalize-space(.)='All']/parent::a/parent::li"));
        return allOptionClassName;
    }

    //Xpath - # of Choices
    public String getnoOfChoicesDropDown() {
        return noOfChoicesDropDown;
    }

    public String getnoOfChoice(String value) {
        noOfChoices = "//ul[@id='selnoofchoice']//a[.='" + value + "']/span";
        return noOfChoices;
    }

    //Xpath - Type of Choices
    public String gettypeofChoicesDropDown() {
        return typeofChoicesDropDown;
    }

    public String gettypeofChoices(String value) {
        typeofChoices = "//ul[@id='seltype']//a[.='" + value + "']/span";
        return typeofChoices;
    }


    //Xpath - Answer Choice Format
    public String getanswerChoiceFormatDropDown() {
        return answerChoiceFormatDropDown;
    }

    public String getanswerChoice(String value) {
        answerChoice = "//ul[@id='selChoiceFormat']//a[.='" + value + "']/span";
        return answerChoice;
    }

    //ID
    public String getlockChoicesOrder() {
        return lockChoicesOrder;
    }

    //ID
    public String getincludeRationale() {
        return includeRationale;
    }

    //Xpath
    public String getnoChoicesSection() {
        return noChoicesSection;
    }

    //ID
    public String getanswerhint() {
        return answerhint;
    }

    //ID
    public String getanswerchoiceSection() {
        return answerchoiceSection;
    }


    public String getAnswerHintTextBox() {
        return answerhinttextbox;
    }

    //Returns Element of Add Standards tab option in drop down
    public WebElement getaddStandardsTab() {
        WebElement addStandardsTab;
        addStandardsTab = BrowserInitHelper.getInstance().findElement(By.xpath("//a[@id='getitemstandarddetails']"));
        return addStandardsTab;
    }

    public String getHisdVersionID(){
        return hisdVersionID;
    }

    public String getHisdVersionDropDown(){
        return hisdVersionDropDown;
    }

    public String getHisdVersionDropDownTextbox(){
        return hisdVersionDropDownTextbox;
    }

    public String getHisdQualifierTextbox(){
        return hisdQualifierTextbox;
    }

    public String getHisdGenerateItemName(){
        return hisdGenerateItemName;
    }
}
