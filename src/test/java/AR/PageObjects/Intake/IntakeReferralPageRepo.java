package AR.PageObjects.Intake;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IntakeReferralPageRepo {

    private WebDriver driver;

    public IntakeReferralPageRepo(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAddRelationshipButton() {
        return driver.findElement(By.xpath("//button[@aria-label='Add relationship']"));
    }

    public WebElement getSearchInput() {
        return driver.findElement(By.xpath("//input[@aria-label='Search this datalist']"));
    }

    public WebElement getSearchIcon() {
        return driver.findElement(By.xpath("//input[@aria-label='Search this datalist']/preceding-sibling::button/i"));
    }

    public WebElement getSearchResultTable() {
        return driver.findElement(By.xpath("//div[contains(text(),'Indicates Draft Records')]/following-sibling::div//tbody"));
    }
}