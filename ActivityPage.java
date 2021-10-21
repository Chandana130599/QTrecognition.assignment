package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActivityPage {
public WebDriver driver;
	
	By sendKudos = By.xpath("//a[@class=\"nav-item nav-link\"]");
	By kudosSearch = By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[5]/div/h5/a/span");
	By kudosFromMe = By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[3]/div/h5/a/span");
	By kudosToMe = By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[4]/div/h5/a/span");
	By activity = By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[2]/div/h5/a/span");
	By recentKudos = By.xpath("//*[@id=\"contact_list\"]/div/div/h5/small/a");
	
	public ActivityPage(WebDriver driver) {	
		this.driver=driver;
	}
	public WebElement clickSendkudos() {
		return driver.findElement(sendKudos);
	}
	public WebElement clickKudosSearch() {
		return driver.findElement(kudosSearch);
	}
	public WebElement clickRecentKudos() {
		return driver.findElement(recentKudos);
	}
	
}

