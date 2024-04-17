<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>

        <head>
            <title>Articles</title>
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        </head>

        <body>
            <h1>Liste des Articles</h1>
            <table border="1">
                <tr>
                    <th>Nom</th>
                    <th>Prix</th>
                    <th>Restant</th>
                    <th></th>
                    <th>Enlever 1 au panier</th>
                    <th>Actuellement dans votre panier</th>
                    <th>Ajouter 1 au panier</th>
                </tr>
                <c:forEach var="article" items="${ARTICLE_LIST}">
                    <tr>
                        <td>${article.name}</td>
                        <td>${article.price}</td>
                        <td>${article.nbRestant}</td>
                        <td></td>
                        <td><a id="remove-${article.id}" href="#" class="remove-from-cart">-</a></td>
                        <td></td>
                        <td><a id="add-${article.id}" href="#" class="add-to-cart">+</a></td>
                    </tr>
                </c:forEach>
            </table>
            <script>
                $(document).ready(function () {
                    $(".add-to-cart").click(function (event) {
                        event.preventDefault();
                        var articleId = $(this).attr('id').split('-')[1];
                        $.get('cart', { action: 'add', id: articleId }, function (data) {
                        });
                    });

                    $(".remove-from-cart").click(function (event) {
                        event.preventDefault();
                        var articleId = $(this).attr('id').split('-')[1];
                        $.get('cart', { action: 'remove', id: articleId }, function (data) {

                        });
                    });
                });
            </script>
            <form action="display-cart" method="get">
                <input type="hidden" name="action" value="displayCart">
                <input type="submit" value="Afficher le panier">
            </form>
        </body>

        </html>