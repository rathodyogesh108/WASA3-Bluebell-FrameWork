package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class youtube {

	public static void main(String[] args) {
	   WebDriver driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://www.youtube.com/");
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
	   
	   driver.findElement(By.xpath("(//yt-icon[@class='style-scope ytd-searchbox'])[2]")).click();
	   driver.findElement(By.id("search")).sendKeys("shree krishna");
	   driver.findElement(By.xpath("//div[@class='ytp-inline-preview-scrim ytp-inline-preview-scrim-clear']")).click();

	}

}
