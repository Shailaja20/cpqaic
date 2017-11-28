package com.apttus.pages;

import org.openqa.selenium.WebDriver;

import com.apttus.admin.Helper;

public class ManageCurrencyConversionPage {
	public WebDriver driver;
	public Helper helper;

	public ManageCurrencyConversionPage(WebDriver driver) {
		this.driver = driver;
		helper = new Helper(driver);
	}
}
