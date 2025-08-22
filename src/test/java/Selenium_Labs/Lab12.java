package Selenium_Labs;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab12 {

    public static void main(String[] args) throws IOException, InterruptedException {

        Properties prob = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\Mayank\\OneDrive\\Desktop\\RICHA\\02-08-2025\\config.properties");
        prob.load(fis);

        String url = prob.getProperty("url");
        String username = prob.getProperty("username");
        String password = prob.getProperty("password");

       
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String title = driver.getTitle();
        System.out.println("The Title is: " + title);

        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(3000); 

        if (driver.getPageSource().contains("Dashboard")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }

        driver.quit();
    }
}
