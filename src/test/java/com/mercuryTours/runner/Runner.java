package com.mercuryTours.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/java/features/Home.feature",
				 plugin = { "pretty", "html:target/default-html-report", "json:target/default-json-report/cucumber.json" }, 
				 tags = {"@TC01"}, 
				 monochrome = true,
				 glue = "com.mercuryTours.stepdefinitions") 
public class Runner {
    
}