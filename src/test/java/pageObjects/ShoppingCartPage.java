package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BaseClass{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]/img[1]")
	WebElement img_hplp;
	@FindBy(linkText="HP LP3065")
	WebElement name_hplp;
	@FindBy(xpath="//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]")
	WebElement shoppingCartEmpty_msg;
	
	
	public void img_hplp() {
		img_hplp.click();
	}
	public void name_hplp() {
		name_hplp.click();
	}
	public boolean shoppingCartEmptyMsg() {
		return shoppingCartEmpty_msg.isDisplayed();
	}
}
