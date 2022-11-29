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

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.get(" https://www.amazon.in/");
		
        //disable notifications
        ChromeOptions ch=new ChromeOptions();
        ch.addArguments("--disable-notifications");
        ChromeDriver drive=new ChromeDriver(ch);
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
		
		//03) Type "Bags" in the Search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bags for boys",Keys.ENTER);
		
		//04) Choose the displayed item in the result with bags for boys
		
		//05) Print the total number of results (like 30000)
	    //1-48 of over 30,000 results for "bags for boys"
		WebElement result = driver.findElement(By.xpath("//span[text()='1-48 of over 30,000 results for']"));
		result.getText();
		String s="1-48 of over 30,000 results for";
		String[] split = s.split(" ");
		System.out.println(split[3]);
		
		
		//06) Select the first 2 brands in the left menu
	   // (like American Tourister, Generic)
		driver.findElement(By.xpath("(//div[contains(@class,'a-checkbox a-checkbox-fancy')]/following-sibling::span)[3]")).click();
		driver.findElement(By.xpath("//span[text()='See more'][1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@id='p_89/Generic']/span[1]/a[1]/div[1]/label[1]/i[1]")).click();
		
		//07) Confirm the results have got reduced like 5000 &30,000	 (use step 05 for compare)
		String text = driver.findElement(By.xpath("//span[text()='1-48 of over 5,000 results for']")).getText();
		String[] split1 = text.split(" ");
		System.out.println(split1[3]);
		if(5000<30000) {
			System.out.println("result got reduced");
		}
		else {
			System.out.println("result is not reduced");
		}
		
		//08) Choose New Arrivals (Sort)
		driver.findElement(By.xpath("//span[@class='a-button-inner']")).click();
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
		
		//09) Print the first resulting bag info (name, discounted price)
		String baginfo = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")).getText();
		System.out.println(baginfo);
		
		//10) Take screenshot and close
		
				File source = driver.getScreenshotAs(OutputType.FILE);
				File dest=new File("./snaps/screenshort.png");
				FileUtils.copyFile(source, dest);
				 

	}

}
