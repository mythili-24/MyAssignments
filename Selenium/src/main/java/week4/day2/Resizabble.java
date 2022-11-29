package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizabble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resizable");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//handle frame
		driver.switchTo().frame(0);
		WebElement findElement = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
		
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(findElement, 300, 0).perform();
		

	}

}
