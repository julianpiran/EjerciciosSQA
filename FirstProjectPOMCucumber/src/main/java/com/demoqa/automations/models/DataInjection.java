package com.demoqa.automations.models;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataInjection {
    Faker faker = new Faker(new Locale("es-ES"));

    private String name, email, lastName, age, salary, department;

    public DataInjection() {

        this.name = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = faker.internet().emailAddress();
        this.age = String.valueOf(faker.number().numberBetween(18,90));
        this.salary = String.valueOf(faker.number().numberBetween(2000,3000));
        this.department = faker.country().capital();
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

    public String getAge() {
        return age;
    }

    public String getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }
}
