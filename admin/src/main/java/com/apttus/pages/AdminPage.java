package com.apttus.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.apttus.admin.Helper;

public class AdminPage {

	public WebDriver driver;
	public Helper helper;

	private String loaderGIFcss="span.loadImageText";
	
	private String btnNewProductxpath = "//*[text()='New Product']";

	private String btnproductstext = "Products";

	private String btnCatalogtext = "Catalog";

	private String btnPricingtext = "Pricing";

	private String cmbSearchclass = "md-select-value";

	private String repeaterSearch = "item in vm.properties.PicklistValues";

	private String btnNewSearchtext = "New Search";

	private String txtSearchProductscss = ".search-box";

	private String btnSearchIconcss = "i.search-icon";

	private String cmbFieldxpath = "//*[@model='item.field']";

	private String cmbOperatorxpath = "//*[@model='item.function']";

	private String cmbrepeater = "item in vm.properties.PicklistValues";

	private String txtValuemodelxpath = "//*[@model='item.value']";

	private String txtSearchNamexpath = "//*[@model='vm.condExpression']";

	private String btnAndxpath = "//button/*[text()='And']";

	private String btnOrxpath = "//button/*[text()='Or']";

	private String btnApplytext = "Apply";

	private String btnSaveAstext = "Save As";

	private String btnCanceltext = "Cancel";

	private String mnuManageProductGroupsxpath = "//span[contains(text(),'Manage Product Groups']";

	private String mnuManageUnitOfMeasurexpath = "//span[contains(text(),'Manage Unit of Measure']";

	private String mnuManageUoMsToProductsxpath = "//span[contains(text(),'Map UoMs to Products']";

	private String mnuManageUoMConversionxpath = "//span[contains(text(),'Manage UoM Conversion']";

	private String mnuManageCatalogxpath = "//span[contains(text(),'Manage Catalog']";

	private String mnuManageOptionGroupsxpath = "//span[contains(text(),'Manage Option Groups')]";

	private String mnuManagePriceListsxpath = "//a[@aria-label='Manage Price Lists']";

	private String mnuManagePriceRulesetxpath = "//a[@aria-label='Manage Price Ruleset']";

	private String mnuManageCurrencyConversionxpath = "//span[contains(text(),'Manage Currency Conversion')]";

	private String mnuManagePriceDimensionsxpath = "//span[contains(text(),'Manage Price Dimensions')]";

	private String mnuManagePricePipelinexpath = "//span[contains(text(),'Manage Price Pipeline')]";

	private String mnuManagePriceWaterfallxpath = "//span[contains(text(),'Manage Price Waterfall')]";

	private String btnOpenDemoMenuxpath = "//button[@aria-label='Open demo menu')]";

	private String mnuNewFromClonexpath = "//*[contains(text(),'New from Clone')]";


	public AdminPage(WebDriver driver) {
		this.driver = driver;
		helper = new Helper(driver);
	}

	public AdminPage navigateToAdminPage() throws Exception {
		helper.navigateToURL("https://stg-aql-test1.apttuscloud.io/ui/cpq/admin/app/list")
			  .waitTillElementIsVisible(By.cssSelector(loaderGIFcss), 180)
			  .waitTillElementIsInvisible(By.cssSelector(loaderGIFcss), 180);	  
		return new AdminPage(driver);
	}

	public NewProductPage navigateToNewProductPage() throws Exception {
		helper.clickByXpath(btnNewProductxpath);
		return new NewProductPage(driver);
	}

	public ManageProductGroupsPage navigateToManageProductsGroupsPage() throws Exception {
		helper.ngclickByButtonText(btnproductstext).clickByXpath(mnuManageProductGroupsxpath);
		return new ManageProductGroupsPage(driver);
	}

	public ManageUnitOfMeasurePage navigateToManageUnitOfMeasurePage() throws Exception {
		helper.ngclickByButtonText(btnproductstext).clickByXpath(mnuManageUnitOfMeasurexpath);
		return new ManageUnitOfMeasurePage(driver);
	}

	public ManageUoMsToProductsPage navigateToManageUoMsToProductsPage() throws Exception {
		helper.ngclickByButtonText(btnproductstext).clickByXpath(mnuManageUoMsToProductsxpath);
		return new ManageUoMsToProductsPage(driver);
	}

	public ManageUOMConversionPage navigateToManageUOMConversionPage() throws Exception {
		helper.ngclickByButtonText(btnproductstext).clickByXpath(mnuManageUoMConversionxpath);
		return new ManageUOMConversionPage(driver);
	}

	public ManageCatalogPage navigateToManageCatalogPage() throws Exception {
		helper.ngclickByButtonText(btnCatalogtext).clickByXpath(mnuManageCatalogxpath);
		return new ManageCatalogPage(driver);
	}

	public ManageCatalogGroupsPage navigateToManageCataloggroupsPage() throws Exception {
		helper.ngclickByButtonText(btnCatalogtext).clickByXpath(mnuManageOptionGroupsxpath);
		return new ManageCatalogGroupsPage(driver);
	}

	public ManagePriceListsPage navigateToManagePriceListsPage() throws Exception {
		helper.ngclickByButtonText(btnPricingtext)
		      .waitTillElementIsVisible(By.xpath(mnuManagePriceListsxpath), 30)
		      .clickByXpath(mnuManagePriceListsxpath)
		      .waitTillProgressBarIsFull(90);
		return new ManagePriceListsPage(driver);

	}

	public ManagePriceRulesetPage navigateToManagePriceRulesetPage() throws Exception {
		helper.ngclickByButtonText(btnPricingtext)
			  .waitTillElementIsVisible(By.xpath(mnuManagePriceRulesetxpath), 40)
		      .clickByXpath(mnuManagePriceRulesetxpath)
		      .waitTillProgressBarIsFull(60);
		return new ManagePriceRulesetPage(driver);
	}

	public ManageCurrencyConversionPage navigateToManageCurrencyConversionPage() throws Exception {
		helper.ngclickByButtonText(btnPricingtext)
		      .clickByXpath(mnuManageCurrencyConversionxpath)
		      .waitTillProgressBarIsFull(30);
		return new ManageCurrencyConversionPage(driver);
	}

	public ManagePriceDimensionsPage navigateToManagePriceDimensionsPage() throws Exception {
		helper.ngclickByButtonText(btnPricingtext)
			  .waitTillElementIsVisible(By.xpath(mnuManagePriceDimensionsxpath), 30)
		      .clickByXpath(mnuManagePriceDimensionsxpath);
		     /* .waitTillElementIsVisible(By.cssSelector(loaderGIFcss), 30)
		      .waitTillElementIsInvisible(By.cssSelector(loaderGIFcss), 30);*/
		return new ManagePriceDimensionsPage(driver);
	}

	public ManagePricePipelinePage navigateToManagePricePipelinePage() throws Exception {
		helper.ngclickByButtonText(btnPricingtext)
			  .waitTillElementIsVisible(By.xpath(mnuManagePricePipelinexpath), 30)
		      .clickByXpath(mnuManagePricePipelinexpath);
		     /* .waitTillElementIsVisible(By.cssSelector(loaderGIFcss), 30)
		      .waitTillElementIsInvisible(By.cssSelector(loaderGIFcss), 30);*/
		return new ManagePricePipelinePage(driver);
	}

	public ManagePriceWaterfallPage navigateToManagePriceWaterfallPage() throws Exception {
		helper.ngclickByButtonText(btnPricingtext)
		      .clickByXpath(mnuManagePriceWaterfallxpath)
		      .waitTillElementIsVisible(By.cssSelector(loaderGIFcss), 30)
		      .waitTillElementIsInvisible(By.cssSelector(loaderGIFcss), 30);
		return new ManagePriceWaterfallPage(driver);
	}

	public void filter(String columnName, String filterCriteria) throws Exception {
		helper.sendKeysToTextBoxInTable(columnName, filterCriteria).sendBoardKeys(Keys.ENTER)
			  .waitTillElementIsVisible(By.cssSelector(loaderGIFcss), 20)
			  .waitTillElementIsInvisible(By.cssSelector(loaderGIFcss), 20);
	}

	public void searchProducts(String searchcriteria) throws Exception {
		helper.sendkeysByCssPath(txtSearchProductscss, searchcriteria).clickByCssPath(btnSearchIconcss);
	}

	public void createNewSearchWithApply(String fieldinput, String operatorinput, String valueinput, String searchName)
			throws Exception {
		helper.ngclickByButtonText(btnNewSearchtext)
			  .clickByXpath(cmbFieldxpath)
		      .ngComboRepeatsSelection(cmbrepeater, fieldinput)
		      .clickByXpath(cmbOperatorxpath)
		      .ngComboRepeatsSelection(cmbrepeater, operatorinput)
		      .sendkeysByXpath(txtValuemodelxpath, valueinput)
		      .clickByXpath(btnAndxpath)
		      .sendkeysByXpath(txtSearchNamexpath, searchName)
		      .ngclickByButtonText(btnApplytext);
	}

	public List<String> getProductsTableData() {
		return helper.returnAllTableData(By.tagName("table"));
	}
}
