<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Upload</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <title>Работа мечты</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    String name = request.getParameter("name");
%>
<div class="container pt-3">
    <h3>Вы уверены, что хотите удалить <%=name%>?</h3>
    <form action="<%=request.getContextPath()%>/deleteCandidate?id=<%=id%>" method="post">
        <button type="submit" class="btn btn-default">Подтверждаю удаление</button>
    </form>
</div>
</body>
</html>
