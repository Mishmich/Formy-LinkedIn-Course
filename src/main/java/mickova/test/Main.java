package mickova.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver-win64/chromedriver.exe/");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://formy-project.herokuapp.com/dragdrop");
        WebElement image = driver.findElement(By.id("image"));
        WebElement box = driver.findElement(By.id("box"));

        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(image, box).build().perform();
        Thread.sleep(1000);

        driver.quit();
    }
}
