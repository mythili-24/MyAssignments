package week.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
	    driver.findElement(By.className("decorativeSubmit")).click();
		String text=driver.findElement(By.tagName("h2")).getText();
		driver.findElement(By.id("label")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
		//Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("mythili");
		//Click Find leads button
		driver.findElement(By.id("ext-gen334")).click();
		
		 //Click on first resulting lead 
		driver.findElement(By.linkText("Mythili")).click();
		 //Verify title of the page
		String title=driver.getTitle();
		//Click Edit
		driver.findElement(By.linkText("Edit")).click();
		//Change the company name
		
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("GE");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		//Close the browser (Do not log out)
		driver.close();
		
		
		

	}

}
