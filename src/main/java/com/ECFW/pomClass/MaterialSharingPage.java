package com.ECFW.pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MaterialSharingPage extends BasePage
{
	@FindBy(xpath="//div[@class='list-group']//a[1]")
	private WebElement materialsharing;
	@FindBy(xpath="/html[1]/body[1]/section[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[5]/a[1]/span[1]")
			//"(//span[@style='margin-left:10px'])[1]")
	private WebElement downloadlink;
	@FindBy(xpath="//div[@class='list-group']//a[3]")
	private WebElement tutorials;
	@FindBy(xpath="//div[@class='list-group']//a[4]")
	private WebElement forums;
	
	
	
	public MaterialSharingPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void downloadPopupHandling()
	{
		materialsharing.click();
		downloadlink.click();
	}
	
	public void alertPopupHandling()
	{
		tutorials.click();
	}
	
	public void promptPopupHandling()
	{
		forums.click();
	}
}
