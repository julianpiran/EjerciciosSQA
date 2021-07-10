package com.demoqa.automations.steps;

import com.demoqa.automations.models.DataInjection;
import com.demoqa.automations.pageobjects.WebTablePage;
import com.demoqa.automations.utils.Javasript;
import net.thucydides.core.annotations.Step;

import java.util.concurrent.TimeUnit;

public class WebTableSteps {
    WebTablePage webTablePage = new WebTablePage();
    DataInjection dataInjection = new DataInjection();


    @Step
    public void openBrowser() {
        webTablePage.open();
    }

    @Step
    public void openWebElementPage() throws InterruptedException {
        webTablePage.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Javasript.clickJS(webTablePage.getDriver(), webTablePage.elementClick);
        Thread.sleep(2000);
        Javasript.clickJS(webTablePage.getDriver(),webTablePage.webTableClick);
        Javasript.clickJS(webTablePage.getDriver(),webTablePage.addToWebTable);
        webTablePage.sendText(webTablePage.firstNameInput, dataInjection.getName());
        webTablePage.sendText(webTablePage.lastNameInput,dataInjection.getLastName());
        webTablePage.sendText(webTablePage.emailInput,dataInjection.getEmail());
        webTablePage.sendText(webTablePage.ageInput,dataInjection.getAge());
        webTablePage.sendText(webTablePage.salaryInput,dataInjection.getSalary());
        webTablePage.sendText(webTablePage.departmentInput,dataInjection.getDepartment());
        Javasript.clickJS(webTablePage.getDriver(),webTablePage.buttonSubmit);
    }

    @Step
    public void validationWebTable (){
        webTablePage.validations(webTablePage.nameValidation,dataInjection.getName());
        webTablePage.validations(webTablePage.lastnameValidation,dataInjection.getLastName());
        webTablePage.validations(webTablePage.ageValidation,dataInjection.getAge());
        webTablePage.validations(webTablePage.emailValidation,dataInjection.getEmail());
        webTablePage.validations(webTablePage.salaryValidation,dataInjection.getSalary());
        webTablePage.validations(webTablePage.departmentValidation,dataInjection.getDepartment());
    }
}
