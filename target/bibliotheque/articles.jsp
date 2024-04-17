<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Articles</title>
</head>
<body>
    <h1>Liste des Articles</h1>
    <table border="1">
        <tr>
            <th>Nom</th>
            <th>Prix</th>
            <th>Restant</th>
            <th></th>
            <th>Enelever 1 au panier</th>
            <th>Actuellement dans votre panier</th>
            <th>Ajouter 1 au panier</th>
        </tr>
        <c:forEach var="article" items="${ARTICLE_LIST}">
            <tr>
                <td>${article.name}</td>
                <td>${article.price}</td>
                <td>${article.nbRestant}</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
