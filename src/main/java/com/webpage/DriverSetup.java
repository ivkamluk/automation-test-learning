package com.webpage;

import org.apache.log4j.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {

    protected WebDriver driver;
    private final Logger log = Logger.getLogger(DriverSetup.class);

    protected WebDriver getDriver() {
        return driver;
    }

    protected void setDriver(String browser) {
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                log.info("Initialized FirefoxDriver.");
                break;
            case "chrome": default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                log.info("By default switched to ChromeDriver.");
        }
        driver.manage().window().maximize();
    }
}

