package org.oracle;

import org.testng.annotations.Test;

public class SetDependency {
	@Test
	public void tc1() {
		System.out.println("TC-1");
	}
	
	@Test
	public void tc2() {
		System.out.println("TC-2");
	}

	@Test(dependsOnMethods= {"tc4"})
	public void tc3() {
		System.out.println("TC-3");
	}

	@Test
	public void tc4() {
		System.out.println("TC-4");
	}

	@Test
	public void tc5() {
		System.out.println("TC-5");
	}

	@Test
	public void tc6() {
		System.out.println("TC-6");
	}


}
