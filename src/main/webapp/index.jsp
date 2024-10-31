<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="static/styles/style.css">
    <script
            src="https://code.jquery.com/jquery-3.7.1.js"
            integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
            crossorigin="anonymous"></script>
    <title>Точечный выстрел</title>
</head>
<body>
<div id="gridContainer">
    <div id="header">
        <div id="header-bio">
            Пожарский Семён, Р3130<br>Вариант: 409359
        </div>
        <div id="header-title">ЛАБА и ТОЧКА: "."</div>
    </div>
    <div id="main-table">
        <div class="gui-element" id="input-block">
            <form id="form" method="GET" action="${pageContext.request.contextPath}/controller">
                <label id="x-label">Выберите X-координату</label>
                <div>
                    <div>
                        <div class="form_radio_btn">
                            <input type="checkbox" value="-2" class="r-choose_input checkbox_x" name="x-choose"
                                   id="checkbox-1">
                            <label for="checkbox-1">-2</label>
                        </div>

                        <div class="form_radio_btn">
                            <input type="checkbox" value="-1.5" class="r-choose_input checkbox_x" name="x-choose"
                                   id="checkbox-2">
                            <label for="checkbox-2">-1.5</label>
                        </div>

                        <div class="form_radio_btn">
                            <input type="checkbox" value="-1" class="r-choose_input checkbox_x" name="x-choose"
                                   id="checkbox-9">
                            <label for="checkbox-9">-1</label>
                        </div>

                        <div class="form_radio_btn">
                            <input type="checkbox" value="-0.5" class="r-choose_input checkbox_x" name="x-choose"
                                   id="checkbox-3">
                            <label for="checkbox-3">-0.5</label>
                        </div>

                        <div class="form_radio_btn">
                            <input type="checkbox" value="0" class="r-choose_input checkbox_x" name="x-choose"
                                   id="checkbox-4">
                            <label for="checkbox-4">0</label>
                        </div>

                        <div class="form_radio_btn">
                            <input type="checkbox" value="1" class="r-choose_input checkbox_x" name="x-choose"
                                   id="checkbox-5">
                            <label for="checkbox-5">1</label>
                        </div>

                        <div class="form_radio_btn">
                            <input type="checkbox" value="1.5" class="r-choose_input checkbox_x" name="x-choose"
                                   id="checkbox-6">
                            <label for="checkbox-6">1.5</label>
                        </div>

                        <div class="form_radio_btn">
                            <input type="checkbox" value="2" class="r-choose_input checkbox_x" name="x-choose"
                                   id="checkbox-7">
                            <label for="checkbox-7">2</label>
                        </div>
                    </div>
                </div>
                <label id="y-label" for="y-inp">Выберите Y-координату</label>
                <div>

                    <input type="text" placeholder="Введите Y в (-5...3)" class="y-choose_input" id="y-inp"
                           oninput="validateYInput()">
                </div>
                <label id="r-label">Выберите R</label>
                <div>
                    <input type="text" placeholder="Введите R в (1...4)" class="y-choose_input" id="r-inp"
                           oninput="validateYInput()">
                </div>

                <input type="submit" id="submitButton" value="Отправить">
                <p class="error_text">Некорректные значения в полях формы.</p>
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
                        <th>Время запроса</th>
                        <th>Время работы</th>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div id="footer-table">
        <div>
            <p>Работа выполнена полностью самостоятельно, все права защищены. Убедительная просьба не душить на
                защите.</p>
        </div>
        <div><img src="static/images/itmo.png" alt=""/></div>
    </div>
</div>
<script src="static/scripts/drawFigure.js"></script>
<script src="static/scripts/validation.js"></script>
<script src="static/scripts/ajax.js"></script>
</body>
</html>
