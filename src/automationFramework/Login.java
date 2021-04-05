package automationFramework;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {	
	static WebDriver driver;
	static String baseurl ="https://internshala.com/";
	static String path="F:\\Test Automation\\chromedriver.exe";
	public static void main(String[] args) throws InterruptedException, IOException { 		
		FileInputStream fis = new FileInputStream("C:\\Users\\anumo\\OneDrive\\Desktop\\UPES\\6th Sem\\Test Automation\\Lab\\Login_Data_Project.xlsx");
		XSSFWorkbook wbook = new XSSFWorkbook(fis);
		XSSFSheet loginsheet = wbook.getSheet("Login");
		for (int i=1; i<3; i++) {		
			XSSFRow row = loginsheet.getRow(i);
			String username;
			if((row.getCell(0).getCellType()) == CellType.NUMERIC) {
			username = row.getCell(0).getRawValue();				
			}
			else {
				username = row.getCell(0).toString();
				}
			String pass = row.getCell(1).toString();
			System.out.println("Name: "+ username + "Password: "+ pass );
			RunTest(username,pass);
		}
		
}
	
	public static void RunTest(String username , String pass)  {  
		System.setProperty("webdriver.chrome.driver", path);
		driver=new ChromeDriver();  
		driver.get(baseurl);  
		
		WebElement hellosignin = driver.findElement(By.xpath("/html/body/div/div[17]/div/nav/div[3]/ul/li[4]/button"));
		  hellosignin.click();
		  WebElement emailid = driver.findElement(By.id("modal_email"));
		  emailid.sendKeys(username);
		 WebElement password = driver.findElement(By.id("modal_password"));
		  password.sendKeys(pass);
		  WebElement continuebtn = driver.findElement(By.id("modal_password"));
		  continuebtn.click();
		  WebElement signin = driver.findElement(By.id("modal_login_submit"));
		  signin.click();
		  driver.close();
 }  
}