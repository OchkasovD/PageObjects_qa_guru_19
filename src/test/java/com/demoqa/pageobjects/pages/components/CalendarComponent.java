package com.demoqa.pageobjects.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class CalendarComponent {

    public void setDate(String day, String month, String year){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        String dayPickerLocator = format(".react-datepicker__day--0%s:not(.react-datapicker__day--outside-,month)", day);
        $(dayPickerLocator).click();
    }
}
