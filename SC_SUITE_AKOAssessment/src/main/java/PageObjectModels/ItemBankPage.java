package PageObjectModels;

import Helpers.DriverHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page Object Model Class for ItemBank Page
public class ItemBankPage {
    public String bankNameTextBox, findMatchingBanksButton, BankLink, PassageCountLink, selectItemWorkSpaceDropDown, createBankButton;
    public String similarItemSearchButton, createBankTitleinPopup, bankNameinPopup, descriptioninPopup, saveButtoninPopup, closeButtoninPopup;
    public String itemCreatedSuccessfullyMessageinPopup, okButtoninPopup, itemBankTitle;
    public String workspaceDropDown, hisdItemBanksWorkspaceDropDown;
    private static String os = null;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;

    public void readItemBankPageProperties() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("CreateMCItemType", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + DriverHelper.getPath("\\Properties\\ItemBankspage.properties"));
            } else {
                input = new FileInputStream(dir + "/Properties/ItemBankspage.properties");
            }
            properties.load(input);

            bankNameTextBox = properties.getProperty("BANK_NAME_TEXT_BOX");
            findMatchingBanksButton = properties.getProperty("FIND_BANK_MATCHING_BUTTON");
            createBankButton = properties.getProperty("CREATE_BANK_BUTTON");
            selectItemWorkSpaceDropDown = properties.getProperty("ITEM_BANKS_WORKSPACE_DROPDOWN");
            similarItemSearchButton = properties.getProperty("SIMILAR_ITEM_SEARCH_BUTTON");
            createBankTitleinPopup = properties.getProperty("CREATE_BANK_TITLE_TEXT_IN_POPUP");
            bankNameinPopup = properties.getProperty("BANK_NAME_TEXT_BOX_IN_CREATEITEM_POPUP");
            descriptioninPopup = properties.getProperty("DESCRIPTION_TEXT_BOX_IN_CREATEITEM_POPUP");
            saveButtoninPopup = properties.getProperty("SAVE_BUTTON_IN_CREATEITEM_POPUP");
            closeButtoninPopup = properties.getProperty("CLOSE_BUTTON_IN_CREATEITEM_POPUP");
            itemCreatedSuccessfullyMessageinPopup = properties.getProperty("BANK_CREATED_SUCCESSFULLY_POPUP");
            okButtoninPopup = properties.getProperty("BANK_CREATED_SUCCESSFULLY_POPUP_OK");
            itemBankTitle = properties.getProperty("ITEM_BANK_TITLE");
            BankLink = properties.getProperty("BANK_LIST");
            PassageCountLink =  properties.getProperty("PASSAGE_COUNT_LINK");
            workspaceDropDown = properties.getProperty("ITEM_BANKS_WORKSPACE_DROPDOWN");
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

    public String getBankNameTextBox() { return bankNameTextBox; }

    public String getFindMatchingBanksButton() { return findMatchingBanksButton; }

    public String getBankLink(String BankName) {
        BankLink = "//a[text()='"+BankName+"']";
        return BankLink;
    }

    public String getPassageCountLink(String BankName) {
        PassageCountLink = "//a[text()='"+BankName+"']";
        return PassageCountLink;
    }

    public String getSelectItemWorkSpaceDropDown() { return selectItemWorkSpaceDropDown; }

    public String getCreateBankButton() { return createBankButton; }

    public String getSimilarItemSearchButton() { return similarItemSearchButton; }

    public String getCreateBankTitleinPopup() { return similarItemSearchButton; }

    public String getBankNameinPopup() { return createBankTitleinPopup; }

    public String getDescriptioninPopup() { return bankNameinPopup; }

    public String getSaveButtoninPopup() { return saveButtoninPopup; }

    public String getCloseButtoninPopup() { return closeButtoninPopup; }

    public String getAlertMessageinPopup() { return itemCreatedSuccessfullyMessageinPopup; }

    public String getOkButtoninPopup() { return okButtoninPopup; }

    public String getItemBankTitle() { return itemBankTitle; }

    public String getWorkspaceDropDown(){
        return workspaceDropDown;
    }

    public String getItemCountLink(String BankName) {
        PassageCountLink = "//a[text()='" + BankName + "']/following::td[1]/a[starts-with(@id,'iCount_')]";
        return PassageCountLink;
    }

    public String getHisdItemBanksWorkspaceDropDown(){
        return hisdItemBanksWorkspaceDropDown;
    }
}