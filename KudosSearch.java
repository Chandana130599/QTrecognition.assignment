package assignment.QTRecognition;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.ActivityPage;
import pageObject.KudosSearchPage;
import pageObject.LoginPage;
import resources.Base;

	public class KudosSearch extends Base {
		public WebDriver driver;
		@BeforeTest
		public void initialize() throws IOException
		{
			 driver =initializeDriver();
		}
		@Test
		public void sendKudos(){
			
			driver.get(prop.getProperty("url"));
			LoginPage lp = new LoginPage(driver);
			lp.getUsername().sendKeys("chandana.rm@qualitestgroup.com");
			lp.getPassword().sendKeys("P@ssw0rd");
			lp.clickLogin().click();
			
			ActivityPage aP = new ActivityPage(driver);
			aP.clickKudosSearch().click();
			
			KudosSearchPage ksp = new KudosSearchPage(driver);
			ksp.getEmail().sendKeys("anupam k");
			driver.findElement(By.xpath("//input[@id='s_e_add']")).sendKeys(Keys.ARROW_DOWN,Keys.RETURN);
			driver.findElement(By.xpath("//input[@id='s_e_add']")).sendKeys(Keys.ENTER,Keys.RETURN);
			
			ksp.ClickSearch().click();
		}
		
		@AfterTest
		public void teardown()
		{
			driver.close();	
		}

}
