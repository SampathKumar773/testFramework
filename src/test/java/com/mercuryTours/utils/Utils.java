package com.mercuryTours.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	public static WebDriver driver;
	public static Properties spectrum;

	public Utils() throws IOException {
		spectrum = new Properties();
		FileInputStream specturmFile = new FileInputStream("./src/test/java/mercuryTours.properties");
		spectrum.load(specturmFile);
	}

	public static WebDriver OpenBrowser(String url) throws Exception {
		File chromeDriver = new File(spectrum.getProperty("chromeDriver"));
		System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;

	}

	/**
	 * 
	 * This method is used to mouse over any given element
	 * 
	 **/
	public static void mouseOver(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	/**
	 * 
	 * This method is used to get the title of the any given page
	 * 
	 **/
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	/**
	 * 
	 * This method is used to check if the given element is displayed in the page
	 * 
	 **/
	public static boolean isElementDisplayed(WebElement element) {
		boolean result = element.isDisplayed();
		System.out.println(result);
		return result;
	}

	/**
	 * 
	 * This method is used to check if the given element is selected in the page
	 * 
	 **/
	public static boolean isElementSelected(WebElement element) {
		boolean result = element.isSelected();
		System.out.println(result);
		return result;
	}

	/**
	 * 
	 * This method is used to check if the given element is enabled in the page
	 * 
	 **/
	public static boolean isElementEnabled(WebElement element) {
		boolean result = element.isEnabled();
		System.out.println(result);
		return result;
	}

	/**
	 * 
	 * This method is used to get the location of any given element
	 * 
	 **/
	public static Point locationOfElement(WebElement element) {
		Point location = element.getLocation();
		return location;
	}

	/**
	 * 
	 * This method is used to switch to any alert
	 * 
	 **/
	public static Alert switchToAlert(WebElement element) {
		Alert alert = switchToAlert(element);
		return alert;
	}

	/**
	 * 
	 * This method is used to tell the web driver to wait for certain amount time
	 * before it throws a "No Such Element" exception
	 * 
	 **/
	public static void implicitWait(int TimeOut) {
		driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
	}

	/**
	 * 
	 * This method is used to tell the web driver to wait for visibility of any
	 * given element
	 * 
	 **/
	public static void waitForVisibilityOfElement(WebDriver driver, int timeInSeconds, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * 
	 * This method is used to tell the web driver to wait for visibility of any
	 * alert
	 * 
	 **/
	public static void waitForAlert(WebDriver driver, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * 
	 * This method is used to tell the web driver to wait until the expected element
	 * to be invisible
	 * 
	 **/
	public static void waitForInvisibilityOfelement(WebDriver driver, int timeInSeconds, WebElement element,
			By locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	/**
	 * 
	 * This method is used to tell the web driver to wait until the expected element
	 * with specific text to be invisible
	 * 
	 **/
	public static void waitForInvisibilityOfelementWithText(WebDriver driver, int timeInSeconds, WebElement element,
			String text, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
	}

	/**
	 * 
	 * This method is used to tell the web driver to wait until all the expected
	 * elements are presence in the page
	 * 
	 **/
	public static void waitForPresenceOfAllElementsLocated(WebDriver driver, int timeInSeconds, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	/**
	 * 
	 * This method is used to tell the web driver to wait until the expected text of
	 * any element to be present
	 * 
	 **/
	public static void waitForTextTobePresent(WebDriver driver, WebElement element, int timeInSeconds, String text) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	/**
	 * 
	 * This method is used to tell the web driver to wait for the expected title of
	 * the pages
	 * 
	 **/
	public static void waitForTitle(WebDriver driver, int timeInSeconds, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.titleIs(title));
	}

	/**
	 * 
	 * This method is used to tell the web driver to wait for the required text is
	 * present in the title of the page
	 * 
	 **/
	public static void waitForTitleContains(WebDriver driver, int timeInSeconds, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.titleContains(title));
	}

	/**
	 * 
	 * This method is used to get the URL of currently opened page
	 * 
	 **/
	public static String getURL() {
		String url = driver.getCurrentUrl();
		return url;
	}

	/**
	 * 
	 * This method is used to generate a random alpha numeric string
	 * 
	 **/
	public static String createRandomString_AlphaNumeric(int count) {
		String randomString = RandomStringUtils.randomAlphanumeric(count);
		return randomString;
	}

	/**
	 * 
	 * This method is used to generate a alphabetic string
	 * 
	 **/
	public static String createRandomString_String(int count) {
		String randomString = RandomStringUtils.randomAlphabetic(count);
		return randomString;
	}

	/**
	 * 
	 * This method is used to generate a numeric string
	 * 
	 **/
	public static String createRandomString_Number(int count) {
		String randomString = RandomStringUtils.randomNumeric(count);
		return randomString;
	}

	/**
	 * 
	 * This method is used to switch to different windows
	 * 
	 **/
	public static void switchToWindow(String currentWindow) {
		for (String nextWindow : driver.getWindowHandles()) {
			driver.switchTo().window(nextWindow);
		}
	}

	/**
	 * 
	 * This method is used to check if the expected alert is present
	 * 
	 **/
	public static final boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	public static void kill() {
		System.out.println("===> Closing the Browser");
		driver.manage().deleteAllCookies();
		driver.quit();
		driver = null;
	}

	public static void waitForElementToBeClickable(WebDriver driver, int timeInSeconds, WebElement element,
			boolean selected) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void refreshPage() {
		driver.navigate().refresh();
	}

	public static void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * 
	 * This method is used to get the value of a given web element Input: Web
	 * Element field display name
	 * 
	 * 
	 **/
	public static String getTextOfWebElement(WebElement webElementName) {
		return webElementName.getText();
	}

	public static String getCurrentWindow() throws Exception {
		return driver.getWindowHandle();
	}

}
