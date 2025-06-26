package TestUtils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestReporterTestNG {
	static ExtentReports extent;
	
	public static ExtentReports getReporterObject() {
		String path = System.getProperty("usr.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Test Automation for Leaforg");
		reporter.config().setDocumentTitle("Test Result");
		return extent;
	}

}
