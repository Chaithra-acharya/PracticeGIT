package PageObjectModels;

import Helpers.DriverHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ItemPropertiesPage extends PageObjectModelBase {
    private String bloomsTaxonomyDropDown, textboxInBloomsTaxonomyDropDown, bloomsTaxonomyID;
    private String depthOfKnowledgeDropDown, textboxInDepthOfKnowledgeDropDown, depthOfKnowledgeID;
    private String difficultyLevelDropDown, textboxInDifficultyLevelDropDown, difficultyLevelID;
    private String pointBiSerialTextbox, pValueTextbox;
    private String linkInsideDropDown, saveButton, nextButton, alertMessage, alertOK;
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
                input = new FileInputStream(dir + DriverHelper.getPath("\\Properties\\ItemBanksPropertiesPage.properties"));
            } else {
                input = new FileInputStream(dir + "/Properties/ItemBanksPropertiesPage.properties");
            }
            properties.load(input);

            bloomsTaxonomyDropDown = properties.getProperty("BLOOMS_TAXONOMY_DROPDOWN");
            textboxInBloomsTaxonomyDropDown = properties.getProperty("TEXTBOX_IN_BLOOMS_TAXONOMY_DROPDOWN");
            bloomsTaxonomyID =  properties.getProperty("BLOOMS_TAXONOMY_ID");
            depthOfKnowledgeDropDown = properties.getProperty("DEPTH_OF_KNOWLEDGE_DROPDOWN");
            textboxInDepthOfKnowledgeDropDown = properties.getProperty("TEXTBOX_DEPTH_OF_KNOWLEDGE_DROPDOWN");
            depthOfKnowledgeID = properties.getProperty("DEPTH_OF_KNOWLEDGE_ID");

            difficultyLevelDropDown = properties.getProperty("DIFFICULTY_LEVEL_DROPDOWN");
            textboxInDifficultyLevelDropDown =  properties.getProperty("TEXTBOX_DIFFICULTY_LEVEL_DROPDOWN");
            difficultyLevelID = properties.getProperty("DIFFICULTY_LEVEL_ID");
            pointBiSerialTextbox = properties.getProperty("POINT_BY_SERIAL_TEXTBOX");
            System.out.println("pValueTextbox:"+pointBiSerialTextbox);
            pValueTextbox = properties.getProperty("PVALUE_TEXTBOX");
            System.out.println("pValueTextbox:"+pValueTextbox);
            saveButton = properties.getProperty("SAVE_BUTTON");
            nextButton = properties.getProperty("NEXT_BUTTON");
            alertMessage = properties.getProperty("ALERT_MESSAGE");
            alertOK = properties.getProperty("ALERT_OK");
        }
        catch (IOException ex) {
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

    //Xpath
    public String getBloomsTaxonomyDropDown() {
        return bloomsTaxonomyDropDown;
    }

    //Xpath
    public String getTextboxInBloomsTaxonomyDropDown() {
        return textboxInBloomsTaxonomyDropDown;
    }

    //ID
    public String getBloomsTaxonomyID() {
        return bloomsTaxonomyID;
    }

    //Xpath
    public String getDepthOfKnowledgeDropDown() {
        return depthOfKnowledgeDropDown;
    }

    //Xpath
    public String getTextboxInDepthOfKnowledgeDropDown() {
        return textboxInDepthOfKnowledgeDropDown;
    }

    //ID
    public String getDepthOfKnowledgeID() {
        return depthOfKnowledgeID;
    }

    //Xpath
    public String getDifficultyLevelDropDown() {
        return difficultyLevelDropDown;
    }

    //Xpath
    public String getTextboxInDifficultyLevelDropDown() {
        return textboxInDifficultyLevelDropDown;
    }

    //ID
    public String getDifficultyLevelID() {
        return difficultyLevelID;
    }

    //Xpath
    public String getPointBiSerialTextbox() {
        return pointBiSerialTextbox;
    }

    //Xpath
    public String getpValueTextbox() {
        return pValueTextbox;
    }

    //Xpath
    public String getlinkInsideDropDown(String ElementID, String LinkText) {
        linkInsideDropDown = "//ul[@id='" + ElementID + "']//a[normalize-space(.)='" + LinkText + "']";
        return linkInsideDropDown;
    }

    //Xpath
    public String getSaveButton() {
        return saveButton;
    }

    //Css
    public String getAlertMessage() {
        return alertMessage;
    }

    //Css
    public String getAlertOK() {
        return alertOK;
    }

    //Xpath
    public String getNextButton() {
        return nextButton;
    }
}
