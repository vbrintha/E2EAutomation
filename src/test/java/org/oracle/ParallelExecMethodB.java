package org.oracle;

import org.testng.annotations.Test;

public class ParallelExecMethodB {
	
	@Test
	public void tcB1() {
		System.out.println("TC-B1="+Thread.currentThread().getId());
	}
	
	@Test
	public void tcB2() {
		System.out.println("TC-B2="+Thread.currentThread().getId());
	}

	@Test
	public void tcB3() {
		System.out.println("TC-B3="+Thread.currentThread().getId());
	}
}
