package com.lamdaTest.qa.factory;


import com.lamdaTest.qa.utilites.TestUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BrowserFactory  {

   public static Properties prop;
   public static JSONObject getTestData;
   public static  ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public BrowserFactory(){

        prop = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/lamdaTest/qa/config/config.properties");
            prop = new Properties();
            prop.load(inputStream);
            JSONParser parser = new JSONParser();
            getTestData = (JSONObject) parser.parse(
                    new FileReader("src/main/java/com/lamdaTest/qa/testdata/stg.json"));
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static WebDriver initialization(){

      String browserName = prop.getProperty("BROWSER");
      boolean headLess =Boolean.parseBoolean( prop.getProperty("HEADLESS"));

      if(browserName.equalsIgnoreCase("chrome")){
          driver.set(new ChromeDriver(new ChromeOptions().setHeadless(headLess)));

      }
      if(browserName.equalsIgnoreCase("firefox")){
         driver.set(new FirefoxDriver(new FirefoxOptions().setHeadless(headLess)));
      }
      if(browserName.equalsIgnoreCase("edge")){
         driver.set(new EdgeDriver());
      }

      driver.get().manage().window().maximize();
      driver.get().manage().deleteAllCookies();
      driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
      driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
      driver.get().get(prop.getProperty("URL"));
      return driver.get();
    }

    public String testData(String data){
        return getTestData.get(data).toString();
    }



}
