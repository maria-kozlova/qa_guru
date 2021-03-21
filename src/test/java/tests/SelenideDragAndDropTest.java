package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideDragAndDropTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void dragAndDropExerciseWithSelenide() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

// doesn't work with actions for me for some reason
//        Selenide.actions().dragAndDrop($("#column-a"), $("#column-b")).release().perform();
        $("#column-a").dragAndDropTo("#column-b");
    }
}
