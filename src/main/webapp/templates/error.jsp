<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ошибка</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/styles/style.css">
</head>
<body>
    <div id="gridContainer">
        <%@include file="includes/_header.jsp"%>
        <div id="message_window">
            <p>${sessionScope.current_error}</p>
        </div>
        <%@include file="includes/_footer.jsp" %>
    </div>
</body>
</html>
