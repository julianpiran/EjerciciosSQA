package com.demoqa.automation.tasks;

import com.demoqa.automation.userinterfaces.FormsPage;
import com.demoqa.automation.utils.SpecialMethods;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillAllFieldsWithConfigFile implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        SpecialMethods.configProperties();

        actor.attemptsTo(
                JavaScriptClick.on(FormsPage.CLOSE_ADS_BUTTON),
                Enter.theValue(SpecialMethods.properties.getProperty("name")).into(FormsPage.USER_FIRST_NAME_INPUT),
                Enter.theValue(SpecialMethods.properties.getProperty("lastname")).into(FormsPage.USER_LASTNAME_INPUT),
                Enter.theValue(SpecialMethods.properties.getProperty("email")).into(FormsPage.USER_EMAIL_INPUT),
                JavaScriptClick.on(FormsPage.GENDER_RADIO_CLICK_2),
                Enter.theValue(SpecialMethods.properties.getProperty("mobile")).into(FormsPage.USER_PHONE_NUMBER_INPUT),
                Enter.keyValues(Keys.CONTROL,"a").into(FormsPage.USER_DATE_BIRTH_INPUT),
                Enter.keyValues(SpecialMethods.properties.getProperty("dateOfBirth")).into(FormsPage.USER_DATE_BIRTH_INPUT).thenHit(Keys.ENTER),
                Enter.keyValues(SpecialMethods.properties.getProperty("subjects")).into(FormsPage.USER_SUBJECTS_INPUT).thenHit(Keys.ENTER),
                JavaScriptClick.on(FormsPage.HOBBIES_CHECK_BOX_CLICK_3),
                Enter.keyValues(SpecialMethods.properties.getProperty("picture")).into(FormsPage.USER_UPLOAD_PICTURE_BUTTON),
                Enter.theValue(SpecialMethods.properties.getProperty("currentAddress")).into(FormsPage.USER_ADDRESS_INPUT),
                Enter.keyValues(SpecialMethods.properties.getProperty("state")).into(FormsPage.SELECT_STATE_BUTTON).thenHit(Keys.ENTER),
                Enter.keyValues(SpecialMethods.properties.getProperty("city")).into(FormsPage.SELECT_CITY_BUTTON).thenHit(Keys.ENTER),
                JavaScriptClick.on(FormsPage.SUBMIT_BUTTON),
                Scroll.to(FormsPage.USER_NAME_VALIDATION)

        );
    }
    public static FillAllFieldsWithConfigFile configSuccessful(){
        return instrumented(FillAllFieldsWithConfigFile.class);
    }
}
