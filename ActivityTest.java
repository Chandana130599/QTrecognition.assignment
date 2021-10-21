package assignment.QTRecognition;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.Base;

public class ActivityTest extends Base{
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		 driver =initializeDriver();
		 driver.get("https://qtrecognition.testqtwiz.com/");
	}
	@Test
	public void ActivityPage(){
		
		
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys("chandana.rm@qualitestgroup.com");
		lp.getPassword().sendKeys("P@ssw0rd");
		lp.clickLogin().click();
		
		System.out.println(driver.findElement(By.xpath("(//h5[@class='header-font-size'])[1]")).isDisplayed());
		
		String s= driver.findElement(By.xpath("//img [@src='img\\\\avatar.svg']")).getAttribute("alt");
		System.out.println(s);
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();	
	}

}
