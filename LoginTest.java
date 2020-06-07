package org.graphwalker;

import Controllers.LaunchPadController;
import DataReader.CSVDataReaderLaunchPadPage;
import DataReader.CSVDataReaderLoginPage;
import PageObjectModels.Launchpad;
import PageObjectModels.LoginPage;
import Utils.Config;
import Utils.ConsoleLogger;
import org.graphwalker.Login;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import Controllers.LoginController;
import Helpers.DriverHelper;
import Helpers.BrowserInitHelper;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@GraphWalker(start = "e_StartBrowser", value = "random(reached_vertex(v_StaffPortalLoginPage))")
public class LoginTest extends ExecutionContext implements Login {

    //Declarations
    Boolean headless;
    int waitTime;
    String browser, url, username, password, closeBrowser, browserTitle, chrome, firefox;
    String studentUn, studentPwd;
    Config config = new Config();
    CSVDataReaderLoginPage csvDataReaderLoginPage = new CSVDataReaderLoginPage();
    CSVDataReaderLaunchPadPage csvDataReaderLaunchPadPage = new CSVDataReaderLaunchPadPage();
    LoginPage loginPagePOM = new LoginPage();
    Launchpad launchpadPOM = new Launchpad();
    DriverHelper driverHelper = new DriverHelper();
    LoginController loginController = new LoginController();
    String dir = null;
    Map<String, String> map = new HashMap<String, String>();

    @BeforeExecution
    public void setup() {
        config.readProperties();
        loginPagePOM.readLoginPageProperties();
        launchpadPOM.readProperties();
        browser = config.getBrowser();
        waitTime = config.getWaitTime();
        url = config.getURL();
        username = config.getUsername();
        password = config.getPassword();
        closeBrowser = config.getCloseBrowser();
        headless = config.getHeadless();
        chrome = config.getChrome();
        firefox = config.getFirefox();
        BrowserInitHelper.setup();
        studentUn = config.getStudentUsername();
        studentPwd = config.getStudentPassword();
    }

//    @AfterExecution
//    public void cleanup() {
//        if (BrowserInitHelper.getInstance() != null) {
//            BrowserInitHelper.getInstance().quit();
//        }
//    }

    public void e_StartBrowser() {

    }

    public void v_BrowserStarted() {

    }

    public void e_EnterBaseURL() {
        BrowserInitHelper.getInstance().manage().window().maximize();
        BrowserInitHelper.getInstance().get(url);
    }

    public void v_BaseURLAndLogo() {
        boolean checkTitle = true;
        checkTitle = BrowserInitHelper.getMinWaiter().until(ExpectedConditions.titleIs(csvDataReaderLoginPage.getBrowserTitle()));
        if (checkTitle) {
            ConsoleLogger.SuccessLog("Browser Title is displayed....");
        } else {
            ConsoleLogger.DebugLog("Browser Title is NOT displayed....!!");
        }
        Assert.assertTrue(checkTitle);

        boolean checkLogo = false;
        checkLogo = DriverHelper.verifyDisplayByXpath(loginPagePOM.getschooolCityLogo());
        if (checkLogo) {
            ConsoleLogger.SuccessLog("SchoolCity Logo is displayed....");
        } else {
            ConsoleLogger.DebugLog("SchoolCity Logo is NOT displayed....!!");
        }
        Assert.assertTrue(checkLogo);

        boolean checkDistrict = false;
        checkDistrict = DriverHelper.verifyDisplayByXpath(loginPagePOM.getschooolCityDistrictLogo());
        if (checkDistrict) {
            ConsoleLogger.SuccessLog("District Logo on login page is displayed....");
        } else {
            ConsoleLogger.DebugLog("District Logo on login page is NOT displayed....!!");
        }
        Assert.assertTrue(checkDistrict);
    }

    public void e_ValidUnInvalidPwd() {
        DriverHelper.sendKeysXpath(loginPagePOM.getUserNameField(), csvDataReaderLoginPage.getValidUsername());
        loginController.setPassword(loginPagePOM.getPasswordField(), csvDataReaderLoginPage.getInvalidPassword());
        DriverHelper.clickXpath(loginPagePOM.getloginSignInButton());
    }

    public void v_InvalidPassword() {
        boolean checkInvalidpwd = false;
        checkInvalidpwd = loginController.verifyInvalidCredentialErrorMsg(loginPagePOM.getInvalidPwdErrorMsg(), csvDataReaderLoginPage.getInvalidPwdError());
        if (checkInvalidpwd) {
            ConsoleLogger.SuccessLog("Valid Username & Invalid password error message verified successfully....");
        } else {
            ConsoleLogger.DebugLog("Failed to verify the Valid Username & Invalid password error message....!!");
        }
        Assert.assertTrue(checkInvalidpwd);
    }

    public void e_InvalidUnValidPwd() {
        DriverHelper.sendKeysXpath(loginPagePOM.getUserNameField(), csvDataReaderLoginPage.getInvalidUsername());
        loginController.setPassword(loginPagePOM.getPasswordField(), csvDataReaderLoginPage.getValidPassword());
        DriverHelper.clickXpath(loginPagePOM.getloginSignInButton());
    }

    public void v_InvalidAuthentication() {
        boolean checkAuthentication = false;
        checkAuthentication = loginController.verifyInvalidCredentialErrorMsg(loginPagePOM.getInvalidUserNameErrorMsg(), csvDataReaderLoginPage.getInvalidUnError());
        if (checkAuthentication) {
            ConsoleLogger.SuccessLog("InValid Username & valid password error message verified successfully....");
        } else {
            ConsoleLogger.DebugLog("Failed to verify the InValid Username & valid password error message....!!");
        }
        Assert.assertTrue(checkAuthentication);
    }

    public void e_InvalidUnInValidPwd() {
        DriverHelper.sendKeysXpath(loginPagePOM.getUserNameField(), csvDataReaderLoginPage.getInvalidUsername());
        loginController.setPassword(loginPagePOM.getPasswordField(), csvDataReaderLoginPage.getInvalidPassword());
        DriverHelper.clickXpath(loginPagePOM.getloginSignInButton());
    }

    public void v_InvalidUnInvalidPwd() {
        boolean checkInavlidPwd = false;
        checkInavlidPwd = loginController.verifyInvalidCredentialErrorMsg(loginPagePOM.getInvalidUserNameErrorMsg(), csvDataReaderLoginPage.getInvalidUnError());
        if (checkInavlidPwd) {
            ConsoleLogger.SuccessLog("InValid Username & Invalid password error message verified successfully....");
        } else {
            ConsoleLogger.DebugLog("Failed to verify the InValid Username & Invalid password error message....!!");
        }
        Assert.assertTrue(checkInavlidPwd);
    }

    public void e_ValidUnValidPwd() {
        DriverHelper.sendKeysXpath(loginPagePOM.getUserNameField(), username);
        loginController.setPassword(loginPagePOM.getPasswordField(), password);
        DriverHelper.clickXpath(loginPagePOM.getloginSignInButton());
    }

    public void v_VerifyLaunchPadAndFlipCards() {
        String replacingValue = "\"";
        boolean checkLaunchPad = false;
        checkLaunchPad = DriverHelper.verifyDisplayByXpath(launchpadPOM.getHeaderlaunchPad());
        if (checkLaunchPad) {
            ConsoleLogger.SuccessLog("launchPad on header is displayed....");
        } else {
            ConsoleLogger.DebugLog("launchPad on header is NOT displayed....!!");
        }

        /*boolean checkCurriculum = false;
        checkCurriculum = driverHelper.verifyDisplayByXpath(launchpadPOM.getcurriculamInstructionsFlipCard());
        if (checkCurriculum) {
            ConsoleLogger.SuccessLog("Curriculum Instruction flipcard is displayed....");
        } else {
            ConsoleLogger.DebugLog("Curriculum Instruction flipcard is NOT displayed....!!");
        }*/

        boolean checkMyLinks = false;
        checkMyLinks = DriverHelper.verifyDisplayByXpath(launchpadPOM.getmyLinksFlipCard());
        if (checkMyLinks) {
            ConsoleLogger.SuccessLog("My Link flipcard is displayed....");
        } else {
            ConsoleLogger.DebugLog("My Link flipcard is NOT displayed....!!");
        }

//        boolean checkScore = false;
//        checkScore = DriverHelper.verifyDisplayByXpath(launchpadPOM.getscoreFlipCard());
//        if (checkScore) {
//            ConsoleLogger.SuccessLog("Score flipcard is displayed....");
//        } else {
//            ConsoleLogger.DebugLog("Score flipcard is NOT displayed....!!");
//        }

       /* boolean checkTxPro = false;
        checkTxPro = driverHelper.verifyDisplayByXpath(launchpadPOM.gettxProFlipCard());
        if (checkTxPro) {
            ConsoleLogger.SuccessLog("TxPro flipcard is displayed....");
        } else {
            ConsoleLogger.DebugLog("TxPro flipcard is NOT displayed....!!");
        }*/

        boolean checkAdmin = false;
        checkAdmin = DriverHelper.verifyDisplayByXpath(launchpadPOM.getadminFlipCard());
        if (checkAdmin) {
            ConsoleLogger.SuccessLog("Admin flipcard is displayed....");
        } else {
            ConsoleLogger.DebugLog("Admin flipcard is NOT displayed....!!");
        }

       /* boolean checkAssessment = false;
        checkAssessment = driverHelper.verifyDisplayByXpath(launchpadPOM.getassessmentsFlipCard());
        if (checkAssessment) {
            ConsoleLogger.SuccessLog("Assessment flipcard is displayed....");
        } else {
            ConsoleLogger.DebugLog("Assessment flipcard is NOT displayed....!!");
        }

        boolean checkEduClim = false;
        checkEduClim = driverHelper.verifyDisplayByXpath(launchpadPOM.geteduClimberFlipCard());
        if (checkEduClim) {
            ConsoleLogger.SuccessLog("EduClimber flipcard is displayed....");
        } else {
            ConsoleLogger.DebugLog("EduClimber flipcard is NOT displayed....!!");
        }
*/
        boolean checkOnline = false;
        checkOnline = DriverHelper.verifyDisplayByXpath(launchpadPOM.getonlineFlipCard());
        if (checkOnline) {
            ConsoleLogger.SuccessLog("Online flipcard is displayed....");
        } else {
            ConsoleLogger.DebugLog("Online flipcard is NOT displayed....!!");
        }

        boolean checkReports = false;
        checkReports = DriverHelper.verifyDisplayByXpath(launchpadPOM.getreportsFlipCard());
        if (checkReports) {
            ConsoleLogger.SuccessLog("Reports flipcard is displayed....");
        } else {
            ConsoleLogger.DebugLog("Reports flipcard is NOT displayed....!!");
        }

//        boolean checkSurvey = false;
//        checkSurvey = DriverHelper.verifyDisplayByXpath(launchpadPOM.getsurveysFlipCard());
//        if (checkSurvey) {
//            ConsoleLogger.SuccessLog("Survey flipcard is displayed....");
//        } else {
//            ConsoleLogger.DebugLog("Survey flipcard is NOT displayed....!!");
//        }
//
//        boolean checkDistrictName = false;
//        checkDistrictName = DriverHelper.verifyElementTextByXpath(launchpadPOM.getLaunchPadHeaderDistrictName(), csvDataReaderLaunchPadPage.getHeaderDistrictName());
//        if (checkDistrictName) {
//            ConsoleLogger.SuccessLog("DistrictName flipcard is displayed....");
//        } else {
//            ConsoleLogger.DebugLog("DistrictName flipcard is NOT displayed....!!");
//        }

        boolean checkUserName = false;
        checkUserName = DriverHelper.replaceAndVerifyTextByXpath(launchpadPOM.getHeaderUserInfo(), csvDataReaderLaunchPadPage.getHeaderUserName());
        if (checkUserName) {
            ConsoleLogger.SuccessLog("UserName on the top right corner of the launchpad header is displayed....");
        } else {
            ConsoleLogger.DebugLog("UserName on the top right corner of the launchpad header is NOT displayed....!!");
        }
    }

    public void e_Logout() {
        BrowserInitHelper.getMinWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(launchpadPOM.getHeaderUserInfo())));
        DriverHelper.clickXpath(launchpadPOM.getHeaderUserInfo());
        BrowserInitHelper.getMinWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(launchpadPOM.getLogOutButton())));
        DriverHelper.clickXpath(launchpadPOM.getLogOutButton());
    }

    public void v_LoginPage() {
        boolean checkUsenameField = false;
        checkUsenameField = DriverHelper.verifyDisplayByXpath(loginPagePOM.getUserNameField());
        if (checkUsenameField) {
            ConsoleLogger.SuccessLog("Usename field after logout is displayed....");
        } else {
            ConsoleLogger.DebugLog("Usename field after logout is NOT displayed....!!");
        }
        Assert.assertTrue(checkUsenameField);
    }

    public void e_ClickLognPageLinks() {

    }

    public void v_VerifyLoginPageLinks() {
       // boolean checkUrl = false;
//        List<WebElement> links=BrowserInitHelper.getInstance().findElements(By.xpath(loginPagePOM.getwebSiteLinks()));
//        for (int i = 0; i < links.size(); i++) {
//            DriverHelper.validateUrlResponseCodeByXpath(loginPagePOM.getwebSiteLinks());
//                    }
//        checkUrl = DriverHelper.validateUrlResponseCodeByXpath(loginPagePOM.getwebSiteLinks());
//        if (checkUrl) {
//            ConsoleLogger.SuccessLog("All the links on the login page are verified....");
//        } else {
//            ConsoleLogger.DebugLog("Failed to verify All the links on the login page....!!");
//        }
//        Assert.assertTrue(checkUrl);
    }

    public void v_VersionNumber() {
        boolean checkVersion = false;
        BrowserInitHelper.getMinWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginPagePOM.getVersionNumber())));
        checkVersion = DriverHelper.verifyElementTextByXpath(loginPagePOM.getVersionNumber(), csvDataReaderLoginPage.getVersion());
        if (checkVersion) {
            ConsoleLogger.SuccessLog("Version number on the login page is verified....");
        } else {
            ConsoleLogger.DebugLog("Failed to verify Version number on the login page....!!");
        }
        Assert.assertTrue(checkVersion);
    }

    public void e_ClickForgotPwdLink() {
        BrowserInitHelper.getMinWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginPagePOM.getForgotPwdLinkText())));
        driverHelper.clickXpath(loginPagePOM.getForgotPwdLinkText());
    }

    public void v_ForgotPwdFields() {
        boolean checkForgotPwdHeader = false;
        checkForgotPwdHeader = DriverHelper.verifyDisplayByXpath(loginPagePOM.getForgotPwdPageHeader());
        if (checkForgotPwdHeader) {
            ConsoleLogger.SuccessLog("Forgot Password header of the login page is verified....");
        } else {
            ConsoleLogger.DebugLog("Failed to verify Forgot Password header of the login page....!!");
        }
        Assert.assertTrue(checkForgotPwdHeader);

        boolean checkForgotPwdUserName = false;
        checkForgotPwdUserName = DriverHelper.verifyDisplayByXpath(loginPagePOM.getForgotPwdUserName());
        if (checkForgotPwdUserName) {
            ConsoleLogger.SuccessLog("Forgot Password Username field of the login page is verified....");
        } else {
            ConsoleLogger.DebugLog("Failed to verify Forgot Password Username field  of the login page....!!");
        }
        Assert.assertTrue(checkForgotPwdUserName);

        boolean checkForgotPwdEmail = false;
        checkForgotPwdEmail = DriverHelper.verifyDisplayByXpath(loginPagePOM.getForgotPwdEmail());
        if (checkForgotPwdEmail) {
            ConsoleLogger.SuccessLog("Forgot Password Email field of the login page is verified....");
        } else {
            ConsoleLogger.DebugLog("Failed to verify Forgot Password Email field  of the login page....!!");
        }
        Assert.assertTrue(checkForgotPwdEmail);

        boolean checkForgotPwdSubmit = false;
        checkForgotPwdSubmit = DriverHelper.verifyDisplayByXpath(loginPagePOM.getForgotPwdSubmit());
        if (checkForgotPwdEmail) {
            ConsoleLogger.SuccessLog("Forgot Password Submit field of the login page is verified....");
        } else {
            ConsoleLogger.DebugLog("Failed to verify Forgot Password Submit field  of the login page....!!");
        }
        Assert.assertTrue(checkForgotPwdSubmit);

        boolean checkForgotPwdCancel = false;
        checkForgotPwdCancel = DriverHelper.verifyDisplayByXpath(loginPagePOM.getForgotPwdCancel());
        if (checkForgotPwdCancel) {
            ConsoleLogger.SuccessLog("Forgot Password Cancel field of the login page is verified....");
        } else {
            ConsoleLogger.DebugLog("Failed to verify Forgot Password Cancel field  of the login page....!!");
        }
        Assert.assertTrue(checkForgotPwdCancel);

    }

    public void e_CancelForgotPwd() {
        BrowserInitHelper.getMinWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginPagePOM.getForgotPwdCancel())));
        DriverHelper.clickXpath(loginPagePOM.getForgotPwdCancel());
    }

    public void v_LoginPageAfterForgotPassword() {
        boolean checkUsename = false;
        checkUsename = DriverHelper.verifyDisplayByXpath(loginPagePOM.getUserNameField());
        if (checkUsename) {
            ConsoleLogger.SuccessLog("Verified Username field after cancelling Forgot password pop up cancel....");
        } else {
            ConsoleLogger.DebugLog("Failed to verify Username field after cancelling Forgot password pop up cancel....!!");
        }
        Assert.assertTrue(checkUsename);
    }

    public void e_EnterStudentPortalValidUnValidPwd() {
        DriverHelper.sendKeysXpath(loginPagePOM.getUserNameField(), studentUn);
        loginController.setPassword(loginPagePOM.getPasswordField(), studentPwd);
        DriverHelper.clickXpath(loginPagePOM.getloginSignInButton());
    }

    public void v_StudentPortalLink() {
        boolean checkStudentPortal = false;
        checkStudentPortal = DriverHelper.verifyDisplayByXpath(loginPagePOM.getstudentPortalLink());
        if (checkStudentPortal) {
            ConsoleLogger.SuccessLog("Student portal link is verified successfully....");
        } else {
            ConsoleLogger.DebugLog("Failed to verify Student portal link....!!");
        }
        Assert.assertTrue(checkStudentPortal);
    }

    public void e_ClickStudentPortalLink() {
        BrowserInitHelper.getMinWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginPagePOM.getstudentPortalLink())));
        DriverHelper.clickXpath(loginPagePOM.getstudentPortalLink());
    }

    public void v_StudentPortalLoginPage() {
        boolean checkStudentAccess = false;
        checkStudentAccess = DriverHelper.verifyDisplayByXpath(loginPagePOM.getStudentAccessText());
        if (checkStudentAccess) {
            ConsoleLogger.SuccessLog("Student portal Login page is verified successfully....");
        } else {
            ConsoleLogger.DebugLog("Failed to verify Student portal Login page....!!");
        }
        Assert.assertTrue(checkStudentAccess);
    }

    public void e_EnterStudentPortalCredentials() {
        DriverHelper.sendKeysXpath(loginPagePOM.getStudentPageUserNameField(), username);
        loginController.setPassword(loginPagePOM.getPasswordField(), password);
        DriverHelper.clickXpath(loginPagePOM.getStudentPageSignInButton());
    }

    public void v_StaffPortalLink() {
        boolean checkStudentPortal = false;
        checkStudentPortal = DriverHelper.verifyDisplayByXpath(loginPagePOM.getstaffPortalLink());
        if (checkStudentPortal) {
            ConsoleLogger.SuccessLog("Staff portal link is verified successfully....");
        } else {
            ConsoleLogger.DebugLog("Failed to verify Staff portal link....!!");
        }
        Assert.assertTrue(checkStudentPortal);
    }

    public void e_ClickStaffPortalLink() {
        BrowserInitHelper.getMinWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginPagePOM.getstaffPortalLink())));
        DriverHelper.clickXpath(loginPagePOM.getstaffPortalLink());
    }

    public void v_StaffPortalLoginPage() {
        boolean checkStudentAccess = false;
        checkStudentAccess = DriverHelper.verifyDisplayByXpath(loginPagePOM.getstaffAccessText());
        if (checkStudentAccess) {
            ConsoleLogger.SuccessLog("Staff portal Login page is verified successfully....");
        } else {
            ConsoleLogger.DebugLog("Failed to verify Staff portal Login page....!!");
        }
        Assert.assertTrue(checkStudentAccess);
    }
}
