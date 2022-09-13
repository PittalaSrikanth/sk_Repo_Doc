package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.CopyUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import testCases.BaseObject;

public class TestListners extends BaseObject implements ITestListener {

	public void onTestStart(ITestResult result) 
	{
		
		
	}

	public void onTestSuccess(ITestResult result)
	{
		
		
	}

	public void onTestFailure(ITestResult result) 
	{
		File dest = new File("./Screenshots/"+result.getName()+".png");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(source, dest);
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}		
		
	}

	public void onTestSkipped(ITestResult result)
	{
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
		
	}

	public void onStart(ITestContext context) 
	{
		
		
	}

	public void onFinish(ITestContext context) 
	{
		
		
	}

}
