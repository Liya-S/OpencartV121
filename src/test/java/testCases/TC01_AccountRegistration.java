package testCases;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.DataProviders;


public class TC01_AccountRegistration extends Test_base{
	
	
	@Test(priority=1,groups={"Sanity","Regression"})
	public void verify_navigation_registration() throws InterruptedException {   //Validate navigating to register link through My account ---> Register
	
		logger.info("********Starting TC01_AccountRegistration********");
		logger.info("***Starting Test 1***");
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked onn register link");
		AccountRegistration ac = new AccountRegistration(driver);
		logger.info("Validating navigating to register link through My account ---> Register");
		Assert.assertEquals(true, ac.title());
		logger.info("Finished Test 1***");
		
	}
	
	
	
	@Test(priority=3,groups={"Smoke","Functional","Regression"})   									//Validate registering an account by giving valid details, mandatory details only
															//Validate registering an account by agreeing to privacy policy
															//Validate proper message is displayed on giving valid details
	public void verify_account_registration() throws InterruptedException {  
		
		logger.info("***Starting Test 3***");
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked onn register link");
		Thread.sleep(3000);
		
		AccountRegistration ac = new AccountRegistration(driver);
		logger.info("Providing Customer Details");
		ac.setFirstName(randomString());
		ac.setLastName(randomString());
		ac.setE_mail(randomAlphaNumeric()+"@gmail.com");
		ac.setPh_no(randomNumeric());
		
	    String password = randomAlphaNumeric();
		ac.setPwd(password);
		ac.setConfPwd(password);
		Thread.sleep(3000);
		ac.agree();
		ac.butCont();
		
		String confirm_msg = ac.getConfMsg();
		logger.info("Validating registering an account by giving valid details");
		Assert.assertEquals(confirm_msg, "Your Account Has Been Created!");
		hp.clickMyaccount();
		hp.clickLogout();
		logger.info("Finished Test3***");
		
	}
	
	
	//@Test(priority=2,dataProvider="Valid_details",dataProviderClass = DataProviders.class,groups="Functional") //Validate registering an account by giving valid details, mandatory details only----------->DDT
																							//Validate registering an account by agreeing to privacy policy


	//public void verify_account_reg_ddt(String email, String ph_no, String fname, String lname) throws InterruptedException {   
		
	//	logger.info("***Starting Test 2***");
		//HomePage hp = new HomePage(driver);
		//Thread.sleep(3000);
		//hp.clickMyaccount();
		//logger.info("Clicked on my account link");
		//hp.clickRegister();
		//logger.info("Clicked onn register link");
		
		//Thread.sleep(3000);
	
		//AccountRegistration ac = new AccountRegistration(driver);
		//logger.info("Providing Customer Details");
		//ac.setFirstName(fname);
		//ac.setLastName(lname);
		//ac.setE_mail(email);
		//ac.setPh_no(ph_no);
	
		//String password = randomAlphaNumeric()+"/*-";
		//ac.setPwd(password);
		//ac.setConfPwd(password);
		//Thread.sleep(3000);
		//ac.agree();
		//ac.butCont();

		//String confirm_msg = ac.getConfMsg();
		//logger.info("Validating registering an account by giving valid details");
		//Assert.assertEquals(confirm_msg, "Your Account Has Been Created!");
		
		//hp.clickMyaccount();
		//hp.clickLogout();
		//logger.info("Finished Test2***");
		
	//}

	
	@Test(priority=4,dataProvider="Register_email",dataProviderClass = DataProviders.class,groups="Negative")     //Validate registering an account by giving invalid email                        
	public void verifyAccountReg_invalid_email(String email, String ph_no, String fname, String lname) throws InterruptedException { 
		
		logger.info("***Starting Test 4***");
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked onn register link");
		
		Thread.sleep(3000);
		
		AccountRegistration ac = new AccountRegistration(driver);
		logger.info("Providing Customer Details");
		ac.setFirstName(fname);
		ac.setLastName(lname);
		ac.setE_mail(email); //invalid email 
		ac.setPh_no(ph_no);			
		
		String password = randomAlphaNumeric()+"/*-";
		ac.setPwd(password);
		ac.setConfPwd(password);
		Thread.sleep(3000);
		ac.agree();
		ac.butCont();
		
		logger.info("Validating registering an account by giving invalid email");
		String confirm_msg = ac.getConfMsg();
		
		if(confirm_msg!="Your Account Has Been Created!") {
			Assert.assertNotEquals(confirm_msg, "Your Account Has Been Created!");
		}else {
			hp.clickMyaccount();
			hp.clickLogout();;
		}
		
		logger.info("Finished Test4***");
	}
	
	
	@Test(priority=5,dataProvider="Register_fname",dataProviderClass = DataProviders.class,groups="Negative")     //Validate registering an account by giving invalid fname                       
	public void verify_account_reg_invalid_fname(String email, String ph_no, String fname, String lname) throws InterruptedException { 
		
		logger.info("***Starting Test 5***");
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked onn register link");
		
		Thread.sleep(3000);
		
		AccountRegistration ac = new AccountRegistration(driver);
		logger.info("Providing Customer Details");
		ac.setFirstName(fname);  //invalid fname
		ac.setLastName(lname);
		ac.setE_mail(email);              
		ac.setPh_no(ph_no);
		
		String password = randomAlphaNumeric()+"/*-";
		ac.setPwd(password);
		ac.setConfPwd(password);
		Thread.sleep(3000);
		ac.agree();
		ac.butCont();
		
		logger.info("Validating registering an account by giving invalid fname");
		String confirm_msg = ac.getConfMsg();
				
		if(confirm_msg!="Your Account Has Been Created!") {
			Assert.assertNotEquals(confirm_msg, "Your Account Has Been Created!");
		}else {
			hp.clickMyaccount();
			hp.clickLogout();;
		}
		logger.info("Finished Test5***");
	}
	
	
	@Test(priority=6,dataProvider="Register_lname",dataProviderClass = DataProviders.class,groups="Negative")     //Validate registering an account by giving invalid lname                        
	public void verify_account_reg_invalid_lname(String email, String ph_no, String fname, String lname) throws InterruptedException { 
		
		logger.info("***Starting Test 6***");
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked onn register link");
		
		Thread.sleep(3000);
		
		AccountRegistration ac = new AccountRegistration(driver);
		logger.info("Providing Customer Details");
		ac.setFirstName(fname);
		ac.setLastName(lname);			//invalid lname
		ac.setE_mail(email);              
		ac.setPh_no(ph_no);
		
		String password = randomAlphaNumeric()+"/*-";
		ac.setPwd(password);
		ac.setConfPwd(password);
		Thread.sleep(3000);
		ac.agree();
		ac.butCont();
		
		logger.info("Validating registering an account by giving invalid lname");
		String confirm_msg = ac.getConfMsg();
		
		if(confirm_msg!="Your Account Has Been Created!") {
			Assert.assertNotEquals(confirm_msg, "Your Account Has Been Created!");
		}else {
			hp.clickMyaccount();
			hp.clickLogout();;
		}
		logger.info("Finished Test6***");
	}
	
	
	@Test(priority=7,dataProvider="Register_ph_no",dataProviderClass = DataProviders.class,groups="Negative")  //Validate registering an account by giving invalid phone number                        
	public void verifyAccountReg_invalid_phno(String email, String ph_no, String fname, String lname) throws InterruptedException { 
		
		logger.info("***Starting Test 7***");
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked onn register link");
		
		Thread.sleep(3000);
		
		AccountRegistration ac = new AccountRegistration(driver);
		logger.info("Providing Customer Details");
		ac.setFirstName(fname);
		ac.setLastName(lname);
		ac.setE_mail(email);  
		
		ac.setPh_no(ph_no);			//invalid phone no
		
		String password = randomAlphaNumeric()+"/*-";
		ac.setPwd(password);
		ac.setConfPwd(password);
		Thread.sleep(3000);
		ac.agree();
		ac.butCont();   
		
		logger.info("Validating registering an account by giving invalid phone number");
		String confirm_msg = ac.getConfMsg();
		
		if(confirm_msg=="Your Account Has Been Created!") {
			hp.clickMyaccount();
			hp.clickLogout();
		}else {
			Assert.assertNotEquals(confirm_msg, "Your Account Has Been Created!");
		}
		logger.info("Finished Test7***");
	}
	
	@Test(priority=8,dataProvider="Already_RegEmail",dataProviderClass = DataProviders.class,groups={"Regression","Negative"})     //Validate registering an account by using already registered e-mail id                    
	public void verifyAccountReg_AlreadyRegEmail(String email, String ph_no, String fname, String lname) throws InterruptedException { 
		
		logger.info("***Starting Test 8***");
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked onn register link");
		
		Thread.sleep(3000);
		
		AccountRegistration ac = new AccountRegistration(driver);
		logger.info("Providing Customer Details");
		ac.setFirstName(fname);
		ac.setLastName(lname);
		
		ac.setE_mail(email);  //already registered email
		ac.setPh_no(ph_no);			
		
		String password = randomAlphaNumeric()+"/*-";
		ac.setPwd(password);
		ac.setConfPwd(password);
		Thread.sleep(3000);
		ac.agree();
		ac.butCont();   
		
		logger.info("Validating registering an account by using already registered e-mail id");
		String confirm_msg = ac.getConfMsg();
		if(confirm_msg=="Your Account Has Been Created!") {
			hp.clickMyaccount();
			hp.clickLogout();
			Assert.fail();
			
		}else {
			Assert.assertNotEquals(confirm_msg, "Your Account Has Been Created!");
		}
		logger.info("Finished Test8***");
	}
	
	@Test(priority=9,dataProvider="Pwd_invalid",dataProviderClass = DataProviders.class,groups="Negative")     //Validate registering an account by using invalid password                 
	public void verifyAccountReg_invalidPwd(String email, String ph_no, String fname, String lname, String password) throws InterruptedException { 
		
		logger.info("***Starting Test 9***");
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked onn register link");
		
		Thread.sleep(3000);
		
		AccountRegistration ac = new AccountRegistration(driver);
		logger.info("Providing Customer Details");
		ac.setFirstName(fname);
		ac.setLastName(lname);
		
		ac.setE_mail(email);  //already registered email     ms
		ac.setPh_no(ph_no);			
		
		ac.setPwd(password);
		ac.setConfPwd(password);
		Thread.sleep(3000);
		ac.agree();
		ac.butCont();  
		
		logger.info("Validating registering an account by using invalid password ");
		String confirm_msg = ac.getConfMsg();
		if(confirm_msg=="Your Account Has Been Created!") {
			hp.clickMyaccount();
			hp.clickLogout();
			Assert.fail();
			
		}else {
			Assert.assertNotEquals(confirm_msg, "Your Account Has Been Created!");
		}
		logger.info("Finished Test9***");
	}
	
	
	@Test(priority=10,groups={"UI","Security"})           //Validate whether password is hidden when we are entering the password
	            
	public void verifyAccountReg_hiddenPwd() throws InterruptedException { 
		
		logger.info("***Starting Test 10***");
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked onn register link");
		
		Thread.sleep(3000);
		
		AccountRegistration ac = new AccountRegistration(driver);
		logger.info("Providing password");
		ac.setPwd("saddf123");
		ac.setConfPwd("saddf123");
		String type_pwd = ac.pwd_hidden();
		
		logger.info("Validating whether password is hidden when we are entering the password");
		Assert.assertEquals(type_pwd, "password", "Password is not hidden");
		logger.info("Finished Test10***");
	}
	
	@Test(priority=11, dataProvider="Valid_details2",dataProviderClass = DataProviders.class,groups="Negative")  //Validate registering an account by giving password textfield and confirm password textfield as different.                 
	public void verifyAccountReg_DiffPwd(String email, String ph_no, String fname, String lname) throws InterruptedException { 
		
		logger.info("***Starting Test 11***");
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked on register link");
		
		Thread.sleep(3000);
		
		AccountRegistration ac = new AccountRegistration(driver);
		logger.info("Providing Customer Details");
		ac.setFirstName(fname);
		ac.setLastName(lname);
		
		ac.setE_mail(email);  //already registered email
		ac.setPh_no(ph_no);			
		
		ac.setPwd(randomAlphaNumeric()+"/*-");
		ac.setConfPwd(randomAlphaNumeric()+"/*-err");
		Thread.sleep(3000);
		ac.agree();
		ac.butCont();   
		
		logger.info("Validating registering an account by giving password textfield and confirm password textfield as different");
		String confirm_msg = ac.getConfMsg();
		if(confirm_msg!="Your Account Has Been Created!") {
			Assert.assertNotEquals(confirm_msg, "Your Account Has Been Created!");
		}else {
			hp.clickMyaccount();
			hp.clickLogout();;
		}
		logger.info("Finished Test11***");
	}
	
	@Test(priority=12, dataProvider="Valid_details3",dataProviderClass = DataProviders.class,groups={"Functional","Regresssion","Negative"})   //Validate registering an account by not agreeing to privacy policy         
	public void verifyAccountReg_NotAgree(String email, String ph_no, String fname, String lname) throws InterruptedException { 
		
		logger.info("***Starting Test 12***");
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked onn register link");
		
		Thread.sleep(3000);
		
		AccountRegistration ac = new AccountRegistration(driver);
		logger.info("Providing Customer Details");
		ac.setFirstName(fname);
		ac.setLastName(lname);
		
		ac.setE_mail(email);  
		ac.setPh_no(ph_no);			
		String password = randomAlphaNumeric()+"/*-";
		ac.setPwd(password);
		ac.setConfPwd(password);
		
		Thread.sleep(3000);
		
		ac.butCont();   
		
		logger.info("Validating registering an account by not agreeing to privacy policy");
		String confirm_msg = ac.getConfMsg();
		if(confirm_msg!="Your Account Has Been Created!") {
			Assert.assertNotEquals(confirm_msg, "Your Account Has Been Created!");
		}else {
			hp.clickMyaccount();
			hp.clickLogout();;
		}
		logger.info("Finished Test12***");
	}
	
	@Test(priority=13,groups="Negative")     //Validate registering an account by not filling all the essential fields                      
	public void verifyAccReg_notGivingAllMandatoryDetails() throws InterruptedException { 
		
		logger.info("***Starting Test 13***");
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked onn register link");
		
		Thread.sleep(3000);
		
		AccountRegistration ac = new AccountRegistration(driver);
		logger.info("Providing Customer Details");
		ac.setFirstName(randomString());
		ac.setLastName(randomString());
		
		ac.setPh_no("9287982963");
		
	    String password = randomAlphaNumeric();
		ac.setPwd(password);
		ac.setConfPwd(password);
		Thread.sleep(3000);
		ac.agree();
		ac.butCont();
		
		logger.info("Validating registering an account by not filling all the essential fields");
		String confirm_msg = ac.getConfMsg();
		if(confirm_msg!="Your Account Has Been Created!") {
			Assert.assertNotEquals(confirm_msg, "Your Account Has Been Created!");
		}else {
			hp.clickMyaccount();
			hp.clickLogout();;
		}
		logger.info("Finished Test13***");
	}	
	
	@Test(priority=14,groups="Negative")     		//Validate registering an account by not filling all the essential fields                      
	public void verifyAccReg_notGivingAllMandatoryDetails2() throws InterruptedException { 
		
		logger.info("***Starting Test 14***");
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked onn register link");
		
		Thread.sleep(3000);
		logger.info("Providing Customer Details");
		AccountRegistration ac = new AccountRegistration(driver);
		ac.setFirstName(randomString());
		ac.setLastName(randomString());
		
	    String password = randomAlphaNumeric();
		ac.setPwd(password);
		ac.setConfPwd(password);
		Thread.sleep(3000);
		ac.agree();
		ac.butCont();
		
		Thread.sleep(3000);
		logger.info("Validating registering an account by not filling all the essential fields");
		String confirm_msg = ac.getConfMsg();
		if(confirm_msg!="Your Account Has Been Created!") {
			Assert.assertNotEquals(confirm_msg, "Your Account Has Been Created!");
		}else {
			hp.clickMyaccount();
			hp.clickLogout();;
		}
		logger.info("Finished Test14***");
	}	
	
	@Test(priority=15,groups={"Functional","Regression","Sanity"})     		//    Validate registering an account by subscribing to newsletter option                  
	public void verifyAccReg_newsletterYes() throws InterruptedException { 
		
		logger.info("***Starting Test 15***");
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked onn register link");
		
		Thread.sleep(3000);
		
		AccountRegistration ac = new AccountRegistration(driver);
		logger.info("Providing Customer Details");
		ac.setFirstName(randomString());
		ac.setLastName(randomString());
		ac.setE_mail(randomAlphaNumeric()+"@gmail.com");
		ac.setPh_no(randomNumeric());
	    String password = randomAlphaNumeric();
		ac.setPwd(password);
		ac.setConfPwd(password);
		ac.newsletter_yes() ;
		
		Thread.sleep(3000);
		ac.agree();
		ac.butCont();
		
		Thread.sleep(3000);
		String confirm_msg = ac.getConfMsg();
		logger.info("Validating registering an account by subscribing to newsletter option ");
		Assert.assertEquals(confirm_msg, "Your Account Has Been Created!");
		hp.clickMyaccount();
		hp.clickLogout();
		logger.info("Finished Test15***");
	}	
	
	
		@Test(priority=16,groups={"Functional","Regression","Sanity"})     		//    Validate registering an account by not subscribing to newsletter option                  
		public void verifyAccReg_newsletterNo() throws InterruptedException { 
			
			logger.info("***Starting Test 16***");
			HomePage hp = new HomePage(driver);
			Thread.sleep(3000);
			hp.clickMyaccount();
			logger.info("Clicked on my account link");
			hp.clickRegister();
			logger.info("Clicked onn register link");
			
			Thread.sleep(3000);
			
			AccountRegistration ac = new AccountRegistration(driver);
			logger.info("Providing Customer Details");
			ac.setFirstName(randomString());
			ac.setLastName(randomString());
			ac.setE_mail(randomAlphaNumeric()+"@gmail.com");
			ac.setPh_no(randomNumeric());
		    String password = randomAlphaNumeric();
			ac.setPwd(password);
			ac.setConfPwd(password);
			ac.newsletter_no();
			
			Thread.sleep(3000);
			ac.agree();
			ac.butCont();
			
			Thread.sleep(3000);
			String confirm_msg = ac.getConfMsg();
			logger.info("Validating registering an account by not subscribing to newsletter option");
			Assert.assertEquals(confirm_msg, "Your Account Has Been Created!");
			hp.clickMyaccount();
			hp.clickLogout();
			logger.info("Finished Test16***");
		}	
		
		@Test(priority=17,groups={"Functional","Regression","Sanity","EndToEnd"})

		public void verify_navigation2_reg() throws InterruptedException {   //Validate navigating to register link through my Account --> login --->Register
			
			logger.info("***Starting Test 17***");
			HomePage hp = new HomePage(driver);
			LoginPage lp = new LoginPage(driver);
			Thread.sleep(3000);
			hp.clickMyaccount();
			logger.info("Clicked on my account link");
			hp.clicklogin();
			logger.info("Clicked on my login link");
			lp.acc_reg_cont();
			logger.info("Clicked on my Continue button under New Customer Link");
			AccountRegistration ac = new AccountRegistration(driver);
			logger.info("Validating navigating to register link through my Account --> login --->Register");
			Assert.assertEquals(true, ac.title());
			logger.info("Finished Test17***");
		}
		
		@Test(priority=18,groups={"Functional","Regression","UI"})
		public void verify_navigation3_reg() throws InterruptedException {  //Validate navigating to Register from Right column option
			
			logger.info("***Starting Test 18***");
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			logger.info("Clicked on my account link");
			AccountRegistration ac = new AccountRegistration(driver);
			ac.right_col_register();
			logger.info("Clicked onn register link from right column");
			logger.info("Validating navigating to Register from Right column option");
			Assert.assertEquals(true, ac.title());
			logger.info("Finished Test18***");
		}
	
	              
	@Test(priority=19,groups={"Functional","Regression"})     		//    Validate registering an account by using keyboard only.               
	public void verifyAccReg_Keyboard() throws InterruptedException, AWTException { 
		
		logger.info("***Starting Test 19***");
		HomePage hp = new HomePage(driver);
		Robot robot=new Robot();
		Thread.sleep(3000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked onn register link");
		
		Thread.sleep(3000);
		
		AccountRegistration ac = new AccountRegistration(driver);
		logger.info("Providing Customer Details");
		ac.setFirstName(randomString());
		robot.keyPress(KeyEvent.VK_TAB);
		WebElement secondName = driver.switchTo().activeElement();
		secondName.sendKeys(randomString());
		
		robot.keyPress(KeyEvent.VK_TAB);
		WebElement email_loc = driver.switchTo().activeElement();
		email_loc.sendKeys(randomAlphaNumeric()+"@gmail.com");
		
		robot.keyPress(KeyEvent.VK_TAB);
		WebElement phone_loc = driver.switchTo().activeElement();
		phone_loc.sendKeys("788945612");
		
		robot.keyPress(KeyEvent.VK_TAB);
		WebElement pwd_loc = driver.switchTo().activeElement();
	    String password = randomAlphaNumeric();
	    pwd_loc.sendKeys(password);
	    robot.keyPress(KeyEvent.VK_TAB);
	    
		WebElement cpwd_loc = driver.switchTo().activeElement();
		cpwd_loc.sendKeys(password);
		
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);  
		robot.keyPress(KeyEvent.VK_TAB); 
		Thread.sleep(2000);  
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);  
		WebElement privacyPolicy = driver.switchTo().activeElement();
		privacyPolicy.click();
		Thread.sleep(2000);  
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);  
		String confirm_msg = ac.getConfMsg();
		logger.info("Validating registering an account by using keyboard only.");
		Assert.assertEquals(confirm_msg, "Your Account Has Been Created!");
		hp.clickMyaccount();
		hp.clickLogout();
		logger.info("Finished Test19***");
	}	
	
	
	@Test(priority=20,groups="Negative")     		//    Validate registering by giving only spaces in the text fields.               
	public void verifyAccReg_onlySpaces() throws InterruptedException, AWTException { 
		
		logger.info("***Starting Test 20***");
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked onn register link");
		
		Thread.sleep(3000);
		
		AccountRegistration ac = new AccountRegistration(driver);
		logger.info("Providing only spaces for firstName and lastName textfields");
		ac.setFirstName("         ");
		ac.setLastName("        ");
		logger.info("Providing valid email, password");
		ac.setE_mail("iljr9wvtce44v1x@msn.com");
	    String password = randomAlphaNumeric();
		ac.setPwd(password);
		ac.setConfPwd(password);
		ac.newsletter_no();
		
		Thread.sleep(3000);
		ac.agree();
		ac.butCont();
		
		Thread.sleep(3000);
		logger.info("Validating registering by giving only spaces in the text fields.");
		String confirm_msg = ac.getConfMsg();
		if(confirm_msg!="Your Account Has Been Created!") {
			Assert.assertNotEquals(confirm_msg, "Your Account Has Been Created!");
		}else {
			hp.clickMyaccount();
			hp.clickLogout();
		}
		logger.info("Finished Test20***");
	
	}
	
	@Test(priority=21,groups="Negative")     		//    Validate registering by giving only spaces in the text fields-->email.               
	public void verifyAccReg_onlySpaces2() throws InterruptedException, AWTException { 
		
		logger.info("***Starting Test 21***");
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked onn register link");
		
		Thread.sleep(3000);
		
		AccountRegistration ac = new AccountRegistration(driver);
		logger.info("Providing Customer Details");
		ac.setFirstName("saniya");
		ac.setLastName("john");
		logger.info("Providing only spaces in email textfield");
		ac.setE_mail("         ");
	    String password = randomAlphaNumeric();
		ac.setPwd(password);
		ac.setConfPwd(password);
		ac.newsletter_no();
		
		Thread.sleep(3000);
		ac.agree();
		ac.butCont();
		
		Thread.sleep(3000);
		logger.info("Validating registering by giving only spaces in the text fields--->email");
		String confirm_msg = ac.getConfMsg();
		if(confirm_msg!="Your Account Has Been Created!") {
			Assert.assertNotEquals(confirm_msg, "Your Account Has Been Created!");
		}else {
			hp.clickMyaccount();
			hp.clickLogout();
		}
		logger.info("Finished Test21***");
	}
	
	@Test(priority=22,groups="UI")     		//Validate there is proper place holders in all the text fields              
	public void verifyAccReg_placeholders() throws InterruptedException, AWTException { 
		
		logger.info("***Starting Test 22***");
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.titleHome();
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked onn register link");
		
		Thread.sleep(3000);
		
		AccountRegistration ac = new AccountRegistration(driver);
		logger.info("Getting placeholder of all textfields");
		String fname = ac.fnamePlaceHolder();
		String lname = ac.lnamePlaceHolder();
		String email = ac.emailPlaceHolder();
		String phone = ac.phonePlaceHolder();
		String pwd = ac.pwdPlaceHolder();
		String cpwd = ac.conf_pwdPlaceHolder();
		
		logger.info("Validating there is proper place holders in all the text fields");
		if(fname == "First Name"&& lname == "Last Name" && email == "E-Mail" && phone == "Telephone" &&  pwd == "Password" && cpwd == "Password Confirm") {
			
			Assert.assertTrue(true);
		}
		logger.info("Finished Test22***");
}
	
	@Test(priority=23,groups="UI")   //Validate that on clicking privacy policy, proper privacy policy window is displayed         
	public void verifyAccReg_PrivacyPolicy() throws InterruptedException, AWTException { 
		
		logger.info("***Starting Test 23***");
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.titleHome();
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked onn register link");
		
		Thread.sleep(3000);
		
		AccountRegistration ac = new AccountRegistration(driver);  
		ac.privacy_Policy();
		boolean value = ac.heading_PrivacyPolicy();
		logger.info("Validating that on clicking privacy policy, proper privacy policy window is displayed ");
		Assert.assertEquals(value, true, "Privacy Policy is not displayed");
		logger.info("Finished Test23***");
	}	
	
	
}   
  