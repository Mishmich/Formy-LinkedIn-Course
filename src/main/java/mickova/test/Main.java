package mickova.test;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://formy-project.herokuapp.com/form");

        submitForm(driver);

        waitForAlert(driver);

        assertEquals("The form was successfully submitted!", getAlertText(driver));

        driver.quit();
    }

    public static void submitForm(WebDriver driver) {
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

    public static void waitForAlert(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert")));
    }

    public static String getAlertText(WebDriver driver) {
        WebElement alert = driver.findElement(By.className("alert"));
        return alert.getText();
    }
}
