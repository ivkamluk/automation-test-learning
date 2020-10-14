package com.webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

       private final String GooglePageUrl = "https://google.com";

       private WebElement buttonSearch;
       private WebElement inputField;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage() {
        driver.get(GooglePageUrl);
        System.out.println(GooglePageUrl + " was opened.");
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
        System.out.println(searchRequest + " request was performed.");
   }
}
