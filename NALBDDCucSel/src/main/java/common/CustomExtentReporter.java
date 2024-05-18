package common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class CustomExtentReporter {
	public static Map<String, String> testStatus = new LinkedHashMap<String, String>();
	// public ExtentHtmlReporter extentSparkReporter = null;
	public ExtentReports extent = null;
	public ExtentTest test = null;
	public String repHTMLFileName = null;
	public String repTestName = null;
	public String repTestDesc = null;
	public String repFolderPath = null;

	public CustomExtentReporter(String repHTMLFileName, String repTestName, String repTestDesc) {

		this.repHTMLFileName = repHTMLFileName;
		this.repTestName = repTestName;
		this.repTestDesc = repTestDesc;
		this.repFolderPath = System.getProperty("user.dir") + "\\target\\Extent-Reports";

	}
	
	
	
	public synchronized void generateReport() {
		this.extent.flush();
	}

	public String getTimeStamp() {
		long timeinMillis = System.currentTimeMillis();
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timeinMillis);
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
		String dateforrow = dateFormat.format(cal.getTime());

		return dateforrow;
	}
	
	
	public static void main(String[] args) {
		
	}
}
