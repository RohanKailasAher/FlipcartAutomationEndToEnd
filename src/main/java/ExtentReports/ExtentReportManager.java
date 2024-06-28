package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static Base.BaseClass.driver;


public class ExtentReportManager implements ITestListener {
    ExtentSparkReporter extentSparkReporter;
    protected static ExtentReports extentReports;
    protected ExtentTest extentTest;

    public void onStart(ITestContext testContext) {

        // Initialize Extent Reports
        extentSparkReporter = new ExtentSparkReporter("./ExtentReportDemo.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        // Set System Information
        extentReports.setSystemInfo("Application", "Flipkart");
       extentReports.setSystemInfo("Os", "Windows10");
        extentReports.setSystemInfo("User", "Admin");
        extentReports.setSystemInfo("Browser", "Chrome");

        // Configure Report Settings
        extentSparkReporter.config().setDocumentTitle("Extent Report Demo");
        extentSparkReporter.config().setReportName("Test_Report");
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setTimeStampFormat("EEEE, MM dd, yyyy, hh:mm a (zzzz)");

    }

    public void onTestSuccess(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.PASS, "Test Passed");


    }
    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (Exception e) {
            e.getMessage();
        }
        return destination;
    }

    public void onTestFailure(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.FAIL, "Test Failed");
        extentTest.log(Status.FAIL, result.getThrowable().getMessage());
        try {
            String imgPath = captureScreen(result.getName());
            extentTest.addScreenCaptureFromPath(imgPath);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.SKIP, "Test Skipped");
        extentTest.log(Status.SKIP, result.getThrowable().getMessage());
    }
    public void startTest(String testName, String author, String category) {
        // Create a new test in the Extent Report
        extentTest = extentReports.createTest(testName)
                .assignAuthor(author)
                .assignCategory(category)
                .assignDevice("Chrome");
    }


}


