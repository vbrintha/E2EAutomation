package com.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.global.GlobalLib;

public class SelectHotelScreen extends GlobalLib {
	
	public SelectHotelScreen() {
		PageFactory.initElements(dr1, this);
	}
	
	@CacheLookup
	@FindBy(id = "radiobutton_0")
	private WebElement rdoSelect;
	
	@CacheLookup
	@FindBy(id = "continue")
	private WebElement btnContinue;
	

	public WebElement getRdoSelect() {
		return rdoSelect;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}
}
