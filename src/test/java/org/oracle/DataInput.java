package org.oracle;

import java.util.Date;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.global.GlobalLib;
import com.screens.LoginScreen;

public class DataInput extends GlobalLib {

	@BeforeClass
	private void launchBrowser() {
		initDriver("Chrome");
		System.out.println("Launch Browser");
	}
	
	@AfterClass
	private void closeBrowser() {
		dr1.quit();
		System.out.println("Quit Browser");
	}
	
	@BeforeMethod
	private void startTime() {
		System.out.println(new Date());
	}
	
	@AfterMethod
	private void endTime() {
		System.out.println(new Date());
	}
	
	@Test(priority=1,dataProvider = "logindetails")
	public void login1(String username, String password) {
		System.out.println("Inside Login-1 Method");
		loadURL("http://adactinhotelapp.com/");
		maxWindow();	
		LoginScreen ls = new LoginScreen();
		WebElement txtLogin = ls.getTxtUserName();
		inputText(txtLogin, username);
		WebElement txtPassword = ls.getTxtPassword();
		inputText(txtPassword,password);
		WebElement btnLogin = ls.getBtnLogin();
		btnClick(btnLogin);
		
	}

	@Test(priority=2,dataProvider = "ProductsToSearch")
	public void search(String searchText) {
		System.out.println("Inside Search Method");
		loadURL("http://www.amazon.in/");
		maxWindow();
		WebElement txtSearch = locateUsingId("twotabsearchtextbox");
		inputText(txtSearch, searchText);
		WebElement btnSubmit = locateUsingXpath("input", "class", "nav-input");
		btnClick(btnSubmit);
	}
		
	@Test(priority=3, dataProvider = "FromToDate")
	public void search(String strFrom, String strTo) throws InterruptedException {
		loadURL("http://www.makemytrip.com/");
		maxWindow();
		WebElement lnkDeparture = locateUsingXpath("span","class","lbl_input latoBold appendBottom10");
		btnClick(lnkDeparture);
		WebElement lnkDepDate=locateUsingXpath("div","aria-label",strFrom);
		btnClick(lnkDepDate);
		WebElement lnkReturn = locateUsingXpath("div","data-cy","returnArea");
		btnClick(lnkReturn);
		WebElement lnkRetDate=locateUsingXpath("div","aria-label",strTo);
		btnClick(lnkRetDate);
	}
	
	
		
	@DataProvider(name = "logindetails")
	public Object[][] loginDetails() {
		return new Object[][] {
			{"vbrintha" , "Password123*"},
			{"test", "Pass123"},
			{"", "Password123"},
			{"vbrintha", ""},
		};
	}
	
	@DataProvider (name = "ProductsToSearch")
	public Object[][] productsToSearch(){
		return new Object[][] {
			{"Honor 8x"},
			{"Samsung"},
			{"Whirlpool"},
			{"Titan"},
			{"Power Bank"},
			{"Portable Hard Disk"},
			{"Toshiba Laptop"},
			{"Sony Speaker"},
			{"Voltas"},
			{"Lenova Tab"}
		};
	}
	
	@DataProvider(name = "FromToDate")
	public Object[][] fromToDate() {
		return new Object[][] {
			{"Thu Sep 10 2020" , "Wed Sep 16 2020"},
			{"Fri Sep 11 2020" , "Thu Sep 17 2020"},
			{"Sat Sep 12 2020", "Mon Sep 14 2020"}
		};
	}
}

