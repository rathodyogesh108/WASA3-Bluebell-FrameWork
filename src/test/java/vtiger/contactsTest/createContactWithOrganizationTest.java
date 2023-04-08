package vtiger.contactsTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilitiws.BaseClass;
import vtiger.GenericUtilitiws.ExcelFileUtility;
import vtiger.GenericUtilitiws.PropertyFileUtility;
import vtiger.GenericUtilitiws.WebDriverUtility;
import vtiger.GenericUtilitiws.javaUtility;
import vtiger.ObjectRepositary.ContactInfoPage;
import vtiger.ObjectRepositary.ContactPage;
import vtiger.ObjectRepositary.HomePage;
import vtiger.ObjectRepositary.LoginPage;
import vtiger.ObjectRepositary.OrganisationInfoPage;
import vtiger.ObjectRepositary.createNewContactPage;
import vtiger.ObjectRepositary.createNewOrganisationPage;
import vtiger.ObjectRepositary.organisationPage;

@Listeners(vtiger.GenericUtilitiws.ListnerImplementation.class)

public class createContactWithOrganizationTest extends BaseClass {

	@Test(groups="SmokeSuite")
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException {
		
		
		
		String ORGS= eUtil.readDataFromExcel("Sheet2", 4, 2)+jUtil.getrandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Sheet2", 4, 3);
		
		
		//Click on Organisation link
		HomePage hp=new HomePage(driver);
		hp.clickOrganisationLink();
		
		//click on create orgimage
		organisationPage op=new organisationPage(driver);
		op.clickOnCreateOrgImg();
		Reporter.log("click on create orgimg is succesful");
		
		//create new organisation
		createNewOrganisationPage cnop=new createNewOrganisationPage(driver);
		cnop.createOrganisation(ORGS);
		Reporter.log("new org create is succesful",true);
		
		//validate 
		OrganisationInfoPage oip=new OrganisationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
     	Assert.assertTrue(orgHeader.contains(ORGS));
     	Reporter.log("succesful");
		
		//navigate to contact
		hp.clickContactsLink();
		
		ContactPage cp=new ContactPage(driver);
		cp.clickOncontactLookupImg();
		
		createNewContactPage cncp=new createNewContactPage(driver);
		cncp.CreateNewContact(driver, LASTNAME, ORGS);
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		String contacheader = cip.Conheadertxt();
		
		Assert.assertTrue(contacheader.contains(LASTNAME));
		
		
	}
@Test(groups="RegressionSuite")
	
	public void demoscript()
	{
		System.out.println("demo");
		Assert.fail();
	}
	@Test

	public void regional()
	{
		System.out.println("regional regression");
	}
	
	
} 
