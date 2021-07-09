package com.demoqa.automation.tasks;

import com.demoqa.automation.models.DataInjection;
import com.demoqa.automation.userinterfaces.FormsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillAllFields implements Task {

    WebDriver driver;
    DataInjection dataInjection = new DataInjection();
    public static String name, lastName, email, phoneNumber, yearBD, monthBD, dayBD, subjects, currentAddress;


    public FillAllFields(){
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                JavaScriptClick.on(FormsPage.CLOSE_ADS_BUTTON),
                Enter.theValue(dataInjection.getName()).into(FormsPage.USER_FIRST_NAME_INPUT),
                Enter.theValue(dataInjection.getLastName()).into(FormsPage.USER_LASTNAME_INPUT),
                Enter.theValue(dataInjection.getEmail()).into(FormsPage.USER_EMAIL_INPUT),
                JavaScriptClick.on(FormsPage.GENDER_RADIO_CLICK_1),
                Enter.theValue(dataInjection.getPhoneNumber()).into(FormsPage.USER_PHONE_NUMBER_INPUT),
                JavaScriptClick.on(FormsPage.USER_DATE_BIRTH_INPUT),
                WaitUntil.the(FormsPage.USER_AGE_BIRTH_INPUT,isVisible()),
                Click.on(FormsPage.USER_AGE_BIRTH_INPUT),
                WaitUntil.the(FormsPage.USER_SELECT_AGE_BIRTH_INPUT,isVisible()),
                Click.on(FormsPage.USER_SELECT_AGE_BIRTH_INPUT),
                Click.on(FormsPage.USER_MONTH_BIRTH_INPUT),
                WaitUntil.the(FormsPage.USER_SELECT_MONTH_BIRTH_INPUT,isVisible()),
                Click.on(FormsPage.USER_SELECT_MONTH_BIRTH_INPUT),
                WaitUntil.the(FormsPage.USER_DAY_SELECT_INPUT,isVisible()),
                Click.on(FormsPage.USER_DAY_SELECT_INPUT),
                JavaScriptClick.on(FormsPage.USER_SUBJECTS_INPUT),
                Enter.keyValues(dataInjection.getSubjects()).into(FormsPage.USER_SUBJECTS_INPUT),
                WaitUntil.the(FormsPage.USER_SUBJECTS_INPUT,isVisible()),
                Enter.keyValues(Keys.ARROW_DOWN).into(FormsPage.USER_SUBJECTS_INPUT).thenHit(Keys.ENTER),
                JavaScriptClick.on(FormsPage.HOBBIES_CHECK_BOX_CLICK_2),
                Scroll.to(FormsPage.USER_UPLOAD_PICTURE_BUTTON),
                Enter.keyValues(dataInjection.getPath()).into(FormsPage.USER_UPLOAD_PICTURE_BUTTON),
                Enter.theValue(dataInjection.getAddress()).into(FormsPage.USER_ADDRESS_INPUT),
                JavaScriptClick.on(FormsPage.SELECT_STATE_BUTTON),
                Enter.keyValues(Keys.ARROW_DOWN).into(FormsPage.SELECT_STATE_BUTTON).thenHit(Keys.ENTER),
                JavaScriptClick.on(FormsPage.SELECT_CITY_BUTTON),
                Enter.keyValues(Keys.ARROW_DOWN).into(FormsPage.SELECT_CITY_BUTTON).thenHit(Keys.ENTER),
                JavaScriptClick.on(FormsPage.SUBMIT_BUTTON),
                Scroll.to(FormsPage.USER_NAME_VALIDATION)
        );
        name = dataInjection.getName();
        lastName = dataInjection.getLastName();
        email = dataInjection.getEmail();
        phoneNumber = dataInjection.getPhoneNumber();
        currentAddress = dataInjection.getAddress();
    }

    public static FillAllFields successful(){
        return instrumented(FillAllFields.class);
    }
}
