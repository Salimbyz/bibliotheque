<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Panier</title>
</head>
<body>
    <h1>Panier</h1>
    <table border="1">
        <tr>
            <th>Nom de l'article</th>
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
