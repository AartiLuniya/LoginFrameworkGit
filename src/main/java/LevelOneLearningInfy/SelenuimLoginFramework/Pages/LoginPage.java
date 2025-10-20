package LevelOneLearningInfy.SelenuimLoginFramework.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;
	@FindBy(id="username")
	private WebElement usrname;
	
	@FindBy(id="password")
	private WebElement pwd;
	
	@FindBy(className="btn")
	private WebElement loginbutton;
	
	@FindBy(id="error")
	private WebElement error;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String username) {
		usrname.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		pwd.sendKeys(password);
	}
	
	public void clickSubmit() {
		loginbutton.click();
	}
	public String getErrorMessage() {
		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(error));
			return error.getText();
		}catch(Exception e) {
			return null;
		}
		
	}
	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickSubmit();
		
	}

	
	
}
