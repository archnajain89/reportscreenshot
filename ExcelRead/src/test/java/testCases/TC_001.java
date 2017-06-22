package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.markuputils.ExtentColor;
//import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utility.ExcelUtility;
import base.CreateDriver;


public class TC_001 extends CreateDriver 
{
	public static int tdata_norows;
	public static int tdata_nocolumns;
	public static Object[][] testcases_excel;
	public static Object[][] test_data;
	
	
	@Test(priority=1)
		public void testexcel() throws Exception 
		{

		//To read testdata from Excel
		test_data = ExcelUtility.getTableArray("D:\\data", "testdata.xlsx", "Sheet1");
		tdata_norows=ExcelUtility.totalRows();
		tdata_nocolumns=ExcelUtility.totalColumns();
		System.out.println("Number of rows IN testdata excel " + tdata_norows);
		System.out.println("Number of columns  IN testdata excel " + tdata_nocolumns);
		
		//To execute 'Y' test cases
		testcases_excel = ExcelUtility.getTableArray("D:\\data", "TestCases01.xlsx", "Sheet1");
		int tc_excelno_rows = ExcelUtility.totalRows();
		int tc_excelno_columns = ExcelUtility.totalColumns();

		System.out.println("Number of rows IN testexcel METHOD " + tc_excelno_rows);
		System.out.println("Number of columns  IN testexcel METHOD " + tc_excelno_columns);

		for (int i = 0; i < tc_excelno_rows; i++) 
		{
			for (int j = 0; j < tc_excelno_columns; j++) 
			{
				// System.out.println(data[i][j]);
				if (testcases_excel [i][j].equals("Y"))
				{
					//testexcel2(driver,i);
					System.out.println("This Test case will execute");
					String testcaseid=(String) testcases_excel [i][0];
					System.out.println(testcaseid);
					
					for(int k=0;k<tdata_norows;k++)
					{
						//Store testcase id from testdata excel
						String testcaseid_TD=(String) test_data[k][0];
						System.out.println(testcaseid_TD);
						
						//Store username in string
						String Username=(String)test_data[k][1];
						System.out.println(Username);
						
						//Store password in string
						String password=(String)test_data[k][2];
						System.out.println(password);
						
					if(testcaseid.equalsIgnoreCase(testcaseid_TD))
						{
							//Enter username
							Thread.sleep(2000);
							driver.findElement(By.xpath("//input[@id='username']")).sendKeys(Username);
							
							//Enter Password
							Thread.sleep(2000);
							driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
							
							/*//Record pass test cases in report.html
							ExtentTest test=r.startTest("Excel Test Cases");
							test.log(LogStatus.PASS, "TEST CASE PASSED");
							r.endTest(test);*/
							
							//Clear Username
							Thread.sleep(2000);
							driver.findElement(By.xpath("//input[@id='username']")).clear();
							
							//Clear Password
							Thread.sleep(2000);
							 driver.findElement(By.xpath("//input[@id='password']")).clear();
							 Thread.sleep(2000);
							// Click on Login button
							//driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
							 
				}
							
			}
		}
			}
}
		}

/*public static void testexcel2(WebDriver driver,int i) throws InterruptedException
{
	System.out.println("This Test case will execute");
	String testcaseid=(String) testcases_excel [i][0];
	System.out.println(testcaseid);
	
	for(int k=0;k<tdata_norows;k++)
	{
		//Store testcase id from testdata excel
		String testcaseid_TD=(String) test_data[k][0];
		System.out.println(testcaseid_TD);
		
		//Store username in string
		String Username=(String)test_data[k][1];
		System.out.println(Username);
		
		//Store password in string
		String password=(String)test_data[k][2];
		System.out.println(password);
		
	if(testcaseid.equalsIgnoreCase(testcaseid_TD))
		{
			//Enter username
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(Username);
			
			//Enter Password
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
			
			//Record pass test cases in report.html
			ExtentTest test=r.startTest("Excel Test Cases");
			test.log(LogStatus.PASS, "TEST CASE PASSED");
			r.endTest(test);
			
			//Clear Username
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='username']")).clear();
			
			//Clear Password
			Thread.sleep(2000);
			 driver.findElement(By.xpath("//input[@id='password']")).clear();
			 
			// Click on Login button
			//driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
			 
			
		}
		
		}*/
	}


/*@AfterTest
public void getResult(ITestResult result) throws IOException
{
    if(result.getStatus() == ITestResult.FAILURE)
    {
        String screenShotPath = Screenshot.GetScreenShot(driver);
        test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
        test.fail(result.getThrowable());
        test.fail("Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
    }
    else if(result.getStatus() == ITestResult.SUCCESS)
    {
        test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
    }
    else
    {
        test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
        test.skip(result.getThrowable());
    }
    r.flush();
	}*/



 
	/*@Test(dataProviderClass = LoginPage.class, dataProvider = "DP1"*//** ,dependsOnMethods*={* "testexcel"}*//*)
	public void verifyvalidlogin(String testCaseId, String username, String password) throws InterruptedException {
		System.out.println("you have provided username as::" + username);
		System.out.println("you have provided password as::" + password);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		Thread.sleep(1000);
		// Click on Login button
		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
		// driver.navigate().back();
		Thread.sleep(5000);
		// driver.findElement(By.xpath("//input[@id='username']")).clear();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//input[@id='password']")).clear();
		Thread.sleep(2000);
	}*/

	/*
	 * @Test(dataProviderClass=LoginPage.class,
	 * dataProvider="DP2",dependsOnMethods={"testexcel"}) public void
	 * verifyinvalidlogin(String username, String password) throws
	 * InterruptedException
	 * 
	 * {
	 * 
	 * Thread.sleep(1000);
	 * driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username
	 * ); Thread.sleep(1000);
	 * driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password
	 * ); Thread.sleep(1000);
	 * 
	 * //Click on Login button
	 * driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
	 * 
	 * 
	 * }
	 */

	/*
	 * ExtentTest t1=r.startTest("Dataprovider"); t1.log(LogStatus.PASS,
	 * "TEST CASE PASSED"); r.endTest(t1);
	 */
