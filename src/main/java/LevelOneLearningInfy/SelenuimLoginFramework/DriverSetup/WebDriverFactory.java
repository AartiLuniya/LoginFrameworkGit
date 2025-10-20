package LevelOneLearningInfy.SelenuimLoginFramework.DriverSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
public static WebDriver getDriver(String browser) {
	WebDriver driver=null;
	
	if(browser==null) {
		browser="chrome";
	}
	switch(browser.toLowerCase()) {
	
	case "chrome" :
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
	
	case "edge":
		//System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		break;
		
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
		
	default:
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
			
	}	
	driver.manage().window().maximize();
	return driver;
	
}
}
