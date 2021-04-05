package automationFramework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;
import java.lang.reflect.Method;
public class ExtentReport {
	static ExtentTest test;
	static ExtentReports report;
	
	@BeforeClass
	public void initializeReport() {
		report= new ExtentReports("C:\\Users\\anumo\\OneDrive\\Desktop\\UPES\\6th Sem\\Test Automation\\Lab\\Projectreport.html",true);
	}
	
	WebDriver driver;
	String path="F:\\Test Automation\\chromedriver.exe";
	
@BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver",path);
	  driver=new ChromeDriver(); 
	  driver.navigate().to("https://internshala.com/"); 
  }
	
@BeforeMethod
public static void startReport(Method result) {
	  test = report.startTest("ExtentDemo - " + result.getName());
}
  @Test(priority = 0)
  public void Clicksignin() {  
 		WebElement hellosignin = driver.findElement(By.xpath("/html/body/div/div[17]/div/nav/div[3]/ul/li[4]/button"));
		  hellosignin.click();
		  test.log(LogStatus.INFO, "Starting with login");
	      if(driver.findElement(By.xpath("/html/body/div/div[17]/div/nav/div[3]/ul/li[4]/button")) != null) {
	        test.log(LogStatus.PASS, "Email BUtton located");
	      }
	      else
	          test.log(LogStatus.FAIL, "Email could not be located");
	  }
  @Test(priority = 1)
  public void Email () {
		  WebElement emailid = driver.findElement(By.id("modal_email"));
		  test.log(LogStatus.INFO, "Entering E-mail ID ");
		  if(driver.findElement(By.id("modal_email")) != null) {
		    test.log(LogStatus.PASS, "Email text field located");
		  }
		  else
		      test.log(LogStatus.FAIL, "Email text field could not be located");
		  emailid.sendKeys("anumor23456789@gmail.com");
		  }
  @Test(priority=2)
  public void Password() {
	  WebElement password = driver.findElement(By.id("modal_password"));
  test.log(LogStatus.INFO, "Entering Password ");
  if(driver.findElement(By.id("modal_password")) != null) {
    test.log(LogStatus.PASS, "Password text field located");
  }
  else
      test.log(LogStatus.FAIL, "Password text field could not be located");
  password.sendKeys("anuragmor");
  }
		 
  @Test(priority=3)
  public void ContinueButton() {
	  WebElement continuebtn = driver.findElement(By.id("modal_password"));
  test.log(LogStatus.INFO, "Continuing to Enter Password ");
  if(driver.findElement(By.id("modal_password")) != null) {
    test.log(LogStatus.PASS, "Email text field located");
  }
  else
      test.log(LogStatus.FAIL, "Email text field could not be located");
  continuebtn.click();
  }	
  
  @Test(priority=4)
  public void signin() {
	  WebElement signin = driver.findElement(By.id("modal_login_submit"));
  test.log(LogStatus.INFO, "Clicking Sign In button ");
  if(driver.findElement(By.id("modal_login_submit")) != null) {
    test.log(LogStatus.PASS, "Sign In button located");
  }
  else
      test.log(LogStatus.FAIL, "Sign in button could not be located");
  signin.click();
  } 

  @AfterClass
  public static void endTest()
  {
  report.endTest(test);
  report.flush();
  }
}
