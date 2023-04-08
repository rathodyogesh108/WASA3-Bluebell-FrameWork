package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class scenario4 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys("nike");
		WebElement ele = driver.findElement(By.name("industry"));
		Actions p=new Actions(driver);
		p.moveToElement(ele).perform();
		driver.findElement(By.name("industry")).click();
		
		WebElement dropdown = driver.findElement(By.name("industry"));
		Select s=new Select(dropdown);
		s.selectByIndex(10);
       
		
		WebElement ele1 = driver.findElement(By.name("accounttype"));
		Actions m=new Actions(driver);
		m.moveToElement(ele1).perform();
		driver.findElement(By.name("accounttype")).click();
		
		
		WebElement drop = driver.findElement(By.name("accounttype"));
		Select s1=new Select(drop);
		s1.selectByIndex(3);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String man = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(man.contains("nike"))
		{
			System.out.println(man+"...pass..");
		}
		else
		{
			System.out.println("fail");
		}
		WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions k=new Actions(driver);
		k.moveToElement(ele2).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("sign out is succesful");
	}

}
