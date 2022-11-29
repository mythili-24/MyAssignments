package week5.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev135603.service-now.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//2. Login with valid credential 
		driver.findElement(By.id("user_name")).sendKeys("admin");		
		driver.findElement(By.id("user_password")).sendKeys("Aa123456");
		
		driver.findElement(By.id("sysverb_login")).click();
		
		//	//3. Click-All and Enter Callers in filter navigator and press enter 
		
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(5);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.findElement("#filter").sendKeys("callers");
		shadow.findElementByXPath("//mark[@class='filter-match']").click();
		
		//4. Create new Caller by filling all the fields and click 'Submit'.
		
		WebElement clicknew = shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(clicknew);
		
		driver.findElement(By.xpath("//button[text()='New']")).click();
		String firstName = "Mythili";
		driver.findElement(By.xpath("//div[@class='hidden']/following-sibling::input")).sendKeys(firstName);
		driver.findElement(By.id("sys_user.last_name")).sendKeys("Sabarish");
	    driver.findElement(By.xpath("//input[@id='sys_user.title']")).sendKeys("Junior Developer");
	    driver.findElement(By.xpath("//input[@id='sys_user.email']")).sendKeys("abcd@gmail.com");
	    driver.findElement(By.xpath("//input[@id='sys_user.phone']")).sendKeys("123456789");
	    driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']")).sendKeys("7373747461");
		driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();
		
		//5. Search and verify the newly created Caller"
		 String search = driver.findElement(By.xpath("//div[@class='outputmsg_text']")).getText();
		 System.out.println(search);
		
		if(search.contains(firstName)) {
			System.out.println("new caller has been creared");
		}
		else {
			System.out.println("no caller");
		}
		
	

	}

}
