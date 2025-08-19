package Selenium_Labs;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab8_Lab3JUnit {
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        System.out.println("=== Browser launched successfully ===");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        if (driver != null) {
            driver.quit();
            System.out.println("=== Browser closed successfully ===");
        }
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("--- Starting new test ---");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("--- Test finished ---");
    }

    @Test
    public void test() {
        System.out.println("Opening TutorialsNinja Demo site...");
        driver.get("https://tutorialsninja.com/demo/index.php?");

        System.out.println("Clicking on 'Desktops' menu...");
        driver.findElement(By.linkText("Desktops")).click();

        System.out.println("Selecting 'Mac (1)'...");
        driver.findElement(By.linkText("Mac (1)")).click();

        System.out.println("Sorting products...");
        WebElement sortele = driver.findElement(By.id("input-sort"));
        Select sortSelect = new Select(sortele);
        sortSelect.selectByIndex(1);

        System.out.println("Adding first product to cart...");
        driver.findElement(By.xpath("//div[@class='button-group']//button")).click();

        System.out.println("=== Test scenario executed successfully ===");
    }
}
