package extentreports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportEngine {
	
	
	public void extentReportSetUp() {
		
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("C:\\Users\\Mohd Yusuf\\codeRepository\\NALCucSelBDD\\NALBDDCucSel\\target\\report.html");
		extentReports.attachReporter(extentSparkReporter);
		
		ExtentTest test1 = extentReports.createTest("TestOne");
		ExtentTest test2 = extentReports.createTest("TestTwo");
		test1.pass("This is the test");
		//we can log also
		/*If the status of tests is fail, all tests are marked failed
		 *If the status of tests is skip and failed is not there, all tests are marked skipped
		 *If the status of tests is pass and failed or skip is not there, all tests are marked passed
		 *If the status of tests is info and failed or skip or passed are not there, all tests are marked info only
		 * 
		 */
		test1.log(Status.PASS, "This is passed");
		test2.log(Status.FAIL, "This is failed");
		extentReports.flush();
		
		//to open the report file automatically.... 
		try {
			Desktop.getDesktop().browse(new File("C:\\\\Users\\\\Mohd Yusuf\\\\codeRepository\\\\NALCucSelBDD\\\\NALBDDCucSel\\\\target\\\\report.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	

}
