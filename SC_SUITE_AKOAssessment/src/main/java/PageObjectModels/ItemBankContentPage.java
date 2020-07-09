package PageObjectModels;

//Page Object Model Class for ItemBank Content Page
public class ItemBankContentPage extends PageObjectModelBase {
    private String PassageNameinItemBankContent, PassageNameinItemBankContentAfterSearch;


    public String getPassageNameinItemBankContent(String PassageName) {
        PassageNameinItemBankContent = "//span[.='" + PassageName + "']";
        return PassageNameinItemBankContent;
    }

    public String getPassageNameinItemBankContentAfterSearch(String PassageName) {
        PassageNameinItemBankContentAfterSearch = "//a[.='" + PassageName + "']";
        return PassageNameinItemBankContentAfterSearch;
    }

    public String getItemNameinItemBankContent(String ItemName) {
        PassageNameinItemBankContent = "//span[.='" + ItemName + "']";
        return PassageNameinItemBankContent;
    }


}