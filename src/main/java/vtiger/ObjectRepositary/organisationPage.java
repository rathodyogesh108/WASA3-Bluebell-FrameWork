package vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organisationPage {

	//declaration
		
		@FindBy(xpath = "//img[@alt='Create Organization...']")
		private WebElement CreateOrgLookupImg;
		
		
		//Initilization
		
		public organisationPage(WebDriver driver) {
			
			PageFactory.initElements(driver, this);
		}
		
		//Utilization
		
		
		public WebElement getCreateOrgLookupImg() {
			return CreateOrgLookupImg;
		}
		
		
		//Businesss Library
		
		/**
		 * This method will perform click operation on organisation image
		 */
		
		public void clickOnCreateOrgImg()
		{
			CreateOrgLookupImg.click();
		}

	
		
		
		

	}


