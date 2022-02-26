package com.cs.arris.Reports;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cs.arris.Base.ParentClass;

public class ExtentReport {
	static ParentClass base = new ParentClass();
	static ExtentReports extent;
	ExtentTest test;
    final static String filePath = "Extent.html";
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
    
    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
        	ExtentHtmlReporter html = new ExtentHtmlReporter("Extent.html");
        	html.config().setEncoding("UTF-8");
        	html.config().setDocumentTitle("Appium Framework");
        	html.config().setReportName("SBC Automation - Bluetooth W31 On-Boarinng App");
        	html.config().setTheme(Theme.DARK);
            extent = new ExtentReports();
            extent.attachReporter(html);
        }
        return extent;
    }
    
    public static synchronized ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = getReporter().createTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }
    
    public static synchronized ExtentTest failTest(String testName, String desc) {
        ExtentTest test = getReporter().createTest(testName, desc);   
        return test;
    }

}
