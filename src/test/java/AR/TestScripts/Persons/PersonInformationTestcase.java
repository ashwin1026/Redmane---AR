package AR.TestScripts.Persons;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import AR.Framework.CommonUtils;
import AR.PageObjects.Intake.WorkspacePageRepo;
import AR.PageObjects.Persons.PersonsPageRepo;

public class PersonInformationTestcase {

    @Test
    public void PersonsInformation() throws InterruptedException {
        WebDriver driver = CommonUtils.getDriver();
        
        PersonsPageRepo personsPage = new PersonsPageRepo(driver);
        WorkspacePageRepo workspacePage = new WorkspacePageRepo(driver);
        
        CommonUtils.jsClick(workspacePage.getPersonsLink());
        
        Thread.sleep(3000);
        
        CommonUtils.jsClick(personsPage.getPersonsAddbutton());
        
        Thread.sleep(3000);
        
        personsPage.getPersonFirstName().sendKeys("Divya");
        personsPage.getPersonMiddleName().sendKeys("test");
        personsPage.getPersonLastName().sendKeys("Kiran");
        personsPage.getPersonSuffix().sendKeys("Mr");
        personsPage.getPersonDOB().sendKeys("06081993");
        personsPage.getPersonSSN().sendKeys("3425789601");
        personsPage.getPersonAliases().sendKeys("Divya");
        
        CommonUtils.jsClick(personsPage.getPersonSearchButton());
        
        Thread.sleep(3000);
        
        CommonUtils.jsClick(personsPage.getPersonNewRecordButton());
    }

}
