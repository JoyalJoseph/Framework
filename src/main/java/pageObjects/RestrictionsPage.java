package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RestrictionsPage {
	
public WebDriver driver;
	
	public RestrictionsPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//div[@data-test-id='restrictions-dialog.content-mode-select']")
	private WebElement dropDown;
	
	@FindBy(xpath="//div[@data-test-id='inspect-perms-entry-button']")
	private WebElement inspectPermissions;
	
	@FindBy(css="h1.css-47j8m2.ej72whz1")
	private WebElement title;
	
	@FindBy(css="div.css-1vejnri.e3nhwts2")
	private WebElement searchUser;
	
	@FindBy(css="button.e3nhwts5.css-1hkbxjq")
	private WebElement addBtn;
	
	@FindBy(css="button.css-a3rhjk")
	private WebElement removeBtn;
	
	@FindBy(css="button.css-ypvsuv")  
	private WebElement applyBtn;
	
	@FindBy(css="button.css-p02cbl")  
	private WebElement cancelBtn;
	
	@FindBy(css="button.css-1rss6dl")  
	private WebElement learnMoreBtn;
	
	//List<WebElement> userList = driver.findElements(By.cssSelector("tr.css-v3yuj6"));
			

	public String getTitle() {
		return title.getText();
	}
	
	public void clickSearch() {
		searchUser.click();
	}
	
	
		
	
}
