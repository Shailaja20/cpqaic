package com.apttus.pages;

import org.openqa.selenium.WebDriver;

import com.apttus.admin.Helper;

public class ManageUoMsToProductsPage {

	public WebDriver driver;
	public Helper helper;

	public ManageUoMsToProductsPage(WebDriver driver) {
		this.driver = driver;
		helper = new Helper(driver);
	}

}
