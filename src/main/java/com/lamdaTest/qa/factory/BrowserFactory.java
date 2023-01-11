package com.lamdaTest.qa.factory;


import com.lamdaTest.qa.utilites.TestUtil;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverListener;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class BrowserFactory  {

   public static Properties prop;
   public static JSONObject getTestData;
   public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static ThreadLocal<WebDriver> driverdc = new ThreadLocal<>();
   public static WebDriver decoratedDriver;
   public static EventCapture eventCapture;

    public BrowserFactory(){

        prop = new Properties();
        try {
            InputStream inputStream = BrowserFactory.class.getResourceAsStream("/config.properties");
            prop = new Properties();
            prop.load(inputStream);
            JSONParser parser = new JSONParser();
            getTestData = (JSONObject) parser.parse(
                    new FileReader("src/main/java/com/lamdaTest/qa/testdata/stg.json"));
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static   WebDriver initialization(){

      String browserName = prop.getProperty("BROWSER");
      boolean headLess =Boolean.parseBoolean( prop.getProperty("HEADLESS"));

      if(browserName.equalsIgnoreCase("chrome")){
          driver.set(new EventFiringDecorator<>(new EventCapture()).decorate(new ChromeDriver(new ChromeOptions().setHeadless(headLess))));

      }
      if(browserName.equalsIgnoreCase("firefox")){
         driver.set(new FirefoxDriver(new FirefoxOptions().setHeadless(headLess)));
      }
      if(browserName.equalsIgnoreCase("edge")){
         driver.set(new EdgeDriver(new EdgeOptions().setHeadless(headLess)));
      }




        driver.get().manage().window().maximize();
        driver.get().manage().deleteAllCookies();
        driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
        driver.get().get(prop.getProperty("URL"));

      return driver.get();
    }

    public static String testData(String data){
        return getTestData.get(data).toString();
    }

    public String captureScreenShot(String testName, WebDriver driver){

        File screenShot =   ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("src/reports/screenshots/" + testName +System.currentTimeMillis()+".png");
        String absolutePathDestinationFile = destinationFile.getAbsolutePath();
        try {
            FileUtils.copyFile(screenShot,destinationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return absolutePathDestinationFile;
    }

    public void removeExistingImages(){
        File theDir = new File("src/reports/screenshots/");
        if (!theDir.exists()){
            theDir.mkdirs();
        }
        File screenShotDir = new File("src/reports/screenshots/");
        try {
            FileUtils.cleanDirectory(screenShotDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

  public static WebDriver addListenerToDriver(WebDriver driver){
        return  new EventFiringDecorator<>(new EventCapture()).decorate(driver);
  }
}
