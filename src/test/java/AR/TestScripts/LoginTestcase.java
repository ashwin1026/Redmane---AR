
package AR.TestScripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AR.Framework.CommonUtils;
import AR.Framework.InvestigationsDataReader;
import AR.Framework.LoginDataReader;
import AR.Model.InvestigationPersonModel;
import AR.PageObjects.LoginRepo;
 

public class LoginTestcase {
  
  WebDriver driver = null;
  
  @BeforeMethod
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver();
    CommonUtils.setDriver(driver);
    CommonUtils.setWebDriverWait(driver);
    CommonUtils.initiateExtentReport(); //Add instruction
    driver.get("https://auusmc-arccwis-app-mcs-qa-r2.redmane-cloud.us/Unauthenticated/Login.aspx?ReturnUrl=%2f");
    driver.manage().window().maximize();
  }
  
  @Test
  public void LoginPage() throws InterruptedException {
    String file = "src/test/java/AR/TestData/Login.json";
	LoginDataReader loginreader = new LoginDataReader(CommonUtils.getFullPath(file));
    LoginRepo loginRepo = new LoginRepo(driver);
    CommonUtils.CreateExtentTest("Login to Application");
    loginRepo.getUserNameInput().sendKeys(loginreader.getUsername());
    loginRepo.getLoginButton().click();
    loginRepo.getPasswordInput().sendKeys(loginreader.getPassword());
    loginRepo.getLoginButton().click();
    
    Thread.sleep(3000);
    CommonUtils.LogToExtent("Logged into application successfully !");
  }

  @AfterMethod
  public void testResult(ITestResult itestResult) {
    CommonUtils.testResult(itestResult);
  }
  
  @AfterSuite
  public void tearDown() {
    CommonUtils.driver.quit(); //Modify instruction
    CommonUtils.extent.flush();
  }
}