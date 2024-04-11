
package AR.PageObjects.Persons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonsCARAPageRepo {
    
    private WebDriver driver;
    
    public PersonsCARAPageRepo(WebDriver driver) {
        this.driver = driver;
    }
    
    public WebElement getPersonCaraBabyWeightLB() {
        return driver.findElement(By.xpath("//input[@aria-label=\"Baby's Weight at Birth (Lb)\"]"));
    }
    
    public WebElement getPersonCaraBabyWeightOZ() {
        return driver.findElement(By.xpath("//input[@aria-label=\"Baby's Weight at Birth (Oz)\"]"));
    }
}
