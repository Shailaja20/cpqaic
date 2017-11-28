package com.apttus.pages;

import org.openqa.selenium.WebDriver;

import com.apttus.admin.Helper;

public class ManageUnitOfMeasurePage {

	public WebDriver driver;
	public Helper helper;

	public ManageUnitOfMeasurePage(WebDriver driver) {
		this.driver = driver;
		helper = new Helper(driver);
	}
}
