package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class scenario3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys("puma");
		WebElement ele = driver.findElement(By.name("industry"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.name("industry")).click();
		
		WebElement dropdown = driver.findElement(By.name("industry"));
		
		Select s=new Select(dropdown);
		Thread.sleep(2000);
		s.selectByIndex(4);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String contactheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactheader.contains("puma"))
		{
			System.out.println(contactheader+"pass");
		}
		else
		{
			System.out.println("fail");
		}
		WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(ele1).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		
		
		
		System.out.println("sign out is succesful");
		
		

	}

}
