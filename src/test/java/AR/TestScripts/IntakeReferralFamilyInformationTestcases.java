
// https://dev.azure.com/RedMane-mCase-AR-CCWIS/15996bff-a24e-4d9f-b135-1a80c9a3cab3/_apis/wit/workItems/49169

package AR.TestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import AR.Framework.CommonUtils;
import AR.Framework.TestData;
import AR.Model.IntakePersonModel;
import AR.PageObjects.CommonObjects;
import AR.PageObjects.Intake.FamilyInformationPageRepo;

public class IntakeReferralFamilyInformationTestcases {

	@Test
	public void fillFamilyInformation() {

		IntakePersonModel ipm = TestData.GetCurrentIntakePersonModel();

		CommonUtils.CreateExtentTest("Fill in Family Information");
		WebDriver driver = CommonUtils.getDriver();
		FamilyInformationPageRepo familyInfoPage = new FamilyInformationPageRepo(driver);

		familyInfoPage.getFamilyNameInput().sendKeys(ipm.getFamilyName());

		familyInfoPage.getFamilyAddressInput().sendKeys(ipm.getFamilyAddress());

		CommonUtils.LogToExtent("Entered Family name and Family address");

		familyInfoPage.getAddClientButton().click();
		CommonUtils.LogToExtent("Clicked on Add client button");

		familyInfoPage.getUnknownClientCheckbox().click();

		CommonUtils.jsClick(familyInfoPage.getParticipatingAsChildOption());

		CommonObjects commonObjects = new CommonObjects();

		commonObjects.getCheckboxByAssociateLabel(ipm.getRole()).click();
		CommonUtils.LogToExtent("Added client");

		commonObjects.getTextareaByLabel("Other Locating Information").sendKeys(ipm.getLocatingInformation());
		CommonUtils.LogToExtent("Entered other locating information");

		CommonUtils.LogToExtent("Filled in all mandatory fields");
		CommonUtils.jsClick(commonObjects.getNextSectionButton());
		CommonUtils.LogToExtent("Moved to next section");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void testResult(ITestResult itestResult) {
		CommonUtils.testResult(itestResult);
	}
}
