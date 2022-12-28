package com.lamdaTest.qa.pages;


import com.lamdaTest.qa.factory.BrowserFactory;
import com.lamdaTest.qa.utilites.ElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BrowserFactory {
    ElementUtil elementhelper;
    public HomePage(){
        PageFactory.initElements(driver.get(),this);
        elementhelper = new ElementUtil(driver.get());
    }

    //page factory
    String formLabel = "xpath;//h2[text()='formname']";
    String demoLinks = "xpath;//a[text()='demoLinkName']";

    public String validateHomePageTitle(){
        return driver.get().getTitle();
    }

    public boolean validateFormesExist(String formName){
        String inputFormLabel = formLabel.replace("formname",formName);
        WebElement inputFromLabelElement = elementhelper.getElement(inputFormLabel);
        return inputFromLabelElement.isDisplayed();
    }

    public InputFormsPage clickOnDemoLink(String linkName){
        String demoLink = demoLinks.replace("demoLinkName",linkName);
        elementhelper.clickOnElement(demoLink);
        return  new InputFormsPage();
    }
}
