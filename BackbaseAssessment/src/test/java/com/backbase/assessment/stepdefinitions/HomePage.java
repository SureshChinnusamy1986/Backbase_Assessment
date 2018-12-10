package com.backbase.assessment.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage {

    public WebDriver driver;

    public HomePage() {
        this.driver = new SeleniumDef().getDriver();
    }

    @Given("^I navigate to the herokuapp website$")
    public void i_navigate_to_the_herokuapp_website() {
        SeleniumDef.loadPage("http://computer-database.herokuapp.com/computers");
    }

    @And("^I landed on the herokuapp website$")
    public void i_landed_to_the_herokuapp_website() throws InterruptedException {
        Thread.sleep(5000);
        String actualTitle = SeleniumDef.getPageTitle();
        String expectedTitle = "Computers database";
        Assert.assertEquals(expectedTitle, actualTitle);

    }

    @Then("^Input \"([^\"]*)\" in the text field in the top left corner of the screen$")
    public void input_in_the_text_field_in_the_top_left_corner_of_the_screen(String computerName) {
        SeleniumDef.getElementById(Constants.FILTER_BY_NAME_TEXT_BOX_ID).sendKeys(computerName);
    }



    @When("^Click the 'filter by name' button in the text field in the top left corner of the screen$")

    public void click_the_filter_by_name_button_in_the_text_field_in_the_top_left_corner_of_the_screen() {
        SeleniumDef.getElementById(Constants.FILTER_BY_NAME_BUTTON_ID).click();
    }

    @Then("^\"([^\"]*)\" is displayed in the screen$")
    public void is_displayed_in_the_screen(String computerName) {
        Boolean expectedResult = true;
        Boolean acutalValue = SeleniumDef.table(Constants.COMPUTER_TABLE_XPATH, computerName);
        assertEquals(acutalValue, expectedResult);
    }

}
