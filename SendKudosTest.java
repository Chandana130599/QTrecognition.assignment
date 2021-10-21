package assignment.QTRecognition;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ActivityPage;
import pageObjects.LoginPage;
import pageObjects.SendKudosPage;
import resources.Base;

public class SendKudosTest extends Base {
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		 driver =initializeDriver();
		 driver.get("https://qtrecognition.testqtwiz.com/");
	}
	
	@Test
	public void sendKudos(){
		
		
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys("chandana.rm@qualitestgroup.com");
		lp.getPassword().sendKeys("P@ssw0rd");
		lp.clickLogin().click();
		
		ActivityPage aP = new ActivityPage(driver);
		aP.clickSendkudos().click();
		SendKudosPage kudos = new SendKudosPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		kudos.getEmailInKudosSearch().sendKeys("Ashwini M Koppad (ashwini.koppad@qualitestgroup.com)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		kudos.getWriteAppreciationMsg().click();
		kudos.getComment().sendKeys("Goood work");;
		kudos.getSendButton().click();
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();	
	}

}
