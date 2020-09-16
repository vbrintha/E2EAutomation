package org.oracle;

import org.testng.annotations.Test;

import com.global.GlobalLib;
import com.screens.LoginScreen;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Date;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class AppLoginParameter extends GlobalLib {

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
	
	@Parameters({"userid", "pass"})
	@Test(priority=1)
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

	@Parameters({"SearchText"})
	@Test(priority=2)
	public void search(@Optional("Titan Watches") String searchText) {
		System.out.println("Inside Search Method");
		loadURL("http://www.amazon.in/");
		maxWindow();
		WebElement txtSearch = locateUsingId("twotabsearchtextbox");
		inputText(txtSearch, searchText);
		WebElement btnSubmit = locateUsingXpath("input", "class", "nav-input");
		btnClick(btnSubmit);
	}

}
/*
Below given is the testng.xml used. SearchText parameter is not defined and hence the optional value given in the input parameter is taken

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="RegressionSuite">
  <test name="Test Basics 1" thread-count="4">
      <parameter name="userid" value="vbrintha@gmail.com"/>
      <parameter name="pass" value="Password123*"/>
      <classes>
      	<class name="org.oracle.AppLoginParameter"/>
      </classes>
  </test> <!-- Test -->
   
</suite> <!-- Suite -->

*/