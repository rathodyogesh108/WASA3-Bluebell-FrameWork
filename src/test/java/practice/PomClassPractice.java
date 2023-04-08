package practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepositary.HomePage;
import vtiger.ObjectRepositary.LoginPage;

public class PomClassPractice {

	public static void main(String[] args) {
		
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		
		 WebDriverManager.chromedriver();
		 WebDriver driver=new ChromeDriver(co);
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("http://localhost:8888/");
		 
		 LoginPage lp=new LoginPage(driver);
	//	 lp.getUsernameEdt().sendKeys("admin");
		// lp.getPasswordEdt().sendKeys("admin");
		 //lp.getLoginBtn().click();
       
		 
		 lp.loginToapp("admin", "admin");
		 
		 HomePage hp=new HomePage(driver);
		 hp.clickOrganisationLink();
		 
		 hp.clickContactsLink();
		 
		hp.logOutofApp(driver);
		
	}

}
