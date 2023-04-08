package practice;

import java.io.IOException;

import vtiger.GenericUtilitiws.ExcelFileUtility;
import vtiger.GenericUtilitiws.PropertyFileUtility;
import vtiger.GenericUtilitiws.javaUtility;

public class GenricUtilityPractice {

	public static void main(String[] args) throws IOException {
		PropertyFileUtility pUtil=new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("username");
		System.out.println(URL);

		
		ExcelFileUtility eUtil=new ExcelFileUtility();
		String value = eUtil.readDataFromExcel("Sheet2", 4, 2);
		System.out.println(value);
		
		System.out.println(eUtil.getRowcount("Sheet2"));
		
		eUtil.writeDataIntoExcel("Sheet2", 4, 6, "spiderman");
		
	javaUtility jUtil=new javaUtility();
	System.out.println(jUtil.getSystemDateInFormat());
	}

}
