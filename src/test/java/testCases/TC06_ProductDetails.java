package testCases;



import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductDetails;
import pageObjects.ProductDisplay;
import pageObjects.ShoppingCartPage;
import pageObjects.WishListPage;


public class TC06_ProductDetails extends Test_base{
	

	
	@Test(priority=1,groups="Sanity")									//Validate getting product display from dropdown in top menu
	public void verify_productDisplayFromDropdown() throws InterruptedException {
	
		
		logger.info("********Starting TC06_ProductDetails********");
		logger.info("***Starting Test 1***");
		HomePage hp = new HomePage(driver);
		ProductDisplay pdp = new ProductDisplay(driver);
		Thread.sleep(2000);
		hp.clickDesktops();
		logger.info("Clicked on Desktops link");
		Thread.sleep(2000);
		hp.mac_click();
		Thread.sleep(2000);
		logger.info("Selected Mac");
		boolean test = pdp.MacDesktopTitle();
		logger.info("Validating getting product display from dropdown in top menu");
		Assert.assertEquals(test, true);
		logger.info("Finished Test 1***");
		Thread.sleep(3000);
		
	}
	
	

	@Test(priority=2,groups="Functional")					//Validate navigating to the Product Display page by using the Product Name link in the 'Wish List' page
	public void verify_productDisplayFromWishListImg() throws InterruptedException {
		
		
		HomePage hp = new HomePage(driver);
		ProductDisplay pdp = new ProductDisplay(driver);
		LoginPage lp =new LoginPage(driver);
		ProductDetails pd = new ProductDetails(driver);
		WishListPage wlp = new WishListPage(driver);
		Thread.sleep(2000);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on login link");
		lp.login_mail("aouhs8u86fifkh@comcast.net");
		lp.login_pwd("asdfqwer123");
		Thread.sleep(2000);
		lp.login_btn();
		Thread.sleep(2000);
		hp.clickLaptopsNotebooks();
		Thread.sleep(2000);
		logger.info("Clicked on Laptops and Notebooks link");
		hp.AllLaptopNotebooksClick();
		Thread.sleep(2000);
		logger.info("Selected Show AllLaptops & Notebooks link");
		
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.scrollByAmount(0, 170).perform();
		Thread.sleep(2000);
		pdp.HP_LP3065click();
		logger.info("Clicked on HPLP3065");
		Thread.sleep(2000);
		pd.addToWishList();
		logger.info("Clicked on add to wish list");
		Thread.sleep(2000);
		hp.clickWishList();
		logger.info("Clicked on wish list");
		Thread.sleep(2000);
		wlp.hplpNameSel();
		logger.info("Clicked on name in wish list");
		Thread.sleep(3000);
		boolean test = pd.breadcrumb_HPLP3065();
		logger.info(" Validating navigating to the Product Display page by using the Product name in the 'Wish List' page");
		Assert.assertEquals(test, true);
		logger.info("Finished Test 2***");
		Thread.sleep(3000);
		hp.clickMyaccount();
		hp.clickLogout();
		 
	}
    
    @Test(priority=3,groups="Functional")				//Validate navigating to the Product Display page by using the Product image link in the 'Wish List' page
	public void verify_productDisplayFromWishListName() throws InterruptedException {
			
			logger.info("***Starting Test 3***");
			HomePage hp = new HomePage(driver);
			ProductDisplay pdp = new ProductDisplay(driver);
			LoginPage lp =new LoginPage(driver);
			ProductDetails pd = new ProductDetails(driver);
			WishListPage wlp = new WishListPage(driver);
			Thread.sleep(2000);
			hp.clickMyaccount();
			logger.info("Clicked on my account link");
			hp.clicklogin();
			logger.info("Clicked on login link");
			lp.login_mail("aouhs8u86fifkh@comcast.net");
			lp.login_pwd("asdfqwer123");
			Thread.sleep(2000);
			lp.login_btn();
			Thread.sleep(2000);
			hp.clickLaptopsNotebooks();
			Thread.sleep(2000);
			logger.info("Clicked on Laptops and Notebooks link");
			hp.AllLaptopNotebooksClick();
			Thread.sleep(2000);
			logger.info("Selected Show AllLaptops & Notebooks link");
			
			Actions act = new Actions(driver);
			Thread.sleep(2000);
			act.scrollByAmount(0, 170).perform();
			Thread.sleep(2000);
			pdp.HP_LP3065click();
			logger.info("Clicked on HPLP3065");
			Thread.sleep(2000);
			pd.addToWishList();
			logger.info("Clicked on add to wish list");
			Thread.sleep(2000);
			hp.clickWishList();
			logger.info("Clicked on wish list");
			Thread.sleep(3000);
			wlp.hplpImgSel();
			logger.info("Clicked on image in wish list");
			Thread.sleep(3000);
			boolean test = pd.breadcrumb_HPLP3065();
			logger.info(" Validating navigating to the Product Display page by using the Product Name link in the 'Wish List' page");
			Assert.assertEquals(test, true);
			logger.info("Finished Test 3***");
			Thread.sleep(3000);
			hp.clickMyaccount();
			hp.clickLogout();
		
		}
    
    @Test(priority=4,groups="Functional")			  //Validate navigating to the Product Display page by using the Product Image in the 'Shopping Cart' page
	public void verify_productDisplayFromAddToCartImg() throws InterruptedException {
		
		logger.info("***Starting Test 4***");
		HomePage hp = new HomePage(driver);
		ProductDisplay pdp = new ProductDisplay(driver);
		LoginPage lp =new LoginPage(driver);
		ProductDetails pd = new ProductDetails(driver);
		ShoppingCartPage scp = new ShoppingCartPage(driver);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		Thread.sleep(2000);
		logger.info("Clicked on login link");
		lp.login_mail("aouhs8u86fifkh@comcast.net");
		lp.login_pwd("asdfqwer123");
		Thread.sleep(2000);
		lp.login_btn();   
		Thread.sleep(2000);
		hp.clickLaptopsNotebooks();
		logger.info("Clicked on Laptops and Notebooks link");
		hp.AllLaptopNotebooksClick();
		logger.info("Selected Show AllLaptops & Notebooks link");
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.scrollByAmount(0, 170).perform();
		pdp.HP_LP3065click();
		logger.info("Clicked on HPLP3065");
		Thread.sleep(2000);
		act.scrollByAmount(0, 170).perform();
		Thread.sleep(2000);
		pd.addToCart();
		logger.info("Clicked on add to cart button");
		Thread.sleep(2000);
		hp.clickShoppingCart();
		logger.info("Clicked on shopping cart link");
		Thread.sleep(3000);
		scp.img_hplp();
		logger.info("Clicked on image");
		Thread.sleep(3000);
		boolean test = pd.breadcrumb_HPLP3065();
		Thread.sleep(3000);
		logger.info("Validating navigating to the Product Display page by using the Product Image in the 'Shopping Cart' page");
		Assert.assertEquals(test, true);
		logger.info("Finished Test 4***");
		Thread.sleep(3000);
		hp.clickMyaccount();
		hp.clickLogout();
		
	}
    
   
	
    
    @Test(priority=6,groups="EndToEnd")	     //Validate navigating to the Product Display page by using the Product Name link in the 'Confirm Order' section of the 'Checkout' page
	public void verify_productDisplayFromConfirmOrder() throws InterruptedException {
		
			logger.info("***Starting Test 6***");
			HomePage hp = new HomePage(driver);
			ProductDisplay pdp = new ProductDisplay(driver);
			LoginPage lp =new LoginPage(driver);
			ProductDetails pd = new ProductDetails(driver);
			CheckoutPage cp = new CheckoutPage(driver);
			hp.clickMyaccount();
			logger.info("Clicked on my account link");
			hp.clicklogin();
			logger.info("Clicked on login link");
			lp.login_mail("aouhs8u86fifkh@comcast.net");
			lp.login_pwd("asdfqwer123");
			lp.login_btn();
			Thread.sleep(2000);
			hp.clickLaptopsNotebooks();
			logger.info("Clicked on Laptops and Notebooks link");
			hp.AllLaptopNotebooksClick();
			logger.info("Selected Show AllLaptops & Notebooks link");
			Actions act = new Actions(driver);
			Thread.sleep(2000);
			act.scrollByAmount(0, 170).perform();
			pdp.HP_LP3065click();
			logger.info("Clicked on HPLP3065");
			Thread.sleep(2000);
			pd.addToCart(); 
			logger.info("Clicked on add to cart button");
			Thread.sleep(3000);
			hp.clickCheckout();
			logger.info("Clicked on Checkout link");
			Thread.sleep(3000);
			cp.btn_useNewAddress();
			logger.info("Clicked on use new address radio button");
			Thread.sleep(3000);
			logger.info("Entering details...");
			cp.f_name("sona");
			cp.l_name("jane");
			cp.company_name("jmt consultants");
			cp.address1("asdf678 sdf 234");
			cp.address2("wer 123 hhh");
			cp.city("Bengaluru");
			cp.post_code("583628");
			cp.countryName("India");
			cp.state("Karnataka");
			
			Thread.sleep(3000);
			cp.BtnPaymentAddress();
			Thread.sleep(3000);
			cp.BtnExistingAddress();
			Thread.sleep(3000);
			cp.BtnContShipppingAddress();
			cp.comment("asdsadf fdgtr jfldkgjodf");
			cp.BtnContShippingMethod();
			Thread.sleep(3000);
			cp.agreeBtn();
			cp.BtnContPaymentMethod();
			logger.info("Clicked on continue payment method button");
			Thread.sleep(3000);
			cp.link_HP3065();
			logger.info("Clicked on product name link");
			Thread.sleep(3000);
			boolean test = pd.breadcrumb_HPLP3065();
			logger.info("Validating navigating to the Product Display page by using the Product Name link in the 'Confirm Order' section of the 'Checkout' page");
			Assert.assertEquals(test, true);
			hp.clickMyaccount();
			hp.clickLogout();
			logger.info("Finished Test 6***");
	}
    
    
 @Test(priority=8,groups={"Smoke","EndToEnd"})										//Validate navigating to the Product Display page and adding the product to cart     
	public void verify_AddToCartFromProductDisplay() throws InterruptedException {
		
		logger.info("***Starting Test 8***");
		HomePage hp = new HomePage(driver);
		ProductDisplay pdp = new ProductDisplay(driver);
		LoginPage lp = new LoginPage(driver);
		ProductDetails pd = new ProductDetails(driver);
		
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		hp.clicklogin();
		logger.info("Clicked on login link");
		lp.login_mail("aouhs8u86fifkh@comcast.net");
		lp.login_pwd("asdfqwer123");
		lp.login_btn();
		Thread.sleep(3000);
		
		hp.clickLaptopsNotebooks();
		logger.info("Clicked on Laptops and Notebooks link");
		hp.AllLaptopNotebooksClick();
		logger.info("Selected Show AllLaptops & Notebooks link");
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.scrollByAmount(0, 170).perform();
		pdp.HP_LP3065click();
		logger.info("Clicked on HPLP3065");
		Thread.sleep(2000);
		act.scrollByAmount(0, 170).perform();
		Thread.sleep(2000);
		pd.addToCart();
		logger.info("Clicked on add to cart button");
		Thread.sleep(3000);
		boolean test = pd.successmsg();
		logger.info("Validating navigating to the Product Display page and adding the product to cart  ");
		Assert.assertEquals(test, true);
		logger.info("Finished Test 8***");
	}
	
	
	
	
	
	
	
	
	
}
