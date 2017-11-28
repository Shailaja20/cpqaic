package com.apttus.pages;

import org.openqa.selenium.WebDriver;

import com.apttus.admin.Helper;

public class ManageProductGroupsPage {
	public WebDriver driver;
	public Helper helper;

	public ManageProductGroupsPage(WebDriver driver) {
		this.driver = driver;
		helper = new Helper(driver);
	}

}
