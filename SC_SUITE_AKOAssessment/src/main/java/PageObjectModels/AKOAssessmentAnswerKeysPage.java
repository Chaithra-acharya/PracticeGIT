package PageObjectModels;

import Helpers.DriverHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AKOAssessmentAnswerKeysPage {
    private String numberOfItemsTextbox, updateButton, multipleFormsToggleButton, tableItems, saveButton, nextButton;

    private static String os = null;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;

    public AKOAssessmentAnswerKeysPage(){
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("SC_SUITE_AKOAssessment", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + DriverHelper.getPath("\\Properties\\AKOAssessmentAnswerKeysPage.properties"));
            } else {
                input = new FileInputStream(dir + "/Properties/AKOAssessmentAnswerKeysPage.properties");
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

    public String getNumberOfItemsTextbox(){
        numberOfItemsTextbox = properties.getProperty("ASSESSMENTS_NUMBER_OF_ITEMS_TEXTBOX");
        return numberOfItemsTextbox;
    }

    public String getUpdateButton(){
        updateButton = properties.getProperty("ASSESSMENTS_UPDATE_BUTTON");
        return updateButton;
    }

    public String getMultipleFormsToggleButton(){
        multipleFormsToggleButton = properties.getProperty("ASSESSMENTS_MULTIPLE_FORMS_TOGGLE_BUTTON");
        return multipleFormsToggleButton;
    }

    public String getTableItems(){
        tableItems = properties.getProperty("ASSESSMENTS_TABLE_ITEMS");
        return tableItems;
    }

    public String getSaveButton(){
        saveButton = properties.getProperty("ASSESSMENTS_SAVE_BUTTON");
        return saveButton;
    }

    public String getNextButton(){
        nextButton = properties.getProperty("ASSESSMENTS_NEXT_BUTTON");
        return nextButton;
    }
}
