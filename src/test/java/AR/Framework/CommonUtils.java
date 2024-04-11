
package AR.Framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class CommonUtils {
    public static ExtentReports extent;
    public static ExtentSparkReporter sparkReporter;
    public static ExtentTest test;
    public static WebDriver driver = null;
    public static WebDriverWait wait;
    private static int iterationCount = 0; 
    
    
    public static FluentWait getFluentWait() {
        return new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(Exception.class);
    }
    
    public static void initiateExtentReport() {
        sparkReporter = new ExtentSparkReporter("ExtentReportResults.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }
    
    public static void LogToExtent(String message) {
        test.log(Status.INFO, message);
    }
    
    public static void CreateExtentTest(String message) {
        test = extent.createTest(message);
    }
    
    public static WebDriver getDriver() {
        return driver;
    }
    
    public static void setDriver(WebDriver newDriver) {
        driver = newDriver;
    }
    
    public static void setWebDriverWait(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    
    public static void testResult(ITestResult iTestResult) {
        if(iTestResult.getStatus() == ITestResult.FAILURE) {
            test.addScreenCaptureFromPath(takeScreenshot(driver));
            test.log(Status.FAIL, iTestResult.getThrowable());
        } else if(iTestResult.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Skipped " + iTestResult.getThrowable());
        } else {
            test.log(Status.PASS, "Test Passed");
        }
    }
    
    public static String takeScreenshot(WebDriver driver) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screenshot, new File("screenshot.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "screenshot.png";
    }
    
    public static void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        try {
            executor.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String getFullPath(String filePath) {
    	Path p = Paths.get(System.getProperty("user.dir"))
                .resolve(filePath);
    	return p.toString();
    }
    
    public static void incrementCounter() {
    	iterationCount +=1; 
    }
    
    public static int getIncrementCount() {
    	return iterationCount;
    }
}
