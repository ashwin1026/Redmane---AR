package AR.PageObjects.Intake;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NarrativePageRepo {
    
    WebDriver driver;
    
    public NarrativePageRepo(WebDriver driver) {
        this.driver = driver;
    }
    
    public WebElement getDateOfIncidentRadioOption(String value) {
        return driver.findElement(By.xpath("//*[contains(text(),'Date of Incident known')]/../following-sibling::mc-dropdown//input[@type='radio' and @value='"+value+"']"));
    }
    
    public WebElement getMostRecentIncidentDate() {
    	return driver.findElement(By.xpath("//input[@aria-label='Most Recent Incident Date date input']"));
    }
    
    public WebElement getCountyOfIncidentInput() {
    	return driver.findElement(By.xpath("/html/body/div[3]/div/form/div[3]/div/main/div/div[2]/div[2]/div[1]/div[3]/div[3]/div[1]/div/div/div/div[5]/mc-field-instance/div/mc-dynamic-drop-down/div/div[1]/div[1]/div/input"));
    }
    
    public WebElement getReporterWorriesTextarea() {
        return driver.findElement(By.xpath("//label[contains(text(),'Worries')]/../following-sibling::mc-long-string//textarea"));
    }
    
    public WebElement getLawInforcementDropdown() {
        return driver.findElement(By.xpath("//label[contains(text(),'Is law enforcement involved?')]/../following-sibling::mc-dropdown//select"));
    }
    
    public WebElement getAdditionalInfoTextarea() {
        return driver.findElement(By.xpath("//textarea[contains(@aria-label,'Additional Information')]"));
    }
}