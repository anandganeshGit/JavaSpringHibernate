package com.car2Go.Controller;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.car2Go.pojo.CarType;

import org.springframework.validation.ValidationUtils;

@Component
public class CarTypeValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(CarType.class);
    }

    public void validate(Object obj, Errors errors)
    {
        CarType newCarType = (CarType) obj;

    }
}
