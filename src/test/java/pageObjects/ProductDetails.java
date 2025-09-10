package pageObjects;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.Select;




public class ProductDetails extends BaseClass{

	public ProductDetails(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	//HPLP3065 //all
	
	@FindBy(xpath="//button[@class=\"btn btn-default\" and @data-original-title=\"Add to Wish List\"]")
	WebElement wishlist; 
	@FindBy(xpath="//button[@class=\"btn btn-default\" and @data-original-title=\"Compare this Product\"]")
	WebElement compare; 
	@FindBy(xpath="//i[@class='fa fa-calendar']")
	WebElement deliveryDate; 
	@FindBy(xpath="//th[normalize-space()='April 2011']")
	WebElement AutomaticMonthYear;
	
	@FindBy(xpath="//th[normalize-space()='2011']")
	WebElement AutomaticYear; 

	@FindBy(xpath="//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]")             //next button > to traverse between months
	WebElement btn_Next;
	
	@FindBy(xpath="//input[@id='input-quantity']")
	WebElement qty;
	
	@FindBy(xpath="//button[@id='button-cart']")                                    //Add To Cart
	WebElement btn_addToCart;
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[contains(text(),'HP LP3065')]")     //breadcrumb of HPLP3065 LAPTOP
	WebElement breadcrumb_HPLP3065;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//a[contains(text(),'HP LP3065')]")
	WebElement SuccessMsg_HPLP_Link;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement successMsg;
	//AppleCinema30
	
	@FindBy(name="option[223][]")
	WebElement AppleCinema30checkbox1;
	@FindBy(name="option[223][]")
	WebElement AppleCinema30checkbox2;
	@FindBy(xpath="//input[@id='input-option208']")
	WebElement AppleCinema30Text;
	@FindBy(xpath="//select[@id='input-option217']")
	WebElement AppleCinema30SelColour;
	@FindBy(xpath="//textarea[@id='input-option209']")
	WebElement AppleCinema30Textarea;
	@FindBy(xpath="//button[@id='button-upload222']")
	WebElement AppleCinema30Upload;
	
	@FindBy(xpath="//div[@class='input-group date']//i[@class='fa fa-calendar']")
	WebElement AppleCinema30Date;
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[4]")
	WebElement dateSelected;
	
	@FindBy(xpath="//div[@class='input-group time']//button[@type='button']")               	//icon for time
	WebElement AppleCinema30Time;
	@FindBy(xpath="//body[1]/div[5]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/span[1]")		//currently displayed time in hr
	WebElement currentTime;
	@FindBy(xpath="//body[1]/div[5]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[1]/a[1]/span[1]")  //lower arrow button to changer time to lesser value in hr 
	WebElement lesser_ArrowBtn;
	@FindBy(xpath="//body[1]/div[5]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]")			//upper arrow button to changer time to higher value in hr
	WebElement Higher_ArrowBtn;
	
	@FindBy(xpath="//div[@class='input-group datetime']//button[@type='button']")
	WebElement AppleCinema30DateTime;
	@FindBy(xpath="//input[@id='input-quantity']")
	WebElement AppleCinema30Qty;
	
	
	
	
	
	
	
	public void addToWishList() {
		wishlist.click();
	}
	
	public void addToCart() {
		btn_addToCart.click();
	}
	
	public void SuccessMsg_HPLP_Click() {
		btn_addToCart.click();
	}
	
	
	public void selectDeliveryDate(String year, String month, String date) {
		deliveryDate.click();
		AutomaticMonthYear.click();
		Select sel = new Select(AutomaticMonthYear);
		sel.selectByVisibleText(year);
		sel.selectByVisibleText(month);
		sel.selectByValue(date);
	}
		
	public void selectQty(int no) {	
		qty.sendKeys("no");
	}
	
	public boolean breadcrumb_HPLP3065() {
		return breadcrumb_HPLP3065.isDisplayed();
	}
	
	
	public void AppleCinema30optionCheck1() {                            //   AppleCinema30
	AppleCinema30checkbox1.click();
	}
	public void AppleCinema30optionCheck2() {
		AppleCinema30checkbox2.click();
	}
	public void AppleCinema30text(String txt) {
	AppleCinema30Text.sendKeys(txt);
	}
	public void AppleCinema30colour(String Colour) {
	AppleCinema30SelColour.click();
	Select sel = new Select(AppleCinema30SelColour);
	sel.selectByValue(Colour);
	}
	public void AppleCinema30txtArea(String Comments) {
	AppleCinema30Textarea.sendKeys(Comments);
	}
	public void AppleCinema30upload(String upload) {
	AppleCinema30Upload.sendKeys(upload);
	}
	
	public void AppleCinema30date() {
	AppleCinema30Date.click();
	dateSelected.click();
	}
	
	public void AppleCinema30time(int hr, int min) {
	AppleCinema30Time.click();	
	String cTime = currentTime.getText();
	int tHr = Integer.parseInt(cTime);
	if(hr==tHr) {
		currentTime.click();
	}
	else if(hr<tHr) {
		lesser_ArrowBtn.click();
	}
	else if(hr>tHr) {
		Higher_ArrowBtn.click();
	}	
	}
	
	public void AppleCinema30dateTime() {
	AppleCinema30DateTime.click();	
	}
	
	public void AppleCinema30qty(CharSequence[] no) {
	AppleCinema30Qty.sendKeys(no);
	}
	
	public boolean successmsg() {
		return successMsg.isDisplayed();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
