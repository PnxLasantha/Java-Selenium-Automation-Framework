package com.lamdaTest.qa.factory;


import com.lamdaTest.qa.utilites.TestUtil;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BrowserFactory  {

   public static Properties prop;
   public static JSONObject getTestData;
   public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();



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


    public static   WebDriver initialization(String browserName){

      boolean headLess =Boolean.parseBoolean( prop.getProperty("HEADLESS"));
      boolean remoteDriver = Boolean.parseBoolean(prop.getProperty("REMOTE"));
      String remoteUrl = prop.getProperty("REMOTE_URL");
      ChromeOptions chromeOptions = new ChromeOptions();
      FirefoxOptions firefoxOptions = new FirefoxOptions();
      EdgeOptions edgeOptions = new EdgeOptions();

      if(headLess) {
          chromeOptions.addArguments("--headless=new");
          firefoxOptions.addArguments("--headless");
          edgeOptions.addArguments("--headless");
      }

      if(browserName.equalsIgnoreCase("chrome")){

          driver.set(new EventFiringDecorator<>(new EventCapture()).decorate(new ChromeDriver(chromeOptions)));
      }

      if(browserName.equalsIgnoreCase("firefox")){
         driver.set(new EventFiringDecorator<>(new EventCapture()).decorate(new FirefoxDriver(firefoxOptions)));
      }
      if(browserName.equalsIgnoreCase("edge")){
         driver.set(new EventFiringDecorator<>(new EventCapture()).decorate(new EdgeDriver(edgeOptions)));
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

}
