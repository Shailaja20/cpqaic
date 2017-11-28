package com.apttus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.apttus.admin.Helper;

public class ManagePriceListsPage {

	public WebDriver driver;
	public Helper helper;

	private String btnNewPriceListxpath = "//*[text()='New PriceList']";

	private String txtPriceListNamexpath = "//input[@name='name']";

	private String txtShortDescpxpath = "//*[text()='Short Description']/..//textarea";

	private String txtEffectiveDatexpath = "//*[@placeholder='Effective Date']";

	private String txtExpirationDatexpath = "//*[@placeholder='Expiration Date']";

	private String txtBasedOnPriceListxpath = "//input[@aria-label='Based on Price List']";

	private String txtBasedonAdjAmtxpath = "//*[@field-type='QUANTITY']//input";

	private String txtAccountxpath = "//*[@aria-label='Account']";

	private String txtCostModelxpath = "//*[@aria-label='Cost Model']";

	private String txtContractNumberxpath = "//*[@name='contractNumber']//input";//"contractNumber";

	private String txtGuidePagexpath = "//*[text()='Guide Page']/..//textarea";

	private String btnSavexpath = "//*[text()='Save']";
	
	private String msgCreatedxpath="//*[text()='Created Successfully']";
	
	private String msgUpdatedxpath="//*[text()='Updated Successfully']";
	
	private String cmbBasedonAdjTypexpath="//label[text()='Based On Adjustment Type']/../..";
	
	private String cmbCurrencyxpath="//label[text()='Currency']/../..";
	
	private String cmbTypexpath="//label[text()='Type']/../..";
	
	private String lnkPriceListItems="PRICELIST ITEMS";
	
	private String txtProductSearchname="searchText";
	
	private String txtProductValidatexpath=".//h4[text()='Products']";
	
	private String cmbProductListxpath=".//*[@class='list-table']/table/tbody/tr[1]/td[1]/div";
	
	private String DropElementxpath=".//*[@class='price-table']/div";
	
	private String msgPriceListSuccess=".//span[text()='Pricelist item(s) are saved successfully']";
	
	private String lnkCancelButton="Cancel";
	
	private String lnkAdvanced="Advanced";
	
	private String lbltoggleIsActive="Is Active";
	
	private String togglexpath="//input[@aria-label='Is Active']/../label";
	
	public ManagePriceListsPage(WebDriver driver) {
		this.driver = driver;
		helper = new Helper(driver);
	}

	public void ClickNewPriceList() throws Exception {
		helper.waitTillElementIsVisible(By.xpath(btnNewPriceListxpath), 40)
		      .clickByXpath(btnNewPriceListxpath)
		      .waitTillProgressBarIsFull(90);
	}

	public void NewPriceDetails(String ProductName, String Descp, String EffectDate, String ExpDate, String AdjAmnt,String account, String CostModel, String ContractNumber, String GuidePage) throws Exception {
		helper.waitTillElementIsVisible(By.xpath(togglexpath), 60)
		      .sendkeysByXpath(txtPriceListNamexpath, ProductName)
		      .sendkeysByXpath(txtShortDescpxpath, Descp)
		      .sendkeysByXpath(txtEffectiveDatexpath, EffectDate)
		      .sendkeysByXpath(txtExpirationDatexpath, ExpDate)
		      .sendkeysByXpath(txtBasedOnPriceListxpath, "SanityTest")
		      .ngComboSelection(By.xpath(cmbBasedonAdjTypexpath), "Discount Amount")
		      .ngComboSelection(By.xpath(cmbCurrencyxpath), "IDR")
		      .sendkeysByXpath(txtBasedonAdjAmtxpath, AdjAmnt)
		      .ngComboSelection(By.xpath(cmbTypexpath), "Standard")
		      //.sendkeysByXpath(txtAccountxpath, account)
			  //.sendkeysByXpath(txtCostModelxpath, CostModel)
			  .sendkeysByXpath(txtContractNumberxpath,"Contr 12345")
			  .sendkeysByXpath(txtGuidePagexpath, GuidePage)
			  .clickByXpath(btnSavexpath)
			  .waitTillProgressBarIsFull(60);
					
	}
	
	public void MandatoryPriceField(String ProductName) throws Exception {
		helper.waitTillElementIsVisible(By.xpath(togglexpath), 60)
			  .sendkeysByXpath(txtPriceListNamexpath, ProductName)
			  .ngComboSelection(By.xpath(cmbBasedonAdjTypexpath), "Price Factor")
			  .clickByXpath(btnSavexpath)
			  .waitTillProgressBarIsFull(60)
			  .waitTillElementIsVisible(By.linkText(lnkPriceListItems), 10)
			  .clickByLinkText(lnkPriceListItems)
			  .waitTillElementIsVisible(By.xpath(txtProductValidatexpath), 40)
			  .clickAndSendkeysByName(txtProductSearchname, "bundle")
			  .sendBoardKeys(Keys.ENTER)
			  .waitTillProgressBarIsFull(60)
			  .DragAndDropJS(By.xpath(cmbProductListxpath), By.xpath(DropElementxpath))
	    	  .waitTillProgressBarIsFull(60)
		      .waitTillElementIsVisible(By.xpath(msgPriceListSuccess), 10)
		      .clickByXpath(btnSavexpath);
	}
	
	public void DeactivatePriceList(String ProductName) throws Exception {
		helper.waitTillElementIsVisible(By.xpath(togglexpath), 60)
		      .sendkeysByXpath(txtPriceListNamexpath, ProductName)
			  .toggleAction(lbltoggleIsActive)
			  .ngComboSelection(By.xpath(cmbBasedonAdjTypexpath), "Price Factor")
			  .clickByXpath(btnSavexpath)
			  .waitTillProgressBarIsFull(60)
			  .clickByLinkText(lnkPriceListItems)
			  .waitTillElementIsVisible(By.xpath(txtProductValidatexpath), 30)
			  .clickAndSendkeysByName(txtProductSearchname, "bundle")
			  .sendBoardKeys(Keys.ENTER)
			  .waitTillProgressBarIsFull(60)
		      .DragAndDropJS(By.xpath(cmbProductListxpath), By.xpath(DropElementxpath))
		      .waitTillElementIsVisible(By.xpath(msgPriceListSuccess), 10)
		      .clickByXpath(btnSavexpath);

	}
	
	public PricingAdvancedLink clickAdvancedLink() throws Exception {
		helper.clickByLinkText(lnkAdvanced);
		return new PricingAdvancedLink(driver);
	}
	
	public boolean SuccessMsgValidation() {
		boolean b=helper.findTheElement(By.xpath(msgPriceListSuccess)).isDisplayed();
		
		if(b=true)
		{
			return true;
		}else 
						
	     return false;
	}
	
	public void isElementPresent() {
		
		checkVisibility(By.xpath(btnNewPriceListxpath));
		checkVisibility(By.xpath(btnSavexpath));
		checkVisibility(By.linkText(lnkCancelButton));
		checkVisibility(By.name(txtProductSearchname));
		checkVisibility(By.name(txtProductSearchname));
		checkVisibility(By.linkText(lnkPriceListItems));
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
	
}