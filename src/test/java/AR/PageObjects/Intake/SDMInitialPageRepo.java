package AR.PageObjects.Intake;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SDMInitialPageRepo {
    
    private WebDriver driver;

    public SDMInitialPageRepo(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getRadioOptionYesNo(int questionNumber, String optionValue) {
        int columnNumber;
        if (optionValue.equalsIgnoreCase("Yes")) {
            columnNumber = 2;
        } else if (optionValue.equalsIgnoreCase("No")) {
            columnNumber = 3;
        } else {
            throw new IllegalArgumentException("Invalid option value, must be either 'Yes' or 'No'");
        }
        return driver.findElement(By.xpath("//span[contains(text(),'Section 1. Initial Screening')]/../../../following-sibling::div//table//tbody/tr["+questionNumber+"]//td["+columnNumber+"]//input"));
    }
    
    public WebElement getRadioOptionYesByLabel(String label) {
        return driver.findElement(By.xpath("//span[contains(text(),'"+label+"')]/../../../../../following-sibling::td[1]//input[@type='radio']"));
    }

    public WebElement getRadioOptionNoByLabel(String label) {
        return driver.findElement(By.xpath("//span[contains(text(),'"+label+"')]/../../../../../following-sibling::td[2]//input[@type='radio']"));
    }
}