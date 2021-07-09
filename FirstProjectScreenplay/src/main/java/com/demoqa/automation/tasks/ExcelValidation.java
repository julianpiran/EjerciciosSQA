package com.demoqa.automation.tasks;

import com.demoqa.automation.models.DataInjection;
import com.demoqa.automation.questions.GetTextFormQuestion;
import com.demoqa.automation.userinterfaces.FormsPage;
import com.demoqa.automation.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.io.IOException;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

public class ExcelValidation implements Task {

    DataInjection dataInjection = new DataInjection();

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.should(
                    seeThat(GetTextFormQuestion.in(FormsPage.USER_NAME_VALIDATION),equalToIgnoringCase(Excel.getCellInformation(dataInjection.getFilePath(),dataInjection.getSheetName(),1,0)
                    +" "+Excel.getCellInformation(dataInjection.getFilePath(),dataInjection.getSheetName(),1,1))),
                    seeThat(GetTextFormQuestion.in(FormsPage.USER_EMAIL_VALIDATION),equalToIgnoringCase(Excel.getCellInformation(dataInjection.getFilePath(),dataInjection.getSheetName(),1,2))),
                    seeThat(GetTextFormQuestion.in(FormsPage.USER_MOBILE_VALIDATION),equalToIgnoringCase(Excel.getCellInformation(dataInjection.getFilePath(),dataInjection.getSheetName(),1,3))),
                    seeThat(GetTextFormQuestion.in(FormsPage.USER_DATE_BIRTH_VALIDATION),equalToIgnoringCase(Excel.getCellInformation(dataInjection.getFilePath(),dataInjection.getSheetName(),1,4))),
                    seeThat(GetTextFormQuestion.in(FormsPage.USER_SUBJECT_VALIDATION),equalToIgnoringCase(Excel.getCellInformation(dataInjection.getFilePath(),dataInjection.getSheetName(),1,5))),
                    seeThat(GetTextFormQuestion.in(FormsPage.USER_ADDRESS_VALIDATION),equalToIgnoringCase(Excel.getCellInformation(dataInjection.getFilePath(),dataInjection.getSheetName(),1,7))),
                    seeThat(GetTextFormQuestion.in(FormsPage.USER_STATE_CITY_VALIDATION),equalToIgnoringCase(Excel.getCellInformation(dataInjection.getFilePath(),dataInjection.getSheetName(),1,8)
                            +" "+Excel.getCellInformation(dataInjection.getFilePath(),dataInjection.getSheetName(),1,9)))


                    );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static ExcelValidation compareData(){
        return instrumented (ExcelValidation.class);
    }
}
