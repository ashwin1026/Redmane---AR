
package AR.PageObjects.Persons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonsDemographicPageRepo {

    private WebDriver driver;

    public PersonsDemographicPageRepo(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPersonDemographiceMCI() {
        return driver.findElement(By.xpath("//input[@aria-label='eMCI ID text input']"));
    }

    public WebElement getPersonDemographicLicense() {
        return driver.findElement(By.xpath("//input[@aria-label='Drivers License text input']"));
    }

    public WebElement getPersonDemographicOtherID() {
        return driver.findElement(By.xpath("//input[@aria-label='Other ID Number text input']"));
    }

    public WebElement getPersonDemographicOtherIDType() {
        return driver.findElement(By.xpath("//input[@aria-label='Other ID Type text input']"));
    }

    public WebElement getPersonDemographicBirthCity() {
        return driver.findElement(By.xpath("//input[@aria-label='Birth City text input']"));
    }

    public WebElement getPersonDemographicBirthPlace() {
        return driver.findElement(By.xpath("//input[@aria-label='Place of Birth address input']"));
    }

    public WebElement getPersonDemographicBrithCountry() {
        return driver.findElement(By.xpath("//input[@aria-label='Birth County text input']"));
    }

    public WebElement getPersonDemographicReligion() {
        return driver.findElement(By.xpath("//div[@aria-label='Dynamic Dropdown - Single Select Collapsed']"));
    }

    public WebElement getPersonDemographicNextButton() {
        return driver.findElement(By.xpath("//button[contains(text(),'Next Section')]"));
    }
}
