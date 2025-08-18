package Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC005_Selenium {
	
	public static void main(String[]args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(("https://www.opencart.com/"));
		String title = driver.getTitle();
		System.out.println("Title:"+driver.getTitle());
		if(title.equals("OpenCart - Open Source Shopping Cart Solution")) 
		{
			System.out.println("The Title Is Matched");	
		}else
		{
			System.out.println("The Title Is Not Matched");
		}
		
	  driver.navigate().to("https://in.yahoo.com\r\n");
	  
	  System.out.println("url is:"+driver.getCurrentUrl());
	  driver.navigate().back();
	  
	  System.out.println("url is:"+driver.getCurrentUrl());
	  driver.navigate().forward();
	  driver.navigate().refresh();
	  
	  System.out.println("url is:"+driver.getCurrentUrl());
	 System.out.println("page source is :"+driver.getPageSource());
	}
}

