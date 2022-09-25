package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
		// TODO Auto-generated method stub
		//MouseHover on Women
		WebElement women = driver.findElement(By.xpath("(//a[text()='Women'])[1]"));
	   //Move to Actions
		//pass driver as a Arg
		Actions builder =new Actions(driver);
		builder.moveToElement(women).perform();


	}

}
