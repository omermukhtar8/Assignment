import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends ExtentReporterNG implements ITestListener {

    ExtentTest test;
    ExtentReports extent=ExtentReporterNG.getReportObject();


    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("Test: " + result.getMethod().getMethodName() + " execution started.");
        test= extent.createTest(result.getMethod().getMethodName());


    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass(result.getMethod().getMethodName() + " completed successfully.");

    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getMethod().getMethodName() + " failed");

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Starting Testing Suite");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Testing Suite finished");

        extent.flush();
    }
}
