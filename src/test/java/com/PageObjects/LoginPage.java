package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver wd;

	public LoginPage(WebDriver wd)
	{
		this.wd=wd;
		PageFactory.initElements(wd, this);
	}
	
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement txt_email;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement txt_password;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement btn_login;
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	WebElement dropdown;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement btn_logout;

	
	public void enterEmail(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void enterPassword(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	
	public void clickOnLoginButton()
	{
		btn_login.click();
	}
	
	public void clickOnLogOutButton()
	{
		dropdown.click();
		btn_logout.click();
	}
}
