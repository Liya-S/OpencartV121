package testCases;

import java.io.File;

import java.io.FileInputStream
;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Test_base {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	   
	
	@BeforeClass(groups= {"Sanity","Functional","Regression","UI","EndToEnd","Smoke","Security"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException {
	
		//Loading config.properties file
		FileInputStream file = new FileInputStream("./src//test//resources//config.properties");
		p= new Properties();
		p.load(file);		
		
		
		logger = LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase()) {
		case "chrome" : driver = new ChromeDriver(); break;
		case "firefox" : driver = new FirefoxDriver(); break;
		default: System.out.println("Invalid browser name..."); return;
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(p.getProperty("appURL"));  //reading url from properties file
		
	}     
	  
	public String randomString() {
		String generated_string = RandomStringUtils.randomAlphabetic(6);
		return(generated_string);
	}
	public String randomNumeric() {
		String generated_numeric = RandomStringUtils.randomNumeric(10);
		return(generated_numeric);
	}
	public String randomAlphaNumeric() {
		String generated_alphanumeric = RandomStringUtils.randomAlphanumeric(15);
		return(generated_alphanumeric);
	}
	
	//public String captureScreen(String tname) {
		
		//String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		//TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		//File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		//String targetFilePath = System.getProperty("user.dir")+"\\screenshot\\"+tname+"_"+timestamp+".png";
		//File targetFile = new File(targetFilePath);
		
		//try {
	       // org.openqa.selenium.io.FileHandler.copy(sourceFile, targetFile);
	       // return targetFilePath;
	    //} catch (IOException e) {
	       // e.printStackTrace();
	       // return null;
	   // }
	//}
	public String captureScreen(String tname) {
	    String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	    String screenshotDir = System.getProperty("user.dir") + File.separator + "screenshots";
	    File dir = new File(screenshotDir);
	    if (!dir.exists()) dir.mkdirs(); // Ensure directory exists

	    String screenshotPath = screenshotDir + File.separator + tname + "_" + timestamp + ".png";

	    try {
	        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        File targetFile = new File(screenshotPath);
	        org.openqa.selenium.io.FileHandler.copy(sourceFile, targetFile);
	        return screenshotPath;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	@AfterClass(groups= {"Sanity","Functional","Regression","UI","EndToEnd","Smoke","Security"})
	public void tearDown() {
		driver.quit();
	}
}
