package com.cs.arris.Listeners;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.cs.arris.Base.ParentClass;
import com.cs.arris.Reports.ExtentReport;
import com.cs.arris.Utilities.TestUtils;

public class TestListener implements ITestListener{
	
	TestUtils utils = new TestUtils();
	ParentClass base = new ParentClass();

	public void onTestStart(ITestResult result) {
		ExtentReport.startTest(result.getName(), result.getMethod().getDescription())
		.assignCategory(base.getPlatformName() + "_" + base.getDeviceName())
		.assignAuthor("Prabhu Rajarathinam");
	}

	public void onTestSuccess(ITestResult result) {
		ExtentReport.getTest().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		ExtentReport.getTest().log(Status.FAIL, "Test Failed");
		base.takeScreenshot(result.getName(), result);
		if(result.getThrowable() != null) {
			  StringWriter sw = new StringWriter();
			  PrintWriter pw = new PrintWriter(sw);
			  result.getThrowable().printStackTrace(pw);
			  utils.log().error(sw.toString());	
		}
		try {
			ExtentReport.failTest(result.getName(), result.getMethod().getDescription())
			.addScreenCaptureFromPath(base.ssFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		ExtentReport.getTest().log(Status.SKIP, "Test Skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		ExtentReport.getReporter().flush();	
		
	}

}
