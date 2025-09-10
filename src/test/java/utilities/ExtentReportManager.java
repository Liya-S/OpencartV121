package utilities;

//import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.Test_base;

//import pageObjects.BaseClass;
//import testCases.Test_base;


	public class ExtentReportManager implements ITestListener {

	    private ExtentSparkReporter extentSparkReporter;
	    private ExtentReports extentReports;
	    private ExtentTest extentTest;

	    private String repName;

	    // ✅ Called automatically at start of suite
	    @Override
	    public void onStart(ITestContext context) {
	        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	        repName = "Test-Report-" + timeStamp + ".html";
	        extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/" + repName);

	        extentSparkReporter.config().setDocumentTitle("Opencart Automation Report");
	        extentSparkReporter.config().setReportName("Test Report");
	        extentSparkReporter.config().setTheme(Theme.DARK);

	        extentReports = new ExtentReports();
	        extentReports.attachReporter(extentSparkReporter);

	        extentReports.setSystemInfo("Application", "opencart");
	        extentReports.setSystemInfo("Module", "admin");
	        extentReports.setSystemInfo("Sub module", "Customers");
	        extentReports.setSystemInfo("User Name", System.getProperty("user.name"));
	        extentReports.setSystemInfo("Environment", "QA");

	        String os = context.getCurrentXmlTest().getParameter("os");
	        if (os != null) extentReports.setSystemInfo("Operating System", os);

	        String browser = context.getCurrentXmlTest().getParameter("browser");
	        if (browser != null) extentReports.setSystemInfo("Browser", browser);

	        List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
	        if (!includedGroups.isEmpty()) {
	            extentReports.setSystemInfo("Groups", includedGroups.toString());
	        }
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        extentTest = extentReports.createTest(result.getMethod().getMethodName());
	        extentTest.assignCategory(result.getMethod().getGroups());
	        extentTest.log(Status.PASS, result.getName() + " PASSED");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        extentTest = extentReports.createTest(result.getMethod().getMethodName());
	        extentTest.assignCategory(result.getMethod().getGroups());
	        extentTest.log(Status.FAIL, result.getName() + " FAILED");
	        extentTest.log(Status.INFO, result.getThrowable().getMessage());

	        String imgPath = new Test_base().captureScreen(result.getName());
	        try {
	            extentTest.addScreenCaptureFromPath(imgPath);
	        } catch (Exception e) {
	            extentTest.log(Status.WARNING, "Screenshot could not be attached: " + e.getMessage());
	        }
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        extentTest = extentReports.createTest(result.getMethod().getMethodName());
	        extentTest.assignCategory(result.getMethod().getGroups());
	        extentTest.log(Status.SKIP, result.getName() + " SKIPPED");
	        extentTest.log(Status.INFO, result.getThrowable() != null ? result.getThrowable().getMessage() : "No skip reason");
	    }

	    // ✅ Correct signature
	    @Override
	    public void onFinish(ITestContext context) {
	        extentReports.flush();
	    }
	}

   