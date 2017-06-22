package com.extentreports.listener;

import java.io.File;
import java.io.IOException;
//import java.util.Calendar;
//import java.util.Date;
import java.util.List;
import java.util.Map;
 
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;
 
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Screenshot;
 
public class ExtentReporterNG extends Screenshot implements IReporter,ITestListener {
    private ExtentReports extent;
 
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) 
    {
        extent = new ExtentReports(outputDirectory + File.separator + "ExtentReportsTestNG.html", true);
 
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
 
            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
 
                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
            }
        }
 
        extent.flush();
        extent.close();
    }
 
    private void buildTestNodes(IResultMap tests, LogStatus status) {
        ExtentTest test;
 
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.startTest(result.getMethod().getMethodName());
 
            //   test.getTest().getStartedTime() = getTime(result.getStartMillis());
              //  test.getTest().endedTime = getTime(result.getEndMillis());
 
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);
 
                String message = "Test " + status.toString().toLowerCase() + "ed";
 
                if (result.getThrowable() != null)
                    message = result.getThrowable().getMessage();
 
                test.log(status, message);
 
                extent.endTest(test);
            }
        }
    }


	@Override
	public void onTestFailure(ITestResult result) 
	{
		try 
		{
			Reporter.setCurrentTestResult(result);
			
			String s=result.getName();
			System.out.println("On test failure of " +s);
			Screenshot.GetScreenShot(result);
			
			
			Reporter.setCurrentTestResult(result); 
		    Reporter.log("<br> <img src=.\\screenshots\\Untitled.png /> <br>");
		    Reporter.setCurrentTestResult(null); 
		    
			/*//Display the screenshot in extent reports
			String image= test.addScreenCapture("screenshotName"); 
			test.log(LogStatus.FAIL, "verify logo of the application", image);*/
			
        } 
		catch (Exception e) 
		{
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
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

	 
   /* private Date getTime(long millis)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();        
    }*/
}