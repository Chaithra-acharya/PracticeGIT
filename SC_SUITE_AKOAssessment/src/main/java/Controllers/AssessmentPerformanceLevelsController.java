package Controllers;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import PageObjectModels.AKOAssessmentPerformanceLevelsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AssessmentPerformanceLevelsController {
    AKOAssessmentPerformanceLevelsPage akoAssessmentPerformanceLevelsPage = new AKOAssessmentPerformanceLevelsPage();
    //Actions action = new Actions(BrowserInitHelper.getInstance());

    public void loadAvailableTemplate(String skipPerformanceLevel, String setupPLBy, String templateName){
        if(skipPerformanceLevel.equalsIgnoreCase("Yes")){
            /*Click Skip Performance levels button*/
            DriverHelper.clickXpath(akoAssessmentPerformanceLevelsPage.getSkipPerformanceLevels());
        }
        else{
            /*Select Setup Performance Level By*/
            if(setupPLBy.equalsIgnoreCase("Percentage")){
                String xpath = "//label[@id='lbPctSet_1']/span[contains(text(), 'Percentage')]";
                JavascriptHelper.click_Xpath(xpath);
            }
            else if(setupPLBy.equalsIgnoreCase("Cut Points")){
                String xpath = "//label[@id='lbCPntSet_1']/span[contains(text(), 'Cut Points')]";
                JavascriptHelper.click_Xpath(xpath);
            }

            /*Click Load from Available Templates button*/
            //DriverHelper.clickXpath(akoAssessmentPerformanceLevelsPage.getLoadFromAvailableTemplate());
            JavascriptHelper.click_Xpath(akoAssessmentPerformanceLevelsPage.getLoadFromAvailableTemplate());

            BrowserInitHelper.getMinWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("(//h4[contains(text(), '"+templateName+"')]/following-sibling::a[contains(text(), 'Apply This Template')])[1]")));

            /*Select the Template*/
            //BrowserInitHelper.getInstance().findElement(By.xpath("(//h4[contains(text(), '"+templateName+"')]/following-sibling::a[contains(text(), 'Apply This Template')])[1]")).click();
            JavascriptHelper.click_Xpath("(//h4[contains(text(), '"+templateName+"')]/following-sibling::a[contains(text(), 'Apply This Template')])[1]");
        }
    }
}
