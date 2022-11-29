package Marathon2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bookmyshow {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); 
		//ChromeDriver driver=new ChromeDriver();
		
		
        //disable notifications
        ChromeOptions ch=new ChromeOptions();
        ch.addArguments("--disable-notifications");
        ChromeDriver driver=new ChromeDriver(ch);
        driver.get("https://in.bookmyshow.com/");
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
		String title = driver.getTitle();
		
		//03) Type the city as "Hyderabad" in Select City
		driver.findElement(By.tagName("input")).sendKeys("hyderabad");
		driver.findElement(By.xpath("//li[@class='sc-dBaXSw gpWNMK']")).click();
		//driver.findElement(By.xpath("//div[contains(@class,'sc-bZQynM sc-iBmynh')]//input[1]")).sendKeys("hyderabad",Keys.ENTER);
		Thread.sleep(2000);
		
		//04) Confirm the URL has got loaded with Hyderabad 
		String currentUrl = driver.getCurrentUrl();
		
		if(currentUrl.contains("hyderabad")) {
			System.out.println("Hyderabad present");
		}
		//05) Search for your favorite movie 
		WebElement favmovie = driver.findElement(By.id("4"));
	/*WebElement favmovie = driver.findElement(By.xpath("//span[contains(text(),'Search for Movies')]"));*/
		favmovie.click();
		driver.findElement(By.tagName("input")).sendKeys("ponniyin selvan");
		driver.findElement(By.xpath("//span[@class='sc-hizQCF gYtrAR']")).click();
		//favmovie.sendKeys("ponniyin selvan");
		
		
		//06) Click Book Tickets
		//driver.findElement(By.xpath("//span[text()='Book tickets']")).click();
		driver.findElement(By.xpath("//button[@data-phase='postRelease']//div")).click();
		
		//07) Print the name of the theater displayed first
		//driver.findElement(By.xpath("(//div[@class='sc-vhz3gb-3 dRokFO'])[2]")).click();
		String theatre = driver.findElement(By.xpath("//a[text()='AMB Cinemas: Gachibowli']")).getText();
		System.out.println("the first displayed theatre is " + theatre);
		//08) Click on the info of the theater
		driver.findElement(By.xpath("//div[text()='INFO']")).click();
		
		//handle sweet alert
		driver.findElement(By.id("btnPopupAccept")).click();
		//09) Confirm if there is a parking facility in the theater
		String parking = driver.findElement(By.xpath("//div[contains(text(),' Parking Facility ')]")).getText();
		if(parking.contains("parking")) {
			System.out.println("parking facility available");
		}
		
		
		//10) Close the theater popup
		driver.findElement(By.xpath("//div[@class='cross-container']")).click();
		//11) Click on the first green (available) timing
		driver.findElement(By.xpath("//div[text()[normalize-space()='01:15 PM']]")).click();
		//12) Click Accept
		driver.findElement(By.xpath("//div[text()='Accept']")).click();
		
		//13) Choose 1 Seat and Click Select Seats
		driver.findElement(By.xpath("//ul[@id='popQty']/li")).click();
		driver.findElement(By.xpath("(//div[@class='btn-bar'])[2]")).click();
		
		//14) Choose any available ticket and Click Pay
		driver.findElement(By.xpath("//table[@class='setmain']//tr[6]/td[2]//a)[2]")).click();
		//15) Print the sub total
		String payRs = driver.findElement(By.xpath("//a[@id='btmcntbook']")).getText();
		
		//16) Take screenshot and close browser

		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snaps/screenshort.png");
		FileUtils.copyFile(source, dest);
		
		

	}

}
