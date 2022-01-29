package com.example.seleniumfrontendtest.Login;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class LoginElements {

        public SelenideElement btnLogin = $x("/html/body/div/div/nav/div/ul/li[6]/a/button");
        public SelenideElement inputUsername = $x("//*[@id=\"username\"]");
        public SelenideElement inputPassword = $x("//*[@id=\"password\"]");
        public SelenideElement submitLogin = $x("//*[@id=\"root\"]/div/div[1]/button");


        }
