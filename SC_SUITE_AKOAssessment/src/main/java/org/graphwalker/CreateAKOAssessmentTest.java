package org.graphwalker;

import DataReader.CSVDataReaderLaunchpad;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import PageObjectModels.LaunchpadPage;
import PageObjectModels.LoginPage;
import PageObjectModels.ManageAssessmentsPage;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import Utils.Config;

import java.util.ArrayList;
import java.util.List;

@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
public class CreateAKOAssessmentTest extends ExecutionContext implements org.graphwalker.CreateAKOAssessment {

    //Declarations
    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket, userlevel;
    int waitTime;
    DriverHelper helper = new DriverHelper();

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(CreateAKOAssessmentTest.class);

    CSVDataReaderLaunchpad csvReaderLaunchpad = new CSVDataReaderLaunchpad();

    LoginPage loginPOM = new LoginPage();
    LaunchpadPage launchpadPOM = new LaunchpadPage();
    ManageAssessmentsPage manageAssessmentsPage = new ManageAssessmentsPage();

    @BeforeExecution
    public void setup() {
        //Config
        config.readProperties();
        browser = config.getBrowser();
        waitTime = config.getWaitTime();
        url = config.getURL();
        username = config.getUsername();
        password = config.getPassword();
        closeBrowser = config.getCloseBrowser();
        multiSite = config.getMultiSite();
        ticket = config.getTicket();
        userlevel = config.getUserLevel();
        BrowserInitHelper.setup();
    }

    @AfterExecution
    public void cleanup() {
        if (BrowserInitHelper.getInstance() != null) {
            //BrowserInitHelper.tearDown();
            BrowserInitHelper.getInstance().quit();
        }
    }

    public void e_StartBrowser() {
        //Driver Instance
        System.out.println(browser);
    }

    public void v_BrowserStarted() {

    }

    public void e_EnterBaseURL() {
        BrowserInitHelper.getInstance().manage().window().maximize();
        BrowserInitHelper.getInstance().get(url);
    }

    public void v_BaseURL() {

    }

    public void e_EnterCredentials() {
        try {
            //Username
            DriverHelper.sendKeysXpath(loginPOM.getUserNameField(), username);

            System.out.println("Entering Password");

            //Password
            DriverHelper.setPassword_JS(password);

            System.out.println("Clicking Sign in");

            //Click SignIn Button
            DriverHelper.clickXpath(loginPOM.getloginSignInButton());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void v_Login() {
        DriverHelper.assertion(launchpadPOM.getlaunchpadTitle(), csvReaderLaunchpad.getLaunchpadTitle());
    }

    public void e_LoginSucceeded() {
        System.out.println("e_LoginSucceeded.....");
    }

    public void v_Launchpad() {
        BrowserInitHelper.getMaxWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(launchpadPOM.getlaunchpadFlipcardsSection())));
    }

    public void e_NavigateToAssessments() {
        //Navigate back to item bank from header
        DriverHelper.waitUntilLoaderInvisible();
        JavascriptHelper.clickXpath_JS(launchpadPOM.getlaunchpadNavigation_Waffle());
        DriverHelper.clickXpath(launchpadPOM.getAssessmentNavigationLink());
        DriverHelper.waitUntilLoaderInvisible();
        DriverHelper.waitForPageLoadComplete();
    }

    public void v_VerifyAssessments() {
        DriverHelper.waitUntilLoaderInvisible();
        if(BrowserInitHelper.getInstance().findElement(By.xpath(manageAssessmentsPage.getPageHeader())).isDisplayed()){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
    }

    public void v_VerifyFiltersInAssessmentManager(){
        BrowserInitHelper.getMaxWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(manageAssessmentsPage.getYearDropDown())));

        List<WebElement> filterElements = new ArrayList<WebElement>();
        filterElements.add(BrowserInitHelper.getInstance().findElement(By.xpath(manageAssessmentsPage.getYearDropDown())));
        filterElements.add(BrowserInitHelper.getInstance().findElement(By.xpath(manageAssessmentsPage.getCollectionDropDown())));
        filterElements.add(BrowserInitHelper.getInstance().findElement(By.xpath(manageAssessmentsPage.getSubjectDropDown())));
        filterElements.add(BrowserInitHelper.getInstance().findElement(By.xpath(manageAssessmentsPage.getStandardGradeDropDown())));
        filterElements.add(BrowserInitHelper.getInstance().findElement(By.xpath(manageAssessmentsPage.getAssessmentTypeDropDown())));
        filterElements.add(BrowserInitHelper.getInstance().findElement(By.xpath(manageAssessmentsPage.getStatusDropDown())));
        filterElements.add(BrowserInitHelper.getInstance().findElement(By.xpath(manageAssessmentsPage.getTagsDropDown())));
        filterElements.add(BrowserInitHelper.getInstance().findElement(By.xpath(manageAssessmentsPage.getAssessmentCreatedByDropDown())));
        filterElements.add(BrowserInitHelper.getInstance().findElement(By.xpath(manageAssessmentsPage.getRefreshButton())));

        boolean isExist = false;

        for(int i=0; i<filterElements.size(); i++){
            System.out.println(filterElements.get(i));
            if(filterElements.get(i).isDisplayed()){
                isExist = true;
            }
            else{
                isExist = false;
                break;
            }
        }

        //Assert.assertTrue(isExist);
    }

    public void v_VerifyTabsInAssessmentManager(){
        BrowserInitHelper.getMaxWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(manageAssessmentsPage.getRefreshButton())));

        if(BrowserInitHelper.getInstance().findElement(By.xpath(manageAssessmentsPage.getPageHeader())).isDisplayed()){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
    }

    public void v_VerifyAssessmentCreation(){

    }

    public void v_ValidateAssessmentInfo(){

    }
}
