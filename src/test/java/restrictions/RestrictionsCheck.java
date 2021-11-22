package restrictions;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LeaveTrackerPage;
import pageObjects.LoginPage;
import pageObjects.RestrictionsPage;
import resources.Base;

public class RestrictionsCheck extends Base {
	RestrictionsPage restrictionsPage;
	
	private static Logger log = LogManager.getLogger(RestrictionsCheck.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("loginUrl"));
		
		
		
	}
	
	@Test(dataProvider="getData")
	public void restrictionsPageNavigation(String email, String pwd) throws IOException, InterruptedException
	{
		
		LoginPage loginPage = new LoginPage(driver);
		log.info("User Log In");
		BasePage basePage = loginPage.userLogin(email,pwd);
		
		Thread.sleep(7000);
		log.info("Opening the conluence");
		HomePage homePage = basePage.confluenceAccess();
		Thread.sleep(7000);
		log.debug("Searching for specific conluence page");
		homePage.searchForPage();
		Thread.sleep(3000);
		log.info("Selecting the conluence page");
		LeaveTrackerPage leaveTrackerPage = homePage.selectPage();
		Thread.sleep(8000);
		restrictionsPage = leaveTrackerPage.seeRestrictions();
		
		//Other Values we can use
		log.error("I'm error");
		log.debug("I'm debug");
		log.fatal("I'm fatal");
		
		//test
		System.out.println(restrictionsPage.getTitle());
		//Assert.assertTrue(false);	

    }
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[1][2];
		data[0][0] ="joyjo4693@gmail.com";
		data[0][1] ="Test1234$";
		
		return data;
		
	}
	
	
	 @Test(dependsOnMethods= {"restrictionsPageNavigation"}) public void
	  clickOnSearch() {
	  
	  restrictionsPage.clickSearch();
	  System.out.println("Reused the first test to click on search");
	  
	  }
	 
	
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	
	
}
