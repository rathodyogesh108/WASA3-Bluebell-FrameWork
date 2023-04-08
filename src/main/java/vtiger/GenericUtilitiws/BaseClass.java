package vtiger.GenericUtilitiws;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepositary.HomePage;
import vtiger.ObjectRepositary.LoginPage;

/**
 * This class consist of basic configuration Annotation of TestNG
 * @author Yogesh
 *
 */

public class BaseClass {
	
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public javaUtility jUtil=new javaUtility();
	public static WebDriver sDriver;
	
	public WebDriver driver;
	
	@BeforeSuite (groups={"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("---Database Connection Is Succesful---");
	}
	
	@BeforeClass(groups= {"SmokeSuite","RegressionSuite"})
	public void bcConfig() throws IOException
	{
	   String URL = pUtil.readDataFromPropertyFile("url");
	  String BROWSER = pUtil.readDataFromPropertyFile("browser");
	  
	  if(BROWSER.equalsIgnoreCase("chrome"))
	  {
		  WebDriverManager.chromedriver().setup();
		  ChromeOptions co=new ChromeOptions();
		  co.addArguments("--remote-allow-origins=*");
		   driver = new ChromeDriver(co);
		   System.out.println("----+BROWSER+----launched succesfully");
	  }
	  else if(BROWSER.equalsIgnoreCase("firefox"))
	  {
		  driver=new FirefoxDriver();
	  }
	  
	  else
	  {
		  System.out.println("Invalid browser");
	  }
	  
	  sDriver=driver;
	  wUtil.maximizeWindow(driver);
	  wUtil.waitForPage(driver);
	  driver.get(URL);
	}
	
	@BeforeMethod(groups= {"SmokeSuite","RegressionSuite"})
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToapp(USERNAME, PASSWORD);
		System.out.println("Login Succesfully");
	}
	
	@AfterMethod(groups= {"SmokeSuite","RegressionSuite"})
	public void amConfig()
	{
		HomePage hp=new HomePage(driver);
		hp.logOutofApp(driver);
		System.out.println("logout Succesfully");
	}
	
	@AfterClass(groups= {"SmokeSuite","RegressionSuite"})
	public void acConfig()
	{
		driver.quit();
		System.out.println("Browser closed succesfully");
	}
	
	@AfterSuite(groups= {"SmokeSuite","RegressionSuite"})
	public void asConfig()
	{
		
	}

}
