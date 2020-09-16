package org.oracle;

import org.testng.annotations.Test;

public class ParallelExecMethodD {
	
	@Test
	public void tcD1() {
		System.out.println("TC-D1="+Thread.currentThread().getId());
	}
	
	@Test
	public void tcD2() {
		System.out.println("TC-D2="+Thread.currentThread().getId());
	}

	@Test
	public void tcD3() {
		System.out.println("TC-D3="+Thread.currentThread().getId());
	}
}
