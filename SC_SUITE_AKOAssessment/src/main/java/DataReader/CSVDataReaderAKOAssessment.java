package DataReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.csvreader.CsvReader;

public class CSVDataReaderAKOAssessment {
    String path = System.getProperty("user.dir");
    String CSVPath = path + "\\..\\dist\\Resources\\AKOTestData.csv";
    private String districtLevelAKOAssessmentName, campusLevelAKOAssessmentName, teacherLevelAKOAssessmentName, subject, collection, plc, setupMultipleGrades, grade, scheduleStudents, courseGroup, course, studentGroup;
    private String scheduleStudentsMultiGrade, scheduleGradeMultiGrade, standard, itemsCount;
    private String question1ItemType, question2ItemType, question3ItemType, question4ItemType, question5ItemType, question6ItemType, question7ItemType;
    private String answerChoice, typeOfChoice, points;
    private String mcItemTypeAnswerChoice, mrItemTypeAnswerChoice, crItemRubricPoints, crItemRubricMultiplier, mbItemAnswerChoice, nrItemAnswer, nrItemGriddableTemplate;
    private String ebsrSubItemType1, ebsrSubItemType2, ebsrSubItemType1AnswerChoice, ebsrSubItemType2AnswerChoice;
    private String skipPerformanceLevel, setupPerformanceLevelBy, plTemplateName;
    private String administrationWindow, scanning, onlineAnswerSheet, intendedUser, answerSheetTemplate, bubbleSize, answerSheetPrintingStartDate, scoringEndDate;
    private String addRubrics, teacherRubricType, studentRubricType, teacherRubricName, teacherRubric, studentRubricName, studentRubric;
    private String availableTeacherRubricName, availableStudentRubricName;
    private String enableBrowserLockDown, onlineSettings, durationToggle, durationHours, durationMins, defaultTimeIncrement, startTime, endTime, daysToSelect;
    public String propSelectAllCheckBox, propSelectAllLock, propSelectAllUnLock, pinVerificationLock, pinVerificationUnLock, autoActivationLock, autoActivationUnLock;
    public String pinVerificationCheckBox, reActivationLock, reActivationUnLock, autoActivationCheckBox, reActivationCheckBox,teacherIntendedUser;
    public String displayItemSPCheckBox, displayItemSPLock, displayItemSPUnLock, displayCorrAnsSPCheckBox, showRationaleIncorrectCheckBox, showStandards, groupItemsByStandards;
    public String displayTimerCheckBox, displayTimerLock, displaytimerUnLock, thermometerCheckBox, thermometerLock, thermometerUnLock;
    public String advCalcCheckBox, advCalcLock, advCalcUnLock, basicCalcCheckBox, basicCalcLock, basicCalcUnLock, scientificCalcCheckBox, scientificCalcLock, scientificCalcUnLock;
    public String equEditorLock, equEditorUnLock, advEquEditorCheckBox, advEquEditorLock, advEquEditorUnLock, algebraEditorCheckBox, algebraEditorLock, algebraEditorUnLock;
    public String trignometryEditorCheckBox, trignometryEditorLock, trignometryEditorUnLock, elimentaryEditorCheckBox, elimentaryEditorLock, elimentaryEditorUnLock;
    public String audioCheckBox, audioLock, audioUnLock, imageCheckBox, imageLock, imageUnLock, videoCheckBox, videoLock, videoUnLock;
    public String ansEliminatorCheckBox, ansEliminatorLock, ansEliminatorUnLock, graphCheckBox, graphLock, graphUnLock;
    public String lineReaderCheckBox, lineReaderLock, lineReaderUnLock, notesCheckBox, notesLock, notesUnLock, periodicTabCheckBox, periodicTabLock, periodicTabUnLock;
    public String protractorCheckBox, protractorLock, protractorUnLock, rulerCheckBox, rulerLock, rulerUnLock, spellCheckCheckBox, spellCheckLock, spellCheckUnLock;
    public String textMagnifierCheckBox, textMagnifierLock, textMagnifierUnLock;

    public Map<String, String> getCsv() {

        Map<String, String> Maprecords = new HashMap<String, String>();
        try {
            CsvReader readercsv = new CsvReader(CSVPath);
            readercsv.readHeaders();

            while (readercsv.readRecord()) {
                districtLevelAKOAssessmentName = readercsv.get("DistrictLevelAssessmentName");
                campusLevelAKOAssessmentName = readercsv.get("CampusLevelAssessmentName");
                teacherLevelAKOAssessmentName = readercsv.get("TeacherLevelAssessmentName");
                subject = readercsv.get("Subject");
                collection = readercsv.get("Collection");
                plc = readercsv.get("PLC");
                setupMultipleGrades = readercsv.get("Setup for Multiple Grades");
                grade = readercsv.get("Grade");
                scheduleStudents = readercsv.get("Student Selection When Setup for Multiple Grades is NO");
                scheduleStudentsMultiGrade = readercsv.get("Student Selection When Setup for Multiple Grades is YES");
                scheduleGradeMultiGrade = readercsv.get("Schedule Student GradeSelection when Multiple Grades is YES");
                courseGroup = readercsv.get("CourseGroup");
                course = readercsv.get("Course");
                studentGroup = readercsv.get("Student Group");
                standard = readercsv.get("Standard");

                itemsCount = readercsv.get("ItemsCount");
                question1ItemType = readercsv.get("Question1ItemType");
                question2ItemType = readercsv.get("Question2ItemType");
                question3ItemType = readercsv.get("Question3ItemType");
                question4ItemType = readercsv.get("Question4ItemType");
                question5ItemType = readercsv.get("Question5ItemType");
                question6ItemType = readercsv.get("Question6ItemType");
                question7ItemType = readercsv.get("Question7ItemType");
                mcItemTypeAnswerChoice = readercsv.get("MCItemAnswerChoice");
                mrItemTypeAnswerChoice = readercsv.get("MRItemAnswerChoice");
                crItemRubricPoints = readercsv.get("CRItemRubricPoints");
                crItemRubricMultiplier = readercsv.get("CRItemRubricMultiplier");
                mbItemAnswerChoice = readercsv.get("MBItemAnswerChoice");
                nrItemAnswer = readercsv.get("NRItemAnswer");
                nrItemGriddableTemplate = readercsv.get("NRItemGriddableTemplate");
                answerChoice = readercsv.get("Number of Choice");
                typeOfChoice = readercsv.get("Type Choice");
                points = readercsv.get("Points");

                ebsrSubItemType1 = readercsv.get("EBSRSubItemType1");
                ebsrSubItemType2 = readercsv.get("EBSRSubItemType2");
                ebsrSubItemType1AnswerChoice = readercsv.get("EBSRSubItemType1AnswerChoice");
                ebsrSubItemType2AnswerChoice = readercsv.get("EBSRSubItemType2AnswerChoice");

                skipPerformanceLevel = readercsv.get("Skip Performance Level");
                setupPerformanceLevelBy = readercsv.get("SetupPerformanceLevelBy");
                plTemplateName = readercsv.get("PLTemplateName");

                administrationWindow = readercsv.get("Administration Window");
                scanning = readercsv.get("Scanning");
                onlineAnswerSheet = readercsv.get("Online Answer Sheet");
                intendedUser = readercsv.get("Intended User");
                answerSheetTemplate = readercsv.get("Answer Sheet Template");

                addRubrics = readercsv.get("Add Rubrics");
                teacherRubricType = readercsv.get("Teacher Rubric Type");
                studentRubricType = readercsv.get("Student Rubric Type");
                teacherRubricName = readercsv.get("Teacher Rubric Name");
                teacherRubric = readercsv.get("Teacher Rubric");
                studentRubricName = readercsv.get("Student Rubric Name");
                studentRubric = readercsv.get("Student Rubric");
                availableTeacherRubricName = readercsv.get("Available Teacher Rubric Name");
                availableStudentRubricName = readercsv.get("Available Student Rubric Name");

                enableBrowserLockDown = readercsv.get("Enable Browser Lock Down");
                onlineSettings = readercsv.get("Online Settings");
                durationToggle = readercsv.get("Duration Toggle");
                durationHours = readercsv.get("Duration - Hours");
                durationMins = readercsv.get("Duration - Mins");
                defaultTimeIncrement = readercsv.get("Default Time Increment");
                startTime = readercsv.get("Start Time");
                endTime = readercsv.get("End Time");
                daysToSelect = readercsv.get("DAYS to SELECT");

                propSelectAllCheckBox = readercsv.get("Properties_SelectAll_CheckBox");
                propSelectAllLock = readercsv.get("Properties_SelectAll_Lock");
                propSelectAllUnLock = readercsv.get("Properties_SelectAll_Unlock");
                pinVerificationCheckBox = readercsv.get("PinVerification_CheckBox");
                pinVerificationLock = readercsv.get("PinVerification_Lock");
                pinVerificationUnLock = readercsv.get("PinVerification_Unlock");
                autoActivationLock = readercsv.get("AutoActivation_Lock");
                autoActivationUnLock = readercsv.get("AutoActivation_Unlock");
                reActivationLock = readercsv.get("AutoReActivation_Lock");
                reActivationUnLock = readercsv.get("AutoReActivation_Unlock");
                autoActivationCheckBox = readercsv.get("AutoActivation_CheckBox");
                reActivationCheckBox = readercsv.get("AutoReActivation_CheckBox");
                displayItemSPCheckBox = readercsv.get("DisplayItemsInSP_CheckBox");
                displayItemSPLock = readercsv.get("DisplayItemsInSP_Lock");
                displayItemSPUnLock = readercsv.get("DisplayItemsInSP_Unlock");
                displayCorrAnsSPCheckBox = readercsv.get("DisplayCorrectAnswersSP_CheckBox");
                showRationaleIncorrectCheckBox = readercsv.get("ShowRationaleIncorrectItems_CheckBox");
                showStandards = readercsv.get("Show Standards");
                groupItemsByStandards = readercsv.get("Group Items by Standard");
                displayTimerCheckBox = readercsv.get("DisplayTimer_CheckBox");
                displayTimerLock = readercsv.get("DisplayTimer_Lock");
                displaytimerUnLock = readercsv.get("DisplayTimer_Unlock");
                thermometerCheckBox = readercsv.get("Thermometer_CheckBox");
                thermometerLock = readercsv.get("Thermometer_Lock");
                thermometerUnLock = readercsv.get("Thermometer_Unlock");
                advCalcCheckBox = readercsv.get("AdvanceCalc_CheckBox");
                advCalcLock = readercsv.get("AdvanceCalc_Lock");
                advCalcUnLock = readercsv.get("AdvanceCalc_UnLock");
                basicCalcCheckBox = readercsv.get("BasicCalc_CheckBox");
                basicCalcLock = readercsv.get("BasicCalc_Lock");
                basicCalcUnLock = readercsv.get("BasicCalc_UnLock");
                scientificCalcCheckBox = readercsv.get("ScientificCalc_CheckBox");
                scientificCalcLock = readercsv.get("ScientificCalc_Lock");
                scientificCalcUnLock = readercsv.get("ScientificCalc_UnLock");
                equEditorLock = readercsv.get("EquationEditor_Lock");
                equEditorUnLock = readercsv.get("EquationEditor_UnLock");
                advEquEditorCheckBox = readercsv.get("AdvEquEditor_CheckBox");
                advEquEditorLock = readercsv.get("AdvEquEditor_Lock");
                advEquEditorUnLock = readercsv.get("AdvEquEditor_UnLock");
                algebraEditorCheckBox = readercsv.get("AlgebraEditor_CheckBox");
                algebraEditorLock = readercsv.get("AlgebraEditor_Lock");
                algebraEditorUnLock = readercsv.get("AlgebraEditor_Unlock");
                trignometryEditorCheckBox = readercsv.get("AlgTrignometry_CheckBox");
                trignometryEditorLock = readercsv.get("AlgTrignometry_Lock");
                trignometryEditorUnLock = readercsv.get("AlgTrignometry_Unlock");
                elimentaryEditorCheckBox = readercsv.get("ElementryEditor_CkeckBox");
                elimentaryEditorLock = readercsv.get("ElementryEditor_Lock");
                elimentaryEditorUnLock = readercsv.get("ElementryEditor_Unlock");
                audioCheckBox = readercsv.get("Audio_CheckBox");
                audioLock = readercsv.get("Audio_Lock");
                audioUnLock = readercsv.get("Audio_UnLock");
                imageCheckBox = readercsv.get("Image_CheckBox");
                imageLock = readercsv.get("Image_Lock");
                imageUnLock = readercsv.get("Image_UnLock");
                videoCheckBox = readercsv.get("Video_CheckBox");
                videoLock = readercsv.get("Video_Lock");
                videoUnLock = readercsv.get("Video_Unlock");
                ansEliminatorCheckBox = readercsv.get("AnsEliminator_CheckBox");
                ansEliminatorLock = readercsv.get("AnsEliminator_Lock");
                ansEliminatorUnLock = readercsv.get("AnsEliminator_Unlock");
                graphCheckBox = readercsv.get("Graph_CheckBox");
                graphLock = readercsv.get("Graph_Lock");
                graphUnLock = readercsv.get("Graph_Unlock");
                lineReaderCheckBox = readercsv.get("LineReader_CheckBox");
                lineReaderLock = readercsv.get("LineReader_Lock");
                lineReaderUnLock = readercsv.get("LineReader_Unlock");
                notesCheckBox = readercsv.get("Notes_CheckBox");
                notesLock = readercsv.get("Notes_Lock");
                notesUnLock = readercsv.get("Notes_Unlock");
                periodicTabCheckBox = readercsv.get("PeriodicTable_CheckBox");
                periodicTabLock = readercsv.get("PeriodicTable_Lock");
                periodicTabUnLock = readercsv.get("PeriodicTable_Unlock");
                protractorCheckBox = readercsv.get("Protractor_CheckBox");
                protractorLock = readercsv.get("Protractor_Lock");
                protractorUnLock = readercsv.get("Protractor_Unlock");
                rulerCheckBox = readercsv.get("Ruler_CheckBox");
                rulerLock = readercsv.get("Ruler_Lock");
                rulerUnLock = readercsv.get("Ruler_Unlock");
                spellCheckCheckBox = readercsv.get("SpellCheck_CheckBox");
                spellCheckLock = readercsv.get("SpellCheck_Lock");
                spellCheckUnLock = readercsv.get("SpellCheck_Unlock");
                textMagnifierCheckBox = readercsv.get("TextMagnifier_CheckBox");
                textMagnifierLock = readercsv.get("TextMagnifier_Lock");
                textMagnifierUnLock = readercsv.get("TextMagnifier_Unlock");

                bubbleSize = readercsv.get("Bubble Size");
                answerSheetPrintingStartDate = readercsv.get("Answer Sheet Printing Start Date");
                scoringEndDate = readercsv.get("Scoring End Date");

                Maprecords.put("DistrictLevelAssessmentName", districtLevelAKOAssessmentName);
                Maprecords.put("CampusLevelAssessmentName", campusLevelAKOAssessmentName);
                Maprecords.put("TeacherLevelAssessmentName", teacherLevelAKOAssessmentName);
                Maprecords.put("Subject", subject);
                Maprecords.put("Collection", collection);
                Maprecords.put("PLC", plc);
                Maprecords.put("Setup for Multiple Grades", setupMultipleGrades);
                Maprecords.put("Grade", grade);
                Maprecords.put("Student Selection When Setup for Multiple Grades is NO", scheduleStudents);
                Maprecords.put("Student Selection When Setup for Multiple Grades is YES", scheduleStudentsMultiGrade);
                Maprecords.put("Schedule Student GradeSelection when Multiple Grades is YES", scheduleGradeMultiGrade);
                Maprecords.put("CourseGroup", courseGroup);
                Maprecords.put("Grade", grade);
                Maprecords.put("CourseGroup", courseGroup);
                Maprecords.put("Course", course);
                Maprecords.put("Student Group", studentGroup);
                Maprecords.put("Standard", standard);
                Maprecords.put("ItemsCount", itemsCount);
                Maprecords.put("Question1ItemType", question1ItemType);
                Maprecords.put("Question2ItemType", question2ItemType);
                Maprecords.put("Question3ItemType", question3ItemType);
                Maprecords.put("Question4ItemType", question4ItemType);
                Maprecords.put("Question5ItemType", question5ItemType);
                Maprecords.put("Question6ItemType", question6ItemType);
                Maprecords.put("Question7ItemType", question7ItemType);
                Maprecords.put("MCItemAnswerChoice", mcItemTypeAnswerChoice);
                Maprecords.put("MRItemAnswerChoice", mrItemTypeAnswerChoice);
                Maprecords.put("CRItemRubricPoints", crItemRubricPoints);
                Maprecords.put("CRItemRubricMultiplier", crItemRubricMultiplier);
                Maprecords.put("MBItemAnswerChoice", mbItemAnswerChoice);
                Maprecords.put("NRItemAnswer", nrItemAnswer);
                Maprecords.put("NRItemGriddableTemplate", nrItemGriddableTemplate);
                Maprecords.put("EBSRSubItemType1", ebsrSubItemType1);
                Maprecords.put("EBSRSubItemType2", ebsrSubItemType2);
                Maprecords.put("EBSRSubItemType1AnswerChoice", ebsrSubItemType1AnswerChoice);
                Maprecords.put("EBSRSubItemType2AnswerChoice", ebsrSubItemType2AnswerChoice);
                Maprecords.put("Number of Choice", answerChoice);
                Maprecords.put("Type Choice", typeOfChoice);
                Maprecords.put("Points", points);

                Maprecords.put("Skip Performance Level", skipPerformanceLevel);
                Maprecords.put("SetupPerformanceLevelBy", setupPerformanceLevelBy);
                Maprecords.put("PLTemplateName", plTemplateName);

                Maprecords.put("Administration Window", administrationWindow);
                Maprecords.put("Scanning", scanning);
                Maprecords.put("Online Answer Sheet", onlineAnswerSheet);
                Maprecords.put("Intended User", intendedUser);

                Maprecords.put("Add Rubrics", addRubrics);
                Maprecords.put("Teacher Rubric Type", teacherRubricType);
                Maprecords.put("Student Rubric Type", studentRubricType);
                Maprecords.put("Teacher Rubric Name", teacherRubricName);
                Maprecords.put("Teacher Rubric", teacherRubric);
                Maprecords.put("Student Rubric Name", studentRubricName);
                Maprecords.put("Student Rubric", studentRubric);
                Maprecords.put("Available Teacher Rubric Name", availableTeacherRubricName);
                Maprecords.put("Available Student Rubric Name", availableStudentRubricName);

                Maprecords.put("Enable Browser Lock Down", enableBrowserLockDown);
                Maprecords.put("Online Settings", onlineSettings);
                Maprecords.put("Duration Toggle", durationToggle);
                Maprecords.put("Duration - Hours", durationHours);
                Maprecords.put("Duration - Mins", durationMins);
                Maprecords.put("Default Time Increment", defaultTimeIncrement);
                Maprecords.put("Start Time", startTime);
                Maprecords.put("End Time", endTime);
                Maprecords.put("DAYS to SELECT", daysToSelect);

                Maprecords.put("DisplayItemsInSP_CheckBox", displayItemSPCheckBox);
                Maprecords.put("DisplayItemsInSP_Lock", displayItemSPLock);
                Maprecords.put("DisplayItemsInSP_Unlock", displayItemSPUnLock);

                Maprecords.put("TextMagnifier_CheckBox", textMagnifierCheckBox);
                Maprecords.put("TextMagnifier_Lock", textMagnifierLock);
                Maprecords.put("TextMagnifier_Unlock", textMagnifierUnLock);
                Maprecords.put("SpellCheck_CheckBox", spellCheckCheckBox);
                Maprecords.put("SpellCheck_Lock", spellCheckLock);
                Maprecords.put("SpellCheck_Unlock", spellCheckUnLock);
                Maprecords.put("Ruler_CheckBox", rulerCheckBox);
                Maprecords.put("Ruler_Lock", rulerLock);
                Maprecords.put("Ruler_Unlock", rulerUnLock);
                Maprecords.put("Protractor_CheckBox", protractorCheckBox);
                Maprecords.put("Protractor_Lock", protractorLock);
                Maprecords.put("Protractor_Unlock", protractorUnLock);
                Maprecords.put("PeriodicTable_CheckBox", periodicTabCheckBox);
                Maprecords.put("PeriodicTable_Lock", periodicTabLock);
                Maprecords.put("PeriodicTable_Unlock", periodicTabUnLock);
                Maprecords.put("Notes_CheckBox", notesCheckBox);
                Maprecords.put("Notes_Lock", notesLock);
                Maprecords.put("Notes_Unlock", notesUnLock);
                Maprecords.put("LineReader_CheckBox", lineReaderCheckBox);
                Maprecords.put("LineReader_Lock", lineReaderLock);
                Maprecords.put("LineReader_Unlock", lineReaderUnLock);
                Maprecords.put("Graph_CheckBox", graphCheckBox);
                Maprecords.put("Graph_Lock", graphLock);
                Maprecords.put("Graph_Unlock", graphUnLock);
                Maprecords.put("AnsEliminator_CheckBox", ansEliminatorCheckBox);
                Maprecords.put("AnsEliminator_Lock", ansEliminatorLock);
                Maprecords.put("AnsEliminator_Unlock", ansEliminatorUnLock);
                Maprecords.put("Video_CheckBox", videoCheckBox);
                Maprecords.put("Video_Lock", videoLock);
                Maprecords.put("Video_Unlock", videoUnLock);
                Maprecords.put("Image_CheckBox", imageCheckBox);
                Maprecords.put("Image_Lock", imageLock);
                Maprecords.put("Image_UnLock", imageUnLock);
                Maprecords.put("Audio_CheckBox", audioCheckBox);
                Maprecords.put("Audio_Lock", audioLock);
                Maprecords.put("Audio_UnLock", audioUnLock);
                Maprecords.put("ElementryEditor_CkeckBox", elimentaryEditorCheckBox);
                Maprecords.put("ElementryEditor_Lock", elimentaryEditorLock);
                Maprecords.put("ElementryEditor_Unlock", elimentaryEditorUnLock);
                Maprecords.put("AlgTrignometry_CheckBox", trignometryEditorCheckBox);
                Maprecords.put("AlgTrignometry_Lock", trignometryEditorLock);
                Maprecords.put("AlgTrignometry_Unlock", trignometryEditorUnLock);
                Maprecords.put("AlgebraEditor_CheckBox", algebraEditorCheckBox);
                Maprecords.put("AlgebraEditor_Lock", algebraEditorLock);
                Maprecords.put("AlgebraEditor_Unlock", algebraEditorUnLock);
                Maprecords.put("AdvEquEditor_CheckBox", advEquEditorCheckBox);
                Maprecords.put("AdvEquEditor_Lock", advEquEditorLock);
                Maprecords.put("AdvEquEditor_UnLock", advEquEditorUnLock);
                Maprecords.put("EquationEditor_Lock", equEditorLock);
                Maprecords.put("EquationEditor_UnLock", equEditorUnLock);
                Maprecords.put("ScientificCalc_CheckBox", scientificCalcCheckBox);
                Maprecords.put("ScientificCalc_Lock", scientificCalcLock);
                Maprecords.put("ScientificCalc_UnLock", scientificCalcUnLock);
                Maprecords.put("BasicCalc_CheckBox", basicCalcCheckBox);
                Maprecords.put("BasicCalc_Lock", basicCalcLock);
                Maprecords.put("BasicCalc_UnLock", basicCalcUnLock);
                Maprecords.put("AdvanceCalc_CheckBox", advCalcCheckBox);
                Maprecords.put("AdvanceCalc_Lock", advCalcLock);
                Maprecords.put("AdvanceCalc_UnLock", advCalcUnLock);
                Maprecords.put("Thermometer_CheckBox", thermometerCheckBox);
                Maprecords.put("Thermometer_Lock", thermometerLock);
                Maprecords.put("Thermometer_Unlock", thermometerUnLock);
                Maprecords.put("DisplayTimer_CheckBox", displayTimerCheckBox);
                Maprecords.put("DisplayTimer_Lock", displayTimerLock);
                Maprecords.put("DisplayTimer_Unlock", displaytimerUnLock);
                Maprecords.put("DisplayCorrectAnswersSP_CheckBox", displayCorrAnsSPCheckBox);
                Maprecords.put("ShowRationaleIncorrectItems_CheckBox", showRationaleIncorrectCheckBox);
                Maprecords.put("Show Standards", showStandards);
                Maprecords.put("Group Items by Standard", groupItemsByStandards);
                Maprecords.put("AutoReActivation_Unlock", reActivationUnLock);
                Maprecords.put("AutoReActivation_Lock", reActivationLock);
                Maprecords.put("AutoActivation_Unlock", autoActivationUnLock);
                Maprecords.put("AutoActivation_Lock", autoActivationLock);
                Maprecords.put("AutoActivation_CheckBox", autoActivationCheckBox);
                Maprecords.put("AutoReActivation_CheckBox", reActivationCheckBox);
                Maprecords.put("PinVerification_CheckBox", pinVerificationCheckBox);
                Maprecords.put("PinVerification_Unlock", pinVerificationUnLock);
                Maprecords.put("PinVerification_Lock", pinVerificationLock);
                Maprecords.put("Properties_SelectAll_CheckBox", propSelectAllCheckBox);
                Maprecords.put("Properties_SelectAll_Unlock", propSelectAllUnLock);
                Maprecords.put("Properties_SelectAll_Lock", propSelectAllLock);
                Maprecords.put("Duration_Toggle", durationToggle);
                Maprecords.put("EnableBrowserLockDown", enableBrowserLockDown);
                Maprecords.put("TeacherIntendedUser", teacherIntendedUser);

                Maprecords.put("Answer Sheet Template", answerSheetTemplate);
                Maprecords.put("Bubble Size", bubbleSize);
                Maprecords.put("Answer Sheet Printing Start Date", answerSheetPrintingStartDate);
                Maprecords.put("Scoring End Date", scoringEndDate);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Maprecords;
    }

    public String getDistrictLevelAKOAssessmentName(){
        return districtLevelAKOAssessmentName;
    }

    public String getCampusLevelAKOAssessmentName(){
        return campusLevelAKOAssessmentName;
    }

    public String getTeacherLevelAKOAssessmentName(){
        return teacherLevelAKOAssessmentName;
    }

    public String getSubject(){
        return subject;
    }

    public String getCollection(){
        return collection;
    }

    public String getPlc(){
        return plc;
    }

    public String getSetupMultipleGrades(){
        return setupMultipleGrades;
    }

    public String getScheduleStudents(){
        return scheduleStudents;
    }

    public String getGrade(){
        return grade;
    }

    public String getScheduleStudentsMultiGrade(){
        return scheduleStudentsMultiGrade;
    }

    public String getScheduleGradeMultiGrade(){
        return scheduleGradeMultiGrade;
    }

    public String getCourseGroup(){
        return courseGroup;
    }

    public String getCourse(){
        return course;
    }

    public String getStudentGroup(){
        return studentGroup;
    }

    public String getStandard(){
        return standard;
    }

    public String getItemsCount(){
        return itemsCount;
    }

    public String getQuestion1ItemType(){
        return question1ItemType;
    }

    public String getQuestion2ItemType(){
        return question2ItemType;
    }

    public String getQuestion3ItemType(){
        return question3ItemType;
    }

    public String getQuestion4ItemType(){
        return question4ItemType;
    }

    public String getQuestion5ItemType(){
        return question5ItemType;
    }

    public String getQuestion6ItemType(){
        return question6ItemType;
    }

    public String getQuestion7ItemType(){
        return question7ItemType;
    }

    public String getMcItemTypeAnswerChoice(){
        return mcItemTypeAnswerChoice;
    }

    public String getMrItemTypeAnswerChoice(){
        return mrItemTypeAnswerChoice;
    }

    public String getCrItemRubricPoints(){
        return crItemRubricPoints;
    }

    public String getCrItemRubricMultiplier(){
        return crItemRubricMultiplier;
    }

    public String getMbItemAnswerChoice(){
        return mbItemAnswerChoice;
    }

    public String getNrItemAnswer(){
        return nrItemAnswer;
    }

    public String getNrItemGriddableTemplate(){
        return nrItemGriddableTemplate;
    }

    public String getEbsrSubItemType1(){
        return ebsrSubItemType1;
    }

    public String getEbsrSubItemType2(){
        return ebsrSubItemType2;
    }

    public String getEbsrSubItemType1AnswerChoice(){
        return ebsrSubItemType1AnswerChoice;
    }

    public String getEbsrSubItemType2AnswerChoice(){
        return ebsrSubItemType2AnswerChoice;
    }

    public String getAnswerChoice(){
        return answerChoice;
    }

    public String getTypeOfChoice(){
        return typeOfChoice;
    }

    public String getPoints(){
        return points;
    }

    public String getSkipPerformanceLevel(){
        return skipPerformanceLevel;
    }

    public String getSetupPerformanceLevelBy(){
        return setupPerformanceLevelBy;
    }

    public String getPlTemplateName(){
        return plTemplateName;
    }

    public String getAdministrationWindow(){
        return administrationWindow;
    }

    public String getScanning(){
        return scanning;
    }

    public String getOnlineAnswerSheet(){
        return onlineAnswerSheet;
    }

    public String getIntendedUser(){
        return intendedUser;
    }

    public String getAddRubrics(){
        return addRubrics;
    }

    public String getTeacherRubricType(){
        return teacherRubricType;
    }

    public String getStudentRubricType(){
        return studentRubricType;
    }

    public String getTeacherRubricName(){
        return teacherRubricName;
    }

    public String getTeacherRubric(){
        return teacherRubric;
    }

    public String getStudentRubricName(){
        return studentRubricName;
    }

    public String getStudentRubric(){
        return studentRubric;
    }

    public String getAvailableTeacherRubricName(){
        return availableTeacherRubricName;
    }

    public String getAvailableStudentRubricName(){
        return availableStudentRubricName;
    }

    public String getEnableBrowserLockDown(){
        return enableBrowserLockDown;
    }

    public String getOnlineSettings(){
        return onlineSettings;
    }

    public String getDurationToggle(){
        return durationToggle;
    }

    public String getDurationHours(){
        return durationHours;
    }

    public String getDurationMins(){
        return durationMins;
    }

    public String getDefaultTimeIncrement(){
        System.out.println("defaultTimeIncrement: "+defaultTimeIncrement);
        return defaultTimeIncrement;
    }

    public String getStartTime(){
        return startTime;
    }

    public String getEndTime(){
        return endTime;
    }

    public String getDaysToSelect(){
        return daysToSelect;
    }

    public String getTextMagnifierCheckBox() {
        textMagnifierCheckBox = getCsv().get("TextMagnifier_CheckBox");
        return textMagnifierCheckBox;
    }
    public String getTextMagnifierLock() {
        textMagnifierLock = getCsv().get("TextMagnifier_Lock");
        return textMagnifierLock;
    }

    public String getTextMagnifierUnLock() {
        textMagnifierUnLock = getCsv().get("TextMagnifier_Unlock");
        return textMagnifierUnLock;
    }

    public String getSpellCheckCheckBox() {
        spellCheckCheckBox = getCsv().get("SpellCheck_CheckBox");
        return spellCheckCheckBox;
    }

    public String getSpellCheckLock() {
        spellCheckLock = getCsv().get("SpellCheck_Lock");
        return spellCheckLock;
    }

    public String getSpellCheckUnLock() {
        spellCheckUnLock = getCsv().get("SpellCheck_Unlock");
        return spellCheckUnLock;
    }

    public String getRulerCheckBox() {
        rulerCheckBox = getCsv().get("Ruler_CheckBox");
        return rulerCheckBox;
    }

    public String getRulerLock() {
        rulerLock = getCsv().get("Ruler_Lock");
        return rulerLock;
    }

    public String getRulerUnLock() {
        rulerUnLock = getCsv().get("Ruler_Unlock");
        return rulerUnLock;
    }

    public String getProtractorCheckBox() {
        protractorCheckBox = getCsv().get("Protractor_CheckBox");
        return protractorCheckBox;
    }

    public String getProtractorLock() {
        protractorLock = getCsv().get("Protractor_Lock");
        return protractorLock;
    }

    public String getProtractorUnLock() {
        protractorUnLock = getCsv().get("Protractor_Unlock");
        return protractorUnLock;
    }

    public String getPeriodicTableCheckBox() {
        periodicTabCheckBox = getCsv().get("PeriodicTable_CheckBox");
        return periodicTabCheckBox;
    }

    public String getPeriodicTableLock() {
        periodicTabLock = getCsv().get("PeriodicTable_Lock");
        return periodicTabLock;
    }

    public String getPeriodicTableUnLock() {
        periodicTabUnLock = getCsv().get("PeriodicTable_Unlock");
        return periodicTabUnLock;
    }

    public String getNotesCheckBox() {
        notesCheckBox = getCsv().get("Notes_CheckBox");
        return notesCheckBox;
    }

    public String getNotesLock() {
        notesLock = getCsv().get("Notes_Lock");
        return notesLock;
    }

    public String getNotesUnLock() {
        notesUnLock = getCsv().get("Notes_Unlock");
        return notesUnLock;
    }

    public String getLineReaderCheckBox() {
        lineReaderCheckBox = getCsv().get("LineReader_CheckBox");
        return lineReaderCheckBox;
    }

    public String getLineReaderLock() {
        lineReaderLock = getCsv().get("LineReader_Lock");
        return lineReaderLock;
    }

    public String getLineReaderUnLock() {
        lineReaderUnLock = getCsv().get("LineReader_Unlock");
        return lineReaderUnLock;
    }

    public String getGraphCheckBox() {
        graphCheckBox = getCsv().get("Graph_CheckBox");
        return graphCheckBox;
    }

    public String getGraphLock() {
        graphLock = getCsv().get("Graph_Lock");
        return graphLock;
    }

    public String getGraphUnLock() {
        graphUnLock = getCsv().get("Graph_Unlock");
        return graphUnLock;
    }

    public String getAnsEliminatorCheckBox() {
        ansEliminatorCheckBox = getCsv().get("AnsEliminator_CheckBox");
        return ansEliminatorCheckBox;
    }

    public String getAnsEliminatorLock() {
        ansEliminatorLock = getCsv().get("AnsEliminator_Lock");
        return ansEliminatorLock;
    }

    public String getAnsEliminatorUnLock() {
        ansEliminatorUnLock = getCsv().get("AnsEliminator_Unlock");
        return ansEliminatorUnLock;
    }

    public String getVideoCheckBox() {
        videoCheckBox = getCsv().get("Video_CheckBox");
        return videoCheckBox;
    }

    public String getVideoLock() {
        videoLock = getCsv().get("Video_Lock");
        return videoLock;
    }

    public String getVideoUnLock() {
        videoUnLock = getCsv().get("Video_Unlock");
        return videoUnLock;
    }

    public String getImageCheckBox() {
        audioCheckBox = getCsv().get("Image_CheckBox");
        return audioCheckBox;
    }

    public String getImageLock() {
        audioLock = getCsv().get("Image_Lock");
        return audioLock;
    }

    public String getImageUnLock() {
        audioUnLock = getCsv().get("Image_UnLock");
        return audioUnLock;
    }

    public String getAudioCheckBox() {
        audioCheckBox = getCsv().get("Audio_CheckBox");
        return audioCheckBox;
    }

    public String getAudioLock() {
        audioLock = getCsv().get("Audio_Lock");
        return audioLock;
    }

    public String getAudioUnLock() {
        audioUnLock = getCsv().get("Audio_UnLock");
        return audioUnLock;
    }

    public String getElementaryEditorCheckBox() {
        elimentaryEditorCheckBox = getCsv().get("ElementryEditor_CkeckBox");
        return elimentaryEditorCheckBox;
    }

    public String getElementaryEditorLock() {
        elimentaryEditorLock = getCsv().get("ElementryEditor_Lock");
        return elimentaryEditorLock;
    }

    public String getElementaryEditorUnLock() {
        elimentaryEditorUnLock = getCsv().get("ElementryEditor_Unlock");
        return elimentaryEditorUnLock;
    }

    public String getTrignometryEditorCheckBox() {
        trignometryEditorCheckBox = getCsv().get("AlgTrignometry_CheckBox");
        return trignometryEditorCheckBox;
    }

    public String getTrignometryEditorLock() {
        trignometryEditorLock = getCsv().get("AlgTrignometry_Lock");
        return trignometryEditorLock;
    }

    public String getTrignometryEditorUnLock() {
        trignometryEditorUnLock = getCsv().get("AlgTrignometry_Unlock");
        return trignometryEditorUnLock;
    }

    public String getAlgebraEditorCheckBox() {
        algebraEditorCheckBox = getCsv().get("AlgebraEditor_CheckBox");
        return algebraEditorCheckBox;
    }

    public String getAlgebraEditorLock() {
        algebraEditorLock = getCsv().get("AlgebraEditor_Lock");
        return algebraEditorLock;
    }

    public String getAlgebraEditorUnLock() {
        algebraEditorUnLock = getCsv().get("AlgebraEditor_Unlock");
        return algebraEditorUnLock;
    }

    public String getAdvEquEditorCheckBox() {
        advEquEditorCheckBox = getCsv().get("AdvEquEditor_CheckBox");
        return advEquEditorCheckBox;
    }

    public String getAdvEquEditorLock() {
        advEquEditorLock = getCsv().get("AdvEquEditor_Lock");
        return advEquEditorLock;
    }

    public String getAdvEquEditorUnLock() {
        advEquEditorUnLock = getCsv().get("AdvEquEditor_UnLock");
        return advEquEditorUnLock;
    }

    public String getEquEditorLock() {
        equEditorLock = getCsv().get("EquationEditor_Lock");
        return equEditorLock;
    }

    public String getEquEditorUnLock() {
        equEditorUnLock = getCsv().get("EquationEditor_UnLock");
        return equEditorUnLock;
    }

    public String getScientificCalcCheckBox() {
        scientificCalcCheckBox = getCsv().get("ScientificCalc_CheckBox");
        return scientificCalcCheckBox;
    }

    public String getScientificCalcLock() {
        scientificCalcLock = getCsv().get("ScientificCalc_Lock");
        return scientificCalcLock;
    }

    public String getScientificCalcUnLock() {
        scientificCalcUnLock = getCsv().get("ScientificCalc_UnLock");
        return scientificCalcUnLock;
    }

    public String getBasicCalcCheckBox() {
        basicCalcCheckBox = getCsv().get("BasicCalc_CheckBox");
        return basicCalcCheckBox;
    }

    public String getBasicCalcLock() {
        basicCalcLock = getCsv().get("BasicCalc_Lock");
        return basicCalcLock;
    }

    public String getBasicCalcUnLock() {
        basicCalcUnLock = getCsv().get("BasicCalc_UnLock");
        return basicCalcUnLock;
    }

    public String getAdvCalcCheckBox() {
        advCalcCheckBox = getCsv().get("AdvanceCalc_CheckBox");
        return advCalcCheckBox;
    }

    public String getAdvCalcLock() {
        advCalcLock = getCsv().get("AdvanceCalc_Lock");
        return advCalcLock;
    }

    public String getAdvCalcUnLock() {
        advCalcUnLock = getCsv().get("AdvanceCalc_UnLock");
        return advCalcUnLock;
    }

    public String getThermometerCheckBox() {
        thermometerCheckBox = getCsv().get("Thermometer_CheckBox");
        return thermometerCheckBox;
    }

    public String getThermometerLock() {
        thermometerLock = getCsv().get("Thermometer_Lock");
        return thermometerLock;
    }

    public String getThermometerUnLock() {
        thermometerUnLock = getCsv().get("Thermometer_Unlock");
        return thermometerUnLock;
    }

    public String getDisplayTimerCheckBox() {
        displayTimerCheckBox = getCsv().get("DisplayTimer_CheckBox");
        return displayTimerCheckBox;
    }

    public String getDisplayTimerLock() {
        displayTimerLock = getCsv().get("DisplayTimer_Lock");
        return displayTimerLock;
    }

    public String getDisplaytimerUnLock() {
        displaytimerUnLock = getCsv().get("DisplayTimer_Unlock");
        return displaytimerUnLock;
    }

    public String getDisplayCorrAnsSPCheckBox() {
        displayCorrAnsSPCheckBox = getCsv().get("DisplayCorrectAnswersSP_CheckBox");
        return displayCorrAnsSPCheckBox;
    }

    public String getShowRationaleIncorrectCheckBox() {
        showRationaleIncorrectCheckBox = getCsv().get("ShowRationaleIncorrectItems_CheckBox");
        return showRationaleIncorrectCheckBox;
    }

    public String getDisplayItemSPUnLock() {
        displayItemSPUnLock = getCsv().get("DisplayItemsInSP_Unlock");
        System.out.println("displayItemSPUnLock in CSV: "+displayItemSPUnLock);
        return displayItemSPUnLock;
    }

    public String getDisplayItemSPLock() {
        displayItemSPLock = getCsv().get("DisplayItemsInSP_Lock");
        System.out.println("displayItemSPLock in CSV: "+displayItemSPLock);
        return displayItemSPLock;
    }

    public String getDisplayItemSPCheckBox() {
        displayItemSPCheckBox = getCsv().get("DisplayItemsInSP_CheckBox");
        System.out.println("displayItemSPCheckBox in CSV: "+displayItemSPCheckBox);
        return displayItemSPCheckBox;
    }

    public String getReActivationLock() {
        reActivationLock = getCsv().get("AutoReActivation_Lock");
        return reActivationLock;
    }

    public String getAutoActivationCheckBox() {
        autoActivationCheckBox = getCsv().get("AutoActivation_CheckBox");
        return autoActivationCheckBox;
    }

    public String getReActivationCheckBox() {
        reActivationCheckBox = getCsv().get("AutoReActivation_CheckBox");
        return reActivationCheckBox;
    }

    public String getReActivationUnLock() {
        reActivationUnLock = getCsv().get("AutoReActivation_Unlock");
        return reActivationUnLock;
    }

    public String getAutoActivationLock() {
        autoActivationLock = getCsv().get("AutoActivation_Lock");
        return autoActivationLock;
    }

    public String getPinVerificationCheckBox() {
        pinVerificationCheckBox = getCsv().get("PinVerification_CheckBox");
        return pinVerificationCheckBox;
    }

    public String getAutoActivationUnLock() {
        autoActivationUnLock = getCsv().get("AutoActivation_Unlock");
        return autoActivationUnLock;
    }

    public String getPinVerificationUnLock() {
        pinVerificationUnLock = getCsv().get("PinVerification_Unlock");
        return pinVerificationUnLock;
    }

    public String getPinVerificationLock() {
        pinVerificationLock = getCsv().get("PinVerification_Lock");
        return pinVerificationLock;
    }

    public String getPropSelectAllUnLock() {
        propSelectAllUnLock = getCsv().get("Properties_SelectAll_Unlock");
        return propSelectAllUnLock;
    }

    public String getPropSelectAllCheckBox() {
        propSelectAllCheckBox = getCsv().get("Properties_SelectAll_CheckBox");
        return propSelectAllCheckBox;
    }

    public String getPropSelectAllLock() {
        propSelectAllLock = getCsv().get("Properties_SelectAll_Lock");
        return propSelectAllLock;
    }

    public String getShowStandards(){
        showStandards = getCsv().get("Show Standards");
        return showStandards;
    }

    public String getGroupItemsByStandards(){
        groupItemsByStandards = getCsv().get("Group Items by Standard");
        return groupItemsByStandards;
    }

    public String getDuration_Toggle() {
        durationToggle = getCsv().get("Duration_Toggle");
        return durationToggle;
    }

    public String getAnswerSheetTemplate(){
        return answerSheetTemplate;
    }

    public String getAnswerSheetPrintingStartDate(){
        return answerSheetPrintingStartDate;
    }

    public String getBubbleSize(){
        return bubbleSize;
    }

    public String getScoringEndDate(){
        return scoringEndDate;
    }
}
