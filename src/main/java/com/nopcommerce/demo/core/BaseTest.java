package com.nopcommerce.demo.core;

import com.nopcommerce.demo.factory.environment.LocalFactory;
import com.nopcommerce.demo.helper.logger.Log;
import com.nopcommerce.demo.helper.reporter.TestListener;
import io.qameta.allure.Allure;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    private WebDriver driver;

    protected BaseTest() {

    }

    protected WebDriver getBrowserDriver(String browserName, String url) {
        driver = new LocalFactory(browserName).createDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
        driver.get(url);
        return driver;
    }

    public void takeScreenshot(WebDriver driver) {
        captureScreenShotToAllure(driver);
    }

    private void captureScreenShotToAllure(WebDriver driver) {
        Allure.getLifecycle().startStep("Take screenshot", new StepResult());
        Allure.addAttachment("Screenshot taken", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Allure.getLifecycle().stopStep("Take screenshot");
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    protected void cleanBrowserAndDriver() {
        String cmd = "";
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            Log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            Log.info("Driver instance name = " + osName);

            if (driverInstanceName.contains("chrome")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                } else {
                    cmd = "pkill chromedriver";
                }
            } else if (driverInstanceName.contains("internetexplorer")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
                }
            } else if (driverInstanceName.contains("firefox")) {
                if (osName.contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
                } else {
                    cmd = "pkill geckodriver";
                }
            } else if (driverInstanceName.contains("edge")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
                } else {
                    cmd = "pkill msedgedriver";
                }
            } else if (driverInstanceName.contains("opera")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
                } else {
                    cmd = "pkill operadriver";
                }
            } else if (driverInstanceName.contains("safari")) {
                if (osName.contains("mac")) {
                    cmd = "pkill safaridriver";
                }
            }
            //Browser
            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            Log.info("Close browser and clean excutable driver:" + e.getMessage());
        } finally {
            try {
                //Excutable driver
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void sleepInSecond(long timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public int randomNumber() {
        Random rd = new Random();
        return rd.nextInt(1000);

    }

    public String getDatTimeNow() {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1; // Note: zero based!
        int day = now.get(Calendar.DAY_OF_MONTH);
        return month + "/" + day + "/" + year;
    }

    @BeforeTest
    public void deleteAllFilesInReportNGScreenshot() {
        Log.info("---------- START delete file in folder ----------");
        deleteAllFileInFolder();
        Log.info("---------- END delete file in folder ----------");
    }

    public void deleteAllFileInFolder() {
        try {
            String workingDir = System.getProperty("user.dir");
            String pathFolderDownload = workingDir + "\\screenshotReportNG";
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    Log.info(listOfFiles[i].getName());
                    new File(listOfFiles[i].toString()).delete();
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

//    public boolean isElementDisplayed(String locator) {
//        try {
//            WebElement element = driver.findElement(By.xpath(locator));
//            return element.isDisplayed();
//        } catch (Exception e) {
//            System.out.println("Exception = " + e.getMessage());
//            return false;
//        }
//    }

    public boolean checkTrue(boolean condition) {
        SoftAssert soft = new SoftAssert();
        boolean pass = true;
        try {
            soft.assertTrue(condition);
            soft.assertAll();
        } catch (Throwable e) {
            System.out.println("Exception = " + e.getMessage());
            pass = false;
        }
        return pass;
    }

    public boolean checkFalse(boolean condition) {
        SoftAssert soft = new SoftAssert();
        boolean pass = true;
        try {
            soft.assertFalse(condition);
            soft.assertAll();
        } catch (Throwable e) {
            System.out.println("Exception = " + e.getMessage());
            pass = false;
        }
        return pass;
    }

    public boolean checkEquals(Object actual, Object expected) {
        SoftAssert soft = new SoftAssert();
        boolean pass = true;
        try {
            soft.assertEquals(actual, expected);
            soft.assertAll();
        } catch (Throwable e) {
            System.out.println("Exception = " + e.getMessage());
            pass = false;
        }
        return pass;
    }

}
