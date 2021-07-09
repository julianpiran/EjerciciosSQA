package com.demoqa.automation.tasks;

import com.demoqa.automation.models.DataInjection;
import com.demoqa.automation.userinterfaces.FormsPage;
import com.demoqa.automation.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.Keys;

import java.io.IOException;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillAllFieldsWithExcel implements Task {

    DataInjection dataInjection = new DataInjection();

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    JavaScriptClick.on(FormsPage.CLOSE_ADS_BUTTON),
                    Enter.theValue(Excel.getCellInformation(dataInjection.getFilePath(), dataInjection.getSheetName(), 1, 0)).into(FormsPage.USER_FIRST_NAME_INPUT),
                    Enter.theValue(Excel.getCellInformation(dataInjection.getFilePath(), dataInjection.getSheetName(), 1, 1)).into(FormsPage.USER_LASTNAME_INPUT),
                    Enter.theValue(Excel.getCellInformation(dataInjection.getFilePath(), dataInjection.getSheetName(), 1, 2)).into(FormsPage.USER_EMAIL_INPUT),
                    JavaScriptClick.on(FormsPage.GENDER_RADIO_CLICK_1),
                    Enter.theValue(Excel.getCellInformation(dataInjection.getFilePath(), dataInjection.getSheetName(), 1, 3)).into(FormsPage.USER_PHONE_NUMBER_INPUT),
                    Enter.keyValues(Keys.CONTROL,"a").into(FormsPage.USER_DATE_BIRTH_INPUT),
                    Enter.keyValues(Excel.getCellInformation(dataInjection.getFilePath(), dataInjection.getSheetName(), 1, 4)).into(FormsPage.USER_DATE_BIRTH_INPUT).thenHit(Keys.ENTER),
                    Scroll.to(FormsPage.USER_SUBJECTS_INPUT),
                    Enter.keyValues(Excel.getCellInformation(dataInjection.getFilePath(), dataInjection.getSheetName(), 1, 5)).into(FormsPage.USER_SUBJECTS_INPUT).thenHit(Keys.ENTER),
                    JavaScriptClick.on(FormsPage.HOBBIES_CHECK_BOX_CLICK_1),
                    Enter.keyValues(Excel.getCellInformation(dataInjection.getFilePath(), dataInjection.getSheetName(),1,6)).into(FormsPage.USER_UPLOAD_PICTURE_BUTTON),
                    Enter.theValue(Excel.getCellInformation(dataInjection.getFilePath(), dataInjection.getSheetName(),1,7)).into(FormsPage.USER_ADDRESS_INPUT),
                    Enter.theValue(Excel.getCellInformation(dataInjection.getFilePath(), dataInjection.getSheetName(),1,8)).into(FormsPage.SELECT_STATE_BUTTON).thenHit(Keys.ENTER),
                    Enter.theValue(Excel.getCellInformation(dataInjection.getFilePath(), dataInjection.getSheetName(),1,9)).into(FormsPage.SELECT_CITY_BUTTON).thenHit(Keys.ENTER),
                    JavaScriptClick.on(FormsPage.SUBMIT_BUTTON),
                    Scroll.to(FormsPage.USER_NAME_VALIDATION)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FillAllFieldsWithExcel excelSuccessful() {
        return instrumented(FillAllFieldsWithExcel.class);
    }
}
