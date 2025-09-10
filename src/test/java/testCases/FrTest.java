package testCases;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;


import pageObjects.HomePage;
import pageObjects.LoginPage;


public class FrTest {

	
	
	public static WebDriver driver;
	
	@BeforeClass(groups= {"Sanity","Functional","Regression","UI","EndToEnd","Smoke","Security"})
	
	public void setup() throws IOException {
	
		//Loading config.properties file
		
		driver = new ChromeDriver();
		

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");  //reading url from properties file
		
		
}
	@Test(priority=14)		                                   //Validate timeout of the Login Session
	public void verify_Timeout() throws InterruptedException {  
	HomePage hp = new HomePage(driver);
	LoginPage lp = new LoginPage(driver);
	
	hp.clickMyaccount();
	hp.clicklogin();
	lp.login_mail("aouhs8u86fifkh@comcast.net");
	lp.login_pwd("asdfqwer123");
	lp.login_btn();
	Thread.sleep(5000*60*10);                            //wait for 10 minutes
	driver.navigate().refresh();
	hp.clickMyaccount();
	boolean test = hp.LogoutIsdisplayed();
	Assert.assertEquals(test, false, "Didnot timeout as expected");
	}
	
										//Validate navigating to the Product Display page and adding the product to cart     
	 
		
	
	
	@AfterMethod(groups= {"Sanity","Functional","Regression","UI","EndToEnd","Smoke","Security"})
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
}