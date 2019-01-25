package com.ECFW.testClass;



import org.testng.annotations.DataProvider ;
import org.testng.annotations.Test;

import com.ECFW.genericClass.AutoConstant;
import com.ECFW.genericClass.CommonSeleniumMethods;
import com.ECFW.genericClass.ExcelReader;
import com.ECFW.pomClass.BasePage;
import com.ECFW.pomClass.EngineersConnectLoginPage;


public class TestEngineersConnectLogin extends BaseTest implements AutoConstant
{
	@DataProvider(name="user")
	public Object[][] provideData()
	{
		ExcelReader er = new ExcelReader(EXCEL_PATH);
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
	public void engineersConnectLoginTest(String user,String pass)
	{
		logger = extent.createTest("engineersConnectLoginTest");
		EngineersConnectLoginPage rv = new EngineersConnectLoginPage(driver);
		rv.setLogin(user, pass);
		BasePage bp = new BasePage(driver);
		CommonSeleniumMethods cs = new CommonSeleniumMethods();
		cs.explicitWait(driver, 10, "Home");
		String str= driver.getTitle();
		if(str.contains("Home"))
		{
			bp.logoutListClick();
			bp.logoutButton();
		}
		cs.assertAll();
	}
}

