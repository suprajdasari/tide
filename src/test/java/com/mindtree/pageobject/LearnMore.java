package com.mindtree.pageobject;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.exception.PageObjectException;
import com.mindtree.reusablecomponents.WebDriverSupport;
import com.mindtree.uistore.LearnMoreUi;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class LearnMore extends LearnMoreUi {
	
	WebDriver driver;
	Logger log;
	ExtentTest test;
	
	public  LearnMore(WebDriver driver, Logger log, ExtentTest test) {
		this.driver = driver;
		this.log = log;
		this.test = test;
	}
	public void click()throws Exception
	{
		WebDriverSupport.click(driver, learnMore,"Home page", "Learn More", log, test);
		Thread.sleep(2000);
	}
	public void validate(String data)
			throws PageObjectException, IOException {
		try {
			
			List<WebElement> results = driver.findElements(result);
			for (WebElement temp : results) {
				System.out.println(temp.getText());
				if (temp.getText().contains(data)) {
					ExtentLogUtilities.pass(driver, test,"Found The result", log);
					break;
				}
				else
				{
					ExtentLogUtilities.fail(driver, test," result not found", log);
				}
			}
		} catch (Exception e) {
			ExtentLogUtilities.fail(driver, test, e.getMessage(), log);
			throw new PageObjectException(e.getMessage());
		}
	}
}
