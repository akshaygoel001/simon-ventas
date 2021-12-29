package CustomListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import TestBase.VentasBase;

public class TestListener extends VentasBase implements ITestListener{

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println(result.getMethod().getMethodName()+" is Passed");
		
		
	}

	
	public void onTestFailure(ITestResult result) {
		
		
		String test_name=result.getMethod().getMethodName();
		
        Date d=new Date();
		SimpleDateFormat ft =new SimpleDateFormat ("dd_mm_yyyy_hh_mm_ss");

		
		String date=ft.format(d);
		
		
		String failed_sc_folder=".\\Screenshots\\Failed";
		File source_file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source_file, new File(failed_sc_folder+"\\"+"_"+test_name+date+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
