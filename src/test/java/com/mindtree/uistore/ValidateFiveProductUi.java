package com.mindtree.uistore;

import org.openqa.selenium.By;

public class ValidateFiveProductUi {
	public static By shopProducts=By.xpath("//a[@data-action-detail='Shop Products']");
	public static By dropDownMenu=By.xpath("//a[@class='event_menu_click ']");
	public static By results=By.xpath("//div[@class='product-preview-content']//a");
}