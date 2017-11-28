package com.apttus.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.apttus.admin.Helper;

public class LoginPage {

	String microsoftUsernameID = "cred_userid_inputtext";
	String microsoftPasswordID = "cred_password_inputtext";
	String microsoftLoginButtonID = "cred_sign_in_button";
	WebDriver driver;
	Helper helper;

	private String loaderGIFcss="span.loadImageText";
	
	public LoginPage(WebDriver driver) throws IOException {
		this.driver = driver;
		helper = new Helper(driver);
	}

	public AdminPage microsoftLogin(String userName, String password) throws Exception {
		helper.sendkeysById(microsoftUsernameID, userName)
		      .sendkeysById(microsoftPasswordID, password).sleepWait(2)
		      .clickById(microsoftLoginButtonID)
		      .waitTillElementIsVisible(By.cssSelector(loaderGIFcss), 20)
		      .waitTillElementIsInvisible(By.cssSelector(loaderGIFcss), 20);
		return new AdminPage(driver);
	}

	public Boolean VerifyAdminPage() throws Throwable {
		WebElement element=helper.findTheElement(By.xpath("//*[text()='New Product']"));
		return element.isDisplayed();
	}
}
