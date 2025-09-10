package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductComparePage extends BaseClass{

	public ProductComparePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
@FindBy(xpath="//h1[normalize-space()='Product Comparison']")
WebElement poductCompare_heading;

public boolean productComparepage() {
	return poductCompare_heading.isDisplayed();
}
  	
	
  	
	
	
	
	
	
	
	
}
