package com.itmo.web_laba_2.utils.validators;

import com.itmo.web_laba_2.exceptions.ValidationException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GraphValidator {
    private static final Set<Double> xValues= new HashSet<>(Arrays.asList(-2.0, -1.5, -1.0, -0.5, 0.0, 0.5, 1.0, 1.5, 2.0));
    public static double validateXValue(double x) throws ValidationException {
        if (!xValues.contains(x)){
            throw new ValidationException("X must be in set: {-2, -1.5, -1, -0.5, 0, 0.5, 1, 1.5, 2}");
        }
        return x;
    }

    public static double validateYValue(double y) throws ValidationException{
        if (y <= -5 || y >=3){
            throw new ValidationException("Y must be in interval (-5, 3)");
        }
        return y;
    }

    public static double validateRValue(double r) throws ValidationException{
        if (r <= 1 || r >=4){
            throw new ValidationException("R must be in interval (1, 4)");
        }
        return r;
    }


}
