package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
		
		//2) Mouseover on Brands and Search L'Oreal Paris
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		
		Actions builder =new Actions(driver);
		builder.moveToElement(brands).perform();
		
		//3) Click L'Oreal Paris
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		
		//4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("L'Oreal Paris")){
			System.out.println("L'Oreal Paris");
		}
		else {
			System.out.println("title not present");
		}
		
		//5) Click sort By and select customer top rated
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		
		//6) Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		
		//7) Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		
		boolean isShampooPresesent = false;
		//8)check whether the Filter is applied with Shampoo
		List<WebElement> filter= driver.findElements(By.xpath("//span[@class='filter-value']"));
		for (int i = 0; i < filter.size(); i++) {
			System.out.println(filter.get(i).getText());
		}
			
		
		//9) Click on L'Oreal Paris Colour Protect Shampoo
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='css-1rd7vky']//div")).click();
		
		
		
		//10) GO to the new window and select size as 175ml
		//handle the window
				Set<String> window1 = driver.getWindowHandles();
				
				List<String>lstWindow=new ArrayList<String>(window1);
				
				driver.switchTo().window(lstWindow.get(1));
		//select class
		  WebElement shampoosize = driver.findElement(By.className("css-2t5nwu"));
	      Select shampoo = new Select(shampoosize);
	      shampoo.selectByVisibleText("175ml");
	   
	    
	    //11) Print the MRP of the product
	    WebElement price = driver.findElement(By.xpath("//span[text()='₹189']"));
	    price.getText();
	    System.out.println("mrp of the product"+price.getText());
	    
	    //12) Click on ADD to BAG
	    driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
	    
	    //13) Go to Shopping Bag 
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		
		//14) Print the Grand Total amount
		//WebElement grandtotal = driver.findElement(By.xpath("//div[@class='css-i1x59x e25lf6d5']//span[1]"));
		
		String  grandtotal = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
		
		System.out.println(grandtotal);
		
		//15) Click Proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		
		//16) Click on Continue as Guest
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		
		//17) Check if this grand total is the same in step 14
		
		//18) Close all windows
		//driver.close();
		
		
	    

	}

}
