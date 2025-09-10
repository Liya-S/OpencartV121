package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import pageObjects.HomePage;




public class TC04_ForgotPassword extends Test_base{
	
	@Test(priority=1,groups={"Regression","Functional"})						//Validate that clicking on forgot password link in login page displays forgot password page
	public void verifyForgotPwd_fromLoginPage() throws InterruptedException {   
		
		logger.info("********Starting TC04_ForgotPassword********");
		logger.info("***Starting Test 1***");
		ForgotPasswordPage fp = new ForgotPasswordPage(driver);
		LoginPage lp= new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on login link");
		Thread.sleep(3000);
		lp.forgot_PwdClick();
		logger.info("Clicked on forgot password link");
		Thread.sleep(3000);
		boolean test = fp.title();
		logger.info("Validating that clicking on forgot password link in login page displays forgot password page");
		Assert.assertEquals(test, true);
		logger.info("Finished Test 1***");
	}
	
	@Test(priority=2,groups="Regression")						//Validate that clicking on forgot password tab in right column
	public void verifyForgotPwd_fromRightColumn() throws InterruptedException {  
		
		logger.info("***Starting Test 2***");
		MyAccount ma= new MyAccount(driver);
		ForgotPasswordPage fp = new ForgotPasswordPage(driver);
		
		HomePage hp = new HomePage(driver);
		hp.titleHome();
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on login link");
		Thread.sleep(3000);
		ma.ForgottenPwd_RightCol_click();
		logger.info("Clicked on forgot password link in right column");
		Thread.sleep(3000);
		boolean test = fp.title();
		logger.info("Validating clicking on forgot password tab in right column");
		Assert.assertEquals(test, true);
		logger.info("Finished Test 2***");
		
	}
	
	@Test(priority=3,groups="Regression")						//Validate that the forgot password page is asking for valid e-mail 
	public void verifyForgotPwd_AskValidEmail() throws InterruptedException {  
		
		
		logger.info("***Starting Test 3***");
		MyAccount ma= new MyAccount(driver);
		ForgotPasswordPage fp = new ForgotPasswordPage(driver);
		HomePage hp = new HomePage(driver);
		hp.titleHome();
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on login link");
		Thread.sleep(3000);
		ma.ForgottenPwd_RightCol_click();
		logger.info("Clicked on forgot password link in right column");
		Thread.sleep(3000);
		boolean test = fp.email_display();
		logger.info("Validating that the forgot password page is asking for valid e-mail");
		Assert.assertEquals(test, true);
		logger.info("Finished Test 3***");
		
	}
	
	@Test(priority=4,groups="UI")						//Validate that proper message is displayed after providing valid e-mail id
	public void verifyForgotPwd_SuccessMsg() throws InterruptedException {  
		
		logger.info("***Starting Test 4***");
		MyAccount ma= new MyAccount(driver);
		ForgotPasswordPage fp = new ForgotPasswordPage(driver);
		HomePage hp = new HomePage(driver);
		hp.titleHome();
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on login link");
		Thread.sleep(3000);
		ma.ForgottenPwd_RightCol_click();
		logger.info("Clicked on forgot password link in right column");
		Thread.sleep(3000);
		fp.email("aouhs8u86fifkh@comcast.net");
		fp.Cont_btn();
		logger.info("Entered email and clicked on continue button");
		Thread.sleep(3000);
		boolean test = fp.success_msg();
		logger.info("Validating that proper message is displayed after providing valid e-mail id");
		Assert.assertEquals(test, true);
		logger.info("Finished Test 4***");
		
	}
	
	@Test(priority=5,groups="UI")						//Validate that proper warning message is displayed after providing invalid e-mail id
	public void verifyForgotPwd_FailureMsg() throws InterruptedException {  
		
		logger.info("***Starting Test 5***");
		MyAccount ma= new MyAccount(driver);
		ForgotPasswordPage fp = new ForgotPasswordPage(driver);
		HomePage hp = new HomePage(driver);
		hp.titleHome();
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on login link");
		Thread.sleep(3000);
		ma.ForgottenPwd_RightCol_click();
		logger.info("Clicked on forgot password link in right column");
		Thread.sleep(3000);
		fp.email("malik.bryant@aol.com");
		fp.Cont_btn();
		logger.info("Entered email and clicked on continue button");
		Thread.sleep(3000);
		boolean test = fp.fail_msg();
		logger.info("Validating tthat proper warning message is displayed after providing invalid e-mail id");
		Assert.assertEquals(test, true);
		logger.info("Finished Test 5***");
	}
	
	@Test(priority=6,groups="UI")						//Validate that proper warning message is displayed after leaving e-mail textfield empty
	public void verifyForgotPwd_FailureMsgIfNoEmail() throws InterruptedException {  
		
		logger.info("***Starting Test 6***");
		MyAccount ma= new MyAccount(driver);
		ForgotPasswordPage fp = new ForgotPasswordPage(driver);
		HomePage hp = new HomePage(driver);
		hp.titleHome();
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on login link");
		Thread.sleep(3000);
		ma.ForgottenPwd_RightCol_click();
		logger.info("Clicked on forgot password link in right column");
		Thread.sleep(3000);
		fp.email("");
		fp.Cont_btn();
		logger.info("Clicked on continue button");
		Thread.sleep(3000);
		boolean test = fp.fail_msg();
		logger.info("Validating that proper warning message is displayed after leaving e-mail textfield empty");
		Assert.assertEquals(test, true);
		logger.info("Finished Test 6***");
	}
	
	@Test(priority=7,groups="UI")						//Verify Placeholder text is displayed in the 'E-Mail Address' field of 'Forgotten Password' page
	public void verifyForgotPwd_Placeholder_email() throws InterruptedException {  
		
		logger.info("***Starting Test 7***");
		MyAccount ma= new MyAccount(driver);
		ForgotPasswordPage fp = new ForgotPasswordPage(driver);
		HomePage hp = new HomePage(driver);
		hp.titleHome();
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on login link");
		Thread.sleep(3000);
		ma.ForgottenPwd_RightCol_click();
		logger.info("Clicked on forgot password link in right column");
		Thread.sleep(3000);
		String placeholder = fp.email_placeholder();
		System.out.println(placeholder);
		logger.info("Validating Placeholder text is displayed in the 'E-Mail Address' field of 'Forgotten Password' page");
		if(placeholder=="E-Mail Address") {
			Assert.assertEquals(placeholder, true);
		}
		logger.info("Finished Test 7***");
	}
		
	@Test(priority=8,groups={"Regression","EndToEnd"})//Validate logging into the Application with the old password when you have initiated the resetting password process and have not reset the password
	public void verifyForgotPwd_loggingInAfterReset() throws InterruptedException {  
		
		logger.info("***Starting Test 8***");
		MyAccount ma= new MyAccount(driver);
		ForgotPasswordPage fp = new ForgotPasswordPage(driver);
		LoginPage lp= new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		
		hp.titleHome();
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on login link");
		Thread.sleep(3000);
		ma.ForgottenPwd_RightCol_click();
		logger.info("Clicked on forgot password link in right column");
		Thread.sleep(3000);
		fp.email("aouhs8u86fifkh@comcast.net");
		fp.Cont_btn();
		logger.info("Entered email and clicked on continue button");
		Thread.sleep(3000);
		ma.Login_RightCol_click();
		logger.info("Clicked on login link");
		Thread.sleep(3000);
		lp.login_mail("aouhs8u86fifkh@comcast.net");
		lp.login_pwd("asdfqwer123");
		lp.login_btn();
		logger.info("Entered email, password and clicked on login button");
		Thread.sleep(3000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		logger.info("Validating logging into the Application with the old password");
		boolean test = hp.LogoutIsdisplayed();
		Assert.assertEquals(test, true);
		logger.info("Finished Test 8***");
	}
		
	
	
	
	
	
	
}
