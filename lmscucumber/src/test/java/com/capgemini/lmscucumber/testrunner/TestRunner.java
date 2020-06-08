package com.capgemini.lmscucumber.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\shahensha\\Desktop\\New folder\\project\\lmscucumber\\src\\test\\java\\com\\capgemini\\lmscucumber\\features\\adminBook.feature", glue = {
		"com.capgemini.lmscucumber.stepsdefination" }, dryRun = false,tags = {"@admin"}, plugin = { "pretty",
				"html:target/cucumber" }, monochrome = true)
public class TestRunner {
	
}
