package week7.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForTextChange {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	    ChromeDriver driver=new ChromeDriver();
	    driver.get("https://leafground.com/waits.xhtml");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    //find the element
	    WebElement click = driver.findElement(By.xpath("(//span[text()='Click'])[3]"));
	    click.click();
	    //explicitly wait
	   
	    
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));//webdriver wait is a subclass
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//span[text()='Click'])[3]"), "Did You Notice"));
        String text1 = driver.findElement(By.xpath("//span[text()='Did you notice?']")).getText();
        System.out.println(text1);
	}

}
