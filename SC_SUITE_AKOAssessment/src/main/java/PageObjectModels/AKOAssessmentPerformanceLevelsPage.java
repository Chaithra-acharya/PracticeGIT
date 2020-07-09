package PageObjectModels;

import Helpers.DriverHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AKOAssessmentPerformanceLevelsPage {
    String loadFromAvailableTemplate, addPerformanceLevelSets, skipPerformanceLevels, setupByPercentage, setupByCutPoints, plDataTable;
    String saveButton, nextButton;

    private static String os = null;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;

    public AKOAssessmentPerformanceLevelsPage(){
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("SC_SUITE_AKOAssessment", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + DriverHelper.getPath("\\Properties\\AKOAssessmentPerformanceLevelsPage.properties"));
            } else {
                input = new FileInputStream(dir + "/Properties/AKOAssessmentPerformanceLevelsPage.properties");
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

    public String getLoadFromAvailableTemplate(){
        loadFromAvailableTemplate = properties.getProperty("ASSESSMENTS_LOAD_FROM_AVAILABALE_TEMPLATES");
        return loadFromAvailableTemplate;
    }

    public String getAddPerformanceLevelSets(){
        addPerformanceLevelSets = properties.getProperty("ASSESSMENTS_ADD_PERFORMANCE_LEVEL_SETS");
        return addPerformanceLevelSets;
    }

    public String getSkipPerformanceLevels(){
        skipPerformanceLevels = properties.getProperty("ASSESSMENTS_SKIP_PERFORMANCE_LEVELS");
        return skipPerformanceLevels;
    }

    public String getSetupByPercentage(){
        setupByPercentage = properties.getProperty("ASSESSMENTS_SETUP_BY_PERCENTAGE");
        return setupByPercentage;
    }

    public String getSetupByCutPoints(){
        setupByCutPoints = properties.getProperty("ASSESSMENTS_SETUP_BY_CUT_POINTS");
        return setupByCutPoints;
    }

    public String getPlDataTable(){
        plDataTable = properties.getProperty("ASSESSMENTS_PERFORMANCE_LEVEL_TABLE");
        return plDataTable;
    }

    public String getSaveButton(){
        saveButton = properties.getProperty("ASSESSMENTS_PL_SAVE_BUTTON");
        return saveButton;
    }

    public String getNextButton(){
        nextButton = properties.getProperty("ASSESSMENTS_PL_NEXT_BUTTON");
        return nextButton;
    }
}
