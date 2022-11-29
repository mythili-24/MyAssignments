package week7.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
	    ChromeDriver driver=new ChromeDriver();
	    driver.get("https://leafground.com/waits.xhtml");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    //find the element
        WebElement invisibility = driver.findElement(By.xpath("(//span[text()='Click'])[2]"));
        invisibility.click();
        //explicitly wait
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));//webdriver wait is a subclass
        wait.until(ExpectedConditions.visibilityOf(invisibility));
        String text = driver.findElement(By.xpath("(//span[text()='I am about to hide'])[1]")).getText();
        System.out.println(text);
	}

}
