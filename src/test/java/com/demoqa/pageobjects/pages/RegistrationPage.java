package com.demoqa.pageobjects.pages;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.StringEscapeUtils;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
public class RegistrationPage {

    //SelenideElements / Locator / etc
    SelenideElement
                firstnameInput = $("#firstName"),
                lastnameInput = $("#lastName"),
                useremailInput = $("#userEmail"),
                gender= $("#genterWrapper");

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

}