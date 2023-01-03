package com.lamdaTest.qa.tests;

import com.lamdaTest.qa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {



    @Test(testName = "Verify home page")
    public void verifyHomePageTitle() {
         test = extentReports.createTest("Verify home page title");
         Assert.assertEquals(homePage.validateHomePageTitle(), "Selenium Grid Online | Run Selenium Test On Cloud");
    }

    @Test
    public void verifyInputForm(){
         test = extentReports.createTest("Verify input forms");
        Assert.assertTrue(homePage.validateFormesExist("Input Forms"));
    }

    @Test
    public void checkJson(){
         test = extentReports.createTest("Verify Json");
       String un = testData("user name");
       System.out.println(un);
    }

    //add data provider
    @Test
    public void verifySimpleFormsLink(){
         test = extentReports.createTest("Verify simple form demo page");
        simpleFormDemoPage =  homePage.clickOnDemoLink("Simple Form Demo");
        Assert.assertEquals(simpleFormDemoPage.getPageHeader(),"Simple Form Demo","Page not found");
    }


}
