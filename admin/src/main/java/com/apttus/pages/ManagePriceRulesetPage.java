package com.apttus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.apttus.admin.Helper;

public class ManagePriceRulesetPage {
	public WebDriver driver;
	public Helper helper;
	
	private String btnNewPriceRulesetxpath="//button[text()='New Price Ruleset']";
	
	private String lnkPriceRulesxpath="//a[text()='Price Rules']";
	
    private String btnSavexpath="//a[text()='Save']";
	
	private String lnkCancelxpath="//a[text()='Cancel']";
	
	private String SearchTextxpath="//*[@name='searchText']";
	
	private String txtPriceRuleSetxpath="//*[@name='name']/../input";
	
	private String txtPriceSequencexpath="//*[@name='sequence']/../input";
	
	private String txtPriceShortDescpxpath="//*[@name='ShortDescription']/../textarea";
	
	private String cmbRuleSetTypexpath="//*[@aria-label='Type']";
	
	private String txtRuleSetEffectDatexpath="//*[@placeholder='Effective Date']";
	
	private String txtRuleSetExpDatexpath="//*[@placeholder='Expiration Date']";
	
	private String txtRuleSetPriceListxpath="//*[@aria-label='Price List']";
	
	private String cmbRuleSetProductFamilyxpath="//*[@aria-label='Product Family']";
	
	private String txtRuleSetProductCategoryxpath="//*[@aria-label='Product Category']";
	
	private String txtRuleSetProductGroupxpath="//*[@aria-label='Product Group']";
	
	private String cmbRuleSetCategoryxpath="//label[text()='Category']/..//span";
	
	private String cmbRuleSetChargeTypexpath="//*[@aria-label='Charge Type']";
	
	private String cmbRuleSetApplicationLevelxpath="//label[text()='Application Level']/..";
	
	private String msgSuccesValidate="//*[text()='Created successfully']";


	public ManagePriceRulesetPage(WebDriver driver) {
		this.driver = driver;
		helper = new Helper(driver);
	}
	
	public void ClickNewPriceRuleset() throws Exception {
		helper.waitTillElementIsVisible(By.xpath(btnNewPriceRulesetxpath), 40)
		      .clickByXpath(btnNewPriceRulesetxpath)
			  .waitTillProgressBarIsFull(60);
	}
	
	public void isElementPresent() {
		
		checkVisibility(By.xpath(btnNewPriceRulesetxpath));
		checkVisibility(By.xpath(SearchTextxpath));
		checkVisibility(By.xpath(lnkPriceRulesxpath));
		checkVisibility(By.xpath(btnSavexpath));
		checkVisibility(By.xpath(lnkCancelxpath));
		
	}
	

	public boolean checkVisibility(By by) {
		try {
		boolean elem=helper.findTheElement(by).isDisplayed()?true:false;
		helper.waitTillElementIsVisible(by, 5);
		if (elem=true) {
			System.out.println(by + " found");
			return elem;
		}
		else
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
	
	public void NewRuleSetDetails(String RuleSetName,String RuleSetSequence,String RuleSetShortDescp,String RuleSetEffectDate,String RuleSetExpDate,String RuleSetPriceList,String RuleSetProductCategory,String RuleSetProductGroup ) throws Exception {
		helper.sendkeysByXpath(txtPriceRuleSetxpath, RuleSetName)
			  .sendkeysByXpath(txtPriceSequencexpath, RuleSetSequence)
			  .sendkeysByXpath(txtPriceShortDescpxpath, RuleSetShortDescp)
			  .ngComboSelection(By.xpath(cmbRuleSetTypexpath), "Incentive")
			  .sendkeysByXpath(txtRuleSetEffectDatexpath, RuleSetEffectDate)
			  .sendkeysByXpath(txtRuleSetExpDatexpath, RuleSetExpDate)
			  .sendkeysByXpath(txtRuleSetPriceListxpath, RuleSetPriceList)//SmokeTest
			  .ngComboSelection(By.xpath(cmbRuleSetProductFamilyxpath), "TestFamily")
			  .sendkeysByXpath(txtRuleSetProductCategoryxpath, RuleSetProductCategory)
			  .sendkeysByXpath(txtRuleSetProductGroupxpath, RuleSetProductGroup)
			  .ngComboSelection(By.xpath(cmbRuleSetCategoryxpath), "Proposal")
			  .ngComboSelection(By.xpath(cmbRuleSetChargeTypexpath), "Standard Price")
			  .ngComboSelection(By.xpath(cmbRuleSetApplicationLevelxpath), "Bundle")
			  .clickByXpath(btnSavexpath)
			  .waitTillProgressBarIsFull(60);
	}
	
	public boolean SuccessMsgValidation() {
		//helper.waitTillElementIsInvisible(By.xpath(msgSuccesValidate), 30);
		boolean b=helper.findTheElement(By.xpath(msgSuccesValidate)).isDisplayed();
		
		if (b==true) {
			return true;
		}else
			return false;
	}
	
}
