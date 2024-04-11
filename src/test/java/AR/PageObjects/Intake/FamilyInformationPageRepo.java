package AR.PageObjects.Intake;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FamilyInformationPageRepo {
    private WebDriver driver;

    public FamilyInformationPageRepo(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFamilyNameInput() {
        return driver.findElement(By.xpath("//input[@aria-label='Family Name text input']"));
    }

    public WebElement getFamilyAddressInput() {
        return driver.findElement(By.xpath("//input[@aria-label='Family Address address input']"));
    }

    public WebElement getAddClientButton() {
        return driver.findElement(By.xpath("(//button[text()='Add'])[2]"));
    }

    public WebElement getUnknownClientCheckbox() {
        return driver.findElement(By.xpath("//input[@name='UNKNOWNCLIENT']"));
    }

    public WebElement getParticipatingAsChildOption() {
    	return driver.findElement(By.xpath("/html/body/div[3]/div/form/div[3]/div/main/div/div[2]/div[2]/div[1]/div[3]/div[2]/div[3]/div/div/div/div[2]/mc-field-instance/div/embedded-list-ui/div/div/embedded-list-horizontal-ui/div/div/table/tbody/tr[1]/td[2]/div/mc-field-instance/div/mc-dropdown/div/div/div/div[1]/mc-drop-down-radio-edit/div/div[1]/input"));
    }

    public WebElement getClientInput() {
        return driver.findElement(By.xpath("//input[@aria-label='Dynamic Dropdown - Single Select Collapsed']"));
    }

    public WebElement getClientDynamicDropdown(String text) {
        return driver.findElement(By.xpath("//div[text()='" + text + "']"));
    }

    public WebElement getRoleCheckbox(String role) {
        return driver.findElement(By.xpath("//label[contains(text(),'" + role + "')]/preceding-sibling::input"));
    }

    public WebElement getRemoveButton() {
        return driver.findElement(By.xpath("(//button[contains(text(),'Remove')])[3]"));
    }

    public WebElement getLocatingInfoTextarea() {
        return driver.findElement(By.xpath("//textarea[contains(@aria-label,'Other Locating Information and Address')]"));
    }
}