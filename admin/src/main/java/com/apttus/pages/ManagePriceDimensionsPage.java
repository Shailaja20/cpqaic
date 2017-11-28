package com.apttus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.apttus.admin.Helper;

public class ManagePriceDimensionsPage {
	public WebDriver driver;
	public Helper helper;
	
	private String btnNewPriceDimensionxpath="//button[text()='New Price Dimension']";
	
	private String btnSavexpath="//a[text()='Save']";
	
	private String lnkCancelxpath="//a[text()='Cancel']";
	
	private String SearchTextxpath="//*[@name='searchText']";
	
	private String Exceptionxpath="//button[@class='modal-Action']";
	
	private String txtException="Ok";	

	public ManagePriceDimensionsPage(WebDriver driver) {
		this.driver = driver;
		helper = new Helper(driver);
	}
	
	public void ClickNewPriceDimension() throws Exception {
		helper.clickByXpath(btnNewPriceDimensionxpath)
			  .waitTillProgressBarIsFull(60)
			  .waitTillElementIsVisible(By.xpath(Exceptionxpath), 60)
			  .ngclickByButtonText(txtException);
	}
	
	public void isElementVisible() {
		checkVisibility(By.xpath(btnNewPriceDimensionxpath));
		checkVisibility(By.xpath(SearchTextxpath));
		checkVisibility(By.xpath(btnSavexpath));
		checkVisibility(By.xpath(lnkCancelxpath));
		
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
}
