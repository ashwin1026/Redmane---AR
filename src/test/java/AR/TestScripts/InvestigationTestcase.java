
package AR.TestScripts;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import AR.Framework.CommonUtils;
import AR.Framework.IntakeSearchReader;
import AR.Framework.InvestigationDataReader;
import AR.PageObjects.InvestigationPageRepo;
import AR.PageObjects.Intake.WorkspacePageRepo;


public class InvestigationTestcase {

    // Creating a method for Investigation test
    @Test
    public void Investigation() throws InterruptedException {
       
    	//change here is that it needs to read multiple records, not one. 
    	//use  
    	//InvestigationsDataReader
    	
    	WebDriver driver = CommonUtils.getDriver();
        InvestigationDataReader datareader = new InvestigationDataReader();
        String path="C:/Development/AR%20Automated%20Testing/AR/src/test/java/AR/TestData/InvestigationCreatePerson.json";
        System.out.println(path);
        datareader.readJsonFile(path);
        InvestigationPageRepo pageRepo = new InvestigationPageRepo(driver);
        WorkspacePageRepo workspaceObjects = new WorkspacePageRepo(driver);

        CommonUtils.jsClick(pageRepo.getWorkspacesLink());
        CommonUtils.jsClick(workspaceObjects.getInvestigationLink());
        CommonUtils.jsClick(pageRepo.getAddbutton());
        Thread.sleep(3000);

        datareader.getFamilyName();
        pageRepo.getFamilyname().sendKeys(datareader.getFamilyName());
        datareader.getFamilyAddress();
        pageRepo.getFamilyAddress().sendKeys(datareader.getFamilyAddress());
        datareader.getStartDate();
        pageRepo.getStartDate().sendKeys(datareader.getStartDate());
        
        // more data entry and interactions...

        CommonUtils.LogToExtent("Navigated to Investigation Form");
        Thread.sleep(3000);
        pageRepo.getFamilyname().sendKeys(datareader.getFamilyName());
        pageRepo.getFamilyAddress().sendKeys(datareader.getFamilyAddress());
        pageRepo.getStartDate().sendKeys(datareader.getStartDate());
        Thread.sleep(3000);

//        Select dropdown = new Select(driver.findElement(By.xpath("")));
//        ((Object) dropdown).selectByIndex(2);
//        Thread.sleep(3000);

        CommonUtils.jsClick(pageRepo.getNextselection());
        Thread.sleep(3000);

        // continue with remaining steps...

        CommonUtils.jsClick(pageRepo.getSavebutton());
        Thread.sleep(3000);
        CommonUtils.jsClick(pageRepo.getInvLink());
        CommonUtils.LogToExtent("Record is created");
    }

    // Creating a method for Search test
    @Test
    public void Search() throws InterruptedException {
    	WebDriver driver = CommonUtils.getDriver();
    	InvestigationPageRepo pageRepo = new InvestigationPageRepo(driver);
    	String filePath = "AR/TestData/InvestigationSearch.json";
        String absolutePath = CommonUtils.getFullPath(filePath);
        IntakeSearchReader dataReader = new IntakeSearchReader();
        dataReader.parse(filePath);
        List<String> searches = dataReader.getValues();
        
        for (String search : searches) {
            pageRepo.getSearchInput().clear();
            pageRepo.getSearchInput().sendKeys(search);
            CommonUtils.jsClick(pageRepo.getSearchIcon());
            //aserts as well. 
            Thread.sleep(3000);
        }
    }
}