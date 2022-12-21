package com.lamdaTest.qa.testcases;

import com.lamdaTest.qa.base.TestBase;
import com.lamdaTest.qa.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    HomePage homepage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homepage = new HomePage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void verifyHomePageTitle() {
        Assert.assertEquals(homepage.validateHomePageTitle(), "Selenium Grid Online | Run Selenium Test On Cloud");
    }
}
