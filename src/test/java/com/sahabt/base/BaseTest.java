package com.sahabt.base;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

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
    public void testCase(){
        navigate("http://www.hepsiburada.com/");
    }

    public void navigate(String url) {
        driver.navigate().to(url);
    }

	@After
	public void tearDown() {
		driver.quit();
	}
}
