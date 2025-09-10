package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductDisplay extends BaseClass{

	public ProductDisplay(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//h2[normalize-space()='PC']")
	WebElement PC_title;
	@FindBy(xpath="//div[@id=\"content\"]//h2[text()='Mac']")
	WebElement MacDesktop_title;
	@FindBy(xpath="//h2[normalize-space()='Desktops']")
	WebElement AllDesktops_title;
	
	@FindBy(xpath="//h2[normalize-space()='Macs']")
	WebElement MacLaptop_title;
	@FindBy(xpath="//h2[normalize-space()='Windows']")
	WebElement WindowsDesktop_title;
	@FindBy(xpath="//h2[normalize-space()='Laptops & Notebooks']")
	WebElement AllLaptopsNotebooks_title;
	
	@FindBy(xpath="//h2[normalize-space()='Mice and Trackballs']")
	WebElement MiceTrackballs_title;
	@FindBy(xpath="//h2[normalize-space()='Monitors']")
	WebElement Monitors_title;
	@FindBy(xpath="///h2[normalize-space()='Printers']")
	WebElement Printers_title;
	@FindBy(xpath="//h2[normalize-space()='Scanners']")
	WebElement Scanners_title;
	@FindBy(xpath="//h2[normalize-space()='Web Cameras']")
	WebElement webCameras_title;
	@FindBy(xpath="//h2[normalize-space()='Components']")
	WebElement AllComponents_title;
	
	
	@FindBy(xpath="//h2[normalize-space()='Tablets']")
	WebElement Tablets_title;
	@FindBy(xpath="//h2[normalize-space()='Software']")
	WebElement Softwares_title;
	@FindBy(xpath="//h2[normalize-space()='Phones & PDAs']")
	WebElement PhonesPDAs_title;
	@FindBy(xpath="//h2[normalize-space()='Cameras']")
	WebElement Cameras_title;
	@FindBy(xpath="//h2[normalize-space()='MP3 Players']")
	WebElement allMP3Players_title;
	
	@FindBy(xpath="//p[normalize-space()='There are no products to list in this category.']")
	WebElement no_Products;
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement btn_Continue;
	
	@FindBy(linkText="iMac")
	WebElement iMac;
	@FindBy(linkText="HP LP3065")
	WebElement HP_LP3065;
	@FindBy(linkText="MacBook")
	WebElement MacBook;
	@FindBy(linkText="MacBook Air")
	WebElement MacBook_Air;
	@FindBy(linkText="MacBook Pro")
	WebElement MacBook_Pro;
	@FindBy(linkText="Sony VAIO")
	WebElement Sony_VAIO;
	@FindBy(linkText="Apple Cinema 30")
	WebElement AppleCinema;
	@FindBy(linkText="Samsung SyncMaster 941BW")
	WebElement SamsungSyncMasterBW;
	@FindBy(linkText="HTC Touch HD")
	WebElement HTC_TouchHD;
	@FindBy(linkText="Samsung Galaxy Tab 10.1")
	WebElement SamsungGalaxyTab10;
	@FindBy(linkText="iPhone")
	WebElement iPhone;
	@FindBy(linkText="Palm Treo Pro")
	WebElement PalmTreoPro;
	@FindBy(linkText="Canon EOS 5D")
	WebElement CanonEOS5D;
	@FindBy(linkText="Nikon D300")
	WebElement NikonD300;
	@FindBy(linkText="iPod Classic")
	WebElement iPodClassic;
	@FindBy(linkText="iPod Nano")
	WebElement iPodNano;
	@FindBy(linkText="iPod Shuffle")
	WebElement iPodShuffle;
	@FindBy(linkText="iPod Touch")
	WebElement iPodTouch;
	@FindBy(linkText="Samsung SyncMaster 941BW")
	WebElement SamsungSyncMaster;
	
	
	
	public void HP_LP3065click() {
		HP_LP3065.click();
	}
	
	public boolean HP_LP3065display() {
		return HP_LP3065.isDisplayed();
	}
	
	
	public void MacBookclick() {
		MacBook.click();
	}
	
	public boolean MacBookdisplay() {
		return MacBook.isDisplayed();
	}
	
	public void MacBook_Airclick() {
		MacBook_Air.click();
	}
	
	public boolean MacBook_Airdisplay() {
		return MacBook_Air.isDisplayed();
	}
	
	public void MacBook_Proclick() {
		MacBook_Pro.click();
	}
	
	public boolean MacBook_Prodisplay() {
		return MacBook_Pro.isDisplayed();
	}
	
	public void iMac_click() {
		iMac.click();
	}
	
	public void Sony_VAIOclick() {
		Sony_VAIO.click();
	}
	
	public boolean Sony_VAIOdisplay() {
		return Sony_VAIO.isDisplayed();
	}
	public void AppleCinemaclick() {
		AppleCinema.click();
	}
	
	public boolean AppleCinemadisplay() {
		return AppleCinema.isDisplayed();
	}
	public void SamsungSyncMasterBWclick() {
		SamsungSyncMasterBW.click();
	}
	
	public boolean SamsungSyncMasterBWdisplay() {
		return SamsungSyncMasterBW.isDisplayed();
	}
	public void HTC_TouchHDclick() {
		HTC_TouchHD.click();
	}
	
	public boolean HTC_TouchHDdisplay() {
		return HTC_TouchHD.isDisplayed();
	}
	public void SamsungGalaxyTab10click() {
		SamsungGalaxyTab10.click();
	}
	
	public boolean SamsungGalaxyTab10display() {
		return SamsungGalaxyTab10.isDisplayed();
	}
	public void iPhoneclick() {
		iPhone.click();
	}
	
	public boolean iPhonedisplay() {
		return iPhone.isDisplayed();
	}
	public void PalmTreoProclick() {
		PalmTreoPro.click();
	}
	
	public boolean PalmTreoProdisplay() {
		return PalmTreoPro.isDisplayed();
	}
	public void CanonEOS5Dclick() {
		CanonEOS5D.click();
	}
	
	public boolean CanonEOS5Ddisplay() {
		return CanonEOS5D.isDisplayed();
	}
	public void NikonD300click() {
		NikonD300.click();
	}
	
	public boolean NikonD300display() {
		return NikonD300.isDisplayed();
	}
	public void iPodClassicclick() {
		iPodClassic.click();
	}
	
	public boolean iPodClassicdisplay() {
		return iPodClassic.isDisplayed();
	}
	public void iPodNanoclick() {
		iPodNano.click();
	}
	
	public boolean iPodNanodisplay() {
		return iPodNano.isDisplayed();
	}
	public void iPodShuffleclick() {
		iPodShuffle.click();
	}
	
	public boolean iPodShuffledisplay() {
		return iPodShuffle.isDisplayed();
	}
	public void iPodTouchclick() {
		iPodTouch.click();
	}
	
	public boolean iPodTouchdisplay() {
		return iPodTouch.isDisplayed();
	}
	
	public boolean pcTitle() {
		return PC_title.isDisplayed();
	}
	public boolean MacDesktopTitle() {
		return MacDesktop_title.isDisplayed();
	}
	public boolean AllDesktops_title() {
		return AllDesktops_title.isDisplayed();
	}
	public void Click_SamsungSyncMaster() {
		SamsungSyncMaster.click();
	}
	
	
	
	
	
}
