package automationFramework;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
public class Allcase {
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
 
@Test(priority=4)
public void goTointernships() throws InterruptedException {
 WebDriverWait wait1 = new WebDriverWait(driver,60);
 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("internships_new_superscript")));
 WebElement internships = driver.findElement(By.id("internships_new_superscript"));
    internships.click();

try{
    WebElement nothanks = driver.findElement(By.linkText("No, thanks"));
    nothanks.click();
    }
    catch(Exception e)
    {
   
    } 

}

@Test(priority=5)
public void selectCategory() throws InterruptedException {
    WebDriverWait wait3 = new WebDriverWait(driver,60);
    wait3.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#select_category_chosen > ul > li > input")));
    WebElement category = driver.findElement(By.cssSelector("#select_category_chosen > ul > li > input"));
    category.click();                                  
    category.sendKeys("Computer Science");
    category.sendKeys(Keys.ENTER);
}

@Test(priority=6)
public void searchAndApply() throws InterruptedException {
    WebDriverWait wait4 = new WebDriverWait(driver,120);
    
    driver.navigate().to("https://internshala.com/internship/details/web-development-internship-in-delhi-at-airpop-media1617291671");
    driver.navigate().to("https://internshala.com/internship/details/web-development-internship-in-delhi-at-airpop-media1617291671");
    WebElement element6 = driver.findElement(By.xpath("//*[@id=\"details_container\"]/div[3]/div[2]/div[15]/a/button"));
    element6.click();
  
       
        WebElement proceed = driver.findElement(By.xpath("//*[@id=\"application_button\"]/button"));
        proceed.click();
}
        @Test(priority=7)
        public void submit() throws InterruptedException {

         WebDriverWait wait4 = new WebDriverWait(driver,60);
            wait4.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cover_letter")));     
        WebElement cover_letter = driver.findElement(By.cssSelector("#cover_letter"));
        cover_letter.click();
        cover_letter.sendKeys("I am always ready to take challanges and learn new things.");
        WebElement text2 = driver.findElement(By.id("text_2094425"));
        text2.sendKeys("Yes,I am available"); 
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        submit.click();
    
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
