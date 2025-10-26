package mickova.test;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mickova.test.pages.FormPage;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://formy-project.herokuapp.com/form");

        FormPage formPage = new FormPage();

        formPage.submitForm(driver);

        waitForAlert(driver);

        assertEquals("The form was successfully submitted!", getAlertText(driver));

        driver.quit();
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
