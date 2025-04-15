package com.TestRun;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./Features/",
		glue = "com.StepDefinition",
		dryRun = false,
		monochrome = true,
		plugin = {"pretty", "html:target/report.html"},
		tags = "@Sanity"
		)
public class Runner {

}
