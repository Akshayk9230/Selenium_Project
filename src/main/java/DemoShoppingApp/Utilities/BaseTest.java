package DemoShoppingApp.Utilities;



import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
	public static WebDriver driver;
	
	public void launchBrowser() throws Exception
	{
		Properties p=new Properties();
		p.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\DemoShoppingApp\\Utilities\\Data.properties"));
		String browserName=System.getProperty("browser")!=null?System.getProperty("browser"):p.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			driver =new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(browserName.equals("edge")){
			driver =new EdgeDriver();
			driver.manage().window().maximize();
		}
	}
	@Parameters({"url"})
	@BeforeMethod(alwaysRun = true)
	public void launchApplication(String url) throws Exception
	{
		launchBrowser();
		driver.get(url);
	}
	@AfterMethod(alwaysRun = true)
	public void teardown() {
		driver.close();
	}
}
