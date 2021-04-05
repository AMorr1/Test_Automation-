package automationFramework;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Jenkins {
	public static WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public class Main {
		WebDriver driver;
		String path="F:\\Test Automation\\chromedriver.exe";
		
	@BeforeTest
	  public void beforeTest() {
		  System.setProperty("webdriver.chrome.driver",path);
		  driver=new ChromeDriver(); 
		  driver.navigate().to("https://internshala.com/"); 
	  }

	  @Test(priority=1)
	  public void login() {

		  WebElement hellosignin = driver.findElement(By.xpath("/html/body/div/div[17]/div/nav/div[3]/ul/li[4]/button"));
		  hellosignin.click();
		  WebElement emailid = driver.findElement(By.id("modal_email"));
		  emailid.sendKeys("anumor23456789@gmail.com");
		 WebElement password = driver.findElement(By.id("modal_password"));
		  password.sendKeys("anurag@123");
		  WebElement continuebtn = driver.findElement(By.id("modal_password"));
		  continuebtn.click();
		  WebElement signin = driver.findElement(By.id("modal_login_submit"));
		  signin.click();
	  
	  }

	@Test(dataProvider = "dataprovider", priority=2)
	public void contact_us(String contact_element) throws InterruptedException {
	driver.navigate().to("https://internshala.com/contact");
	WebElement contact = driver.findElement(By.cssSelector(contact_element));
	    contact.click();    
	}

	@Test(dataProvider = "dataprovider", priority=3)
	public void close_tabs(String contact_element) {
		//Get the list of window handles
	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    driver.close();
	    driver.switchTo().window(tabs2.get(0));
	   
	}
	@DataProvider(name = "dataprovider")
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { "#social_media_container > a:nth-child(1) > i" },      //css-selector values
	      new Object[] { "#social_media_container > a:nth-child(2) > i"},
	      new Object[] { "#social_media_container > a:nth-child(3) > i"},
	      new Object[] { "#social_media_container > a:nth-child(4) > i"},
	     
	    };
	  }
	}

}
