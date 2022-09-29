package week4.day1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
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
		
		
				
				for (int i = 1; i <lst.size();i++) {
					
		List<WebElement> securitynames = driver.findElements(By.xpath("//table[contains(@class,'table table-bordered table')]//tr["+i+"]/td[3]"));

		
			
			String text= securitynames.get(i).getText();
			
			for (int j = 1; j < securitynames.size(); j++) {
				
				lst.add(text);
			}
			System.out.print(lst.size());
			
		}
		
		Set<String> dupset= new LinkedHashSet<String>(lst);
		
		if(lst.size()== dupset.size()) {
			
			System.out.println("duplicate is present");
		}
		else {
			
			System.out.println("no duplicate");
		}
		

	}

}
