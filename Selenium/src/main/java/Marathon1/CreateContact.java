package Marathon1;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); 
		
        //disable notifications
        ChromeOptions ch=new ChromeOptions();
        ch.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(ch);
		driver.get("https://login.salesforce.com/?locale=in");
	
	
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
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(3000);
		
		//Click on Account tab 
		driver.findElement(By.xpath("//a[@title='Accounts']/parent::one-app-nav-bar-item-root")).click();
		
		//Click on New button
		driver.findElement(By.xpath("//a[@title='New']")).click();
		
		//Enter 'your name' as account name
		driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow']//input")).sendKeys("Mythili");

		Thread.sleep(3000);
		
		//Select Ownership as Public
		driver.findElement(By.xpath("(//div[@role='none']//button)[3]")).click();
		driver.findElement(By.xpath("(//button[@role='combobox'])[3]")).click();		
		Thread.sleep(3000);
	

		
		
		//click save
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
	}

}
