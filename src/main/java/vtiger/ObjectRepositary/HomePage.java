package vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilitiws.WebDriverUtility;

public class HomePage extends WebDriverUtility {


	@FindBy(linkText="Organizations")
	private WebElement OrganisationLink;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLink;
	
	@FindBy (linkText="Opportunities")
	private WebElement OpportunitiesLink;
	
	@FindBy (xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement AdminstratorImg;
	
	@FindBy (linkText="Sign Out")
	private WebElement signoutLink;
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getOrganisationLink()
	{
		return OrganisationLink;
	}
	
	public WebElement getContactsLink()
	{
		return ContactsLink;
	}
	
	public WebElement getOpportunitiesLink()
	{
		return OpportunitiesLink;
	}
	 
	public WebElement getAdminstratorImg()
	{
		return AdminstratorImg;
	}
	
	public WebElement getsignoutLink()
	{
		return signoutLink;
	}
	
	
	//business libraries
	
	
	public void clickOrganisationLink()
	{
		OrganisationLink.click();
	}
	
	public void clickContactsLink()
	{
		ContactsLink.click();
	}
	
	public void logOutofApp(WebDriver driver)
	{
		mouseHoverAction(driver, AdminstratorImg);
		signoutLink.click();
	}
	
	

}
