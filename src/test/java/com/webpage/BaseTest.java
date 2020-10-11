package com.webpage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;

public class BaseTest {

    private DriverSetup driversetup;
    public WebDriver driver;

    @Parameters ({"browser"})
    @BeforeClass
    public WebDriver startBrowser(String browser) {
        driversetup = new DriverSetup();
        driversetup.setDriver(browser);
        driver = driversetup.getDriver();
        return driver;
    }

    @BeforeClass
    public void removeMadeScreenshots() {
        File file = new File("ScreenShotLinkFromSearch.png");
        if (file.delete()) {
            System.out.println("Screenshot deleted successfully");
        }
        else {
            System.out.println("Screenshot not exist for deleting.");
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
