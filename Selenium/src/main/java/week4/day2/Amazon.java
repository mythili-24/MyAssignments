package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup(); 
        ChromeOptions ch = new ChromeOptions();
		
		ChromeDriver driver=new ChromeDriver();
		ch.addArguments("--disable-notifications");
		driver.get(" https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
		
		//2.search as oneplus 9 pro 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus9pro",Keys.ENTER);
		
		//3.Get the price of the first product
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[4]")).getText();
		System.out.println("price of first product: "+ price);
		
		//4. Print the number of customer ratings for the first displayed product
		String rating = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']")).getText();
		System.out.println("customer rating for first product: "+ rating);
		
		//5. Mouse Hover on the stars
        WebElement stars = driver.findElement(By.xpath("(//a[@href='javascript:void(0)']//i)[1]"));
		
		Actions builder =new Actions(driver);
		builder.scrollByAmount(0, 150).moveToElement(stars).click().build().perform();
		Thread.sleep(1000);
		
		//6. Get the percentage of ratings for the 5 star.
		String percentage = driver.findElement(By.xpath("(//td[@class='a-text-right a-nowrap']//a)[1]")).getText();
		System.out.println("percentage of ratings for 5star:" + percentage);
		
		//7. Click the first text link of the first image

		//handle window
		String parentwindow = driver.getWindowHandle();
		driver.findElement(By.xpath("(//span[contains(@class,'a-size-medium a-color-base')])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>  window1= new ArrayList<String>(windowHandles);
		driver.switchTo().window(window1.get(1));
		Thread.sleep(2000);
		
		//8. Take a screen shot of the product displayed
		//take snapshot
				File source = driver.getScreenshotAs(OutputType.FILE);
				//Create physicalFile
				File dest=new File("./snaps/screenshort.png");
				//copy the source to destination
				FileUtils.copyFile(source, dest);
				
		//9. Click 'Add to Cart' button
		driver.findElement(By.xpath("//input[@title='Add to Shopping Cart']")).click();
		Thread.sleep(2000);
		
		//10. Get the cart subtotal and verify if it is correct.
		String subtotalcart = driver.findElement(By.xpath("//span[contains(@class,'a-size-base-plus a-color-price')]//span[1]")).getText();
		System.out.println("subtotal of cart: " + subtotalcart);
		
				
		
				
		
		

	}

}
