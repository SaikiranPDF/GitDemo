package KiranKabothula.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {

	ExtentReports extent;
	@BeforeTest
	public void config()
	{
		//Two main classes are 1.ExtentReports 2.ExtentSparkReporter
		
		//ExtentSparkReporter
		String path = System.getProperty("user.dir")+"\\report\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		//ExtentReports
		 extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "kiran Kabothula");
		
	}
	
	@Test
	public void intialDemo()
	{
		
		ExtentTest test = extent.createTest("Initial Demo");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		test.fail("Result Do Not Match");
		extent.flush();		
	}
}
