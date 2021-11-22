package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
public WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://joyjo4693.atlassian.net/wiki']")
	private WebElement confluence;
	
	public HomePage confluenceAccess() {
		confluence.click();
		HomePage homePage = new HomePage(driver);
		return homePage;
	}

}
