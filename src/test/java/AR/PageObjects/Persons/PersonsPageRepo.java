
package AR.PageObjects.Persons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonsPageRepo {

    private WebDriver driver;

    public PersonsPageRepo(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPersonsAddbutton() {
        return driver.findElement(By.id("btns-cdl-edit-add"));
    }

    public WebElement getPersonId() {
        return driver.findElement(By.xpath("//*[@aria-label='Person ID input filter']"));
    }

    public WebElement getPersonFirstName() {
        return driver.findElement(By.xpath("//*[@aria-label='First Name input filter']"));
    }

    public WebElement getPersonMiddleName() {
        return driver.findElement(By.xpath("//*[@aria-label='Middle Name input filter']"));
    }

    public WebElement getPersonLastName() {
        return driver.findElement(By.xpath("//*[@aria-label='Last Name input filter']"));
    }

    public WebElement getPersonSuffix() {
        return driver.findElement(By.xpath("//*[@aria-label=' Suffix input filter']"));
    }

    public WebElement getPersonGender() {
        return driver.findElement(By.xpath("//option[contains(text(),'Male')]"));
    }

    public WebElement getPersonDOB() {
        return driver.findElement(By.xpath("//*[@aria-label='Date of Birth input filter']"));
    }

    public WebElement getPersonSSN() {
        return driver.findElement(By.xpath("//*[@aria-label='Social Security Number input filter']"));
    }

    public WebElement getPersonRace() {
        return driver.findElement(By.xpath("//option[contains(text(),'Asian')]"));
    }

    public WebElement getPersonAliases() {
        return driver.findElement(By.xpath("//*[@aria-label='Aliases input filter']"));
    }

    public WebElement getPersonSearchButton() {
        return driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
    }

    public WebElement getPersonNewRecordButton() {
        return driver.findElement(By.xpath("//a[contains(text(),'New Record')]"));
    }
}
