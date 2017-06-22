package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;


import base.CreateDriver;



public class Screenshot extends CreateDriver
{
	
	public static String GetScreenShot(ITestResult result) throws IOException
	{
		
	String screenshotname1 = null;
	//Save screenshot
		try
		{
			File f1 =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    
			String filename =  new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

			File f2=new File("D://Screenshot//");
			
				
			//To create folder for saving screenshot
			if (!f2.exists()) 
			{
				f2.mkdir();
				System.out.println("File created " + f2);
		
			
			}
			
				f2=new File("D://Screenshot//"+filename+".png");
				FileUtils.copyFile(f1, f2);
				String screenshotName="D://Screenshot//"+filename+".png";
				System.out.println(screenshotName+" ScreenShot saved successfully!!!!!!!");
				
				//Reporter.log("<a href='"+ f2.getAbsolutePath()+"/selenium-reports/html/" + result.getName() + ".jpg'> <img src='"+ f2.getAbsolutePath()+"/selenium-reports/html/"+ result.getName() + ".jpg' height='100' width='100'/> </a>");
				//Reporter.log(f2.getAbsolutePath());	
				
				//Display the screenshot in testng report of index.html
				screenshotname1=("D:/Screenshot/"+filename+".png").toString();
				String filePath = screenshotname1.toString(); 
				String path = "<a href="+filePath+" alt="+screenshotname1+" height='200' width='200'/>"; 
				Reporter.log(path);
			
				
				/*//Display the screenshot in extent reports
				String image= test.addScreenCapture("screenshotName"); 
				test.log(LogStatus.FAIL, "verify logo of the application", image);*/

		}
		catch (Exception e) 
		{
			System.out.println("Failed to capture screenshot: "+e.getMessage());
		}
		return screenshotname1;
	
	}

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
		
}