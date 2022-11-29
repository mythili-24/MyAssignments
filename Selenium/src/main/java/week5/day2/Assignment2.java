package week5.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev76441.service-now.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//2. Login with valid credential 
		driver.findElement(By.id("user_name")).sendKeys("admin");		
		driver.findElement(By.id("user_password")).sendKeys("Aa123456...");
		
		driver.findElement(By.id("sysverb_login")).click();
		
		//3. Click All and Enter Proposal in filter navigator and press enter 
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//div[text()='All']").click();
		//shadow.findElementByXPath("//span[text()='Service Catalog']").click();
		shadow.findElement("#filter").sendKeys("Proposal");
		shadow.findElement(".filter-match").click();
		
		
		//4. Click- new  and  fill mandatory fields and click 'Submit' 	Button.
		
		WebElement clicknew = shadow.findElementByXPath(("//iframe[@title='Main Content']"));
	
		driver.switchTo().frame(clicknew);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Issue with networking");
		
		//driver.switchTo().frame(1);
		
		driver.findElement(By.xpath("//div[@class='form_action_button_container']/button")).click();
		
		
		
		
		//5. Verify the successful creation of new Proposal"
		String proposal = driver.findElement(By.xpath("//td[text()='Issue with networking']")).getText();
		System.out.println(proposal);
		if(proposal.contains("networking") ){
			System.out.println("created successfully");
			
		}
		else {
			System.out.println("proposal not created");
		}
	}

}
