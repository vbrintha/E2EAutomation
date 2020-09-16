package com.global;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.screens.LoginScreen;
import com.screens.SearchHotelScreen;

public class GlobalAdactinLib extends GlobalLib {
	public static LoginScreen ls;
	public static SearchHotelScreen scrSearchHotel;
	
	public static void adactinLogin(String userid, String password) {
		ls = new LoginScreen();
		WebElement txtUserName = ls.getTxtUserName();
		inputText(txtUserName, "vbrintha");
		WebElement txtPassword = ls.getTxtPassword();
		inputText(txtPassword, "Password123*");
		WebElement btnLogin = ls.getBtnLogin();
		btnClick(btnLogin);	
		WebElement txtSearchHotel = locateUsingXpath("table", "class", "login");
		String lblSearchHotel = getWebTableRowColDataText(txtSearchHotel, 1, 1);
		Assert.assertEquals("Search Hotel (Fields marked with Red asterix (*) are mandatory)", lblSearchHotel);
	}
	
	public static void adactinSearch(List<String> lstSearchInputs) {
		scrSearchHotel = new SearchHotelScreen();
		WebElement selLocation = scrSearchHotel.getSelLocation();
		WebElement selHotels = scrSearchHotel.getSelHotels();
		WebElement selRoomType = scrSearchHotel.getSelRoomType();
		WebElement selNumRooms = scrSearchHotel.getSelNumRooms();
		WebElement txtDateIn = scrSearchHotel.getTxtDateIn();
		WebElement txtDateOut = scrSearchHotel.getTxtDateOut();
		WebElement selNumAdults = scrSearchHotel.getSelNumAdults();
		WebElement selNumChild = scrSearchHotel.getSelNumChild();
		WebElement btnSubmit = scrSearchHotel.getBtnSubmit();
		
		ddSelByVisText(selLocation, lstSearchInputs.get(0));
		ddSelByVisText(selHotels, lstSearchInputs.get(1));
		ddSelByVisText(selRoomType, lstSearchInputs.get(2));
		ddSelByVisText(selNumRooms, lstSearchInputs.get(3));
		inputTextJS(txtDateIn, lstSearchInputs.get(4));
		inputTextJS(txtDateOut, lstSearchInputs.get(5));
		ddSelByVisText(selNumAdults,lstSearchInputs.get(6));
		ddSelByVisText(selNumChild, lstSearchInputs.get(7));
		
		btnClick(btnSubmit);
		
		WebElement tblSelHotel = locateUsingXpath("table", "class", "login");
		//System.out.println(getWebTableDataRowText(tblSelHotel, 1));
		System.out.println(getWebTableRowColDataText(tblSelHotel, 1, 1));
		Assert.assertEquals("Select Hotel", getWebTableRowColDataText(tblSelHotel, 1, 1));
		
		//getWebTableHeaderColumnText(tblSelHotel, 1);
	}
	
	public static void adactinLogout() {
		WebElement lnkLogout = locateUsingXpath("a", "href", "Logout.php");
		btnClick(lnkLogout);
		WebElement lnkLoginAgain = locateUsingXpath("a", "href", "index.php");
		Assert.assertEquals("Click here to login again", getFieldText((lnkLoginAgain)));
	}
}

