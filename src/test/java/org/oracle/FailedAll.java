package org.oracle;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class FailedAll implements IAnnotationTransformer{

	public void transform(ITestAnnotation arg0, Class arg1, Constructor arg2, Method arg3) {
		
		IRetryAnalyzer i = arg0.getRetryAnalyzer();
		if (i==null) {
			arg0.setRetryAnalyzer(Failed.class);
		
		}
	}
	

}
