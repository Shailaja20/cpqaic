package com.apttus.pages;

import org.openqa.selenium.WebDriver;

import com.apttus.admin.Helper;

public class ManageCatalogPage {
	public WebDriver driver;
	public Helper helper;

	public ManageCatalogPage(WebDriver driver) {
		this.driver = driver;
		helper = new Helper(driver);
	}
}
