package com.webpage;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    private DriverSetup driversetup;
    private final static Logger log = Logger.getLogger(BaseTest.class);
    public WebDriver driver;

    @Parameters ({"browser"})
    @BeforeClass
    public WebDriver startBrowser(String browser) {
        driversetup = new DriverSetup();
        driversetup.setDriver(browser);
        driver = driversetup.getDriver();
        return driver;
    }

    @BeforeMethod
    public void removeScreenshot() {
        File file = new File("ScreenShotLinkFromSearch.png");
        if (file.delete()) {
            log.info("Screenshot deleted successfully");
        }
        else {
            log.info("Screenshot not exist for deleting.");
        }
    }

    @AfterMethod
    public void createScreenShot() throws IOException {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("ScreenShotLinkFromSearch.png"));
        }
        catch (IOException exception) {
            log.error(exception);
        }
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
        log.info("Browser was closed.");
    }
}
