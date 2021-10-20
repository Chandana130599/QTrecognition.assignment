package assignment.QTRecognition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.ActivityPage;
import pageObject.LoginPage;
import pageObject.SendKudosPage;
import resources.Base;

public class KudosRecent extends Base {
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		 driver =initializeDriver();
	}
	@Test
	public void SendKudos(){
		
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys("chandana.rm@qualitestgroup.com");
		lp.getPassword().sendKeys("P@ssw0rd");
		lp.clickLogin().click();
		
		ActivityPage aP=new ActivityPage(driver);
		aP.clickRecentKudos().click();
		
		SendKudosPage skp = new SendKudosPage(driver);
		skp.getWriteAppreciationMsg().click();
		skp.getComment().sendKeys("Good Work");
		skp.getSendButton().click();
	}
	@AfterTest
	public void teardown()
	{
		driver.close();	
	}

}