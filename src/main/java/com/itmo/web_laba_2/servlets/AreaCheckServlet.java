package com.itmo.web_laba_2.servlets;

import com.itmo.web_laba_2.exceptions.IncorrectRequestException;
import com.itmo.web_laba_2.exceptions.ValidationException;
import com.itmo.web_laba_2.model.ShotResult;
import com.itmo.web_laba_2.utils.parsers.QueryStringParser;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HashMap<String, Double> requestParams = QueryStringParser.parseQuery(req.getQueryString());
            HttpSession session = req.getSession();
            if (session.getAttribute("shots")==null){
                session.setAttribute("shots", new ArrayList<ShotResult>());
            }
            ArrayList<ShotResult> shotResults = (ArrayList<ShotResult>) session.getAttribute("shots");

            if (checkArea(requestParams.get("x"), requestParams.get("y"), requestParams.get("r"))){
                shotResults.add(new ShotResult(requestParams.get("x"), requestParams.get("y"), requestParams.get("r"), true));
            } else {
                shotResults.add(new ShotResult(requestParams.get("x"), requestParams.get("y"), requestParams.get("r"), true));
            }

            req.getRequestDispatcher("/templates/shot_result.jsp").forward(req, resp);


        } catch (IncorrectRequestException e) {
            throw new RuntimeException(e);
        } catch (ValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkArea(double x, double y, double r){
        return ((y >= (-x-r))&&(x<=0)&&(y<=0))||((Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r, 2)/4)&&(x>=0)&&(y<=0)) || ((x>=0)&&(x<=r)&&(y>=0)&&(y<=r/2));
    }
}
