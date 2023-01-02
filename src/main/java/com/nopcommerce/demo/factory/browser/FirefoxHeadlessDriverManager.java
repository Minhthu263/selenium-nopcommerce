package com.nopcommerce.demo.factory.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxHeadlessDriverManager implements BrowserFactory{
    @Override
    public WebDriver getBrowserDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions =new FirefoxOptions();
        firefoxOptions.setHeadless(true);
        firefoxOptions.addArguments("--window-size=1920x1080");
        return new FirefoxDriver(firefoxOptions);
    }
}
