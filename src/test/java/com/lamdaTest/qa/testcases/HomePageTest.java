package com.lamdaTest.qa.testcases;

import com.lamdaTest.qa.base.TestBase;
import org.testng.Assert;

import org.testng.annotations.Test;

public class HomePageTest extends TestBase {


    public HomePageTest() {
        super();

    }


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

    @Test
    public void verifySimpleFormsLink(){
        inputFormsPage =  homePage.clickOnDemoLink("Simple Form Demo");
        Assert.assertEquals(inputFormsPage.getPageHeader(),"Simple Form Demo","Page not found");
    }
}
