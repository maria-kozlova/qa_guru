package PageObject;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormPage {
    Faker faker = new Faker();

    //Data Storage - NOT the best practice
    String firstName = faker.name().firstName(),
    lastName = faker.name().lastName(),
    email = faker.internet().emailAddress(),
    phoneNumber = faker.number().digits(10),
    gender = "Female",
    date = "26",
    month = "August",
    year = "1996",
    language = "English",
    picturePath = "picture.png",
    address = faker.address().fullAddress(),
    state = "Haryana",
    city = "Karnal";

    public StudentRegistrationFormPage openPage() {
        String pageUrl = "https://demoqa.com/automation-practice-form";
        open(pageUrl);
        return this;
    }

    public StudentRegistrationFormPage fillOutTheForm() {
        $("#firstName").setValue(firstName);
        System.out.println(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText(gender)).click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        selectDateOfBirth();
        $("#subjectsInput").setValue(language).pressEnter();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath(picturePath);
        $("#currentAddress").setValue(address);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();
        return this;
    }

    public void selectDateOfBirth() {
        $(".react-datepicker__month-select").selectOptionContainingText(month);
        $(".react-datepicker__year-select").selectOptionContainingText(year);
        $(".react-datepicker__day--0"+date).click();
    }

    public void VerifyData() {
        System.out.println("VERIFY ----" +firstName);
        $(".table-responsive").shouldHave(text(firstName + " "+ lastName), text(email),
                text(gender), text(phoneNumber),
                text(date + " " + month + ","+ year), text(language),
                text("Music"), text(picturePath),
                text(address), text(state + " " + city));
    }

}
