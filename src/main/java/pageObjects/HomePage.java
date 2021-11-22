package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@data-test-id='search-dialog-input']")
	private WebElement searchBox;
	
	
	@FindBy(css="a[href*='Leave+Tracker']")
	private WebElement pageName;
	
	
	public void searchForPage() {
		searchBox.sendKeys("Leave Tracker");
		searchBox.sendKeys(Keys.ENTER);
		
	}
	
	public LeaveTrackerPage selectPage() {
		pageName.click();
		LeaveTrackerPage leaveTrackerPage = new LeaveTrackerPage(driver);
		return leaveTrackerPage;
	}

}
