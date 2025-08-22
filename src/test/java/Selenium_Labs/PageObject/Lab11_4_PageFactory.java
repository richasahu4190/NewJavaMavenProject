package Selenium_Labs.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Lab11_4_PageFactory {
    WebDriver driver;

    public Lab11_4_PageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "My Account")
    WebElement myAccountLink;

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(id = "input-firstname")
    WebElement firstName;

    @FindBy(id = "input-lastname")
    WebElement lastName;

    @FindBy(id = "input-email")
    WebElement email;

    @FindBy(id = "input-telephone")
    WebElement telephone;

    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(id = "input-confirm")
    WebElement confirmPassword;

    @FindBy(name = "agree")
    WebElement privacyPolicy;

    @FindBy(css = "input[value='Continue']")
    WebElement continueBtn;

    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement successMessage;

    public void openRegisterPage() {
        myAccountLink.click();
        registerLink.click();
    }

    public void enterFirstName(String fname) {
        firstName.sendKeys(fname);
    }

    public void enterLastName(String lname) {
        lastName.sendKeys(lname);
    }

    public void enterEmail(String mail) {
        email.sendKeys(mail);
    }

    public void enterTelephone(String phone) {
        telephone.sendKeys(phone);
    }

    public void enterPassword(String pwd) {
        password.sendKeys(pwd);
    }

    public void enterConfirmPassword(String cpwd) {
        confirmPassword.sendKeys(cpwd);
    }

    public void acceptPrivacyPolicy() {
        privacyPolicy.click();
    }

    public void clickContinue() {
        continueBtn.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
