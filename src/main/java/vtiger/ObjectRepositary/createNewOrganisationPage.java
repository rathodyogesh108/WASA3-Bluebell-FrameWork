package vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilitiws.WebDriverUtility;

public class createNewOrganisationPage extends WebDriverUtility {

	//Declaration
	@FindBy(name="accountname")
	private WebElement orgnameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	//Initilisation
	
	public createNewOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgnameEdt() {
		return orgnameEdt;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getSavrBtn() {
		return saveBtn;
	}
	
	public void createOrganisation(String Orgname)
	{
		orgnameEdt.sendKeys(Orgname);
		saveBtn.click();
		
	}
	
	public void createOrganisation(String ORGS, String industryType)
	{
		orgnameEdt.sendKeys(ORGS);
		handleDropdown(industryDropdown, industryType);
		saveBtn.click();
		
	}
	
	
	
	

}
