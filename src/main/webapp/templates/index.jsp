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
    <div id="main-table">
        <div class="gui-element" id="input-block">
            <form id="form" method="GET" action="${pageContext.request.contextPath}/main">
                <label id="x-label">Выберите X-координату</label>
                <div>
                    <div>
                        <div class="form_radio_btn">
                            <input type="checkbox" value="-2" class="r-choose_input checkbox_x" name="x"
                                   id="checkbox-1">
                            <label for="checkbox-1">-2</label>
                        </div>

                        <div class="form_radio_btn">
                            <input type="checkbox" value="-1.5" class="r-choose_input checkbox_x" name="x"
                                   id="checkbox-2">
                            <label for="checkbox-2">-1.5</label>
                        </div>

                        <div class="form_radio_btn">
                            <input type="checkbox" value="-1" class="r-choose_input checkbox_x" name="x"
                                   id="checkbox-3">
                            <label for="checkbox-3">-1</label>
                        </div>

                        <div class="form_radio_btn">
                            <input type="checkbox" value="-0.5" class="r-choose_input checkbox_x" name="x"
                                   id="checkbox-4">
                            <label for="checkbox-4">-0.5</label>
                        </div>

                        <div class="form_radio_btn">
                            <input type="checkbox" value="0" class="r-choose_input checkbox_x" name="x"
                                   id="checkbox-5">
                            <label for="checkbox-5">0</label>
                        </div>

                        <div class="form_radio_btn">
                            <input type="checkbox" value="0.5" class="r-choose_input checkbox_x" name="x"
                                   id="checkbox-6">
                            <label for="checkbox-6">0.5</label>
                        </div>

                        <div class="form_radio_btn">
                            <input type="checkbox" value="1" class="r-choose_input checkbox_x" name="x"
                                   id="checkbox-7">
                            <label for="checkbox-7">1</label>
                        </div>

                        <div class="form_radio_btn">
                            <input type="checkbox" value="1.5" class="r-choose_input checkbox_x" name="x"
                                   id="checkbox-8">
                            <label for="checkbox-8">1.5</label>
                        </div>

                        <div class="form_radio_btn">
                            <input type="checkbox" value="2" class="r-choose_input checkbox_x" name="x"
                                   id="checkbox-9">
                            <label for="checkbox-9">2</label>
                        </div>
                    </div>
                </div>
                <label id="y-label" for="y-inp">Выберите Y-координату</label>
                <div>

                    <input type="text" placeholder="Введите Y в (-5...3)" class="y-choose_input" id="y-inp"
                           oninput="validateYInput()" name="y">
                </div>
                <label id="r-label">Выберите R</label>
                <div>
                    <input type="text" placeholder="Введите R в (1...4)" class="y-choose_input" id="r-inp"
                           oninput="validateRInput()" name="r">
                </div>

                <input type="submit" id="submitButton" value="Отправить">
                <p class="error_text" id="Incorrect">Некорректные значения в полях формы.</p>
                <p class="error_text" id="rNotSelectedError">r не выбран, невозвожно определить координаты</p>
            </form>
        </div>

        <div class="gui-element" id="visualization-block">
            <div id="frame">
                <canvas id="figureCanvas" width="100" height="100"></canvas>
            </div>
        </div>
    </div>
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
                    <c:forEach var="shot" items="${sessionScope.shots}">
                        <tr>
                            <td>${shot.getGraphShot().getX()}</td>
                            <td>${shot.getGraphShot().getY()}</td>
                            <td>${shot.getGraphShot().getR()}</td>
                            <td>
                                <c:if test="${shot.isInArea()}">
                                    Попадание
                                </c:if>

                                <c:if test="${!shot.isInArea()}">
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
    <%@include file="includes/_footer.jsp" %>
</div>
<script src="${pageContext.request.contextPath}/static/scripts/drawFigure.js"></script>
<script src="${pageContext.request.contextPath}/static/scripts/validation.js"></script>
<script src="${pageContext.request.contextPath}/static/scripts/index.js"></script>
<script src="${pageContext.request.contextPath}/static/scripts/areaClickHandler.js"></script>
</body>
</html>
