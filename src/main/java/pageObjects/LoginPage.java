package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.*;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement userName;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement continueBtn;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login-submit")
	private WebElement loginBtn;
	
	
	public BasePage userLogin(String email, String pwd) {
		userName.sendKeys(email);
		continueBtn.click();
		password.sendKeys(pwd);
		loginBtn.click();
		BasePage basePage = new BasePage(driver);
		return basePage;
	}
	
	
}
