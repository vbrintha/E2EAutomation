package com.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.global.GlobalLib;

//import com.global.GlobalLib;

//Page Object Model (POM) for Login Page.
public class LoginScreen extends GlobalLib{
		
		public LoginScreen() {
			PageFactory.initElements(dr1, this);
		}
		
		@CacheLookup
		@FindBy(id = "username")
		private WebElement txtUserName;
		
		@CacheLookup
		@FindBy(id = "password")
		private WebElement txtPassword;

		@CacheLookup
		@FindBy(id = "login")
		private WebElement btnLogin;

		public WebElement getTxtUserName() {
			return txtUserName;
		}

		public WebElement getTxtPassword() {
			return txtPassword;
		}

		public WebElement getBtnLogin() {
			return btnLogin;
		}
			
}
