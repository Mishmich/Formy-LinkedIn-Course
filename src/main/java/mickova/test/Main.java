package mickova.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

        driver.get("https://formy-project.herokuapp.com/switch-window");
        WebElement alertBtn = driver.findElement(By.id("alert-button"));
        alertBtn.click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);  // Just to see the alert before accepting
        alert.accept();
        driver.quit();
    }
}
