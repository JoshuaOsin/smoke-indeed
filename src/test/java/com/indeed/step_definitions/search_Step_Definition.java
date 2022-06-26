package com.indeed.step_definitions;

import com.indeed.pages.SearchPage;
import com.indeed.utilities.ConfigurationReader;
import com.indeed.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class search_Step_Definition {

    SearchPage searchPage = new SearchPage();

    @Given("user is on uk.indeed.com search page")
    public void user_is_on_uk_indeed_com_search_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));
    }
    @When("user types SDET in the job title search box")
    public void user_types_sdet_in_the_job_title_search_box() {
        searchPage.searchBoxOfJobTitle.sendKeys("SDET");
    }
    @When("user types London in the location search box")
    public void user_types_london_in_the_location_search_box() {
        searchPage.searchBoxOfJobLocation.sendKeys("London");
    }
    @When("user clicks search button")
    public void user_clicks_search_button() {
        searchPage.searchButton.click();
    }
    @Then("user sees SDET jobs in London on the result")
    public void user_sees_sdet_jobs_in_london_on_the_result() {
        String result = searchPage.searchResult.getText();
        System.out.println("result = " + result);
    }

    /*
          // If you have alert such as google etc.
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
     */

}
