package com.ECFW.pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EngineersConnectLoginPage extends BasePage
{
	//for login 
		@FindBy(xpath="//input[@id='ecLoginEmailOrPhone']")
		private WebElement email;
		@FindBy(xpath="//input[@id='ecLoginPassword']")
		private WebElement password;
		@FindBy(xpath="//button[@id='loginBtn']")
		private WebElement loginbutton;
	//*******************************************************************
		//for registration 
		@FindBy(id="ecFirstName")
		private WebElement firstname;
		@FindBy(id="ecLastName")
		private WebElement lastname;
		@FindBy(id="ecSignupEmailOrPhone")
		private WebElement emailOrPhone;
		@FindBy(id="ecSignupPassword")
		private WebElement pass;
		@FindBy(xpath="(//label[@class='btn btn-primary ec-gender-btn-label'])[1]")
		private WebElement gender;
		@FindBy(id="signupBtn")
		private WebElement signUpButton;
		@FindBy(xpath="//div[contains(text(),'Email is already in use.')]")
		private WebElement emailAlreadyInUse;
	//*******************************************************************
		
		public EngineersConnectLoginPage(WebDriver driver)
		{
			super(driver);
			PageFactory.initElements(driver, this);
		}
		
	//*******************************************************************
		//for login
		public void setLogin(String user, String pass)
		{
			email.sendKeys(user);
			password.sendKeys(pass);
			loginbutton.click();
		}
		
	//*******************************************************************
		//for registration
		public void registrationPage(String first, String last, String email, String password)
		{
			firstname.sendKeys(first);
			lastname.sendKeys(last);
			emailOrPhone.sendKeys(email);
			pass.sendKeys(password);
			gender.click();
			signUpButton.click();
			emailAlreadyInUse.isDisplayed();
		}
}
