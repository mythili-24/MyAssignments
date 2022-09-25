package week4.day1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittograph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.get(" https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
		
		driver.findElement(By.id("navbtn_stockmarket")).click();
		driver.findElement(By.linkText("NSE Bulk Deals")).click();
		
		//declare the list
				List<String> lst= new ArrayList<String>();
				
				for (int i = 0; i <lst.size();i++) {
					
		List<WebElement> library = driver.findElements(By.xpath("//table[contains(@class,'table table-bordered table')]//tr["+i+"]/td[3]"));
		
		
			
			String text=library.get(i).getText();
			
			for (int j = 0; j < library.size(); j++) {
				
				lst.add(text);
			}
			System.out.print(lst);
			
		}
		
		Set<String> dupset= new HashSet<String>(lst);
		if(lst.size()== dupset.size()) {
			
			System.out.println("duplicate is present");
		}
		else {
			
			System.out.println("no duplicate");
		}
		

	}

}
