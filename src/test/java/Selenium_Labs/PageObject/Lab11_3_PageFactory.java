package Selenium_Labs.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Lab11_3_PageFactory {
    WebDriver driver;
    WebDriverWait wait;

    public Lab11_3_PageFactory(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Desktops")
    WebElement desktopsLink;

    @FindBy(linkText = "Mac (1)")
    WebElement macLink;

    @FindBy(xpath = "//h2[contains(text(),'Mac')]")
    WebElement macHeading;

    @FindBy(id = "input-sort")
    WebElement sortDropdown;

    @FindBy(xpath = "//span[text()='Add to Cart']/..")
    WebElement addToCartBtn;

    @FindBy(css = ".alert-success")
    WebElement successMsg;

    @FindBy(name = "search")
    WebElement searchBox;

    @FindBy(css = "button.btn.btn-default.btn-lg")
    WebElement searchBtn;

    @FindBy(id = "description")
    WebElement searchDescriptionChk;

    public String getTitle() {
        return driver.getTitle();
    }

    public void clickDesktops() {
        wait.until(ExpectedConditions.elementToBeClickable(desktopsLink)).click();
    }

    public void clickMac() {
        wait.until(ExpectedConditions.elementToBeClickable(macLink)).click();
    }

    public String verifyMacHeading() {
        return wait.until(ExpectedConditions.visibilityOf(macHeading)).getText();
    }

    public void selectSortByNameAZ() {
        new Select(wait.until(ExpectedConditions.visibilityOf(sortDropdown))).selectByVisibleText("Name (A - Z)");
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }

    public boolean isSuccessMsgDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(successMsg)).isDisplayed();
    }

    public void searchProduct(String product) {
        wait.until(ExpectedConditions.visibilityOf(searchBox)).clear();
        searchBox.sendKeys(product);
        searchBtn.click();
    }

    public void clearSearchCriteria() {
        wait.until(ExpectedConditions.visibilityOf(searchBox)).clear();
    }

    public void searchWithDescription(String keyword) {
        wait.until(ExpectedConditions.visibilityOf(searchBox)).clear();
        searchBox.sendKeys(keyword);
        searchDescriptionChk.click();
        searchBtn.click();
    }
}
