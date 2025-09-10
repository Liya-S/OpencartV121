package pageObjects;

import java.time.Duration;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseClass{

	public HomePage(WebDriver driver) { 
		super(driver);
		   
	}
	

@FindBy(linkText="Qafox.com")	
WebElement homeTitle;
@FindBy(xpath="//span[normalize-space()='My Account']")
WebElement MyAccount;
@FindBy(linkText="Register") 
WebElement Register;
@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
WebElement Login;
@FindBy(linkText="Order History")                                         //After Login
WebElement OrderHistory;
@FindBy(linkText="Transactions")
WebElement Transactions;
@FindBy(linkText="Downloads")
WebElement Downloads;
@FindBy(id="wishlist-total")
WebElement WishList;
@FindBy(xpath="//span[text()='Shopping Cart']")
WebElement ShoppingCart;
@FindBy(xpath="//span[text()='Checkout']")
WebElement Checkout;
@FindBy(linkText="//i[@class='fa fa-phone']")
WebElement contact;
@FindBy(linkText="//span[normalize-space()='Shopping Cart']")
WebElement btn_shoppingCart;
@FindBy(xpath="//a[normalize-space()='Logout']")
WebElement Logout; 
@FindBy(linkText="Site Map")
WebElement sitemap;
@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
WebElement btn_search;

@FindBy(id="cart-total")
WebElement Toggle_shoppingCart;


@FindBy(linkText="Desktops")
WebElement Desktops;
@FindBy(linkText="Laptops & Notebooks")
WebElement LaptopsNotebooks;
@FindBy(linkText="Components")
WebElement Components;
@FindBy(linkText="Tablets")
WebElement Tablets;
@FindBy(linkText="Software")
WebElement Software;
@FindBy(linkText="Phones & PDAs")
WebElement Phones_PDAs;
@FindBy(linkText="Cameras")
WebElement Cameras;
@FindBy(linkText="MP3 Players")
WebElement MP3Players;

@FindBy(linkText="Mac (1)")
WebElement mac_click;
@FindBy(linkText="PC (0)")
WebElement pc_click;
@FindBy(linkText="Show AllLaptops & Notebooks")
WebElement AllLaptopsNotebooks_click;
@FindBy(linkText="Monitors (2)")
WebElement Monitors;


public void titleHome() {
	homeTitle.click();
}

public void clickMyaccount() {                                      //Title bar
	Actions act = new Actions(driver);
	act.click(MyAccount).perform();
}

public void clickRegister() {										//Title bar
	Register.click();
}

public void clicklogin() {											//Title bar
	Login.click();
}

public void clickOrderHistory() {									//Title bar
	OrderHistory.click();
}

public void clickTransactions() {									//Title bar
	Transactions.click();
}

public void clickDownloads() {										//Title bar
	Downloads.click();
}

public void clickWishList() {										//Title bar
	WishList.click();
}

public void clickShoppingCart() {									//Title bar
	ShoppingCart.click();
}

public void clickCheckout() {										//Title bar
	Checkout.click();
}

public void clickcontact() {										//Title bar
	contact.click();
}

public void clickbtn_shoppingCart() {								//Title bar
	btn_shoppingCart.click();
}


public void clickLogout() {											//Title bar
	Logout.click();
}

public boolean LoginIsdisplayed() {									//Title bar
	return Login.isDisplayed();
}

public boolean LogoutIsdisplayed() {								//Title bar
	return Logout.isDisplayed();
}

public void clicksiteMap() {										//Bottom
	
	Actions act = new Actions(driver);
	act.scrollByAmount(0, 300);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Site Map"))); // adjust locator

	
	sitemap.click();
}

public void clickSearchbtn() {										
	btn_search.click();
}

public void Toggle_shoppingCart() {
	Toggle_shoppingCart.click();
}

public void clickDesktops() {                       //top menu
	Desktops.click();
}

public void clickLaptopsNotebooks() {				//top menu
	LaptopsNotebooks.click();
}

public void clickComponents() {						//top menu
	Components.click();
}

public void clickTablets() {						//top menu
	Tablets.click();
}

public void clickSoftware() {						//top menu
	Software.click();
}

public void clickPhones_PDAs() {					//top menu
	Phones_PDAs.click();
}

public void clickCameras() {						//top menu
	Cameras.click();
}
public void clickMP3Players() {						//top menu
	MP3Players.click();
}

public void mac_click() {
	mac_click.click();
}

public void pc_click() {
	pc_click.click();
}

public void AllLaptopNotebooksClick() {
	AllLaptopsNotebooks_click.click();
}

public void ClickMonitors() {
	Monitors.click();
}


   












}
     