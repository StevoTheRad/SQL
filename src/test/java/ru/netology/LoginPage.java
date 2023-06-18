package ru.netology;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static java.awt.SystemColor.info;

public class LoginPage {

    private SelenideElement errorNotification = $("[data-test-id='error-notification']");
    private SelenideElement loginField = $(".input__control[type=text]");
    private SelenideElement passwordField = $(".input__control[type='password']");
    private SelenideElement loginButton = $("[data-test-id='action-login']");


    public void verifyErrorNotificationVisibility() {
        errorNotification.shouldBe(visible);
    }

    public VerificationPage validLogin(DataHelper.AuthInfo info ) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }
}
