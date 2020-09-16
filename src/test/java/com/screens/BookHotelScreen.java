package com.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.global.GlobalLib;

public class BookHotelScreen extends GlobalLib {
	
	public BookHotelScreen() {
		PageFactory.initElements(dr1, this);
	}
	
	@CacheLookup
	@FindBy(id = "first_name")
	private WebElement txtFirstName;
	
	@CacheLookup
	@FindBy(id = "last_name")
	private WebElement txtLastName;
	
	@CacheLookup
	@FindBy(id = "address")
	private WebElement txtAddress;
	
	@CacheLookup
	@FindBy(id = "cc_num")
	private WebElement txtCC;
	
	@CacheLookup
	@FindBy(id = "cc_type")
	private WebElement selCCType;
	
	@CacheLookup
	@FindBy(id = "cc_exp_month")
	private WebElement selExpMonth;
	
	@CacheLookup
	@FindBy(id = "cc_exp_year")
	private WebElement selExpYear;
	
	@CacheLookup
	@FindBy(id = "cc_cvv")
	private WebElement txtCVVNum;
	
	@CacheLookup
	@FindBy(id = "book_now")
	private WebElement btnBookNow;

	
	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCC() {
		return txtCC;
	}

	public WebElement getSelCCType() {
		return selCCType;
	}

	public WebElement getSelExpMonth() {
		return selExpMonth;
	}

	public WebElement getSelExpYear() {
		return selExpYear;
	}

	public WebElement getTxtCVVNum() {
		return txtCVVNum;
	}
	
	public WebElement getBtnBookNow() {
		return btnBookNow;
	}

}
