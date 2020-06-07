package Controllers;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Utils.ConsoleLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Helpers.JavascriptHelper.highlight;

/**** Login Controller *****/
public class LoginController {

    public static void setPassword(String xpath, String text) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) BrowserInitHelper.getInstance();
            executor.executeScript("document.getElementById('" + xpath + "').value='" + text + "'");
        } catch (Exception e) {
            e.printStackTrace();
            ConsoleLogger.DebugLog("Password is not entered.");
        }
    }

    public static boolean verifyInvalidCredentialErrorMsg(String xpath, String text) {
        boolean res = false;
        try {
            BrowserInitHelper.getMinWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            if (BrowserInitHelper.getInstance().findElement(By.xpath(xpath)).getText().equals(text)) {
                res = true;
            } else {
                return res;
            }
        } catch (Exception e) {
            e.printStackTrace();
            ConsoleLogger.DebugLog("Invalid username/Password error message not verified.");
        }
        return res;
    }


}
