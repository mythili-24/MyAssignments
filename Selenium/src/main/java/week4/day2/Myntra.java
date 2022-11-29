package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); 
        ChromeOptions ch = new ChromeOptions();
		
		ChromeDriver driver=new ChromeDriver(ch);
		ch.addArguments("--disable-notifications");
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
		
		//2) Mouse hover on MeN 
		WebElement men = driver.findElement(By.xpath("(//a[text()='Men'])[1]"));

		//3) Click Jackets 
		WebElement jackets = driver.findElement(By.xpath("(//a[text()='Jackets'])[1]"));
		
		Actions mousehover =new Actions(driver);
		mousehover.moveToElement(men).click(jackets).perform();
		
		//4) Find the total count of item 
		String totalcount = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
		System.out.println("total count of item: " + totalcount);
		
		//5) Validate the sum of categories count matches
		//7) Click + More option under BRAND
		driver.findElement(By.className("brand-more")).click();
		
        //8) Type Duke and click checkbox
		driver.findElement(By.className("FilterDirectory-searchInput")).sendKeys("duke");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[@class='common-customCheckbox']//input)[1]")).click();
		
		//9) Close the pop-up x
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		Thread.sleep(1000);
		
		//10) Confirm all the Coats are of brand Duke
	   // Hint : use List 
	   List<WebElement> coats = driver.findElements(By.xpath("//li[@class='product-base']//a//div//h3[1]"));	
	   for (int i = 0; i < coats.size(); i++) {
		   System.out.println(coats.get(i).getText());
		
	}
	   
	   //11) Sort by Better Discount
	   driver.findElement(By.xpath("//div[@class='sort-sortBy']")).click();
	   Thread.sleep(1000);
	   
	   //12) Find the price of first displayed item
	   //Click on the first product
	   String price = driver.findElement(By.xpath("//div[@class='product-price'][1]")).getText();
	   System.out.println("price of first product: " + price);
	   
	   //13) Take a screen shot
	 //take snapshot
		File source = driver.getScreenshotAs(OutputType.FILE);
		//Create physicalFile
		File dest=new File("./snaps/screenshort.png");
		//copy the source to destination
		FileUtils.copyFile(source, dest);
		
		//14) Click on WishList Now

		driver.findElement(By.xpath("(//span[@class='desktop-userTitle'])[2]")).click();
	   
	   
	   
	   
	   
	   
		
		

		
		

	}

}
