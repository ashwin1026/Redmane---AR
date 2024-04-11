package AR.PageObjects.Persons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonAdditionalInfoPageRepo {
  
    private WebDriver driver;

    public PersonAdditionalInfoPageRepo(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getPersonCaraBabyWeightLB() {
        return driver.findElement(By.xpath("//a[contains(text(),'Your desired text here')]"));
    }
}