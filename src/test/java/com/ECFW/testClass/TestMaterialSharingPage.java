package com.ECFW.testClass;

import org.testng.annotations.Test;

import com.ECFW.genericClass.CommonSeleniumMethods;
import com.ECFW.genericClass.ExcelHandling;
import com.ECFW.pomClass.BasePage;
import com.ECFW.pomClass.EngineersConnectLoginPage;
import com.ECFW.pomClass.MaterialSharingPage;


public class TestMaterialSharingPage extends BaseTest
{
	@Test(priority=3)
	public void downloadPopup() throws InterruptedException
	{
		logger = extent.createTest("downloadPopup");
		String user = ExcelHandling.excelRead("Sheet1", 1, 0);
		String pass = ExcelHandling.excelRead("Sheet1", 1, 1);
		EngineersConnectLoginPage rv=new EngineersConnectLoginPage(driver);
		rv.setLogin(user,pass);
		
		MaterialSharingPage mp=new MaterialSharingPage(driver);
		mp.downloadPopupHandling();
		
		CommonSeleniumMethods cm=new CommonSeleniumMethods();
		cm.downloadPopup(dPopupPath);
		Thread.sleep(10000);
		cm.downloadPopup(dPopupCancelButton);
		Thread.sleep(10000);
		BasePage bp = new BasePage(driver);
		bp.logoutListClick();
		bp.logoutButton();	
		//cm.alertAccept(driver);
		
		//cm.assertAll();
	}
	@Test(priority=1)
	public void alertHandle()
	{
		logger = extent.createTest("alertHandle");
		String user = ExcelHandling.excelRead("Sheet1", 1, 0);
		String pass = ExcelHandling.excelRead("Sheet1", 1, 1);
		EngineersConnectLoginPage rv=new EngineersConnectLoginPage(driver);
		rv.setLogin(user,pass);
		
		MaterialSharingPage mp=new MaterialSharingPage(driver);
		CommonSeleniumMethods cm=new CommonSeleniumMethods();
		mp.alertPopupHandling();
		cm.alertVerify(driver, 10);
		cm.alertAccept(driver);
		
		BasePage bp = new BasePage(driver);
		bp.logoutListClick();
		bp.logoutButton();
		cm.assertAll();
	}
	@Test(priority=2)
	public void PromptHandle()
	{
		logger = extent.createTest("PromptHandle");
		String user = ExcelHandling.excelRead("Sheet1", 1, 0);
		String pass = ExcelHandling.excelRead("Sheet1", 1, 1);
		EngineersConnectLoginPage rv=new EngineersConnectLoginPage(driver);
		rv.setLogin(user,pass);
		
		MaterialSharingPage mp=new MaterialSharingPage(driver);
		CommonSeleniumMethods cm=new CommonSeleniumMethods();
		mp.promptPopupHandling();
		cm.alertVerify(driver, 10);
		cm.alertAccept(driver);
		
		BasePage bp = new BasePage(driver);
		bp.logoutListClick();
		bp.logoutButton();
		cm.assertAll();
	}
}
