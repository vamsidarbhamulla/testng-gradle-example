package testng.listeners;

import org.testng.*;

public class TestExecListener implements ITestListener, IClassListener {

    private ThreadLocal<ITestContext> contexts = new ThreadLocal<>();
    private ThreadLocal<ITestResult> testResults = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        this.testResults.set(result);
        this.contexts.set(this.testResults.get().getTestContext());
        testMethodLogStatus( "() started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testMethodLogStatus("() completed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        var errorInfo = "() failed" + "\n "+ testResults.get().getThrowable().getMessage();
        testMethodLogStatus(errorInfo);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        var skippedInfo = "() skipped" + "\n "+ testResults.get().getThrowable().getMessage();
        testMethodLogStatus(skippedInfo);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        var errorInfo = "() failed" + "\n "+ testResults.get().getThrowable().getMessage();
        testMethodLogStatus(errorInfo);
    }

    @Override
    public void onStart(ITestContext context) {
        this.contexts.set(context);
        testXmlTagLogStatus(" --> test tag started");
    }

    @Override
    public void onFinish(ITestContext context) {
        testXmlTagLogStatus(" --> test tag ended");
    }

    @Override
    public void onBeforeClass(ITestClass testClass) {
        testClassLogStatus(testClass.getRealClass().getName()+" class started");
    }

    @Override
    public void onAfterClass(ITestClass testClass) {
        testClassLogStatus(testClass.getRealClass().getName() + " class ended");
    }

    private void testXmlTagLogStatus(String tagInfo) {
        System.out.println("\n" +Thread.currentThread() + ": "
                + contexts.get().getName() + tagInfo);
    }

    private void testClassLogStatus(String classInfo) {
        System.out.println("\n"+ Thread.currentThread() + ": " + classInfo);
    }

    private void testMethodLogStatus(String methodInfo) {
        System.out.println("\n" + Thread.currentThread() + ": "
                + testResults.get().getTestClass().getRealClass().getName()
                +"." + testResults.get().getMethod().getMethodName()
                + methodInfo);
    }
}
