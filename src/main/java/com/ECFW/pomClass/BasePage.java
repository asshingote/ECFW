package com.ECFW.pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage 
{
	@FindBy(id="homeTitle")
	private WebElement home;
	@FindBy(id="friendsTitle")
	private WebElement friends;
	@FindBy(xpath="(//a[@class='dropdown-toggle'])[1]")
	private WebElement notification;
	@FindBy(id="chatsTitle")
	private WebElement chat;
	@FindBy(id="materialsShareTitle")
	private WebElement materialshare;
	@FindBy(id="placementsTitle")
	private WebElement placement;
	@FindBy(xpath="//div[contains(text(),'My Profile')]")
	private WebElement myprofile;
	@FindBy(xpath="//img[@id='ec_main_navbar_dp']")
	private WebElement logoutList;
	@FindBy(xpath="//a[@onclick='unsetlog();']")
	private WebElement logoutbutton;
	
	
	
	
	public BasePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void homeTitleClick()
	{
		home.click();
	}
	public void friendsTitleClick()
	{
		friends.click();
	}
	public void notificationTitleClick()
	{
		notification.click();
	}
	public void chatsTitleClick()
	{
		chat.click();
	}
	public void placementsTitleClick()
	{
		placement.click();
	}
	public void myprofileTitleClick()
	{
		myprofile.click();
	}
	public void logoutListClick()
	{
		logoutList.click();
	}
	public void logoutButton()
	{
		logoutbutton.click();
	}
}
