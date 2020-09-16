package org.oracle;

import org.testng.annotations.Test;

public class ParallelExecMethodA {
	
	@Test
	public void tcA1() {
		System.out.println("TC-A1="+Thread.currentThread().getId());
	}
	
	@Test
	public void tcA2() {
		System.out.println("TC-A2="+Thread.currentThread().getId());
	}

	@Test
	public void tcA3() {
		System.out.println("TC-A3="+Thread.currentThread().getId());
	}


}
