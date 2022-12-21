package com.lamdaTest.qa.base;

import com.lamdaTest.qa.utilites.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase  {
   public static WebDriver driver;
   public static Properties prop;
    public TestBase(){

        prop = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/lamdaTest/qa/config/config.properties");
            prop.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void initialization(){
      String browserName = prop.getProperty("BROWSER");

      if(browserName.equalsIgnoreCase("chrome")){
          driver = new ChromeDriver();
      }
      if(browserName.equalsIgnoreCase("firefox")){
          driver = new FirefoxDriver();
      }
      if(browserName.equalsIgnoreCase("edge")){
          driver = new EdgeDriver();
      }

      driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
      driver.get(prop.getProperty("URL"));
    }
}
