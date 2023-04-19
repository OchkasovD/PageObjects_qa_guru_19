package com.demoqa.pageobjects.tests;
import com.demoqa.pageobjects.pages.TextBoxPage;
import org.junit.jupiter.api.Test;


public class BoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void successfulFillFormTest() {
        textBoxPage.openPage()
                .setFullName("Name")
                .setEmail("mail@mail.com")
                .setCurrentAddress("street")
                .setPermanentAddress("street1")
                .clickSubmit();

        textBoxPage.verifyOutputName("Name")
                .verifyOutputEmail("mail@mail.com")
                .verifyOutputCurrentAddress("street")
                .verifyOutputPermanentAddress("street1");
    }
}