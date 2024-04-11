
package AR.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginRepo {
    WebDriver driver;

    public LoginRepo(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public WebElement getUserNameInput() {
        return driver.findElement(By.id("UserName"));
    }

    public WebElement getPasswordInput() {
        return driver.findElement(By.id("Password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.id("LoginBtn"));
    }
}