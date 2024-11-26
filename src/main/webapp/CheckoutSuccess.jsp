<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Checkout Successful</title>
</head>
<body>
    <h1>Thank you for your order!</h1>
    <p><%= request.getAttribute("message") %></p>
    <a href="Home.jsp">Return to Menu</a>
</body>
</html>
