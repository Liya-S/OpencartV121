package pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;




public class SearchPage extends BaseClass{

	
	public SearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	
	@FindBy(xpath="//h1[normalize-space()='Search']")
	WebElement searchPage;
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement searchText;
	@FindBy(id="input-search")
	WebElement keyWord;
	@FindBy(name="category_id")
	WebElement category;
	@FindBy(name="sub_category")
	WebElement subcategory_checkbox;
	@FindBy(name="description")
	WebElement description_checkbox;
	@FindBy(id="button-search")
	WebElement btn_search;
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement btn_searchLoginpage;
	@FindBy(xpath="//h2[normalize-space()='Products meeting the search criteria']")   
	WebElement searchProductDisplay;
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
	WebElement noProductsMessage;
	@FindBy(id="list-view")
	WebElement list;
	@FindBy(id="grid-view")
	WebElement grid;
	@FindBy(xpath="//a[text()='MacBook']/ancestor::div[contains(@class,'product-layout')]//div[@class='button-group']//i[contains(@class,'fa') and contains(@class,'fa-exchange')]")
	WebElement compare_macbook;
	@FindBy(xpath="//a[text()='MacBook Air']/ancestor::div[contains(@class,'product-layout')]//div[@class='button-group']//i[contains(@class,'fa') and contains(@class,'fa-exchange')]")
	WebElement compare_macbookAir;
	@FindBy(xpath="//a[text()='MacBook Pro']/ancestor::div[contains(@class,'product-layout')]//div[@class='button-group']//i[contains(@class,'fa') and contains(@class,'fa-exchange')]")
	WebElement compare_macbookPro;
	
	@FindBy(id="compare-total")
	WebElement compare_total; 
	@FindBy(id="input-sort")
	WebElement sortBy;
	
	
	public boolean isSearchPageDisplayed() {
		return searchPage.isDisplayed();
	}
	
	public void searchText(String search) {
	searchText.sendKeys(search);
	}
	
	public void keyWord(String key_Word) {
		keyWord.sendKeys(key_Word);
	}
	
	public void category(int c) {
	Select sel = new Select(category);
	category.click();
	sel.selectByIndex(c);
	}
	
	public void subCategory() {
	subcategory_checkbox.click();
	}
	
	public void descriptionCheckbox() {
	description_checkbox.click();
	}
	
	public void btnSearch() {
	btn_search.click();
	}
	
	public void btnSearch_Loginpage() {
	btn_searchLoginpage.click();
	}
	
	public boolean searchProductDisplay() {
	return searchProductDisplay.isDisplayed();
	}
	
	public boolean noProductDisplay() {
	return noProductsMessage.isDisplayed();
	}
	
	public String placeholderSearch() {
	return searchText.getAttribute("placeholder");
	}
	
	
	public String placeholderKeyword() {
	return keyWord.getAttribute("placeholder");
	}
	
	public void view_List() {
	list.click();
	}
	
	public void view_Grid() {
	grid.click();
	}
	
	public String attribute_List() {
	return list.getAttribute("class");
	}
		
	public String attribute_Grid() {
	return grid.getAttribute("class");
	}
	
	public void compare_macbookAir() {
	compare_macbookAir.click();
	}
		
	public void compare_macbookPro() {
	compare_macbookPro.click();
	}
	
	public void compare_macbook() {
	compare_macbook.click();
	}	
	
	public void btn_compareTotal() {
		compare_total.click();
	}
	
	public void sortBy(String sort_by) {
		sortBy.click();
		Select sel = new Select(sortBy);
		sel.selectByVisibleText(sort_by);
	}
	
	
	
	
	
	
	
	
	
	
}
