package week7.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Clickability {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
	    ChromeDriver driver=new ChromeDriver();
	    driver.get("https://leafground.com/waits.xhtml");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    //find the element
	    WebElement clickability = driver.findElement(By.xpath("//span[text()='Click First Button']"));
	    clickability.click();
	    //explicitly wait
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));//webdriver wait is a subclass
        wait.until(ExpectedConditions.elementToBeClickable(clickability));
        WebElement secondelement = driver.findElement(By.xpath("//span[text()='Click Second']"));
        secondelement.click();

	}

}
