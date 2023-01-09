package com.lamdaTest.qa.tests;

import com.lamdaTest.qa.base.BaseTest;
import com.lamdaTest.qa.pages.CheckBoxDemoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTest extends BaseTest {
    CheckBoxDemoPage checkBoxDemoPage;


    @Test
    public void verifySingleCheckBox(){
        test = extentReports.createTest("Verify single checkbox");
        checkBoxDemoPage =  homePage.clickOnDemoLink("Checkbox Demo");
        String msg = checkBoxDemoPage.singleCheckBoxCheckedMessage();
        Assert.assertEquals(msg,"Success - Check box is checked");


    }
    @Test
    public void verifycheckAllCheckBox(){
        test = extentReports.createTest("Verify check all checkbox functionality ");
        checkBoxDemoPage =  homePage.clickOnDemoLink("Checkbox Demo");
        Assert.assertTrue(checkBoxDemoPage.clickOnCheckAllButton());
    }

    @Test
    public void verifyUncheckAllCheckBox(){
        test = extentReports.createTest("Verify uncheck all checkbox functionality ");
        checkBoxDemoPage =  homePage.clickOnDemoLink("Checkbox Demo");
        Assert.assertTrue(checkBoxDemoPage.clickOnUnCheckAllButton());
    }
}
