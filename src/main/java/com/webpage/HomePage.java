package com.webpage;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private final String GooglePageUrl = "https://google.com";

    @FindBy(xpath="//input[@name='btnK']")
    private WebElement buttonSearch;

    @FindBy(xpath="//input[@name='q']")
    private WebElement inputField;

    public HomePage(WebDriver driver) {
        super(driver);
        log = Logger.getLogger(HomePage.class);
        PageFactory.initElements(driver, this);
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
        inputField.sendKeys(searchRequest);
        waitElementLoadedToClick(buttonSearch);
        buttonSearch.click();
        log.info(searchRequest + " request was performed.");
   }
}
