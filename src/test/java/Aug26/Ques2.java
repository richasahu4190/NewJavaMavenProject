package Aug26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Ques2 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver(); 
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() {
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        WebElement successMessage = driver.findElement(By.id("flash"));

        String messageText = successMessage.getText();
        System.out.println("Success Message: " + messageText);

        Assert.assertTrue(messageText.contains("You logged into a secure area!"),
                "Login success message not found!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

