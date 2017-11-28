package com.apttus.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.apttus.admin.Helper;

public class Structure {
	public WebDriver driver;
	public Helper helper;
	
	public Structure(WebDriver driver) {
		this.driver=driver;
		helper = new Helper(driver);
	}
	
	public void OptionGroupLists() {
		String str1=driver.findElement(By.xpath("//*[@class='dropzone']/..")).getText();
				System.out.println(str1);
		//assertEquals(str, str1);
	}

}
