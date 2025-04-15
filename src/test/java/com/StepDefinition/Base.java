package com.StepDefinition;

import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.PageObjects.LoginPage;

public class Base {
	
	public WebDriver wd;
	public LoginPage lp;
	public Logger log;
	public Properties p;

}
