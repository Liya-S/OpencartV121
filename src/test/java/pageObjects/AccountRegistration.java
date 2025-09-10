package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BaseClass{

	public AccountRegistration(WebDriver driver) {
		super(driver);
		
	}
@FindBy(id="input-firstname") 
WebElement firstName;

@FindBy(id="input-lastname")
WebElement lastname;

@FindBy(id="input-email") 
WebElement email;

@FindBy(id="input-telephone") 
WebElement phone;

@FindBy(id="input-password")
WebElement pwd;

@FindBy(id="input-confirm") 
WebElement conf_pwd;

@FindBy(xpath="//label[normalize-space()='Yes']")
WebElement newsletter_yes;

@FindBy(xpath="//input[@value='0']")
WebElement newsletter_no;

@FindBy(xpath="//input[@name='agree']") 
WebElement agree;

@FindBy(xpath="//input[@value='Continue']") 
WebElement butn_cont ;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msg_conf;

@FindBy(xpath="//h1[normalize-space()='Register Account']")
WebElement title_register;

@FindBy(xpath="//b[normalize-space()='Privacy Policy']")
WebElement privacyPolicy;

@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/h4[1]")
WebElement heading_privacyPolicy;

@FindBy(xpath = "//a[normalize-space()='login page']")
WebElement login_link;

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



public void setFirstName(String fname) {
	firstName.sendKeys(fname);
}
public void setLastName(String lname) {
	lastname.sendKeys(lname);
}
public void setE_mail(String e_mail) {
	email.sendKeys(e_mail);
}
public void setPh_no(String phno) {
	phone.sendKeys(phno);
}
public void setPwd(String p_wd) {
	pwd.sendKeys(p_wd);
}
public void setConfPwd(String c_pwd) {
	conf_pwd.sendKeys(c_pwd);
}
public void newsletter_yes() {
	newsletter_yes.click();
}

public void newsletter_no() {
	newsletter_no.click();
}

public void agree() {
	agree.click();
}
public void butCont() {
	butn_cont.click();
}
 
public String getConfMsg() {
try {
	return(msg_conf.getText());
} catch(Exception e) {
	return(e.getMessage());
}
}

public boolean title() {
	boolean rt=title_register.isDisplayed();
	return rt;
	
}	
public void right_col_register(){
	right_register.click();
}

public String pwd_hidden() {
	String type = pwd.getAttribute("type");
	return type;
}

public String fnamePlaceHolder() {
	
	String fname_placeholder = firstName.getAttribute("placeholder");
	return fname_placeholder;
}

public String lnamePlaceHolder() {
	
	String lname_placeholder = lastname.getAttribute("placeholder");
	return lname_placeholder;
}
	
public String emailPlaceHolder() {
	
	String email_placeholder = email.getAttribute("placeholder");
	return email_placeholder;
}

public String phonePlaceHolder() {
	
	String phone_placeholder = phone.getAttribute("placeholder");
	return phone_placeholder;
}

public String pwdPlaceHolder() {
	
	String pwd_placeholder = pwd.getAttribute("placeholder");
	return pwd_placeholder;
}

public String conf_pwdPlaceHolder() {
	String conf_pwd_placeholder = conf_pwd.getAttribute("placeholder");
	return conf_pwd_placeholder;	
}	
	
	
	
	
	

public void privacy_Policy(){
	privacyPolicy.click();
}

public boolean heading_PrivacyPolicy() {
 return heading_privacyPolicy.isDisplayed();
}
	
public void Login_link() {
	login_link.click();
}

public void Login_rightColumn() {
	Login_rightColumn.click();
}	
	
	
}