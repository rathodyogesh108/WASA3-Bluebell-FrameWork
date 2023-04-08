package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	
	@Test(dataProvider="getdata")
	public void dataprovider(String phone, int price) 
	{
		System.out.println(phone+"---"+price);
		
	}
	
	
	@DataProvider
	public Object[][] getdata()
	{
		Object [][] data=new Object[3][2];
		
		data[0][0]="Samsung";
		data[0][1]=1200;
		
		data[1][0]="Iphone";
		data[1][1]=700;
		
		data[2][0]="Nokia";
		data[2][1]=2000;
		
		return data;
		
	}
	

}
