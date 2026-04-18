package com.srm.listeners;

import org.testng.*;

import com.aventstack.extentreports.*;
import com.srm.base.BaseTest;
import com.srm.utils.ExtentManager;
import com.srm.utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getReport();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail("Test Failed");

        BaseTest bt = (BaseTest) result.getInstance();

        String path = ScreenshotUtil.capture(bt.driver, result.getName());

        try {
            test.addScreenCaptureFromPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}