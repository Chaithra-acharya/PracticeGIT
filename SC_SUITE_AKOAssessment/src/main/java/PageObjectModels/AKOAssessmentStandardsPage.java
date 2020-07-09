package PageObjectModels;

import Helpers.DriverHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AKOAssessmentStandardsPage {
    String noStandardsSelected, notAligned, searchStandardTextbox, searchIcon, saveButton, nextButton;
    String alertMessage, alertOKButton;

    private static String os = null;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;

    public AKOAssessmentStandardsPage(){
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("SC_SUITE_AKOAssessment", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + DriverHelper.getPath("\\Properties\\AKOAssessmentStandardsPage.properties"));
            } else {
                input = new FileInputStream(dir + "/Properties/AKOAssessmentStandardsPage.properties");
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

    public String getNoStandardsSelected(){
        noStandardsSelected = properties.getProperty("ASSESSMENTS_NO_STANDARDS_SELECTED");
        return noStandardsSelected;
    }

    public String getNotAligned(){
        notAligned = properties.getProperty("ASSESSMENTS_NOT_ALIGNED");
        return notAligned;
    }

    public String getSearchStandardTextbox(){
        searchStandardTextbox = properties.getProperty("ASSESSMENT_SEARCH_STANDARD_TEXTBOX");
        return searchStandardTextbox;
    }

    public String getSearchIcon(){
        searchIcon = properties.getProperty("ASSESSMENT_SEARCH_ICON");
        return searchIcon;
    }

    public String getSaveButton(){
        saveButton = properties.getProperty("ASSESSMENT_SAVE_BUTTON");
        return saveButton;
    }

    public String getAlertMessage(){
        alertMessage = properties.getProperty("ALERT_MESSAGE");
        return alertMessage;
    }

    public String getAlertOKButton(){
        alertOKButton = properties.getProperty("ALERT_OK_BUTTON");
        return alertOKButton;
    }

    public String getNextButton(){
        nextButton = properties.getProperty("ASSESSMENT_NEXT_BUTTON");
        return nextButton;
    }
}
