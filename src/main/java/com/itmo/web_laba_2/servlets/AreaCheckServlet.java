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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (req.getParameter("areaClick") != null && req.getParameter("areaClick").equals("true")) {
                List<ShotResult> shotResults = fillSessionData(req, true);
                sendJSONResponse(shotResults, resp);
            } else {
                List<ShotResult> shotResults = fillSessionData(req, false);
                HttpSession session = req.getSession();
                session.setAttribute("queriesCount", shotResults.size());
                req.getRequestDispatcher("/templates/shot_result.jsp").forward(req, resp);
            }
        } catch (ValidationException | IncorrectRequestException e) {
            HttpSession session = req.getSession();
            session.setAttribute("current_error", e.getMessage());
            req.getRequestDispatcher("/templates/error.jsp").forward(req, resp);
        } catch (JSONException e) {
            HttpSession session = req.getSession();
            session.setAttribute("current_error", "Ошибка сервера. Попробуйте снова.");
        }
    }

    public boolean checkArea(double x, double y, double r) {
        return ((y >= (-x - r)) && (x <= 0) && (y <= 0)) || ((Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r, 2) / 4) && (x >= 0) && (y <= 0)) || ((x >= 0) && (x <= r) && (y >= 0) && (y <= r / 2));
    }

    public void sendJSONResponse(List<ShotResult> shotResults, HttpServletResponse resp) throws IOException, JSONException {
        PrintWriter out = resp.getWriter();
        JSONArray jsonArray = new JSONArray();
        for (ShotResult shotResult : shotResults){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("x", shotResult.getGraphShot().getX());
            jsonObject.put("y", shotResult.getGraphShot().getY());
            jsonObject.put("r", shotResult.getGraphShot().getR());
            jsonObject.put("result", shotResult.isInArea());
            jsonArray.put(jsonObject);
        }

        out.println(jsonArray);
    }

    public List<ShotResult> fillSessionData(HttpServletRequest req, boolean areaClick) throws ValidationException, IncorrectRequestException {
        List<HashMap<String, Double>> requestList = QueryStringParser.parseQuery(req, areaClick);
        HttpSession session = req.getSession();
        if (session.getAttribute("shots") == null) {
            session.setAttribute("shots", new ArrayList<ShotResult>());
        }
        List<ShotResult> filledShots = new ArrayList<>();
        for (HashMap<String, Double> requestParams : requestList){
            ArrayList<ShotResult> shotResults = (ArrayList<ShotResult>) session.getAttribute("shots");
            ShotResult shotResult = new ShotResult(requestParams.get("x"), requestParams.get("y"), requestParams.get("r"), checkArea(requestParams.get("x"), requestParams.get("y"), requestParams.get("r")));
            shotResults.add(shotResult);
            filledShots.add(shotResult);
        }

        return filledShots;
    }
}
