package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Library {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.get(" https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
		List<WebElement> library= driver.findElements(By.xpath("//div[@class='render']/table"));
		for (int i = 0; i < library.size(); i++) {
			System.out.println(library.get(i).getText());
		}
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr"));
		System.out.println(rows.size());
		
		List<WebElement> columns=driver.findElements(By.xpath("//div[@class='render']/table//th"));
		System.out.println(columns.size());
				
	}

}



