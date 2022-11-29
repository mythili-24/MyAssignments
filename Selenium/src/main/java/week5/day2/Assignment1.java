package week5.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev144595.service-now.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//2. Login with valid credentials username as admin and password as Aa123456
		
		driver.findElement(By.id("user_name")).sendKeys("admin");		
		driver.findElement(By.id("user_password")).sendKeys("Aa123456");
		
		driver.findElement(By.id("sysverb_login")).click();
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.findElementByXPath("//span[text()='Service Catalog']").click();
		/* To Locate frame inside Shadow DOM  by XPath and save as WebElement*/
	WebElement eleFrame= shadow.findElementByXPath(("//iframe[@id='gsft_main']"));
		
		/* switch to the frame */
		driver.switchTo().frame(eleFrame);
		/* Element for Mobiles catalog is visible in DOM 
		 * Not necessary to use shadow object to locate the same
		 */
		driver.findElement(By.linkText("Mobiles")).click();

	}

}
