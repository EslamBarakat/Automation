package NewProject.Selenium;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class GooglePlay {
	
	ChromeDriver driver;
	

	@BeforeTest
		
	public void openPlayStore() {
		
		String chromePath=System.getProperty("user.dir")+"\\Resources\\chromedriver.exe";
		String path = "https://play.google.com/";
		System.setProperty("webdriver.chrome.driver",chromePath);
		driver=new ChromeDriver();
		driver.get(path);
	}
	
	@Test	
	public void assertTitle() {

		String ExpectedTitle="Google Play";
		
		String ActualTitle=driver.getTitle();

		Assert.assertEquals(ActualTitle, ExpectedTitle);	
		
		
	}
	@Test	
	public void assertApps() {

		String ExpectedText="Apps";
		List <WebElement > list= driver.findElements(By.className("pvVVcb"));
		String apps=list.get(1).getText();

		Assert.assertEquals(apps, ExpectedText);	
		
	}

	@AfterTest
	public void closeBrowser() {

		driver.close();
	}
	
	
	
}
