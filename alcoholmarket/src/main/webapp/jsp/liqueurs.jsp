<%@ page import="com.am.entity.Liqueur" %>
<%@ page import="com.am.repository.LiqueurRepository" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: SERJEY
  Date: 16.04.2020
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%! LiqueurService liqueurService = new LiqueurService(new LiqueurRepository()); %>
</head>
<body>
    <%
        ArrayList<Liqueur> liqueurs = liqueurService.getLiqueurs();
        Liqueur liqueur = new Liqueur();
        for (int i = 0; i < liqueurs.size(); i++) {
            out.println(liqueurs.get(i));
        }
    %>
</body>
</html>
