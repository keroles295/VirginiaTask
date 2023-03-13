package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import testClasses.PageInitializer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class CommonMethods extends PageInitializer {

    public static WebDriver driver;

    /*

      This method opens a browser, maximizes window and sets implicit wait

     */
    @BeforeMethod
    public static void openBrowserAndLaunchApplication(){
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        /*
        cross browser testing
         */
        switch (ConfigReader.getPropertyValue("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }

        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        //this method is used to initialize all the objects of the pages at the very beginning
        initializePageObjects();
    }

    /*
    This method to close the Browser
     */
    @AfterMethod
   public static void closeBrowser(){
       driver.quit();
    }

    /*
    This method to clear the text field and send keys
     */
    public static void sendText(WebElement element, String textToSend){
        element.clear();
        element.sendKeys(textToSend);
    }

    public static WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }
    /*
    This method to provide wait until the element be clickable
     */


    public static void waitForApplicability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /*
    This method to click after waiting for the element being clickable
     */
    public static void click(WebElement element){
        waitForApplicability(element);
        element.click();
    }

    /*
    This method to select a value from dropdown By the visible text
     */
    public static void selectDdValue(WebElement element, String textToSelect) {

        try {
            Select select = new Select(element);
            List<WebElement> options = select.getOptions();

            for (WebElement el : options) {
                if (el.getText().equals(textToSelect)) {
                    select.selectByVisibleText(textToSelect);
                    break;
                }
            }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }
    }


    public static JavascriptExecutor getJsExecutor(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        return js;
    }
    /*
    This method provide js click
   */
    public static void jsClick(WebElement element){
        getJsExecutor().executeScript("arguments[0].click();", element);
    }

    /*
     This method to take the screenshot
     */

    public static void takeScreenshot(String fileName){
        TakesScreenshot ts = (TakesScreenshot) driver;

        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        /*
        This method provide how to name the screenshot
         */

        try {
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILEPATH +
                    fileName + " " + getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
     This method to get the time in specific format so that we can add it in the name of screenshot
     */
    public static String getTimeStamp(String pattern){
        Date date = new Date();
        /*
        To format the date according to the choice of our own
         */
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }






}
