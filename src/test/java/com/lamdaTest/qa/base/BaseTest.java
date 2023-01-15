package com.lamdaTest.qa.base;


import com.lamdaTest.qa.factory.BrowserFactory;
import com.lamdaTest.qa.pages.HomePage;
import com.lamdaTest.qa.pages.SimpleFormDemoPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class BaseTest {


    protected HomePage homePage;
    protected SimpleFormDemoPage simpleFormDemoPage;
    public  BrowserFactory bf;
    public static WebDriver driver;


    @BeforeSuite
    public void init(){

    }
    @BeforeTest
    public void browserSetup() {
        bf = new BrowserFactory();
        bf.removeExistingImages();
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional String browser) {
        if(browser == null) browser = BrowserFactory.prop.getProperty("BROWSER");
        driver = BrowserFactory.initialization(browser);
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
