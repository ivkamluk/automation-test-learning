package com.webpage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {

    protected WebDriver driver;

    protected WebDriver getDriver() {
        return driver;
    }

    protected void setDriver(String browser) {
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                System.out.println("Initialized FirefoxDriver.");
                break;
            case "chrome": default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                System.out.println("By default switched to ChromeDriver.");
        }
        driver.manage().window().maximize();
    }
}

