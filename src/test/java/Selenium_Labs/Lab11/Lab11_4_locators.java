package Selenium_Labs.Lab11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Selenium_Labs.PageObject.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab11_4_locators {
    WebDriver driver;
    Lab11_4_Locators page;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php");
        page = new Lab11_4_Locators (driver);
    }

    @Test
    public void testUserRegistration() {
        page.openRegisterPage();
        page.enterFirstName("Richa");
        page.enterLastName("Sahu");
        page.enterEmail("richa" + System.currentTimeMillis() + "@test.com");
        page.enterTelephone("9876543210");
        page.enterPassword("Password@123");
        page.enterConfirmPassword("Password@123");
        page.acceptPrivacyPolicy();
        page.clickContinue();

        String msg = page.getSuccessMessage();
        Assert.assertEquals(msg, "Your Account Has Been Created!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
