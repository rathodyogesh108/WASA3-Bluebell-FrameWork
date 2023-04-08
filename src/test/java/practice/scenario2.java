package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class scenario2 {

	public static void main(String[] args) {
		
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		
		WebDriver driver=new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys("being huuman");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		String contactheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(contactheader.contains("being human"))
		{
			System.out.println(contactheader+"pass");
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
