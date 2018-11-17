package com.sahabt.base;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BaseTest {

	public static final String URL = "http://hub.testinium.io/wd/hub";
	public static RemoteWebDriver driver;

	@Before
	public void setUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("key", System.getProperty("key"));
		try {
			driver = new RemoteWebDriver(new URL(URL),capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

    @Test
    public void searchTest(){
        navigate("http://www.google.com");

		JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");

        List<WebElement> elements = driver.findElements(By.tagName("a"));
    	for (WebElement webElement : elements) {
			WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
			WebElement waitElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
			if(waitElement != null) {
				try {
					webElement.click();
					break;
				} catch (Exception e) {
					continue;
				}
			}
    	}
    }

    public void navigate(String url) {
        driver.navigate().to(url);
    }

	@After
	public void tearDown() {
		driver.quit();
	}
}