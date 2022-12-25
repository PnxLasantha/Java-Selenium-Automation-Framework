package com.lamdaTest.qa.base;

import com.lamdaTest.qa.pages.HomePage;
import com.lamdaTest.qa.pages.InputFormsPage;
import com.lamdaTest.qa.utilites.TestUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase  {
   public static WebDriver driver;
   public static Properties prop;
   public static JSONObject getTestData;

   public HomePage homePage;
   public InputFormsPage inputFormsPage;

    public TestBase(){

        prop = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/lamdaTest/qa/config/config.properties");
            prop.load(inputStream);
            JSONParser parser = new JSONParser();
            getTestData = (JSONObject) parser.parse(
                    new FileReader("src/main/java/com/lamdaTest/qa/testdata/stg.json"));
        } catch (ParseException | IOException e) {
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

    public String testData(String data){
        return getTestData.get(data).toString();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        inputFormsPage = new InputFormsPage();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }

}
