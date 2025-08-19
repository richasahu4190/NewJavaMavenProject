package Selenium_Labs;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Lab8_Lab4Test {
    WebDriver driver;

    @Test(priority = 1)
    public void verifyTitleAndNavigation() throws InterruptedException {
     
        Assert.assertEquals(driver.getTitle(), "Your Store");
        System.out.println("Title Verified: " + driver.getTitle());

        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Mac (1)")).click();

        WebElement sort = driver.findElement(By.id("input-sort"));
        Select sle = new Select(sort);
        sle.selectByVisibleText("Name (A - Z)");

        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")).click();
        System.out.println("Product sorted and Add to Cart clicked");
    }

    @Test(priority = 2)
    public void searchProduct() throws InterruptedException {
        // Search for a product
        driver.findElement(By.name("search")).sendKeys("Mobile");
        driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
        Thread.sleep(2000);

        // Clear search, enable description and search again
        driver.findElement(By.id("input-search")).clear();
        driver.findElement(By.name("description")).click();
        driver.findElement(By.id("button-search")).click();

        System.out.println("Search functionality executed successfully");
    }

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximize window
        driver.get("https://tutorialsninja.com/demo/index.php");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit(); // close browser
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }
}
