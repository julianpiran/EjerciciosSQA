package com.demoqa.automations.pageobjects;

import com.demoqa.automations.models.DataInjection;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import static org.junit.Assert.*;

@DefaultUrl("https://www.demoqa.com/")
public class WebTablePage extends PageObject {

    DataInjection dataInjection = new DataInjection();

    public By elementClick = By.xpath("//*[text() = 'Elements']");
    public By webTableClick = By.xpath("//*[text() = 'Web Tables']");
    public By addToWebTable = By.id("addNewRecordButton");
    public By firstNameInput = By.id("firstName");
    public By lastNameInput = By.id("lastName");
    public By emailInput = By.id("userEmail");
    public By ageInput = By.id("age");
    public By salaryInput = By.id("salary");
    public By departmentInput = By.id("department");
    public By buttonSubmit = By.id("submit");
    public By nameValidation = By.xpath("//div[contains (text(),"+"'"+dataInjection.getName()+"'"+")]");


    public void sendText(By locator, String text){
        getDriver().findElement(locator).sendKeys(text);
    }
    public void clickElement (By locator){
        getDriver().findElement(locator).click();
    }

    public void validations (String expectedName){
        assertEquals(getDriver().findElement(nameValidation).getText(),expectedName);
    }
}
