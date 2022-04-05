<%--
  Created by IntelliJ IDEA.
  User: william
  Date: 04/04/2022
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>error screen</title>
</head>
<body>
    <h1>error message</h1>
    <h2>contact the system team</h2>
    <%
        out.print(request.getAttribute("msg"));
    %>
</body>
</html>
