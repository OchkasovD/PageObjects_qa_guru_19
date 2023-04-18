package com.demoqa.pageobjects.tests;
import org.junit.jupiter.api.Test;
public class BoxTests extends TestBase {
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