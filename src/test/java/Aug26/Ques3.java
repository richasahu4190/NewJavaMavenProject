package Aug26;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ques3 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test(dataProvider = "dp")
    public void searchProducts(String search) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        searchBox.clear();
        searchBox.sendKeys(search);
        driver.findElement(By.id("nav-search-submit-button")).click();

        List<WebElement> productTitles = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("h2.a-size-medium"))
        );

        System.out.println("Top 5 product titles for: " + search);
        for (int i = 0; i < 5 && i < productTitles.size(); i++) {
            System.out.println((i + 1) + ": " + productTitles.get(i).getText());
        }
    }

    @AfterClass
    public void teardown() {
        if (driver != null) driver.quit();
    }

    @DataProvider
    public Object[][] dp() {
        return new Object[][] { { "laptop" } };
    }
}
