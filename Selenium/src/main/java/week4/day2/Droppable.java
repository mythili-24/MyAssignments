package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Droppable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.switchTo().frame(0);
	
		WebElement drag = driver.findElement(By.xpath("//div[contains(@class,'ui-widget-content')]"));
		Actions builder =new Actions(driver);
		builder.clickAndHold(drag).dragAndDropBy(drag, 100,200).perform();
		
		WebElement drop = driver.findElement(By.xpath("//div[@class='ui-widget-header ui-droppable']"));
	
		builder.dragAndDrop(drag, drop).perform();
		

	}

}
