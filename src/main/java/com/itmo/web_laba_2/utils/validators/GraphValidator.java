package com.itmo.web_laba_2.utils.validators;

import com.itmo.web_laba_2.exceptions.ValidationException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GraphValidator {
    private static final Set<Double> xValues= new HashSet<>(Arrays.asList(-2.0, -1.5, -1.0, -0.5, 0.0, 0.5, 1.0, 1.5, 2.0));
    public static double validateXString(String x, boolean areaClick) throws ValidationException {
        try{
            double xValue = Double.parseDouble(x);
            if (!areaClick && !xValues.contains(xValue)){
                throw new ValidationException("X must be in set: {-2, -1.5, -1, -0.5, 0, 0.5, 1, 1.5, 2}");
            }
            return xValue;
        } catch (NumberFormatException e){
            throw new ValidationException("X must be a double!");
        }
    }

    public static double validateYString(String y,  boolean areaClick) throws ValidationException{
        try{
            double yValue = Double.parseDouble(y);
            if (!areaClick && (yValue <= -5 || yValue >=3)){
                throw new ValidationException("Y must be in interval (-5, 3)");
            }
            return yValue;
        } catch (NumberFormatException e){
            throw new ValidationException("Y must be a double!");
        }

    }

    public static double validateRString(String r) throws ValidationException{
        try{
            double rValue = Double.parseDouble(r);
            if (rValue <= 1 || rValue >=4){
                throw new ValidationException("R must be in interval (1, 4)");
            }
            return rValue;
        } catch (NumberFormatException e){
            throw new ValidationException("R must be a double!");

        }
    }


}
