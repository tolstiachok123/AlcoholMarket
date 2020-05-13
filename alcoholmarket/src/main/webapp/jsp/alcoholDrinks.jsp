<%@ page import="com.am.entity.AlcoholDrink" %>
<%@ page import="com.am.repository.AlcoholDrinkRepository" %>
<%@ page import="com.am.service.AlcoholDrinkService" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: SERJEY
  Date: 16.04.2020
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <h2>Congratulations!!!</h2>
    <%! AlcoholDrinkService alcoholDrinkService = new AlcoholDrinkService(new AlcoholDrinkRepository()); %>
</head>
<body>
    <%
        ArrayList<AlcoholDrink> alcoholDrinks = alcoholDrinkService.getList();
        AlcoholDrink alcoholDrink = new AlcoholDrink();
        for (int i = 0; i < alcoholDrinks.size(); i++) {
            out.println(alcoholDrinks.get(i));
        }
    %>
</body>
</html>
