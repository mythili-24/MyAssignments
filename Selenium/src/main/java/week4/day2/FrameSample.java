package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//handle frame
	    driver.switchTo().frame("iframeResult");//index start from 0
		WebElement frame1=driver.findElement(By.xpath("//button[text()='Try it']"));
        frame1.click();
        //handle alert
      //click the simple alert
		
		
	    Alert alert = driver.switchTo().alert();//ctrl+2+l
	    String text = alert.getText();//ctrl+2+l
	    System.out.println(text);//print the text in alert box
	    //click ok / cancel
	    alert.accept();
	    String text2=driver.findElement(By.id("demo")).getText();
		if(text2.contains("You pressed")) {
			System.out.println("Action is performed");
		}

	    
	    
	}

}
