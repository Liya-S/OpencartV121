package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoggedOutPage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;

public class TC03_AccountLogout extends Test_base{
	
	@Test(priority=1,groups={"Functional","Regression","Sanity","UI"})
	public void verifyLogout_AfterLogin() throws InterruptedException {   //Validate Logging out option is displayed in MyAccount drop menu after logging in
		
		logger.info("********Starting TC03_AccountLogout********");
		logger.info("***Starting Test 1***");
		HomePage hp = new HomePage(driver);
		LoginPage lp= new LoginPage(driver);  
		Thread.sleep(3000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on login link");
		logger.info("Giving valid details");
		lp.login_mail("aouhs8u86fifkh@comcast.net");
		lp.login_pwd("asdfqwer123");
		lp.login_btn();
		Thread.sleep(2000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		boolean test = hp.LogoutIsdisplayed();
		logger.info("Validating Logging out option is displayed in MyAccount drop menu after logging in");
		if(test==true) {
			hp.clickLogout();
			Assert.assertEquals(test, true);
		}
		logger.info("Finished Test 1***");
		
	}
	
	@Test(priority=2,dependsOnMethods="verifyLogout_AfterLogin()",groups={"Sanity","Smoke"})
	public void verifyLogout_fromMyAccount() throws InterruptedException {   //Validate Logging out by selecting Logout option from 'My Account' drop menu
		
		logger.info("***Starting Test 2***");
		HomePage hp = new HomePage(driver);
		LoginPage lp= new LoginPage(driver);
		Thread.sleep(3000);
		hp.titleHome();
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on login link");
		logger.info("Giving valid details");
		lp.login_mail("aouhs8u86fifkh@comcast.net");
		lp.login_pwd("asdfqwer123");
		lp.login_btn();
		Thread.sleep(2000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clickLogout();
		logger.info("Clicked on logout link");
		Thread.sleep(2000);
		hp.titleHome();
		hp.clickMyaccount(); 
		logger.info("Clicked on my account link");
		boolean test = hp.LoginIsdisplayed();
		logger.info("Validating Logging out by selecting Logout option from 'My Account' drop menu");
		Assert.assertEquals(test, true);
		logger.info("Finished Test 2***");
	}
	
	@Test(priority=3,groups={"Sanity","Functional","Regression"})
	public void verifyLogout_fromRightColumn() throws InterruptedException {   //Validate Logging out by selecting Logout option from 'My Account' drop menu
		
		logger.info("***Starting Test 3***");
		HomePage hp = new HomePage(driver);
		LoginPage lp= new LoginPage(driver);
		MyAccount ma= new MyAccount(driver);
		Thread.sleep(3000);
		hp.titleHome();
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on login link");
		logger.info("Giving valid details");
		lp.login_mail("aouhs8u86fifkh@comcast.net");
		lp.login_pwd("asdfqwer123");
		lp.login_btn();
		
		ma.Logout_RightCol_click();
		logger.info("Clicked on logout option in right column");
		hp.clickMyaccount();    
		logger.info("Clicked on my account link");
		boolean test = hp.LoginIsdisplayed();
		logger.info("Validating Logging out by selecting Logout option from 'My Account' drop menu");
		Assert.assertEquals(test, true);
		logger.info("Finished Test 3***");
	}
	
	@Test(priority=4,groups={"EndToEnd","Functional","Regression","Negative","Security"})
	public void verifyLogout_Browseback() throws InterruptedException {   //Validate logging out and browsing back
		
		logger.info("***Starting Test 4***");
		HomePage hp = new HomePage(driver);
		LoginPage lp= new LoginPage(driver);
		Thread.sleep(3000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clickMyaccount();
		hp.clicklogin();
		logger.info("Clicked on login link");
		logger.info("Giving valid details");
		lp.login_mail("aouhs8u86fifkh@comcast.net");
		lp.login_pwd("asdfqwer123");
		lp.login_btn();
		Thread.sleep(2000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clickLogout();
		logger.info("Clicked on logout link");
		Thread.sleep(2000);
		driver.navigate().back();
		logger.info("navigated back...");
		Thread.sleep(2000);
		hp.clickMyaccount(); 
		logger.info("Clicked on my account link");
		Thread.sleep(2000);
		boolean test = hp.LogoutIsdisplayed();
		logger.info("Validating logging out and browsing back");
		Assert.assertEquals(test, false);
		logger.info("Finished Test 4***");
	}
	
	@Test(priority=5,groups={"UI","Functional"})
	public void verifyLogoutNotDisplayedBeforeLoggingIn() throws InterruptedException {   //Validate Logout option is not displayed under 'My Account' menu before logging in
		
		logger.info("***Starting Test 5***");
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		boolean test = hp.LogoutIsdisplayed();
		logger.info("Validating Logout option is not displayed under 'My Account' menu before logging in");
		Assert.assertEquals(test, false);
		logger.info("Finished Test 5***");
	}

	@Test(priority=6,groups="UI")
	public void verify_ProperMessageAfterLogout() throws InterruptedException {   //Validate that proper message is displayed after logging out
		
		logger.info("***Starting Test 6***");
		LoginPage lp= new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		LoggedOutPage lop = new LoggedOutPage(driver);
		hp.titleHome();
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on login link");
		logger.info("Giving valid details");
		lp.login_mail("aouhs8u86fifkh@comcast.net");
		lp.login_pwd("asdfqwer123");
		lp.login_btn();
		Thread.sleep(2000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clickLogout();
		logger.info("Clicked on logout link");
		Thread.sleep(5000);
		boolean test = lop.titleDisplayed();
		logger.info("Validating that proper message is displayed after logging out");
		Assert.assertEquals(test, true);
		logger.info("Finished Test 6***");
	}
	
	
	
	
	
}
