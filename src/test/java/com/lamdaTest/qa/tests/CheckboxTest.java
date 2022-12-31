package com.lamdaTest.qa.tests;

import com.lamdaTest.qa.base.BaseTest;
import com.lamdaTest.qa.pages.CheckBoxDemoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTest extends BaseTest {
    CheckBoxDemoPage checkBoxDemoPage;


    @Test
    public void verifyCheckAllCheckBox(){
        checkBoxDemoPage =  homePage.clickOnDemoLink("Checkbox Demo");
        String msg = checkBoxDemoPage.singleCheckBoxCheckedMessage();
        Assert.assertEquals(msg,"Success - Check box is checked");


    }
    @Test
    public void verifyheckAllCheckBox(){
        checkBoxDemoPage =  homePage.clickOnDemoLink("Checkbox Demo");
        Assert.assertTrue(checkBoxDemoPage.clickOnCheckAllButton());
    }

    @Test
    public void verifyUncheckAllCheckBox(){
        checkBoxDemoPage =  homePage.clickOnDemoLink("Checkbox Demo");
        Assert.assertTrue(checkBoxDemoPage.clickOnUnCheckAllButton());
    }
}
