package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
	    driver.findElement(By.className("decorativeSubmit")).click();
		String text=driver.findElement(By.tagName("h2")).getText();
		driver.findElement(By.id("label")).click();
		
		
		// * 5. Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		
		// * 6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		// * 7. Click on Widget of From Contact
		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();
		
		//handle the window
		Set<String> window1 = driver.getWindowHandles();
		//List<String> lst1=new ArrayList<String>();
		List<String>lstWindow=new ArrayList<String>(window1);
		driver.switchTo().window(lstWindow.get(1));
		
		// * 8. Click on First Resulting Contact
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();
		
		//back to window1
		//Set<String> window = driver.getWindowHandles();
		//List<String> lst2=new ArrayList<String>(window);
		//driver.switchTo().window(lst2.get(0));
		driver.switchTo().window(lstWindow.get(0));
		
		
		// * 9. Click on Widget of To Contact
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
		
		Set<String> window2 = driver.getWindowHandles();
		List<String> lst3=new ArrayList<String>(window2);
		driver.switchTo().window(lst3.get(1));
		
		
		
		// * 10. Click on Second Resulting Contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
		driver.switchTo().window(lstWindow.get(0));
		
		// * 11. Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		// * 12. Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		// * 13. Verify the title of the page
	
			String text2 = driver.findElement(By.id("sectionHeaderTitle_contacts")).getText();
			System.out.println(text2);
		
		

	}

}
