package PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page Object Model Class for Launchpad Page
public class LaunchpadPage {
    public String launchpadTitle,launchpadFlipcardsSection, navigationWaffle,assessmentNavigationLink;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public LaunchpadPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("SC_SUITE_AKOAssessment", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\LaunchPadPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/LaunchPadPage.properties");
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

    public String getlaunchpadTitle() {
        launchpadTitle = properties.getProperty("LAUNCHPAD_HEADER");
        return launchpadTitle;
    }

    public String getlaunchpadFlipcardsSection() {
        launchpadFlipcardsSection = properties.getProperty("LAUNCHPAD_FLIPCARD_SECTION");
        return launchpadFlipcardsSection;
    }

    public String getlaunchpadNavigation_Waffle() {
        navigationWaffle = properties.getProperty("LAUNCHPAD_NAVIGATION_WAFFLE");
        return navigationWaffle;
    }
    public String getAssessmentNavigationLink() {
        assessmentNavigationLink = properties.getProperty("LAUNCHPAD_ASSESSMENTS_NAVIGATIONAL_LINK");
        return assessmentNavigationLink;
    }
}