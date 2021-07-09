package com.demoqa.automation.userinterfaces;

import com.demoqa.automation.models.DataInjection;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FormsPage {
    public static final DataInjection dataInjection = new DataInjection();
    public static String URL = "https://www.demoqa.com/automation-practice-form";
    public static final Target CLOSE_ADS_BUTTON = Target.the("").located(By.id("close-fixedban"));
    public static final Target USER_FIRST_NAME_INPUT = Target.the("").located(By.id("firstName"));
    public static final Target USER_LASTNAME_INPUT = Target.the("").located(By.id("lastName"));
    public static final Target USER_EMAIL_INPUT = Target.the("").located(By.id("userEmail"));
    public static final Target GENDER_RADIO_CLICK_1 = Target.the("").located(By.id("gender-radio-1"));
    public static final Target GENDER_RADIO_CLICK_2 = Target.the("").located(By.id("gender-radio-2"));
    public static final Target GENDER_RADIO_CLICK_3 = Target.the("").located(By.id("gender-radio-3"));
    public static final Target USER_PHONE_NUMBER_INPUT = Target.the("").located(By.id("userNumber"));
    public static final Target USER_DATE_BIRTH_INPUT = Target.the("").located(By.id("dateOfBirthInput"));

    public static final Target USER_AGE_BIRTH_INPUT = Target.the("").locatedBy("//select[@class = 'react-datepicker__year-select']");
    public static final Target USER_SELECT_AGE_BIRTH_INPUT = Target.the("").
            locatedBy("//select[@class = 'react-datepicker__year-select']//option [@value = '"+dataInjection.getAgeBD()+"']");

    public static final Target USER_MONTH_BIRTH_INPUT = Target.the("").locatedBy("//select[@class = 'react-datepicker__month-select']");
    public static final Target USER_SELECT_MONTH_BIRTH_INPUT = Target.the("").
            locatedBy("//select[@class = 'react-datepicker__month-select']//option [@value = '"+dataInjection.getMonthBD()+"']");

    public static final Target USER_DAY_SELECT_INPUT = Target.the("").
            locatedBy("//div[@class = 'react-datepicker__day react-datepicker__day--0"+dataInjection.getDayBD()+"']");



    public static final Target USER_SUBJECTS_INPUT = Target.the("").located(By.id("subjectsInput"));
    public static final Target HOBBIES_CHECK_BOX_CLICK_1 = Target.the("").located(By.id("hobbies-checkbox-1"));
    public static final Target HOBBIES_CHECK_BOX_CLICK_2 = Target.the("").located(By.id("hobbies-checkbox-2"));
    public static final Target HOBBIES_CHECK_BOX_CLICK_3 = Target.the("").located(By.id("hobbies-checkbox-3"));
    public static final Target USER_UPLOAD_PICTURE_BUTTON = Target.the("").located(By.id("uploadPicture"));
    public static final Target USER_ADDRESS_INPUT = Target.the("").located(By.id("currentAddress"));
    public static final Target SELECT_STATE_BUTTON = Target.the("").located(By.id("react-select-3-input"));
    public static final Target SELECT_CITY_BUTTON = Target.the("").located(By.id("react-select-4-input"));
    public static final Target SUBMIT_BUTTON = Target.the("").located(By.id("submit"));

    public static final Target USER_NAME_VALIDATION = Target.the("").locatedBy("//tr[1]//td[2]");
    public static final Target USER_EMAIL_VALIDATION = Target.the("").locatedBy("//tr[2]//td[2]");
    public static final Target USER_GENDER_VALIDATION = Target.the("").locatedBy("//tr[3]//td[2]");
    public static final Target USER_MOBILE_VALIDATION = Target.the("").locatedBy("//tr[4]//td[2]");
    public static final Target USER_DATE_BIRTH_VALIDATION = Target.the("").locatedBy("//tr[5]//td[2]");
    public static final Target USER_SUBJECT_VALIDATION = Target.the("").locatedBy("//tr[6]//td[2]");
    public static final Target USER_HOBBIES_VALIDATION = Target.the("").locatedBy("//tr[7]//td[2]");
    public static final Target USER_ADDRESS_VALIDATION = Target.the("").locatedBy("//tr[9]//td[2]");
    public static final Target USER_STATE_CITY_VALIDATION = Target.the("").locatedBy("//tr[10]//td[2]");



}
