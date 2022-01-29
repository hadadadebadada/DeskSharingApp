package com.example.seleniumfrontendtest.Login;

public class LoginTest {

    LoginElements loginElements = new LoginElements();
    public void loginUser(){

        loginElements.btnLogin.click();
        loginElements.inputUsername.sendKeys("admin");
        loginElements.inputPassword.sendKeys("password");
        loginElements.submitLogin.click();


    }
}
