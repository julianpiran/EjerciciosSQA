package com.demoqa.automation.models;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataInjection {

    Faker faker = new Faker(new Locale("es-ES"));

    private final String name;
    private final String email;
    private final String lastName;
    private final String phoneNumber;
    private static int ageBD;
    private static int monthBD;
    private static int dayBD;
    private final String subjects;
    private final String path;
    private final String address;
    private final String filePath;
    private final String sheetName;
    private static String ScreenshotDI;
    private final String ScreenshotEx;
    private final String ScreenshotCp;

    public DataInjection() {

        this.name = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = faker.internet().emailAddress();
        this.phoneNumber = faker.phoneNumber().subscriberNumber(10);
        ageBD = faker.number().numberBetween(1900,2021);
        monthBD = faker.number().numberBetween(0,11);
        dayBD = faker.number().numberBetween(10,30);
        this.subjects = faker.letterify("?");
        this.path = "C:\\Users\\user\\Pictures\\Sin titulo.jpg";
        this.address = faker.address().fullAddress();
        this.filePath = "resources/DataInjection.xlsx";
        this.sheetName = "DataInjection";
        this.ScreenshotDI = "D:\\Cursos\\CursoSQA\\FirstProjectScreenplay\\ScreenshotDI.jpg";
        this.ScreenshotEx = "D:\\Cursos\\CursoSQA\\FirstProjectScreenplay\\ScreenshotEx.jpg";
        this.ScreenshotCp = "D:\\Cursos\\CursoSQA\\FirstProjectScreenplay\\ScreenshotCp.jpg";
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAgeBD() {
        return ageBD;
    }

    public int getMonthBD() {
        return monthBD;
    }

    public int getDayBD() {
        return dayBD;
    }

    public String getSubjects() {
        return subjects;
    }

    public String getPath() {
        return path;
    }

    public String getAddress() {
        return address;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getSheetName() {
        return sheetName;
    }

    public String getScreenshotDI() {
        return ScreenshotDI;
    }

    public String getScreenshotEx() {
        return ScreenshotEx;
    }

    public String getScreenshotCp() {
        return ScreenshotCp;
    }
}
