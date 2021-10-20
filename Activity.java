package assignment.QTRecognition;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import resources.Base;

public class Activity extends Base{
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		 driver =initializeDriver();
	}
	@Test
	public void ActivityPage(){
		
		driver.get(prop.getProperty("url"));
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