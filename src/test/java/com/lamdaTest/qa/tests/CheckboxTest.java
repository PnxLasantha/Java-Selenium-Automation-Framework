package com.lamdaTest.qa.tests;

import com.lamdaTest.qa.base.BaseTest;
import com.lamdaTest.qa.pages.CheckBoxDemoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTest extends BaseTest {
    CheckBoxDemoPage checkBoxDemoPage;


    @Test(description = "Verify single checkbox")
    public void verifySingleCheckBox(){

        checkBoxDemoPage =  homePage.clickOnDemoLink("Checkbox Demo");
        String msg = checkBoxDemoPage.singleCheckBoxCheckedMessage();
        Assert.assertEquals(msg,"Success - Check box is checked");


    }
    @Test(description = "Verify checkall checkbox")
    public void verifycheckAllCheckBox(){
        checkBoxDemoPage =  homePage.clickOnDemoLink("Checkbox Demo");
        Assert.assertTrue(checkBoxDemoPage.clickOnCheckAllButton());
    }

    @Test(description = "Verify uncheck all checkbox")
    public void verifyUncheckAllCheckBox(){
        checkBoxDemoPage =  homePage.clickOnDemoLink("Checkbox Demo");
        Assert.assertTrue(checkBoxDemoPage.clickOnUnCheckAllButton());
    }
}
