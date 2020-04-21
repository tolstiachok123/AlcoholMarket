<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <body>
        <form method="post" action="controler">
            <h2>Вам есть 18 лет?</h2>
            <input name="page" type="hidden" value="alcoholDrinks.jsp">
            <input type="submit" value="Да">
        </form>
    </body>
</html>
