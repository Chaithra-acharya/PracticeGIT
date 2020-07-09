package Controllers;

import DataReader.CSVDataReaderAKOAssessment;
import Helpers.DriverHelper;
import PageObjectModels.ManageAssessmentsPage;

public class ManageAssessmentController {
    public static ManageAssessmentsPage manageAssessmentsPagePOM = new ManageAssessmentsPage();
    public static CSVDataReaderAKOAssessment csvDataReaderExpressAssesmentData = new CSVDataReaderAKOAssessment();
    DriverHelper Helper = new DriverHelper();

    public ManageAssessmentController() {
        csvDataReaderExpressAssesmentData.getCsv();
    }

    public static boolean deleteExistingAssessmentName(String AssessmentName) {
        boolean res = false;
        try {
            System.out.println("Entering Assessment Name");
            DriverHelper.sendKeysXpath(manageAssessmentsPagePOM.getAllTabsSearchTextBox(), AssessmentName);
            DriverHelper.clickXpath(manageAssessmentsPagePOM.getAllTabSearchButton());
            DriverHelper.waitUntilLoaderInvisible();

            try {
                String expressAssessmentName = DriverHelper.getReplacedLocator(AssessmentName, manageAssessmentsPagePOM.getAssessmentNamesResults());
                if (DriverHelper.verifyElementTextByXpath(expressAssessmentName, AssessmentName) == true) {
                    String expressAssessmentCheckBox = DriverHelper.getReplacedLocator(AssessmentName, manageAssessmentsPagePOM.getAssessmentNamesCheckBoxResults());
                    DriverHelper.clickXpath(expressAssessmentCheckBox);
                    String expressAssessmentDelete = DriverHelper.getReplacedLocator(AssessmentName, manageAssessmentsPagePOM.getAssessmentDeleteButton());
                    DriverHelper.clickXpath(expressAssessmentDelete);
                    if (DriverHelper.verifyDisplayByXpath(manageAssessmentsPagePOM.getAssessmentDeletePopUpHeader()) == true) {
                        DriverHelper.clickXpath(manageAssessmentsPagePOM.getAssessmentDeletePopUpDeleteButton());
                        if (DriverHelper.verifyDisplayByXpath(manageAssessmentsPagePOM.getAssessmentDeleteSuccessfully()) == true) {
                            DriverHelper.clickXpath(manageAssessmentsPagePOM.getAssessmentDeleteOk());
                            res = true;
                        }
                    }
                } else {
                    System.out.println("No Assessments Found displayed.");
                    res = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Exception handled for No AKO Assessment found");
                res = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception handled for deleteExistingAssessmentName");
        }
        return res;
    }
}
