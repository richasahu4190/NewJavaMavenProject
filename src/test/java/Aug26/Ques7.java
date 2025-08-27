package Aug26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Ques7{
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    @Test
    public void testTableData() {
        WebElement table = driver.findElement(By.id("table1"));

        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

        System.out.println("All Names in the first table:");
        String jasonEmail = null;

        for (WebElement row : rows) {
            String name = row.findElement(By.xpath("./td[1]")).getText();
            System.out.println(name);

            if (name.contains("Jason")) {
                jasonEmail = row.findElement(By.xpath("./td[3]")).getText();
            }
        }

        if (jasonEmail != null) {
            System.out.println("Jason's Email: " + jasonEmail);
        } else {
            System.out.println("Jason not listed in the table.");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
