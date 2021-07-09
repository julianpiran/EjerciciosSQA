package com.demoqa.tests.stepdefinitions;

import com.demoqa.automation.interactions.OpenBrowser;
import com.demoqa.automation.tasks.*;
import com.demoqa.automation.userinterfaces.FormsPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class FormStepDefinitions {

    @Managed
    private WebDriver driver;

    @Before
    public void autoSetUp(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Julian").can(BrowseTheWeb.with(driver));
    }


    @Given("^that a web user want to practice fill a web form$")
    public void thatAWebUserWantToPracticeFillAWebForm() {
        theActorInTheSpotlight().attemptsTo(OpenBrowser.on(FormsPage.URL));
    }

    @When("^he fill all the requested field in the form$")
    public void heFillAllTheRequestedFieldInTheForm() {
        theActorInTheSpotlight().attemptsTo(FillAllFields.successful());
    }

    @When("^he fill all the requested field in the form with the information in excel$")
    public void heFillAllTheRequestedFieldInTheFormWithTheInformationInExcel() {
        theActorInTheSpotlight().attemptsTo(FillAllFieldsWithExcel.excelSuccessful());
    }

    @When("^he fill all the requested field in the form with the information in configProperties$")
    public void heFillAllTheRequestedFieldInTheFormWithTheInformationInConfigProperties() {
        theActorInTheSpotlight().attemptsTo(FillAllFieldsWithConfigFile.configSuccessful());
    }

    @Then("^he should see his data in the register\\.$")
    public void heShouldSeeHisDataInTheRegister() {
        theActorInTheSpotlight().attemptsTo(DataInjectionValidation.compareData());
    }
    @Then("^he should see his excel data in the register\\.$")
    public void heShouldSeeHisExcelDataInTheRegister() {
        theActorInTheSpotlight().attemptsTo(ExcelValidation.compareData());
    }

    @Then("^he should see his config data in the register\\.$")
    public void heShouldSeeHisConfigDataInTheRegister() {
        theActorInTheSpotlight().attemptsTo(configFileValidations.compareData());
    }
}
