package com.webpage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

       private final String GooglePageUrl = "https://google.com";
       private WebElement buttonSearch;
       private WebElement inputField;

    public HomePage(WebDriver driver) {
        super(driver);
        log = Logger.getLogger(HomePage.class);
    }

    public void openHomePage() {
        driver.get(GooglePageUrl);
        log.info(GooglePageUrl + " was opened.");
    }

 /*
To test url from commandLine

    public void openHomePage(String pageUrl) {
        waitPageFullyLoaded();
        driver.get(pageUrl);
    }
  */

   public void performSearchByRequest(String searchRequest) {
        inputField = driver.findElement(By.xpath("//input[@name='q']"));
        inputField.sendKeys(searchRequest);
        buttonSearch = driver.findElement(By.xpath("//input[@name='btnK']"));
        waitElementLoadedToClick(buttonSearch);
        buttonSearch.click();
        log.info(searchRequest + " request was performed.");
   }
}
