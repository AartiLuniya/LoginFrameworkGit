package LevelOneLearningInfy.SelenuimLoginFramework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LevelOneLearningInfy.SelenuimLoginFramework.DriverSetup.WebDriverFactory;
import LevelOneLearningInfy.SelenuimLoginFramework.Pages.LoginPage;
import utils.ConfigReader;

import java.time.Duration;

public class LoginTest {
private WebDriver driver;
private LoginPage lp;
private ConfigReader conf;
	
@BeforeMethod
public void setup() {
	//initialize config reader
	conf=new ConfigReader();
	
	//get browser,url,wait from config file
	String browserName=System.getProperty("browser")!=null? System.getProperty("browser"):conf.getProperty("browser");
	//String browser=conf.getProperty("browser");
	String url=conf.getProperty("baseUrl");
	int implicitWait=Integer.parseInt(conf.getProperty("implicitWait"));
	
	driver = WebDriverFactory.getDriver(browserName);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
	driver.get(url);
	lp=new LoginPage(driver); 
}

@Test
public void testValidLogin() {
	lp.login("student","Password123");
	System.out.println("Login successful test executed.");
}

@Test
public void testInvalidLogin() {
	lp.login("student", "abc");
	System.out.println("Error message: " + lp.getErrorMessage());
}
@AfterMethod
public void tearDown() {
	driver.quit();
}


}
