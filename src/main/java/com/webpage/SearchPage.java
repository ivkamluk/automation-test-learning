package com.webpage;

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
    }

    public void openLinkFromSearch(int linkIndex) throws InterruptedException {
        Thread thread = new Thread();  // use this just only for personal debug:
        thread.sleep(7000);           // to compare real page with opened index page
        waitElementLoadedToClick(getLinkFromSearchByIndex(linkIndex));
        getLinkFromSearchByIndex(linkIndex).click();
        System.out.println(driver.getCurrentUrl() + "link by requested index - " + linkIndex + ".");
    }

    private List<WebElement> getLinksFromSearch(String path) {

        if (determineSpecificFirstBlockByRequest() != null) {
            linksFromSearch.add(specificFirstBlockFromSearch);
        }

        linksFromSearch.addAll(driver.findElements(By.xpath(path)));

        System.out.println(linksFromSearch.size() + " links from search was found.");
        return linksFromSearch;
    }

    private WebElement getLinkFromSearchByIndex(int linkIndex) {
        // to open link according to the searched result we should decrease by 1
        // in list numeration always starts from 0 and 1st link will be on position 0
        return getLinksFromSearch("//*[@id='rso']/div/div/div/a").get(linkIndex-1);
    }

    private WebElement determineSpecificFirstBlockByRequest() {
       try {
            specificFirstBlockFromSearch = driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div[1]/a"));
            return specificFirstBlockFromSearch;
        }
       catch(NoSuchElementException exception) {
           return null;
       }
    }
}
