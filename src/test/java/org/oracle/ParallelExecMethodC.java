package org.oracle;

import org.testng.annotations.Test;

public class ParallelExecMethodC {
	
	@Test
	public void tcC1() {
		System.out.println("TC-C1="+Thread.currentThread().getId());
	}
	
	@Test
	public void tcC2() {
		System.out.println("TC-C2="+Thread.currentThread().getId());
	}

	@Test
	public void tcC3() {
		System.out.println("TC-C3="+Thread.currentThread().getId());
	}


}
