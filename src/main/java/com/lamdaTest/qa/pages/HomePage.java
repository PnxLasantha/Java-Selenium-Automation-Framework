package com.lamdaTest.qa.pages;


import com.lamdaTest.qa.factory.BrowserFactory;
import com.Util.ElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BrowserFactory {
    ElementUtil elementHelper;
    public HomePage(){
        PageFactory.initElements(driver.get(),this);
        elementHelper = new ElementUtil(driver.get());
    }

    //page factory
    String link = "xpath;//a[text()='linkName']";


    public String validateHomePageTitle(){
        return driver.get().getTitle();
    }

    public boolean validateFormesExist(String formName){
        String inputFormLabel = link.replace("linkName",formName);
        WebElement inputFromLabelElement = elementHelper.getElement(inputFormLabel);
        return inputFromLabelElement.isDisplayed();
    }

    public <Any> Any clickOnDemoLink(String linkName){
        String demoLink = link.replace("linkName",linkName);
        elementHelper.clickOnElement(demoLink);
        return switch (linkName){
            case "Simple Form Demo" -> (Any) new SimpleFormDemoPage();
            case "Checkbox Demo" -> (Any) new CheckBoxDemoPage();
            case "Radio Buttons Demo" -> (Any) new RadioButtonDemoPage();
            default -> (Any) new HomePage();
        };

    }


}
