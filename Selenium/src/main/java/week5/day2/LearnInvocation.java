package week5.day2;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class LearnInvocation {
	@Test(invocationCount=3,invocationTimeOut=5000,threadPoolSize=2)
	public void create() {
		
	}
	@Test(priority = 1)
	public void edit() {
		
	}
	@Ignore
	@Test(enabled=false)
	public void delete() {
		
	}

}
