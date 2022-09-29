package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//click the simple alert
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		
		//switch the control
	    Alert alert = driver.switchTo().alert();//ctrl+2+l
	    String text = alert.getText();//ctrl+2+l
	    System.out.println(text);
        //2. Click on OK button in the dialog 
	    alert.accept();
	    driver.findElement(By.xpath("//button[text()='OK']")).click();
	    //click on flight
	    driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		
	  //get the title
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		//How can i know the second window
		Set<String> windowHandles = driver.getWindowHandles();//ctrl+2+l
		System.out.println("How many window open"+windowHandles.size());
		//how can i get second window
		//convert set into list by pass the set value to list as a arg
		List<String>lstWindow=new ArrayList<String>(windowHandles);
		//How to move the control
		driver.switchTo().window(lstWindow.get(1));
		//print title
		System.out.println(driver.getTitle());
		//Close
		driver.close();

	    

	}

}
