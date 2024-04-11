
// Link to Azure DevOps Work Item: https://dev.azure.com/RedMane-mCase-AR-CCWIS/15996bff-a24e-4d9f-b135-1a80c9a3cab3/_apis/wit/workItems/49709
package AR.PageObjects.Intake;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SDMDecisionPageRepo {

    WebDriver driver;

    // Constructor
    public SDMDecisionPageRepo(WebDriver driver) {
        this.driver = driver;
    }

    // Method to get Screen Override Option by Label
    public WebElement getScreenOverrideOptionByLabel(String label) {
        return driver.findElement(By.xpath("(//input[@type='radio' and contains(@value,'" + label + "')])[1]"));
    }

    // Method to get Rationale Text Area
    public WebElement getRationaleTextArea() {
        return driver.findElement(By.xpath("/html/body/div[3]/div/form/div[3]/div/main/div/div[2]/div/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[6]/div[2]/div/div/div/div[25]/mc-field-instance/div/mc-long-string/div/div/div/div[1]/mc-long-string-edit/div/div/textarea"));
    }
}