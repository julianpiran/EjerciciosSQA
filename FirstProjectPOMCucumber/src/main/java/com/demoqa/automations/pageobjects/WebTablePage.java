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
    public By nameValidation = By.xpath("//div[@id='app']//div[4]/div/div[1]");
    public By lastnameValidation = By.xpath("//div[@id='app']//div[4]/div/div[2]");
    public By ageValidation = By.xpath("//div[@id='app']//div[4]/div/div[3]");
    public By emailValidation = By.xpath("//div[@id='app']//div[4]/div/div[4]");
    public By salaryValidation = By.xpath("//div[@id='app']//div[4]/div/div[5]");
    public By departmentValidation = By.xpath("//div[@id='app']//div[4]/div/div[6]");


    public void sendText(By locator, String text){
        getDriver().findElement(locator).sendKeys(text);
    }
    public void clickElement (By locator){
        getDriver().findElement(locator).click();
    }

    public void validations (By locator, String expectedParameter){
        assertEquals(getDriver().findElement(locator).getText(),expectedParameter);
    }
}
