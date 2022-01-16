package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AmazonAutomation {
	public WebDriver driver;
		@BeforeTest
		public void BT() throws InterruptedException
		{
			//first line
			//this line automatically fetch the latest version of chrome driver
			WebDriverManager.chromedriver().setup();
			//web driver is a an interface which contains the library of all the browser
			driver = new ChromeDriver();
			//to maximize the window of browser
			 driver.manage().window().maximize();
			 Thread.sleep(2000);
				//to open a url
			driver.navigate().to("https://www.amazon.com");
			
	}
		
		@Test
		public void amazon() throws InterruptedException
		{
			String text = driver.findElement(By.xpath("//*[contains(text(),'amazon')]")).getText();
			 Thread.sleep(4000);
			 //to click on amazon logo
			 WebElement logo = driver.findElement(By.xpath("//*[@id='nav-logo']"));
			driver.findElement(By.xpath("//*[@id='nav-logo']")).click();
			 Thread.sleep(3000);
			 System.out.println("The logo clicked");
			 Thread.sleep(4000);
			 // to click on All option
		     driver.findElement(By.xpath("//*[@id ='nav-hamburger-menu']")).click();
			 System.out.println("the All option clicked");
		     Thread.sleep(4000);
		     //to close All option  
			driver.findElement(By.xpath("//*[@class ='nav-sprite hmenu-close-icon']")).click();
			Thread.sleep(3000);
			 System.out.println("the All  option closed");
			 Thread.sleep(4000);
			 //to select todays deals
			 driver.findElement(By.linkText("Today's Deals")).click();
			 System.out.println("the option clicked");
			 Thread.sleep(2000);
			 // to navigate back
			driver.navigate().back();
			Thread.sleep(2000);
			// to select headsets option in homepage
			driver.findElement(By.xpath("//*[@class ='landscape-image']")).click();
			 System.out.println("the headset option clicked");
			 Thread.sleep(2000);
			 // to sort products
				driver.findElement(By.xpath("//*[@id='a-autoid-0-announce']")).click();
		     System.out.println("sort is selected");
			 Thread.sleep(3000);
			 // to select one of the sort options 
			 driver.findElement(By.xpath("//*[@id='s-result-sort-select_1']")).click();
			 System.out.println("low to high selected and products sorted accordingly");
			 driver.navigate().back();
			 Thread.sleep(4000);
			 //to filter products
			 driver.findElement(By.xpath("//*[@class ='a-size-base a-color-base']")).click();
			 System.out.println("one of the filter option is selected and products filtered accordingly");
			 Thread.sleep(3000);		 
				}
		@AfterTest
		public void AT() throws InterruptedException
		{
			Thread.sleep(3000);
			//this will close the browser
			driver.close();
		}
}