package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableTag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.get(" https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
		
		List<WebElement> table=driver.findElements(By.xpath("//div[@class='render']/table"));
		for (int i = 0; i < table.size(); i++) {
			
			System.out.println(table.get(i).getText());
		}
		
		
		WebElement text=driver.findElement(By.tagName("tr"));
		text.getText();
		
		
		List<WebElement> absolute=driver.findElements(By.xpath("//div[@class='render']//tr[2]/td"));
		
		for (int i = 0; i < absolute.size(); i++) {
			System.out.println(absolute.get(i).getText());
			
		}
		
		}
	}


