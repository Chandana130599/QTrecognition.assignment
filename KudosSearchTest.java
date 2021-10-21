package assignment.QTRecognition;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ActivityPage;
import pageObjects.KudosSearchPage;
import pageObjects.LoginPage;
import resources.Base;

	public class KudosSearchTest extends Base {
		public WebDriver driver;
		@BeforeTest
		public void initialize() throws IOException
		{
			 driver =initializeDriver();
			 driver.get("https://qtrecognition.testqtwiz.com/");
		}
		@Test
		public void sendKudos() throws InterruptedException{
			
			
			LoginPage lp = new LoginPage(driver);
			lp.getUsername().sendKeys("chandana.rm@qualitestgroup.com");
			lp.getPassword().sendKeys("P@ssw0rd");
			lp.clickLogin().click();
			
			ActivityPage aP = new ActivityPage(driver);
			aP.clickKudosSearch().click();
			Thread.sleep(3000);
			KudosSearchPage ksp = new KudosSearchPage(driver);
			ksp.getEmail().sendKeys("Ashwini M Koppad (ashwini.koppad@qualitestgroup.com)");
			Thread.sleep(3000);
			ksp.ClickSearch().click();
		}
		
		@AfterTest
		public void teardown()
		{
			driver.close();	
		}

}


