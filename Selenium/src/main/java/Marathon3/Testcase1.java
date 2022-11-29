package Marathon3;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase1 extends ProjectSpecificMethod {
	@BeforeTest
	   public void setup() {
		   excelFile="salesforcedata";
		   sheetName="testcase1";
	   }

	@Test(dataProvider ="fetchData" )

	public  void runTestcase1(String search,String questions,String details) throws InterruptedException {
		  

			//05) Type Content on the Search box
			driver.findElement(By.xpath("//one-app-launcher-search-bar[@class='searchBar']")).sendKeys(search);
			//06) Click Content Link
			driver.findElement(By.xpath("//div[@class='slds-truncate']")).click();
			//07) Click on Chatter Tab
			driver.findElement(By.xpath("(//one-app-nav-bar-item-root[contains(@class,'navItem slds-context-bar')])[2]")).click();
			//08) Verify Chatter title on the page
			String text = driver.findElement(By.xpath("//span[text()='Chatter']")).getText();
			System.out.println(text);
			if(text.contains("Chatter")) {
				System.out.println("title is present");
			}
			 String title=driver.getTitle();
			 System.out.println("Page title is : " + driver.getTitle());
			 
			//09) Click Question tab
			 driver.findElement(By.xpath("(//li[@class='tabs__item uiTabItem'])[2]")).click();
			//10) Type Question with data (coming from excel)
			 driver.findElement(By.xpath("//textarea[@placeholder='What would you like to know?']")).sendKeys(questions);
			//11) Type Details with data (coming from excel)
			 driver.findElement(By.xpath("//div[@data-placeholder='If you have more to say, add details here...']")).sendKeys(details);
			//12) Click Ask
			 driver.findElement(By.xpath("//div[@class='bottomBarRight slds-col--bump-left']/button")).click();
			//13) Confirm the question appears
			 String question = driver.findElement(By.xpath("//div[contains(@class,'cuf-body cuf-questionTitle force')]/span")).getText();
			 System.out.println(question);
			 if(question.contains(questions)) {
				 System.out.println("question appeared");
			 }
						
			
	}

}
