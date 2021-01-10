package com.webpage;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath="//*[@id='rso']/div/div/div/a")
    private List<WebElement> searchedLinks;

    @FindBy(xpath="//*[@id='rso']/div[1]/div/div/div/div[1]/a")
    private WebElement specificFirstBlockFromSearch;

    private List<WebElement> linksOnSearchPage;


    public SearchPage(WebDriver driver) {
        super(driver);
        linksOnSearchPage = new ArrayList<WebElement>();
        log = Logger.getLogger(SearchPage.class);
        PageFactory.initElements(driver, this);
    }

    public void openLinkFromSearch(int linkIndex) throws InterruptedException {
        Thread.sleep(7000); // use Thread only for personal debug: to compare real page with opened index page
        waitElementLoadedToClick(getLinkFromSearchByIndex(linkIndex));
        linksOnSearchPage.get(linkIndex).click();
        log.info(driver.getCurrentUrl() + "link by requested index - " + linkIndex + ".");
    }

    private WebElement getLinkFromSearchByIndex(int linkIndex) {
        // to open link according to the searched result we should decrease by 1
        // in list numeration always starts from 0 and 1st link will be on position 0

        if (determineSpecificFirstBlockByRequest() != null) {
           linksOnSearchPage.add(specificFirstBlockFromSearch);
        }

        linksOnSearchPage.addAll(searchedLinks);
        return linksOnSearchPage.get(linkIndex-1);
    }

    private WebElement determineSpecificFirstBlockByRequest() {
        try {
            return specificFirstBlockFromSearch;
        }
        catch(NoSuchElementException exception) {
            return null;
        }
    }
}
