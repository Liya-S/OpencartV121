package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;




public class WishListPage extends BaseClass{

	public WishListPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath="//div[@class='table-responsive']//table//tbody//td")
	WebElement HPLP_IMG;
	@FindBy(linkText="HP LP3065")
	WebElement HPLP_Name;
	@FindBy(xpath="//a[normalize-space()='My Wish List']")
	WebElement breadcrumb;
	
	public void hplpImgSel() {
		HPLP_IMG.click();
	}
	public void hplpNameSel() {
		HPLP_Name.click();
	}
	public boolean breadcRumb() {
		return breadcrumb.isDisplayed();
	}
	
}
