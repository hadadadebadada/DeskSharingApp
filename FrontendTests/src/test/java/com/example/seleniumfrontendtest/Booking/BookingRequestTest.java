package com.example.seleniumfrontendtest.Booking;

public class BookingRequestTest {
    BookingRequestElements bookingRequestElements = new BookingRequestElements();

    public void navigateToOfficeDK(){
        bookingRequestElements.navRequest.click();
        bookingRequestElements.openDK.click();
    }
}
