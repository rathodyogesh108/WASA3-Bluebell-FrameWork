package vtiger.OrganisationTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practiceddt {

	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		Random r=new Random();
		int random = r.nextInt(1000);
		
		
		
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fise);
		String URL = pobj.getProperty("url");
		String BROWSER = pobj.getProperty("browser");
		String USERNAME = pobj.getProperty("uname");
		String PASSWORD= pobj.getProperty("pword");
		
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fisp);
		String ORGNAME = wb.getSheet("organisation").getRow(1).getCell(2).getStringCellValue()+random;
		
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
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
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys("USERNAME");
		driver.findElement(By.name("user_password")).sendKeys("USERNAME");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys("ORGNAME");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String orgheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgheader.contains(ORGNAME))
		{
			System.out.println(orgheader+"pass");
		}
		else
		{
			System.out.println("fail");
		}
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        Actions a=new Actions(driver);
        a.moveToElement(ele).perform();
        driver.findElement(By.linkText("Sign Out")).click();
        System.out.println("signout succesful");
        
		
	
	}

}

