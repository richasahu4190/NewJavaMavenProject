package Selenium_Labs.Lab11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Selenium_Labs.PageObject.Lab11_3_PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab11_3_pagefactory {
    WebDriver driver;
    Lab11_3_PageFactory page;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php");
        page = new Lab11_3_PageFactory(driver);
    }

    @Test
    public void testLabFlow() {
        Assert.assertEquals(page.getTitle(), "Your Store");
        page.clickDesktops();
        page.clickMac();
        Assert.assertEquals(page.verifyMacHeading(), "Mac");
        page.selectSortByNameAZ();
        page.clickAddToCart();
        Assert.assertTrue(page.isSuccessMsgDisplayed());
        page.searchProduct("Mobile");
        page.clearSearchCriteria();
        page.searchWithDescription("Monitors");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
