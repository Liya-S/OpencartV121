package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BaseClass {
	
	
	public MyAccount(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement MyAccount_Title;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement Logout_RightColumn;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Register']")					  //RIGHT COLUMN OPTIONS
	WebElement right_register;

	@FindBy(xpath ="//a[@class='list-group-item'][normalize-space()='Login']")                        //RIGHT COLUMN OPTIONS
	WebElement Login_rightColumn;

	@FindBy(xpath ="//a[@class='list-group-item'][normalize-space()='Forgotten Password']")           //RIGHT COLUMN OPTIONS
	WebElement ForgotPwd_rightColumn;

	@FindBy(xpath ="//a[normalize-space()='My Account']")											  //RIGHT COLUMN OPTIONS
	WebElement MyAccount_rightColumn;

	@FindBy(xpath ="//a[@class='list-group-item'][normalize-space()='Address Book']")				 //RIGHT COLUMN OPTIONS
	WebElement AddressBook_rightColumn;

	@FindBy(xpath ="//a[@class='list-group-item'][normalize-space()='//a[@class='list-group-item'][normalize-space()='Wish List']']")  //RIGHT COLUMN OPTIONS
	WebElement WishList_rightColumn;

	@FindBy(xpath ="//a[@class='list-group-item'][normalize-space()='Order History']")              //RIGHT COLUMN OPTIONS
	WebElement OrderHistory_rightColumn;

	@FindBy(linkText ="Downloads")																	//RIGHT COLUMN OPTIONS
	WebElement Downloads_rightColumn;

	@FindBy(linkText ="Recurring payments")															//RIGHT COLUMN OPTIONS
	WebElement Recurringpayments_rightColumn;

	@FindBy(linkText ="Reward Points")																//RIGHT COLUMN OPTIONS
	WebElement RewardPoints_rightColumn;

	@FindBy(linkText ="Returns")																	//RIGHT COLUMN OPTIONS
	WebElement Returns_rightColumn;

	@FindBy(linkText ="Transactions")																//RIGHT COLUMN OPTIONS
	WebElement Transactions_rightColumn;

	@FindBy(linkText ="Newsletter")																	//RIGHT COLUMN OPTIONS
	WebElement Newsletter_rightColumn;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Forgotten Password']")
	WebElement Forgotten_Pwd;

	public boolean GetTitle() {
		return MyAccount_Title.isDisplayed();
	}
	public boolean Logout_RightCol_displayed() {
		return Logout_RightColumn.isDisplayed();
	}
	public void Logout_RightCol_click() {
		Logout_RightColumn.click();
	}
	public void right_col_register(){
		right_register.click();
	}
	public void Login_RightCol_click() {
		Login_rightColumn.click();
	}
	public void MyAccount_RightCol_click() {
		MyAccount_rightColumn.click();
	}
	public void AddressBook_RightCol_click() {
		AddressBook_rightColumn.click();
	}
	public void WishList_RightCol_click() {
		WishList_rightColumn.click();
	}
	public void OrderHistory_RightCol_click() {
		OrderHistory_rightColumn.click();
	}
	public void Downloads_RightCol_click() {
		Downloads_rightColumn.click();
	}
	public void ReccurringPayments_RightCol_click() {
		Recurringpayments_rightColumn.click();
	}
	public void RewardPoints_RightCol_click() {
		RewardPoints_rightColumn.click();
	}
	public void ForgottenPwd_RightCol_click() {
		Forgotten_Pwd.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
