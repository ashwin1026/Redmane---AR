
// URL for the work item in Azure DevOps
// https://dev.azure.com/RedMane-mCase-AR-CCWIS/15996bff-a24e-4d9f-b135-1a80c9a3cab3/_apis/wit/workItems/49710

package AR.TestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import AR.PageObjects.Intake.SDMDecisionPageRepo;
import AR.Framework.CommonUtils;
import AR.Framework.TestData;
import AR.Model.IntakePersonModel;
import AR.PageObjects.CommonObjects;

public class IntakeReferralSDMDecisionTestcases {

    @Test
    public void FillSDMDecision() {
        
    	IntakePersonModel ipm = TestData.GetCurrentIntakePersonModel();
    	
    	WebDriver driver = CommonUtils.getDriver();
    	SDMDecisionPageRepo sdmDecisionPage = new SDMDecisionPageRepo(driver);
        CommonUtils.jsClick(sdmDecisionPage.getScreenOverrideOptionByLabel(ipm.getScreeningOverride()));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sdmDecisionPage.getRationaleTextArea().sendKeys(ipm.getRationale());

        CommonObjects commonObjects = new CommonObjects();
        CommonUtils.jsClick(commonObjects.getNextSectionButton());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        CommonUtils.LogToExtent("SDM Decision is complete");
        CommonUtils.LogToExtent("Moved to next section");

        CommonUtils.jsClick(commonObjects.getSaveButton());
        CommonUtils.LogToExtent("Saved the record");
    }

    @AfterMethod
    public void testResult(ITestResult iTestResult) {
        CommonUtils.testResult(iTestResult);
    }
}
