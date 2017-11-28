package com.apttus.pages;

import org.openqa.selenium.WebDriver;

import com.apttus.admin.Helper;

public class ManageCatalogGroupsPage {

	public WebDriver driver;
	public Helper helper;

	public ManageCatalogGroupsPage(WebDriver driver) {
		this.driver = driver;
		helper = new Helper(driver);
	}
}
