package com.example.seleniumfrontendtest.Booking;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
public class BookingRequestElements {

    public SelenideElement navRequest = $x("/html/body/div/div/nav/div/ul/li[2]/a");
    public SelenideElement openDK = $x("/html/body/div/div/div[1]/div[1]/div/div/ul/li[1]/a/div/h5");

}
