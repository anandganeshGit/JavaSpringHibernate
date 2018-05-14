package com.car2Go.Controller;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.car2Go.pojo.Car;

import org.springframework.validation.ValidationUtils;

@Component
public class CarValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(Car.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Car newCar = (Car) obj;
    }
}

