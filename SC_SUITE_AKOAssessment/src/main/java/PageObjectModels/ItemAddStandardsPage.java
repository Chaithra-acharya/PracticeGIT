package PageObjectModels;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ItemAddStandardsPage extends PageObjectModelBase {
    private String NoStandardsSelectedCheckbox, NotAlignedCheckbox, SearchTextBox, SearchTextBoxButton;
    private String StandardSelectionCheckbox, NextButton, SearchedStandardSelection;
    private String hisdSearchTextBox;
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
                input = new FileInputStream(dir + DriverHelper.getPath("\\Properties\\ItemBanksAddStandardsPage.properties"));
            } else {
                input = new FileInputStream(dir + "/Properties/ItemBanksAddStandardsPage.properties");
            }
            properties.load(input);

            NoStandardsSelectedCheckbox = properties.getProperty("NO_STANDARDS_SELECTED_CHECKBOX");
            NotAlignedCheckbox = properties.getProperty("NOT_ALIGNED_CHECKBOX");
            SearchTextBox =  properties.getProperty("SEARCH_TEXTBOX");
            SearchTextBoxButton = properties.getProperty("SEARCH_TEXTBOX_BUTTON");
            SearchedStandardSelection = properties.getProperty("SEARCHED_STANDARD_SELECTION");
            NextButton = properties.getProperty("NEXT_BUTTON");

            hisdSearchTextBox = properties.getProperty("HISD_SEARCH_TEXTBOX");
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

    public String getNoStandardsSelectedCheckbox() {
        return NoStandardsSelectedCheckbox;
    }

    public String getNotAlignedCheckbox() {
        return NotAlignedCheckbox;
    }

    public String getSearchTextBox() {
        return SearchTextBox;
    }

    public String getSearchTextBoxButton() {
        return SearchTextBoxButton;
    }

    public String getStandardSelectionCheckbox() {
        return StandardSelectionCheckbox;
    }

    public String getNextButton() {
        return NextButton;
    }

    public String getSearchedStandardSelection() {
        return SearchedStandardSelection;
    }

    public String getaddedStandard(String Standard) {
        SearchedStandardSelection = "//ul[@id='ulSelectedStand']//li[normalize-space(.)='" + Standard + "']";
        return SearchedStandardSelection;
    }

    public WebElement getpropertiesTab() {
        WebElement propertiesTab;
        propertiesTab = BrowserInitHelper.getInstance().findElement(By.xpath("//a[@id='getitemproperties']"));
        return propertiesTab;
    }

    public String getHisdSearchTextBox(){
        return hisdSearchTextBox;
    }
}
