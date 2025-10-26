package mickova.test.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FormPage {

     public void submitForm(WebDriver driver) {
        driver.findElement(By.id("first-name")).sendKeys("Mikaila");
        driver.findElement(By.id("last-name")).sendKeys("Mitzkiewich");
        driver.findElement(By.id("job-title")).sendKeys("Tester");
        driver.findElement(By.id("radio-button-1")).click();
        driver.findElement(By.id("checkbox-2")).click();
        driver.findElement(By.id("select-menu")).click();
        driver.findElement(By.cssSelector("option[value='2']")).click();
        driver.findElement(By.id("datepicker")).sendKeys("10/26/2024");
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);
        driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();
    }

}
