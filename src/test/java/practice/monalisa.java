package practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;


public class monalisa {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions Options=new ChromeOptions();
		Options.addArguments("---remote-allow-origins=*");
		Options.addArguments("disable notification");
		DesiredCapabilities cp=new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, Options);
		Options.merge(cp);
		
		WebDriver driver=new ChromeDriver();
		//FirefoxDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

}
