package week8.day2;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnExtentReport {

	public static void main(String[] args) throws IOException {
		//set up the physical report path
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./reports/result.html");
		//to keep the report history
		reporter.setAppendExisting(true);
		//Create object for ExtentReports
		ExtentReports extent=new ExtentReports();
		//attach the data with physical report
		extent.attachReporter(reporter);
		//create a test case and assign the test detail
		                                    //testname       //test Description
		ExtentTest test = extent.createTest("Login","Login test for leaftaps application");//ctrl+2+l
        test.assignCategory("smoke");
        test.assignAuthor("Mythili");
        //step level status
        test.pass("Enter username");//if status pass, the test will treated as pass
        test.fail("Enter password");//if status fail, the test will treated as fail
       //attach the screenshot//control still stay in reports folder;../ to came out of the report  folder
        test.pass("Click login button",MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/login.png").build());
        
        //Mandatory step
        extent.flush();
        

	}

}
