package com.apttus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.apttus.admin.Helper;

public class ManagePricePipelinePage {
	public WebDriver driver;
	public Helper helper;
	
	private String txtPricePipelineNamexpath="//label[text()='Price Pipeline Name']/../input";
	
	private String txtDescriptionxpath="//label[text()='Description']/../input";
	
	private String btnPublishxpath="//span[text()='Publish']/..";
	
	private String btnCancelxpath="//span[text()='Cancel']/..";

	public ManagePricePipelinePage(WebDriver driver) {
		this.driver = driver;
		helper = new Helper(driver);
	}
	
	public void isElementPresent() {
		checkVisibility(By.xpath(txtPricePipelineNamexpath));
		checkVisibility(By.xpath(txtDescriptionxpath));
		checkVisibility(By.xpath(btnPublishxpath));
		checkVisibility(By.xpath(btnCancelxpath));
		
	}
	
	public boolean checkVisibility(By by) {
		try {
		boolean elem=helper.findTheElement(by).isDisplayed()?true:false;
		helper.waitTillElementIsVisible(by, 10);
		if(elem=true)
		{
			System.out.println(by + " Found");
			return elem;
		}else
		{
			System.out.println(by + " Not found");
			return false;
		}
		
		}
		catch(NoSuchElementException noexp) {
			System.out.println(by + " Not found");
			return false;
		}
}
	
	public void clickCancel() throws Exception {
		helper.clickByXpath(btnCancelxpath);
	}
}
