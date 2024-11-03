package com.itmo.web_laba_2.utils.parsers;

import com.itmo.web_laba_2.exceptions.IncorrectRequestException;
import com.itmo.web_laba_2.exceptions.ValidationException;
import com.itmo.web_laba_2.utils.validators.GraphValidator;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class QueryStringParser {
    public static HashMap<String, Double> parseQuery(String query, boolean areaClick) throws IncorrectRequestException, ValidationException {
        HashMap<String, Double> resultMap = new HashMap<>();
        if (query == null) {
            return resultMap;
        }

        String[] queryParams = query.split("&");
        for (String param : queryParams) {
            String[] paramKeyValue = param.split("=");
            if (paramKeyValue.length != 2) {
                throw new IncorrectRequestException("Incorrect request parameters!");
            }

            switch (paramKeyValue[0]) {
                case "x":
                    resultMap.put("x", GraphValidator.validateXString(paramKeyValue[1], areaClick));
                    break;
                case "y":
                    resultMap.put("y", GraphValidator.validateYString(paramKeyValue[1], areaClick));
                    break;
                case "r":
                    resultMap.put("r", GraphValidator.validateRString(paramKeyValue[1]));
                    break;
                case "areaClick":
                    break;
                default:
                    throw new IncorrectRequestException("Param '" + paramKeyValue[0] + "' is redundant");
            }
        }
        if (resultMap.size() != 3) {
            throw new IncorrectRequestException("There are must be 3 params: x, y, r!");
        }
        return resultMap;
    }
}
