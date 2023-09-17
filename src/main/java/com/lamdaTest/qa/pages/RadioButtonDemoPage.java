package com.lamdaTest.qa.pages;

import com.lamdaTest.qa.factory.BrowserFactory;
import com.Util.ElementUtil;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonDemoPage extends BrowserFactory {

    ElementUtil elementHelper;
    String singleRadioButton ="xpath;//*[@value='type'][@name='optradio']";
    String genderGroupRadioButtons = "xpath;//*[@value='type'][@name='gender']";
    String ageGroupRadioButtons = "xpath;//*[@value='type'][@name='ageGroup']";
    String getCheckedValueButton ="id;buttoncheck";
    String genderDisplayText = "classname;genderbutton";
    String ageGrouoDisplayText = "classname;groupradiobutton";
    String getValuesButton = "xpath;//button[text()='Get values']";
    String singleRadioButtonConfirmText = "xpath;//p[text()=\"Radio button 'type' is checked\"]";
  public   RadioButtonDemoPage(){
        PageFactory.initElements(driver.get(),this);
        elementHelper = new ElementUtil(driver.get());
    }

    public void clickOnRadioButtonDemo(String value){
      String locator = singleRadioButton.replace("type",value);
      elementHelper.clickOnElement(locator);
    }

    public void clickOngetCheckedValueButton(){
      elementHelper.clickOnElement(getCheckedValueButton);
    }

    public boolean checkSingleRadioButtonText(String value){
        String locator = singleRadioButtonConfirmText.replace("type",value);
        return elementHelper.getElement(locator).isDisplayed();
    }
    public void clickOnGenderGroupRadioButton(String value){
        String locator = genderGroupRadioButtons.replace("type",value);
        elementHelper.clickOnElement(locator);
    }

    public void clickOnGetValuesButton(){
      elementHelper.clickOnElement(getValuesButton);
    }
    public void clickOnAgeGroupRadioButton(String value){
        String locator = ageGroupRadioButtons.replace("type",value);
        elementHelper.clickOnElement(locator);
    }

    public String getGenderDisplayText(){
      return elementHelper.getElement(genderDisplayText).getText();
    }

    public String getAgeGroupDisplayText(){
        return elementHelper.getElement(ageGrouoDisplayText).getText();
    }

}
