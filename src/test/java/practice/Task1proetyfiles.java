package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1proetyfiles {

	public static void main(String[] args) throws IOException {
         WebDriver driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.get("http://localhost:8888/");
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         
         FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
       Properties pobj = new Properties();
       pobj.load(fis);
       
      String USERNAME = pobj.getProperty("username");
      String PASSWORD = pobj.getProperty("password");

	}

}
