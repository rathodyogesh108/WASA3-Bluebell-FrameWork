package vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement contactLookupImg;
	
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	

	public WebElement getContactLookupImg() {
		return contactLookupImg;
	}
	
	//Business Library
	/**
	 * This method will perform click action on Creat contact lookup image
	 */
	
	public void clickOncontactLookupImg()
	{
		contactLookupImg.click();
		
	}
	
	

}
