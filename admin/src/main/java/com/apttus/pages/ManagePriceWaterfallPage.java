package com.apttus.pages;

import org.openqa.selenium.WebDriver;

import com.apttus.admin.Helper;

public class ManagePriceWaterfallPage {

	public WebDriver driver;
	public Helper helper;

	public ManagePriceWaterfallPage(WebDriver driver) {
		this.driver = driver;
		helper = new Helper(driver);
	}
}
