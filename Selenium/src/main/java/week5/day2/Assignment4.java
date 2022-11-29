package week5.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev135603.service-now.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//2. Login with valid credentials username as admin and password as Aa123456
		
		driver.findElement(By.id("user_name")).sendKeys("admin");		
		driver.findElement(By.id("user_password")).sendKeys("Aa123456");
		
		driver.findElement(By.id("sysverb_login")).click();
		
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//div[text()='All']").click();
		
		//3. Enter Knowledge  in filter navigator and press enter
		shadow.findElementByXPath("//input[contains(@class,'navigation-filter keyboard')]").sendKeys("knowledge");
		shadow.findElementByXPath("//mark[@class='filter-match']").click();
		
		//4. Create new Article 
		//driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		//5.Select knowledge base as IT and category as IT- java and Click Ok
		driver.switchTo().frame("AC.kb_knowledge.kb_knowledge_base_shim");
		driver.findElement(By.xpath("//span[@class='input-group-btn']")).click();
		
		
		
	}

}
