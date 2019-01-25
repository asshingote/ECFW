package com.ECFW.testClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ECFW.genericClass.AutoConstant;
import com.ECFW.genericClass.CommonSeleniumMethods;
import com.ECFW.genericClass.ExcelReader;
import com.ECFW.pomClass.EngineersConnectLoginPage;


public class ExcelReaderRegitrationTest extends BaseTest implements AutoConstant
{
	@DataProvider(name="user")
	public Object[][] provideData()
	{
		//logger = extent.createTest("registration");
		ExcelReader er = new ExcelReader(RegistrationPage);
		int rowCount= er.fetchRowCount("Sheet1");
		int cellcount = er.fetchCellCount("Sheet1");
		Object[][] excelColumnData= new Object[rowCount][cellcount];
		int ci=0;
		for (int i = 1; i <=rowCount; i++,ci++) 
		{
			int cj=0;
			for (int j = 0; j <cellcount; j++,cj++) 
			{
				excelColumnData[ci][cj]=er.getTestData("Sheet1",i, j);
			}
		}
		return excelColumnData;
	}
	
	@Test(dataProvider="user")
	public void registration(String first, String last, String email, String password)
	{
		logger = extent.createTest("registration");
		//RegistrationPage rv = new RegistrationPage(driver);
		EngineersConnectLoginPage rv = new EngineersConnectLoginPage(driver);
		rv.registrationPage(first, last, email, password);
		CommonSeleniumMethods cs = new CommonSeleniumMethods();
		cs.assertAll();
	}
}
