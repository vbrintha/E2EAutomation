package org.oracle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.global.GlobalLib;

public class MultiBrowserParallel extends GlobalLib{
	
	@Parameters({ "browser" })
	@BeforeClass
	public void launchbrowser(String strBrowser) {
		System.out.println(strBrowser + "Before Class");
		initDriver(strBrowser);
	}
	
	@Test
	public void loadPage() {
		System.out.println("Inside Load Page");
		loadURL("https://www.facebook.com");
	}

}
