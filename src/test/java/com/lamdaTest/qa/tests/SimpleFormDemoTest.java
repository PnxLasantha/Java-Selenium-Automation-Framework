package com.lamdaTest.qa.tests;

import com.lamdaTest.qa.base.BaseTest;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class SimpleFormDemoTest extends BaseTest {
Logger logger = LogManager.getLogger(SimpleFormDemoTest.class);
    @DataProvider (name = "singleInputField-data-provider")
    public Object[][] singleMethod(){
        return new Object[][] {{"Test ABC"}, {"1234556"}, {"!@#$%"}};
    }

    @Test(dataProvider = "singleInputField-data-provider",description = "Verify single input field")
    public void verifySingleInputField(String inputText){
        logger.log(Level.INFO,"Verify single input field : " + inputText);
        simpleFormDemoPage = homePage.clickOnDemoLink("Simple Form Demo");

        simpleFormDemoPage.typeToSingleInputField(inputText);
        simpleFormDemoPage.clickOnGetCheckedButton();
        String displayResult = simpleFormDemoPage.validateInputText();
        Assert.assertEquals(displayResult,inputText);
    }
    @DataProvider (name = "twoInputField-data-provider")
    public Object[][] twoMethod(){
        return new Object[][] {{"5","6","11"}, {"1","","Entered value is not a number"}, {"","","Entered value is not a number"}};
    }

    @Test(dataProvider ="twoInputField-data-provider",description = "Verify two input fields" )
    public void verifyTwoInputFields(String value1, String value2, String sum){
        logger.log(Level.INFO,"Verify two input fields : " + value1 +" "+ value2 + " "+ sum);
        simpleFormDemoPage =  homePage.clickOnDemoLink("Simple Form Demo");
        simpleFormDemoPage.typeTwonsumInputFields(value1,value2);
        simpleFormDemoPage.clickOnGetValuesButton();
        Assert.assertEquals(simpleFormDemoPage.validateSum(),sum);

    }

}
