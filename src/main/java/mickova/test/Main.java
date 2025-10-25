package mickova.test;

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

        driver.get("https://formy-project.herokuapp.com/radiobutton");
        WebElement radioButton1 = driver.findElement(By.id("radio-button-1"));
        Thread.sleep(1000);
        radioButton1.click();
        Thread.sleep(1000);
        WebElement radioButton2 = driver.findElement(By.xpath("/html/body/div/div[2]/input"));
        radioButton2.click();
        Thread.sleep(1000);
        driver.get("https://formy-project.herokuapp.com/checkbox");
        WebElement check = driver.findElement(By.id("checkbox-3"));
        Thread.sleep(1000);
        check.click();
        driver.quit();
    }
}
