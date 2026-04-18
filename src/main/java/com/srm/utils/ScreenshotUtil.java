package com.srm.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {

    public static String capture(WebDriver driver, String testName) {

        String time =
                new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        String path = "screenshots/" + testName + "_" + time + ".png";

        try {

            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            File dest = new File(path);
            FileHandler.copy(src, dest);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }
}