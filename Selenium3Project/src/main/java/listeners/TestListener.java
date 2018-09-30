package listeners;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import easy.util.BaseUtils;
import easy.util.ExtentReporter;
import easy.util.Operations;
import easy.util.RetryFailedTests;
public class TestListener implements ITestListener, IAnnotationTransformer {

	public void onTestStart(ITestResult result) {

		System.out.println("Inside on test Start");
		String methodName = result.getTestClass() + "::"
				+ result.getName().toString();
		System.out
				.println("on test  start listener for the method" + methodName);
		ExtentReporter.startReporting(methodName);
	}

	public void onTestSuccess(ITestResult result) {

		String methodName = result.getName().toString();
		BaseUtils.test.pass(methodName);
		System.out.println("After test passed listener");
	}

	public void onTestFailure(ITestResult result) {

		String methodName = result.getName().toString();
		Operations.takeScreenShot(methodName);
		BaseUtils.test.fail(methodName);
		System.out.println("After test Failed listener");
	}

	public void onTestSkipped(ITestResult result) {

		// TODO Auto-generated method stub
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {

		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {

		System.out.println("Inside on Finish");
		// TODO Auto-generated method stub
	}

	public void transform(ITestAnnotation annotation, Class testClass,
			Constructor testConstructor, Method testMethod) {

		// TODO Auto-generated method stub
		annotation.setRetryAnalyzer(RetryFailedTests.class);
	}
}
