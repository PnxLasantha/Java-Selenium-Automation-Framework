package com.lamdaTest.qa.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.lamdaTest.qa.factory.BrowserFactory;
import com.lamdaTest.qa.pages.HomePage;
import com.lamdaTest.qa.pages.SimpleFormDemoPage;
import com.lamdaTest.qa.utilites.TestUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {


    protected HomePage homePage;
    protected SimpleFormDemoPage simpleFormDemoPage;
    public BrowserFactory bf;
    public static WebDriver driver;
    public ExtentReports extentReports;
    public ExtentSparkReporter sparkReporter;
    public ExtentTest test;

    private TestUtil testUtil;

    @BeforeTest
    public void browserSetup() {
        extentReports = new ExtentReports();
        sparkReporter = new ExtentSparkReporter("reports/Extent-report.html");
        extentReports.attachReporter(sparkReporter);
        testUtil = new TestUtil();
        testUtil.removeExistingImages();
        bf = new BrowserFactory();

    }

    @BeforeMethod
    public void setUp() {


        driver = bf.initialization();
        homePage = new HomePage();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {


        if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Pass");
        }
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenShotPath = testUtil.captureScreenShot(driver, result.getName());
            test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());

        }
        if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Skip");
        }
        driver.quit();
    }

    @AfterTest
    public void afterTest() {
        extentReports.flush();

    }

    public String testData(String key) {
        return bf.testData(key);
    }

}
