package NewProject.Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClassforTest {
	
	 ChromeDriver driver;

	@BeforeTest
	public void openBrowser() {
		
		String chromePath=System.getProperty("user.dir")+"\\Resources\\chromedriver.exe";
		String path = "https://www.google.com";
		System.setProperty("webdriver.chrome.driver",chromePath);
		driver=new ChromeDriver();
		driver.get(path);
	}

	@Test	
	public void search() throws InterruptedException {
		String SearchKey="Selenium Webdriver";
		driver.findElement(By.name("q")).sendKeys(SearchKey);
		Thread.sleep(3000);
	}

	@Test	
	public void assertText() {

		String ExpectedTitle="selenium webdriver";
		List <WebElement > list= driver.findElements(By.className("eIPGRd"));
		String ActualTitle=list.get(0).getText();

		Assert.assertEquals(ActualTitle, ExpectedTitle);	
	}

	@AfterTest
	public void closeBrowser() {

		driver.close();
	}

}

