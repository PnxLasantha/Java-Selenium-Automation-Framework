package com.lamdaTest.qa.base;

import com.lamdaTest.qa.factory.BrowserFactory;
import com.lamdaTest.qa.pages.HomePage;
import com.lamdaTest.qa.pages.InputFormsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {


    protected HomePage homePage;
    protected InputFormsPage inputFormsPage;
    public BrowserFactory bf;
    public static WebDriver driver;
    @BeforeTest
    public void browserSetup(){
        bf = new BrowserFactory();

    }
    @BeforeMethod
    public void setUp() {

        driver= bf.initialization();
        homePage = new HomePage();

    }

    @AfterMethod
    public void tearDown() {
       driver.quit();

    }

    public String testData(String key){
       return bf.testData(key);
    }

}
