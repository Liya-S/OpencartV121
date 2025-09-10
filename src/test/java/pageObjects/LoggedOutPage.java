package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedOutPage extends BaseClass{

	public LoggedOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//h1[normalize-space()='Account Logout']")
	WebElement logoutTitle;
	
	public boolean titleDisplayed() {
		return logoutTitle.isDisplayed();
	}
}
