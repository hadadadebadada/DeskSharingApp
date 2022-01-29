package com.example.seleniumfrontendtest.AdminBooking;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class AdminBookingElements {

    public SelenideElement navAdminBooking = $x("//*[@id=\"root\"]/div/nav/div/ul/li[5]/a");
    public SelenideElement tdRowFirst = $x("//*[@id=\"root\"]/div/div[1]/div[2]/table/tbody/tr/td[1]");

}
