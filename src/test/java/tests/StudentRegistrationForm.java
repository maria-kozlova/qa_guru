package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationForm {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillOutStudentRegistrationForm() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Maria");
        $("#lastName").setValue("Kozlova");
        $("#userEmail").setValue("myemail@mail.com");
        $(byText("Female")).click();
        $("#userNumber").setValue("8582345674");
        $("#dateOfBirthInput").click();

        $(".react-datepicker__month-select").selectOptionContainingText("August");
        $(".react-datepicker__year-select").selectOptionContainingText("1996");
        $(".react-datepicker__day--026").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("picture.png");
        $("#currentAddress").setValue("123 My Address Street");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Maria Kozlova"), text("myemail@mail.com"),
                text("Female"), text("8582345674"),
                text("26 August,1996"), text("English"),
                text("Music"), text("picture.png"),
                text("123 My Address Street"), text("Haryana Karnal"));

    }

}
