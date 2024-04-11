
package AR.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InvestigationPageRepo {

    private WebDriver driver;

    public InvestigationPageRepo(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getWorkspacesLink() {
        return driver.findElement(By.id("workspaceDropDown"));
    }

    public WebElement getInvestigationLink() {
        return driver.findElement(By.xpath("//a[@aria-label='Investigations']"));
    }

    public WebElement getAddbutton() {
        return driver.findElement(By.id("btns-cdl-edit-add"));
    }

    public WebElement getFamilyname() {
        return driver.findElement(By.xpath("//input[@aria-label='Family Name text input']"));
    }

    public WebElement getFamilyAddress() {
        return driver.findElement(By.xpath("//input[@aria-label='Family Address address input']"));
    }

    public WebElement getStartDate() {
        return driver.findElement(By.xpath("//input[@aria-label='Start Date / Time date-time input']"));
    }

    public WebElement getLivingArrangement() {
        return driver.findElement(By.xpath("//select[@class='form-control shadow-none form-select ng-valid ng-not-empty ng-touched ng-dirty ng-valid-parse']"));
    }

    public WebElement getNextselection() {
        return driver.findElement(By.xpath("//button[@class='btn btn-primary float-end ng-binding']"));
    }

    public WebElement getExtensionComment() {
        return driver.findElement(By.xpath("//textarea[@aria-label='Comment text-area input']"));
    }

    public WebElement getConnection() {
        return driver.findElement(By.xpath("//input[@value='Do not open a case']"));
    }

    public WebElement getCaseConnectas() {
        return driver.findElement(By.xpath("//textarea[@aria-label='Case Connect Details text-area input']"));
    }

    public WebElement getCaseType() {
        return driver.findElement(By.xpath("//select[@class='form-control shadow-none form-select ng-valid ng-not-empty ng-dirty ng-valid-parse ng-touched']"));
    }

    public WebElement getClosureMeeting() {
        return driver.findElement(By.xpath("//textarea[@aria-label='Safe Closure Meeting text-area input']"));
    }

    public WebElement getSavebutton() {
        return driver.findElement(By.xpath("//a[contains(text(),'Save')]"));
    }

    public WebElement getSearchInput() {
        return driver.findElement(By.xpath("//input[@aria-label='Search this datalist']"));
    }

    public WebElement getSearchIcon() {
        return driver.findElement(By.xpath("//button[@aria-label='Search this datalist']"));
    }

    public WebElement getInvLink() {
        return driver.findElement(By.xpath("//span/a[contains(text(),'Investigations')]"));
    }
}
