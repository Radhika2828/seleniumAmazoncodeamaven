package selenium;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.event.MenuKeyEvent;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.awt.Robot;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Demo1{
public WebElement un;
public WebDriver driver;


@BeforeTest
public void BT() throws InterruptedException
{
	//first line
	//this line automatically fetch the latest version of chrome driver
	WebDriverManager.chromedriver().setup();
	//web driver is a an interface which contains the library of all the browser
	//WebDriver driver = new ChromeDriver();
	//for fire fox
	//Webdriver driver = new fire foxdriver();
	//if i want to open a browser
	 driver = new ChromeDriver();
	 //i want to maximize the browser
	 driver.manage().window().maximize();
	 Thread.sleep(2000);
	
	//i want to open a url
	//driver.navigate().to("https://opensource-demo.orangehrmlive.com");
	//driver.navigate().to("http://demo.guru99.com/test/newtours");
	 //driver.navigate().to("https://demoqa.com/alerts");
	 //driver.navigate().to("https://www.google.com");
	//driver.navigate().to("https://demoqa.com/browser-windows");
//one time way line to use before class or after class
	//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	 //alternate way for thread.sleep
//implicit wait and explicit wait are 2 alternates for thread.sleep	 
	 driver.navigate().to("https://demoqa.com/frames");
	 
}

@Test(enabled=false)
public void login() throws InterruptedException

{
	Thread.sleep(3000);
	//finding by text
	String text = driver.findElement(By.xpath("//*[contains(text(),'Username')]")).getText();
	System.out.println(text);
			
	//want to store user name element in a web element // how to do it
	
	WebElement un  = driver.findElement(By.xpath("//*[@name='txtUsername']"));
	if(un.isEnabled())
	{
		Thread.sleep(3000);
		//it will remove the existing value
		un.clear();
		//it is trying to send the value to application
		un.sendKeys("Admin");
		
	}
	
	//want to check is the name displayed
	if(un.isDisplayed())
	{
	//i want to fetch the value from the user name field
      System.out.println(un.getAttribute("value"));
      //let us assume that there is some attribute whose value is keep on changing
      System.out.println(un.getAttribute("name"));
   
     
}

}

@Test(priority=0,enabled = false)
public void newtours() throws InterruptedException
{
	//login
	driver.findElement(By.xpath("//*[@type='text' and @name='userName']")).sendKeys("admin");
	driver.findElement(By.xpath("//*[@type='password' and @name='password']")).sendKeys("admin@123");
	
	
	//Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@type='submit' and @name='submit']")).click();
	driver.findElement(By.linkText("Flights")).click();
	
	//if i want to wait for particular element explicit wait
	
		WebDriverWait wt = new WebDriverWait(driver,30);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Flights")));
		
	//this is to click on the radio button
	driver.findElement(By.xpath("//*[@name='tripType' and @value='oneway']")).click();//for radio buttons
	//if i have to work with drop down
	WebElement cc = driver.findElement(By.name("passCount")); //for dropdown boxes
	Select sel1= new Select(cc);
	//i want to find out the values under dropdown by get all the values in the derop box

	List<WebElement> values = sel1.getOptions();
	System.out.println(values.size());
	for(int i=0;i<values.size();i++)
	{
		System.out.println(values.get(i).getText());
		sel1.selectByVisibleText("4");
		//i want to fetch the value
		WebElement first = sel1.getFirstSelectedOption();
		System.out.println("the dropdownvalue is:");
		System.out.println(first.getAttribute("value"));
		
	}
}
@Test(enabled = false)
public void HRM() throws InterruptedException
{
	
		WebElement username = driver.findElement(By.xpath("//*[@id='txtUsername']"));
		String fetch = driver.findElement(By.xpath("//*[contains(text(),'( Username : Admin | Password : admin123 )')]")).getText();
		System.out.println(fetch);
		if(username.isEnabled())
		{
			username.clear();
			username.sendKeys("admin");
			Thread.sleep(3000);
		}
		if(username.isDisplayed())
		{
			String un = username.getAttribute("value");
			System.out.println(un);
		}
		WebElement password = driver.findElement(By.xpath("//*[@id='txtPassword']"));
		if(password.isEnabled())
		{
			password.clear();
			password.sendKeys("admin123");
			Thread.sleep(3000);
		}
		if(password.isDisplayed())
		{
			String ps = password.getAttribute("value");
			System.out.println(ps);
		}
		driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
Thread.sleep(4000);
List<WebElement> links = driver.findElements(By.tagName("a"));
System.out.println(links.size());
//to print each link which is visble
for(WebElement e:links)
{
	String link = e.getText();
	System.out.println(link);
}

//driver.findElement(By.linkText("PIM")).click();
//to go back to home page
Thread.sleep(2000);
//driver.navigate().back();
//Thread.sleep(2000);
//driver.navigate().forward();
//Thread.sleep(2000);
//driver.navigate().refresh();
//Thread.sleep(2000);
//WebElement link = driver.findElement(By.linkText("PIM"));
WebElement link = driver.findElement(By.linkText("Dashboard"));
//creating an action object
Actions MO = new Actions(driver);
//Actions mouseover = MO.moveToElement(link).build();
MO.moveToElement(link).build().perform();
//Thread.sleep(3000);
//WebElement link1 = driver.findElement(By.linkText("Configuration"));
//creating an action object
//Actions MO1 = new Actions(driver);
//Actions mouseover = MO1.moveToElement(link).build();
//WebElement link1 = driver.findElement(By.linkText("Configuration"));
//creating an action object
//Actions MO1 = new Actions(driver);
//Actions mouseover = MO1.moveToElement(link).build();
//MO.moveToElement(link).build().perform();
Thread.sleep(3000);
MO.sendKeys(link,Keys.TAB).perform();
Thread.sleep(3000);
MO.sendKeys(link,Keys.TAB).perform();
Thread.sleep(3000);
MO.sendKeys(link,Keys.TAB).perform();
Thread.sleep(3000);
MO.sendKeys(link,Keys.TAB).perform();
Thread.sleep(3000);
MO.sendKeys(link,Keys.ENTER).perform();
Thread.sleep(3000);
//MO.sendKeys(link,Keys.ARROW_DOWN).perform();
//WebElement link2 = driver.findElement(By.linkText("performance"));
//creating an action object
//Actions MO2 = new Actions(driver);
//Actions mouse over = MO.moveToElement(link).build();
//MO2.moveToElement(link2).build().perform();
Thread.sleep(3000);
driver.findElement(By.partialLinkText("Welcome")).click();
Thread.sleep(2000);
driver.findElement(By.partialLinkText("Logout")).click();
}
//how to do pop up
@Test(enabled = false)
public void pop_up() throws InterruptedException
{
	driver.findElement(By.xpath("//*[@id='alertButton']")).click();
	Thread.sleep(2000);
	Alert alert = driver.switchTo().alert();
	Thread.sleep(2000);
	alert.accept();
	
	driver.findElement(By.xpath("//*[@id='timerAlertButton']")).click();
	Thread.sleep(6000);
	Alert alert1 = driver.switchTo().alert();
	Thread.sleep(6000);
	alert1.accept();
	
	driver.findElement(By.xpath("//*[@id='confirmButton']")).click();
	Thread.sleep(2000);
	Alert alert11 = driver.switchTo().alert();
	Thread.sleep(2000);
	alert11.dismiss();
	
	driver.findElement(By.xpath("//*[@id='promtButton']")).click();
	Thread.sleep(2000);
	Alert alert111 = driver.switchTo().alert();
	Thread.sleep(2000);
	alert.sendKeys("radhika");
	alert111.accept();
	
}
@Test(enabled=false)
public void login1() throws InterruptedException

{
	driver.findElement(By.xpath("//*[@id='username']")).click();
	
	}
		
@Test(enabled=false)
public void testcase4() throws InterruptedException, AWTException
{
String title = driver.getTitle();
System.out.println(title);
WebElement gmail = driver.findElement(By.linkText("Gmail"));
Actions act = new Actions(driver);
act.contextClick(gmail).build().perform();
Thread.sleep(3000);
//similar to actions
Robot robot = new Robot();
robot.keyPress(MenuKeyEvent.VK_DOWN);
robot.keyPress(MenuKeyEvent.VK_ENTER);
robot.keyPress(MenuKeyEvent.VK_CONTROL);
robot.keyPress(MenuKeyEvent.VK_TAB);


} 

@Test(enabled = false)

public void multiplewindow()
{
	//getwindowhandle helps to understand the parent window which we use
	//getwindowhandle used to get and store in parent window
	//getwindowhandles helps to get all windows
	String parentwindow = driver.getWindowHandle();
	System.out.println(parentwindow);
	
	WebElement windowbtn = driver.findElement(By.id("windowButton"));
	for(int i=0;i<3;i++)
	{
		windowbtn.click();
	}
	Set<String>allwindows = driver.getWindowHandles();
	System.out.println(allwindows);
	String lastwindow = " ";
	for(String handle : allwindows)
	
	{
		System.out.println("switch to all windows and navigate to goggle.com");
	   
		driver.switchTo().window(handle);
		driver.get("https://www.nykaa.com");
		lastwindow = handle;
	}
	driver.switchTo().window(parentwindow);
	driver.get("http:////www.ajio.com");
	driver.close();
	 
	driver.switchTo().window(lastwindow);
	driver.get("https://www.myntra.com");
	
	
}


@Test(enabled=false)
public void js() throws InterruptedException
{
	//js java script executor is  an interface similar to web driver can be used to work with driver
	JavascriptExecutor js = (JavascriptExecutor)driver;
	//line to be used for title page
	//String title = driver.getTitle();
	
	//so using js
	String title = js.executeScript("return document.title").toString();
	System.out.println(title);
	
	//for fetching url
	String url = js.executeScript("return document.URL").toString();
	System.out.println(url);
	
	//for fetching the domain
	
	String domain = js.executeScript("return document.domain").toString();
	System.out.println(domain);
	
	//to pass username and password using js
	js.executeScript("document.getElementById('txtUsername').value='Admin'");
	js.executeScript("document.getElementById('txtPassword').value='admin123'");
	js.executeScript("document.getElementById('btnLogin').click()");
	
	//employee list 
	js.executeScript("document.getElementById('menu_pim_viewPimModule').click()");
	js.executeScript("document.getElementById('menu_pim_viewEmployeeList').click()");
	//scrolling
	js.executeScript("window.scrollBy(0,500)");
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	Thread.sleep(3000);
	js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	Thread.sleep(3000);
	//String tabledata =js.executeScript(return document.getElementById('orhmList_chk')null)
	
	String tabledata = js.executeScript("return document.getElementById('resultTable').innerText").toString();
	System.out.print(tabledata);
	//navigate.back//navigate.forward before//
	js.executeScript("window.history.back()");
    js.executeScript("window.history.forward()");
    //creating alert in js
    js.executeScript("alert('welcome to Orange HRM')");
    
    //handeling pop-up
    driver.switchTo().alert().accept();
    Thread.sleep(3000);
    //confirm pop up
    js.executeScript("confirm('this is to click on cancel')");
    //getting text from pop up
    String message = driver.switchTo().alert().getText();
    Thread.sleep(3000);
    driver.switchTo().alert().dismiss();
    Thread.sleep(3000);
    js.executeScript("prompt('Enter yes/No','yes/no')");
   
    Thread.sleep(3000);
    driver.switchTo().alert().sendKeys("YES");
    
    Thread.sleep(3000);
    driver.switchTo().alert().accept();
    
    
    
    
	//WebDriver driver = new ChromeDriver();
	//ChromeDriver driver = new ChromeDriver();

}
@Test(enabled=false)
public void frame()
{
	List<WebElement> frames = driver.findElements(By.tagName("iframe"));
	System.out.println(frames.size());
	//fetching name from frames
	for(int i=0;i<frames.size();i++)
	{
		String name = frames.get(i).getAttribute("id");
		System.out.println(name);
		
	}
//next step
	driver.switchTo().frame("frame1");
	String frame1text = driver.findElement(By.id("sampleHeading")).getText();
	//coming out of frame
	driver.switchTo().defaultContent();
	//new frame
	
	driver.switchTo().frame("frame2");
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	
}

//This is something post-Condition
@AfterTest(enabled=false)

public void AT() throws InterruptedException
{
	Thread.sleep(2000);
	//this will close the browser
	driver.close();
	//will close all window parent and child
	//driver.quit();
}
}

