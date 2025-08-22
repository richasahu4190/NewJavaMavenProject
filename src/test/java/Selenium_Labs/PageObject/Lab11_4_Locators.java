package Selenium_Labs.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Lab11_4_Locators {
	    WebDriver driver;
	    WebDriverWait wait;

	    public Lab11_4_Locators(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    By myAccountLink = By.linkText("My Account");
	    By registerLink = By.linkText("Register");
	    By firstName = By.id("input-firstname");
	    By lastName = By.id("input-lastname");
	    By email = By.id("input-email");
	    By telephone = By.id("input-telephone");
	    By password = By.id("input-password");
	    By confirmPassword = By.id("input-confirm");
	    By privacyPolicyCheckbox = By.name("agree");
	    By continueBtn = By.cssSelector("input[type='submit'][value='Continue']");
	    By successMessage = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");

	    public void openRegisterPage() {
	        wait.until(ExpectedConditions.elementToBeClickable(myAccountLink)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
	    }

	    public void enterFirstName(String fname) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fname);
	    }

	    public void enterLastName(String lname) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).sendKeys(lname);
	    }

	    public void enterEmail(String mail) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(mail);
	    }

	    public void enterTelephone(String phone) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(telephone)).sendKeys(phone);
	    }

	    public void enterPassword(String pwd) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pwd);
	    }

	    public void enterConfirmPassword(String cpwd) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPassword)).sendKeys(cpwd);
	    }

	    public void acceptPrivacyPolicy() {
	        wait.until(ExpectedConditions.elementToBeClickable(privacyPolicyCheckbox)).click();
	    }

	    public void clickContinue() {
	        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
	    }

	    public String getSuccessMessage() {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
	    }
	

}
