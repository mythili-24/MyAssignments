package Marathon3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase2 extends ProjectSpecificMethod{
	@BeforeTest
	   public void setup() {
		   excelFile="salesforcedata";
		   sheetName="testcase2";
	   }

	@Test(dataProvider ="fetchData" )

	public  void runTestcase2(String search,String lastname) throws InterruptedException {
		 
			//05) Type Individuals on the Search box
			driver.findElement(By.xpath("//one-app-launcher-search-bar[@class='searchBar']")).sendKeys(search);
			
			
			//06) Click Individuals Link
			driver.findElement(By.xpath("//li[contains(@class,'slds-size_1-of-5 slds')]")).click();
			//07) Click New
			driver.findElement(By.xpath("//li[contains(@class,'slds-button slds-button--neutral')]")).click();
			//08) Name: Select Salutation with data (coming from excel) 
			driver.findElement(By.xpath("//a[@role='menuitemradio']")).sendKeys("Mrs");
			/*List<WebElement> salutation = driver.findElements(By.xpath("//a[@role='menuitemradio']"));
		    int size = salutation.size();
		    System.out.println(size);
		    
		    for (int i = 0; i<salutation.size(); i++) {
		    	salutation.get(2).click();
		    	break;
		    	}
		    */	
			
			
			//09) Type Last Name (coming from excel)
			driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastname);
			//10) Click Save
			driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
			//11) Click on the App Launcher (dots)
			driver.findElement(By.xpath("//button[@class='slds-button slds-show']")).click();
			
			//12) Click View All
			driver.findElement(By.xpath("//div[@class='slds-size_medium']//lightning-button")).click();
			Thread.sleep(5000);

			//13) Type Customers on the Search box
			driver.findElement(By.xpath("//one-app-launcher-search-bar[@class='searchBar']")).sendKeys(search);

			//14) Click Customers Link
			driver.findElement(By.xpath("//li[@class='slds-size_1-of-5 slds-col--padded slds-p-vertical_small']")).click();
			//15) Click New
			WebElement newClk = driver.findElement(By.xpath("//div[text()='New']"));
			driver.executeScript("arguments[0].click();",newClk);
			Thread.sleep(2000);
			//16) Type the same name provided in step 8 and confirm it appears
			
			driver.findElement(By.xpath("//input[@title='Search Individuals']")).sendKeys("Sabarish");
			Thread.sleep(3000);
			String text = driver.findElement(By.xpath("//table[contains(@class,'forceRecordLayout slds-table slds-table')]//td/a[1]")).getText();
			System.out.println(text);
			


			
	}

}
