package vtiger.ObjectRepositary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilitiws.WebDriverUtility;

public class createNewContactPage  extends WebDriverUtility{

	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	  @FindBy(xpath="//input[@title='Save [Alt+S]']")
	  private WebElement saveBtn;
	  
	  @FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
	  private WebElement orgLookupImg;
	  
	  
	  @FindBy(name="search_text")
	  private WebElement searchEdt;
	  
	  @FindBy(name="search")
	  private WebElement searchBtn;
	  
	  //intilization
	  public createNewContactPage(WebDriver driver)
	  {
		  PageFactory.initElements(driver, this);
	  }
	  
	//  Uitilization

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOrgLookupImg() {
		return orgLookupImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
		
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	/**
	 * This method will help to select oragnisation from orglookup icon
	 * @param driver
	 * @param Lastname
	 * @param Orgname
	 */
	  
	public void CreateNewContact(WebDriver driver,String Lastname,String ORGS)
	{
		lastNameEdt.sendKeys(Lastname);
		orgLookupImg.click();
		switchToWindow(driver,"Accounts");
		searchEdt.sendKeys(ORGS);
		searchBtn.click();
		driver.findElement(By.xpath(" //a[text()='"+ORGS+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
		
		
		
		
	}
	  
}
