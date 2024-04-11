/**
 * https://dev.azure.com/RedMane-mCase-AR-CCWIS/15996bff-a24e-4d9f-b135-1a80c9a3cab3/_apis/wit/workItems/49707
 */
package AR.TestScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import AR.Framework.CommonUtils;
import AR.Framework.TestData;
import AR.Model.IntakePersonModel;
import AR.PageObjects.CommonObjects;
import AR.PageObjects.Intake.SDMInitialPageRepo;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class IntakeReferralSDMInitialTestcases {

    @Test(description = "FillSDMInitial")
    public void fillSDMInitial() throws InterruptedException {
    	
    	
    	WebDriver driver = CommonUtils.getDriver();
        CommonUtils.CreateExtentTest("Fill in SDM Initial Information");

        SDMInitialPageRepo sdmInitialPage = new SDMInitialPageRepo(driver);
        
        for (int i = 1; i <= 8; i++) {
        	CommonUtils.jsClick(sdmInitialPage.getRadioOptionYesNo(i, "No"));
            Thread.sleep(500);
        }
        
        CommonUtils.LogToExtent("Selected all questions option");
        
        CommonObjects commonObjects = new CommonObjects();
        
        Thread.sleep(10000);
        CommonUtils.jsClick(commonObjects.getEllipsisButton());
        Thread.sleep(2000);
        CommonUtils.jsClick(commonObjects.getSaveDraftButton());
        Thread.sleep(20000);
        CommonUtils.LogToExtent("Record saved as Draft");

        CommonUtils.jsClick(commonObjects.getEditButton());
        CommonUtils.LogToExtent("Clicked on Edit record");

        CommonUtils.jsClick(commonObjects.getLinkByPartialText("Screening"));
        Thread.sleep(4000);
        CommonUtils.LogToExtent("Moved to next section");
    }

    @AfterMethod
    public void testResult(ITestResult iTestResult) {
        CommonUtils.testResult(iTestResult);
    }
}
