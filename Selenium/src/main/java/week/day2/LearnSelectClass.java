package week.day2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnSelectClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://WWW.amazon.in");
		driver.manage().window().maximize();
		driver.findElement( By.id("twotabsearchtextbox")).sendKeys("Bags for men",Keys.ENTER);
		String text= driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("field-keywords"));
		
		//Select source =new Select(dropDown);
		//source.selectByIndex(1);
		//source.selectByVisibleText("twotabsearchtextbox");
	 
		
        

	}

}
