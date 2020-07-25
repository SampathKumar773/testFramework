package com.mercuryTours.webelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebElements_Home {

	@FindBy(xpath = "*//a[text()='Home']")
	public static WebElement homePage_validationPoint;

	
}
