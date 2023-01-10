package com.lamdaTest.qa.utilites;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TestUtil {

    public static final long PAGE_LOAD_TIMEOUT = 40;
    public static final long IMPLICIT_WAIT = 40;

    public String captureScreenShot(WebDriver driver,String testName){
     File screenShot =   ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
     File destinationFile = new File("reports/screenshots/" + testName +System.currentTimeMillis()+".png");
     String absolutePathDestinationFile = destinationFile.getPath();
        try {
            FileUtils.copyFile(screenShot,destinationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return absolutePathDestinationFile;
    }

    public void removeExistingImages(){
        File screenShotDir = new File("src/test/reports/screenshots/");
        try {
            FileUtils.cleanDirectory(screenShotDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
