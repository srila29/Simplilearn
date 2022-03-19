package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class HomeTest extends BaseClass {
	
	@Test()
	public void HomeTestCase()
	{
	
		
		WebElement Explore = driver.findElement(By.xpath("//a[@class='btn']"));
		String ExploreMsg=Explore.getText();
		String SampleMsg="Explore Programs";
		Assert.assertEquals(ExploreMsg, SampleMsg);
		
		
			}
	
	
	}

