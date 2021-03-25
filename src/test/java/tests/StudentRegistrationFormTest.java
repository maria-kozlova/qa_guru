package tests;

import PageObject.StudentRegistrationFormPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class StudentRegistrationFormTest {
    StudentRegistrationFormPage studentRegistrationFormPage;

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillOutStudentRegistrationForm() {
        studentRegistrationFormPage = new StudentRegistrationFormPage();

        studentRegistrationFormPage.openPage()
                .fillOutTheForm()
                .VerifyData();
    }

}
