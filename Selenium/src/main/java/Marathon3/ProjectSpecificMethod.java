package Marathon3;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import week7.day1.ReadExcel;


public class ProjectSpecificMethod {
	ChromeDriver driver;//Global variable declaration
	String excelFile;
	String sheetName;
	@Parameters({"url","username","password"})//2 step
	@BeforeMethod
	public void setup(String URL, String UserName,String Password) throws InterruptedException//3
	{
		    WebDriverManager.chromedriver().setup(); 
		    ChromeOptions ch=new ChromeOptions();
	        ch.addArguments("--disable-notifications");
		    driver=new ChromeDriver(ch);
			driver.get(URL);
		
		
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
			driver.findElement(By.id("username")).sendKeys(UserName);
			driver.findElement(By.id("password")).sendKeys(Password);
			driver.findElement(By.id("Login")).click();
			Thread.sleep(8000);
			
			//Click on app launcher
			driver.findElement(By.className("slds-icon-waffle")).click();
			
			//04) Click View All
			driver.findElement(By.xpath("//div[@class='slds-size_medium']//lightning-button")).click();
			Thread.sleep(5000);
}
	@AfterMethod
public void tearDown() {
	driver.close();
}
	@DataProvider(name="fetchData")
	  public String[][] getData() throws IOException  {
		  String[][] readData = ReadExcel.readData(excelFile, sheetName);
		return readData;
}
}




