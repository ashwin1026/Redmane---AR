// https://dev.azure.com/RedMane-mCase-AR-CCWIS/15996bff-a24e-4d9f-b135-1a80c9a3cab3/_apis/wit/workItems/48910
package AR.PageObjects.Intake;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IntakeInformationPageRepo {
    
    private WebDriver driver;
    
    // Constructor
    public IntakeInformationPageRepo(WebDriver driver) {
        this.driver = driver;
    }
    
    // Get method for DateTime input
    public WebElement getDateTimeInput() {
        return driver.findElement(By.xpath("//span[text()='Intake Information']/../../../following-sibling::div//input[1]"));
    }
    
    // Get method for Intake Referral Source Dropdown
    public WebElement getIntakeReferralSourceDropdown() {
        return driver.findElement(By.xpath("//label[text()='Intake Referral Source']/../following-sibling::mc-dropdown//select"));
    }
    
    // Get method for Reporter Add Button
    public WebElement getReporterAddButton() {
        return driver.findElement(By.xpath("//button[text()='Add']"));
    }
    
    // Get method for Mandated Reporter Option
    public WebElement getMandatedReporterOption(String value) {
        return driver.findElement(By.xpath("//input[@value='" + value + "']"));
    }
    
    // Get method for Reporter Input
    public WebElement getReporterInput() {
        return driver.findElement(By.xpath("//input[@aria-label='Dynamic Dropdown - Single Select Collapsed']"));
    }
    
    // Get method for Reporter Dynamic Dropdown
    public WebElement getReporterDynamicDropdown(String text) {
        return driver.findElement(By.xpath("//div[text()='" + text + "']"));
    }
    
    // Get method for Primary Relationship Dropdown
    public WebElement getPrimaryRelationshipDropdown() {
        return driver.findElement(By.xpath("//label[text()='Primary Relationship']/../following-sibling::mc-dropdown//select"));
    }
    
    // Get method for Secondary Relationship Dropdown
    public WebElement getSecondaryRelationshipDropdown() {
        return driver.findElement(By.xpath("//select[@aria-label='Secondary Relationship options']"));
    }
}