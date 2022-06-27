package com.indeed.pages;

import com.indeed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    public SearchPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptAllCookies;

    @FindBy(xpath = "//input[@placeholder='Job title, keywords, or company']")
    public WebElement searchBoxOfJobTitle;

    @FindBy(xpath = "//input[@placeholder='city or postcode']")
    // attribute name is value
    public WebElement searchBoxOfJobLocation;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;

    @FindBy (xpath = "//div[@id=\"searchCountPages\"]")
    public WebElement searchResult;
}
