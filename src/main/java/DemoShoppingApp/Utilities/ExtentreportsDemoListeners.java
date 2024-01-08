package DemoShoppingApp.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ExtentreportsDemoListeners implements ITestListener{
	ExtentSparkReporter reporter;
	ExtentReports extent;
	ExtentTest test;
	WebDriver driver;
	ThreadLocal<ExtentTest> thread=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		test= extent.createTest(result.getName());
		thread.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		thread.get().log(Status.PASS, result.getName()+" passed successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		this.driver=BaseTest.driver;
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date date =new Date();
		SimpleDateFormat format=new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		String currentDate=format.format(date);
		String file_path=System.getProperty("user.dir")+"\\"+result.getName()+currentDate+".jpg";
		File screenShot=new File(file_path);
		thread.get().log(Status.FAIL, result.getThrowable());
		try {
			Files.move(f, new File(file_path));
			thread.get().addScreenCaptureFromPath(file_path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
		reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\Reports.html");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("Extent Report");
		reporter.config().setReportName("This is Demo Report for Testing");
		extent=new ExtentReports(); 
		extent.attachReporter(reporter);
		extent.setSystemInfo("Project name", "Swag Labs");
		extent.setSystemInfo("Tester", "Akshay K");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		extent.flush();
	}

}
