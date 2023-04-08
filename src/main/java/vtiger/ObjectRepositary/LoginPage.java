package vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Yogesh
 *
 */

public class LoginPage {
	//rule1:create pom classes for every web page
	//rule2:identify the web elements with @FindBy, @FindAll, @FindBys
	
	@FindBy(name="user_name")
	private WebElement UsernameEdt;
	
	@FindAll({@FindBy(name="user_password"), @FindBy(xpath="//input[@type='password']")})
	private WebElement PasswordEdt;
	
	@FindBy(id="submitButton")
	private WebElement LoginBtn;
	
	//rule no 3:Create constructor to initilize these web elements
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//rule:4 provide getters to access these elements

	public WebElement getUsernameEdt() {
		return UsernameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}
		
	
	public void loginToapp(String Username, String Password)
	{
		UsernameEdt.sendKeys("admin");
		PasswordEdt.sendKeys("admin");
		LoginBtn.click();
		
	}
	
	
	

}
