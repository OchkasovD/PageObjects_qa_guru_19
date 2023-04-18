package com.demoqa.pageobjects.pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.pageobjects.pages.components.CalendarComponent;
import com.demoqa.pageobjects.pages.components.ResultsModal;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    //SelenideElements / Locator / etc
    ResultsModal resultsModal = new ResultsModal();
    SelenideElement
                firstnameInput = $("#firstName"),
                lastnameInput = $("#lastName"),
                useremailInput = $("#userEmail"),
                gender= $("#genterWrapper"),
                userNumber= $("#userNumber"),
                dateOfBirthInput = $("#dateOfBirthInput"),
                subjectsInput = $("#subjectsInput"),
                hobbies = $("#hobbiesWrapper"),
                pictureInput = $("#uploadPicture"),
                currentAddressInput = $("#currentAddress"),
                stateInput = $("#state"),
                cityInput = $("#city"),
                stateAndCity = $("#stateCity-wrapper"),
                submitButton = $("#submit");


    //Actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }public RegistrationPage setFirstName(String value) {
        firstnameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {

        lastnameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        useremailInput.setValue(value);

        return this;
    }
    public RegistrationPage setGender(String value) {
        gender.$(byText("Other")).click();

        return this;
    }

    public RegistrationPage setNumber(String value) {
        userNumber.setValue(value);

        return this;

    }

    public void setBirthDate(String day, String month, String year){
        dateOfBirthInput.click();
        calendarComponent.setDate(day,month,year);
    }

    public RegistrationPage verifyRegistrationResultsModalAppears() {
       resultsModal.verifyModalAppears();

       return this;
    }
        public RegistrationPage verifyResult(String key, String value){
            resultsModal.verifyResult(key, value);

            return this;
}
    }