package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassroomWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		//handle browser notification
		ChromeOptions ch = new ChromeOptions();
		
		ChromeDriver driver=new ChromeDriver(ch);
		ch.addArguments("--disable-notifications");

		driver.manage().window().maximize();
		driver.get(" https://www.irctc.co.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Handle the alert  sweet alert so inspect and write
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		
		//click on flights
		driver.findElement(By.xpath("//a[@href='https://www.air.irctc.co.in']")).click();
		
		//go to flights tab
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lstwindow=new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(lstwindow.get(1));
		
		WebElement webElement=driver.findElement(By.xpath("//a[contains(@class,'nav-link dropdown')]"));
		webElement.click();
		
		

	}

}
