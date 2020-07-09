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

public class ItemPreviewandPublishPage extends PageObjectModelBase {
    private String previewandPublishTab, previewAndPublish_ItemName, previewAndPublish_OnlineMarkup;
    private String previewAndPublish_PDFItemPreview, previewAndPublish_TagItem, previewAndPublish_CreateItem;
    private String previewAndPublish_CopyItem, previewAndPublish_PublishButton, previewAndPublish_BacktoWorkspace, previewAndPublish_FinalPublish;
    private String previewAndPublish_FinalCancel, previewAndPublish_FinalClose, ItemBankLinkfromPopup;
    private String AlertMessageinPopup, OkButtoninPopup, AlertFade, itemTab;
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
                input = new FileInputStream(dir + DriverHelper.getPath("\\Properties\\ItemBanksPreviewPublishPage.properties"));
            } else {
                input = new FileInputStream(dir + "/Properties/ItemBanksPreviewPublishPage.properties");
            }
            properties.load(input);

            previewandPublishTab = properties.getProperty("PREVIEW_PUBLISH_TAB");
            previewAndPublish_ItemName = properties.getProperty("PREVIEW_PUBLISH_ITEMNAME");
            previewAndPublish_OnlineMarkup =  properties.getProperty("PREVIEW_PUBLISH_ONLINE_MARKUP");
            previewAndPublish_PDFItemPreview = properties.getProperty("PREVIEW_PUBLISH_PDF_ITEM_PREVIEW");
            previewAndPublish_TagItem = properties.getProperty("PREVIEW_PUBLISH_TAG_NAME");
            previewAndPublish_CreateItem = properties.getProperty("PREVIEW_PUBLISH_CREATE_ITEM");

            previewAndPublish_CopyItem = properties.getProperty("PREVIEW_PUBLISH_COPY_ITEM");
            previewAndPublish_PublishButton =  properties.getProperty("PREVIEW_PUBLISH_PUBLISH_BUTTON");
            previewAndPublish_BacktoWorkspace = properties.getProperty("PREVIEW_PUBLISH_BACKTOWORKSPACE_BUTTON");
            previewAndPublish_FinalPublish = properties.getProperty("PREVIEW_PUBLISH_FINAL_PUBLISH_BUTTON");
            previewAndPublish_FinalCancel = properties.getProperty("PREVIEW_PUBLISH_FINAL_CANCEL_BUTTON");
            previewAndPublish_FinalClose = properties.getProperty("PREVIEW_PUBLISH_FINAL_CLOSE_ICON");
            AlertMessageinPopup = properties.getProperty("PREVIEW_PUBLISH_ALERT_MESSAGE");
            OkButtoninPopup = properties.getProperty("PREVIEW_PUBLISH_OK_BUTTON");
            AlertFade = properties.getProperty("PREVIEW_PUBLISH_ALERT_FADE");
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

    //XPath
    public String getpreviewandPublishTab() {
        return previewandPublishTab;
    }

    //XPath
    public String getpreviewAndPublish_ItemName() {
        return previewAndPublish_ItemName;
    }

    //XPath
    public String getpreviewAndPublish_OnlineMarkup() {
        return previewAndPublish_OnlineMarkup;
    }

    //XPath
    public String getpreviewAndPublish_PDFItemPreview() {
        return previewAndPublish_PDFItemPreview;
    }

    //XPath
    public String getpreviewAndPublish_TagItem() {
        return previewAndPublish_TagItem;
    }

    //XPath
    public String getpreviewAndPublish_CreateItem() {
        return previewAndPublish_CreateItem;
    }

    //XPath
    public String getpreviewAndPublish_CopyItem() {
        return previewAndPublish_CopyItem;
    }

    //XPath
    public String getpreviewAndPublish_PublishButton() {
        return previewAndPublish_PublishButton;
    }

    //XPath
    public String getpreviewAndPublish_BacktoWorkspace() {
        return previewAndPublish_BacktoWorkspace;
    }

    //XPath
    public String getpreviewAndPublish_FinalPublish() {
        return previewAndPublish_FinalPublish;
    }

    //XPath
    public String getpreviewAndPublish_FinalCancel() {
        return previewAndPublish_FinalCancel;
    }

    //XPath
    public String getpreviewAndPublish_FinalClose() {
        return previewAndPublish_FinalClose;
    }


    public List<WebElement> Publish_ItemBanks() {
        List<WebElement> ItemBanksList = BrowserInitHelper.getInstance().findElements(By.xpath("//div[@id='bank-details']//ul[@id='bankNames']//a"));
        return ItemBanksList;
    }

    public String getItemBankLinkfromPopup(String BankName) {
        ItemBankLinkfromPopup = "//*[text() = '" + BankName + "']";
        return ItemBankLinkfromPopup;
    }

    public String getAlertMessageinPopup() {
        return AlertMessageinPopup;
    }

    public String getOkButtoninPopup() {
        return OkButtoninPopup;
    }

    public String getAlertFade() {
        return AlertFade;
    }

}
