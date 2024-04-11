
package AR.TestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import AR.Framework.CommonUtils;
import AR.Framework.TestData;
import AR.Model.IntakePersonModel;
import AR.PageObjects.CommonObjects;
import AR.PageObjects.Intake.NarrativePageRepo;

public class IntakeReferralNarrativeTestcases {

	// Link to Azure board work item: https://dev.azure.com/RedMane-mCase-AR-CCWIS/15996bff-a24e-4d9f-b135-1a80c9a3cab3/_apis/wit/workItems/49711

	@Test(description = "FillNarrative")
	public void fillInNarrativeInformation() throws Exception {
		
		IntakePersonModel ipm = TestData.GetCurrentIntakePersonModel();
		
		WebDriver driver = CommonUtils.getDriver(); 
		CommonUtils.CreateExtentTest("Fill in Narrative Information");
		NarrativePageRepo narrativePage = new NarrativePageRepo(driver);

		narrativePage.getDateOfIncidentRadioOption("Yes").click();
		narrativePage.getMostRecentIncidentDate().sendKeys(ipm.getDateOfIncident());
		
		narrativePage.getCountyOfIncidentInput().click();
		narrativePage.getCountyOfIncidentInput().sendKeys(ipm.getCountyOfIncident());

		CommonObjects commonObjects = new CommonObjects();
		CommonUtils.jsClick(commonObjects.getDynamicDropdownList(ipm.getCountyOfIncident()));
		CommonUtils.LogToExtent("Incident date and county is entered");

		CommonUtils.jsClick(commonObjects.getCheckboxByAriaLabel(ipm.getStatementsForAllegations()));
		CommonUtils.jsClick(narrativePage.getReporterWorriesTextarea());
		narrativePage.getReporterWorriesTextarea().sendKeys(ipm.getReporterWorries());

		Select lawEnforcementDropdown = new Select(narrativePage.getLawInforcementDropdown());
		lawEnforcementDropdown.selectByValue(ipm.getLawEnforcement());
		CommonUtils.LogToExtent("Law enforcement is selected");

		CommonUtils.jsClick(commonObjects.getCheckboxByAssociateLabel(ipm.getSafetyIssue()));
		CommonUtils.LogToExtent("Criminal history checkbox is selected");

		narrativePage.getAdditionalInfoTextarea().sendKeys(ipm.getAdditionalInfo());

		CommonUtils.jsClick(commonObjects.getCheckboxByTableColumnHeader(ipm.getFamilySupport(), 1, 5));
		CommonUtils.LogToExtent("Family resource Other is selected");

	    CommonUtils.jsClick(commonObjects.getTextareaByLabel("Other Family or Community Support text-area input"));
	    commonObjects.getTextareaByLabel("Other Family or Community Support text-area input").sendKeys(ipm.getOtherFamilySupport());

		CommonUtils.jsClick(commonObjects.getNextSectionButton());
		CommonUtils.LogToExtent("Moved to next section");
	}

	@AfterMethod
	public void afterTestMethod(ITestResult iTestResult) {
		CommonUtils.testResult(iTestResult);
	}
}
