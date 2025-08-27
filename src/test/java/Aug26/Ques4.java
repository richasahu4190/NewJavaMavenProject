package Aug26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Ques4 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @Test
    public void testDropdownSelection() {
        WebElement dropdownElement = driver.findElement(By.name("my-select"));
        Select dropdown = new Select(dropdownElement);

        dropdown.selectByVisibleText("Two");  

        String actualText = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualText, "Two", "Dropdown selection failed!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
