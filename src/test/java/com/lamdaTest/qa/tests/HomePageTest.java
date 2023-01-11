package com.lamdaTest.qa.tests;

import com.lamdaTest.qa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {



    @Test(description = "Verify home page")
    public void verifyHomePageTitle() {

         Assert.assertEquals(homePage.validateHomePageTitle(), "Selenium Grid Online | Run Selenium Test On Clou");
    }

    @Test(description = "Verify input form")
    public void verifyInputForm(){
        Assert.assertTrue(homePage.validateFormesExist("Input Forms"));
    }

    @Test(description = "Verify jackson")
    public void checkJson(){
       String un = testData("user name");

       System.out.println(un);
        System.out.println( bf.testData("user name"));
    }

    //add data provider
    @Test(description = "Verify simple form link")
    public void verifySimpleFormsLink(){
        simpleFormDemoPage =  homePage.clickOnDemoLink("Simple Form Demo");
        Assert.assertEquals(simpleFormDemoPage.getPageHeader(),"Simple Form Demo","Page not found");
    }


}
