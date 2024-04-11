package AR.PageObjects.Persons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonsGeneralInfoPageRepo {

    private WebDriver driver;

    public PersonsGeneralInfoPageRepo(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPersonGeneralInfoAddress() {
        return driver.findElement(By.xpath("//input[@aria-label='Address address input']"));
    }

    public WebElement getPersonGeneralInfoPhoneNumber() {
        return driver.findElement(By.xpath("//input[@aria-label='Phone Number']"));
    }

    public WebElement getPersonGeneralInfoEmail() {
        return driver.findElement(By.xpath("//input[@aria-label='Email Address']"));
    }
}
