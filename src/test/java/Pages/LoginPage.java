package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testCases.BaseClass;

public class LoginPage {
	
//========================= Web elements========================
	
	WebDriver driver=BaseClass.driver;
	ExtentTest test=BaseClass.test;
	
	@FindBy(name="user_login")
	WebElement UserName;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(name="btn_login")
	WebElement LoginButton;
	@FindBy(className="rememberMe")
	WebElement RemMe;
	@FindBy(linkText="Log in")
	WebElement LoginLink;
	
//===== Initelement method using constructor from Page factory class to use FindBy method==============
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
// ======================== Functions=============================================
	
	public void LoginDetails(String UserNameVal,String PasswordValue)
	{
		
		//--------------- Web elements replaced by Pagefactory @FindBy method---------
		/* Removed as @FindBy annotations are used above
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));//Find the login link using linktext
		WebElement UserName=driver.findElement(By.name("user_login")); // Object to find username textbox
		WebElement Password=driver.findElement(By.id("password")); // Object to find password textbox
		WebElement LoginButton= driver.findElement(By.name("btn_login")); //Object to find the login button
		WebElement RemMe= driver.findElement(By.className("rememberMe")); //Object to find the Remember Me check box*/
		
		//Login opertaions
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(LoginLink));	
		LoginLink.click();//Click on the login link	
		test.log(LogStatus.PASS,"Click on the login link","Login link clicked successfully");
		UserName.sendKeys(UserNameVal); //Enter test value for username
		test.log(LogStatus.PASS,"Enter test value for username","Name entered successfully");
		Password.sendKeys(PasswordValue); //Enter test password
		test.log(LogStatus.PASS,"Enter the test value for password","Password entered successfully");
		RemMe.click(); //TO Enable REmember me
		test.log(LogStatus.PASS,"Enable Remember me check box","Rem me enabled successfully");
		LoginButton.click(); // To click on Login button
		test.log(LogStatus.PASS,"Click on the login button","Login button clicked successfully");
	}
	
public void UICheck() {
		
		Assert.assertTrue(UserName.isDisplayed());
	}

}
