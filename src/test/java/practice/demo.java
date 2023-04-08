package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class demo {

	public static void main(String[] args) throws FileNotFoundException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		
		//step2 login to the application
		//driver.findElement(By.name("user_name")).sendKeys("admin");
		//driver.findElement(By.name("user_password")).sendKeys("admin");
		//driver.findElement(By.id("submitButton")).click();
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step3:navigate to contact link
		driver.findElement(By.linkText("Contacts")).click();
		
		//step4:click on create contact lookup image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//step5:create contact with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("rathod");
		
		//step6:save and verify
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String contactheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactheader.contains("rathod"))
		{
			System.out.println(contactheader+"..pass..");
		}
		else
		{
			System.out.println("fail");
		}
		
		//step7:logout of application
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("sign out succesful");

	}

}
