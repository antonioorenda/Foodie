<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>Home</h1>
    <br/>

    <c:forEach items="${allRecipes}" var="recipe" begin="0" end="7">
        <br />
        <h5>${recipe.title}</h5>
        <p>${recipe.description}</p>
    </c:forEach>
</body>
</html>
