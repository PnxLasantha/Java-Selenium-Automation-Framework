package com.lamdaTest.qa.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {


    public static ExtentReports extentReports;
    public static ExtentSparkReporter sparkReporter ;
     public static ExtentReports extentReportsGenerator(){
         sparkReporter = new ExtentSparkReporter("src/reports/Extent-report.html");
         sparkReporter.config().setReportName("Test Automation Report");
         sparkReporter.config().setDocumentTitle("Test Results");
         extentReports = new ExtentReports();
         extentReports.attachReporter(sparkReporter);

         return extentReports;
     }
}
