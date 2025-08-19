package Selenium_Labs;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.nio.channels.Selector;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Lab8_Lab3Test {
	WebDriver driver;
	WebDriverWait wait;
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
	  
	  Reporter.log("Starting test with sort index: " + n + " and product: " + s, true);

      driver.get("https://tutorialsninja.com/demo/index.php?");
      Reporter.log("Navigated to homepage", true);

      driver.findElement(By.linkText("Desktops")).click();
      Reporter.log("Clicked on Desktops link", true);

      driver.findElement(By.linkText(s)).click();
      Reporter.log("Selected product: " + s, true);

      WebElement sortele = driver.findElement(By.xpath("//select[@id='input-sort']"));
      Select sortSelect = new Select(sortele);
      sortSelect.selectByIndex(n);
      Reporter.log("Sorted products using index: " + n, true);

      driver.findElement(By.xpath("//div[@class='button-group']//button")).click();
      Reporter.log("Clicked on Add to Cart button", true);

      Reporter.log("Test completed successfully for product: " + s, true);
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		  Reporter.log("Browser launched and maximized", true);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  Reporter.log("Browser closed", true);
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "Mac (1)" },
      new Object[] { 2, "Mac (1)"},
    };
  }
  @BeforeClass
  public void beforeClass() {
	  Reporter.log("BeforeClass executed", true);
  }

  @AfterClass
  public void afterClass() {
	  Reporter.log("AfterClass executed", true);
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}