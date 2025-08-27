package Aug26;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Ques1 {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}

   @Test
   public void openGoogleAndPrintTitle() {
	   driver.get("https://www.google.com");
	   String title = driver.getTitle();
	   System.out.println("Page Title is: " + title);
   }
   
   @AfterClass
   public void tearDown() {
	   if(driver != null) {
		   driver.quit();
	   }
   }
}
