package com.lamdaTest.qa.pages;

import com.lamdaTest.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    //page factory
    @FindBy(xpath = "//h2[text()='Input Forms']")
    WebElement inputFormesLabel;

    public String validateHomePageTitle(){
        return driver.getTitle();
    }

    public boolean validateInputFormesExist(){
       return inputFormesLabel.isDisplayed();
    }
}
