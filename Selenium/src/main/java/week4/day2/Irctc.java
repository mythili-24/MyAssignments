package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Irctc {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//1. Load https://www.irctc.co.in/
		//	2. Click on OK button in the dialog  
		          
			//4. Get the Title of the page
		WebDriverManager.chromedriver().setup();
		//handle browser notification
		ChromeOptions ch = new ChromeOptions();
		
		ChromeDriver driver=new ChromeDriver();
		ch.addArguments("--disable-notifications");

		driver.manage().window().maximize();
		driver.get(" https://www.irctc.co.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Handle the alert  sweet alert so inspect and write
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		//Alert alert = driver.switchTo().alert();
		//String text = alert.getText();
		
		
		//click ok
	   // alert.accept();
				
		//click on flights
		driver.findElement(By.xpath("//a[@href='https://www.air.irctc.co.in']")).click();
		//get title
		String title = driver.getTitle();
		System.out.println(title);
		
				

	}

}
