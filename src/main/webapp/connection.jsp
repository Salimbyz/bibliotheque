<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Page de connexion</title>
</head>
<body>
    <h1>Connexion</h1>
    <form action="login" method="post">
        <label for="username">Nom d'utilisateur:</label>
        <input type="text" id="username" name="username" required><br><br>
        
        <label for="password">Mot de passe:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <button type="submit">Se connecter</button>
    </form>
    
    <%-- Afficher le message d'erreur s'il y en a un --%>
    <c:if test="${not empty error}">
        <p style="color: red">${error}</p>
    </c:if>
</body>
</html>
