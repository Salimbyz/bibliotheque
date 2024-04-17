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
                <td>${result.studentBean.id}</td>
                <td>${result.noteBean.note}</td>
                <td>${result.studentBean.firstName} ${result.studentBean.lastName}</td>
            </tr>
        </c:forEach>
    </table>
    <c:if test="${not empty RESULTS_MEAN}">
        <p>Moyenne: ${RESULTS_MEAN}</p>
    </c:if>
</body>
</html>
