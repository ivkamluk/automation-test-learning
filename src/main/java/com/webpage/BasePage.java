package com.webpage;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected final long waitLoadTimeSeconds = 15;
    protected Logger log = Logger.getLogger(BasePage.class);
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean pageFullyLoaded() {
        boolean pageLoaded = true;
        try {
            new WebDriverWait(driver, waitLoadTimeSeconds).until(webDriver -> ((JavascriptExecutor)
                    webDriver).executeScript("return document.readyState").equals("complete"));
        }
        catch(Throwable exception) {
                log.error(exception);
                pageLoaded = false;
        }
        return pageLoaded;
}

    public void waitElementLoadedToClick(WebElement element) {
            new WebDriverWait(driver, waitLoadTimeSeconds).until(ExpectedConditions.elementToBeClickable(element));
    }
}
