package week.day2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.messages.types.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;


public class FindLead {

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
		System.out.println(text);
		String title=driver.getTitle();
		System.out.println(title);
		driver.findElement(By.id("label")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.name("id")).sendKeys("10024");
		driver.findElement(By.id("ext-gen248")).sendKeys("mythili");
		driver.findElement(By.id("ext-gen250")).sendKeys("sabarish");
		driver.findElement(By.id("ext-gen252")).sendKeys("Test Leaf Pvt Ltd");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//driver.close();


	}

}
