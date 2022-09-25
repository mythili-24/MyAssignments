package week.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
	    driver.findElement(By.className("decorativeSubmit")).click();
		String text=driver.findElement(By.tagName("h2")).getText();
		driver.findElement(By.id("label")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
		//Click on Phone
		driver.findElement(By.xpath("(//span[@class='x-tab-strip-inner']/span)[2]")).click();
         //Enter phone number
		driver.findElement(By.name("phoneCountryCode")).sendKeys("");
		driver.findElement(By.name("phoneAreaCode")).sendKeys("");
		driver.findElement(By.name("phoneNumber")).sendKeys("7373747479");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//Click First Resulting lead
	
			Thread.sleep(3000);
			String leadID = driver.findElement(By.xpath("//td[contains(@class,'x-grid3-col x-grid3-cell')]//div")).getText();
			System.out.println(leadID);

		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();	
		driver.findElement(By.linkText("Delete")).click();
		
		//Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		//enter captured lead ID
		driver.findElement(By.name("id")).sendKeys(leadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		String message = driver.findElement(By.className("x-paging-info")).getText();
        System.out.println(message);
        driver.close();
		
		
		
		
		
		
		
		//Click Delete
		
	}

}
