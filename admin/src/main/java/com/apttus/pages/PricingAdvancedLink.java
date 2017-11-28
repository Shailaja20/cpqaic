package com.apttus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.apttus.admin.Helper;

public class PricingAdvancedLink {
	
	public WebDriver driver;
	public Helper helper;
	
	private String lnkOptions="OPTIONS";
	
	
	public PricingAdvancedLink(WebDriver driver) {
		this.driver=driver;
		helper =new Helper(driver);
	}
	
	public void OptionGroupList() throws Exception {
		helper.clickByLinkText(lnkOptions)
			  .waitTillProgressBarIsFull(60);
		String str=driver.findElement(By.xpath("//*[@class='tree-wrapper']")).getText();
		System.out.println(str);
	}
	
}
