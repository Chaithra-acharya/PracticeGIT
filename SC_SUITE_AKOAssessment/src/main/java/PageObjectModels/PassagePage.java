package PageObjectModels;

import Helpers.BrowserInitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

//Page Object Model Class for Passage Creation Page
public class PassagePage extends PageObjectModelBase {

    private String passageNameTextBox, topicTextBox, lexileTextBox, passageTextBox, propertiesDropDown, AlertFade;
    private String propertiesDropDown_InputBox, linkInsideDropDown, propertiesTextBox, passageInfoSaveButton;
    private String AlertMessageinPopup, OkButtoninPopup, passageInfoNextButton, publishpassageButton, publishpassageButtoninPopup;
    private String publishpassageTextinPopup, publishpassageOkinPopup, ItemBankLinkfromPopup, backToMyWorkSpaceButton;

    public String getpassageNameTextBox() {
        passageNameTextBox = "//input[@id='passagename']";
        return passageNameTextBox;
    }

    public String gettopicTextBox() {
        topicTextBox = "//input[@id='topic']";
        return topicTextBox;
    }

    public String getlexileTextBox() {
        lexileTextBox = "//input[@id='lexile']";
        return lexileTextBox;
    }

    //Css Selector
    public String getpassageTextBox() {
        passageTextBox = "#trpassagetext>td>div";
        return passageTextBox;
    }

    //Css Selector
    public String getpropertiesDropDown() {
        propertiesDropDown = "button[data-id^= 'selproperties_']";
        return propertiesDropDown;
    }

    public String getpropertiesDropDown_InputBox() {
        propertiesDropDown_InputBox = "//button[starts-with(@data-id,'selproperties_')]/following::div[@class='dropdown-menu open']/div/input";
        return propertiesDropDown_InputBox;
    }

    public String getlinkInsideDropDown(String LinkText) {
        linkInsideDropDown = "//a[normalize-space(.)=\"" + LinkText + "\"]";
        return linkInsideDropDown;
    }

    public String getpropertiesTextBox() {
        propertiesTextBox = "//input[starts-with(@id,'propid_')]";
        return propertiesTextBox;
    }

    public String getpassageInfoSaveButton() {
        passageInfoSaveButton = "//a[@id='btnSavePassage']/i";
        return passageInfoSaveButton;
    }

    public String getAlertMessageinPopup() {
        AlertMessageinPopup = "//p[@class='alertify-message']";
        return AlertMessageinPopup;
    }

    public String getOkButtoninPopup() {
        OkButtoninPopup = "//button[@id='alertify-ok']";
        return OkButtoninPopup;
    }

    public String getAlertFade() {
        AlertFade = "//div[@class='modal-backdrop fade in']";
        return AlertFade;
    }

    public String getpassageInfoNextButton() {
        passageInfoNextButton = "//a[@id='btnNextPassage']";
        return passageInfoNextButton;
    }

    public String getpublishpassageButton() {
        publishpassageButton = "//a[starts-with(@id,'publish_')]/i";
        return publishpassageButton;
    }

    public String getpublishpassageButtoninPopup() {
        publishpassageButtoninPopup = "//a[@id='btnPublish']/i";
        return publishpassageButtoninPopup;
    }

    public String getpublishpassageTextinPopup() {
        publishpassageTextinPopup = "//div[@id='pub-msg']";
        return publishpassageTextinPopup;
    }

    public String getpublishpassageOkinPopup() {
        publishpassageOkinPopup = "//div[@id='pubmsg']//a[.='OK']";
        return publishpassageOkinPopup;
    }

    public List<WebElement> Publish_ItemBanks() {
        List<WebElement> ItemBanksList = BrowserInitHelper.getInstance().findElements(By.xpath("//div[@id='bank-details']//ul[@id='bankNames']//a"));
        return ItemBanksList;
    }

    public String getItemBankLinkfromPopup(String BankName) {
        ItemBankLinkfromPopup = "//*[text() = '" + BankName + "']";
        return ItemBankLinkfromPopup;
    }

    public String getbackToMyWorkSpaceButton() {
        backToMyWorkSpaceButton = "//a[@id='myWorkSpace']/i";
        return backToMyWorkSpaceButton;
    }

}