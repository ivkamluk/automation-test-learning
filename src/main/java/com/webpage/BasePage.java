package com.webpage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected final long waitLoadTimeSeconds = 15;
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitPageFullyLoaded() {
    new WebDriverWait(driver, waitLoadTimeSeconds).until(webDriver -> ((JavascriptExecutor)
            webDriver).executeScript("return document.readyState").equals("complete"));
}

    public void waitElementLoadedToClick(WebElement element) {
        new WebDriverWait(driver, waitLoadTimeSeconds).until(ExpectedConditions.elementToBeClickable(element));
    }
}
