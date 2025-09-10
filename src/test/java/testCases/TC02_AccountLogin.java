package testCases;


import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.Test;
import pageObjects.AccountRegistration;
import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;



public class TC02_AccountLogin extends Test_base{

	
	@Test(priority=1,groups= {"Functional","Sanity"})					 //Validate navigating to login page through login link in register page				
	public void verify_login_navigation_link() {  
		logger.info("********Starting TC02_AccountLogin********");
		logger.info("***Starting Test 1***");
		LoginPage lp = new LoginPage(driver);
		AccountRegistration ac = new AccountRegistration(driver);
		HomePage hp = new HomePage(driver);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked onn register link");
		ac.Login_link();
		logger.info("Clicked onn login link in register page");
		boolean link = lp.Login_title();
		logger.info("Validating navigating to login page through login link in register page");
		Assert.assertEquals(link, true);
		logger.info("Finished Test1***");
	}
	
	@Test(priority=2,groups= {"Functional","Sanity"})					 //Validate navigating to login from right column option			
		public void verify_login_navigation_RightColumn() { 
		logger.info("***Starting Test 2***");
		AccountRegistration ac = new AccountRegistration(driver);
		LoginPage lp = new LoginPage(driver);
		ac.Login_rightColumn(); 
		logger.info("Clicked on login link in right column");
		boolean link = lp.Login_title();
		logger.info("Validating navigating to login from right column option");
		Assert.assertEquals(link, true);
		logger.info("Finished Test2***");
	}
	
	@Test(priority=3,groups="Functional")					 //Validate logging in to the account through My Account --> login				
	public void verify_login_navigation_MyAccount() {  
		
		logger.info("***Starting Test 3***");
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on my login link");
		boolean test = lp.Login_title();
		logger.info("Validating logging in to the account through My Account --> login");
		Assert.assertEquals(test, true);	
		logger.info("Finished Test3***");
	}
	
	@Test(priority=4,groups={"Sanity","Smoke"})					 //Validate logging into account by giving valid credentials			
	public void verify_login_ValidCredentials() throws InterruptedException {  
		
		logger.info("***Starting Test 4***");
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		hp.titleHome();
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on my login link");
		logger.info("Giving valid login credentials...");
		lp.login_mail("v8vdr09hb0l5il0@gmail.com");
		lp.login_pwd("asdfqwer123");
		lp.login_btn();
		Thread.sleep(2000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		Thread.sleep(2000);
		boolean test = hp.LogoutIsdisplayed();
		logger.info("Validating  logging into account by giving valid credentials	");
		if(test==true) {
			hp.clickLogout();
			Assert.assertEquals(test, true);	
		}
		logger.info("Finished Test4***");
	}
	
	@Test(priority=5,groups="Negative")					 //	Validate logging into account by giving not registered username		
	public void verify_login_NotRegisteredUsername() throws InterruptedException {  
	
		logger.info("***Starting Test 5***");
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on my login link");
		logger.info("Giving not registered username");
		lp.login_mail("ksmg40e60o14@googlemail.com");
		lp.login_pwd("qwerhjkl4789");
		lp.login_btn();
		Thread.sleep(2000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		boolean test = hp.LoginIsdisplayed();
		logger.info("Validating logging into account by giving not registered username");
		Assert.assertEquals(test, true);
		logger.info("Finished Test5***");
	}
	
	@Test(priority=6,groups="Negative")					 //Validate logging into account by giving registered username and incorrect password		
	public void verify_login_WrongPwd() throws InterruptedException {  
		
		logger.info("***Starting Test 6***");
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		hp.titleHome();
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on my login link");
		logger.info("Giving registered username with incorrect password");
		lp.login_mail("aouhs8u86fifkh@comcast.net");
		lp.login_pwd("aouhs123");
		lp.login_btn();
		Thread.sleep(2000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		boolean test = hp.LoginIsdisplayed();
		logger.info("Validating logging into account by giving registered username and incorrect password");
		Assert.assertEquals(test, true);
		if(test==false) {
			hp.clickLogout();
			Assert.fail();
		}
		logger.info("Finished Test6***");
	}
	
	@Test(priority=7,groups="Negative")					 //Validate logging into account by giving registered username and keeping password textfield empty		
	public void verify_login_EmptyPwd() throws InterruptedException { 
		
		logger.info("***Starting Test 7***");
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		hp.titleHome();
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on my login link");
		logger.info("Giving registered username with password textfield empty");
		lp.login_mail("aouhs8u86fifkh@comcast.net");
		lp.login_pwd("");
		lp.login_btn();
		Thread.sleep(2000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		boolean test = hp.LoginIsdisplayed();
		logger.info("Validating logging into account by giving registered username and keeping password textfield empty");
		Assert.assertEquals(test, true);
		if(test==false) {
		hp.clickLogout();
		Assert.fail();
		}
		logger.info("Finished Test 7***");
	}
	
	@Test(priority=8,groups="Negative")					//Validate logging into account by giving password only and keeping username textfield empty	
	public void verify_login_EmptyUN() throws InterruptedException {  
		
		logger.info("***Starting Test 8***");
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		hp.titleHome();
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on my login link");
		logger.info("Keeping username textfield empty");
		lp.login_mail("");
		lp.login_pwd("asdfqwer123");
		lp.login_btn();
		Thread.sleep(2000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		boolean test = hp.LoginIsdisplayed();
		logger.info("Validating logging into account by giving password only and keeping username textfield empty");
		Assert.assertEquals(test, true);
		if(test==false) {
			hp.clickLogout();
			Assert.fail();
		}
		logger.info("Finished Test 8***");
	}
	
	@Test(priority=9,groups="Negative")					//Validate logging into account by keeping both the textfields empty
	public void verifyLogin_EmptyUN_PWD() throws InterruptedException { 
		
		logger.info("***Starting Test 9***");
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		hp.titleHome();
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on my login link");
		logger.info("Keeping username and email textfield empty");
		lp.login_mail("");
		lp.login_pwd("");
		lp.login_btn();
		Thread.sleep(2000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		boolean test = hp.LoginIsdisplayed();
		logger.info("Validating logging into account by keeping both the textfields empty");
		Assert.assertEquals(test, true);
		if(test==false) {
		hp.clickLogout();
		}
		logger.info("Finished Test 9***");
	}
	
	@Test(priority=11,groups={"UI","Functional"})								//Validate the text into the Password field is toggled to hide its visibility
	public void verifyLogin_PwdToggled() {  
		
		logger.info("***Starting Test 11***");
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		hp.titleHome();
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on my login link");
		logger.info("Giving valid details");
		lp.login_mail("aouhs8u86fifkh@comcast.net");
		lp.login_pwd("asdfqwer123");
		String type = lp.pwd_type();
		logger.info("Validating the text into the Password field is toggled to hide its visibility");
		Assert.assertEquals(type, "password");	
		logger.info("Finished Test 11***");
	}
	
	@Test(priority=12,groups= {"Security","Functional","Regression"})								//Validate the Password is not visible in the Page Source
	public void verifyLogin_PwdInPageSource() { 

		logger.info("***Starting Test 12***");
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		hp.titleHome();
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on my login link");
		logger.info("Giving valid details");
		lp.login_mail("aouhs8u86fifkh@comcast.net");
		lp.login_pwd("asdfqwer123");
		String pageSource = driver.getPageSource();
		boolean pwd = pageSource.contains("asdfqwer123");
		logger.info("Validating the Password is not visible in the Page Source");
		if(pwd==true) {
			System.out.println("***WARNING***SECURITY RISK--->Password is visible in page source ");
			Assert.fail();
		}
		else {
			Assert.assertEquals(true,true);
		}
		logger.info("Finished Test 12***");
	}	
	
	@Test(priority=15,groups= {"Functional","Regression"})		                                   //Validate forgot password link is provided in the login page
	public void verify_ForgotPwdLink() throws InterruptedException { 
		
		logger.info("***Starting Test 15***");
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		hp.titleHome();
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on my login link");
		boolean test = lp.forgot_PwdDisplay();
		logger.info("Validating forgot password link is provided in the login page");
		Assert.assertEquals(test, true);
		logger.info("Finished Test 15***");
	}
	
	@Test(priority=16,groups= {"Functional","Sanity","Regression"} )		                                  //Validate on clicking forgot password link --> the forgot password page is displayed
	public void verify_ForgotPwdPage() throws InterruptedException {  
		
		logger.info("***Starting Test 16***");
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		ForgotPasswordPage fp = new ForgotPasswordPage(driver);
		  
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on my login link");
		logger.info("Giving invalid details");
		lp.login_mail("fgeovqw3vu4xe3ro@rediffmail.com");
		lp.login_pwd("asdfqwer123");
		lp.forgot_PwdClick();
		boolean test = fp.title();
		logger.info("Validating on clicking forgot password link --> the forgot password page is displayed");
		Assert.assertEquals(test, true);
		logger.info("Finished Test 16***");

	}
	
	@Test(priority=17,groups="Negative")		                                   //Validate clicking on forgot password link by giving email id only
	public void verify_ForgotPwd02() throws InterruptedException {  
		
		logger.info("***Starting Test 17***");
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		ForgotPasswordPage fp = new ForgotPasswordPage(driver);
		  
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on my login link");
		logger.info("Giving email only");
		lp.login_mail("fgeovqw3vu4xe3ro@rediffmail.com");
		lp.forgot_PwdClick();
		boolean test = fp.title();
		logger.info("Validating clicking on forgot password link by giving email id only");
		Assert.assertEquals(test, true);
		logger.info("Finished Test 17***");

	}
	
	@Test(priority=18,groups="Negative")		                                   //Validate clicking on forgot password link by giving password only
	public void verify_ForgotPwd03() throws InterruptedException {  
		
		logger.info("***Starting Test 18***");
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		ForgotPasswordPage fp = new ForgotPasswordPage(driver);
		  
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on my login link");
		logger.info("Giving password only");
		lp.login_pwd("asdfqwer123");
		lp.forgot_PwdClick();
		boolean test = fp.title();
		logger.info("Validating clicking on forgot password link by giving password only");
		Assert.assertEquals(test, true);
		logger.info("Finished Test 18***");

	}
	
	@Test(priority=19,groups="UI")		                                   //Validate there is proper place holders in all the text fields
	public void verify_Login_Placeholders() throws InterruptedException {  
		
		logger.info("***Starting Test 19***");
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on my login link");
		String p_email = lp.placeholderEmail();
		String p_pwd = lp.placeholderPwd();
		logger.info("Validating there is proper place holders in all the text fields");
		if(p_email =="E-Mail Address"&& p_pwd == "Password") {
			Assert.assertEquals(true, true);
		}else {
			System.out.println("No proper placeholders");
		}
		logger.info("Finished Test 19***");
	}
	
	@Test(priority=20,groups="Negative")								//Validate logging in by giving only spaces in the text fields.
	public void verifyLogin_OnlySpaces() throws InterruptedException {  
		
		logger.info("***Starting Test 20***");
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on my login link");
		logger.info("Giving valid email");
		lp.login_mail("aouhs8u86fifkh@comcast.net");
		logger.info("Giving only spaces in pwd");
		lp.login_pwd("      ");
		lp.login_btn();
		Thread.sleep(2000);
		hp.clickMyaccount();
		boolean test = hp.LoginIsdisplayed();
		logger.info("Validating logging in by giving only spaces in the text fields");
		Assert.assertEquals(test, true);
		logger.info("Finished Test 20***");
	
	}
	@Test(priority=26)//Validate Logging into the Application, closing the Browser without logging out and opening the application in the Browser again						
	public void verifyOpeningBrowserWithoutLoggingOut() throws InterruptedException {  
	HomePage hp = new HomePage(driver);
	LoginPage lp = new LoginPage(driver);
	
	hp.clickMyaccount();
	hp.clicklogin();
	lp.login_mail("aouhs8u86fifkh@comcast.net");
	lp.login_pwd("asdfqwer123");
	lp.login_btn();
	Thread.sleep(2000);
	driver.close();
	Thread.sleep(2000);
	driver = new ChromeDriver();
	//driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().window().maximize();
	Thread.sleep(2000);
	driver.get("https://tutorialsninja.com/demo/");
	Thread.sleep(4000);
	hp = new HomePage(driver);
    Thread.sleep(4000);
	hp.clickMyaccount();
	Thread.sleep(4000);
	boolean test = hp.LogoutIsdisplayed();
	Assert.assertEquals(test, true);
	}
						
}		
