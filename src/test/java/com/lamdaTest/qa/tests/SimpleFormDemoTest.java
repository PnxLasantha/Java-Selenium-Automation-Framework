package com.lamdaTest.qa.tests;

import com.lamdaTest.qa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class SimpleFormDemoTest extends BaseTest {

    @DataProvider (name = "singleInputField-data-provider")
    public Object[][] singleMethod(){
        return new Object[][] {{"Test ABC"}, {"1234556"}, {"!@#$%"}};
    }

    @Test(dataProvider = "singleInputField-data-provider")
    public void verifySingleInputField(String inputText){
        simpleFormDemoPage = homePage.clickOnDemoLink("Simple Form Demo");

        simpleFormDemoPage.typeToSingleInputField(inputText);
        simpleFormDemoPage.clickOnGetCheckedButton();
        String displayResult = simpleFormDemoPage.validateInputText();
        Assert.assertEquals(displayResult,inputText);
    }
    @DataProvider (name = "twoInputField-data-provider")
    public Object[][] twoMethod(){
        return new Object[][] {{"5","6","11"}, {"1","","NaN"}, {"","","NaN"}};
    }

    @Test(dataProvider ="twoInputField-data-provider" )
    public void verifyTwoInputFields(String value1, String value2, String sum){
        simpleFormDemoPage =  homePage.clickOnDemoLink("Simple Form Demo");
        simpleFormDemoPage.typeTwonsumInputFields(value1,value2);
        simpleFormDemoPage.clickOnGetValuesButton();
        Assert.assertEquals(sum, simpleFormDemoPage.validateSum());

    }

}
