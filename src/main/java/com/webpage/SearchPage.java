package com.webpage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {

    private List<WebElement> linksFromSearch;
    private WebElement specificFirstBlockFromSearch;


    public SearchPage(WebDriver driver) {
        super(driver);
        linksFromSearch = new ArrayList<WebElement>();
        log = Logger.getLogger(SearchPage.class);
    }

    public void openLinkFromSearch(int linkIndex) throws InterruptedException {
        Thread.sleep(7000); // use Thread only for personal debug: to compare real page with opened index page
        waitElementLoadedToClick(getLinkFromSearchByIndex(linkIndex));
        getLinkFromSearchByIndex(linkIndex).click();
        log.info(driver.getCurrentUrl() + "link by requested index - " + linkIndex + ".");
    }

    private List<WebElement> getLinksFromSearch(String path) {

        if (determineSpecificFirstBlockByRequest() != null) {
            linksFromSearch.add(specificFirstBlockFromSearch);
        }

        linksFromSearch.addAll(driver.findElements(By.xpath(path)));
        return linksFromSearch;
    }

    private WebElement getLinkFromSearchByIndex(int linkIndex) {
        // to open link according to the searched result we should decrease by 1
        // in list numeration always starts from 0 and 1st link will be on position 0
        return getLinksFromSearch("//*[@id='rso']/div/div/div/a").get(linkIndex-1);
    }

    private WebElement determineSpecificFirstBlockByRequest() {
        try {
            specificFirstBlockFromSearch = driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div/div[1]/a"));
            return specificFirstBlockFromSearch;
        }
        catch(NoSuchElementException exception) {
            return null;
        }
    }
}
