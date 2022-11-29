package week5.day2;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class LearnDepends {
	@Test(dependsOnMethods= {"testcase.DeleteLead.runDeleteLead"},alwaysRun= true)
	public void create() {
		
	}
	@Test(priority = 1)
	public void edit() {
		
	}
	@Ignore
	@Test(enabled=true)
	public void delete() {
		
	}

}
