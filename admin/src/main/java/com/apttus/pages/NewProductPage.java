package com.apttus.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.apttus.admin.Helper;

public class NewProductPage {

	public WebDriver driver;
	public Helper helper;

	// Declaring the locators

	private String txtNameid = "element0";

	private String txtProductcodexpath = "//*[@id='element1']";

	private String cmbConfigxpath = "//*[text()='Configuration Type']/..//md-select-value";

	private String cmbFamilyxpath = "//*[text()='Family']/../..";

	private String dateEffectivexpath = "//*[@placeholder='Effective Date']";

	private String dateExpirationxpath = "//*[@placeholder='Expiration Date']";

	private String txtProductDescriptionxpath = "//*[text()='Product Description']/..//textarea";

	private String cmbUOMxpath = "//*[text()='Uom']/..//md-select";

	private String btnSavexpath = "//*[text()='Save']";

	private String repeaterTextConfiguration = "item in vm.properties.PicklistValues";

	private String repeaterTextFamily = "item in vm.properties.PicklistValues";

	public NewProductPage(WebDriver driver) {
		this.driver = driver;
		helper = new Helper(driver);
	}

	public void FillDetails(String name, String productcode, String effDate, String expDate, String prdDesc,
			String configType, String familyType, String uom) throws Exception {
       
		helper.waitTillProgressBarIsFull(30)
		      .waitTillElementIsVisible(By.xpath(txtProductcodexpath), 30)
		      .returnVisibleElement(By.id(txtNameid))
		      .sendKeys(name);
		helper.sendkeysByXpath(txtProductcodexpath, productcode)
		      .clickByXpath(cmbUOMxpath)
		      .sendTextkeys(uom)
		      .sendBoardKeys(Keys.ENTER)
		      .clickByXpath(cmbConfigxpath)
		      .sendTextkeys(configType)
		      .sendBoardKeys(Keys.ENTER)
		      .clickByXpath(cmbFamilyxpath)
		      .sendTextkeys(familyType)
		      .sendBoardKeys(Keys.ENTER)
		      .sendkeysByXpath(dateEffectivexpath, effDate)
		      .sendkeysByXpath(dateExpirationxpath, expDate)
		      .clickAndSendkeysByXpath(txtProductDescriptionxpath,prdDesc)
			  .clickByXpath(btnSavexpath)
			  .waitTillProgressBarIsFull(30);
	}

}