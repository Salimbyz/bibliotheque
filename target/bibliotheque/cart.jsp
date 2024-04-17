<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Panier</title>
</head>
<body>
    <h1>Votre Panier</h1>
    <table border="1">
        <tr>
            <th>Nom</th>
            <th>Prix</th>
            <th>Quantité</th>
        </tr>
        <c:forEach var="item" items="${cartItems}">
            <tr>
                <td>${item.article.name}</td>
                <td>${item.article.price}</td>
                <td>${item.quantity}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
