package week.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	private static final String Nov = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));

		
		
		//Click on Create New Account button
		driver.findElement(By.linkText("Create New Account")).click();
		driver.findElement(By.name("firstname")).sendKeys("mythili");
		driver.findElement(By.name("lastname")).sendKeys("vijayakumar");
		driver.findElement(By.name("reg_email__")).sendKeys("123456789");
		driver.findElement(By.id("password_step_input")).sendKeys("testleaf");
		
		
		WebElement birthday= driver.findElement(By.name("birthday_day"));
		Select day= new Select(birthday);
		day.selectByValue("6");
		
		
		WebElement birthMonth= driver.findElement(By.name("birthday_month"));
        Select month= new Select(birthMonth);
		month.selectByVisibleText("Nov");
		
		WebElement birthYear= driver.findElement(By.name("birthday_year"));
        Select year= new Select(birthYear);
		year.selectByIndex(8);
		
		driver.findElement(By.className("_58mt")).click();
		
		
		
		
		
		
		
		
	}

}
