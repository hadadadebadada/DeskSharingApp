package com.example.seleniumfrontendtest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.seleniumfrontendtest.AdminBooking.AdminBookingTest;
import com.example.seleniumfrontendtest.Booking.BookingRequestTest;
import com.example.seleniumfrontendtest.Login.LoginTest;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {

    LoginTest loginTest = new LoginTest();
    BookingRequestTest bookingRequestTest = new BookingRequestTest();

    AdminBookingTest adminBookingTest = new AdminBookingTest();
    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:3000/home");
        loginTest.loginUser();

    }

    @Test
    public void testBookingRequest() {
        bookingRequestTest.navigateToOfficeDK();



    }

    @Test
    public void checkFirstTd() {

        adminBookingTest.navigateToAdmin();


    }


}
