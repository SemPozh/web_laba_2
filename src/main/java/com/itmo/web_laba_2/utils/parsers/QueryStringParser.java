package com.itmo.web_laba_2.utils.parsers;

import com.itmo.web_laba_2.exceptions.IncorrectRequestException;
import com.itmo.web_laba_2.exceptions.ValidationException;
import com.itmo.web_laba_2.utils.validators.GraphValidator;
import jakarta.servlet.http.HttpServletRequest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryStringParser {
    public static List<HashMap<String, Double>> parseQuery(HttpServletRequest request, boolean areaClick) throws IncorrectRequestException, ValidationException {
        List<HashMap<String, Double>> resultList = new ArrayList<>();

        String[] xValues = request.getParameterValues("x");
        String yValue = request.getParameter("y");
        String rValue = request.getParameter("r");
        if (yValue==null || rValue==null || xValues.length==0){
            throw new IncorrectRequestException("There are must be 3 params: x, y, r!");
        }
        for (String x : xValues){
            HashMap<String, Double> shotMap = new HashMap<>();
            shotMap.put("x", GraphValidator.validateXString(x, areaClick));
            shotMap.put("y", GraphValidator.validateYString(yValue, areaClick));
            shotMap.put("r", GraphValidator.validateRString(rValue));
            resultList.add(shotMap);
        }

        return resultList;
    }
}
