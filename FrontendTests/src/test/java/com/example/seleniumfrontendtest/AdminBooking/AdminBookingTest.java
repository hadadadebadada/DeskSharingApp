package com.example.seleniumfrontendtest.AdminBooking;

import com.codeborne.selenide.Selenide;
import org.checkerframework.checker.units.qual.A;

public class AdminBookingTest {

   AdminBookingElements adminBookingElements = new AdminBookingElements();


    public void navigateToAdmin(){
       adminBookingElements.navAdminBooking.click();


    }


}
