package testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class BaseClass {
	public static WebDriver driver ;
    XSSFWorkbook wbook;
    XSSFSheet sheet;
    
    public static ExtentReports report;
    public static ExtentTest test;
    
    
    @BeforeTest
    public void DataSetup() throws IOException
    {
    	FileInputStream file=new FileInputStream("ExcelFile.xlsx");
    	wbook =new XSSFWorkbook(file);
    	sheet= wbook.getSheet("Sheet1");
    	
    	report=new ExtentReports("ExtentReport.html");
    	
    }
    
    @AfterTest
    public void DataTeardown() throws IOException
    {
    	wbook.close();
    	report.flush();
    	report.close();
    }
    
	@BeforeMethod
	public void SetUp(Method method)
	{
		test=report.startTest(method.getName());
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");//Register the driver - step 1 - Chrome browser

		 driver=new ChromeDriver();
		driver.get("https://www.simplilearn.com/");// Open the website with the link - step 3
		
		driver.manage().window().maximize();//Maximise the chrome window
	//	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); // if network is slow, the screen will wait for 5 sec

	}
	@AfterMethod
	public void TearDown()
	{
		report.endTest(test);
		driver.quit(); //Closing the driver object to close the chrome
	}

}
