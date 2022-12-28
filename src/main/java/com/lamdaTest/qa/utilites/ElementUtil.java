package com.lamdaTest.qa.utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class ElementUtil {
    WebDriver driver;
   private WebDriverWait wait;
    public ElementUtil(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public  WebElement getElement(String element){
        String[] parts = element.split(";");

        if(parts[0].isEmpty() | parts[1].isEmpty()){
            System.out.println("Please Check locator");
        }

        By locator = null;
        switch (parts[0].toLowerCase()){
            case "css" : locator = By.cssSelector(parts[1]); break;
            case "xpath": locator = By.xpath(parts[1]);break;
            case "id": locator = By.id(parts[1]);break;
            case "classname" : locator = By.className(parts[1]);break;
            default: System.out.println("Wrong element type");
        }
        return constructWebElement(locator);
    }

    private WebElement constructWebElement(By locator){
        WebElement element = driver.findElement(locator);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void clickOnElement(String locator){
        getElement(locator).click();
    }

    public void clearAndType(String locator,String inputText){
        getElement(locator).clear();
        getElement(locator).sendKeys(inputText);
    }

    public void selectDropDownByIndex(String locator,int index){
        Select dropdown = new Select(getElement(locator));
        dropdown.selectByIndex(index);
    }
    public void selectDropDownByValue(String locator,String value){
        Select dropdown = new Select(getElement(locator));
        dropdown.selectByValue(value);
    }

    public void selectDropDownByVisibleText(String locator,String value){
        Select dropdown = new Select(getElement(locator));
        dropdown.selectByVisibleText(value);
    }

    public void switchToWindow(String windowHandle){
        Set<String> windowHandles = driver.getWindowHandles();
        if(windowHandles.contains(windowHandle)) {
            driver.switchTo().window(windowHandle);
        }else {
            System.out.println("Window handle " + windowHandle + "not found");
        }
    }
}
