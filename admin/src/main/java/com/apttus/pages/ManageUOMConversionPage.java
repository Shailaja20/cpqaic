package com.apttus.pages;

import org.openqa.selenium.WebDriver;

import com.apttus.admin.Helper;

public class ManageUOMConversionPage {
	public WebDriver driver;
	public Helper helper;

	public ManageUOMConversionPage(WebDriver driver) {
		this.driver = driver;
		helper = new Helper(driver);
	}

}
