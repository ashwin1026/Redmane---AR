
// https://dev.azure.com/RedMane-mCase-AR-CCWIS/15996bff-a24e-4d9f-b135-1a80c9a3cab3/_apis/wit/workItems/49228

package AR.TestScripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import AR.Framework.CommonUtils;
import AR.Framework.IntakeSearchReader;
import AR.Framework.TestData;
import AR.Model.IntakePersonModel;
import AR.PageObjects.Intake.IntakeReferralPageRepo;

public class IntakeReferralTestcases {
    
    @Test
    public void addRecord() throws InterruptedException {
    	WebDriver driver = CommonUtils.getDriver();
    	IntakeReferralPageRepo intakeReferralPageRepo = new IntakeReferralPageRepo(driver);
    	
    	//CommonUtils.wait.until(ExpectedConditions.visibilityOf(intakeReferralPageRepo.getAddRelationshipButton()));
    	
    	CommonUtils.CreateExtentTest("Add New Record");
        
        
       TestData.LoadIntakeData();
        List<IntakePersonModel> records = TestData.getIntakeData();
        Thread.sleep(8000);
        CommonUtils.wait.until(ExpectedConditions.visibilityOf(intakeReferralPageRepo.getAddRelationshipButton()));
        //intakeReferralPageRepo.getAddRelationshipButton().click();
        
        for (IntakePersonModel record : records) {
            intakeReferralPageRepo.getAddRelationshipButton().click();
            CommonUtils.LogToExtent("Clicked on Add Record + button");
            TestData.Increment();
        }
        Thread.sleep(5000);
    }
    
    @Test
    public void searchRecord() throws InterruptedException {
        CommonUtils.CreateExtentTest("Search Record");
        WebDriver driver = CommonUtils.getDriver();
        IntakeReferralPageRepo intakeReferralPageRepo = new IntakeReferralPageRepo(driver);
        IntakeSearchReader dataReader = new IntakeSearchReader();
        dataReader.parse("AR/TestData/IntakeSearch.json");
        List<String> searches = dataReader.getValues();
        
        CommonUtils.LogToExtent("Clicked on Search Magnifier");
        
        for (String search : searches) {
            intakeReferralPageRepo.getSearchInput().clear();
            intakeReferralPageRepo.getSearchInput().sendKeys(search);
            intakeReferralPageRepo.getSearchIcon().click();
            Thread.sleep(3000);
        }
    }
    
    @AfterMethod
    public void testResult(ITestResult itestResult) {
        CommonUtils.testResult(itestResult);
    }
}
