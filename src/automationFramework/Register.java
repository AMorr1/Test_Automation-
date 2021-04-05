package automationFramework;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Register {
	WebDriver driver;
	String path="F:\\Test Automation\\chromedriver.exe";
	
@BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver",path);
	  driver=new ChromeDriver(); 
	  driver.navigate().to("https://internshala.com/"); 
  }
	
  @Test(priority = 0)
  public void f() {
	  WebElement hellosignin = driver.findElement(By.xpath("/html/body/div/div[17]/div/nav/div[3]/ul/li[5]/button"));
	  hellosignin.click();
  }
 @Test(priority = 1)
  public void f1() {
	  WebElement stu = driver.findElement(By.xpath("/html/body/div/div[17]/div/nav/div[3]/ul/li[5]/div/div/div/div/ul/li[1]/a"));
	  stu.click();
  }
  @Test(priority = 2)
  public void f2() {
	  WebElement label1= driver.findElement(By.xpath("/html/body/div/div[18]/div/div/div/div[2]/div/form/div[1]/label[1]"));
	  String actual = label1.getText();
	  System.out.print(actual);
	  String expected="Email";
	  Assert.assertEquals(actual, expected);
	  WebElement name = driver.findElement(By.id("email"));
	  name.sendKeys("anumor23456789@gmail.com");

  }
  
  @Test(priority = 3)
  public void f4() {
	  WebElement pss = driver.findElement(By.id("password"));
	  assertTrue(pss.isEnabled());
	  pss.sendKeys("anurag@123");
  }
  @Test(priority = 4)
  public void f5() {
	  WebElement fname = driver.findElement(By.id("first_name"));
	  assertTrue(fname.isDisplayed());
	  fname.sendKeys("Anurag");
  }
  @Test(priority = 5)
  public void f6() {
	  WebElement lname = driver.findElement(By.id("last_name"));
	  assertTrue(lname.isDisplayed());
	  lname.sendKeys("Mor");
  }
  @Test(priority = 6)
  public void f7() {
	  WebElement btn = driver.findElement(By.xpath("/html/body/div/div[18]/div/div/div/div[2]/div/form/button"));
	  assertTrue(btn.isDisplayed());
	  btn.click();
  }
  
  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}