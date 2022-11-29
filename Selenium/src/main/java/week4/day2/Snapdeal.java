package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup(); 
        ChromeOptions ch = new ChromeOptions();
		
		ChromeDriver driver=new ChromeDriver();
		ch.addArguments("--disable-notifications");
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
		
		//2. Go to Mens Fashion
		WebElement mensfashion = driver.findElement(By.linkText("Men's Fashion"));
		Actions builder =new Actions(driver);
		builder.moveToElement(mensfashion).perform();
		
		//3. Go to Sports Shoes
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		
		//4.get the count of sports shoes
		String count = driver.findElement(By.xpath("//span[ @class='category-name category-count']")).getText();
        System.out.println(" the count of the sports shoes : " + count);
        
        //5. Click Training shoes
        driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
        
        //6. Sort by Low to High
        driver.findElement(By.xpath("//i[@class ='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
        driver.findElement(By.xpath("//li[@class='search-li'][1]")).click();
        
        //7. Check if the items displayed are sorted correctly use string
		String sort = driver.findElement(By.xpath("//div[@class='sort-drop clearfix']/div")).getText();
        System.out.println(sort);
        if(sort.contains("Low to High")) {
			 System.out.println("item displayed correctly");
		 }else {
			 System.out.println("item not displayed correctly");
		 }

        
        
        //8.Select the price range (900-1200)
        
        
        driver.findElement(By.name("fromVal")).clear();
        Thread.sleep(1000);
		driver.findElement(By.name("fromVal")).sendKeys("500");

		driver.findElement(By.name("toVal")).clear();
		Thread.sleep(1000);
		driver.findElement(By.name("toVal")).sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(text(),'GO')] ")).click();
		Thread.sleep(2000);
		
       
        
        //9.Filter with color Navy 
       
        driver.findElement(By.xpath("//label[@for='Color_s-Navy']/span")).click();
        Thread.sleep(1000);
        
        //11. Mouse Hover on first resulting Training shoes
        WebElement firstresult = driver.findElement(By.className("product-title"));
		builder.moveToElement(firstresult).perform();
		
		//12. click QuickView button
		driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar')]")).click();
		
		//13. Print the cost and the discount percentage
		
		
		String price = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println(price);
		
		String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println(discount);
		
		//14. Take the snapshot of the shoes.
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snaps/screenshort.png");
		FileUtils.copyFile(source, dest);
		 
		 driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();
		Thread.sleep(2000);

		
		//driver.close();
		
        

	}

}
