package org.oracle;

import java.util.Date;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.global.GlobalLib;
import com.screens.LoginScreen;

public class TestngFirst extends GlobalLib {

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
	
	@Test(priority=-333)
	public void login1() {
		System.out.println("Inside Login-1 Method");
		loadURL("http://adactinhotelapp.com/");
		maxWindow();	
		LoginScreen ls = new LoginScreen();
		WebElement txtLogin = ls.getTxtUserName();
		inputText(txtLogin, "vbrintha");
		WebElement txtPassword = ls.getTxtPassword();
		inputText(txtPassword,"Password123*");
		WebElement btnLogin = ls.getBtnLogin();
		btnClick(btnLogin);
		
	}
	
	@Test(priority=-444)
	public void login2() {
		System.out.println("Inside Login-2 Method");
		loadURL("http://adactinhotelapp.com/");
		maxWindow();		
		LoginScreen ls = new LoginScreen();
		WebElement txtLogin = ls.getTxtUserName();
		inputText(txtLogin, "vbrintha");
		WebElement txtPassword = ls.getTxtPassword();
		inputText(txtPassword,"test123*");
		WebElement btnLogin = ls.getBtnLogin();
		btnClick(btnLogin);
		
	}
	
	@Test (enabled=false,priority = -100, invocationCount=2)
	public void login3() {
		System.out.println("Inside Login-3 Method");
		loadURL("http://adactinhotelapp.com/");
		maxWindow();		
		LoginScreen ls = new LoginScreen();
		WebElement txtLogin = ls.getTxtUserName();
		inputText(txtLogin, "vbrintha");
		WebElement txtPassword = ls.getTxtPassword();
		inputText(txtPassword,"test123*");
		WebElement btnLogin = ls.getBtnLogin();
		btnClick(btnLogin);
		
	}
	
	@Test(priority=44)
	public void login4() {
		System.out.println("Inside Login-4 Method");
		loadURL("http://adactinhotelapp.com/");
		maxWindow();		
		LoginScreen ls = new LoginScreen();
		WebElement txtLogin = ls.getTxtUserName();
		inputText(txtLogin, "vbrintha");
		WebElement txtPassword = ls.getTxtPassword();
		inputText(txtPassword,"test123*");
		WebElement btnLogin = ls.getBtnLogin();
		btnClick(btnLogin);
		
	}
	
	@Test
	public void login5() {
		System.out.println("Inside Login-5 Method");
		loadURL("http://adactinhotelapp.com/");
		maxWindow();		
		LoginScreen ls = new LoginScreen();
		WebElement txtLogin = ls.getTxtUserName();
		inputText(txtLogin, "vbrintha");
		WebElement txtPassword = ls.getTxtPassword();
		inputText(txtPassword,"test123*");
		WebElement btnLogin = ls.getBtnLogin();
		btnClick(btnLogin);
		
	}
	
	@Test
	public void login6() {
		System.out.println("Inside Login-6 Method");
		loadURL("http://adactinhotelapp.com/");
		maxWindow();		
		LoginScreen ls = new LoginScreen();
		WebElement txtLogin = ls.getTxtUserName();
		inputText(txtLogin, "vbrintha");
		WebElement txtPassword = ls.getTxtPassword();
		inputText(txtPassword,"test123*");
		WebElement btnLogin = ls.getBtnLogin();
		btnClick(btnLogin);
		
	}
}
