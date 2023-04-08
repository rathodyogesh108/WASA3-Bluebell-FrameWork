package practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilitiws.ExcelFileUtility;
import vtiger.GenericUtilitiws.PropertyFileUtility;
import vtiger.GenericUtilitiws.WebDriverUtility;
import vtiger.GenericUtilitiws.javaUtility;

public class DemoTestScriptwithDDtandGU {

	public static void main(String[] args) throws IOException {
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		javaUtility jUtil=new javaUtility();
		
		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME = eUtil.readDataFromExcel("Sheet2", 4, 2)+jUtil.getrandomNumber();
		
		
		
		
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions Options=new ChromeOptions();
			Options.addArguments("--remote-allow-origins=*");
		
			driver=new ChromeDriver(Options);
		}
	    else if(BROWSER.equalsIgnoreCase("firefox"))
		{
	    	WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser name");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForPage(driver);
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys("ORGNAME");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String orgheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgheader.contains("ORGNAME"))
		{
			System.out.println(orgheader+"pass");
		}
		else
		{
			System.out.println("fail");
		}
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        wUtil.mouseHoverAction(driver, ele);
        
        driver.findElement(By.linkText("Sign Out")).click();
        System.out.println("signout succesful");
        
		

	}

}
