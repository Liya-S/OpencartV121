Project Overview
----------------
This project is an automation test suite built using Java, Selenium WebDriver and TestNG for OpenCart e-commerce website.
The purpose of this project is to validate key functionalities of the application, ensure robustness through data-driven testing and execute tests across multiple browsers using parallel execution.


Functionalities Tested
----------------------

The following functionalities of the OpenCart website have been automated:

 * User Registration – Validate new user registration process 
 * Login – Verify correct and incorrect login scenarios  
 * Logout – Verify logout scenarios 
 * Forgot Password – Ensure password recovery workflow works as expected  
 * Search – Validate search functionality with different inputs  
 * Product Display – Check product details and pages  
 * Add to Cart – Test adding products to the cart and managing it  

Project Structure
-----------------

/src/test/java/ - 
		# pageObjects ---> classes corresponding to various pages of the website
		# testCases   ---> classes corresponding to each functionality testing all positive and negative test cases 
		# utilities   ---> Data providers
				               Excel utility file
				               Extent report utility file
/src/test/resources - properties file
		                  log4j2.xml file

logs 
reports - extent reports
screenshots
grouping.xml - XML file for grouping tests
paralleltesting.xml -  XML file for parallel execution across browsers
run.bat
testng.xml - run all test cases together


Tools & Technologies Used
-------------------------

- Java – Programming language for implementing test scripts  
- Selenium WebDriver – Web automation tool  
- TestNG – Framework for test execution, grouping, and reporting  
- Data Driven Testing – Test data is managed via Excel files  
- Properties File – Configuration management for environment-specific data  
- Parallel Execution – Tests run concurrently on multiple browsers  
- TestNG XML Files – Separate configurations for parallel, grouped and full test execution  
- Maven  – For dependency management and builds


Prerequisites
-------------

Before running the tests, ensure you have the following installed:

- Java JDK 8 or higher  
- Eclipse IDE (or any Java IDE)  
- Selenium WebDriver dependencies  
- TestNG plugin for Eclipse  
- ChromeDriver, GeckoDriver or other browser drivers in the path  
- Apache POI libraries for Excel file reading (if applicable)



Setup Instructions
------------------


Open in Eclipse:

Import the project as a Maven project or as a standard Java project.

Add Test Data Files:

Place your properties files inside /resources/.

Configure Browser Drivers:

Ensure drivers like chromedriver.exe or geckodriver.exe are in your system’s PATH or set their path in the properties file.

Run Test Suites:

Right-click on paralleltesting.xml, grouping.xml, or testng.xml and choose “Run as TestNG Suite.”

How to Run Tests
----------------

>> Parallel Execution
Run tests on multiple browsers simultaneously using:- paralleltesting.xml

>> Grouping Tests
Run a specific set of tests grouped as sanity/smoke/functionality/regression/end to end/security using:-grouping.xml

>> Run All Tests
Execute the complete test suite:- testng.xml

>> Data Driven Testing
ddt_register.xlsx - Test cases are data-driven using Excel files 
Multiple test scenarios are handled with different datasets.

Configuration values like URLs, browser types are managed through the properties file.

Reports
-------

> click on reports
> click any report from dropdown
> click "download raw file"
> open the downloaded file
