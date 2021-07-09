package com.demoqa.test.stepdefinitions;

import com.demoqa.automations.steps.WebTableSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class practiceWebTableStepDefinition {

    @Steps
    WebTableSteps webTableSteps;

    @Given("^that a web user want to practice fill web table in demoqa$")
    public void thatAWebUserWantToPracticeFillWebTableInDemoqa() {
        webTableSteps.openBrowser();
    }


    @When("^he fills all the requested fields in the page to add in the web table$")
    public void heFillsAllTheRequestedFieldsInThePageToAddInTheWebTable() throws InterruptedException {
        webTableSteps.openWebElementPage();
    }

    @Then("^he should see all him information in the web table$")
    public void heShouldSeeAllHimInformationInTheWebTable() {
        webTableSteps.validationWebTable();
    }
}
