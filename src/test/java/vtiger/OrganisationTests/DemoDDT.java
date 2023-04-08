package vtiger.OrganisationTests;



import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoDDT {

	public static void main(String[] args) throws IOException {
		
		Random r=new Random();
		int random = r.nextInt(1000);
		
		//step1"read all the data
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
      Properties pobj = new Properties();
      pobj.load(fis);
      String URL = pobj.getProperty("url");
      String BROWSER = pobj.getProperty("browser");
      
      
     String USERNAME = pobj.getProperty("username");
     String PASSWORD = pobj.getProperty("password");
      
      //read data from excel sheet
     FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
     Workbook wb = WorkbookFactory.create(fise);
      String ORGNAME = wb.getSheet("organisation").getRow(1).getCell(2).getStringCellValue();
      
      WebDriver driver=null;
      //Step2"launch the browser
      if(BROWSER.equalsIgnoreCase("chrome"))
      {
    	  driver=new ChromeDriver();
      }
      else if(BROWSER.equalsIgnoreCase("firefox"))
      {
    	  driver=new FirefoxDriver();
    			  
      }
      else {
    	  System.out.println("invalid browser name");
    	  
      }
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.get(URL);
      
      
     driver.findElement(By.name("user_name")).sendKeys("USERNAME");
     driver.findElement(By.name("user_password")).sendKeys("PASSWORD");
      
      
      
	}

}
