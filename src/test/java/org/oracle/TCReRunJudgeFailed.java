package org.oracle;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TCReRunJudgeFailed {
	
	@Test
	public void tcA1() {
		System.out.println("TC-A1");
	}
	
	@Test(retryAnalyzer=Failed.class)
	public void tcA2() {
		Assert.assertTrue(false,"Assert Failure in tcA2");
		System.out.println("TC-A2");
	}

	@Test
	public void tcA3() {
		System.out.println("TC-A3");
	}


}
