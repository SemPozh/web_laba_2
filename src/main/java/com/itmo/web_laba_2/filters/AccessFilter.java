package com.itmo.web_laba_2.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AccessFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getRequestURI().equals(request.getContextPath()+"/check") || request.getRequestURI().equals(request.getContextPath()+"/templates/index.jsp")){
            if (request.getParameter("fromController")!=null){
                filterChain.doFilter(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
