package com.uttunga.hdfcTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameTest {
	static WebDriver driver1; 

	// COmments
	//
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\H\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
		
		//driver.get("https://www.redbus.in/");
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		
		driver.switchTo().frame("login_page");
		driver.findElement(By.name("fldLoginUserId")).sendKeys("123456");
		//driver.findElement(By.xpath("//imag{@src=/gif/continue_new1.gif?v=1}")).click();
		driver.switchTo().defaultContent();
		//driver.findElement(By.linkText("Click here")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().window("https://www.hdfcbank.com/htdocs/common/insider/index.htm");
		//driver.findElement(By.name("")).
		
//		System.setProperty"webdriver.chrome.driver", "C:\\H\\Drivers\\chromedriver_win32\\chromedriver.exe");
//		driver1 = new ChromeDriver();
//		
//		driver1.manage().window().maximize();
//		driver1.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
//		
//		driver1.get("https://www.redbus.in/");
//		WebElement signinIcon = driver1.findElement(By.id("sign-in-icon-down"));
//		signinIcon.click();
//		
//		WebElement signIn = driver1.findElement(By.xpath("//*[contains(text(), 'Sign In')]"));
//		signIn.click();
//		
//		//By fb_Locator = By.className("fb-loaded");
//		
//		By SignupButton = By.className("signup-btn");
//		
//		frameClick(SignupButton);
//		
//		By email = By.id("emailID");
//		frameType(email, "hari@hari.com");
//		
//		By password = By.id("password");
//		frameType(password, "Password1");	
//	
//		By ProceedButton = By.id("createAccountLink");
//		frameClick(ProceedButton);
	}
	
	public static void frameClick(By Locator)
	{
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		List<WebElement> frames = driver1.findElements(By.tagName("iframe"));
		
		if(frames.isEmpty())
		{
			frames = driver1.findElements(By.tagName("frame"));
		}
		
		List<WebElement> fb_btn;
		for(WebElement frame:frames){
			driver1.switchTo().frame(frame);
			fb_btn = driver1.findElements(Locator);
			if (fb_btn.isEmpty())
			{
			}
			else
			{
				driver1.findElement(Locator).click();
				driver1.switchTo().defaultContent();
				break;
			}
			driver1.switchTo().defaultContent();
		}
	}
	
	//
	//
	
	public static void frameType(By Locator, String value)
	{
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		List<WebElement> frames = driver1.findElements(By.tagName("iframe"));
		
		if(frames.isEmpty())
		{
			frames = driver1.findElements(By.tagName("frame"));
		}
		
		List<WebElement> fb_btn;
		for(WebElement frame:frames){
			driver1.switchTo().frame(frame);
			fb_btn = driver1.findElements(Locator);
			if (fb_btn.isEmpty())
			{
			}
			else
			{
				driver1.findElement(Locator).sendKeys(value);;
				driver1.switchTo().defaultContent();	
				driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				break;
			}
			driver1.switchTo().defaultContent();
		}
	}
	
}
