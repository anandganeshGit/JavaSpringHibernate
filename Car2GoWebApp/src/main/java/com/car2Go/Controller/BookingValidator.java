package com.car2Go.Controller;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.car2Go.pojo.Booking;

@Component
public class BookingValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(Booking.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Booking newBooking = (Booking) obj;
    }
}
