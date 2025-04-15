package com.StepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.PageObjects.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef extends Base {
	
	@Before
	public void setup() throws IOException {
		
		log = LogManager.getLogger(this.getClass());
		
		p = new Properties();
		FileInputStream fis = new FileInputStream("./config.properties");
		p.load(fis);
		
		
		log.info("Launching Browser");
		if(p.getProperty("browser").equals("chrome")) {
			wd = new ChromeDriver();
		}
		else if(p.getProperty("browser").equals("edge")) {
			wd = new EdgeDriver();
		}
		else if(p.getProperty("browser").equals("firefox")) {
			wd = new FirefoxDriver();
		}
		else
			System.out.println("Select proper browser");
		
		wd.manage().window().maximize();
	}
	
	@Given("Launch the browser")
	public void launch_the_browser() {
		
		lp = new LoginPage(wd);
	}

	@When("Open URL as {string}")
	public void open_url_as(String url) throws InterruptedException {
		log.info("Opening URL");
	    wd.get(url);
	    Thread.sleep(5000);
	}

	@When("Enter username as {string} and password as {string}")
	public void enter_username_as_and_password_as(String uname, String pass) {
		log.info("Entering the credentials");
	    lp.enterEmail(uname);
	    lp.enterPassword(pass);
	}

	@When("Click login button")
	public void click_login_button() {
		log.info("Clicked login button");
		lp.clickOnLoginButton();
	}

	@Then("Verify title as {string}")
	public void verify_title_as(String Title) {
		log.info("Validation");
	    String title = wd.getTitle();
	    if(title.equals(Title)) {
	    	Assert.assertTrue(true);
	    }
	    else {
	    	Assert.assertTrue(false);
	    }
	}

	@When("Click logout button")
	public void click_logout_button() throws InterruptedException {
		log.info("Clicked logout button");
		Thread.sleep(2000);
	    lp.clickOnLogOutButton();
	}

	@Then("Close the browser")
	public void close_the_browser() throws InterruptedException {
		log.info("Closing the browser");
		Thread.sleep(2000);
		wd.close(); 
	}
	
	@After
	public void teardown(Scenario s) {
		if(s.isFailed()==true) {
			log.info("Failed Screenshots");
			TakesScreenshot ts = (TakesScreenshot) wd;
			File sf =  ts.getScreenshotAs(OutputType.FILE);
			File df = new File("./screenshot/failed.png");
			sf.renameTo(df);
		}
		wd.quit();
	}


}
