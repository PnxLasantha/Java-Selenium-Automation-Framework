package com.lamdaTest.qa.tests;

import com.lamdaTest.qa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {



    @Test()
    public void verifyHomePageTitle() {
        Assert.assertEquals(homePage.validateHomePageTitle(), "Selenium Grid Online | Run Selenium Test On Cloud");
    }

    @Test
    public void verifyInputForm(){
        Assert.assertTrue(homePage.validateFormesExist("Input Forms"));
    }

    @Test
    public void checkJson(){
       String un = testData("user name");
       System.out.println(un);
    }

    //add data provider
    @Test
    public void verifySimpleFormsLink(){
        simpleFormDemoPage =  homePage.clickOnDemoLink("Simple Form Demo");
        Assert.assertEquals(simpleFormDemoPage.getPageHeader(),"Simple Form Demo","Page not found");
    }


}
