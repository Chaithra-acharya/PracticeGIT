package Helpers;

import Utils.Config;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserInitHelper {

    private static String browser, chrome, firefox;
    private static Boolean headless;
    private static int waitTime;
    private static Config config = new Config();
    private static WebDriver driver = null;
    private static FirefoxProfile profile = new FirefoxProfile();
    public static boolean loggingEnabled = true;
    public static FirefoxOptions options = new FirefoxOptions();

    /**
     * LoggerFactory
     */
    //private static final Logger log = LoggerFactory.getLogger(BrowserInitHelper.class);

    /**
     * Creates manager  of Chrome
     */
    public static void setup() {
        config.readProperties();
        browser = config.getBrowser();
        firefox = config.getFirefox();

        if (browser.equals("chrome")) {
            ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
            System.setProperty("webdriver.chrome.silentOutput", "true");
        } else if (browser.equals("firefox") && firefox.length() != 0) {
            loggingEnabled = false;
            System.setProperty("webdriver.gecko.driver", firefox);
            profile.setPreference("devtools.console.stdout.content", true);
            //FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            options.setProfile(profile);
            driver = new FirefoxDriver(options);
        } else if (browser.equals("firefox") && firefox.length() == 0) {
            loggingEnabled = false;
            profile.setPreference("devtools.console.stdout.content", true);
            FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        } else if(browser.equals("edge")) {
            loggingEnabled = false;
            EdgeDriverManager.getInstance(DriverManagerType.EDGE).setup();
        } else if (browser.equals("safari")) {
            loggingEnabled = false;
            driver = new SafariDriver();
        }
    }

    /**
     * Tear down Chrome Driver
     */
    public static void tearDown() {
        getInstance().quit();
    }

    /**
     * Create an instance of Chrome WebDriver
     */
    private static class ChromeWebDriverHolder {
        private static final WebDriver INSTANCE = new ChromeDriver(getChromeOptions());
    }

    private static class FirefoxWebDriverHolder {
        //private static final WebDriver INSTANCE = new FirefoxDriver(getFirefoxOptions());
        private static final WebDriver INSTANCE = new FirefoxDriver();
    }

    private static class EdgeWebDriverHolder {
        private static final WebDriver INSTANCE = new EdgeDriver();
    }

    private static class SafariWebDriverHolder {
        private static final WebDriver INSTANCE = new SafariDriver();
    }

    public static ChromeOptions getChromeOptions() {
        config.readProperties();
        browser = config.getBrowser();
        headless = config.getHeadless();
        chrome = config.getChrome();

        //Path chromePath = Paths.get(chrome);

        if (!chrome.equals("")) {
            System.setProperty("webdriver.chrome.driver", chrome);
        }

        ChromeOptions options = new ChromeOptions();
        if (browser.equals("chrome") && headless == true) {
            options.addArguments("window-size=1600,1600");
            options.addArguments("--no-sandbox");
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-extensions");
            options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        } else {
            options.addArguments("window-size=1600,1600");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-extensions");
            options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        }
        return options;
    }

    public static FirefoxOptions getFirefoxOptions() {
        config.readProperties();
        browser = config.getBrowser();
        headless = config.getHeadless();
        firefox = config.getFirefox();

        System.out.println("Firefox Gecko Path==>"+firefox);

        if (!firefox.equals("")) {
            System.setProperty("webdriver.gecko.driver", firefox );
        }

        FirefoxOptions options = new FirefoxOptions();
        if (browser.equals("firefox") && headless == true) {
            //options.addArguments("window-size=1600,1600");
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-extensions");
        } else {
            //options.addArguments("window-size=1600,1600");
            options.addArguments("--disable-extensions");
        }
        return options;
    }

    public static WebDriverWait getMaxWaiter() {
        return new WebDriverWait(getInstance(), 90);
    }

    public static WebDriverWait getMinWaiter() {
        return new WebDriverWait(getInstance(), 30);
    }

    public static WebDriver getInstance() {
        if (browser.equals("chrome")) {
            return BrowserInitHelper.ChromeWebDriverHolder.INSTANCE;
        } else if (browser.equals("firefox") && firefox.length() == 0) {
            return BrowserInitHelper.FirefoxWebDriverHolder.INSTANCE;
        } else if (browser.equals("firefox") && firefox.length() != 0) {
            driver.manage().window().maximize();
            return driver;
        } else if (browser.equals("edge")) {
            return BrowserInitHelper.EdgeWebDriverHolder.INSTANCE;
        } else if (browser.equals("safari")) {
//            driver.manage().window().maximize();
            return driver;
        } else {
            return BrowserInitHelper.ChromeWebDriverHolder.INSTANCE;
        }
    }

    public static void waitUntil(String xpath) {
        BrowserInitHelper.getMinWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public void assertion(String xpath, String expected) {
        Assert.assertEquals(getMinWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).getText().trim(), expected);
    }
}
