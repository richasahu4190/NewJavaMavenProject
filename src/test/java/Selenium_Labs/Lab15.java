package Selenium_Labs;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Lab15 {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method - Launching Browser");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method - Closing Browser");
        driver.quit();
    }

    @Test(dataProvider = "dp")
    public void registerUser(String firstName, String lastName, String email, String telephone,
                             String password, String confirmPassword) throws InterruptedException {

        String title = driver.getTitle();
        Assert.assertEquals(title, "Your Store");
        System.out.println("Verified Title: " + title);

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        WebElement regText = driver.findElement(By.xpath("//h1[text()='Register Account']"));
        Assert.assertTrue(regText.isDisplayed());
        System.out.println("On Register Account Page");

        driver.findElement(By.id("input-firstname")).sendKeys(firstName);
        driver.findElement(By.id("input-lastname")).sendKeys(lastName);
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-telephone")).sendKeys(telephone);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.id("input-confirm")).sendKeys(confirmPassword);

        driver.findElement(By.name("agree")).click();

        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        Thread.sleep(2000); 

        try {
            WebElement successMsg = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
            Assert.assertTrue(successMsg.isDisplayed());
            System.out.println("Account Created Successfully for: " + email);

        } catch (org.openqa.selenium.NoSuchElementException e) {
            WebElement warning = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]"));
            System.out.println("Registration Failed for " + email + " → " + warning.getText());
            Assert.assertTrue(warning.getText().contains("E-Mail Address is already registered"));
        }
    }


    @DataProvider
    public Object[][] dp() throws IOException, CsvException {
        String csvFile = projectPath + "\\UserDetails.csv"; 
        CSVReader csvReader = new CSVReader(new FileReader(csvFile));
        List<String[]> data = csvReader.readAll();

        int rows = data.size() - 1; 
        String[][] data1 = new String[rows][6];

        for (int i = 1; i < data.size(); i++) {
            data1[i - 1][0] = data.get(i)[0]; 
            data1[i - 1][1] = data.get(i)[1]; 
            data1[i - 1][2] = data.get(i)[2]; 
            data1[i - 1][3] = data.get(i)[3]; 
            data1[i - 1][4] = data.get(i)[4]; 
            data1[i - 1][5] = data.get(i)[5]; 
        }
        return data1;
    }
}
