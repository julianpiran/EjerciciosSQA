package com.demoqa.automation.tasks;

import com.demoqa.automation.questions.GetTextFormQuestion;
import com.demoqa.automation.userinterfaces.FormsPage;
import com.demoqa.automation.utils.SpecialMethods;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

public class configFileValidations implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.should(
                seeThat(GetTextFormQuestion.in(FormsPage.USER_NAME_VALIDATION),equalToIgnoringCase(SpecialMethods.properties.getProperty("nameValidation"))),
                seeThat(GetTextFormQuestion.in(FormsPage.USER_EMAIL_VALIDATION),equalToIgnoringCase(SpecialMethods.properties.getProperty("email"))),
                seeThat(GetTextFormQuestion.in(FormsPage.USER_MOBILE_VALIDATION),equalToIgnoringCase(SpecialMethods.properties.getProperty("mobile"))),
                seeThat(GetTextFormQuestion.in(FormsPage.USER_DATE_BIRTH_VALIDATION),equalToIgnoringCase(SpecialMethods.properties.getProperty("dateOfBirth"))),
                seeThat(GetTextFormQuestion.in(FormsPage.USER_SUBJECT_VALIDATION),equalToIgnoringCase(SpecialMethods.properties.getProperty("subjects"))),
                seeThat(GetTextFormQuestion.in(FormsPage.USER_ADDRESS_VALIDATION),equalToIgnoringCase(SpecialMethods.properties.getProperty("currentAddress"))),
                seeThat(GetTextFormQuestion.in(FormsPage.USER_STATE_CITY_VALIDATION),equalToIgnoringCase(SpecialMethods.properties.getProperty("stateCityValidation")))
        );
    }

    public static configFileValidations compareData(){
        return instrumented (configFileValidations.class);
    }
}
