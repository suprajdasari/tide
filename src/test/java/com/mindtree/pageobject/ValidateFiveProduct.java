package com.mindtree.pageobject;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.mindtree.exception.PageObjectException;
import com.mindtree.reusablecomponents.WebDriverSupport;
import com.mindtree.uistore.ValidateFiveProductUi;
import com.mindtree.utilities.ExcelSheetRead;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class ValidateFiveProduct extends ValidateFiveProductUi {

	WebDriver driver;
	Logger log;
	ExtentTest test;

	public  ValidateFiveProduct(WebDriver driver, Logger log, ExtentTest test) {
		this.driver = driver;
		this.log = log;
		this.test = test;
	}
	public void Hover()throws Exception
	{
		new Actions(driver).moveToElement(driver.findElement(shopProducts)).build().perform();
		Thread.sleep(2000);
	}
	public void click() throws Exception
	{

		List<WebElement> dropDown = driver.findElements(dropDownMenu);
		System.out.println(dropDown.size());
		for (WebElement Drops : dropDown) {
			System.out.println(Drops.getText());
			if (Drops.getText().equalsIgnoreCase("Powder")) {
				WebDriverSupport.clickByWebElement(driver, Drops, "Home page",Drops.getText(), log, test);
						break;
				}
				
		}
		Thread.sleep(1000);
	}
	public void validate()
			throws PageObjectException, IOException {
		try {
			
			List<WebElement> result = driver.findElements(results);
			for (WebElement temp : result) {
				System.out.println(temp.getText());
				if (temp.getText().contains(ExcelSheetRead.excelData.get("data"))) {
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
