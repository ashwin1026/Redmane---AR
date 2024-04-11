
package AR.PageObjects.Intake;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WorkspacePageRepo {

	 private WebDriver driver;

	    public WorkspacePageRepo(WebDriver driver) {
	        this.driver = driver;
	    }

	    public WebElement getIntakeReferralLink() {
	        return driver.findElement(By.xpath("//div[text()='Intake Referrals']"));
	    }

	    public WebElement getInvestigationLink() {
	        return driver.findElement(By.cssSelector("a[aria-label='Investigations']"));
	    }

	    public WebElement getPersonsLink() {
	        return driver.findElement(By.cssSelector("a[aria-label='Persons']"));
	    }
	}

