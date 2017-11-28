package com.apttus.admin;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.apttus.helpers.JavaHelpers;
import com.apttus.pages.AdminPage;
import com.apttus.pages.LoginPage;
import com.apttus.pages.ManageCatalogGroupsPage;
import com.apttus.pages.ManageCatalogPage;
import com.apttus.pages.ManagePriceDimensionsPage;
import com.apttus.pages.ManagePriceListsPage;
import com.apttus.pages.ManagePricePipelinePage;
import com.apttus.pages.ManagePriceRulesetPage;
import com.apttus.pages.NewProductPage;
import com.apttus.selenium.SeleniumHelper;
import com.apttus.selenium.WebDriverUtils;
import com.fasterxml.jackson.databind.deser.impl.ManagedReferenceProperty;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.MalformedJsonException;

import junit.framework.Assert;

public class SmokeSuite {
	public Properties properties;
	public JavaHelpers javaHelper = new JavaHelpers();
	public SeleniumHelper seleniumHelper;
	public WebDriverUtils webDriverUtils = new WebDriverUtils();
	public WebDriver driver;
	public boolean needsLoginFlag = true;
	public Helper help;

	public LoginPage loginPage;
	public AdminPage adminPage;
	public ManageCatalogGroupsPage manageCatalogGroupsPage;
	public ManageCatalogPage manageCatalogPage;
	public NewProductPage newProductPage;
	public ManagePriceListsPage managePriceListsPage;
	public ManagePriceRulesetPage managePriceRuleSet;
	public ManagePriceDimensionsPage managePriceDimensionPage;
	public ManagePricePipelinePage managePricePipelinePage;
	
	@BeforeTest(alwaysRun = true)
	@Parameters({ "runParallel", "environment", "browser", "hubURL" })
	public void LoginToDealMax(String runParallel, String environment, String browser, String hubURL) throws Exception {
		// initReport();
		// startReport("Navigate to Deal Max URL");
		// properties = javaHelper.loadPropertyFile(environment);
		WebDriverUtils webDriverUtils = new WebDriverUtils();
		if (runParallel.equalsIgnoreCase("true")) {
			webDriverUtils.initializeDriver(browser, hubURL);
			this.driver = webDriverUtils.getDriver();
			webDriverUtils.getDriver().get("https://stg-aql-test2.apttuscloud.io/ui/cpq/admin/"); 
			driver.manage().window().maximize();
			seleniumHelper = new SeleniumHelper(driver);
			loginPage = new LoginPage(driver);
			seleniumHelper.waitForNGToLoad();
			adminPage = loginPage.microsoftLogin("globaladmin@aicaqlstg.apttuscloud.io", "f8uthuC*e6tu");
			help = new Helper(driver);
			// dealMaxHomePage=adminPage.NavigateToDealMax();
		} else if (needsLoginFlag == true) {
			webDriverUtils.initializeDriver(browser, hubURL);
			this.driver = webDriverUtils.getDriver();
			webDriverUtils.getDriver().get("https://stg-aql-test2.apttuscloud.io/ui/cpq/admin/");
			driver.manage().window().maximize();
			seleniumHelper = new SeleniumHelper(driver);
			loginPage = new LoginPage(driver);
			seleniumHelper.waitForNGToLoad();
			adminPage = loginPage.microsoftLogin("globaladmin@aicaqlstg.apttuscloud.io", "f8uthuC*e6tu");
			help = new Helper(driver);
			needsLoginFlag = false;
		}

	}

	//@Test(priority=1)
	public void Test1() throws Exception {
		try {
		List<String> tabledata=adminPage.getProductsTableData();
		System.out.println(tabledata);
		adminPage.filter("Product code", "Bundle");
		adminPage.filter("arrow_upward Name", "Bundle");
		adminPage.filter("Version", "0");
		}
		catch(Exception e) {
			fail();
		}
	}
	
	//@Test(priority=2)
	public void CreateProduct() throws Exception {
		try {
		newProductPage=adminPage.navigateToNewProductPage();
		newProductPage.FillDetails("SmokeTest", "code", "10/12/2017", "10/12/2018", "New Product", "Bundle", "Sales Cloud", "Year");
		}
		catch(Exception e) {
			fail();
		}
	}
	
	//@Test(priority=3, groups= {"Pricing"})
	public void CreatePriceList() {
		try {
		managePriceListsPage=adminPage.navigateToManagePriceListsPage();
		Map<String,String> createPriceListdata=javaHelper.readJsonFile("Smoke.json");
		managePriceListsPage.ClickNewPriceList();
		managePriceListsPage.NewPriceDetails(createPriceListdata.get("productName"),createPriceListdata.get("descp"),createPriceListdata.get("effectDate"),createPriceListdata.get("expDate"),createPriceListdata.get("adjAmnt"),createPriceListdata.get("account"),createPriceListdata.get("costModel"),createPriceListdata.get("contractNumber"),createPriceListdata.get("guidePage"));
		}
		catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	//@Test(description="Checking Mandatory Fields in the Price Filed",priority=4, groups= {"pricing"})
	public void PriceListMandatoryFields() {
		try {
			managePriceListsPage=adminPage.navigateToManagePriceListsPage();
			managePriceListsPage.ClickNewPriceList();
			Map<String,String> managePriceListsPagedata=javaHelper.readJsonFile("Smoke.json");
			managePriceListsPage.MandatoryPriceField(managePriceListsPagedata.get("productName"));
			assertTrue(managePriceListsPage.SuccessMsgValidation());
		}catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	   // @Test(description="Deactivate Price List",priority=5, groups= {"pricing"})
		public void DisablePriceToggle() {
			try {
				managePriceListsPage=adminPage.navigateToManagePriceListsPage();
				managePriceListsPage.ClickNewPriceList();
				Map<String,String> disablePriceListToggle=javaHelper.readJsonFile("Smoke.json");
				managePriceListsPage.DeactivatePriceList(disablePriceListToggle.get("productName"));
				assertTrue(managePriceListsPage.SuccessMsgValidation());
			}catch (Exception e) {
				e.printStackTrace();
				fail();
			}
		}
	
	//@Test(description="Validating Webelemements in Manage Price List Page", priority=6, groups= {"pricing"})
	public void PriceListValidation()
	{
		try {
			managePriceListsPage=adminPage.navigateToManagePriceListsPage();
			managePriceListsPage.ClickNewPriceList();
			managePriceListsPage.isElementPresent();
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	//@Test(description="Validating Webelements in Price Ruleset Page", priority=7, groups= {"pricing"})
	public void PriceRulesetValidation()
	{
		try {
			managePriceRuleSet=adminPage.navigateToManagePriceRulesetPage();
			managePriceRuleSet.ClickNewPriceRuleset();
			managePriceRuleSet.isElementPresent();
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	//@Test(description="Validating WebElements in the Price Dimension Page", priority=8)
	public void NewPriceDimensionValidation() {
		try {
			managePriceDimensionPage=adminPage.navigateToManagePriceDimensionsPage();
			managePriceDimensionPage.ClickNewPriceDimension();
			managePriceDimensionPage.isElementVisible();
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	//@Test(description="Validating WebElements of Price Pipeline Page", priority=9, groups= {"pricing"})
	public void PricePipelineValidation() {
		try {
			managePricePipelinePage=adminPage.navigateToManagePricePipelinePage();
			managePricePipelinePage.isElementPresent();
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test(description="Fill all the details of the Rule Set Page", priority=10, groups= {"RulePage"})
	public void CreateNewRuleSet() {
		try {
			managePriceRuleSet=adminPage.navigateToManagePriceRulesetPage();
			managePriceRuleSet.ClickNewPriceRuleset();
			Map<String, String> createRuleSetData=javaHelper.readJsonFile("Smoke.json");
			managePriceRuleSet.NewRuleSetDetails(createRuleSetData.get("RuleSetName"), createRuleSetData.get("RuleSetSequence"), createRuleSetData.get("RuleSetShortDescp"), createRuleSetData.get("RuleSetEffectDate"), createRuleSetData.get("RuleSetExpDate"), createRuleSetData.get("RuleSetPriceList"), createRuleSetData.get("RuleSetProductCategory"), createRuleSetData.get("RuleSetProductGroup"));
			assertTrue(managePriceRuleSet.SuccessMsgValidation());
		}catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
	}
	
	
	//@Test(description="Verify Option Group List should be same for the Advance Pricing Page and the Product Structure Page", priority=10)
	public void VerifyOptionGroupList() {
		
	}

	/*@AfterMethod
	public void methodCleanUp()
	{
		try {
		adminPage=adminPage.navigateToAdminPage();
		}
		catch(Exception e) {
			fail();
		}
	}*/
}