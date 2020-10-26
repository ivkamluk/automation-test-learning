package com.webpage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BasePage {

    private final Logger log = Logger.getLogger(SearchPage.class);
    private List<WebElement> linksFromSearch;


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void openLinkFromSearch(int linkIndex) {
        getLinkFromSearchByIndex(linkIndex).click();
        waitPageFullyLoaded();
        log.info(driver.getCurrentUrl() + "link by requested index - " + linkIndex + ".");
    }

    private List<WebElement> getLinksFromSearch(String path) {
        linksFromSearch = driver.findElements(By.xpath(path));
        log.info(linksFromSearch.size() + " links from search was found.");
        return linksFromSearch;
    }

    private WebElement getLinkFromSearchByIndex(int linkIndex) {
        // to open link according to the searched result we should decrease by 1
        // in list numeration always starts from 0 and 1st link will be on position 0
        return getLinksFromSearch("//*[@id='rso']/div/div/div/a").get(linkIndex-1);
    }
}
