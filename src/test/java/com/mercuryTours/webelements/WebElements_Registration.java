package com.mercuryTours.webelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebElements_Registration {

	@FindBy(xpath = "*//a[text()='REGISTER']")
	public static WebElement register_link;

	@FindBy(name = "firstName")
	public static WebElement firstName_textbox;

	@FindBy(name = "lastName")
	public static WebElement lastName_textbox;

	@FindBy(name = "phone")
	public static WebElement phone_textbox;

	@FindBy(id = "userName")
	public static WebElement userName_textbox;

	@FindBy(name = "address1")
	public static WebElement address1_textbox;

	@FindBy(name = "address2")
	public static WebElement address2_textbox;

	@FindBy(name = "city")
	public static WebElement city_textbox;

	@FindBy(name = "state")
	public static WebElement state_textbox;


}
