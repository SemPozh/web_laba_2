<%@ page import="java.util.ArrayList" %>
<%@ page import="com.itmo.web_laba_2.model.ShotResult" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/styles/style.css">
    <title>Точечный выстрел</title>
</head>
<body>
    <div id="gridContainer">
        <%@include file="includes/_header.jsp"%>
        <div id="data-table">
            <div class="gui-element" id="data-block">
                <div>
                    <table id="results">
                        <thead>
                            <tr>
                                <th>X</th>
                                <th>Y</th>
                                <th>R</th>
                                <th>Попадание</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach begin="1" end="${sessionScope.queriesCount}" var="i">
                        <tr>
                            <td>${sessionScope.shots.get(sessionScope.shots.size()-i).getGraphShot().getX()}</td>
                            <td>${sessionScope.shots.get(sessionScope.shots.size()-i).getGraphShot().getY()}</td>
                            <td>${sessionScope.shots.get(sessionScope.shots.size()-i).getGraphShot().getR()}</td>
                            <td>
                                <c:if test="${sessionScope.shost.get(sessionScope.shots.size()-i).isInArea()}">
                                    Попадание
                                </c:if>

                                <c:if test="${!sessionScope.shost.get(sessionScope.shots.size()-i).isInArea()}">
                                    Промах
                                </c:if>
                            </td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div id="backLinkWrapper">
            <a href="${pageContext.request.contextPath}/main" class="back_button">Обратно</a>
        </div>
        <%@include file="includes/_footer.jsp"%>
    </div>
</body>
</html>
