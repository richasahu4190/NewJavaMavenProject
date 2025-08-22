package Selenium_Labs;

import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.time.Duration;

public class Lab14 {
    WebDriver driver;

    @Test(dataProvider = "dp")
    public void registerUser(String fname, String lname, String email, String phone, String password, String confirmpwd) {
        System.out.println(">>> Running Test with Data: " + fname + " | " + email);

        Assert.assertEquals(driver.getTitle(), "Your Store", "Title mismatch!");

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        WebElement heading = driver.findElement(By.xpath("//h1[text()='Register Account']"));
        Assert.assertTrue(heading.isDisplayed(), "Register Account page not displayed!");

        driver.findElement(By.id("input-firstname")).sendKeys(fname);
        driver.findElement(By.id("input-lastname")).sendKeys(lname);
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-telephone")).sendKeys(phone);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.id("input-confirm")).sendKeys(confirmpwd);

        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        WebElement successMsg = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
        Assert.assertTrue(successMsg.isDisplayed(), "Account creation failed!");
        System.out.println("Account Created Successfully for: " + email);
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method - Navigating to app");
        driver.manage().deleteAllCookies();
        driver.get("https://tutorialsninja.com/demo/index.php");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After method - Test completed");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class - Setting up WebDriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class - Closing WebDriver");
        driver.quit();
    }

    @DataProvider
    public Object[][] dp() throws IOException {
        String projectpath = System.getProperty("user.dir");
        File file1 = new File(projectpath + "\\UserDetails.xlsx");
        FileInputStream fs = new FileInputStream(file1);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        Sheet worksheet = workbook.getSheetAt(0);

        int rowcount = worksheet.getPhysicalNumberOfRows();
        System.out.println("Total Rows (including header): " + rowcount);

        Object[][] data = new Object[rowcount - 1][6]; 

        for (int i = 1; i < rowcount; i++) { 
            Row row = worksheet.getRow(i);
            for (int j = 0; j < 6; j++) {
                if (row.getCell(j).getCellType() == CellType.NUMERIC) {
                    data[i - 1][j] = String.valueOf((long) row.getCell(j).getNumericCellValue());
                } else {
                    data[i - 1][j] = row.getCell(j).getStringCellValue();
                }
            }
        }

        workbook.close();
        fs.close();
        return data;
    }
}
