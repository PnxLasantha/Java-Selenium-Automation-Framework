package com.lamdaTest.qa.tests;

import com.lamdaTest.qa.base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;



public class HomePageTest extends BaseTest {

    Logger logger = LogManager.getLogger(HomePageTest.class);

    @Test(description = "Verify home page")
    public void verifyHomePageTitle() {
         logger.info("Verify home page");
         Assert.assertEquals(homePage.validateHomePageTitle(), "Selenium Grid Online | Run Selenium Test On Cloud");
    }

    @Test(description = "Verify input form")
    public void verifyInputForm(){
        logger.info("Verify input form");
        Assert.assertTrue(homePage.validateFormesExist("Input Forms"));
    }

    @Test(description = "Verify jackson")
    public void checkJson(){
        logger.info("Verify jackson");
       String un = testData("user name");
       System.out.println(un);
    }

    //add data provider
    @Test(description = "Verify simple form link")
    public void verifySimpleFormsLink(){
        logger.info("Verify simple form link");
        simpleFormDemoPage =  homePage.clickOnDemoLink("Simple Form Demo");
        Assert.assertEquals(simpleFormDemoPage.getPageHeader(),"Simple Form Demo","Page not found");
    }


}
