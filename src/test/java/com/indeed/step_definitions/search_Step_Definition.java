package com.indeed.step_definitions;

import com.indeed.pages.SearchPage;
import com.indeed.utilities.BrowserUtils;
import com.indeed.utilities.ConfigurationReader;
import com.indeed.utilities.DBUtils;
import com.indeed.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class search_Step_Definition {

    SearchPage searchPage = new SearchPage();

    @Given("user is on uk.indeed.com search page")
    public void user_is_on_uk_indeed_com_search_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));
    }
    @When("user types SDET in the job title search box")
    public void user_types_sdet_in_the_job_title_search_box() {
        //WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
        //wait.until(ExpectedConditions.visibilityOf(searchPage.searchBoxOfJobTitle));
        searchPage.searchBoxOfJobTitle.clear();
        searchPage.searchBoxOfJobTitle.sendKeys("SDET");
    }


    @When("user types London in the location search box")
    public void user_types_london_in_the_location_search_box() {
        BrowserUtils.waitForVisibility(searchPage.searchBoxOfJobLocation,15);
        BrowserUtils.setAttribute(searchPage.searchBoxOfJobLocation,"value","London" );
    }
    @When("user clicks search button")
    public void user_clicks_search_button() {
        BrowserUtils.waitForVisibility(searchPage.searchButton,15);
        BrowserUtils.clickWithJS(searchPage.searchButton);
    }
    @Then("user sees the result")
    public void user_sees_the_result() {
        BrowserUtils.waitForClickablility(searchPage.searchResult,15);
        String result = searchPage.searchResult.getText();
        System.out.println("results = " + result);
    }

    @When("user types {string} in the job title search box")
    public void userTypesInTheJobTitleSearchBox(String string) {
        searchPage.searchBoxOfJobTitle.clear();
        searchPage.searchBoxOfJobTitle.sendKeys(string);
    }
    @When("user types {string} in the location search box")
    public void user_types_in_the_location_search_box(String string) {
        searchPage.searchBoxOfJobLocation.clear();
        searchPage.searchBoxOfJobLocation.sendKeys(string);
    }

    @When("user types lOCATION FROM DATABASE in the location search box")
    public void user_types_l_ocatıon_from_database_in_the_location_search_box() {
        DBUtils.createConnection();

        String query = "SELECT CITY_NAME FROM INDEED_LOCATIONS\n" +
                "WHERE LOC_ID=1";

        Map<String,Object> location = DBUtils.getRowMap(query);

        String city = (String) location.get("CITY_NAME");

        searchPage.searchBoxOfJobLocation.sendKeys(city);

        DBUtils.destroy();

        //HDHDHHH

    }

    /*
          // If you have alert such as google etc.
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
     */

}
