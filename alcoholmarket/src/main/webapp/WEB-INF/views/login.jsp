<%--
  Created by IntelliJ IDEA.
  User: SERJEY
  Date: 24.05.2020
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Login page</title>
    <meta charset="UTF-8">
    <style>
        <%@ include file="../../css/main.css"%>
        <%@ include file="../../css/util.css"%>
    </style>
</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div><p>
            <c:if test="${error}">
                <c:out value="LOGIN FAILED" />
            </c:if>
        </p></div>
        <div class="wrap-login100 p-t-50 p-b-90">


            <form class="login100-form validate-form flex-sb flex-w" action="/perform_login" method="post">
					<span class="login100-form-title p-b-51">
						Login
					</span>


                <div class="wrap-input100 validate-input m-b-16" data-validate = "Username is required">
                    <input class="input100" type="text" name="username" placeholder="Username">
                    <span class="focus-input100"></span>
                </div>


                <div class="wrap-input100 validate-input m-b-16" data-validate = "Password is required">
                    <input class="input100" type="password" name="password" placeholder="Password">
                    <span class="focus-input100"></span>
                </div>

                <div class="container-login100-form-btn m-t-17">
                    <button class="login100-form-btn" type="submit">
                        Login
                    </button>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>


        </div>
    </div>
</div>

</body>
</html>