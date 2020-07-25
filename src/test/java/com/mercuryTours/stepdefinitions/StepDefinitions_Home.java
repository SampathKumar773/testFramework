package com.mercuryTours.stepdefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import com.mercuryTours.utils.Utils;
import com.mercuryTours.webelements.WebElements_Home;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefinitions_Home extends Utils {

	public WebElements_Home webelements_home;

	public StepDefinitions_Home() throws IOException {
		super();
	}

	@After
	public void tearDown(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) Utils.driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		kill();
	}

	@Given("^the user hits the Mercury Tours application (.+)$")
	public void the_user_hits_the_mercury_tours_application(String url) throws Throwable {
		OpenBrowser(url);
		webelements_home = PageFactory.initElements(driver, WebElements_Home.class);
	}

	@Then("^the user should see the Home page$")
	public void the_user_should_see_the_home_page() throws Throwable {
		isElementDisplayed(WebElements_Home.homePage_validationPoint);
		isElementEnabled(WebElements_Home.homePage_validationPoint);

		String titleOfHomePage = getTitle();
		Assert.assertEquals(titleOfHomePage, "Welcome: Mercury Tours");
	}
}
