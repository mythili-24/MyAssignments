package Marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Redbus {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Chennai");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bangalore");
		Thread.sleep(2000);
		
		driver.findElement(By.id("onward_cal")).click();
		
		driver.findElement(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr[4]/td[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
		
	   //07) Print the number of buses shown as results (104 Buses found)
	   String numofbus = driver.findElement(By.xpath("//span[@class='w-60 d-block d-found']")).getText();
		System.out.println(numofbus);
		
		//08) Choose SLEEPER in the left menu
		driver.findElement(By.xpath("//label[text()='SLEEPER']")).click();
		
		//09) Print the name of the second resulting bus 
		String secondbbusname = driver.findElement(By.xpath("(//div[text()='Hail Trip'])[2]")).getText();
		System.out.println(secondbbusname);
		//10) Click the VIEW SEATS of that bus
		driver.findElement(By.xpath("(//div[text()='View Seats'])[2]")).click();
		//11) Take screenshot and close browser
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snaps/screenshort.png");
		FileUtils.copyFile(source, dest);
		
	}

}
