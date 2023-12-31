package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LoginPage 
{
	WebDriver driver;
	Properties properties=new Properties();
	FileInputStream ip;
	GeneralUtility generalutility;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement userNameField;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement passwordField;
	
	@FindBy(xpath="//input[@id='remember']")
	WebElement rememberMeCheckBox;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertMsg;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement signInButton;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		try
		{
			ip=new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void enterUserName(String userName)
	{
		userNameField.sendKeys(userName);
	}
	
	public void enterPassword(String password)
	{
		passwordField.sendKeys(password);
	}
	
	public void clickCheckbox()
	{
		rememberMeCheckBox.click();
	}
	
	public void clickSignInButton()
	{
		signInButton.click();
	}
	
	public void login(String userName,String password)
	{
		enterUserName(userName);
		enterPassword(password);
		clickSignInButton();
	}
	
	public void login()
	{
		String userName=properties.getProperty("username");
		String password=properties.getProperty("password");
		login(userName,password);
	}
	
	public boolean checkErrorMsg(String expectedErrorMsg)
	{
		generalutility=new GeneralUtility(driver);
		return generalutility.isWordPresent(alertMsg,expectedErrorMsg);
	}
}
