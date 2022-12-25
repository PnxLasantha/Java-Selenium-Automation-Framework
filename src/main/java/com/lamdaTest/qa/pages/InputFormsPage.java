package com.lamdaTest.qa.pages;

import com.lamdaTest.qa.base.TestBase;
import com.lamdaTest.qa.utilites.ElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class InputFormsPage extends TestBase {

    ElementUtil elementHelper;

    String header = "xpath;//h1";
    public InputFormsPage(){
        PageFactory.initElements(driver,this);
        elementHelper = new ElementUtil(driver);
    }

    public String getPageHeader(){
        WebElement headerElement = elementHelper.getElement(header);
        return headerElement.getText();

    }
}
