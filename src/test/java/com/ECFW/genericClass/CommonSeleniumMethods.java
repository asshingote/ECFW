package com.ECFW.genericClass;



import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;

public class CommonSeleniumMethods
{
		public void listBoxHandle(WebElement element,int index)
		{
			Select s=new Select(element);
			s.selectByIndex(index);
		}
		
		public void dropDowns(WebDriver driver,WebElement toElement)
		{
			Actions a=new Actions(driver);
			a.moveToElement(toElement).perform();
		}
		
		public void explicitWait(WebDriver driver,long timeOutInSeconds, String title)
		{
			WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.titleContains(title));
		}
		
		public void alertVerify(WebDriver driver,long timeOutInSeconds)
		{
			WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.alertIsPresent());
		}
		public void alertAccept(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		public void alertCancel(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		//sikuli
		public void downloadPopup(String PopupPath)
		{
			Screen s = new Screen();
			Pattern p = new Pattern(PopupPath);
			try 
			{
				s.click(p);
			} catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void assertAll()
		{
			SoftAssert soft = new SoftAssert();
			soft.assertAll();
		}
	}
