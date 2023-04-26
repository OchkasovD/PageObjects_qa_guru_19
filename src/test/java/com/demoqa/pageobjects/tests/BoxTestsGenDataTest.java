package com.demoqa.pageobjects.tests;
import com.demoqa.pageobjects.pages.TextBoxPage;
import org.junit.jupiter.api.Test;
import static com.demoqa.pageobjects.testData.TextBoxPageData.*;


public class BoxTestsGenDataTest extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    @Test
    void successfulFillFormTest() {
        textBoxPage.openPage()
                .setFullName(userName)
                .setEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmit();

        textBoxPage.verifyOutputName(userName)
                .verifyOutputEmail(userEmail)
                .verifyOutputCurrentAddress(currentAddress)
                .verifyOutputPermanentAddress(permanentAddress);
    }
}