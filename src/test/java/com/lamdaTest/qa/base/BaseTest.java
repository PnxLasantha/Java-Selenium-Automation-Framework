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
import org.testng.annotations.*;

public class BaseTest {


    protected HomePage homePage;
    protected SimpleFormDemoPage simpleFormDemoPage;
    public  BrowserFactory bf;
    public static WebDriver driver;


    private TestUtil testUtil  = new TestUtil();

    @BeforeSuite
    public void init(){

    }
    @BeforeTest
    public void browserSetup() {
        bf = new BrowserFactory();
        bf.removeExistingImages();
    }

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.initialization();
        homePage = new HomePage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void afterTest() {
    }


    public String testData(String key) {
        return BrowserFactory.testData(key);
    }

}
