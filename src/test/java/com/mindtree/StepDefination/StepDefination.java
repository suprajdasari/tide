
package com.mindtree.StepDefination;


import org.apache.log4j.Logger;


import com.mindtree.exception.*;
import com.mindtree.reusablecomponents.*;
import com.mindtree.pageobject.*;
import com.mindtree.utilities.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.cucumber.java.en.*;



public class StepDefination extends Base {
	public StepDefination() throws UtilityException, Exception {
		//super();
	}

	static Logger log;
	static ExtentTest test;
	static ExtentReports report;

	  @Given("^Tide Site Url Open$")
	    public void tide_site_url_open() throws Throwable {
				report = new ExtentReports(System.getProperty("user.dir") + "\\reports\\" + "ExtentReportResults-"
						+ System.currentTimeMillis() + "-.html");
				log = Logger.getLogger(StepDefination.class.getName());
				driver = initialize();
				driver.manage().window().maximize();
				test = report.startTest("Home Page");
				driver.get(GetProperties.get.getProperty("url"));
				ExtentLogUtilities.pass(driver, test, "URL Opened", log);
				report.endTest(test);
				report.flush();
	    }

	    @Then("^Hover on Shop Products$")
	    public void hover_on_shop_products() throws Exception {
	    	test = report.startTest("Product page");
	    	new ValidateFiveProduct(driver, log, test).Hover();
	    	report.endTest(test);
			report.flush();
	    }

	    @Then("^search \"([^\"]*)\" and check \"([^\"]*)\"$")
	    public void search_something_and_check(String product, String strArg1) throws Exception {
	    	test = report.startTest("Product page");
	    	new Search(driver, log, test).validate(product);
	    	report.endTest(test);
			report.flush();
	    }

	    @Then("^click one Learn More$")
	    public void click_one_learn_more() throws Exception {
	    	test = report.startTest("Learn More page");
	    	driver.navigate().to(GetProperties.get.getProperty("url"));
	    	 new LearnMore(driver, log, test).click();
	    	 report.endTest(test);
				report.flush();
	    }

	    @And("^Click On powder$")
	    public void click_on_powder() throws Exception {
	    	test = report.startTest("Product page");
	    	 new ValidateFiveProduct(driver, log, test).click();
	    	 report.endTest(test);
				report.flush();
	    }

	    @And("^Check if product available or not$")
	    public void check_if_product_available_or_not() throws Exception {
	    	test = report.startTest("Product page");
	    	new ValidateFiveProduct(driver, log, test).Hover();
	    	report.endTest(test);
			report.flush();
	    }

	    @And("^under How to do Laundry varify How to Read Laundry Symbols$")
	    public void under_how_to_do_laundry_varify_how_to_read_laundry_symbols() throws Exception {
	    	test = report.startTest("learn More page");
	       new LearnMore(driver, log, test).validate("How to Read Laundry Symbols");
	       report.endTest(test);
			report.flush();
	    }
}