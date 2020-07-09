package Controllers;

import DataReader.CSVDataReaderAKOAssessment;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import PageObjectModels.AKOAssessmentInfoPage;
import PageObjectModels.AKOAssessmentStandardsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class AssessmentStandardsController {
    AKOAssessmentStandardsPage akoAssessmentStandardsPage = new AKOAssessmentStandardsPage();
    CSVDataReaderAKOAssessment csvDataReaderAKOAssessment = new CSVDataReaderAKOAssessment();

    public void selectStandards(String standard){
        JavascriptHelper.scrollIntoView(akoAssessmentStandardsPage.getNoStandardsSelected());

        /*Select No Standard Selected checkbox*/
        //DriverHelper.clickXpath(akoAssessmentStandardsPage.getNoStandardsSelected());

        /*Select Not Alinged checkbox*/
        //DriverHelper.clickXpath(akoAssessmentStandardsPage.getNotAligned());

        /*Enter Standard in Search Standard textbox*/
        DriverHelper.sendKeysXpath(akoAssessmentStandardsPage.getSearchStandardTextbox(), standard);

        /*Click Search Icon*/
        DriverHelper.clickXpath(akoAssessmentStandardsPage.getSearchIcon());

        /*Wait until loading icon disappear*/
        DriverHelper.waitUntilLoaderInvisible();

        BrowserInitHelper.getMinWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), '"+standard+"')]")));

        /*Select the searched Standard*/
        BrowserInitHelper.getInstance().findElement(By.xpath("//span[contains(text(), '"+standard+"')]")).click();

        /*Click on Save button*/
        DriverHelper.clickXpath(akoAssessmentStandardsPage.getSaveButton());

        /*Wait until alert message appears*/
        BrowserInitHelper.getMaxWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(akoAssessmentStandardsPage.getAlertMessage())));
    }
}
