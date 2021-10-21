package assignment.QTRecognition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.Base;

public class LoginTest extends Base{
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{

		 driver =initializeDriver();
		 driver.get("https://qtrecognition.testqtwiz.com/");
	}
	
	@Test
	public void userLogin() {
		
//Checking Gold Color
		String colourGold = driver.findElement(By.xpath("//div[@class='myHeading']")).getCssValue("background-color");
		String c = Color.fromString(colourGold).asHex(); 
		System.out.println(c);
//Checking Navy Blue color
		String colourNavyBlue = driver.findElement(By.xpath("//button[@type='submit']")).getCssValue("background-color");
		String c1 = Color.fromString(colourNavyBlue).asHex(); 
		System.out.println(c1);
		
		LoginPage lp = new LoginPage(driver);
//Login with valid user credentials
		lp.getUsername().sendKeys("chandana.rm@qualitestgroup.com");
		lp.getPassword().sendKeys("P@ssw0rd");
		lp.clickLogin().click();
		assertEquals("QTRecognition", driver.getTitle());
		//System.out.println(driver.getTitle());
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();	
	}

}
