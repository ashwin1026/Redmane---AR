package AR.TestScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import AR.Framework.CommonUtils;
import AR.PageObjects.Intake.IntakeReferralPageRepo;
import AR.PageObjects.Intake.WorkspacePageRepo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;

// https://dev.azure.com/RedMane-mCase-AR-CCWIS/15996bff-a24e-4d9f-b135-1a80c9a3cab3/_apis/wit/workItems/49165


public class WorkspaceTestcase {

    @Test
    public void navigateToIntakeReferralPage() throws InterruptedException {
        WebDriver driver = CommonUtils.getDriver();
        CommonUtils.CreateExtentTest("Navigate to Intake Referral Workspace");

        WorkspacePageRepo workspacePageRepo = new WorkspacePageRepo(driver);
        CommonUtils.jsClick(workspacePageRepo.getIntakeReferralLink());
        Thread.sleep(3000);
        CommonUtils.LogToExtent("Clicked on Intake Referral and navigated to workspace");
    }

    @AfterMethod
    public void testResult(ITestResult itestResult) {
        CommonUtils.testResult(itestResult);
    }
}