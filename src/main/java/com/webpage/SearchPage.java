package com.webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BasePage {

    private List<WebElement> linksFromSearch;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void openLinkFromSearch(int linkIndex) {
        getLinkFromSearchByIndex(linkIndex).click();
        waitPageFullyLoaded();
        System.out.println(driver.getCurrentUrl() + "link by requested index - " + linkIndex + ".");
    }

    private List<WebElement> getLinksFromSearch(String path) {
        linksFromSearch = driver.findElements(By.xpath(path));
        System.out.println(linksFromSearch.size() + " links from search was found.");
        System.out.println(linksFromSearch);
        return linksFromSearch;
    }

    private WebElement getLinkFromSearchByIndex(int linkIndex) {
        // to open link according to the searched result we should decrease by 1
        // in list numeration always starts from 0 and 1st link will be on position 0
        return getLinksFromSearch("//*[@id='rso']/div/div/div/a").get(linkIndex-1);
    }
}
