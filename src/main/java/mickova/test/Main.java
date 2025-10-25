package mickova.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver-win64/chromedriver.exe/");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://formy-project.herokuapp.com/datepicker");
        WebElement datepicker = driver.findElement(By.id("datepicker"));
        datepicker.sendKeys("10/25/2025");
        datepicker.sendKeys(Keys.RETURN);
        Thread.sleep(2000);  // Pause to see the result

        driver.quit();
    }
}
