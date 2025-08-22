package Selenium_Labs.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Lab11_3_Locators {
	    WebDriver driver;
	    WebDriverWait wait;

	    public Lab11_3_Locators(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    By desktopsTab = By.linkText("Desktops");
	    By macOption = By.linkText("Mac (1)");
	    By sortDropdown = By.id("input-sort");
	    By addToCartBtn = By.xpath("//button[@onclick=\"cart.add('41', '1');\"]");
	    By successMessage = By.cssSelector(".alert-success");
	    By searchBox = By.name("search");
	    By searchBtn = By.cssSelector("#search button");
	    By searchCriteria = By.name("search");
	    By searchDescriptionCheckbox = By.name("description");
	    By searchCriteriaBtn = By.id("button-search");
	    By macHeading = By.xpath("//h2[contains(text(),'Mac')]");

	    public String getTitle() {
	        return driver.getTitle();
	    }

	    public void clickDesktops() {
	        wait.until(ExpectedConditions.elementToBeClickable(desktopsTab)).click();
	    }

	    public void clickMac() {
	        wait.until(ExpectedConditions.elementToBeClickable(macOption)).click();
	    }

	    public String verifyMacHeading() {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(macHeading)).getText();
	    }

	    public void selectSortByNameAZ() {
	        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(sortDropdown));
	        new Select(dropdown).selectByVisibleText("Name (A - Z)");
	    }

	    public void clickAddToCart() {
	        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
	    }

	    public boolean isSuccessMsgDisplayed() {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
	    }

	    public void searchProduct(String product) {
	        WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
	        box.clear();
	        box.sendKeys(product);
	        driver.findElement(searchBtn).click();
	    }

	    public void clearSearchCriteria() {
	        WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(searchCriteria));
	        box.clear();
	    }

	    public void searchWithDescription(String product) {
	        WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(searchCriteria));
	        box.clear();
	        box.sendKeys(product);
	        driver.findElement(searchDescriptionCheckbox).click();
	        driver.findElement(searchCriteriaBtn).click();
	    }
	
}
