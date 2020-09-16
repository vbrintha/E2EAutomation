package com.global;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.io.*;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GlobalLib {
	
	public static WebDriver dr1;
	public static Actions ac;
	public static Robot rb;
	public static Alert al;
	public static TakesScreenshot tss;
	public static JavascriptExecutor js;
	public static Select sel;
	public static String dirPath;
	public static File f;
	public static FileInputStream inputStream;
	public static FileOutputStream outputStream;
	public static Workbook wb;
	public static Sheet sh;
	public static Date dt;
	//Method-1 : To initiate driver
	
	public static void initDriver(String strDriver) {
		System.out.println("strDriver = "+strDriver);
		if (strDriver.equals("Chrome")){
			System.out.println("Common Chrome");
			WebDriverManager.chromedriver().setup();
			dr1 = new ChromeDriver();
		}
		else if (strDriver.equals("IE")){
			System.out.println("Common IE");			
			WebDriverManager.iedriver().setup();
			dr1 = new InternetExplorerDriver();
		}
		else if (strDriver.equals("FireFox")) {
			System.out.println("Common Firefox");
			WebDriverManager.firefoxdriver().setup();
			dr1 = new FirefoxDriver();
			
		}
	}

	
	/*
	 * public static void initDriver() {
		//System.out.println("Inside initDriver");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\VEV\\eclipse-workspace\\Day2SelPracticals\\drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		dr1 = new ChromeDriver();
	}
	*/
	
	public static void quitBrowser() {
		dr1.quit();
	}
	
	//Method-2 : To load URL
	public static void loadURL(String url) {
		dr1.get(url);
	}
	
	//Method-3 : To fetch the title of the page.
	public static String fetchTitle() {
		return dr1.getTitle();
	}
	
	//Method-4 : To fetch the url of the page.
	public static String fetchURL() {
		return dr1.getCurrentUrl();
	}
	
	//Method-5 : To locate an element using Id.
	public static WebElement locateUsingId(String elementId){
		return dr1.findElement(By.id(elementId));
	}
	
	//Method-6 : To locate an element using Name.
	public static WebElement locateUsingNm(String elementNm){
		return dr1.findElement(By.name(elementNm));
	}
	
	//Method-7 : To locate an element using xpath 
	public static WebElement locateUsingXpath(String tagName, String attrName, String attrValue){
		String strXPath;
		strXPath = "//"+tagName+"[@"+attrName+"='"+attrValue+"']";
		return dr1.findElement(By.xpath(strXPath));
	}
	
	//Method-8 : To input value in a field
	public static void inputText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	//Method-9 : To get the field value
	public static String getFieldValue(WebElement element) {
		return element.getAttribute("value");
	}
	
	public static String getFieldText(WebElement element) {
		return element.getText();
	}
	
	
	public static void btnClick(WebElement element) {
		element.click();
	}
	//Method-10 : To maximize the window
	public static void maxWindow() {
		dr1.manage().window().maximize();
	}
	
	//Method-11 : To mouseover an element
	public static void mouseOver(WebElement element) {
		ac.moveToElement(element).perform();
	}
	
	//Method-12 : To drag and Drop
	public static void dragAndDrop(WebElement Source, WebElement Dest) {
		ac.dragAndDrop(Source, Dest); 
	}
	
	//Method-13 :  Right click on an element
	public static void rightClick(WebElement element) {
		ac.contextClick(element).perform();
	}
	
	//Method-14 : Initiate Action class
	public static void initActions()
	{
		 ac = new Actions(dr1);
	}
	
	//Method-15 : Initiate Robot class
	public static void initRobot() throws AWTException {
		rb = new Robot();
	}

	//Method-16	: Press keyboard key for specified number of times.
	public static void keyBoartInput(int Key, int count) {
		for (int i=0;i<count;i++) {
			rb.keyPress(Key);
			rb.keyRelease(Key);
		}
	}
	
	//Method-17 : Click Ok in Simple or Confirm Alert
	public static void alertOkClick() {
		al = dr1.switchTo().alert();
		al.accept();
	}
	
	//Method-18 : Click Cancel in Confirm Alert
	public static void alertCancelClick() {
		al = dr1.switchTo().alert();
		al.dismiss();
	}
	
	//Method-19	: Enter an input text in prompt alert
	public static void alertInputText(String text) {
		al = dr1.switchTo().alert();
		al.sendKeys(text);
	}
	
	//Method-20 : Overloading loadURL to handle Authentication
	public static void loadURL(String url, String authUserid, String authPassword) {
		String strHttp = (url.replaceFirst("\\\\", "\\\\\\\\")).substring(0,(url.indexOf(":"))+3);
		String strDomain = (url.replaceFirst("\\\\", "\\\\\\\\")).substring((url.indexOf(":"))+3,(url.length()+1));
		String tempURL = strHttp + authUserid + ":" + authPassword + "@" + strDomain;
		System.out.println(tempURL);
		dr1.get(tempURL);
	}
	
	//Method-21 : Store Screenshot in file.
	public static void captureScreenShot(String filePath) throws IOException {
		tss = (TakesScreenshot)dr1;
		File Source = tss.getScreenshotAs(OutputType.FILE);
		File Destination = new File(filePath);
		FileUtils.copyFile(Source, Destination);
				
	}
	
	public static void initJS(){
		js = (JavascriptExecutor)dr1;
	}
	
	//Method-22 : InputText to input value in a field using Javascript.
	public static void inputTextJS(WebElement element, String text) {
		initJS();
		String tempStr = "arguments[0].setAttribute('value','"+text+"')";
		js.executeScript(tempStr, element);
	}
		
	//Method-23 : To get the field value using Javascript
	public static String getFieldValueJS(WebElement element) {
		initJS();
		return ((String) js.executeScript("return arguments[0].getAttribute('value')", element));
	}
	
	//Method-24 : To scroll down
	public static void scrollDown(WebElement element) {
		initJS();
		js.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	
	//Method-25 : To scroll up
	public static void scrollUp(WebElement element) {
		initJS();
		js.executeScript("arguments[0].scrollIntoView(false)",element);
	}
	
	//Method-26 : Switch To Frame using index
	public static void switchToFrameIndex(int Index) {
		dr1.switchTo().frame(Index);
	}

	//Method-27 : Switch To Frame using Id or Name - Overloading
	public static void switchToFrameIdNm(String idNm) {
		dr1.switchTo().frame(idNm);
	}

	//Method-28 : Switch To Frame using WebElement - Overloading
	public static void switchToFrameIdNm(WebElement element) {
		dr1.switchTo().frame(element);
	}
	
	//Method-29 : Switch To Main Window
	public static void switchToMainWindow() {
		dr1.switchTo().defaultContent();
	}
	
	//Method-30 : Switch To Parent Frame.
	public static void switchToParentFrame() {
		dr1.switchTo().parentFrame();
	}
	
	//Method-31 : Select Drop Down value by Index
	public static void ddSelByIndex(WebElement selElement,int index) {
		sel = new Select(selElement);
		sel.selectByIndex(index);
	}
	
	//Method-32 : Select Drop Down value by Value
	public static void ddSelByValue(WebElement selElement,String value) {
		sel = new Select(selElement);
		sel.selectByValue(value);
	}
	
	//Method-33 : Select Drop Down value by Visible Text
	public static void ddSelByVisText(WebElement selElement,String text) {
		sel = new Select(selElement);
		sel.selectByVisibleText(text);
	}
	
	//Method-34 : To get drop down options values and text
	public static List<String> ddGetOptions(WebElement selElement, String type) {
		sel = new Select(selElement);
		List<WebElement> lstOptions = sel.getOptions();
		List<String> lstOptionsText = new ArrayList<String>();
		if (type=="text") {
				for (int i=0;i<lstOptions.size();i++) {
					lstOptionsText.add(lstOptions.get(i).getText());
				}
		}
		else if (type == "value"){
			for (int i=0;i<lstOptions.size();i++) {
				lstOptionsText.add(lstOptions.get(i).getAttribute("value"));
			}
		}
		return lstOptionsText;
	}
	
	//Method-35 : To get drop down options text
	public static List<String> ddGetOptionsText(WebElement selElement) {
		return ddGetOptions(selElement, "text");
	}
	
	//Method-36 : To get drop down values text
	public static List<String> ddGetOptionsValue(WebElement selElement) {
		return ddGetOptions(selElement, "value");	
	}
	
	//Method-37 : To find if the dropdown is single or multiple select
	public static boolean ddIsMultiple(WebElement selElement) {
		sel = new Select(selElement);
		Boolean flag = sel.isMultiple();
		return flag;
	}
	
	//Method-38 : To get drop down selected option's value / text
	public static List<String> ddGetSelectedOptions(WebElement selElement, String type) {
		sel = new Select(selElement);
		List<WebElement> lstOptions = sel.getAllSelectedOptions();
		List<String> lstOptionsText = new ArrayList<String>();
		if (type=="text") {
				for (int i=0;i<lstOptions.size();i++) {
					lstOptionsText.add(lstOptions.get(i).getText());
				}
		}
		else if (type == "value"){
			for (int i=0;i<lstOptions.size();i++) {
				lstOptionsText.add(lstOptions.get(i).getAttribute("value"));
			}
		}
		return lstOptionsText;
	}
	
	//Method-39 : To get drop down selected option's text
	public static List<String> ddGetSelectedOptionsText(WebElement selElement) {
		return ddGetSelectedOptions(selElement, "text");
	}
	
	//Method-40 : To get drop down selected option's value
	public static List<String> ddGetSelectedOptionsValue(WebElement selElement) {
		return ddGetSelectedOptions(selElement, "value");	
	}

	//Method-41 : To get the first selected option's text.
	public static String ddGetFirstSelectedOptionsText(WebElement selElement) {
		return ddGetSelectedOptions(selElement,"text").get(0);
	}
	
	//Method-42 : To get the first selected option's value.
	public static String ddGetFirstSelectedOptionsValue(WebElement selElement) {
		return ddGetSelectedOptions(selElement,"value").get(0);
	}
	
	//Method-43 : To deselect an option using Index.
	public static void ddDeselectByIndex(WebElement selElement, int Index) {
		sel = new Select(selElement);
		sel.deselectByIndex(Index);
	}
	
	//Method-44 : To deselect an option using text.
	public static void ddDeselectByText(WebElement selElement, String text) {
		sel = new Select(selElement);
		sel.deselectByVisibleText(text);
	}

	//Method-45 : To deselect an option using Value.
	public static void ddDeselectByValue(WebElement selElement, String text) {
		sel = new Select(selElement);
		sel.deselectByValue(text);
	}
	
	//Method-46 : To get parent window id.
	public static String getParentWindowId() {
		return dr1.getWindowHandle();
	}
	
	//Method-47 : To switch to an child window
	public static void switchToChildWindowId () {
		String pWid = getParentWindowId();
		Set<String> allWindowsId = dr1.getWindowHandles();
		for (String eachWindowId : allWindowsId){
			if(pWid != eachWindowId){
				dr1.switchTo().window(eachWindowId);
			}
		}
	}
	
	//Method-48 : To switch to window. Called from switchToWindowURL, switchToWindowTitle
	public static void switchToWindow(String text) {
		dr1.switchTo().window(text);
	}

	//Method-49 : To switch to window using URL.
	public static void switchToWindowURL(String URL) {
		switchToWindow(URL);
	}
	
	//Method-50 : To switch to window using Title.
	public static void switchToWindowTitle(String Title) {
		switchToWindow(Title);
	}
	
	//Method-51 : To check if an element is hidden or not.
	public static boolean eleIsHidden(WebElement element) {
		return element.isDisplayed();
	}
	
	//Method-52 : To check if an element is selected or not.	
	public static boolean eleIsSelected(WebElement element) {
		return element.isSelected();
	}
	
	//Method-53 : To check if an element is enabled or not.
	public static boolean eleIsEnabled(WebElement element) {
		return element.isSelected();
	}

	//Method-54 : To get specific row data from Web Table.
	public static List<String> getWebTableDataRowText(WebElement tableElement, int RowNum) {
		List<WebElement> lstRows = tableElement.findElements(By.tagName("tr"));
	//	WebElement rowElement = lstRows.get(RowNum);
		WebElement rowElement = lstRows.get(RowNum-1);
		List<WebElement> lstRowDataElement = rowElement.findElements(By.tagName("td"));
		List<String> lstRowDataText = new ArrayList<String>();
		for (int i=0;i<lstRowDataElement.size();i++) {
			lstRowDataText.add(lstRowDataElement.get(i).getText());
		}
		return lstRowDataText;
	}
	
	//Method-55 : To get specific column data from Web Table.
	public static List<String> getWebTableDataColumnText(WebElement tableElement, int ColNum) {
		List<WebElement> lstRows = tableElement.findElements(By.tagName("tr"));
		List<String> lstColDataText = new ArrayList<String>();
		for (int i=1;i<lstRows.size();i++) {
			List<WebElement> lstRowDataElement = lstRows.get(i).findElements(By.tagName("td"));
			lstColDataText.add(lstRowDataElement.get(ColNum-1).getText());
		}
		return lstColDataText;
	}

	//Method-56 : To get last row data from Web Table.
	public static List<String> getWebTableDataLastRowText(WebElement tableElement) {
		return getWebTableDataRowText(tableElement, tableElement.findElements(By.tagName("tr")).size()-1);
	}
	
	//Method-57 : To get last col data from Web Table.
	public static List<String> getWebTableDataLastColumnText(WebElement tableElement) {
		//return tableElement.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size();
		return getWebTableDataColumnText(tableElement,tableElement.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
	}
	
	//Method-58 : To get Header row data from Web Table.
	public static List<String> getWebTableHeaderRowText(WebElement tableElement) {
		List<WebElement> lstRows = tableElement.findElements(By.tagName("tr"));
		WebElement rowElement = lstRows.get(0);
		List<WebElement> lstRowDataElement = rowElement.findElements(By.tagName("th"));
		List<String> lstRowDataText = new ArrayList<String>();
		for (int i=0;i<lstRowDataElement.size();i++) {
			lstRowDataText.add(lstRowDataElement.get(i).getText());
		}
		return lstRowDataText;
	}
	
	//Method-59 : To get specific column data from Header Row in a Web Table.
	public static String getWebTableHeaderColumnText(WebElement tableElement, int ColNum) {
		List<WebElement> lstRows = tableElement.findElements(By.tagName("tr"));
		List<WebElement> lstRowDataElement = lstRows.get(0).findElements(By.tagName("th"));
		String lstColDataText = lstRowDataElement.get(ColNum-1).getText();
		return lstColDataText;
	}
	
	//Method-60 : To get data from specific (Row, Column) from a Web Table.
	public static String getWebTableRowColDataText(WebElement tableElement, int RowNum, int ColNum){
		return getWebTableDataRowText(tableElement, RowNum).get(ColNum-1);
	}
	
	//Method-61 : To set the project directory.
	public static void setUserDir() {
		dirPath = System.getProperty("user.dir");
	}
	
	//Method-62 : To set the Excel working sheet.
	public static void setWorkingSheet(String fPath, String fSheet) throws IOException {
		setUserDir();
		String path = dirPath+fPath;
		System.out.println(path);
		f = new File(path);
		inputStream = new FileInputStream(f);
		//Workbook wb = new XSSFWorkbook(inputStream);
		wb = new XSSFWorkbook(inputStream);
		sh = wb.getSheet(fSheet);
	}
	
	//Method-63 : To write into a file.
	public static void writeIntoExcelFile() throws IOException {
		outputStream = new FileOutputStream(f);
		wb.write(outputStream);
		
	}
	
	//Method-64 : To get total rows in the excel.
	public static int getExcelTotalRows() throws IOException{
		return (sh.getPhysicalNumberOfRows());
	}
	
	//Method-65 : To get a particular row data from the excel
	public static List<String> getExcelRowData(int rowNum) throws IOException {
		Row r = sh.getRow(rowNum-1);
		List<String> lstRowData = new ArrayList<String>();
		for (int i=0;i<r.getPhysicalNumberOfCells();i++) {
			Cell c = r.getCell(i);
			if (c.getCellType() == 1)
			{
				lstRowData.add(c.getStringCellValue());
			}
			else if (c.getCellType()== 0)
			{
				if (DateUtil.isCellDateFormatted(c)) {
					lstRowData.add(new SimpleDateFormat("dd/MM/YYYY").format(c.getDateCellValue()));
				}
				else {
					lstRowData.add(String.valueOf((long)c.getNumericCellValue()));
				}
			}
		}
		return lstRowData;
	}
	
	// Method-66 : To get a particular column data from Excel
	public static List<String> getExcelColumnData(int colNum) throws IOException{
		int rowCount = getExcelTotalRows();
		List<String> lstColData = new ArrayList<String>();
		for (int i=0;i<rowCount;i++) {
			lstColData.add(getExcelRowData(i+1).get(colNum-1));
		}
		return lstColData;
		
	}

	// Method-67 : To get a particular cell value based on the row and column given.
	public static String getExcelCellData(int rowNum, int colNum) throws IOException{
		return (getExcelRowData(rowNum).get(colNum-1));
	}
	
	// Method-68 : To create a excel cell with string data.
	public static void createExcelCellWithData(String data, int rowNum, int colNum) {
		Row r = sh.getRow(rowNum-1);
		Cell c = r.createCell(colNum-1);
		c.setCellValue(data);
	}

	public static Date getCurrentDateandTime() {
		return (new Date());
	}
	/*
	public int getExcelTotalRows(String fPath, String fSheet) throws IOException{
//		setWorkingSheet(fPath, fSheet);
		return (sh.getPhysicalNumberOfRows());
	}
	
	
	public List<String> getExcelRowData(String fPath, String fSheet, int rowNum) throws IOException {
//		setWorkingSheet(fPath, fSheet);
		Row r = sh.getRow(rowNum-1);
		List<String> lstRowData = new ArrayList<String>();
		for (int i=0;i<r.getPhysicalNumberOfCells();i++) {
			Cell c = r.getCell(i);
			if (c.getCellType() == 1)
			{
				lstRowData.add(c.getStringCellValue());
			}
			else if (c.getCellType()== 0)
			{
				if (DateUtil.isCellDateFormatted(c)) {
					lstRowData.add(new SimpleDateFormat("dd/MMM/yy").format(c.getDateCellValue()));
				}
				else {
					lstRowData.add(String.valueOf((long)c.getNumericCellValue()));
				}
			}
		}
		return lstRowData;
	}
	
	public List<String> getExcelColumnData(String fPath, String fSheet, int colNum) throws IOException{
		int rowCount = getExcelTotalRows(fPath, fSheet);
		//List<String> lstRowData = new ArrayList<String>();
		List<String> lstColData = new ArrayList<String>();
		for (int i=0;i<rowCount;i++) {
			lstColData.add(getExcelRowData(fPath, fSheet, i+1).get(colNum-1));
		}
		return lstColData;
		
	}

	
	public String getExcelCellData(String fPath, String fSheet, int rowNum, int colNum) throws IOException{
		return (getExcelRowData(fPath, fSheet, rowNum).get(colNum-1));
	}
	*/
}
