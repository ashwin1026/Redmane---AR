
package AR.TestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import AR.Framework.CommonUtils;
import AR.Framework.TestData;
import AR.Model.IntakePersonModel;
import AR.PageObjects.CommonObjects;


public class IntakeReferralSDMScreeningTestcases {

    @Test
    public void FillSDMScreening() {
    	
    	IntakePersonModel ipm = TestData.GetCurrentIntakePersonModel();
    	
        CommonUtils.CreateExtentTest("Fill in SDM Screening");
        WebDriver driver = CommonUtils.getDriver();
        CommonObjects commonObjects = new CommonObjects();

        CommonUtils.jsClick(commonObjects.getCheckboxByAssociateLabel(ipm.getChildDeath()));
        CommonUtils.jsClick(commonObjects.getCheckboxByAssociateLabel(ipm.getMentalInjury()));
        CommonUtils.jsClick(commonObjects.getCheckboxByAssociateLabel(ipm.getNeglect1()));
        CommonUtils.jsClick(commonObjects.getCheckboxByAssociateLabel(ipm.getNeglect2()));
        CommonUtils.jsClick(commonObjects.getCheckboxByAssociateLabel(ipm.getNeglect3()));
        //CommonUtils.jsClick(commonObjects.getCheckboxByAriaLabel("No maltreatment"));

        CommonUtils.LogToExtent("Filled in screening");

        CommonUtils.jsClick(commonObjects.getNextSectionButton());
        CommonUtils.LogToExtent("Moved to next section");
    }

    @AfterMethod
    public void testResult(ITestResult iTestResult) {
        CommonUtils.testResult(iTestResult);
    }
}
