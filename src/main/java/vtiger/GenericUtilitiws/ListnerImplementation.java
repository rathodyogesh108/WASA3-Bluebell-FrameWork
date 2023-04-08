package vtiger.GenericUtilitiws;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * This class contains implementation for ITestListeners interface of testng
 * @author Yogesh
 *
 */
public class ListnerImplementation implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"....execution started");
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"...execution succesful");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		javaUtility jUtil=new javaUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"...execution Failed");
		String ScreenshotName = methodName+"-"+jUtil.getSystemDateInFormat();
		try {
			wUtil.takeScreenShot(BaseClass.sDriver, ScreenshotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"...execution Skipped");
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("Suite Execution Started");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("Suite Execution Finished");
	
	}
	

}
