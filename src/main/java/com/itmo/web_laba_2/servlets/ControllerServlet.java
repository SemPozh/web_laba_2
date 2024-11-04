package com.itmo.web_laba_2.servlets;

import com.itmo.web_laba_2.exceptions.IncorrectRequestException;
import com.itmo.web_laba_2.exceptions.ValidationException;
import com.itmo.web_laba_2.utils.parsers.QueryStringParser;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("fromController", "true");
        if (req.getParameterMap().isEmpty()){
            RequestDispatcher dispatcher = req.getRequestDispatcher("/templates/index.jsp");
            dispatcher.forward(req, resp);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/check");
            dispatcher.forward(req, resp);
        }
    }
}
