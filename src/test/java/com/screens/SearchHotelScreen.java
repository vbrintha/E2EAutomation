package com.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.global.GlobalLib;

public class SearchHotelScreen extends GlobalLib{
	
	public SearchHotelScreen() {
		PageFactory.initElements(dr1, this);
	}
	
	@CacheLookup
	@FindBy(id = "location")
	private WebElement selLocation;
	
	@CacheLookup
	@FindBy(id = "hotels")
	private WebElement selHotels;

	@CacheLookup
	@FindBy(id = "room_type")
	private WebElement selRoomType;

	@CacheLookup
	@FindBy(id = "room_nos")
	private WebElement selNumRooms;

	@CacheLookup
	@FindBy(id = "datepick_in")
	private WebElement txtDateIn;

	@CacheLookup
	@FindBy(id = "datepick_out")
	private WebElement txtDateOut;

	@CacheLookup
	@FindBy(id = "adult_room")
	private WebElement selNumAdults;

	@CacheLookup
	@FindBy(id = "child_room")
	private WebElement selNumChild;

	@CacheLookup
	@FindBy(id = "Submit")
	private WebElement btnSubmit;

	public WebElement getSelLocation() {
		return selLocation;
	}

	public WebElement getSelHotels() {
		return selHotels;
	}

	public WebElement getSelRoomType() {
		return selRoomType;
	}

	public WebElement getSelNumRooms() {
		return selNumRooms;
	}

	public WebElement getTxtDateIn() {
		return txtDateIn;
	}

	public WebElement getTxtDateOut() {
		return txtDateOut;
	}

	public WebElement getSelNumAdults() {
		return selNumAdults;
	}

	public WebElement getSelNumChild() {
		return selNumChild;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

}
