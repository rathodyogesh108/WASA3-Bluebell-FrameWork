package vtiger.OrganisationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericUtilitiws.BaseClass;
import vtiger.ObjectRepositary.HomePage;
import vtiger.ObjectRepositary.LoginPage;
import vtiger.ObjectRepositary.OrganisationInfoPage;
import vtiger.ObjectRepositary.createNewOrganisationPage;
import vtiger.ObjectRepositary.organisationPage;

public class createOrganisationTest extends BaseClass {
	
	@Test(groups="SmokeSuite")
	
	public void createOrgTest() throws EncryptedDocumentException, IOException
	{
		String orgname = eUtil.readDataFromExcel("organisation", 4, 2)+jUtil.getrandomNumber();
		//String  itd= eUtil.readDataFromExcel("organisation", 4, 3);
		
		
		HomePage hp=new HomePage(driver);
		hp.clickOrganisationLink();
		
		organisationPage op=new organisationPage(driver);
		op.clickOnCreateOrgImg();
		
		createNewOrganisationPage  cop=new createNewOrganisationPage(driver);
		cop.createOrganisation(orgname);
		
		OrganisationInfoPage oip=new OrganisationInfoPage(driver);
		String OrgHeader = oip.getOrgHeader();
		Assert.assertTrue(OrgHeader.contains(orgname));
		
	}
	
}
