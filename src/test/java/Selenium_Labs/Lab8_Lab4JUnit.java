
package Selenium_Labs;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Lab8_Lab4JUnit {
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        System.out.println("✅ Browser launched successfully");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        if (driver != null) {
            driver.quit();
            System.out.println("✅ Browser closed successfully");
        }
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("🔹 Starting a new test...");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("🔹 Test finished.\n");
    }

    @Test
    public void test() {
        driver.get("https://tutorialsninja.com/demo/index.php?");
        System.out.println("🌐 Opened TutorialsNinja Demo");

        driver.findElement(By.linkText("Desktops")).click();
        System.out.println("🖥️ Clicked on Desktops");

        driver.findElement(By.linkText("Mac (1)")).click();
        System.out.println("🍎 Navigated to Mac section");

        WebElement sortele = driver.findElement(By.id("input-sort"));
        Select sortSelect = new Select(sortele);
        sortSelect.selectByIndex(1);
        System.out.println("🔽 Applied sorting by index 1");

        driver.findElement(By.xpath("//div[@class='button-group']//button")).click();
        System.out.println("🛒 Clicked Add to Cart");

        String pageTitle = driver.findElement(By.xpath("//div[@id='content']/h2")).getText();
        System.out.println("📄 Page heading: " + pageTitle);
        assertEquals("Mac", pageTitle);
        System.out.println("✅ Assertion passed: Heading is 'Mac'");

        WebElement searchele = driver.findElement(By.xpath("//input[@type='text']"));
        searchele.clear();
        searchele.sendKeys("Mobile");
        System.out.println("🔍 Entered search term: Mobile");

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[@class='input-group-btn']/button[@type='button']")));
        button.click();
        System.out.println("📌 Clicked search button");

        driver.findElement(By.xpath("//input[@placeholder='Keywords']")).clear();
        driver.findElement(By.id("description")).click();
        driver.findElement(By.id("button-search")).click();
        System.out.println("🔍 Performed advanced search");

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Monitors");
        System.out.println("🔍 Entered search term: Monitors");
    }
}
