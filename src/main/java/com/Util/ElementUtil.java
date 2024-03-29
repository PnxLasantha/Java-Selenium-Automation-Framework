package com.Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class ElementUtil {
    WebDriver driver;
   private WebDriverWait wait;
    public ElementUtil(WebDriver driver){
        this.driver = driver;

    }

    //page header is same for all the pages.
    public String getPageTitle(){
        return driver.getTitle();
    }
    public  WebElement getElement(String element){
     By locator = createLocator(element);
        return constructWebElement(locator);
    }

    public  List<WebElement> getElements(String element){
        By locator = createLocator(element);
        return constructWebElements(locator);
    }

    private By createLocator(String element){
        String[] parts = element.split(";");

        if(parts[0].isEmpty() | parts[1].isEmpty()){

            throw new Error("Please check the locator " + element );
        }

        By locator;
        switch (parts[0].toLowerCase()) {
            case "css" -> locator = By.cssSelector(parts[1]);
            case "xpath" -> locator = By.xpath(parts[1]);
            case "id" -> locator = By.id(parts[1]);
            case "classname" -> locator = By.className(parts[1]);
            default -> throw  new Error("Invalid locator type");
        }
        return locator;
    }

    private WebElement constructWebElement(By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = driver.findElement(locator);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
    private List<WebElement> constructWebElements(By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        List<WebElement> elements;
        elements = driver.findElements(locator);

        return elements;
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
           throw  new Error("Window handle " + windowHandle + "not found");
        }
    }
}
