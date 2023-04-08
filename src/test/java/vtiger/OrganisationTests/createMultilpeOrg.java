package vtiger.OrganisationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.GenericUtilitiws.BaseClass;
import vtiger.ObjectRepositary.HomePage;
import vtiger.ObjectRepositary.OrganisationInfoPage;
import vtiger.ObjectRepositary.createNewOrganisationPage;
import vtiger.ObjectRepositary.organisationPage;

public class createMultilpeOrg extends BaseClass {
	
	@Test(dataProvider="getdata")
	public void MultipleOrg(String Org, String INDUSTRY)
	{
		String ORGNAME = Org+jUtil.getrandomNumber();
		
		HomePage hp=new HomePage(driver);
		hp.clickOrganisationLink();
		
		organisationPage op=new organisationPage(driver);
		op.clickOnCreateOrgImg();
		
		createNewOrganisationPage cnop=new createNewOrganisationPage(driver);
		cnop.createOrganisation(ORGNAME, INDUSTRY);
		
		OrganisationInfoPage oip=new OrganisationInfoPage(driver);
		String Orgheader = oip.getOrgHeader();
		Assert.assertTrue(Orgheader.contains(ORGNAME));
	}
	
	@DataProvider
	public Object[][] getdata() throws EncryptedDocumentException, IOException
	{
		Object[][] data = eUtil.createMultipleData("Multiple");
		return data;
	}

}
