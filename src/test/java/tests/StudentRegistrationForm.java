package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Condition.text;
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
        $("[for='gender-radio-2']").click();
        $("#userNumber").setValue("8582345674");
        $("#dateOfBirthInput").click();

        Select months = new Select($(".react-datepicker__month-select"));
        months.selectByVisibleText("August");
        Select year = new Select($(".react-datepicker__year-select"));
        year.selectByVisibleText("1996");
        $("[aria-label='Choose Monday, August 26th, 1996']").click();
        $("#subjectsInput").setValue("English");
        $("#subjectsInput").pressEnter();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").sendKeys("/Users/maria.kozlova/IdeaProjects/qa_guru/Screen Shot 2021-03-02 at 8.32.20 PM.png");
        $("#currentAddress").setValue("123 My Address Street");
        $("#react-select-3-input").setValue("Haryana");
        $("#react-select-3-input").pressEnter();
        $("#react-select-4-input").setValue("Karnal");
        $("#react-select-4-input").pressEnter();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Maria Kozlova"))
                .shouldHave(text("myemail@mail.com"))
                .shouldHave(text("Female"))
                .shouldHave(text("8582345674"))
                .shouldHave(text("26 August,1996"))
                .shouldHave(text("English"))
                .shouldHave(text("Music"))
                .shouldHave(text("Screen Shot 2021-03-02 at 8.32.20 PM.png"))
                .shouldHave(text("123 My Address Street"))
                .shouldHave(text("Haryana Karnal"));

    }

}
