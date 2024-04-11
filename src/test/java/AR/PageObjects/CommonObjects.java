// https://dev.azure.com/RedMane-mCase-AR-CCWIS/15996bff-a24e-4d9f-b135-1a80c9a3cab3/_apis/wit/workItems/48911

package AR.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AR.Framework.CommonUtils;

public class CommonObjects {
    
    WebDriver driver = CommonUtils.getDriver();
    
    @FindBy(xpath = "//button[text()='Add']")
    private WebElement addButton;
    
    public WebElement getAddButton() {
        return addButton;
    }
    
    public WebElement getEllipsisButton() {
        return driver.findElement(By.xpath("//button[contains(@aria-label,'Ellipsis to display additional options')]"));
    }
    
    public WebElement getSaveDraftButton() {
        return driver.findElement(By.xpath("//button[contains(@aria-label,'Ellipsis to display additional options')]/following-sibling::div/div[1]/a"));
    }
    
    public WebElement getSaveNewButton() {
        return driver.findElement(By.xpath("//button[contains(@aria-label,'Ellipsis to display additional options')]/following-sibling::div/div[2]/a"));
    }
    
    public WebElement getSaveButton() {
        return driver.findElement(By.xpath("//a[text()='Save']"));
    }
    
    public WebElement getEditButton() {
        return driver.findElement(By.xpath("//a[text()='Edit']"));
    }
    
    public WebElement getLinkByPartialText(String partialText) {
        return driver.findElement(By.partialLinkText(partialText));
    }
    
    public WebElement getRadioOptionByValue(String value) {
        return driver.findElement(By.xpath("//input[@type='radio' and contains(@value,'" + value + "')]"));
    }
    
    public WebElement getYesNoOptionByQuestion(String question, String value) {
        return driver.findElement(By.xpath("//*[contains(text(),'" + question + "')]/../../following-sibling::mc-dropdown//input[@type='radio' and @value='" + value + "']"));
    }
    
    public WebElement getNextSectionButton() {
        return driver.findElement(By.xpath("//button[contains(text(),'Next Section')]"));
    }
    
    @FindBy(xpath = "//input[contains(@aria-label,'Dynamic Dropdown - Single Select Collapsed')]")
    private WebElement dynamicDropdownInput;
    
    public WebElement getDynamicDropdownInput() {
        return dynamicDropdownInput;
    }
    
    public WebElement getDynamicDropdownList(String listValue) {
        return driver.findElement(By.xpath("//a[contains(text(),'" + listValue + "')]"));
    }
    
    public WebElement getCheckboxByName(String name) {
        return driver.findElement(By.xpath("//input[@type='checkbox' and @name='" + name + "']"));
    }
    
    public WebElement getCheckboxByAssociateLabel(String label) {
        return driver.findElement(By.xpath("//label[contains(text(),'" + label + "')]/preceding-sibling::input[@type='checkbox']"));
    }
    
    public WebElement getCheckboxByAriaLabel(String labelValue) {
        return driver.findElement(By.xpath("//input[contains(@aria-label,'" + labelValue + "')]"));
    }
    
    public WebElement getCheckboxByTableColumnHeader(String head, int rowNumber, int columnNumber) {
        return driver.findElement(By.xpath("//span[contains(text(),'" + head + "')]/parent::td//parent::tr/../following-sibling::tbody//tr[" + rowNumber + "]//td[" + columnNumber + "]//input[@type='checkbox']"));
    }
    
    public WebElement getTextareaByLabel(String labelName) {
        return driver.findElement(By.xpath("//textarea[contains(@aria-label,'" + labelName + "')]"));
    }
    
    public WebElement getRequiredFieldMessageLabel() {
    	return driver.findElement(By.xpath("//span[contains(text(),'There are required fields that are missing, please review.')]"));
    }
    
}