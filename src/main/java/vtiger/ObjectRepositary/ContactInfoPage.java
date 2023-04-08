package vtiger.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement ContacHeadertxt;

public ContactInfoPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getContacHeadertxt() {
	return ContacHeadertxt;
}



public  String Conheadertxt()
{
	return ContacHeadertxt.getText();
}
}
