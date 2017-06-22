package pages;
import org.testng.annotations.DataProvider;

import Utility.ExcelUtility;
import base.CreateDriver;

public class LoginPage extends CreateDriver
{

	//This test method declares that its data should be supplied by the Data Provider
		// "getdata" is the function name which is passing the data
	       // Number of columns should match the number of input parameters
	
	
	
	@DataProvider(name="DP1")
	public Object[][] getData() throws Exception
	{
		
		        Object[][] retObjArr=ExcelUtility.getTableArray("D:\\data","testdata.xlsx","Sheet1");
		        return(retObjArr);
		 

	}		
}