package com.sg.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
		
		//features = {"src/test/resources/Feature/Login.feature","src/test/resources/Feature/Patient.feature"},
		features={"src/test/resources/Feature"},
		glue = {"com.sg.stepdefinitions","com.sg.base"},
		publish=true,
		monochrome = true,
		plugin = {"html:Report/index.html"}, //plugin = {"pretty"}
		dryRun=true,
		tags="@patient" // tags="not @invalid", tags="@valid or @invalid", tags="@valid and @lowpriority"
		)

@RunWith(Cucumber.class)
public class RunnerTest
{

}
