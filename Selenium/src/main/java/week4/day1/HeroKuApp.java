package week4.day1;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeroKuApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://testleaf.herokuapp.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
		
		List<WebElement> table=driver.findElements(By.xpath("//table[@cellspacing='0']"));
		for (int j = 0; j < table.size(); j++) {
			
			System.out.println(table.get(j).getText());
		}
		
		List<WebElement> lst=driver.findElements(By.xpath("//table[@cellspacing='0']//tr[3]/td[2]"));
		for (int i = 0; i < lst.size(); i++) {
			
			System.out.println(lst.get(i).getText()+"------progress value of learn to interact with elements");
			
		}
		
	
		//driver.findElement(By.xpath("//table[@cellspacing='0']//tr[4]/td[3]"));
	List<WebElement> columns =	driver.findElements(By.xpath("//table[@cellspacing='0']//th"));
		System.out.println(columns.size());
		
		List<WebElement> rows =	driver.findElements(By.xpath("//table[@cellspacing='0']//tr"));
			System.out.println(rows.size());
			

	}

}
