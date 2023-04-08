package practice;

import org.testng.annotations.Test;

public class TestNGPractice22 {
	
	@Test(invocationCount=2)
	
	public void createuser()
	{
		System.out.println("create");
	}
	
	@Test( dependsOnMethods="deleteuser")
	public void updateuser()
	{
		System.out.println("update");
		
	}
	
	@Test(invocationCount=5, dependsOnMethods="createuser")
	public void deleteuser()
	{
		System.out.println("delete");
	}

}
