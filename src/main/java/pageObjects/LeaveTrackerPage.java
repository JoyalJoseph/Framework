package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeaveTrackerPage {
	public WebDriver driver;
	
	public LeaveTrackerPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="span[data-testid='restriction-button']")
	private WebElement restrictionCntrl;
	
	public RestrictionsPage seeRestrictions() {
		restrictionCntrl.click();
		RestrictionsPage restrictionsPage = new RestrictionsPage(driver);
		return restrictionsPage;
	}

}
