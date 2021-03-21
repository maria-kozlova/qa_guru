package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTestGitHub {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void verifyWikiPageOnGotHub() {
        open("https://github.com/");

        $("[name='q']").setValue("Selenide").pressEnter();
        $("ul.repo-list li a").click();
        $("[itemprop='name'] a").shouldHave(text("selenide"));
        $(byText("Wiki")).click();
        $(byText("Soft assertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
    }

}
