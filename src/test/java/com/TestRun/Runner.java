package com.TestRun;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./Features/",
		glue = "com.StepDefinition",
		dryRun = false,
		monochrome = true,
		plugin = {"pretty", "html:target/report.html"},
		tags = "@Sanity"
		)
public class Runner extends AbstractTestNGCucumberTests {

}
