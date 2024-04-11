
// https://dev.azure.com/RedMane-mCase-AR-CCWIS/15996bff-a24e-4d9f-b135-1a80c9a3cab3/_apis/wit/workItems/49167
package AR.TestScripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import AR.Framework.CommonUtils;
import AR.Framework.TestData;
import AR.Model.IntakePersonModel;
import AR.PageObjects.CommonObjects;
import AR.PageObjects.Intake.IntakeInformationPageRepo;

public class IntakeInformationTestcases {

	WebDriver driver = CommonUtils.getDriver();
	
    @Test
    public void FillIntakeInformation() throws InterruptedException {
        IntakePersonModel ipm = TestData.GetCurrentIntakePersonModel();
        
    	CommonUtils.CreateExtentTest("Fill in Intake Information");
        
        IntakeInformationPageRepo intakePage = new IntakeInformationPageRepo(CommonUtils.getDriver());
        intakePage.getDateTimeInput().sendKeys(ipm.getDate()); //"20-03-20240310"
        CommonUtils.LogToExtent("Entered Date Time");

        Select referralSourceDropdown = new Select(intakePage.getIntakeReferralSourceDropdown());
        referralSourceDropdown.selectByValue(ipm.getReferralSource());
        CommonUtils.LogToExtent("Referral Source selected");
        
        scrollDownPage();
        
        Thread.sleep(2000);
        
        intakePage.getMandatedReporterOption("Yes").click();
        
        intakePage.getReporterInput().sendKeys(ipm.getReporterInput());
        //Thread.sleep(3000);
        intakePage.getReporterInput().click();
        Thread.sleep(3000);

        CommonObjects commonObjects = new CommonObjects();
        CommonUtils.jsClick(commonObjects.getDynamicDropdownList(ipm.getReporterInput()));


//        CommonUtils.jsClick(intakePage.getMandatedReporterOption("Yes")); //modify instruction
//        intakePage.getReporterInput().click();
//        intakePage.getReporterInput().sendKeys("Test");
//        Thread.sleep(3000);
//        
//        CommonObjects commonObjects = new CommonObjects();
//        CommonUtils.jsClick(commonObjects.getDynamicDropdownList("AS Test"));
//        //CommonUtils.jsClick(intakePage.getReporterDynamicDropdown("AS Test")); //modify instruction
//        //intakePage.getReporterInput().click();
//        Thread.sleep(2000);

        
        
        Select primaryRelationshipDropdown = new Select(intakePage.getPrimaryRelationshipDropdown());
        primaryRelationshipDropdown.selectByValue(ipm.getPrimaryRelationship());
        //Thread.sleep(2000);

        Select secondaryRelationshipDropdown = new Select(intakePage.getSecondaryRelationshipDropdown());
        secondaryRelationshipDropdown.selectByVisibleText(ipm.getSecondaryRelationship());

        CommonUtils.LogToExtent("Added reporter");
        
        
        CommonUtils.jsClick(commonObjects.getNextSectionButton());
        CommonUtils.LogToExtent("Moved to Next Section");
    }

    @AfterMethod
    public void testResult(ITestResult itestResult) {
        CommonUtils.testResult(itestResult);
    }

    // Additional helper method
    private void scrollDownPage() {
    	JavascriptExecutor js = (JavascriptExecutor) CommonUtils.driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        
    }
}
