package com.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.global.GlobalLib;

public class BookingConfirmScreen extends GlobalLib {
	
	public BookingConfirmScreen() {
		PageFactory.initElements(dr1, this);
	}
	
	@CacheLookup
	@FindBy(id = "order_no")
	private WebElement txtOrderNo;

	public WebElement getTxtOrderNo() {
		return txtOrderNo;
	}
}
