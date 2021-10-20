package assignment.QTRecognition;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.ActivityPage;
import pageObject.LoginPage;
import pageObject.SendKudosPage;
import resources.Base;

public class SendKudos extends Base {
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		 driver =initializeDriver();
	}
	@SuppressWarnings("deprecation")
	@Test
	public void sendKudos(){
		
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys("chandana.rm@qualitestgroup.com");
		lp.getPassword().sendKeys("P@ssw0rd");
		lp.clickLogin().click();
		
		ActivityPage aP = new ActivityPage(driver);
		aP.clickSendkudos().click();
		SendKudosPage kudos = new SendKudosPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		kudos.getEmailInKudosSearch().sendKeys("ashwini.koppad@qualitestgroup.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(Keys.ARROW_DOWN,Keys.RETURN);
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(Keys.ENTER,Keys.RETURN);
		
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