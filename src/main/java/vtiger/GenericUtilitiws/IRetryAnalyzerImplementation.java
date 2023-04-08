package vtiger.GenericUtilitiws;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * this class provides implemnetation for itestanalyzer interface of testng
 * @author Yogesh
 *
 */

public class IRetryAnalyzerImplementation implements IRetryAnalyzer{
	
	int count=0;
	int retrycount=3;

	@Override
	public boolean retry(ITestResult result) {
		while(count<retrycount)
		{
			count++;
			return true;
		}
	
	return false;
	
	}

}
