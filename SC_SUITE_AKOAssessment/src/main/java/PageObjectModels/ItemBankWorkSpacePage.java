package PageObjectModels;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

//Page Object Model Class for ItemBank Work Space Page
public class ItemBankWorkSpacePage extends PageObjectModelBase {
    private String createPassageButton, passageTab, passageTitleTextBox, findMatchingPassagesButton, passagecheckbox;
    private String passagemoveButton, moveButtoninPopup, AlertMessageinPopup, OkButtoninPopup, backToDistrictWorkSpaceButton;
    private String backToSchoolWorkSpaceButton, passagePublishButton, publishpassageButtoninPopup, publishpassageTextinPopup, publishpassageOkinPopup;
    private String ItemBankLinkfromPopup, publishPassagePopupTitle, itemTab, itemNameTextBox, itemcheckbox, createItemButton;
    private String hisdItemBanksWorkspaceDropDown;
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
                input = new FileInputStream(dir + DriverHelper.getPath("\\Properties\\ItemBanksWorkspacePage.properties"));
            } else {
                input = new FileInputStream(dir + "/Properties/ItemBanksWorkspacePage.properties");
            }
            properties.load(input);

            createPassageButton = properties.getProperty("CREATE_PASSAGE_BUTTON");
            passageTab = properties.getProperty("ITEM_BANKS_PASSAGE_TAB");
            passageTitleTextBox = properties.getProperty("PASSAGE_SEARCH_TEXTBOX");
            findMatchingPassagesButton = properties.getProperty("FIND_MATCHING_PASSAGES_BUTTON");

            passagemoveButton = properties.getProperty("PASSAGE_MOVE_BUTTON");
            moveButtoninPopup = properties.getProperty("MOVE_MODAL_MOVE_BUTTON");
            AlertMessageinPopup = properties.getProperty("ALERT_MESSAGE");
            OkButtoninPopup = properties.getProperty("ALERT_MODAL_OK_BUTTON");
            passagePublishButton = properties.getProperty("PASSAGE_PUBLISH_BUTTON");
            publishpassageButtoninPopup = properties.getProperty("PASSAGE_PUBLISH_MODAL_PUBLISH_BUTTON");
            publishpassageTextinPopup = properties.getProperty("PASSAGE_PUBLISH_POPUP_TEXT");
            publishpassageOkinPopup = properties.getProperty("PASSAGE_PUBLISH_OK_BUTTON");

            itemTab = properties.getProperty("ITEM_BANKS_ITEMS_TAB");
            itemNameTextBox = properties.getProperty("ITEM_SEARCH_TEXTBOX");
            createItemButton = properties.getProperty("CREATE_ITEM_BUTTON");

            hisdItemBanksWorkspaceDropDown= properties.getProperty("HISD_ITEM_BANKS_WORKSPACE_DROPDOWN");
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

	public String getcreateItemButton() {
        return createItemButton;
    }
	
    public String getcreatePassageButton() {
        return createPassageButton;
    }

    public String getpassageTab() {
        return passageTab;
    }

    public String getpassageTitleTextBox() {
        return passageTitleTextBox;
    }

    public String getfindMatchingPassagesButton() {
        return findMatchingPassagesButton;
    }

    public String getpassagecheckbox(String PassageName) {
        passagecheckbox = "//a[text()='" + PassageName + "']/parent::td/preceding::td/input[@class='passagechk']";
        return passagecheckbox;
    }

    public String getitemcheckbox(String ItemName) {
        itemcheckbox = "//a[text()='" + ItemName + "']/parent::td/preceding::td/input[@class='itemchk']";
        return itemcheckbox;
    }

    public String getpassagemoveButton() {
        return passagemoveButton;
    }

    public String getpassagePublishButton() {
        return passagePublishButton;
    }

    public List<WebElement> getMoveWorkSpace_ItemBank() {
        List<WebElement> ItemBanksList = BrowserInitHelper.getInstance().findElements(By.xpath("//div[@id='page-container']//div[@id='moveworkspace'][1]//ul//a"));
        return ItemBanksList;
    }

    public String getmoveButtoninPopup() {
        return moveButtoninPopup;
    }

    public String getAlertMessageinPopup() {
        return AlertMessageinPopup;
    }

    public String getOkButtoninPopup() {
        return OkButtoninPopup;
    }

    public String getbackToDistrictWorkSpaceButton() {
        return backToDistrictWorkSpaceButton;
    }

    public String getbackToSchoolWorkSpaceButton() {
        return backToSchoolWorkSpaceButton;
    }

    public List<WebElement> getpublishWorkSpace_ItemBank() {
        List<WebElement> ItemBanksList = BrowserInitHelper.getInstance().findElements(By.xpath("//div[@id='bank-details']//ul//a"));
        return ItemBanksList;
    }

    public String getpublishPassagePopupTitle() {
        return publishPassagePopupTitle;
    }

    public String getpublishpassageButtoninPopup() {
        return publishpassageButtoninPopup;
    }

    public String getpublishpassageTextinPopup() {
        return publishpassageTextinPopup;
    }

    public String getpublishpassageOkinPopup() {
        return publishpassageOkinPopup;
    }

    public String getItemBankLinkfromPopup(String BankName) {
        ItemBankLinkfromPopup = "//div[@id='moveworkspace'][1]//*[text() = '" + BankName + "']";
        return ItemBankLinkfromPopup;
    }

    public String getItemBankLinkPublishfromPopup(String BankName) {
        ItemBankLinkfromPopup = "//ul[@id='bankNames'][1]//*[text() = '" + BankName + "']";
        return ItemBankLinkfromPopup;
    }

    public String getitemTab() {
        return itemTab;
    }

    public String getitemNameTextBox() {
        return itemNameTextBox;
    }

    public String getHisdItemBanksWorkspaceDropDown(){
        return hisdItemBanksWorkspaceDropDown;
    }
}
