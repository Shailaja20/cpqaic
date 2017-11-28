package com.apttus.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.apttus.selenium.SeleniumHelper;
import com.paulhammant.ngwebdriver.ByAngular;

public class Helper {

	public WebDriver driver;
	public SeleniumHelper seleniumHelper;
	public Actions acc;

	public Helper(WebDriver driver) {
		this.driver = driver;
		seleniumHelper = new SeleniumHelper(driver);
		acc = new Actions(driver);
	}
	
	
	public WebElement returnVisibleElement(By by) throws Exception {
		seleniumHelper.waitForNGToLoad();
		int count=0;
		List<WebElement> elems=driver.findElements(by);
		for (WebElement elem:elems) {
			if (elem.isDisplayed()==true) {
				count++;
				seleniumHelper.waitForNGToLoad();
				return elem;
			}
			if (count>0) {
			break;
			}
		}
		seleniumHelper.waitForNGToLoad();
		return null;
	}

	public Helper waitTillElementIsVisible(By bystring, int timeval) {
		seleniumHelper.waitForNGToLoad();
		WebDriverWait wait = new WebDriverWait(driver, timeval);
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(bystring)));
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}
	
	public Helper waitTillProgressBarIsFull(int timeval) {
		seleniumHelper.waitForNGToLoad();
		WebDriverWait wait = new WebDriverWait(driver, timeval);
		wait.until(ExpectedConditions.or(ExpectedConditions.attributeContains
				(findTheElement(By.xpath("//*[@id='ngProgress']")), "style", "100%")));
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper waitTillElementIsInvisible(By bystring, int timeval) {
		WebDriverWait wait = new WebDriverWait(driver, timeval);
		wait.until(ExpectedConditions.or(ExpectedConditions.invisibilityOfElementLocated(bystring)));
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper navigateToURL(String url) throws InterruptedException {
		seleniumHelper.waitForNGToLoad();
		driver.navigate().to(url);
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	
	public Helper sleepWait(double timeinteger) throws InterruptedException {
		seleniumHelper.waitForNGToLoad();
		Double d = timeinteger*1000;
		Integer intTime = d.intValue(); 
		Thread.sleep(intTime);
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public WebElement findTheElement(By byelement) {
		seleniumHelper.waitForNGToLoad();
		return driver.findElement(byelement);
	}

	public List<WebElement> findTheElements(By byelement) {
		seleniumHelper.waitForNGToLoad();
		return driver.findElements(byelement);
	}

	public Helper switchToCurrentTab() {
		seleniumHelper.waitForNGToLoad();
		Set<String> winHandles = driver.getWindowHandles();
		for (String wind : winHandles) {
			seleniumHelper.switchToWindow(wind);
		}
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper sendBoardKeys(Keys key) {
		seleniumHelper.waitForNGToLoad();
		// Actions acc=new Actions(driver);
		acc.sendKeys(key).build().perform();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}
	
	
	
	public Helper sendTextkeys(String strings) {
		seleniumHelper.waitForNGToLoad();
		acc.sendKeys(strings).build().perform();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public String takeScreenShot(String fileName) throws IOException {
		seleniumHelper.waitForNGToLoad();
		String dirs = System.getProperty("user.dir");
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(dirs + "/test-output/images/" + fileName + ".png");
		FileUtils.copyFile(SrcFile, DestFile);
		seleniumHelper.waitForNGToLoad();
		return DestFile.toString().trim();
	}

	public Helper ngComboRepeatsSelection(String repeaterText, String option) throws Exception {
		seleniumHelper.waitForNGToLoad();
		List<WebElement> elems = driver.findElements(ByAngular.repeater(repeaterText));
		for (WebElement elem : elems) {
			System.out.println(elem.getText().trim().toString());
			if (elem.getText().trim().toString().equalsIgnoreCase(option)) {
				elem.sendKeys(Keys.ENTER);
			}
		}
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	////////////////////////// Click Actions
	////////////////////////// /////////////////////////////////////////////

	public Helper clickById(String idString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		seleniumHelper.findWebElementbyid(idString).click();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper clickByName(String nameString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		seleniumHelper.findWebElementbyName(nameString).click();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper clickByXpath(String xpathString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		seleniumHelper.findWebElementbyXpath(xpathString).click();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper clickByCssPath(String csspathString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		seleniumHelper.findWebElementbyCssSelector(csspathString).click();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper clickByClassname(String classNameString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		seleniumHelper.findWebElementbyclass(classNameString).click();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper clickByLinkText(String linkTextString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		seleniumHelper.findWebElementbyLink(linkTextString).click();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper clickByTagName(String tagNameString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		seleniumHelper.findWebElementbyTagName(tagNameString).click();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	////////////////////////// Angular Click Actions
	////////////////////////// /////////////////////////////////////////////

	public Helper ngclickByButtonText(String buttonText) throws Exception {
		seleniumHelper.waitForNGToLoad();
		driver.findElement(ByAngular.buttonText(buttonText)).click();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper ngclickByModel(String modelText) throws Exception {
		seleniumHelper.waitForNGToLoad();
		driver.findElement(ByAngular.model(modelText)).click();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper ngSendkeysByModel(String modelString, String inputString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		driver.findElement(ByAngular.model(modelString)).clear();
		driver.findElement(ByAngular.model(modelString)).sendKeys(inputString);
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	////////////////////////////////////// Send Keys Actions
	////////////////////////////////////// ////////////////////////////////////////////

	public Helper sendkeysById(String idString, String inputString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		seleniumHelper.findWebElementbyid(idString).clear();
		seleniumHelper.findWebElementbyid(idString).sendKeys(inputString);
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper sendkeysByName(String nameString, String inputString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		seleniumHelper.findWebElementbyName(nameString).clear();
		seleniumHelper.findWebElementbyName(nameString).sendKeys(inputString);
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper sendkeysByXpath(String xpathString, String inputString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		seleniumHelper.findWebElementbyXpath(xpathString).clear();
		seleniumHelper.findWebElementbyXpath(xpathString).sendKeys(inputString);
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper sendkeysByCssPath(String csspathString, String inputString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		seleniumHelper.findWebElementbyCssSelector(csspathString).clear();
		seleniumHelper.findWebElementbyCssSelector(csspathString).sendKeys(inputString);
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper sendkeysByClassname(String classNameString, String inputString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		seleniumHelper.findWebElementbyclass(classNameString).clear();
		seleniumHelper.findWebElementbyclass(classNameString).sendKeys(inputString);
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper sendkeysByLinkText(String linkTextString, String inputString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		seleniumHelper.findWebElementbyLink(linkTextString).clear();
		seleniumHelper.findWebElementbyLink(linkTextString).sendKeys(inputString);
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper sendkeysByTagName(String tagNameString, String inputString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		seleniumHelper.findWebElementbyTagName(tagNameString).clear();
		seleniumHelper.findWebElementbyTagName(tagNameString).sendKeys(inputString);
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	////////////////////////////////////// Selenium Actions(MoveToElement and
	////////////////////////////////////// Perform Actions)
	////////////////////////////////////// ///////////////////////////

	public Helper moveAndSendKeysById(String idString, Keys inputString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		acc.moveToElement(seleniumHelper.findWebElementbyid(idString)).sendKeys(inputString).build().perform();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper moveAndSendKeysByName(String nameString, Keys inputString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		acc.moveToElement(seleniumHelper.findWebElementbyName(nameString)).sendKeys(inputString).build().perform();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper moveAndSendKeysByXpath(String xpathString, Keys inputString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		acc.moveToElement(seleniumHelper.findWebElementbyXpath(xpathString)).sendKeys(inputString).build().perform();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper moveAndSendKeysByCssPath(String csspathString, Keys inputString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		acc.moveToElement(seleniumHelper.findWebElementbyCssSelector(csspathString)).sendKeys(inputString).build()
				.perform();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper moveAndSendKeysByClassname(String classNameString, Keys inputString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		acc.moveToElement(seleniumHelper.findWebElementbyclass(classNameString)).sendKeys(inputString).build()
				.perform();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper moveAndSendKeysByLinkText(String linkTextString, Keys inputString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		acc.moveToElement(seleniumHelper.findWebElementbyLink(linkTextString)).sendKeys(inputString).build().perform();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper moveAndSendKeysByTagName(String tagNameString, Keys inputString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		acc.moveToElement(seleniumHelper.findWebElementbyTagName(tagNameString)).sendKeys(inputString).build()
				.perform();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	//////////////////////////////////// Selenium Actions (MoveToelement and Click)
	//////////////////////////////////// ///////////////////////////////

	public Helper moveAndClickById(String idString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		acc.moveToElement(seleniumHelper.findWebElementbyid(idString)).click().build().perform();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper moveAndClickByName(String nameString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		acc.moveToElement(seleniumHelper.findWebElementbyName(nameString)).click().build().perform();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper moveAndClickByXpath(String xpathString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		acc.moveToElement(seleniumHelper.findWebElementbyXpath(xpathString)).click().build().perform();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper moveAndClickByCssPath(String csspathString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		acc.moveToElement(seleniumHelper.findWebElementbyCssSelector(csspathString)).click().build().perform();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper moveAndClickByClassname(String classNameString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		acc.moveToElement(seleniumHelper.findWebElementbyclass(classNameString)).click().build().perform();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper moveAndClickByLinkText(String linkTextString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		acc.moveToElement(seleniumHelper.findWebElementbyLink(linkTextString)).click().build().perform();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper moveAndClickByTagName(String tagNameString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		acc.moveToElement(seleniumHelper.findWebElementbyTagName(tagNameString)).click().build().perform();
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	//////////////////////////////////////// Click and Send Keys
	//////////////////////////////////////// /////////////////////////////////////////////

	public Helper clickAndSendkeysById(String idString, String inputString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		seleniumHelper.findWebElementbyid(idString).click();
		seleniumHelper.findWebElementbyid(idString).sendKeys(inputString);
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper clickAndSendkeysByName(String nameString, String inputString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		seleniumHelper.findWebElementbyName(nameString).click();
		seleniumHelper.findWebElementbyName(nameString).sendKeys(inputString);
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper clickAndSendkeysByXpath(String xpathString, String inputString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		seleniumHelper.findWebElementbyXpath(xpathString).click();
		seleniumHelper.findWebElementbyXpath(xpathString).sendKeys(inputString);
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper clickAndSendkeysByCssPath(String csspathString, String inputString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		seleniumHelper.findWebElementbyCssSelector(csspathString).click();
		seleniumHelper.findWebElementbyCssSelector(csspathString).sendKeys(inputString);
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper clickAndSendkeysByClassname(String classNameString, String inputString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		seleniumHelper.findWebElementbyclass(classNameString).click();
		seleniumHelper.findWebElementbyclass(classNameString).sendKeys(inputString);
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper clickAndSendkeysByLinkText(String linkTextString, String inputString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		seleniumHelper.findWebElementbyLink(linkTextString).click();
		seleniumHelper.findWebElementbyLink(linkTextString).sendKeys(inputString);
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper clickAndSendkeysByTagName(String tagNameString, String inputString) throws Exception {
		seleniumHelper.waitForNGToLoad();
		seleniumHelper.findWebElementbyTagName(tagNameString).click();
		seleniumHelper.findWebElementbyTagName(tagNameString).sendKeys(inputString);
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	}

	public Helper sendKeysToTextBoxInTable(String textlabel, String inputtext) throws Exception {
		WebElement tab = findTheElement(By.tagName("table"));
		List<WebElement> headers = tab.findElements(By.tagName("th"));
		for (WebElement header : headers) {
			System.out.println(header.getText().trim().toString());
			if (header.getText().trim().toString().equalsIgnoreCase(textlabel)) {
				header.findElement(By.cssSelector("input")).sendKeys(inputtext);
			}
		}
		
		return new Helper(driver);
	}

	public List<String> returnAllTableData(By enterUniqueTableSelector) {
		String getrow=null;
		List<String> tableData=new ArrayList<String>();
		WebElement tab=findTheElement(enterUniqueTableSelector);
	 	List<WebElement> trows=tab.findElements(By.tagName("tr"));
	 	for(WebElement trow:trows) {
			List<WebElement> tdatas=trow.findElements(By.tagName("td"));
			int count=0;
	 		for(WebElement tdata:tdatas) {
	 			if (count==0){
		 			getrow=tdata.getText().trim().toString()+"|";
		 			count=count+1;
	 			}
	 			else {
	 				getrow=getrow+tdata.getText().trim().toString()+"|";
	 			}
	 		}
	 		tableData.add(getrow);
	 	}
		
		return tableData;
		
	}
	
	public Helper ngComboSelection(By comboElement, String option) throws Exception {
		seleniumHelper.waitForNGToLoad();
		findTheElement(comboElement).click();
		sendTextkeys(option);
		sendBoardKeys(Keys.ENTER);
		sendBoardKeys(Keys.ESCAPE);
		sleepWait(0.25);
		seleniumHelper.waitForNGToLoad();
		return new Helper(driver);
	} 
	
	public List<String> listGetText(By byTreeListDiv)
	{
		List<String> treeList=new ArrayList<String>();
		WebElement myElement = findTheElement(byTreeListDiv);
		List<WebElement> treeElements=myElement.findElements(By.xpath("//a//span"));
		for(WebElement e : treeElements) {
			treeList.add(e.getText().trim().toString());
		  System.out.println(e.getText());
		}
		return treeList;
	}
	
	public Helper DragAndDropJS(By bysource,By bydestination) throws Exception 
    {
          logInfo("Performing Drag And Drop from "+bysource.toString()+" to "+bydestination.toString());
          WebElement source=findTheElement(bysource);
          WebElement destination=findTheElement(bydestination);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("function createEvent(typeOfEvent) "
                 + "{\n" +"var event =document.createEvent(\"CustomEvent\");\n" 
                 +"event.initCustomEvent(typeOfEvent,true, true, null);\n" 
                 +"event.dataTransfer = {\n" +"data: {},\n" 
                 +"setData: function (key, value) {\n" +"this.data[key] = value;\n" +"},\n" 
                 +"getData: function (key) {\n" +"return this.data[key];\n" +"}\n" +"};\n" 
                 +"return event;\n" +"}\n" +"\n" +
                 "function dispatchEvent(element, event,transferData) "
                 + "{\n" +"if (transferData !== undefined) "
                              + "{\n" +"event.dataTransfer = transferData;\n" +"}\n" 
                 +"if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" +"} "
                              + "else if (element.fireEvent) {\n" +"element.fireEvent(\"on\" + event.type, event);\n" +"}\n" +"}\n" +"\n" 
                 +"function simulateHTML5DragAndDrop(element, destination) {\n" 
                              +"var dragStartEvent =createEvent('dragstart');\n" +"dispatchEvent(element, dragStartEvent);\n" +"var dropEvent = createEvent('drop');\n" +"dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" +"var dragEndEvent = createEvent('dragend');\n" +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +"}\n" +"\n" +"var source = arguments[0];\n" +"var destination = arguments[1];\n" +"simulateHTML5DragAndDrop(source,destination);",source, destination);
        sleepWait(1);
     return new Helper(driver);
    }

	private void logInfo(String string) {		
	}
	
	public String toggleCheck="input[aria-label='<<LABEL>>'].toggle:checked";
	public String toggleControl="input[aria-label='<<LABEL>>']";
	
	public Helper toggleAction(String toggleLabel) {
        try {
        WebElement elem=driver.findElement(By.cssSelector(toggleCheck.replace("<<LABEL>>", toggleLabel).toString()));
  elem=driver.findElement(By.cssSelector(toggleControl.replace("<<LABEL>>", toggleLabel).toString()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
               return new Helper(driver);           
        }
        catch(Exception ex) {
               WebElement elem=driver.findElement(By.cssSelector(toggleControl.replace("<<LABEL>>", toggleLabel).toString()));
               ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
               return new Helper(driver);     
        }
  }
	
	


	
}
