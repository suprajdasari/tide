package com.mindtree.uistore;

import org.openqa.selenium.By;

public class SearchUi {
	public static By searchBox=By.xpath("//input[@placeholder='Search']");
	public static By button=By.xpath("//button[@type='submit']");
	public static By results=By.xpath("//div[@class='product-preview-content'] //a[@class='product-preview-title']");
}
