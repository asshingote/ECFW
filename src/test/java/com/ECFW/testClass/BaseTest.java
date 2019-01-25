package com.ECFW.testClass;

import java.util.concurrent.TimeUnit; 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.ECFW.genericClass.AutoConstant;
import com.ECFW.genericClass.Listener;
import com.ECFW.genericClass.PropertyfileHandling;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;



@Listeners(Listener.class)
public class BaseTest implements AutoConstant
{
	public static WebDriver driver;
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	
	@BeforeTest
	public void startReport() {

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Sample Test");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "Amol");

		htmlReporter.config().setDocumentTitle("ECFW Extent Report");
		htmlReporter.config().setReportName("Amol Shingote");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
	
	@Parameters("browsername")
	@BeforeMethod(alwaysRun=true)
	public void preCondition(@Optional("abc") String browsername)
	{
		if(browsername.equalsIgnoreCase("Firefox"))
		{
			//System.setProperty(GeckoExe, GeckoPath);
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("Chrome"))
		{
			System.setProperty(CHROME_EXE, CHROME_PATH);
			driver=new ChromeDriver();
		}
		else
		{
			System.setProperty(IE_EXE, IE_PATH);
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		String str = PropertyfileHandling.getProperty("URL");
		driver.get(str);
	}
	/*@AfterMethod(alwaysRun=true)
	public void testResult(ITestResult result)
	{
		String testmethodname = result.getName();
		int status = result.getStatus();
		if(status==2)
		{
			ScreenShotHandling.getScreenShot(driver, testmethodname);
		}
		
	}*/
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}
	
	@AfterTest
	public void endReport() 
	{
		extent.flush();
		//extent.close();
	}

}
