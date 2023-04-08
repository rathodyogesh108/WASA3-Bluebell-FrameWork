package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {
	
	@Test(retryAnalyzer=vtiger.GenericUtilitiws.IRetryAnalyzerImplementation.class)
	public void practice()
	{
		Assert.fail();
		System.out.println("hi");
	}

}
