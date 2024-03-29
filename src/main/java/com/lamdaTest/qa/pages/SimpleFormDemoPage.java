package com.lamdaTest.qa.pages;


import com.lamdaTest.qa.factory.BrowserFactory;
import com.Util.ElementUtil;
import org.openqa.selenium.support.PageFactory;

public class SimpleFormDemoPage extends BrowserFactory {

    ElementUtil elementHelper;

    String header = "xpath;//h1";
    String inputField = "id;user-message";
    String getCheckedButton = "id;showInput";
    String displayTextMessage = "id;message";
    String sum1input = "id;sum1"; //addmessage
    String sum2input = "id;sum2";
    String displaySumTextMessage = "id;addmessage";

    String getValuesButton = "xpath;//button[text()='Get Sum']";
    public SimpleFormDemoPage(){
        PageFactory.initElements(driver.get(),this);
        elementHelper = new ElementUtil(driver.get());
    }

    public String getPageHeader(){
       return elementHelper.getElement(header).getText();

    }

    public void typeToSingleInputField(String inputText){
        elementHelper.clearAndType(inputField,inputText);
    }

    public void clickOnGetCheckedButton(){
        elementHelper.clickOnElement(getCheckedButton);

    }

   public String validateInputText(){
        return  elementHelper.getElement(displayTextMessage).getText();
   }

   public void typeTwonsumInputFields(String sum1Value, String sum2Value){
        elementHelper.clearAndType(sum1input, sum1Value);
        elementHelper.clearAndType(sum2input, sum2Value);
   }
   public void clickOnGetValuesButton(){
    elementHelper.clickOnElement(getValuesButton);
   }

   public String validateSum(){
       return elementHelper.getElement(displaySumTextMessage).getText();
   }
}
