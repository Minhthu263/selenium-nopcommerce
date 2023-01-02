package com.nopcommerce.demo.helper.listener;

import com.nopcommerce.demo.core.BaseTest;
import com.nopcommerce.demo.helper.logger.Log;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {
    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] saveToScreenShot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void onTestStart(ITestResult result) {
        Log.info("Start test: " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();
        saveToScreenShot(driver);
    }

    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();
        saveToScreenShot(driver);
    }
}
