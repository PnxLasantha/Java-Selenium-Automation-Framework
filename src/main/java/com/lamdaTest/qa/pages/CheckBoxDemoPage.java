package com.lamdaTest.qa.pages;

import com.lamdaTest.qa.factory.BrowserFactory;
import com.Util.ElementUtil;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxDemoPage extends BrowserFactory {
    ElementUtil elementHelper;
    
    CheckBoxDemoPage(){
        PageFactory.initElements(driver.get(),this);
        elementHelper = new ElementUtil(driver.get());
    }
    
    String singleCheckBox = "id;isAgeSelected"; //txtAge
    String singleCheckBoxCheckedMsg = "xpath;//div[@id='txtAge']";
    String checkallButton ="css;[value='Check All']";
    String uncheckallButton ="css;[value='Uncheck All']";

   
    public String getPageHeader(){
        return elementHelper.getPageTitle();

    }
    
    public String singleCheckBoxCheckedMessage(){
        elementHelper.clickOnElement(singleCheckBox);
        return elementHelper.getElement(singleCheckBoxCheckedMsg).getText();
    }

    public boolean clickOnCheckAllButton(){
        elementHelper.clickOnElement(checkallButton);
      return   elementHelper.getElement(uncheckallButton).isDisplayed();
    }
    public boolean clickOnUnCheckAllButton(){
        elementHelper.clickOnElement(checkallButton);
        elementHelper.clickOnElement(uncheckallButton);
        return   elementHelper.getElement(checkallButton).isDisplayed();
    }
}
