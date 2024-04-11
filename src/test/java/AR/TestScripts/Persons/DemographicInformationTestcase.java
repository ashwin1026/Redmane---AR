
// Test case for Demographic Information
// https://dev.azure.com/RedMane-mCase-AR-CCWIS/15996bff-a24e-4d9f-b135-1a80c9a3cab3/_apis/wit/workItems/49634

package AR.TestScripts.Persons;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import AR.Framework.CommonUtils;
import AR.PageObjects.Persons.PersonsDemographicPageRepo;

public class DemographicInformationTestcase {

    @Test
    public void DemographicInformation() throws InterruptedException {
        WebDriver driver = CommonUtils.getDriver();
        
        PersonsDemographicPageRepo demographicPage = new PersonsDemographicPageRepo(driver);
        
        Thread.sleep(3000);
        
        demographicPage.getPersonDemographiceMCI().sendKeys("Test");
        demographicPage.getPersonDemographicLicense().sendKeys("testDriver");
        demographicPage.getPersonDemographicOtherID().sendKeys("MCN1180BG");
        demographicPage.getPersonDemographicOtherIDType().sendKeys("Passport");
        demographicPage.getPersonDemographicBirthCity().sendKeys("Texas");
        demographicPage.getPersonDemographicBirthPlace().sendKeys("Texs");
        demographicPage.getPersonDemographicBrithCountry().sendKeys("USA");
        
        CommonUtils.jsClick(demographicPage.getPersonDemographicNextButton());
    }
}
