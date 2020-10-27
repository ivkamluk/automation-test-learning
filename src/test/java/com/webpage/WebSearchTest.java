package com.webpage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class WebSearchTest extends BaseTest {

    @Parameters ("searchRequest")
    @Test
    public void openLinkFromSearch(String searchRequest) throws InterruptedException {
        HomePage homepage = new HomePage(driver);
        homepage.openHomePage();
        Assert.assertTrue(homepage.pageFullyLoaded(), "Home page failed to load.");
        Assert.assertEquals(driver.getTitle(), "Google");
        homepage.performSearchByRequest(searchRequest);
        SearchPage searchpage = new SearchPage(driver);
        searchpage.openLinkFromSearch(4);
        Assert.assertTrue(searchpage.pageFullyLoaded(), "Search page failed to load.");
    }
}

/*
To test url from commandLine
    @Parameters ({"pageUrl", "searchRequest"})
    @Test
    public void openHomePage(String pageUrl, String searchRequest) throws IOException {
        // use all code from test > openLinkFromSearch
    }
*/


