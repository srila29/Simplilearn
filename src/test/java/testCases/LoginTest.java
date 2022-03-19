package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginTest extends BaseClass {
	

	
	@Test(enabled=true)
		public void LoginFailureTest() throws InterruptedException
	{
		//test=report.startTest("LoginFailureTest");  Commenting this here because the same command is added in before method
		LoginPage loginPage=new LoginPage();
		loginPage.LoginDetails("zyx@gmail.com","Abc@12345");
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("msg_box")));	
		WebElement ErrorMsg=driver.findElement(By.id("msg_box")); //Object to find the error element on the webpage
		String ActualMsg=ErrorMsg.getText(); //Error message text is fetched in a string variable
		String ExpMsg="The email or password you have entered is invalid.";
		Assert.assertEquals(ActualMsg, ExpMsg);	
		//report.endTest(test); // Added in aftermethod
	}
	@Test(enabled=true)
	public void LoginSuccessTest()
	{
		LoginPage loginPage=new LoginPage();
		loginPage.LoginDetails("srilakshmicompsci2021@gmail.com","Simply@123");
	
		WebDriverWait wait=new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='program-detail__course custom-program-detail__course-theme']")));
		WebElement DispMsg = driver.findElement(By.xpath("//div[@class='program-detail__course custom-program-detail__course-theme']"));

		String ActualMsg=DispMsg.getText(); 
		String ExpMsg="Automation Testing Masters Program";
		Assert.assertEquals(ActualMsg, ExpMsg);	
	
	}
	
	@Test(enabled=true)
	@Parameters({"param1","param2"})
	public void ParametirezedTest(String UserNameVal,String PasswordVal)
	{
		LoginPage loginPage=new LoginPage();
		loginPage.LoginDetails(UserNameVal,PasswordVal);
	}
	
	@Test(enabled=false)
	public void ExternalSheetDataTest()
	{
		String UName=sheet.getRow(1).getCell(0).getStringCellValue();
		String PWord=sheet.getRow(1).getCell(1).getStringCellValue();
		LoginPage loginPage=new LoginPage();
		loginPage.LoginDetails(UName,PWord);
	}
	

}
