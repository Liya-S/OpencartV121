package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
public class CheckoutPage extends BaseClass{

	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//input[@value='new']")
	WebElement btn_NewAddress;
	@FindBy(id="input-payment-firstname")
	WebElement firstname;
	@FindBy(id="input-payment-lastname")
	WebElement lastname;
	@FindBy(id="input-payment-company")
	WebElement company;
	@FindBy(id="input-payment-address-1")
	WebElement address1;
	@FindBy(id="input-payment-address-2")
	WebElement address2;
	@FindBy(id="input-payment-city")
	WebElement city;
	@FindBy(id="input-payment-postcode")
	WebElement postcode;
	@FindBy(id="input-payment-country")
	WebElement country;
	@FindBy(id="input-payment-zone")
	WebElement state;
	@FindBy(id="button-payment-address")
	WebElement btn_paymentAddress;
	@FindBy(xpath="//label[normalize-space()='I want to use an existing address']//input[@name='shipping_address']")
	WebElement btn_useExistingAddress;
	@FindBy(id="button-shipping-address")
	WebElement btn_ContShippingAddress;
	@FindBy(xpath="//textarea[@name='comment']")
	WebElement comments;
	@FindBy(id="button-shipping-method")
	WebElement btn_ContShippingMethod;
	@FindBy(xpath="//input[@name='agree']")
	WebElement btn_Agree;
	@FindBy(id="button-payment-method")
	WebElement btn_ContPaymentMethod;
	
	@FindBy(linkText="HP LP3065")
	WebElement link_HP3065;
	@FindBy(id="button-confirm")
	WebElement btn_confirm;
	
	
	public void btn_useNewAddress() {
	btn_NewAddress.click();
	}
	public void f_name(String fname) {
	firstname.sendKeys(fname);
	}
	public void l_name(String lname) {
	lastname.sendKeys(lname);
	}
	public void company_name(String comp_name) {
	company.sendKeys(comp_name);
	}
	public void address1(String address_1) {
	address1.sendKeys(address_1);
	}
	public void address2(String address_2) {
	address2.sendKeys(address_2);
	}
	public void city(String city_name) {
	city.sendKeys(city_name);
	}
	public void post_code(String post_code) {
	postcode.sendKeys(post_code);
	}
	public void countryName(String country_name) {
	country.click();
	Select sel = new Select(country);
	sel.selectByVisibleText(country_name);
	}
	public void state(String stateName) {
	state.click();
	Select sel = new Select(state);
	sel.selectByVisibleText(stateName);
	}
	public void BtnPaymentAddress() {
	btn_paymentAddress.click();
	}
	public void BtnExistingAddress() {
	btn_useExistingAddress.click();
	}
	public void BtnContShipppingAddress() {
	btn_ContShippingAddress.click();
	}
	public void comment(String Comments) {
	comments.sendKeys(Comments);
	}
	public void BtnContShippingMethod() {
	btn_ContShippingMethod.click();
	}
	public void agreeBtn() {
	btn_Agree.click();
	                  }
	public void BtnContPaymentMethod() {
	btn_ContPaymentMethod.click();
	}
	public void link_HP3065() {
	link_HP3065.click();
	}
	public void BtnConfirm(){
	btn_confirm.click();
	}
	
	
	
}
