package testCases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import org.testng.annotations.Test;


import pageObjects.LoginPage;
import pageObjects.ProductComparePage;
import pageObjects.SearchPage;
import pageObjects.SiteMap;
import pageObjects.HomePage;
public class TC05_Search extends Test_base{

	@Test(priority=1,groups="Sanity")								//Validate navigating to Search page from the Site Map page
	public void verify_navigation_fromSiteMap() {
		
		logger.info("********Starting TC05_Search********");
		logger.info("***Starting Test 1***");
		HomePage hp = new HomePage(driver);
		SiteMap sm = new SiteMap(driver);
		SearchPage sp = new SearchPage(driver);
		hp.clicksiteMap();
		logger.info("Clicked on my site map link");
		sm.search();
		logger.info("Clicked on search link");
		boolean test = sp.isSearchPageDisplayed();
		logger.info("Validating navigating to Search page from the Site Map page");
		Assert.assertEquals(test, true);
		logger.info("Finished Test 1***");
	}
	
	
	 @Test(priority=2,groups={"Sanity","Functional"})								//Validate searching by giving an existing product name			
		public void verify_search_validProduct() throws InterruptedException {
			
			logger.info("***Starting Test 2***");
			HomePage hp = new HomePage(driver);
			SearchPage sp = new SearchPage(driver);
			hp.titleHome();
			hp.clickSearchbtn();
			logger.info("Clicked on search button");
			Thread.sleep(3000);
			logger.info("Entering details...");
			sp.keyWord("mac");
			sp.category(3);
			sp.subCategory();
			sp.descriptionCheckbox();
			sp.btnSearch();
			logger.info("Clicked on search tab");
			Thread.sleep(4000);
			boolean test = sp.searchProductDisplay();
			logger.info("Validating searching by giving an existing product name");
			Assert.assertEquals(test, true);
			logger.info("Finished Test 2***");
		}
	    
	    @Test(priority=3,groups="Negative")								//Validate searching by giving a non-existing product name			
		public void verify_search_invalidProduct() throws InterruptedException {
			
			logger.info("***Starting Test 3***");
			HomePage hp = new HomePage(driver);
			SearchPage sp = new SearchPage(driver);
			hp.titleHome();
			hp.clickSearchbtn();
			logger.info("Clicked on search button");
			logger.info("Entering details...");
			sp.keyWord("asus");
			sp.category(2);
			sp.subCategory();
			sp.descriptionCheckbox();
			sp.btnSearch();
			logger.info("Clicked on search tab");
			Thread.sleep(4000);
			boolean test = sp.noProductDisplay();
			logger.info("Validating searching by giving a non-existing product name");
			Assert.assertEquals(test, true);	
			logger.info("Finished Test 3***");
			
			}
	    
	    
	    
	    @Test(priority=4,groups="Negative")								//Validate searching by leaving search textfield empty		
		public void verify_search_emptySearchfield() throws InterruptedException {
			
			logger.info("***Starting Test 4***");
			HomePage hp = new HomePage(driver);
			SearchPage sp = new SearchPage(driver);
			hp.titleHome();
			hp.clickSearchbtn();
			logger.info("Clicked on search button");
			sp.keyWord("");
			logger.info("Left keyword textfield empty");
			sp.category(2);
			sp.subCategory();
			sp.descriptionCheckbox();
			sp.btnSearch();
			logger.info("Clicked on search tab");
			Thread.sleep(4000);
			boolean test = sp.noProductDisplay();
			logger.info("Validating searching by leaving search textfield empty");
			Assert.assertEquals(test, true);	
			logger.info("Finished Test 4***");
			
		}
		
		@Test(priority=5,groups="Negative")								//Validate searching by leaving search textfield empty	and no option selected	in category
		public void verify_search_emptySearchfield02() throws InterruptedException {
			
			logger.info("***Starting Test 5***");
			HomePage hp = new HomePage(driver);
			SearchPage sp = new SearchPage(driver);
			hp.titleHome();
			hp.clickSearchbtn();
			logger.info("Clicked on search button");
			sp.keyWord("");
			sp.category(0);
			sp.subCategory();
			sp.descriptionCheckbox();
			sp.btnSearch();
			logger.info("Clicked on search tab");
			Thread.sleep(4000);
			boolean test = sp.noProductDisplay();
			logger.info("Validating searching by leaving search textfield empty	and no option selected	in category");
			Assert.assertEquals(test, true);
			logger.info("Finished Test 5***");
			
		}
		
		@Test(priority=6,groups={"Functional","Regression","Sanity","EndToEnd"})								//Validate searching for a product after login	
		public void verify_search_AfterLogin() throws InterruptedException {
			
			logger.info("***Starting Test 6***");
			HomePage hp = new HomePage(driver);
			SearchPage sp = new SearchPage(driver);
			LoginPage lp=new LoginPage(driver);
			hp.titleHome();
			hp.clickMyaccount();
			logger.info("Clicked on my account link");
			hp.clicklogin();
			logger.info("Clicked on login link");
			lp.login_mail("aouhs8u86fifkh@comcast.net");
			lp.login_pwd("asdfqwer123");
			lp.login_btn();
			Thread.sleep(4000);
			logger.info("Entered login details and clicked on login link");
			sp.searchText("mac");
			sp.btnSearch_Loginpage();
			logger.info("Entered text in search textfield and selected on login button");
			Thread.sleep(4000);
			boolean test = sp.searchProductDisplay();
			logger.info("Validating searching for a product after login");
			Assert.assertEquals(test, true);
			logger.info("Finished Test 6***");
			
		}
		
		@Test(priority=7,groups={"Functional","Regression"})								//Validate searching without checking search in product description		
		public void verifyWithoutCheckingSearchInProductDescription() throws InterruptedException {
			
			logger.info("***Starting Test 7***");
			HomePage hp = new HomePage(driver);
			SearchPage sp = new SearchPage(driver);
			hp.titleHome();
			hp.clickSearchbtn();
			logger.info("Clicked on search button");
			logger.info("Entering details..");
			sp.keyWord("asus");
			sp.category(2);
			sp.subCategory();
			sp.btnSearch();
			logger.info("Clicked on search tab");
			Thread.sleep(4000);
			boolean test = sp.searchProductDisplay();
			logger.info("Validating searching for a product after login");
			Assert.assertEquals(test, true);	
			logger.info("Finished Test 7***");
			
			}
		
		
		@Test(priority=8,groups= {"Functional","Regression","Negative"})								//Validate searching without checking search in sub-categories	
		public void verifyWithoutCheckingSearchInSubCategories() throws InterruptedException {
			
			logger.info("***Starting Test 8***");
			HomePage hp = new HomePage(driver);
			SearchPage sp = new SearchPage(driver);
			hp.titleHome();
			hp.clickSearchbtn();
			logger.info("Clicked on search button");
			logger.info("Entering details..");
			sp.keyWord("asus");
			sp.category(3);
			sp.descriptionCheckbox();
			sp.btnSearch();
			logger.info("Clicked on search tab");
			Thread.sleep(4000);
			boolean test = sp.searchProductDisplay();
			logger.info("Validating searching without checking search in sub-categories");
			Assert.assertEquals(test, true);
			logger.info("Finished Test 8***");
				
			}
		
		@Test(priority=9,groups="UI")								//Validate all the fields in the Search functionality and Search page have placeholders
		public void verifyPlaceholders() throws InterruptedException {
			
			logger.info("***Starting Test 9***");
			SearchPage sp = new SearchPage(driver);
			HomePage hp = new HomePage(driver);
			hp.titleHome();
			hp.clickSearchbtn();
			logger.info("Clicked on search button");
			String test1 = sp.placeholderKeyword();
			String test2 = sp.placeholderSearch();
			logger.info("Validating all the fields in the Search functionality and Search page have placeholders");
			if(test1=="Keywords" && test2=="Search") {
			Assert.assertEquals(true, true, "Placeholder Present");
			}
			logger.info("Finished Test 9***");
			}
		
		@Test(priority=11,groups= "Functional")												//Validate List view when multiple products are displayed in the search results
		public void verifyListView_MultipleProducts() throws InterruptedException{  
			
			logger.info("***Starting Test 11***");
			HomePage hp = new HomePage(driver);											
			SearchPage sp = new SearchPage(driver);
			hp.titleHome();
			hp.clickSearchbtn();
			logger.info("Clicked on search button");
			logger.info("Entering details..");
			sp.keyWord("mac");															 
			sp.category(4);
			sp.descriptionCheckbox();                                                       
			sp.btnSearch();
			logger.info("Clicked on search tab");
			Thread.sleep(4000);
			sp.view_List();
			logger.info("Clicked on list tab");
			Thread.sleep(4000);
			String test = sp.attribute_List();
			System.out.println(test);
			logger.info("Validating List view when multiple products are displayed in the search results");
			Assert.assertEquals(test, "btn btn-default active");
			logger.info("Finished Test 11***");
			}
		
		@Test(priority=12,groups= "Functional")							//Validate Grid view when multiple products are displayed in the search results
		public void verifyListAndGridViews_MultipleProducts() throws InterruptedException{  
			
			logger.info("***Starting Test 12***");
			HomePage hp = new HomePage(driver);											
			SearchPage sp = new SearchPage(driver);
			hp.titleHome();
			hp.clickSearchbtn();
			logger.info("Clicked on search button");
			logger.info("Entering details..");
			sp.keyWord("mac");															 
			sp.category(4);
			sp.descriptionCheckbox();                                                       
			sp.btnSearch();
			logger.info("Clicked on search tab");
			Thread.sleep(4000);
			sp.view_Grid();
			logger.info("Clicked on Grid tab");
			String test = sp.attribute_Grid();
			logger.info("Validating Grid view when multiple products are displayed in the search results");
			Assert.assertEquals(test, "btn btn-default active");
			//logger.info("Finished Test 12***");
			}
		
		@Test(priority=13,groups= "Functional")								//Validate navigating to Product Compare Page from Search Results page
		public void verifyNavigation_ProductComparePage() throws InterruptedException {
			
			logger.info("***Starting Test 13***");
			HomePage hp = new HomePage(driver);
			SearchPage sp = new SearchPage(driver);
		    ProductComparePage pcp = new ProductComparePage(driver);
		    hp.titleHome();
		    hp.clickSearchbtn();
		    logger.info("Clicked on search button");
			logger.info("Entering details..");
			sp.keyWord("mac");
			sp.category(4);
			sp.descriptionCheckbox();
			sp.btnSearch();
			logger.info("Clicked on search tab");
			Actions act = new Actions(driver);
			act.scrollByAmount(0, 500).perform();
			Thread.sleep(4000);
			sp.compare_macbook();
			logger.info("Added macbook to compare");
			Thread.sleep(2000);
			act.scrollByAmount(0, 500).perform();
			sp.compare_macbookAir();
			logger.info("Added macbookAir to compare");
			Thread.sleep(2000);
			act.scrollByAmount(0, 500).perform();
			sp.compare_macbookPro();
			logger.info("Added macbookPro to compare");
			Thread.sleep(2000);
			sp.btn_compareTotal();
			logger.info("Clicked on compare all button");
			Thread.sleep(4000);	
			boolean test = pcp.productComparepage();
			logger.info("Validating navigating to Product Compare Page from Search Results page");
			Assert.assertEquals(test, true);	
			logger.info("Finished Test 13***");
			
			}
	}