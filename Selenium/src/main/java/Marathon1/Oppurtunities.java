package Marathon1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Oppurtunities {
	public static WebElement WebElement;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/?locale=in");
		
        //disable notifications
        ChromeOptions ch=new ChromeOptions();
        ch.addArguments("--disable-notifications");
        ChromeDriver drive=new ChromeDriver(ch);
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(8000);
		//Click on toggle menu button from the left corner
		driver.findElement(By.className("slds-r5")).click();
		//Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//div[@class='slds-size_medium']//lightning-button")).click();
		Thread.sleep(8000);
		

		driver.findElement(By.xpath("(//div[@data-name='Sales']//div)[2]")).click();
		Thread.sleep(3000);
		//Click on Opportunity tab 
		driver.findElement(By.xpath("//span[text()='Opportunities']")).click();
}
}