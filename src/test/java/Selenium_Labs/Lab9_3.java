package Selenium_Labs;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab9_3 {
 WebDriver driver;

 @Parameters("browser")
 @Test
 public void test1(String browser) {
     if (browser.equalsIgnoreCase("chrome")) {
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
     } else if (browser.equalsIgnoreCase("edge")) {
         WebDriverManager.edgedriver().setup();
         driver = new EdgeDriver();
     }

     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

     driver.get("https://tutorialsninja.com/demo/index.php?");
     driver.findElement(By.linkText("Desktops")).click();
     driver.findElement(By.linkText("Mac (1)")).click();

     WebElement sort = driver.findElement(By.id("input-sort"));
     Select sle = new Select(sort);
     sle.selectByIndex(1);

     JavascriptExecutor js = (JavascriptExecutor) driver;
     js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

     driver.findElement(By.xpath("//button[contains(@onclick,'cart.add')]")).click();

     driver.quit();
 }
}
