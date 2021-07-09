package com.demoqa.automation.tasks;

import com.demoqa.automation.questions.GetTextFormQuestion;
import com.demoqa.automation.userinterfaces.FormsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class DataInjectionValidation implements Task {



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.should(seeThat(GetTextFormQuestion.in(FormsPage.USER_NAME_VALIDATION),equalToIgnoringCase(FillAllFields.name+" "+FillAllFields.lastName)));
        actor.should(seeThat(GetTextFormQuestion.in(FormsPage.USER_EMAIL_VALIDATION),equalToIgnoringCase(FillAllFields.email)));
        actor.should(seeThat(GetTextFormQuestion.in(FormsPage.USER_MOBILE_VALIDATION),equalToIgnoringCase(FillAllFields.phoneNumber)));
        actor.should(seeThat(GetTextFormQuestion.in(FormsPage.USER_ADDRESS_VALIDATION),equalToIgnoringCase(FillAllFields.currentAddress)));
    }

    public static DataInjectionValidation compareData (){
        return instrumented (DataInjectionValidation.class);
    }
}
